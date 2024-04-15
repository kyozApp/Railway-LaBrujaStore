package top.kyozweb.service;

import java.util.List;

import top.kyozweb.entity.Refrigeracion;

public interface RefrigeracionService 
{
	public List<Refrigeracion> listarRefrigeracion();
	public Refrigeracion guardarRefrigeracion(Refrigeracion refrigeracion);
	public Refrigeracion actualizarRefrigeracion(Refrigeracion refrigeracion);
	public Refrigeracion obtenerIdRefrigeracion(Integer refrigeracionId);
	public void eliminarRefrigeracion(Integer refrigeracionId);
	public List<Refrigeracion> obtenerRefrigeracionesPorCategoria(Integer refrigeracionId);
}
