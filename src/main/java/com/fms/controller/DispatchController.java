package com.fms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DispatchController {

    @GetMapping("/dispatch")
    public String dispatchPage() {
        return "dispatch";   // dispatch.html
    }
}
