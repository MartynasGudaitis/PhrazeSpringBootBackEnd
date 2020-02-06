/*
package com.example.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.LanguageDao;
import com.example.demo.models.Language;

@RestController
@RequestMapping("/api/v1/language")
public class LanguageController {
	@Autowired
	private LanguageDao dao;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	@PostMapping("/")
	public void addLanguage(@RequestBody final Language language) {
		language.setDateCreated(dateFormat.format(Calendar.getInstance().getTime()));
		dao.save(language);
	}
	
	@GetMapping("/")
	public List<Language> getLanguages(){
		return (List<Language>) dao.findAll();
	}
}
*/

package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Language;
import com.example.demo.services.LanguageService;

@RestController
@RequestMapping("/api/v1/language")
public class LanguageController{
	
	@Autowired
	private LanguageService languageService;
	
	@GetMapping("/")
	public List<Language> getAllLanguages(){
		return languageService.getAllLanguages();
	}
	
	@GetMapping("/{id}")
	public Optional<Language> getLanguage(@PathVariable int id){
		return languageService.getLanguage(id);
	}
	
	@PostMapping("/")
	public Language addLanguage(@RequestBody Language language) {
		return languageService.addLanguage(language);
	}
	
	@PutMapping("/{id}")
	public Language updateLanguage(@PathVariable int id, @RequestBody Language language) {
		return languageService.updateLanguage(id, language);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLanguage(@PathVariable int id) {
	}
}
