package com.mycompany.jpa_practica1.controladores;

import com.mycompany.jpa_practica1.exceptions.IllegalOrphanException;
import com.mycompany.jpa_practica1.exceptions.NonexistentEntityException;
import com.mycompany.jpa_practica1.modelos.Autor;
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
import javax.persistence.Persistence;

public class AutorJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public AutorJpaController() {
        this.emf = Persistence.createEntityManagerFactory("miUnidad");
    }

    public AutorJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean create(Autor autor) {
        if (autor.getListaLibros() == null || autor.getListaLibros().isEmpty()) {
            return false;
        }
        EntityManager em = null;
        try {
            em = this.emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(autor);
            for (Libro libro : autor.getListaLibros()) {
                Autor oldAutorOfLibroCollectionLibro = libro.getAutor();
                libro.setAutor(autor);
                libro = em.merge(libro);
                if (oldAutorOfLibroCollectionLibro != null) {
                    oldAutorOfLibroCollectionLibro.getListaLibros().remove(libro);
                    oldAutorOfLibroCollectionLibro = em.merge(oldAutorOfLibroCollectionLibro);
                }
            }
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

    public Boolean edit(Autor autor){
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Autor persistentAutor = em.find(Autor.class, autor.getIdAutor());
            if (persistentAutor == null) {
                return false;
            }
            persistentAutor.setNomAutor(autor.getNomAutor());
            em.merge(persistentAutor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = autor.getIdAutor();
                if (findAutor(id) == null) {
                    return false;
                }
                
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return true;
    }

    public boolean destroy(Autor autor) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            int id = autor.getIdAutor();
            try {
                autor = em.find(Autor.class, id);
                autor.getIdAutor();
            } catch (EntityNotFoundException enfe) {
                enfe.printStackTrace();
            }

            Collection<Libro> listaLibros = autor.getListaLibros();
            if (!listaLibros.isEmpty()) {
                return false;
            }
            em.remove(autor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
        return true;
    }

    public List<Autor> findAutorEntities() {
        return findAutorEntities(true, -1, -1);
    }

    public List<Autor> findAutorEntities(int maxResults, int firstResult) {
        return findAutorEntities(false, maxResults, firstResult);
    }

    private List<Autor> findAutorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Autor.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Autor findAutor(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Autor.class, id);
        } finally {
            em.close();
        }
    }

    public int getAutorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Autor> rt = cq.from(Autor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
