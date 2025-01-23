package com.mycompany.jpa_practica1.controladores;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.jpa_practica1.modelos.Autor;
import com.mycompany.jpa_practica1.modelos.Categoria;
import com.mycompany.jpa_practica1.modelos.Libro;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LibroJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public LibroJpaController() {
        this.emf = Persistence.createEntityManagerFactory("miUnidad");
    }

    public LibroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public Boolean create(Libro libro) {
        Boolean respuesta = true;
        if (libro.getCategoriaCollection() == null) {
            libro.setCategoriaCollection(new ArrayList<Categoria>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Autor autor = libro.getAutor();
            if (autor != null) {
                autor = em.getReference(autor.getClass(), autor.getIdAutor());
                libro.setAutor(autor);
            }
            em.persist(libro);
            if (autor != null) {
                autor.getListaLibros().add(libro);
                autor = em.merge(autor);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            respuesta = false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return respuesta;
    }

    public Boolean edit(Libro libro) {
        EntityManager em = null;
        Boolean respuesta = true;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Libro persistentLibro = em.find(Libro.class, libro.getIdLibros());
            persistentLibro.setTitulo(libro.getTitulo());
            persistentLibro = em.merge(persistentLibro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            respuesta = false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return true;
    }

    public Boolean destroy(Integer id) {
        EntityManager em = null;
        Boolean respuesta = true;
        Libro libro = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            try {
                libro = em.getReference(Libro.class, id);
                libro.getIdLibros();
            } catch (EntityNotFoundException enfe) {
                enfe.printStackTrace();
                respuesta = false;
            }
            Autor autor = libro.getAutor();
            if (autor != null) {
                autor.getListaLibros().remove(libro);
                autor = em.merge(autor);
            }
            Collection<Categoria> categoriaCollection = libro.getCategoriaCollection();
            for (Categoria categoriaCollectionCategoria : categoriaCollection) {
                categoriaCollectionCategoria.getLibroCollection().remove(libro);
                categoriaCollectionCategoria = em.merge(categoriaCollectionCategoria);
            }
            em.remove(libro);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            respuesta = false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return respuesta;
    }
    
    public Libro findLibro(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Libro.class, id);
        } finally {
            em.close();
        }
    }


}
