package com.project.examples.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.examples.model.Cats;

public interface CatsRepository extends JpaRepository<Cats, Integer> {

}
