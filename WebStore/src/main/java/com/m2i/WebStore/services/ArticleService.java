package com.m2i.WebStore.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m2i.WebStore.entity.Article;
import com.m2i.WebStore.repository.ArticleRepository;

@Service
public class ArticleService {

	@Autowired
	ArticleRepository repo;
	
	public void create(Article a) {
		repo.save(a);
	}

	public Article getById(int id) {
		return repo.findById(id).orElse(null);
	}

	public List<Article> getAll() {
		return repo.findAll();
	}

	public void update(int id, Article a) {
		Article article = repo.findById(id).orElse(null);
		if (a!= null) {
			article.setBrand(a.getBrand());
			article.setDescription(a.getDescription());
			article.setPrice(a.getPrice());						
			repo.save(article);
		}
	}

	public void delete(int id) {
		Article article = repo.findById(id).orElse(null);
		if (article!= null) {
			repo.delete(article);
		}
		
	}

}
