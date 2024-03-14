package com.enigma.abank.controller;

import com.enigma.abank.constant.AppPath;
import com.enigma.abank.dto.request.TransactionRequest;
import com.enigma.abank.dto.response.CommonResponse;
import com.enigma.abank.dto.response.TransactionResponse;
import com.enigma.abank.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(AppPath.TRANSACTION)
public class TransactionController {
    private final TransactionService transactionService;

    @PostMapping
    public ResponseEntity<?> createTransfer(@RequestBody TransactionRequest transactionRequest){
        TransactionResponse transactionResponse = transactionService.transfer(transactionRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CommonResponse.builder()
                        .statusCode(HttpStatus.CREATED.value())
                        .messages("Berhasil transfer")
                        .data(transactionResponse)
                        .build());
    }

    @GetMapping
    public ResponseEntity<?> getAllTransfer() {
        List<TransactionResponse> transactionResponses = transactionService.getAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(CommonResponse.builder()
                        .statusCode(HttpStatus.OK.value())
                        .messages("Berhasil mengakses semua data transaction")
                        .data(transactionResponses)
                        .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable String id){
        TransactionResponse transactionResponse = transactionService.getById(id);
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(CommonResponse.builder()
                        .statusCode(HttpStatus.FOUND.value())
                        .messages("Data Transaction ditemukan")
                        .data(transactionResponse)
                        .build());
    }
}
