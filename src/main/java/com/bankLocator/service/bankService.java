package com.bankLocator.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.bankLocator.model.bankModel;
import com.bankLocator.model.latLon;

@Service
public class bankService {

    @Autowired
    private googleService geoService;

    private static final String API_KEY = "YOUR_GOOGLE_API_KEY";

    public List<bankModel> findNearbyBanks(String zipcode) {
    	latLon location = googleService.getCoordinatesFromZip(zipcode);
        return getNearbyPlaces(location);
    }

    private List<bankModel> getNearbyPlaces(latLon location) {
        String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/json"
                + "?location=" + location.getLat() + "," + location.getLng()
                + "&radius=16093" // 10 miles in meters
                + "&type=bank"
                + "&key=" + API_KEY;

        RestTemplate restTemplate = new RestTemplate();
        Map response = restTemplate.getForObject(url, Map.class);

        List<Map> results = (List<Map>) response.get("results");
        List<bankModel> banks = new ArrayList<>();
        for (Map result : results) {
            String name = (String) result.get("name");
            String address = (String) result.get("vicinity");
            banks.add(new bankModel(name, address));
        }
        return banks;
    }
}
