package br.com.encurtadorurl.encurtadorurlapi.entidades;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Data
@Entity
@Table (name = "url")
@NoArgsConstructor @AllArgsConstructor
public class Url implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
   private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
