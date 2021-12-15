package br.com.impacta.doe.doe.infra.bucket;

import com.azure.storage.blob.BlobClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class BlobStorage implements ImagemService {

    @Override
    public String upload(MultipartFile img) throws IOException {
        System.out.println("Fazendo upload da imagem...");
        /*String connectString = "123";
        String containerName = "name";
        String URL_AZURE = "....";

        BlobContainerClient containerClient = new BlobContainerClientBuilder()
                .connectionString(connectString)
                .containerName(containerName)
                .buildClient();

        BlobClient blob = containerClient.getBlobClient(img.getOriginalFilename());
        blob.upload(img.getInputStream(), img.getSize(), true);

        return URL_AZURE + "/" + img.getOriginalFilename();*/
        return null;
    }
}
