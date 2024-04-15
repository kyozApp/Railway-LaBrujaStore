package top.kyozweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.kyozweb.entity.Tarjeta;
import top.kyozweb.repository.TarjetaRepository;

@Service
public class TarjetaServiceImpl implements TarjetaService
{
	@Autowired
	private TarjetaRepository tarjetaRepository;

	@Override
	public List<Tarjeta> listarTarjeta() {
		return tarjetaRepository.findAll();
	}

	@Override
	public Tarjeta guardarTarjeta(Tarjeta tarjeta) {
		return tarjetaRepository.save(tarjeta);
	}

	@Override
	public Tarjeta actualizarTarjeta(Tarjeta tarjeta) {
		return tarjetaRepository.save(tarjeta);
	}

	@Override
	public Tarjeta obtenerIdTarjeta(Integer tarjetaId) {
		return tarjetaRepository.findById(tarjetaId).get();
	}

	@Override
	public void eliminarTarjeta(Integer tarjetaId) {
		tarjetaRepository.deleteById(tarjetaId);
	}

	@Override
    public List<Tarjeta> obtenerTarjetasPorCategoria(Integer tarjetaId) {

		List<Tarjeta> tarjetas = tarjetaRepository.findAll();
		List<Tarjeta> tarjetasFinal = new ArrayList<>();
		for (Tarjeta tarjeta : tarjetas) {
			if (tarjetaId.equals(tarjeta.getCategoria().getCategoriaId())) {
				tarjetasFinal.add(tarjeta);
			}
		}
	
		return tarjetasFinal;
	}
}
