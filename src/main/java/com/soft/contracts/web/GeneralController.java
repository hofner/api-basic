package com.soft.contracts.web;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.soft.contracts.entity.Agreement;
import com.soft.contracts.entity.RegisterProducts;

/**
 * Controller que nos proporciona los metodos para hacer POST, PUT y get(aunque
 * este metodo solo es un generador de datos para que construyamos los test para
 * el software POSTMAN)
 *
 * @author Juan Miguel Olguin Salguero
 *
 */
@RestController
public class GeneralController {

	private static final String FOLDER = "/agreements";

	//
	// return 201 Created
	/**
	 * Metodo para agregar un nuevo Agreement. Almacena directamente al disco
	 * duro
	 *
	 * @param agreement
	 *            Parametro del agreement del que se tomara su nombre, y se
	 *            escribira a disco, junto con sus atributos
	 * @return el agreement creado
	 */
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(FOLDER)
	Agreement newAgreement(@RequestBody Agreement agreement) {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try {
			FileWriter fw = new FileWriter(agreement.getName());
			gson.toJson(agreement, fw);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return agreement;
	}

	//
	/**
	 * Metodo para agregar los productos a este Agreement. Este lo actualiza
	 * directamente en el archivo.
	 *
	 * @param agreement
	 *            el agreement object que ya viene con los productos que se le
	 *            van a agregar
	 * @return el objeto agreement con los productos ya asociados
	 */
	@PutMapping(FOLDER)
	ResponseEntity<Agreement> updateAgreement(@RequestBody Agreement agreement) {
		HttpStatus status = HttpStatus.OK;
		File file = new File(agreement.getName());
		if (file.exists()) {
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			try {
				FileWriter fw = new FileWriter(agreement.getName());
				gson.toJson(agreement, fw);
				fw.close();
			} catch (Exception e) {
				status = HttpStatus.INTERNAL_SERVER_ERROR;
				e.printStackTrace();
			}
		} else {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			agreement = null;
		}

		return new ResponseEntity<Agreement>(agreement, status);
	}

	/**
	 * Metodo para generar datos con los cuales probar los otros dos metodos:
	 * Post y Put. Este metodo me devuelve los Agreements y los productos
	 * asociados a cada uno, aun y cuando estos productos esten anidados(cuando
	 * un producto tiene como padre a otro producto).
	 *
	 * @return el json con todos los objetos
	 */
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(FOLDER)
	List<Agreement> generateData() {
		RegisterProducts prodsListGenerator = new RegisterProducts();
		return prodsListGenerator.generate();
	}

}
