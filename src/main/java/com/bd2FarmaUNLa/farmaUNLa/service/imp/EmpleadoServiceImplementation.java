package com.bd2FarmaUNLa.farmaUNLa.service.imp;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bd2FarmaUNLa.farmaUNLa.model.Empleado;
import com.bd2FarmaUNLa.farmaUNLa.repository.EmpleadoRepository;
import com.bd2FarmaUNLa.farmaUNLa.service.EmpleadoService;


@Service("empleadoService")
@Transactional
public class EmpleadoServiceImplementation implements EmpleadoService {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Empleado> empleados;
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	public List<Empleado> findAllEmpleados() {
		return (List<Empleado>) empleadoRepository.findAll();
	}
		
	@Override
	public Empleado findByCuil(long cuil) {
		return empleadoRepository.findByCuil(cuil);
	}

	@Override
	public void saveEmpleado(Empleado empleado) {
		empleadoRepository.save(empleado);
	}

	@Override
	public void updateEmpleado(Empleado empleado) {
		empleadoRepository.save(empleado);
	}

	@Override
	public void deleteEmpleadoById(long id) {
		empleadoRepository.deleteById(id);
	}

	@Override
	public boolean isEmpleadoExist(Empleado empleado) {
		return findByCuil(empleado.getCuil())!=null;
	}
	
	@Override
	public void deleteAllEmpleados() {
		empleadoRepository.deleteAll();
	}

}
