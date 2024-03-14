package com.enigma.abank.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class TransactionRequest {
    private Integer nominal;
    private String idRekeningSender;
    private String idRekeningRecipient;
}
