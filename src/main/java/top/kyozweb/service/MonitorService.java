package top.kyozweb.service;

import java.util.List;

import top.kyozweb.entity.Monitor;

public interface MonitorService 
{
	public List<Monitor> listarMonitor();
	public Monitor guardarMonitor(Monitor monitor);
	public Monitor actualizarMonitor(Monitor monitor);
	public Monitor obtenerIdMonitor(Integer monitorId);
	public void eliminarMonitor(Integer monitorId);
	public List<Monitor> obtenerMonitoresPorCategoria(Integer monitorId);
}
