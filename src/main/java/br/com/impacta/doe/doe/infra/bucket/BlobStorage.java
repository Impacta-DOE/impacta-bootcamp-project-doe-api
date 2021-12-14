package br.com.impacta.doe.doe.infra.bucket;

import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class BlobStorage implements ImagemService {

    @Override
    public String upload(Base64 img) {
        return null;
    }
}
