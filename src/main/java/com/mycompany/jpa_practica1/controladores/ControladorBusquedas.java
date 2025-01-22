package com.mycompany.jpa_practica1.controladores;

import com.mycompany.jpa_practica1.modelos.Autor;
import com.mycompany.jpa_practica1.modelos.Categoria;
import com.mycompany.jpa_practica1.modelos.Libro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

public class ControladorBusquedas {

    private EntityManagerFactory emf;
    private EntityManager em;
    
    public ControladorBusquedas(EntityManagerFactory emf){
        this.emf = emf;
    }

    public List allAutores() {
        em = emf.createEntityManager();

        TypedQuery<Autor> query = em.createNamedQuery("Autor.findAll", Autor.class);

        List<Autor> autores = query.getResultList();

        em.close();

        return autores;
    }
    
    public List allAutores2() {
        em = emf.createEntityManager();

        TypedQuery<Autor> query = em.createNamedQuery("Autor.findAutores", Autor.class);

        List<Autor> autores = query.getResultList();

        em.close();

        return autores;
    }
    
    public List buscarPorNombre(String autor) {
        em = emf.createEntityManager();

        TypedQuery<Libro> query = em.createNamedQuery("Libro.findNomAutor", Libro.class);
        query.setParameter("nomAutor", autor);

        List<Libro> libros = query.getResultList();

        em.close();

        return libros;
    }

    public List allLibros() {
        em = emf.createEntityManager();

        TypedQuery<Libro> query = em.createNamedQuery("Libro.findAll", Libro.class);
        List<Libro> libros = query.getResultList();

        em.close();

        return libros;
    }
    
    public List librosByAutor(int idAutor) {
        em = emf.createEntityManager();

        TypedQuery<Libro> query = em.createNamedQuery("Libro.findByAutor", Libro.class);
        query.setParameter("idAutor", idAutor);
        List<Libro> libros = query.getResultList();

        em.close();

        return libros;
    }
    
    public List librosByNomAutor(String nomAutor) {
        em = emf.createEntityManager();

        TypedQuery<Libro> query = em.createNamedQuery("Libro.findNomAutor", Libro.class);
        query.setParameter("nomAutor", nomAutor);
        List<Libro> libros = query.getResultList();

        em.close();

        return libros;
    }

    public List allCategorias() {
        em = emf.createEntityManager();

        TypedQuery<Categoria> query = em.createNamedQuery("Categoria.findAll", Categoria.class);
        List<Categoria> categorias = query.getResultList();

        em.close();

        return categorias;
    }
    
    public List autoresByCategoria(String categoria){
        em = emf.createEntityManager();

        TypedQuery<Autor> query = em.createNamedQuery("Autor.findCategoria", Autor.class);
        query.setParameter("textoCategoria", categoria);
        List<Autor> autores = query.getResultList();

        em.close();

        return autores;
    }
    
    public Categoria encontrarLibros(int id){
        em = emf.createEntityManager();
        try {
            return em.find(Categoria.class, id);
        } finally {
            em.close();
        }
    }
    
    
}
