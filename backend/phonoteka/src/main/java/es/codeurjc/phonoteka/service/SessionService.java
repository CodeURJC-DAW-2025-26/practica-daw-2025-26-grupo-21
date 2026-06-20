package es.codeurjc.phonoteka.service;

import org.springframework.stereotype.Service;

@Service
public class SessionService {

    public boolean authenticate(String email, String password) {
        // TODO: implementar autenticación real contra base de datos
        return email != null && password != null
            && !email.isBlank() && !password.isBlank();
    }

    public boolean registerUser(String username, String email, String password) {
        // TODO: implementar registro real contra base de datos
        return username != null && email != null && password != null
            && !username.isBlank() && !email.isBlank() && !password.isBlank();
    }
}
