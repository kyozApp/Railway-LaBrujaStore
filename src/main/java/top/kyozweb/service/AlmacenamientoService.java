package top.kyozweb.service;

import java.util.List;

import top.kyozweb.entity.Almacenamiento;

public interface AlmacenamientoService 
{
	public List<Almacenamiento> listarAlmacenamiento();
	public Almacenamiento guardarAlmacenamiento(Almacenamiento almacenamiento);
	public Almacenamiento actualizarAlmacenamiento(Almacenamiento almacenamiento);
	public Almacenamiento obtenerIdAlmacenamiento(Integer almacenamientoId);
	public void eliminarAlmacenamiento(Integer almacenamientoId);
	public List<Almacenamiento> obtenerAlmacenamientosPorCategoria(Integer almacenamientoId);
}
