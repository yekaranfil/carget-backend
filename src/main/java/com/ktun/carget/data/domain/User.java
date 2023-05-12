package com.ktun.carget.data.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @Column(name = "userid")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    private String userId;
    @Column(name = "firstname")
    private String userFirstName;
    @Column(name = "lastname")
    private String userLastName;
    @Column(name = "phone")
    private String userPhone;
    @Column(name = "email")
    private String userEmail;
    @Column(name = "age")
    private String userAge;
    @Column(name = "driver_licence")
    private String driverLicence;
    @Column(name = "user_image")
    private String userImage;
    @Column(name = "address")
    private String userAddress;
    @Column(name = "created_at")
    private OffsetDateTime createdAt;
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;
}
