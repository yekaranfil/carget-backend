package com.ktun.carget.dto;

import java.time.OffsetDateTime;
import lombok.*;
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

    private OffsetDateTime createdAt = OffsetDateTime.now();

    private OffsetDateTime updatedAt = OffsetDateTime.now();
}
