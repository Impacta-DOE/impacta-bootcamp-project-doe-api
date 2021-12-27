package br.com.impacta.doe.doe.infra.bucket;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class BlobStorage implements ImagemService {

    @Value("${url.api.azure}")
    private String URL_AZURE;

    @Value("${url.api.azure.container}")
    private String containerName;

    @Value("${url.api.azure.connectionstring}")
    private String connectString;

    @Override
    public String upload(MultipartFile img) throws IOException {

        BlobContainerClient containerClient = new BlobContainerClientBuilder()
                .connectionString(connectString)
                .containerName(containerName)
                .buildClient();

        BlobClient blob = containerClient.getBlobClient(img.getOriginalFilename());
        blob.upload(img.getInputStream(), img.getSize(), true);

        return URL_AZURE + "/" + img.getOriginalFilename();
    }
}
