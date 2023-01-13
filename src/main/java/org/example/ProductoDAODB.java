package org.example;

import models.Producto;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductoDAODB implements ProductoDAO {
    private EntityManager em = EntityManagerFactoryUtil.getEmf().createEntityManager();

    @Override
    public Boolean crearProducto(Producto producto) {
        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public Boolean actualizarProducto(Producto producto) {
        em.getTransaction().begin();
        em.persist(producto);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public Producto obtenerProducto(Integer id) {
        return em.find(Producto.class, id);
    }

    @Override
    public Boolean eliminarProducto(Producto producto) {
        em.getTransaction().begin();
        em.remove(producto);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public List<Producto> obtenerListadoProductos() {
        TypedQuery<Producto> query =
                em.createQuery("SELECT p FROM Producto p", Producto.class);

        List<Producto> listadoProductos = query.getResultList();

        return listadoProductos;
    }
}
