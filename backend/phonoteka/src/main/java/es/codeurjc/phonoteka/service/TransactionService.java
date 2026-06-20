package es.codeurjc.phonoteka.service;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import static es.codeurjc.phonoteka.utils.TemplateData.checkoutItem;

@Service
public class TransactionService {

    public List<Map<String, Object>> getOrderItems() {
        return List.of(
            checkoutItem("Nevermind", "Nirvana", "1", "29,90 €",
                "https://picsum.photos/seed/order1/120/120"),
            checkoutItem("Abbey Road", "The Beatles", "1", "28,50 €",
                "https://picsum.photos/seed/order2/120/120"),
            checkoutItem("Random Access Memories", "Daft Punk", "1", "31,20 €",
                "https://picsum.photos/seed/order3/120/120"));
    }

    public String getSubtotal() {
        return "89,60 €";
    }

    public String getShipping() {
        return "4,50 €";
    }

    public String getTotal() {
        return "94,10 €";
    }
}
