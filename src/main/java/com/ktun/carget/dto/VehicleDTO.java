package com.ktun.carget.dto;

import java.time.OffsetDateTime;
import lombok.*;
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleDTO {

    private String vehicleId;

    private String vehicleClass;

    private String vehicleBrand;

    private String vehicleModel;

    private String vehicleLocationFk;

    private String vehicleCapacity;

    private String vehicleMaxDistance;

    private String vehicleColor;

    private String vehicleGearbox;

    private String vehiclePrice;
    private String vehicleFuel;

    private String vehicleImage;

    private OffsetDateTime createdAt = OffsetDateTime.now();

    private OffsetDateTime updatedAt = OffsetDateTime.now();

}
