package com.buono.control.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Assets {

    @Id
    private Long id;
    private String name;
}
