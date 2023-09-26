package com.buono.control.service.serviceImpl;

import com.buono.control.daoImpl.NegotiationRepository;
import com.buono.control.model.Negotiation;
import com.buono.control.search.NegotiationSearch;
import com.buono.control.service.NegotiationService;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NegotiationImpl implements NegotiationService {

    @Autowired
    private NegotiationRepository negotiationRepository;

    @Override
    public List<Negotiation> negotiations(NegotiationSearch search) {
        List<Negotiation> negotiations = this.negotiationRepository.findAll();

        if(negotiations.isEmpty()){
            throw new NoResultException("No Negotiations found.");
        }
        return negotiations;
    }

    @Override
    public Negotiation createNegotiation(Negotiation negotiation) {
        return this.negotiationRepository.save(negotiation);
    }
}
