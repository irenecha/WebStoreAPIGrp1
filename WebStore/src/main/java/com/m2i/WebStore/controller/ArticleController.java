package com.m2i.WebStore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.WebStore.entity.Article;
import com.m2i.WebStore.services.ArticleService;

@RestController
@RequestMapping("/article")
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
	public List<Article> getAllArticles(){
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
	
	@GetMapping("/brand")
	public List<Article> getAllArticleSameBrand(@RequestParam("brand") String marque){
		List<Article> articles = aService.getAll();
		List<Article> articlesSameBrand = new ArrayList<>();
		for(int i = 0; i<articles.size(); i++) {
			Article a = articles.get(i);
			String m = a.getBrand();
			if(m.equals(marque)) {
				articlesSameBrand.add(a);
			}
		}
		return (articlesSameBrand);
	}	
	
	@PostMapping("/addliste")
	public void postListArticles(@RequestBody List<Article> articles) {
		for(int i = 0; i<articles.size(); i++) {
			aService.create(articles.get(i));			
		}
		
	}
}
