package com.maurodegaspari.restapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maurodegaspari.restapi.model.ClienteModel;

public interface ClienteRepository  extends JpaRepository<ClienteModel, Long>{

}
