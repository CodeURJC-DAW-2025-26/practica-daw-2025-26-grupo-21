package es.codeurjc.phonoteka.utils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class TemplateData {

    private TemplateData() {
    }

    public static List<String> styles(String... styles) {
        return List.of(styles);
    }

    public static List<String> stars(int fullStars, boolean halfStar) {
        List<String> icons = new ArrayList<>(5);
        for (int i = 0; i < fullStars; i++) {
            icons.add("star");
        }
        if (halfStar) {
            icons.add("star_half");
        }
        while (icons.size() < 5) {
            icons.add("star_border");
        }
        return icons;
    }

    public static Map<String, Object> vinylCard(String title, String artist, String genre, String price,
            String image, String alt, String href) {
        Map<String, Object> card = new LinkedHashMap<>();
        card.put("title", title);
        card.put("artist", artist);
        card.put("genre", genre);
        card.put("price", price);
        card.put("image", image);
        card.put("alt", alt);
        card.put("href", href);
        return card;
    }

    public static Map<String, Object> seller(String username, String avatar, String profileHref,
            List<String> ratingIcons) {
        Map<String, Object> seller = new LinkedHashMap<>();
        seller.put("username", username);
        seller.put("avatar", avatar);
        seller.put("profileHref", profileHref);
        seller.put("ratingIcons", ratingIcons);
        return seller;
    }

    public static Map<String, Object> review(String author, String comment, List<String> ratingIcons) {
        Map<String, Object> review = new LinkedHashMap<>();
        review.put("author", author);
        review.put("comment", comment);
        review.put("ratingIcons", ratingIcons);
        return review;
    }

    public static Map<String, Object> purchaseHistoryItem(String title, String artist, String purchasedOn,
            String sellerName, String statusClass, String statusLabel, String price, String cover,
            String ratingHref, String vinylHref) {
        Map<String, Object> item = new LinkedHashMap<>();
        item.put("title", title);
        item.put("artist", artist);
        item.put("purchasedOn", purchasedOn);
        item.put("sellerName", sellerName);
        item.put("statusClass", statusClass);
        item.put("statusLabel", statusLabel);
        item.put("price", price);
        item.put("cover", cover);
        item.put("ratingHref", ratingHref);
        item.put("vinylHref", vinylHref);
        return item;
    }

    public static Map<String, Object> checkoutItem(String title, String artist, String quantity, String price,
            String cover) {
        Map<String, Object> item = new LinkedHashMap<>();
        item.put("title", title);
        item.put("artist", artist);
        item.put("quantity", quantity);
        item.put("price", price);
        item.put("cover", cover);
        return item;
    }

    public static String vinylHref(int id, boolean logged) {
        return "/vinyl/" + id + (logged ? "?logged=true" : "");
    }
}
