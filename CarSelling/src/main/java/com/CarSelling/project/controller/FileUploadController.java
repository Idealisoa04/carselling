package com.CarSelling.project.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadController {
    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestPart("file") MultipartFile file) throws IOException {
        // Vous pouvez traiter le fichier ici (enregistrer, analyser, etc.)
        // Exemple : sauvegarder le fichier dans un répertoire local
        // Ne pas oublier de gérer les exceptions liées au traitement du fichier
        // (par exemple, IOException, IllegalStateException, etc.)

        // Pour illustrer, sauvegardons le fichier dans le répertoire "uploads" à la
        // racine du projet
        try {
            // file.transferTo(new File("uploads/" + file.getOriginalFilename()));
            return ResponseEntity.ok("Fichier téléchargé avec succès : " + file.getOriginalFilename());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erreur lors du téléchargement du fichier.");
        }
    }
}
