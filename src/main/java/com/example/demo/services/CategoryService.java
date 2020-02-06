package com.example.demo.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.CategoryRepository;
import com.example.demo.models.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	
	public List<Category> getAllCategories(){
		List<Category> categories = new ArrayList<>();
		categoryRepository.findAll().forEach(categories::add);
		return categories;	
	}
	
	public Optional<Category> getCategory(int id) {
		return categoryRepository.findById(id);
	}
	
	public Category createCategory(Category category) {
		category.setDateCreated(dateFormat.format(Calendar.getInstance().getTime()));
		return categoryRepository.save(category);
	}
	
	public Category updateCategory(int id, Category category) {
		category.setDateModified(dateFormat.format(Calendar.getInstance().getTime()));
		category.setId(id);
		return categoryRepository.save(category);
	}
	
	public void deletecategory(int id) {
		categoryRepository.deleteById(id);
	}
}
