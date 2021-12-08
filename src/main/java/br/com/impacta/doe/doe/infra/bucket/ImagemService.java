package br.com.impacta.doe.doe.infra.bucket;

import java.util.Base64;

public interface ImagemService {
    String upload(Base64 img);
}
