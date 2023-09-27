package com.buono.control.model;

import com.buono.control.model.modelEnum.SalesEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @ManyToOne
    @JoinColumn(name="assets_id")
    private Assets  assets;

    @NotNull(message = "number of assets purchased or sold required")
    private Integer quantity;
    private Double amountInvested;
    private Double amountAssets;
    private Double dy;
    private Double pvp;
    private Double lastIncome;

    @NotNull(message = "type IN or OUT is necessary (buy or sell)")
    private SalesEnum inOut;

    public Double getEstimatedIncome(){
        return this.lastIncome*quantity;
    }
}
