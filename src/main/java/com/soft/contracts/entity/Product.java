package com.soft.contracts.entity;

import java.util.ArrayList;

/**
 * Entidad que modela a un Producto
 * 
 * @author Juan Miguel Olguin Salguero
 * @version 1.0
 * @created 16-abr-2020 08:22:19 p.m.
 */
public class Product {

	private String name;
	private Double price;
	private Object parent;
	private ArrayList<Product> products;

	public Product() {
		products = new ArrayList<>();
	}

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
		products = new ArrayList<>();
	}

	public Product(String name, Double price, Object parent) {
		this.name = name;
		this.price = price;
		this.parent = parent;
		products = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public Object getParent() {
		return parent;
	}

	public void setParent(Object parent) {
		this.parent = parent;
	}

}