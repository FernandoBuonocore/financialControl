package com.buono.control.service.serviceImpl;

import com.buono.control.daoImpl.AssetsRepository;
import com.buono.control.daoImpl.NegotiationRepository;
import com.buono.control.model.Assets;
import com.buono.control.model.Negotiation;
import com.buono.control.search.AssetsSearch;
import com.buono.control.search.NegotiationSearch;
import com.buono.control.service.AssetsService;
import com.buono.control.service.NegotiationService;
import jakarta.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetsImpl implements AssetsService {

    @Autowired
    private AssetsRepository assetsRepository;


    @Override
    public List<Assets> listAssets(AssetsSearch assetSearch) {
        List<Assets> assets = this.assetsRepository.findAll();

        if(assets.isEmpty()){
            throw new NoResultException("No Assets found.");
        }
        return assets;
    }

    @Override
    public Assets createAsset(Assets assets) {
        return this.assetsRepository.save(assets);
    }
}
