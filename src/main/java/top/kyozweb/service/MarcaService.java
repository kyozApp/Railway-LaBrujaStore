package top.kyozweb.service;

import java.util.List;

import top.kyozweb.entity.Marca;

public interface MarcaService {
    public List<Marca> listarMarca();

    public Marca guardarMarca(Marca marca);

    public Marca actualizarMarca(Marca marca);

    public Marca obtenerIdMarca(Integer marcaId);

    public void eliminarMarca(Integer marcaId);
}
