package com.asishtech.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorDTO {
    private String apiName;
    private String errorCode;
    private String errorMessage;
    private LocalDateTime errorTime;
}
