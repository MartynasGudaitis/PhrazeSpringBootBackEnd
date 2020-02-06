package com.example.demo.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.LanguageRepository;
import com.example.demo.models.Language;


@Service
public class LanguageService {

	@Autowired
	private LanguageRepository languageRepository;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	public List<Language> getAllLanguages(){
		List<Language> languages = new ArrayList<>();
		languageRepository.findAll().forEach(languages::add);
		return languages;
	}
	
	public Optional<Language> getLanguage(int id) {
		return languageRepository.findById(id);
	}
	
	public Language addLanguage(Language language) {
		language.setDateCreated(dateFormat.format(Calendar.getInstance().getTime()));
		return languageRepository.save(language);
	}
	
	public Language updateLanguage(int id, Language language) {
		language.setDateModified(dateFormat.format(Calendar.getInstance().getTime()));
		language.setId(id);
		return languageRepository.save(language);
	}
	
	public void deleteLanguage(int id) {
		languageRepository.deleteById(id);
	}
}
