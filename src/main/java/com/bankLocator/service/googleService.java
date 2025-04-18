package com.bankLocator.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bankLocator.model.latLon;

@Service
public class googleService {

    private static final String API_KEY = "YOUR_GOOGLE_API_KEY";

    public static latLon getCoordinatesFromZip(String zipcode) {
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address="
                + zipcode + "&key=" + API_KEY;

        RestTemplate restTemplate = new RestTemplate();
        Map response = restTemplate.getForObject(url, Map.class);
        List results = (List) response.get("results");
        if (!results.isEmpty()) {
            Map geometry = (Map) ((Map) results.get(0)).get("geometry");
            Map location = (Map) geometry.get("location");
            double lat = (double) location.get("lat");
            double lng = (double) location.get("lng");
            return new latLon(lat, lng);
        }
        return null;
    }
}
