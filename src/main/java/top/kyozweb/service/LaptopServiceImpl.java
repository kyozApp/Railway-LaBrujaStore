package top.kyozweb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.kyozweb.entity.Laptop;
import top.kyozweb.repository.LaptopRepository;

@Service
public class LaptopServiceImpl implements LaptopService
{
	@Autowired
	private LaptopRepository laptopRepository;

	@Override
	public List<Laptop> listarLaptop() {
		return laptopRepository.findAll();
	}

	@Override
	public Laptop guardarLaptop(Laptop laptop) {
		return laptopRepository.save(laptop);
	}

	@Override
	public Laptop actualizarLaptop(Laptop laptop) {
		return laptopRepository.save(laptop);
	}

	@Override
	public Laptop obtenerIdLaptop(Integer laptopId) {
		return laptopRepository.findById(laptopId).get();
	}

	@Override
	public void eliminarLaptop(Integer laptopId) {
		laptopRepository.deleteById(laptopId);
	}

	@Override
    public List<Laptop> obtenerLaptopsPorCategoria(Integer laptopId) {

		List<Laptop> laptops = laptopRepository.findAll();
		List<Laptop> laptopsFinal = new ArrayList<>();
		for (Laptop laptop : laptops) {
			if (laptopId.equals(laptop.getCategoria().getCategoriaId())) {
				laptopsFinal.add(laptop);
			}
		}
	
		return laptopsFinal;
	}
}
