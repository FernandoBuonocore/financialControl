package com.buono.control.service;

import com.buono.control.model.Assets;
import com.buono.control.model.Negotiation;
import com.buono.control.search.AssetsSearch;
import com.buono.control.search.NegotiationSearch;

import java.util.List;

public interface AssetsService {

    public List<Assets> listAssets(AssetsSearch assetSearch);

    public Assets createAsset(Assets assets);

}
