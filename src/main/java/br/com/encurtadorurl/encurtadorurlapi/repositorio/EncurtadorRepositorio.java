package br.com.encurtadorurl.encurtadorurlapi.repositorio;

import br.com.encurtadorurl.encurtadorurlapi.entidades.Url;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EncurtadorRepositorio extends JpaRepository<Url, Long> {


}
