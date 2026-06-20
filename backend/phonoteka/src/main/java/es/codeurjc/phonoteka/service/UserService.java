package es.codeurjc.phonoteka.service;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import static es.codeurjc.phonoteka.utils.TemplateData.purchaseHistoryItem;
import static es.codeurjc.phonoteka.utils.TemplateData.review;
import static es.codeurjc.phonoteka.utils.TemplateData.stars;
import static es.codeurjc.phonoteka.utils.TemplateData.vinylCard;
import static es.codeurjc.phonoteka.utils.TemplateData.vinylHref;

@Service
public class UserService {

    public String getUsername() {
        return "a.morales.2019";
    }

    public String getMemberSince() {
        return "Miembro desde Jul 2025";
    }

    public int getSalesCount() {
        return 12;
    }

    public int getRatingsCount() {
        return 5;
    }

    public List<String> getRatingIcons() {
        return stars(4, true);
    }

    public String getProfileAvatar() {
        return "https://i.pravatar.cc/150?u=a.morales.2019";
    }

    public List<Map<String, Object>> getSellingVinyls() {
        return List.of(
            vinylCard("AM", "Arctic Monkeys", "Indie Rock", "33,50 €",
                "https://picsum.photos/seed/profile1/400/400", "Portada de AM", vinylHref(15, true)),
            vinylCard("Currents", "Tame Impala", "Psychedelic Pop", "38,00 €",
                "https://picsum.photos/seed/profile2/400/400", "Portada de Currents", vinylHref(19, true)),
            vinylCard("Is This It", "The Strokes", "Indie Rock", "25,00 €",
                "https://picsum.photos/seed/profile3/400/400", "Portada de Is This It", vinylHref(16, true)));
    }

    public List<Map<String, Object>> getReceivedReviews() {
        return List.of(
            review("GrooveGuardian",
                "El vinilo llegó en perfecto estado y muy rápido. ¡Vendedor muy recomendable!",
                stars(4, false)),
            review("WaxWizard", "¡Una joya! Comunicación excelente.", stars(5, false)));
    }

    public List<Map<String, Object>> getPurchaseHistory() {
        return List.of(
            purchaseHistoryItem("Nevermind", "Nirvana", "14/04/2026", "WaxWizard", "delivered",
                "Entregado", "29,90 €", "https://picsum.photos/seed/order1/120/120",
                "/transaction/leave-rating", vinylHref(4, true)),
            purchaseHistoryItem("Abbey Road", "The Beatles", "05/04/2026", "SpinMaster", "shipping",
                "En reparto", "28,50 €", "https://picsum.photos/seed/order2/120/120",
                "/transaction/leave-rating", vinylHref(2, true)),
            purchaseHistoryItem("Random Access Memories", "Daft Punk", "23/03/2026", "ClassicCuts",
                "delivered", "Entregado", "31,20 €", "https://picsum.photos/seed/order3/120/120",
                "/transaction/leave-rating", vinylHref(8, true)));
    }
}
