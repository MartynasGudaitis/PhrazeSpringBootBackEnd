package com.example.demo.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Phrase;
import com.example.demo.repositories.PhraseRepository;

@Service
public class PhraseService {
	
	@Autowired
	private PhraseRepository phraseRepository;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	public List<Phrase> getAllPhrases(){
		List<Phrase> phrases = new ArrayList<>();
		phraseRepository.findAll().forEach(phrases::add);
		return phrases;
	}
	
	public Optional<Phrase> getPhrase(int id){
		return phraseRepository.findById(id);
	}
	
	public Phrase createPhrase(Phrase phrase) {
		phrase.setDateCreated(dateFormat.format(Calendar.getInstance().getTime()));
		return phraseRepository.save(phrase);
	}
	
	public Phrase updatePhrase(int id, Phrase phrase) {
		phrase.setDateModified(dateFormat.format(Calendar.getInstance().getTime()));
		phrase.setId(id);
		return phraseRepository.save(phrase);
	}
	
	public void deletePhrase(int id) {
		phraseRepository.deleteById(id);
	}
}
