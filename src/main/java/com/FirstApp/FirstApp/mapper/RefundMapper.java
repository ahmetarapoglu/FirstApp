package com.FirstApp.FirstApp.mapper;
import com.FirstApp.FirstApp.dto.RefundDto;
import com.FirstApp.FirstApp.entity.Refund;

public class RefundMapper {
    public static RefundDto mapToRefundDto(Refund refund){

        return new RefundDto(
                refund.getId(),
                refund.getAmount(),
                refund.getPurchase(),
                refund.getCreated()
        );
    }
}
