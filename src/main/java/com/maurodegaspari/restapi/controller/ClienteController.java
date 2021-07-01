package com.maurodegaspari.restapi.controller;

import java.io.Console;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.maurodegaspari.restapi.model.ClienteModel;
import com.maurodegaspari.restapi.respository.ClienteRepository;

import jdk.nashorn.internal.ir.annotations.Ignore;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository repo;
	
	@GetMapping
	public List<ClienteModel> listaCliente(){
		return repo.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteModel adicionar(@RequestBody ClienteModel cliente) {
		 return repo.save(cliente); 
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.GONE)
	public ClienteModel update(@PathVariable Long id, @RequestBody ClienteModel cliente) {
		ClienteModel upDateCliente	= this.repo.findById(id).get();
		BeanUtils.copyProperties(cliente, upDateCliente,"id");
		return repo.save(upDateCliente);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		repo.deleteById(id);
	}
}
