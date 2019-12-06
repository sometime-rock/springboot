package com.yan.springmvc.controller;

import com.yan.springmvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller // 1
@RequestMapping("/anno") //2
public class DemoAnnoController {

	//eg.http://localhost:8080/springmvc/anno
	@RequestMapping(produces = "text/plain;charset=UTF-8")	// 3
	@ResponseBody //写在这里跟写在下面是一样的
	public String index(HttpServletRequest request) { // 4
		return "url:" + request.getRequestURL() + " can access";
	}

	//eg http://localhost:8080/springmvc/anno/pathvar/aaa
	@RequestMapping(value = "/pathvar/{str}", produces = "text/plain;charset=UTF-8")// 5
	public @ResponseBody String demoPathVar(@PathVariable String str, //3
			HttpServletRequest request) {
		return "url:" + request.getRequestURL() + " can access,str: " + str;
	}

	//http://localhost:8080/springmvc/anno/requestParam?id=101
	@RequestMapping(value = "/requestParam", produces = "text/plain;charset=UTF-8") //6
	public @ResponseBody String passRequestParam(Long id,
			HttpServletRequest request) {
		
		return "url:" + request.getRequestURL() + " can access,id: " + id;

	}

	//http://localhost:8080/springmvc/anno/obj?id=101&name=22
	@RequestMapping(value = "/obj", produces = "application/json;charset=UTF-8")//7
	@ResponseBody //8
	public String passObj(DemoObj obj, HttpServletRequest request) {

		 return "url:" + request.getRequestURL()
		 			+ " can access, obj id: " + obj.getId()+" obj name:" + obj.getName();

	}

	//http://localhost:8080/springmvc/anno/name2
	@RequestMapping(value = { "/name1", "/name2" }, produces = "text/plain;charset=UTF-8")//9
	public @ResponseBody String remove(HttpServletRequest request) {
		
		return "url:" + request.getRequestURL() + " can access";
	}

}
