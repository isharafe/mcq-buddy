package com.idea.mcq.controller;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import com.idea.mcq.model.Subject;
import com.idea.mcq.service.SubjectService;
import com.idea.mcq.util.JsonUtils;

@RestController
@RequestMapping(path="/momcq/subject")
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class SubjectController {
	SubjectService service = new SubjectService();

	@RequestMapping(path="/add", produces="application/json", method=RequestMethod.POST)
	public String add(@RequestParam("data") String data) {
		Subject c = (Subject) JsonUtils.convertToObject(data, Subject.class);
		Subject saved = service.add(c);
		return JsonUtils.toJson(saved);
	}
	
	@RequestMapping(path="/edit", produces="application/json", method=RequestMethod.POST)
	public String edit(@RequestParam("data") String data) {
		Subject c = (Subject) JsonUtils.convertToObject(data, Subject.class);
		Subject saved = service.edit(c);
		return JsonUtils.toJson(saved);
	}
	
	@RequestMapping(path="/delete", produces="application/json", method=RequestMethod.POST)
	public String delete(@RequestParam("data") String data) {
		Subject c = (Subject) JsonUtils.convertToObject(data, Subject.class);
		boolean saved = service.delete(c);
		return String.format("{'result': %s}", saved);
	}
	
	@RequestMapping(path="/browse", produces="application/json", method=RequestMethod.POST)
	public String browse(@RequestParam("data") String data) {
		List<Subject> result = service.browse();
		return JsonUtils.toJson(result);
	}
}
