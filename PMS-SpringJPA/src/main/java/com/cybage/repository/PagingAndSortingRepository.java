package com.cybage.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import com.cybage.model.Product;

public interface PagingAndSortingRepository<Product, Integer> extends CrudRepository<Product, Integer> {
	  Iterable<Product> findAll(Sort sort);

}

