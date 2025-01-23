package com.mycompany.jpa_practica1.modelos;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "autores")
@NamedQueries({
    @NamedQuery(name = "Autor.findLike", query = "SELECT a FROM Autor a WHERE a.nomAutor LIKE :texto"),
    @NamedQuery(
            name = "Autor.findCategoria",
            query = "SELECT a FROM Autor a WHERE a.idAutor IN ("
            + "SELECT l.autor.idAutor FROM Libro l JOIN l.categoriaCollection c WHERE c.nomCategoria = :textoCategoria)"
    ),
    @NamedQuery(name = "Autor.findAll", query = "SELECT DISTINCT(a) FROM Autor a JOIN a.listaLibros l WHERE a.idAutor = a.idAutor"),
    @NamedQuery(name = "Autor.findAutores", query = "SELECT a FROM Autor a"),
    @NamedQuery(name = "Autor.findByIdAutor", query = "SELECT a FROM Autor a WHERE a.idAutor = :idAutor"),
    @NamedQuery(name = "Autor.findByNomAutor", query = "SELECT a FROM Autor a WHERE a.nomAutor LIKE :nomAutor")})
public class Autor implements Serializable, Comparable<Autor> {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAutor;
    private String nomAutor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "autor")
    private Collection<Libro> listaLibros;

    public Autor() {
    }

    public Autor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public Autor(String nomAutor) {
        this.nomAutor = nomAutor;
    }

    public Integer getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Integer idAutor) {
        this.idAutor = idAutor;
    }

    public String getNomAutor() {
        return nomAutor;
    }

    public void setNomAutor(String nomAutor) {
        this.nomAutor = nomAutor;
    }

    public Collection<Libro> getListaLibros() {
        return listaLibros;
    }

    public void setLibroCollection(Collection<Libro> libroCollection) {
        this.listaLibros = libroCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAutor != null ? idAutor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Autor)) {
            return false;
        }
        Autor other = (Autor) object;
        if ((this.idAutor == null && other.idAutor != null) || (this.idAutor != null && !this.idAutor.equals(other.idAutor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.nomAutor;
    }

    @Override
    public int compareTo(Autor o) {
        return this.idAutor.compareTo(o.idAutor);
    }

}
