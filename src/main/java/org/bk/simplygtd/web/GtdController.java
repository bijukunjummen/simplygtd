package org.bk.simplygtd.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/gtd")
public class GtdController {
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
}
