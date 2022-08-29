package com.acon.dokseo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/ticket")
@Controller
public class TicketController {
	@GetMapping("/ticketConfig")
	
	public void ticketConfig() {}
	
	@GetMapping("/list")
	
	public void list() {}
	
	@GetMapping ("/insert")
	public void insert() {}
	
	@GetMapping ("/detail")
	public void detail() {}
}
