package com.example.demo.dao;

import com.example.demo.model.Language;

import org.springframework.data.repository.CrudRepository;

public interface LanguageDao extends CrudRepository<Language, Integer>{

}