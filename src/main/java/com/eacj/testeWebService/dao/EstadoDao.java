package com.eacj.testeWebService.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eacj.testeWebService.entidade.Estado;

public interface EstadoDao extends JpaRepository<Estado, Long>{
	
}
