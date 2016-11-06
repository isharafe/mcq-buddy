package com.idea.mcq.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import com.idea.mcq.model.Mcq;
import com.idea.mcq.service.McqService;
import com.idea.mcq.util.JsonUtils;

@RestController
@RequestMapping(path="/momcq/mcq")
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class McqController {
	McqService service = new McqService();

	@RequestMapping(path="/add", produces="application/json", method=RequestMethod.POST)
	public String add(@RequestParam("data") String data) {
		Mcq c = (Mcq) JsonUtils.convertToObject(data, Mcq.class);
		Mcq saved = service.add(c);
		return JsonUtils.toJson(saved);
	}
	
	@RequestMapping(path="/edit", produces="application/json", method=RequestMethod.POST)
	public String edit(@RequestParam("data") String data) {
		Mcq c = (Mcq) JsonUtils.convertToObject(data, Mcq.class);
		Mcq saved = service.edit(c);
		return JsonUtils.toJson(saved);
	}
	
	@RequestMapping(path="/delete", produces="application/json", method=RequestMethod.POST)
	public String delete(@RequestParam("data") String data) {
		Mcq c = (Mcq) JsonUtils.convertToObject(data, Mcq.class);
		boolean saved = service.delete(c);
		return String.format("{'result': %s}", saved);
	}
	
	@RequestMapping(path="/browse", produces="application/json", method=RequestMethod.POST)
	public String browse(@RequestParam("data") String data) {
		List<Mcq> result = service.browse();
		return JsonUtils.toJson(result);
	}
}
