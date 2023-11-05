package com.project.examples.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.examples.dao.CatsRepository;
import com.project.examples.model.Cats;

@Service
public class CatsService {

	@Autowired
	private CatsRepository catsRepository;

	public Cats saveCats(Cats cats) {
		return catsRepository.save(cats);
	}

	public Cats getCatById(int catId) {
		return catsRepository.findById(catId).get();
	}
	
	public List<Cats> getAllCats() {
		return catsRepository.findAll();
	}

	public List<Cats> removeCat(int catId) {
		catsRepository.deleteById(catId);
		return catsRepository.findAll();
	}

}
