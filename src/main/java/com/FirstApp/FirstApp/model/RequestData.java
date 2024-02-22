package com.FirstApp.FirstApp.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestData {
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
