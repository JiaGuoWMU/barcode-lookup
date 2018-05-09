package edu.wmich.cs.guo.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int pid;

	private String barcode;

	private String description;

	private String weight;

	@Column(name="image_url")
	private String imageUrl;

	private String name;

	private String specification;

	//bi-directional many-to-one association to Category
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="cid")
	private Category category;

	//bi-directional many-to-one association to Manufacture
	//@JsonIgnore
	@ManyToOne
	@JoinColumn(name="mid")
	private Manufacture manufacture;

	//bi-directional many-to-one association to StoreProductRelation
	@JsonIgnore
	@OneToMany(mappedBy="product")
	private List<StoreProductRelation> storeProductRelations;

	public Product() {
	}

	public int getPid() {
		return this.pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getBarcode() {
		return this.barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecification() {
		return this.specification;
	}

	public void setSpecification(String specification) {
		this.specification = specification;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Manufacture getManufacture() {
		return this.manufacture;
	}

	public void setManufacture(Manufacture manufacture) {
		this.manufacture = manufacture;
	}

	public List<StoreProductRelation> getStoreProductRelations() {
		return this.storeProductRelations;
	}

	public void setStoreProductRelations(List<StoreProductRelation> storeProductRelations) {
		this.storeProductRelations = storeProductRelations;
	}

	public StoreProductRelation addStoreProductRelation(StoreProductRelation storeProductRelation) {
		getStoreProductRelations().add(storeProductRelation);
		storeProductRelation.setProduct(this);

		return storeProductRelation;
	}

	public StoreProductRelation removeStoreProductRelation(StoreProductRelation storeProductRelation) {
		getStoreProductRelations().remove(storeProductRelation);
		storeProductRelation.setProduct(null);

		return storeProductRelation;
	}

}