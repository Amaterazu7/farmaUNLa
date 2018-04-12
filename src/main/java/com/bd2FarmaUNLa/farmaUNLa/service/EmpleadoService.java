package com.bd2FarmaUNLa.farmaUNLa.service;

import java.util.List;
import com.bd2FarmaUNLa.farmaUNLa.model.Empleado;


public interface EmpleadoService {
	
	Empleado findById(long id);
	
	void saveEmpleado(Empleado empleado);
	
	void updateEmpleado(Empleado empleado);
	
	void deleteEmpleadoById(long id);

	List<Empleado> findAllEmpleados(); 
	
	void deleteAllEmpleados();
	
	public boolean isEmpleadoExist(Empleado empleado);
}

