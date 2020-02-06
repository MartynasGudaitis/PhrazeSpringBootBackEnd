package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Phrase;

public interface PhraseRepository extends CrudRepository<Phrase, Integer> {

}
