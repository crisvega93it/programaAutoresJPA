/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.jpa_practica1.controladores;

import com.mycompany.jpa_practica1.modelos.Categoria;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.jpa_practica1.modelos.Libro;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author crveg
 */
public class CategoriaJpaController implements Serializable {

    public CategoriaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Boolean create(Categoria categoria) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(categoria);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return true;
    }

    public Boolean edit(Categoria categoria) {
        EntityManager em = null;
        Boolean respuesta = true;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria persistentCategoria = em.find(Categoria.class, categoria.getIdCategoria());
            persistentCategoria.setNomCategoria(categoria.getNomCategoria());
            em.merge(persistentCategoria);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return respuesta;
    }

    public Boolean destroy(Integer id) {
        EntityManager em = null;
        Boolean respuesta = true;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Categoria categoria;
            try {
                categoria = em.getReference(Categoria.class, id);
                categoria.getIdCategoria();
                if (!categoria.getLibroCollection().isEmpty()) {
                    respuesta = false;
                }
            } catch (EntityNotFoundException enfe) {
                return false;
            }
            if (respuesta) {
                em.remove(categoria);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return respuesta;
    }
}
