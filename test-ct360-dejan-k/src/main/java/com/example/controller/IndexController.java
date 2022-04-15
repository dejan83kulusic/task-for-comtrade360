package com.example.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	@GetMapping("/hello-endpoint")
	public String index(@NotNull Model model) {
		model.addAttribute("name", "Hello, World!");
		return "hello";
	}
}
