package com.bd2FarmaUNLa.farmaUNLa.service.imp;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bd2FarmaUNLa.farmaUNLa.model.Producto;
import com.bd2FarmaUNLa.farmaUNLa.repository.ProductoRepository;
import com.bd2FarmaUNLa.farmaUNLa.service.ProductoService;


@Service("productoService")
@Transactional
public class ProductoServiceImplementation implements ProductoService {
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<Producto> productos;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	public List<Producto> findAllProductos() {
		return (List<Producto>) productoRepository.findAll();
	}
		
	@Override
	public Producto findById(long idProducto) {
		return productoRepository.findByIdProducto(idProducto);
	}

	@Override
	public void saveProducto(Producto producto) {
		productoRepository.save(producto);
	}

	@Override
	public void updateProducto(Producto producto) {
		productoRepository.save(producto);
	}

	@Override
	public void deleteProductoById(long id) {
		productoRepository.deleteById(id);
	}

	@Override
	public boolean isProductoExist(Producto producto) {
		return findById(producto.getIdProducto())!=null;
	}
	
	@Override
	public void deleteAllProductos() {
		productoRepository.deleteAll();
	}

}
