package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.LanguageDao;
import com.example.demo.model.Language;

@RestController
@RequestMapping("/api/v1/language")
public class LanguageController {
	@Autowired
	private LanguageDao dao;
	
	@PostMapping("/")
	public String createLanguage(@RequestBody final Language languages) {
		dao.save(languages);
		return "1 language inserted.";
	}
	
	@GetMapping("/")
	public List<Language> getLanguages(){
		return (List<Language>) dao.findAll();
	}
}
