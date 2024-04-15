package top.kyozweb.service;

import java.util.List;

import top.kyozweb.entity.Placa;

public interface PlacaService 
{
	public List<Placa> listarPlaca();
	public Placa guardarPlaca(Placa placa);
	public Placa actualizarPlaca(Placa placa);
	public Placa obtenerIdPlaca(Integer placaId);
	public void eliminarPlaca(Integer placaId);
	public List<Placa> obtenerPlacasPorCategoria(Integer placaId);
}
