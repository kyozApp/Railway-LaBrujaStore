package top.kyozweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.kyozweb.entity.Marca;
import top.kyozweb.repository.MarcaRepository;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Override
    public Marca actualizarMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public void eliminarMarca(Integer marcaId) {
        marcaRepository.deleteById(marcaId);
    }

    @Override
    public Marca guardarMarca(Marca marca) {
        return marcaRepository.save(marca);
    }

    @Override
    public List<Marca> listarMarca() {
        return marcaRepository.findAll();
    }

    @Override
    public Marca obtenerIdMarca(Integer marcaId) {
        return marcaRepository.findById(marcaId).get();
    }

}
