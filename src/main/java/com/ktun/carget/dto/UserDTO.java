package com.ktun.carget.dto;

import java.time.OffsetDateTime;
import lombok.*;
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO {

    private String userId;

    private String userFirstName;

    private String userLastName;

    private String userPhone;

    private String userEmail;

    private String userAge;

    private String driverLicence;

    private String userImage;

    private String userAddress;

    private OffsetDateTime createdAt =  OffsetDateTime.now();

    private OffsetDateTime updatedAt = OffsetDateTime.now();
}
