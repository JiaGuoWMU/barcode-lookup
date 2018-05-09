package edu.wmich.cs.guo.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the manufactures database table.
 * 
 */
@Entity
@Table(name="manufactures")
@NamedQuery(name="Manufacture.findAll", query="SELECT m FROM Manufacture m")
public class Manufacture implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int mid;

	private String address;

	private String description;

	private String name;

	//bi-directional many-to-one association to Product
	@JsonIgnore
	@OneToMany(mappedBy="manufacture")
	private List<Product> products;

	public Manufacture() {
	}

	public int getMid() {
		return this.mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setManufacture(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setManufacture(null);

		return product;
	}

}