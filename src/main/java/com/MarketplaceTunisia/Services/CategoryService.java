package com.MarketplaceTunisia.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.MarketplaceTunisia.DAO.CategoryRepository;
import com.MarketplaceTunisia.Entities.Category;

@RestController
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping(value="/category/save",method=RequestMethod.POST)
	public void saveCategory(@RequestBody Category category){
		categoryRepository.save(category);
	}
	
	@RequestMapping(value="/category/delete")
	public void deleteCategory(int idCategory){
		categoryRepository.delete(idCategory);
	}
	
	@RequestMapping(value="/category/update")
	public Category updateCategory(Category category){
		return categoryRepository.saveAndFlush(category);
	}
	/*
	@RequestMapping(value="/category/all", method=RequestMethod.GET)
	public List<Category> allCategories() {
		return categoryRepository.findAll();
	}
	*/
	@RequestMapping("/category/all")
	public Page<Category> allCategories(int page){
	return categoryRepository.findAll(new PageRequest(page, 5));
	}
}
