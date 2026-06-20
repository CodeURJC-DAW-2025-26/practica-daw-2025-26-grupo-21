package es.codeurjc.phonoteka.service;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    public Map<String, Object> getDashboardStats() {
        // TODO: obtener estadísticas reales de la base de datos
        return Map.of(
            "totalUsers", 156,
            "totalVinyls", 432,
            "totalTransactions", 89,
            "revenue", "2.847,50 €"
        );
    }

    public List<Map<String, Object>> getAllUsers() {
        // TODO: obtener usuarios reales de la base de datos
        return List.of(
            Map.of("username", "a.morales.2019", "email", "adrian@email.com", "role", "user"),
            Map.of("username", "SpinMaster", "email", "spin@email.com", "role", "user"),
            Map.of("username", "VinylVortex", "email", "vortex@email.com", "role", "user")
        );
    }

    public List<Map<String, Object>> getAllVinyls() {
        // TODO: obtener vinilos reales de la base de datos
        return List.of(
            Map.of("title", "The Dark Side of the Moon", "artist", "Pink Floyd", "price", "35,00 €"),
            Map.of("title", "Abbey Road", "artist", "The Beatles", "price", "28,50 €"),
            Map.of("title", "Nevermind", "artist", "Nirvana", "price", "29,90 €")
        );
    }
}
