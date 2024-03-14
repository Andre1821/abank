package com.enigma.abank.service.impl;

import com.enigma.abank.dto.request.NasabahRequest;
import com.enigma.abank.dto.response.NasabahResponse;
import com.enigma.abank.repository.NasabahRepository;
import com.enigma.abank.service.NasabahService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class NasabahServiceImpl implements NasabahService {
    private final NasabahRepository nasabahRepository;

    @Override
    public NasabahResponse create(NasabahRequest nasabahRequest) {
        return nasabahRepository.create(nasabahRequest);
    }

    @Override
    public List<NasabahResponse> getAll() {
        return nasabahRepository.getAll();
    }

    @Override
    public NasabahResponse getById(String id) {
        NasabahResponse currentNasabah = nasabahRepository.getById(id);
        if (currentNasabah == null) throw new NoSuchElementException("Nasabah dengan ID " + id + " tidak ditemukan");

        return currentNasabah;
    }

    @Override
    public NasabahResponse update(NasabahRequest nasabahRequest) {
        NasabahResponse currentNasabah = getById(nasabahRequest.getId());
        if (currentNasabah == null) throw new NoSuchElementException("Nasabah dengan ID " + nasabahRequest.getId() + " tidak ditemukan");
        return nasabahRepository.update(nasabahRequest);
    }

    @Override
    public void delete(String id) {
        NasabahResponse currentNasabah = getById(id);
        if (currentNasabah == null) throw new NoSuchElementException("Nasabah dengan ID " + id + " tidak ditemukan");
        nasabahRepository.deleteById(id);
    }
}
