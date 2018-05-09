package edu.wmich.cs.guo.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the stores database table.
 * 
 */
@Entity
@Table(name="stores")
@NamedQuery(name="Store.findAll", query="SELECT s FROM Store s")
public class Store implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sid;

	private String location;

	private String name;

	//bi-directional many-to-one association to StoreProductRelation
	@OneToMany(mappedBy="store")
	private List<StoreProductRelation> storeProductRelations;

	public Store() {
	}

	public int getSid() {
		return this.sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<StoreProductRelation> getStoreProductRelations() {
		return this.storeProductRelations;
	}

	public void setStoreProductRelations(List<StoreProductRelation> storeProductRelations) {
		this.storeProductRelations = storeProductRelations;
	}

	public StoreProductRelation addStoreProductRelation(StoreProductRelation storeProductRelation) {
		getStoreProductRelations().add(storeProductRelation);
		storeProductRelation.setStore(this);

		return storeProductRelation;
	}

	public StoreProductRelation removeStoreProductRelation(StoreProductRelation storeProductRelation) {
		getStoreProductRelations().remove(storeProductRelation);
		storeProductRelation.setStore(null);

		return storeProductRelation;
	}

}