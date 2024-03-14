package com.enigma.abank.service;

import com.enigma.abank.dto.request.TransactionRequest;
import com.enigma.abank.dto.response.TransactionResponse;

import java.util.List;

public interface TransactionService {
    TransactionResponse transfer (TransactionRequest transactionRequest);
    List<TransactionResponse> getAll();
    TransactionResponse getById (String id);
}
