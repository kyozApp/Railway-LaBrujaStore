package top.kyozweb.service;

import java.util.List;

import top.kyozweb.entity.Ram;

public interface RamService 
{
	public List<Ram> listarRam();
	public Ram guardarRam(Ram ram);
	public Ram actualizarRam(Ram ram);
	public Ram obtenerIdRam(Integer ramId);
	public void eliminarRam(Integer ramId);
	public List<Ram> obtenerRamsPorCategoria(Integer ramId);
}
