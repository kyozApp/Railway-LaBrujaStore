package top.kyozweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.kyozweb.entity.Subcategoria;
import top.kyozweb.repository.SubCategoriaRepository;


@Service
public class SubCategoriaServiceImpl implements SubCategoriaService
{
    @Autowired
    private SubCategoriaRepository subCategoriaRepository;
    
    @Override
	public List<Subcategoria> listarSubCategoria() {
		return subCategoriaRepository.findAll();
	}

	@Override
	public Subcategoria guardarSubCategoria(Subcategoria subcategoria) {
		return subCategoriaRepository.save(subcategoria);
	}

	@Override
	public Subcategoria actualizarSubCategoria(Subcategoria subcategoria) {
		return subCategoriaRepository.save(subcategoria);
	}

	@Override
	public Subcategoria obtenerIdSubCategoria(Integer subcategoriaId) {
		return subCategoriaRepository.findById(subcategoriaId).get();
	}

	@Override
	public void eliminarSubCategoria(Integer subcategoriaId) {
		subCategoriaRepository.deleteById(subcategoriaId);
	}
}
