package com.buono.control.http;

import com.buono.control.model.Assets;
import com.buono.control.model.Negotiation;
import com.buono.control.search.AssetsSearch;
import com.buono.control.search.NegotiationSearch;
import com.buono.control.service.AssetsService;
import com.buono.control.service.NegotiationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/assets", produces = "application/json")
public class AssetsController {

    @Value("${project.name}")
    private String valueApplication;

    @Autowired
    private AssetsService assetsService;

    @GetMapping("/findAssets")
    public ResponseEntity<?> assets(AssetsSearch assetSearch) {
        try {
            return new ResponseEntity<List<Assets>>(
                    this.assetsService.listAssets(assetSearch), HttpStatus.OK);
        }catch(Exception exception){
            return new ResponseEntity<Object>(exception.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/createAssets")
    public ResponseEntity<?> createAssets(@RequestBody Assets assets){
        Assets createdAsset = this.assetsService.createAsset(assets);
        return new ResponseEntity<Assets>(createdAsset, HttpStatus.OK);
    }
}
