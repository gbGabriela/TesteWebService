package com.eacj.testeWebService.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.eacj.testeWebService.dao.EstadoDao;
import com.eacj.testeWebService.entidade.Estado;

@CrossOrigin
@RestController
@RequestMapping("/ws/estado/")
public class RestEstado {
	
	@Autowired
	private EstadoDao dao;
	
	@RequestMapping(method = RequestMethod.POST)
	public void salvar(@RequestBody Estado estado) {
		dao.save(estado);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Estado>> buscar(){
		List<Estado> list = dao.findAll();
		return new ResponseEntity<List<Estado>>(list,HttpStatus.OK);
	}
	
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void excluir(@PathVariable("id") Long id) {
		dao.deleteById(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void alterar(@RequestBody Estado estado) {
		Estado estadoOld = dao.findById(estado.getId()).get();
		estadoOld.setNome(estado.getNome());
		estadoOld.setSigla(estado.getSigla());
		dao.saveAndFlush(estadoOld);
	}
	
}
