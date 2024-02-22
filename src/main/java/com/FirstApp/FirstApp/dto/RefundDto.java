package com.FirstApp.FirstApp.dto;
import com.FirstApp.FirstApp.entity.Purchase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RefundDto {
    private long id;
    private double amount;
    private Purchase purchase;
    private LocalDateTime created;
}
