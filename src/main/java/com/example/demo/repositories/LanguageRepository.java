package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Integer>{

}