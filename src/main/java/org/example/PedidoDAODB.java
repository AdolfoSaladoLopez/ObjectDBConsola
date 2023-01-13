package org.example;

import models.*;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class PedidoDAODB implements PedidoDAO {
    private EntityManager em = EntityManagerFactoryUtil.getEmf().createEntityManager();

    @Override
    public Boolean crearPedido(Pedido pedido) {
        em.getTransaction().begin();
        em.persist(pedido);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public Boolean actualizarPedido(Pedido pedido) {
        em.getTransaction().begin();
        em.persist(pedido);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public Pedido obtenerPedido(Integer id) {
        return em.find(Pedido.class, id);
    }

    @Override
    public Boolean eliminarPedido(Pedido pedido) {
        em.getTransaction().begin();
        em.remove(pedido);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public List<Pedido> obtenerListadoPedidos() {
        TypedQuery<Pedido> query =
                em.createQuery("SELECT p FROM Pedido p", Pedido.class);

        List<Pedido> listadoPedidos = query.getResultList();
        em.close();

        return listadoPedidos;
    }

    @Override
    public List<Pedido> obtenerPedidosPendientesHoy() {
        TypedQuery<Pedido> query =
                em.createQuery("SELECT p FROM Pedido p WHERE p.fecha = cb.currentTimestamp()", Pedido.class);

        List<Pedido> listadoPedidos = query.getResultList();

        return listadoPedidos;
    }
}
