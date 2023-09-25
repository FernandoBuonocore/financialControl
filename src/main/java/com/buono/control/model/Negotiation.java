package com.buono.control.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.Instant;

@Data
@Entity
public class Negotiation {

    @Id
    private Long id;
    private Instant negotiationDate;
    private Assets  assets;
    private Integer quantity;
    private Double amountInvested;
    private Double amountAssets;
    private Double dy;
    private Double pvp;
    private Double lastIncome;
    private Double estimatedIncome;

}
