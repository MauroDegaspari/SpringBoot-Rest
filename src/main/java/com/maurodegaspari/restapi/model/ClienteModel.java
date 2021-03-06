package com.maurodegaspari.restapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClienteModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@Column(nullable = false)
	public String nome;
}
