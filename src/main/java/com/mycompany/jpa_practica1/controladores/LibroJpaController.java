package com.mycompany.jpa_practica1.controladores;

import com.mycompany.jpa_practica1.exceptions.NonexistentEntityException;
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

/**
 *
 * @author crveg
 */
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

    public void create(Libro libro) {
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
            Collection<Categoria> attachedCategoriaCollection = new ArrayList<Categoria>();
            for (Categoria categoriaCollectionCategoriaToAttach : libro.getCategoriaCollection()) {
                categoriaCollectionCategoriaToAttach = em.getReference(categoriaCollectionCategoriaToAttach.getClass(), categoriaCollectionCategoriaToAttach.getIdCategoria());
                attachedCategoriaCollection.add(categoriaCollectionCategoriaToAttach);
            }
            libro.setCategoriaCollection(attachedCategoriaCollection);
            em.persist(libro);
            if (autor != null) {
                autor.getListaLibros().add(libro);
                autor = em.merge(autor);
            }
            for (Categoria categoriaCollectionCategoria : libro.getCategoriaCollection()) {
                categoriaCollectionCategoria.getLibroCollection().add(libro);
                categoriaCollectionCategoria = em.merge(categoriaCollectionCategoria);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Libro libro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Libro persistentLibro = em.find(Libro.class, libro.getIdLibros());
            Autor autorOld = persistentLibro.getAutor();
            Autor autorNew = libro.getAutor();
            Collection<Categoria> categoriaCollectionOld = persistentLibro.getCategoriaCollection();
            Collection<Categoria> categoriaCollectionNew = libro.getCategoriaCollection();
            if (autorNew != null) {
                autorNew = em.getReference(autorNew.getClass(), autorNew.getIdAutor());
                libro.setAutor(autorNew);
            }
            Collection<Categoria> attachedCategoriaCollectionNew = new ArrayList<Categoria>();
            for (Categoria categoriaCollectionNewCategoriaToAttach : categoriaCollectionNew) {
                categoriaCollectionNewCategoriaToAttach = em.getReference(categoriaCollectionNewCategoriaToAttach.getClass(), categoriaCollectionNewCategoriaToAttach.getIdCategoria());
                attachedCategoriaCollectionNew.add(categoriaCollectionNewCategoriaToAttach);
            }
            categoriaCollectionNew = attachedCategoriaCollectionNew;
            libro.setCategoriaCollection(categoriaCollectionNew);
            libro = em.merge(libro);
            if (autorOld != null && !autorOld.equals(autorNew)) {
                autorOld.getListaLibros().remove(libro);
                autorOld = em.merge(autorOld);
            }
            if (autorNew != null && !autorNew.equals(autorOld)) {
                autorNew.getListaLibros().add(libro);
                autorNew = em.merge(autorNew);
            }
            for (Categoria categoriaCollectionOldCategoria : categoriaCollectionOld) {
                if (!categoriaCollectionNew.contains(categoriaCollectionOldCategoria)) {
                    categoriaCollectionOldCategoria.getLibroCollection().remove(libro);
                    categoriaCollectionOldCategoria = em.merge(categoriaCollectionOldCategoria);
                }
            }
            for (Categoria categoriaCollectionNewCategoria : categoriaCollectionNew) {
                if (!categoriaCollectionOld.contains(categoriaCollectionNewCategoria)) {
                    categoriaCollectionNewCategoria.getLibroCollection().add(libro);
                    categoriaCollectionNewCategoria = em.merge(categoriaCollectionNewCategoria);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = libro.getIdLibros();
                if (findLibro(id) == null) {
                    throw new NonexistentEntityException("The libro with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Libro libro;
            try {
                libro = em.getReference(Libro.class, id);
                libro.getIdLibros();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The libro with id " + id + " no longer exists.", enfe);
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
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Libro> findLibroEntities() {
        return findLibroEntities(true, -1, -1);
    }

    public List<Libro> findLibroEntities(int maxResults, int firstResult) {
        return findLibroEntities(false, maxResults, firstResult);
    }

    private List<Libro> findLibroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Libro.class));
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

    public Libro findLibro(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Libro.class, id);
        } finally {
            em.close();
        }
    }

    public int getLibroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Libro> rt = cq.from(Libro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
