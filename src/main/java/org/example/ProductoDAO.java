package org.example;

import models.Producto;

import java.util.List;

public interface ProductoDAO {
    public Boolean crearProducto(Producto producto);

    public Boolean actualizarProducto(Producto producto);

    public Producto obtenerProducto(Integer id);

    public Boolean eliminarProducto(Producto producto);

    public List<Producto> obtenerListadoProductos();

}