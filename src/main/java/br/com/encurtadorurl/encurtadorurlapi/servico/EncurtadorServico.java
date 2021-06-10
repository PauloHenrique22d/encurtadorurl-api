package br.com.encurtadorurl.encurtadorurlapi.servico;

import br.com.encurtadorurl.encurtadorurlapi.entidades.Url;
import br.com.encurtadorurl.encurtadorurlapi.repositorio.EncurtadorRepositorio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class EncurtadorServico {

    @Autowired
    private EncurtadorRepositorio encurtadorRepositorio;

    /**
     * Lista todos as urls
     * @return  uma lista de urls
     * @throws RuntimeException
     */
    public List<Url> findAll() throws RuntimeException{

        try {
            return encurtadorRepositorio.findAll();
        } catch (Exception e) {
            log.info("Ocorreu um erro ao consultar as urls");
            return new ArrayList<>();
        }
    }

    /**
     * @param id
     * @return A url consultada
     * @throws RuntimeException
     */
    public Optional<Url> findById(Long id) throws RuntimeException{

        Optional<Url> urls = null;

        try {
            urls = encurtadorRepositorio.findById(id);
            return urls;
        } catch (Exception e) {
            log.info("Ocorreu um erro ao consultar uma determinada url");
            return urls;
        }
    }

    /**
     * Salva a url em questao
     * @param url
     * @return a url salvo
     * @throws RuntimeException
     */
    public Url salvar(Url url) throws RuntimeException{

        try {
            return encurtadorRepositorio.save(url);
        } catch (Exception e) {
            log.info("Ocorreu um erro ao salvar url");
            return new Url();
        }
    }



}
