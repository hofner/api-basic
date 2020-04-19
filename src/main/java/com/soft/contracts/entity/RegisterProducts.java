package com.soft.contracts.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/**
 * Clase que genera agreements y produtos asociados.
 * 
 * @author Juan Miguel Olguin Salguero
 *
 */
public class RegisterProducts {
	public List<Agreement> generate() {

		TreeMap<String, Agreement> hmAgrees = new TreeMap<>();
		hmAgrees.put("Agreement 15-04-2020", new Agreement("Agreement 15-04-2020", "Stacia Misner Varga"));
		hmAgrees.put("Agreement 16-04-2020", new Agreement("Agreement 16-04-2020", "Kesha Williams"));
		hmAgrees.put("Agreement 17-04-2020", new Agreement("Agreement 17-04-2020", "David Liu"));
		hmAgrees.put("Agreement 18-04-2020", new Agreement("Agreement 18-04-2020", "Ben Piper"));
		hmAgrees.put("Agreement 19-04-2020", new Agreement("Agreement 19-04-2020", "Jared Rhodes"));
		hmAgrees.put("Agreement 20-04-2020", new Agreement("Agreement 20-04-2020", "Milena Pajic"));

		HashMap<String, Product> hmProds = new HashMap<>();
		hmProds.put("Cleaning Operative 514 engine", new Product("Cleaning Operative 514 engine", 501.46));
		hmProds.put("Cleaning Operative 2654 engine", new Product("Cleaning Operative 2654 engine", 157.25));
		hmProds.put("Cleaning Operative 877 engine", new Product("Cleaning Operative 877 engine", 693.7));
		hmProds.put("Hydrochlorothiazide", new Product("Hydrochlorothiazide", 987.45));
		hmProds.put("Losartan", new Product("Losartan", 548.44));
		hmProds.put("Methyldopa", new Product("Methyldopa", 159.46));
		hmProds.put("Metoprolol", new Product("Metoprolol", 357.44));
		hmProds.put("Sodium nitroprusside", new Product("Sodium nitroprusside", 223.12));
		hmProds.put("Surfactant", new Product("Surfactant", 100.12));
		hmProds.put("Production Waste – Standard Bin Bag", new Product("Production Waste – Standard Bin Bag", 101.87));
		hmProds.put("Pallet Disposal engine", new Product("Pallet Disposal engine", 205.88));
		hmProds.put("Bin Hire – 120 Litre Food Waste engine",
				new Product("Bin Hire – 120 Litre Food Waste engine", 637.3));
		hmProds.put("Bin Hire – 331 Litre Glass engine", new Product("Bin Hire – 331 Litre Glass engine", 692.1));
		hmProds.put("Bin Hire – 240 Litre Wheelie engine", new Product("Bin Hire – 240 Litre Wheelie engine", 177.34));
		hmProds.put("Bin Hire – 240 Litre Raw Meat engine",
				new Product("Bin Hire – 240 Litre Raw Meat engine", 267.87));
		hmProds.put("Bin Hire – 1200 Litre Euro engine", new Product("Bin Hire – 1200 Litre Euro engine", 515.85));
		hmProds.put("Bin Hire – 5 Litre Clinical Waste engine",
				new Product("Bin Hire – 5 Litre Clinical Waste engine", 650.84));

		// agregando productos a los agreements que son puros
		hmAgrees.get("Agreement 15-04-2020").getProducts().add(hmProds.get("Cleaning Operative 514 engine"));
		hmAgrees.get("Agreement 15-04-2020").getProducts().add(hmProds.get("Cleaning Operative 2654 engine"));
		// hmProds.get("Cleaning Operative 514
		// engine").setParent(hmAgrees.get("Agreement 15-04-2020"));
		// hmProds.get("Cleaning Operative 2654
		// engine").setParent(hmAgrees.get("Agreement 15-04-2020"));

		hmAgrees.get("Agreement 16-04-2020").getProducts().add(hmProds.get("Cleaning Operative 877 engine"));
		hmAgrees.get("Agreement 16-04-2020").getProducts().add(hmProds.get("Hydrochlorothiazide"));
		// hmProds.get("Cleaning Operative 877
		// engine").setParent(hmAgrees.get("Agreement 16-04-2020"));
		// hmProds.get("Hydrochlorothiazide").setParent(hmAgrees.get("Agreement
		// 16-04-2020"));

		hmAgrees.get("Agreement 17-04-2020").getProducts().add(hmProds.get("Losartan"));
		hmAgrees.get("Agreement 17-04-2020").getProducts().add(hmProds.get("Methyldopa"));
		// hmProds.get("Losartan").setParent(hmAgrees.get("Agreement
		// 17-04-2020"));
		// hmProds.get("Methyldopa").setParent(hmAgrees.get("Agreement
		// 17-04-2020"));

		hmAgrees.get("Agreement 18-04-2020").getProducts().add(hmProds.get("Metoprolol"));
		hmAgrees.get("Agreement 18-04-2020").getProducts().add(hmProds.get("Sodium nitroprusside"));
		hmAgrees.get("Agreement 18-04-2020").getProducts().add(hmProds.get("Surfactant"));
		// hmProds.get("Metoprolol").setParent(hmAgrees.get("Agreement
		// 18-04-2020"));
		// hmProds.get("Sodium nitroprusside").setParent(hmAgrees.get("Agreement
		// 18-04-2020"));
		// hmProds.get("Surfactant").setParent(hmAgrees.get("Agreement
		// 18-04-2020"));

		hmAgrees.get("Agreement 19-04-2020").getProducts().add(hmProds.get("Production Waste – Standard Bin Bag"));
		// hmProds.get("Production Waste – Standard Bin
		// Bag").setParent(hmAgrees.get("Agreement 19-04-2020"));
		hmAgrees.get("Agreement 20-04-2020").getProducts().add(hmProds.get("Pallet Disposal engine"));
		// hmProds.get("Pallet Disposal
		// engine").setParent(hmAgrees.get("Agreement 20-04-2020"));

		// agregando productos a los productos

		hmProds.get("Production Waste – Standard Bin Bag").getProducts()
				.add(hmProds.get("Bin Hire – 120 Litre Food Waste engine"));
		hmProds.get("Production Waste – Standard Bin Bag").getProducts()
				.add(hmProds.get("Bin Hire – 331 Litre Glass engine"));
		hmProds.get("Production Waste – Standard Bin Bag").getProducts()
				.add(hmProds.get("Bin Hire – 240 Litre Wheelie engine"));
		// hmProds.get("Bin Hire – 120 Litre Food Waste
		// engine").setParent(hmProds.get("Production Waste – Standard Bin
		// Bag"));
		// hmProds.get("Bin Hire – 331 Litre Glass
		// engine").setParent(hmProds.get("Production Waste – Standard Bin
		// Bag"));
		// hmProds.get("Bin Hire – 240 Litre Wheelie
		// engine").setParent(hmProds.get("Production Waste – Standard Bin
		// Bag"));

		hmProds.get("Pallet Disposal engine").getProducts().add(hmProds.get("Bin Hire – 240 Litre Raw Meat engine"));
		hmProds.get("Pallet Disposal engine").getProducts().add(hmProds.get("Bin Hire – 1200 Litre Euro engine"));
		hmProds.get("Pallet Disposal engine").getProducts()
				.add(hmProds.get("Bin Hire – 5 Litre Clinical Waste engine"));
		// hmProds.get("Bin Hire – 240 Litre Raw Meat
		// engine").setParent(hmProds.get("Pallet Disposal engine"));
		// hmProds.get("Bin Hire – 1200 Litre Euro
		// engine").setParent(hmProds.get("Pallet Disposal engine"));
		// hmProds.get("Bin Hire – 5 Litre Clinical Waste
		// engine").setParent(hmProds.get("Pallet Disposal engine"));
		ArrayList<Agreement> arry = new ArrayList<>();

		for (Iterator<String> iterator = hmAgrees.keySet().iterator(); iterator.hasNext();) {
			String mykey = iterator.next();
			arry.add(hmAgrees.get(mykey));
		}
		return arry;
	}

}
