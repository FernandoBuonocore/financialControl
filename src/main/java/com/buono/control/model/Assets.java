package com.buono.control.model;

import com.buono.control.model.modelEnum.TypeAssetEnum;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Assets {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;

    @Enumerated
    private TypeAssetEnum typeAssetEnum;
}
