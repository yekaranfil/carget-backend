package com.ktun.carget.data.domain;

import javax.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.OffsetDateTime;

@Entity
@Getter
@Setter
@Table(name = "rentals")
public class Rental {

    @Id
    @Column(name = "rentalid")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    private String rentalId;
    @Column(name = "vehicleid_fk")
    private String vehicleIdFk;
    @Column(name = "userid_fk")
    private String userIdFk;
    @Column(name = "rental_start_date")
    private OffsetDateTime rentalStartDate;
    @Column(name = "rental_end_date")
    private OffsetDateTime rentalEndDate;
    @Column(name = "created_at")
    private OffsetDateTime createdAt;
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;
}
