package edu.wmich.cs.guo.repository;

import java.io.Serializable;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.wmich.cs.guo.model.Store;

public interface StoreRepository extends PagingAndSortingRepository<Store, Serializable> {
	
	public Store findByName(String name);
	
}
