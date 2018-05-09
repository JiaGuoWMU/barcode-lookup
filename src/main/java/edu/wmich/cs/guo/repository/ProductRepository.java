package edu.wmich.cs.guo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import edu.wmich.cs.guo.model.Product;

public interface ProductRepository extends CrudRepository<Product, Serializable> {

	public Product findByNameAndBarcode(String name, String barcode);

	public Product findByBarcode(String barcode);

	public Product getProductByPid(Integer id);

	public Product findByPid(Integer id);

	@Query(value = "SELECT * FROM products p WHERE p.name = :name", nativeQuery = true)
	public Product findByName(@Param("name") String name);

	@Query(value = "DELETE FROM products p WHERE p.pid = :pid", nativeQuery = true)
	public boolean deleteProductByPid(@Param("pid") Integer id);

}
