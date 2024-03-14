package com.enigma.abank.service.impl;

import com.enigma.abank.dto.request.RekeningRequest;
import com.enigma.abank.dto.response.RekeningResponse;
import com.enigma.abank.repository.RekeningRepository;
import com.enigma.abank.service.RekeningService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class RekeningServiceImpl implements RekeningService {
    private final RekeningRepository rekeningRepository;

    @Override
    public RekeningResponse create(RekeningRequest rekeningRequest) {
        return rekeningRepository.create(rekeningRequest);
    }

    @Override
    public List<RekeningResponse> getAll() {
        return rekeningRepository.getAll();
    }

    @Override
    public RekeningResponse getById(String id) {
        RekeningResponse currentRekening = rekeningRepository.getById(id);
        if (currentRekening == null) throw new NoSuchElementException("Rekening dengan ID " + id + " tidak ditemukan");
        return rekeningRepository.getById(id);
    }

    @Override
    public RekeningResponse update(RekeningRequest rekeningRequest) {
        RekeningResponse currentRekening = getById(rekeningRequest.getId());
        return rekeningRepository.update(rekeningRequest);
    }

    @Override
    public void delete(String id) {
        RekeningResponse currentRekening = getById(id);
        rekeningRepository.delete(id);
    }
}
