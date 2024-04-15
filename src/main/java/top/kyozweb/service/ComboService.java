package top.kyozweb.service;

import java.util.List;

import top.kyozweb.entity.Combo;

public interface ComboService 
{
    public List<Combo> listarCombo();
    public Combo guardarCombo(Combo combo);
    public Combo actualizarCombo(Combo combo);
    public Combo obtenerIdCombo(Integer comboId);
    public void eliminarCombo(Integer comboId);
    public List<Combo> obtenerCombosPorCategoria(Integer comboId);
}
