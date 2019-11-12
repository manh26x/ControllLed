package com.kit.controllledwithesp.controll;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainControll {

	@RequestMapping(value= {"/", "/controll"}, method=RequestMethod.GET)
	public String goControll() {
		return "index.html";
	}
}
