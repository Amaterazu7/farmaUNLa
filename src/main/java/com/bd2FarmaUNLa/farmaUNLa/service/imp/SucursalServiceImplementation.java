package com.bd2FarmaUNLa.farmaUNLa.service.imp;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bd2FarmaUNLa.farmaUNLa.model.Sucursal;
import com.bd2FarmaUNLa.farmaUNLa.repository.SucursalRepository;
import com.bd2FarmaUNLa.farmaUNLa.service.SucursalService;


@Service("sucursalService")
@Transactional
public class SucursalServiceImplementation implements SucursalService {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Sucursal> sucursales;
	
	@Autowired
	private SucursalRepository sucursalRepository;
	
	public List<Sucursal> findAllSucursales() {
		return (List<Sucursal>) sucursalRepository.findAll();
	}
		
	@Override
	public Sucursal findById(long id) {
		return sucursalRepository.findById(id);
	}

	@Override
	public void saveSucursal(Sucursal sucursal) {
		sucursalRepository.save(sucursal);
	}

	@Override
	public void updateSucursal(Sucursal sucursal) {
		sucursalRepository.save(sucursal);
	}

	@Override
	public void deleteSucursalById(long id) {
		sucursalRepository.deleteById(id);
	}

	@Override
	public boolean isSucursalExist(Sucursal sucursal) {
		return findById(sucursal.getId())!=null;
	}
	
	@Override
	public void deleteAllSucursales() {
		sucursalRepository.deleteAll();
	}

}
