package br.com.encurtadorurl.encurtadorurlapi.vo;

import lombok.*;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class UrlVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String urlOriginal;
    private String urlEncurtada;

}
