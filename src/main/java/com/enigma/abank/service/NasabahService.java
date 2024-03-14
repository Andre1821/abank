package com.enigma.abank.service;

import com.enigma.abank.dto.request.NasabahRequest;
import com.enigma.abank.dto.response.NasabahResponse;

import java.util.List;

public interface NasabahService {
    NasabahResponse create(NasabahRequest nasabahRequest);
    List<NasabahResponse> getAll();
    NasabahResponse getById(String id);
    NasabahResponse update(NasabahRequest nasabahRequest);
    void delete(String id);
}
