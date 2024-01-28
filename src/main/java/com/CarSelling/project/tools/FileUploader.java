package com.CarSelling.project.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Base64;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;

@Service
public class FileUploader {

    private final Storage storage;

    public FileUploader() {
        storage = StorageOptions.getDefaultInstance().getService();
    }

    public File getFileFromByte(String base64) {
        try {
            // Décodez la chaîne Base64 en tableau de bytes
            byte[] decodedBytes = Base64.getDecoder().decode(base64);

            // Écrivez les données décodées dans un fichier
            File outputFile = new File("temp.jpg");
            try (FileOutputStream outputStream = new FileOutputStream(outputFile)) {
                outputStream.write(decodedBytes);
            }

            return outputFile;

        } catch (IOException e) {
            System.err.println("Une erreur s'est produite : " + e.getMessage());
            return null;
        }
    }

    public String uploadImage(String base64) throws IOException {
        File file = getFileFromByte(base64);

        String bucketName = "carselling2-78837.appspot.com";
        String filename = UUID.randomUUID().toString() + ".jpg";
        BlobId blobId = BlobId.of(bucketName, filename); // Replace with your bucker name
        BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("media").build();
        // InputStream inputStream =
        // ImageService.class.getClassLoader().getResourceAsStream("serviceAccountKey.json");
        // // change
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("serviceAccountKey.json");

        GoogleCredentials credentials = GoogleCredentials.fromStream(inputStream);
        Storage storage = StorageOptions.newBuilder().setCredentials(credentials).build().getService();
        storage.create(blobInfo, Files.readAllBytes(file.toPath()));

        String DOWNLOAD_URL = "https://firebasestorage.googleapis.com/v0/b/" + bucketName + "/o/%s?alt=media";
        return String.format(DOWNLOAD_URL, URLEncoder.encode(filename, StandardCharsets.UTF_8));
    }
}
