package com.FirstApp.FirstApp.model;
import com.FirstApp.FirstApp.entity.Purchase;
import com.FirstApp.FirstApp.entity.Refund;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReportData {
    List<Purchase> purchases;
    List<Refund> refunds;
}
