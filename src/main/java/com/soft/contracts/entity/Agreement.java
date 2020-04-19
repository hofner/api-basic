package com.soft.contracts.entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * Entidad que modela a un Agreement
 * 
 * @author Juan Miguel Olguin Salguero
 *
 */
public class Agreement {

	private String signedBy;
	private String name;
	private ArrayList<Product> products;

	public Agreement() {
		// TODO Auto-generated constructor stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		name = "Agreement " + sdf.format(new Date());

		products = new ArrayList<>();
	}

	public Agreement(String name, String signedBy) {
		this.signedBy = signedBy;
		this.name = name;
		products = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public String getSignedBy() {
		return signedBy;
	}

	public void setSignedBy(String signedBy) {
		this.signedBy = signedBy;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		for (Iterator<Product> iterator = products.iterator(); iterator.hasNext();) {
			Product product = iterator.next();
			if (product.getParent() != null && product.getParent().getClass().getName().indexOf("Product") >= 0) {
				return;
			}

		}
		this.products = products;
	}

	public void setName(String name) {
		this.name = name;
	}

}