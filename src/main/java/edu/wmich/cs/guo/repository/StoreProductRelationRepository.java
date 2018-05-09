package edu.wmich.cs.guo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import edu.wmich.cs.guo.model.StoreProductRelation;

public interface StoreProductRelationRepository extends CrudRepository<StoreProductRelation, Serializable> {
	
	@Query(value = "SELECT * FROM store_product_relation spr WHERE spr.pid = :pid", nativeQuery = true )
	public StoreProductRelation findLowestByPid(@Param("pid") Integer pid);
	
}
