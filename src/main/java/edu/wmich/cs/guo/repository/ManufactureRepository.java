package edu.wmich.cs.guo.repository;

import java.io.Serializable;
import org.springframework.data.repository.PagingAndSortingRepository;

import edu.wmich.cs.guo.model.Manufacture;

public interface ManufactureRepository extends PagingAndSortingRepository<Manufacture, Serializable> {

	public Manufacture findByName(String name);
}
