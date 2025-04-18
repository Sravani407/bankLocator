package com.bankLocator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bankLocator.model.bankModel;
import com.bankLocator.service.*;

@RestController
@RequestMapping("/api/banks")
public class bankController {

    @Autowired
    private bankService bankService;

    @GetMapping
    public ResponseEntity<List<bankModel>> getNearbyBanks(@RequestParam String zipcode) {
        return ResponseEntity.ok(bankService.findNearbyBanks(zipcode));
    }
}
