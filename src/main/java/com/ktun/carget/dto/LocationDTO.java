package com.ktun.carget.dto;

import lombok.*;

import java.time.OffsetDateTime;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationDTO {
    private String locationId;

    private String locationName;

    private OffsetDateTime createdAt = OffsetDateTime.now();

    private OffsetDateTime updatedAt = OffsetDateTime.now();


}
