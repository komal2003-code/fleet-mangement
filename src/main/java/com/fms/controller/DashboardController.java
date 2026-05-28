package com.fms.controller;

import com.fms.dto.CoordinateRequest;
import com.fms.dto.DriverDto;
import com.fms.dto.RouteResponse;
import com.fms.entity.DeliveryTask;
import com.fms.entity.Route;
import com.fms.entity.Vehicle;
import com.fms.service.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class DashboardController {

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private RouteService routeService;

    @Autowired
    private DeliveryTaskService taskService;

    @Autowired
    private RouteOptimizationService routeOptimizationService;

    // ❌ DON'T AUTOWIRE ObjectMapper

    //private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    private ObjectMapper objectMapper;
    
    
    // DASHBOARD
    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }

    // VEHICLE
    @GetMapping("/vehicle")
    public String vehiclePage(Model model) {
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        return "vehicle";
    }

    @PostMapping("/vehicle/save")
    public String saveVehicle(@ModelAttribute Vehicle vehicle,
                              RedirectAttributes redirectAttributes) {

        vehicleService.saveVehicle(vehicle);
        redirectAttributes.addFlashAttribute("success", "Vehicle Registered Successfully!");
        return "redirect:/vehicle";
    }

    // DRIVER
    @GetMapping("/driver")
    public String driverPage(Model model) {
        model.addAttribute("drivers", driverService.getAllDrivers());
        return "driver";
    }

    @PostMapping("/driver/save")
    public String saveDriver(@ModelAttribute DriverDto dto,
                              RedirectAttributes redirectAttributes) {

        driverService.saveDriver(dto);
        redirectAttributes.addFlashAttribute("success", "Driver Registered Successfully!");
        return "redirect:/driver";
    }

    // ROUTE
    @GetMapping("/route")
    public String routePage(Model model) {
        model.addAttribute("routes", routeService.getAllRoutes());
        model.addAttribute("route", new Route());
        return "route";
    }

    @PostMapping("/route/save")
    public String saveRoute(@ModelAttribute Route route,
                            RedirectAttributes redirectAttributes) {

        routeService.saveRoute(route);
        redirectAttributes.addFlashAttribute("success", "Route saved successfully!");
        return "redirect:/route";
    }

    // TASK
    @GetMapping("/task")
    public String taskPage(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        model.addAttribute("task", new DeliveryTask());
        return "task";
    }

    @PostMapping("/task/save")
    public String saveTask(@ModelAttribute DeliveryTask task,
                           RedirectAttributes redirectAttributes) {

        taskService.saveTask(task);
        redirectAttributes.addFlashAttribute("success", "Task Created Successfully!");
        return "redirect:/task";
    }

    // OPTIMIZE
    @GetMapping("/optimize")
    public String optimizePage(Model model) {
        model.addAttribute("result", null);
        return "optimize";
    }
    @PostMapping("/optimize")
    public String optimizeRoute(@RequestParam(value = "json", required = false) String json,
                                Model model) {
        try {
            if (json == null || json.trim().isEmpty()) {
                model.addAttribute("error", "Please enter JSON input!");
                return "optimize";
            }
            System.out.println("JSON = " + json);
            CoordinateRequest request =
                    objectMapper.readValue(
                            "{\"stops\":" + json + "}",
                            CoordinateRequest.class);

            RouteResponse result =
                    routeOptimizationService.getRoute(request);

            model.addAttribute("result", result);

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", e.getMessage());
        }

        return "optimize";
    }
    @GetMapping("/dispatch")
    public String dispatchPage(Model model) {

        model.addAttribute(
                "tasks",
                taskService.getAllTasks());

        model.addAttribute(
                "drivers",
                driverService.getAllDrivers());

        model.addAttribute(
                "vehicles",
                vehicleService.getAllVehicles());

        model.addAttribute(
                "routes",
                routeService.getAllRoutes());

        return "dispatch";
    }
    @PostMapping("/dispatch/{id}")
    public String dispatch(@PathVariable Long id, RedirectAttributes ra) {
        try {
            taskservice.dispatchTask(id);
            ra.addFlashAttribute("success", "Task Dispatched Successfully");
        } catch (Exception e) {
            ra.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/tasks";
    }
    }