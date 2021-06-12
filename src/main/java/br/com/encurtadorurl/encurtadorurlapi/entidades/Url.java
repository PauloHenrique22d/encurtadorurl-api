package br.com.encurtadorurl.encurtadorurlapi.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;


@Data
@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Url implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id ;
    private String urlOriginal;
    private String urlEncurtada;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Url url = (Url) o;
        return id.equals(url.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
