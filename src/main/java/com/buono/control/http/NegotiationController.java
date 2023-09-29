package com.buono.control.http;

import com.buono.control.model.Negotiation;
import com.buono.control.model.modelEnum.SalesEnum;
import com.buono.control.search.NegotiationSearch;
import com.buono.control.service.NegotiationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/negotiation", produces = "application/json")
public class NegotiationController {

    @Value("${project.name}")
    private String valueApplication;

    @Autowired
    private NegotiationService negotiationService;

    @GetMapping("/findNegotiations")
    public ResponseEntity<?> negotiations(NegotiationSearch negotiationSearch) {
        try {
            return new ResponseEntity<List<Negotiation>>(
                    this.negotiationService.negotiations(negotiationSearch), HttpStatus.OK);
        } catch(Exception exception){
            return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/balance")
    public ResponseEntity<?> calculateValues(){
        List<Negotiation> findAll = this.negotiationService.negotiations(null);
        Map<SalesEnum, Double> groupByinOUt = findAll.stream().collect(
                Collectors.groupingBy(Negotiation::getInOut, Collectors.summingDouble(
                        Negotiation::getQuantity)));
        return new ResponseEntity<Object>( groupByinOUt, HttpStatus.OK);
    }

    @PostMapping("/createNegotiation")
    public ResponseEntity<?> createNegotiations(@Valid @RequestBody Negotiation negotiation){
        Negotiation createdNegotiation = this.negotiationService.createNegotiation(negotiation);
        return new ResponseEntity<Negotiation>(createdNegotiation, HttpStatus.OK);
    }
}
