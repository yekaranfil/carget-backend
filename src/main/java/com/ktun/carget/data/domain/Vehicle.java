package com.ktun.carget.data.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.OffsetDateTime;
@Entity
@Getter
@Setter
@Table(name = "vehicles")
public class Vehicle {

    @Id
    @Column(name = "vehicleid")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid",strategy = "uuid")
    private String vehicleId;
    @Column(name = "vehicle_class")
    private String vehicleClass;
    @Column(name = "vehicle_brand")
    private String vehicleBrand;
    @Column(name = "vehicle_model")
    private String vehicleModel;
    @Column(name = "vehicle_location_fk")
    private String vehicleLocationFk;
    @Column(name = "capacity")
    private String vehicleCapacity;
    @Column(name = "max_distance")
    private String vehicleMaxDistance;
    @Column(name = "vehicle_color")
    private String vehicleColor;
    @Column(name = "vehicle_gearbox")
    private String vehicleGearbox;
    @Column(name = "vehicle_price")
    private String vehiclePrice;
    @Column(name = "vehicle_fuel")
    private String vehicleFuel;
    @Column(name = "vehicle_image")
    private String vehicleImage;
    @Column(name = "created_at")
    private OffsetDateTime createdAt;
    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

}
