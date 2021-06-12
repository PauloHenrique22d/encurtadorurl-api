package br.com.encurtadorurl.encurtadorurlapi;

import br.com.encurtadorurl.encurtadorurlapi.entidades.Url;
import br.com.encurtadorurl.encurtadorurlapi.repositorio.EncurtadorRepositorio;
import br.com.encurtadorurl.encurtadorurlapi.servico.EncurtadorServico;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EncurtadorurlApiApplicationTests {

    @Autowired
    private EncurtadorServico encurtadorServico;

    @Autowired
    private EncurtadorRepositorio encurtadorRepositorio;

    @Test
    void contextLoads() {
    }

    @Test
    public void saveUrl() {
        Url url = new Url("", "https://docs.spring.io/spring-boot/docs/", "");
        encurtadorServico.salvar(url.getUrlOriginal());
        Integer countUrl = encurtadorServico.findAll().size();
        assertEquals(new Integer(2), countUrl);
    }

    @Test
    public void checkUrlrSavedWithUrl() {
        Url url = new Url("b2dcf3c1", "https://spring.io/projects/spring-boot", "https://encurtador-api-ws.herokuapp.com:8080/url/b2dcf3c1");
        encurtadorRepositorio.save(url);
        Integer countUrl = encurtadorRepositorio.findAll().size();
        assertEquals(new Integer(1), countUrl);
        Optional<Url> urlSalva = encurtadorRepositorio.findById("b2dcf3c1");

        assertNotNull(urlSalva);
    }

    @Test
    public void urlTest() {
        Url url = new Url("b2dcf3c1", "https://docs.spring.io/spring-boot/docs/", "https://encurtador-api-ws.herokuapp.com:8080/url/b2dcf3c1");
        assertEquals("b2dcf3c1", url.getId());
    }

    @Test
    public void findByIdTest() {
        Url url = new Url("b2dcf3c1", "", "");
        Optional<Url> retorno = encurtadorRepositorio.findById(url.getId());
        assertNotNull(retorno);

    }

}
