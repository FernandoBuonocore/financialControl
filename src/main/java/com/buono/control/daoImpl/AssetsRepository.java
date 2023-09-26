package com.buono.control.daoImpl;

import com.buono.control.model.Assets;
import com.buono.control.model.Negotiation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetsRepository extends JpaRepository<Assets, Long> {
}
