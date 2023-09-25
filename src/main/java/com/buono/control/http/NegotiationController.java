package com.buono.control.http;

import com.buono.control.model.Negotiation;
import com.buono.control.search.NegotiationSearch;
import com.buono.control.service.NegotiationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/negotiation", produces = "application/json")
public class NegotiationController {

    @Value("${project.name}")
    private String valueApplication;

    @Autowired
    private NegotiationService negotiationService;

    @GetMapping("/findNegotiations")
    public ResponseEntity<?> negotiations(@RequestParam NegotiationSearch negotiationSearch) {
        return new ResponseEntity<List<Negotiation>>(
                this.negotiationService.negotiations(negotiationSearch), HttpStatus.OK);
    }

    @PostMapping("/createNegotiation")
    public ResponseEntity<?> createNegotiations(@RequestBody Negotiation negotiation){
        Negotiation createdNegotiation = this.negotiationService.createNegotiation(negotiation);
        return new ResponseEntity<Negotiation>(createdNegotiation, HttpStatus.OK);
    }
}
