package com.FirstApp.FirstApp.controller;
import com.FirstApp.FirstApp.global.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/admin")
public class TestController {

    @PreAuthorize("hasRole('" + Roles.USER + "')")
    @GetMapping
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("sayHello.");
    }
}
