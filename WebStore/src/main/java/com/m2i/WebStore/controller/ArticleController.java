package com.m2i.WebStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.m2i.WebStore.entity.Article;
import com.m2i.WebStore.services.ArticleService;

public class ArticleController {

	@Autowired
	ArticleService aService;
	
	@GetMapping("/fake")
	public Article fakeArticle() {
		Article a = new Article();
		aService.create(a);
		return a;
	}
	
	@GetMapping("/{id}")
	public Article getArticleById(@PathVariable("id") int id) {
		return aService.getById(id);
	}
	
	@GetMapping
	public List<Article> getAll(){
		return aService.getAll();
	}
	
	@PostMapping
	public void postArticle(@RequestBody Article a) {
		aService.create(a);
	}
	
	@PutMapping("/{id}")
	public void putArticle(@PathVariable("id") int id,@RequestBody Article a) {
		aService.update(id, a);
	}
	
	@DeleteMapping("/{id}")
	public void deleteArticle(@PathVariable("id") int id) {
		aService.delete(id);
	}
	
}
