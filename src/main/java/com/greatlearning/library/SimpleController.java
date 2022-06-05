package com.greatlearning.library;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SimpleController {
	
	@RequestMapping("/")
	public String requestHandler() {
		// process the request , update the Model & return the view.
		return "simple";
	}

}
