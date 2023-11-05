package com.project.examples.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.examples.model.Cats;
import com.project.examples.service.CatsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cats")
@Api(value = "Cats Info", description = "The Cats Shop")
public class CatsController {

	@Autowired
	private CatsService catsService;

	@PostMapping("/saveCats")
	@ApiOperation(value = "Api to save cats info")
	public Cats saveCats(@RequestBody Cats cats) {
		return catsService.saveCats(cats);
	}

	@ApiOperation(value = "Api to get cat info by cat Id")
	@GetMapping("/getCatById/{catId}")
	public Cats getCatById(@PathVariable int catId) {
		return catsService.getCatById(catId);
	}
	
	@ApiOperation(value = "Api to get all cats info")
	@GetMapping("/getAllCats")
	public List<Cats> getAllCats() {
		return catsService.getAllCats();
	}

	@DeleteMapping("/removeCat/{catId}")
	@ApiOperation(value = "Api to remove cat info by cat Id")
	public List<Cats> removeCat(@PathVariable int catId) {
		return catsService.removeCat(catId);

	}

}
