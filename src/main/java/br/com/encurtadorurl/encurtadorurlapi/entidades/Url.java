package br.com.encurtadorurl.encurtadorurlapi.entidades;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;


@Data
@Entity
@NoArgsConstructor @AllArgsConstructor
public class Url implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String urlOriginal;
    private String urlEncurtada;

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public String getUrlOriginal() {
        return urlOriginal;
    }

    public void setUrlOriginal(String urlOriginal) {
        this.urlOriginal = urlOriginal;
    }

    public String getUrlEncurtada() {
        return urlEncurtada;
    }

    public void setUrlEncurtada(String urlEncurtada) {
        this.urlEncurtada = urlEncurtada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Url url = (Url) o;
        return Objects.equals(id, url.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
