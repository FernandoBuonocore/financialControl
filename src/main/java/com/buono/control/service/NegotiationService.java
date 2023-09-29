package com.buono.control.service;

import com.buono.control.model.Negotiation;
import com.buono.control.search.NegotiationSearch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NegotiationService {

    public List<Negotiation> negotiations(NegotiationSearch negotiationSearch);

    public Negotiation createNegotiation(Negotiation negotiation);


}
