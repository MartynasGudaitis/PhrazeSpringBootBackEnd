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

import com.example.demo.models.Phrase;
import com.example.demo.services.PhraseService;

@RestController
@RequestMapping("/api/v1/phrase")
public class PhraseController {

	@Autowired
	private PhraseService phraseService;
	
	@GetMapping("/")
	public List<Phrase> getAllPhrases(){
		return phraseService.getAllPhrases();
	}
	
	@GetMapping("/{id}")
	public Optional<Phrase> getPhrase(@PathVariable int id){
		return phraseService.getPhrase(id);
	}
	
	@PostMapping("/")
	public Phrase createPhrase(@RequestBody Phrase phrase) {
		return phraseService.createPhrase(phrase);
	}
	
	@PutMapping("/{id}")
	public Phrase updatePhrase(@PathVariable int id, @RequestBody Phrase phrase) {
		return phraseService.updatePhrase(id, phrase);
	}
	
	@DeleteMapping("/{id}")
	public void deletePhrase(@PathVariable int id) {
		phraseService.deletePhrase(id);
	}
}
