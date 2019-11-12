package com.kit.controllledwithesp.controll;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.kit.controllledwithesp.device.Status;

@RestController
public class RestControll {
	
	private static Status status = new Status();
	
	@GetMapping(value = {"/api/controll", "/api/device"})
	@ResponseBody
	public ResponseEntity<?> goControll() {
		System.out.println(status.getStatus());
		 
		return ResponseEntity.ok(status);
	}
	
	@PutMapping(value = "/api/controll/{st}")
	@ResponseBody
	public Status controllDevice(@PathVariable("st") long st) {
		status.setStatic(st);
		System.out.println(status.getStatus());
		return status;
	}
	
	
	

}
