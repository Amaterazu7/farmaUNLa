package com.bd2FarmaUNLa.farmaUNLa.service.imp;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bd2FarmaUNLa.farmaUNLa.model.TipoProducto;
import com.bd2FarmaUNLa.farmaUNLa.repository.TipoProductoRepository;
import com.bd2FarmaUNLa.farmaUNLa.service.TipoProductoService;


@Service("tipoProductoService")
@Transactional
public class TipoProductoServiceImplementation implements TipoProductoService {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<TipoProducto> tipoProductoes;
	
	@Autowired
	private TipoProductoRepository tipoProductoRepository;
	
	public List<TipoProducto> findAllTiposProductos() {
		return (List<TipoProducto>) tipoProductoRepository.findAll();
	}
		
	@Override
	public TipoProducto findById(long id) {
		return tipoProductoRepository.findById(id);
	}

	@Override
	public void saveTipoProducto(TipoProducto tipoProducto) {
		tipoProductoRepository.save(tipoProducto);
	}

	@Override
	public void updateTipoProducto(TipoProducto tipoProducto) {
		tipoProductoRepository.save(tipoProducto);
	}

	@Override
	public void deleteTipoProductoById(long id) {
		tipoProductoRepository.deleteById(id);
	}

	@Override
	public boolean isTipoProductoExist(TipoProducto tipoProducto) {
		return findById(tipoProducto.getIdTipoProducto())!=null;
	}
	
	@Override
	public void deleteAllTiposProductos() {
		tipoProductoRepository.deleteAll();
	}

}
