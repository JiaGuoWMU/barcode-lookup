package edu.wmich.cs.guo.repository;

import java.io.Serializable;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.wmich.cs.guo.model.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Serializable> {
	
	public Category findByName(String name);
}
