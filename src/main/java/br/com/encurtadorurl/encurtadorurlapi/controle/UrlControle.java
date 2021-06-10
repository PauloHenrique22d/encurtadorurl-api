package br.com.encurtadorurl.encurtadorurlapi.controle;


import br.com.encurtadorurl.encurtadorurlapi.entidades.Url;
import br.com.encurtadorurl.encurtadorurlapi.servico.EncurtadorServico;
import br.com.encurtadorurl.encurtadorurlapi.vo.UrlVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/url")
@CrossOrigin(origins = "http://localhost:4200")
public class UrlControle {

    @Autowired
    private EncurtadorServico encurtadorServico;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<?> listar() {

        List<Url> urls = encurtadorServico.findAll();
        urls.stream().map(this::convertToDto).collect(Collectors.toList() ) ;
        return !urls.isEmpty() ? ResponseEntity.ok(urls) : ResponseEntity.noContent().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Url> criar(@RequestBody Url url, HttpServletResponse response) {
        encurtadorServico.salvar(url);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(url.getId())
                .toUri();
        response.setHeader("Location", uri.toASCIIString());
        return ResponseEntity.created(uri).body(url);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaPeloCodigo(@PathVariable Long id) {

        Optional<Url> url = encurtadorServico.findById(id);
        url.stream().map(this::convertToDto).collect(Collectors.toList() ) ;
        return url != null ? ResponseEntity.ok(url) : ResponseEntity.notFound().build();
    }

    private UrlVO convertToDto(Url url) {
        UrlVO urlVO = modelMapper.map(url, UrlVO.class);
        return urlVO;
    }
}
