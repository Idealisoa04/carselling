package com.CarSelling.project.Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class FirebaseConfig {
    @Bean
    public FirebaseApp firebaseApp() throws IOException {
        List<FirebaseApp> firebaseApps = FirebaseApp.getApps();
        FirebaseApp app;
        if (firebaseApps != null && !firebaseApps.isEmpty()) {
            app = firebaseApps.get(0);
        } else {
            // String path =
            // getClass().getClassLoader().getResource("serviceAccountKey.json").getFile();
            InputStream serviceAccount = getClass().getClassLoader().getResourceAsStream("serviceAccountKey.json");
            // FileInputStream serviceAccount = new FileInputStream(path);

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://carselling.firebaseio.com")
                    .setStorageBucket("carselling2-78837.appspot.com")
                    .build();

            app = FirebaseApp.initializeApp(options);
        }

        return app;
    }
}
