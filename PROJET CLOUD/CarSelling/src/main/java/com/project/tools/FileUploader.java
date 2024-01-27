package com.CarSelling.project.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;

public class FileUploader {
    @Value("${upload.folder}")
    private String filepath;

    public void uploadFile(String base64) throws Exception {

        // Décodez la chaîne Base64
        byte[] decodedBytes = Base64.decodeBase64(base64);

        try {
            String fileName = "nouveauFichier.jpg"; // Nom du fichier que vous souhaitez enregistrer
            Path path = Paths.get("E:\\DOSSIER_S5\\demo(1)\\carselling\\uploadFile", fileName);
            Files.write(path, decodedBytes);

        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
