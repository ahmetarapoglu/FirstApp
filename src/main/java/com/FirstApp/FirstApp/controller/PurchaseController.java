package com.FirstApp.FirstApp.controller;
import com.FirstApp.FirstApp.entity.Purchase;
import com.FirstApp.FirstApp.model.PurchaseRequest;
import com.FirstApp.FirstApp.service.PurchaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import com.FirstApp.FirstApp.global.Roles;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/purchases")
public class PurchaseController {

    private final PurchaseService purchaseService;

    @PreAuthorize("hasRole('" + Roles.ADMIN + "')")
    @PostMapping
    public ResponseEntity<Purchase> createPurchaseTransaction(@RequestBody PurchaseRequest purchaseRequest){

        Purchase savedPurchase = purchaseService.createPurchaseTransaction(purchaseRequest);
        return new ResponseEntity<>(savedPurchase, HttpStatus.CREATED);
    }
}
