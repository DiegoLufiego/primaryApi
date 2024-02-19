package com.kopek.stockAndSales.apiControllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kopek.stockAndSales.dtos.Dato;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/data")
public class ApiController {

	public List<Dato> listaDatos = new ArrayList<>();
	public Short lastID = 0;

	@GetMapping("/")
	public List<Dato> listAll() {
		return this.listaDatos;
	}

	@GetMapping("/{id}")
	public Dato listOne(@PathVariable("id") Integer identification) {
		return listaDatos
				.stream()
				.filter(dato -> dato.getId().equals(identification))
				.findFirst().orElse(new Dato());
	}

	@PostMapping("/")
	public Dato create(@RequestBody Dato entity) {
		Dato datoReturn = new Dato();
		datoReturn.setId(entity.getId());
		datoReturn.setCadena(entity.getCadena());
		listaDatos.add(datoReturn);

		return datoReturn;
	}

}
