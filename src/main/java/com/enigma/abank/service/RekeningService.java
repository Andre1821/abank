package com.enigma.abank.service;

import com.enigma.abank.dto.request.RekeningRequest;
import com.enigma.abank.dto.response.RekeningResponse;

import java.util.List;

public interface RekeningService {
    RekeningResponse create(RekeningRequest rekeningRequest);
    List<RekeningResponse> getAll();
    RekeningResponse getById(String id);
    RekeningResponse update(RekeningRequest rekeningRequest);
    void delete(String id);
}
