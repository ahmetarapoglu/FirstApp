package com.FirstApp.FirstApp.controller;
import com.FirstApp.FirstApp.global.Roles;
import com.FirstApp.FirstApp.dto.RefundDto;
import com.FirstApp.FirstApp.model.RefundRequest;
import com.FirstApp.FirstApp.service.RefundService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/refunds")
public class RefundController {

    private final RefundService refundService;

    @PreAuthorize("hasRole('" + Roles.ADMIN + "')")
    @PostMapping
    public ResponseEntity<RefundDto> createPurchaseTransaction(@RequestBody RefundRequest refundRequest){

        RefundDto savedRefund = refundService.createRefundTransaction(refundRequest);

        return new ResponseEntity<>(savedRefund, HttpStatus.CREATED);
    }

}
