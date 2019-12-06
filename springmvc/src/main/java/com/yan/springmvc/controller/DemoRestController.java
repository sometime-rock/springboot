package com.yan.springmvc.controller;

import com.yan.springmvc.domain.DemoObj;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //1
@RequestMapping("/rest")
public class DemoRestController {


	//http://localhost:8080/springmvc/rest/getjson?id=101&name=22
	@RequestMapping(value = "/getjson",
			produces={"application/json;charset=UTF-8"}) //2
	public DemoObj getjson (DemoObj obj){
		return new DemoObj(obj.getId()+1, obj.getName()+"yy");//3
	}

	//http://localhost:8080/springmvc/rest/getxml?id=101&name=22
	@RequestMapping(value = "/getxml",
			produces={"application/xml;charset=UTF-8"})//4
	public DemoObj getxml(DemoObj obj){
		return new DemoObj(obj.getId()+1, obj.getName()+"yy");
	}

}
