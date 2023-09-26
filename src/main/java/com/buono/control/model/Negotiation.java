package com.buono.control.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
public class Negotiation {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate negotiationDate;

    @OneToOne
    @JoinColumn(name="assets_id", referencedColumnName = "id")
    private Assets  assets;

    private Integer quantity;
    private Double amountInvested;
    private Double amountAssets;
    private Double dy;
    private Double pvp;
    private Double lastIncome;

    //private Double estimatedIncome;

    public Double getEstimatedIncome(){
        return this.lastIncome*quantity;
    }
}
