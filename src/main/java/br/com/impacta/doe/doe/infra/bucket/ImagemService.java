package br.com.impacta.doe.doe.infra.bucket;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImagemService {
    String upload(MultipartFile img) throws IOException;
}
