package top.kyozweb.service;

import java.util.List;

import top.kyozweb.entity.Producto;

public interface ProductoService 
{
    public List<Producto> listarProducto();
	public Producto guardarProducto(Producto producto);
	public Producto actualizarProducto(Producto producto);
	public Producto obtenerIdProducto(Integer productoId);
	public void eliminarProducto(Integer productoId);
	public List<Producto> obtenerProductosPorCategoria(Integer idCategoria);
}
