package com.phone.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.phone.entity.MobileRepairOrder;
import com.phone.service.MobileRepairOrderService;

@RestController
@CrossOrigin
public class MobileRepairOrderController {
	@Autowired
	MobileRepairOrderService orderService;
	
	
	
	
	
	@GetMapping("/hello")
	public String hello()
	{
		return "hello";
	}
	
	
	@GetMapping("/get")
	public List<MobileRepairOrder> get()
	{
		return orderService.getservice();
	}

	@PostMapping("/repairOrder")
	public MobileRepairOrder repairOrder(@RequestBody MobileRepairOrder repairOrder)
	{
		
		return orderService.mobileRepair(repairOrder);
	}
}
