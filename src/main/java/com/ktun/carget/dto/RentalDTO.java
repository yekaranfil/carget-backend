package com.ktun.carget.dto;

import java.time.OffsetDateTime;
import lombok.*;

import javax.persistence.Column;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RentalDTO {

    private String rentalId;
    private String vehicleIdFk;
    private String userIdFk;
    private OffsetDateTime rentalStartDate;
    private OffsetDateTime rentalEndDate;
    private Boolean navigation;
    private Boolean driverService;
    private Boolean babySeat;
    private Boolean ecoInsurance;
    private Boolean detailingInsurance;
    private Boolean cash;
    private Boolean transfer;
    private Boolean creditCard;
    private OffsetDateTime createdAt = OffsetDateTime.now();
    private OffsetDateTime updatedAt = OffsetDateTime.now();

}
