package com.asishtech.loans.controller;

import com.asishtech.loans.constants.LoansConstants;
import com.asishtech.loans.dto.LoansDTO;
import com.asishtech.loans.dto.ResponseDTO;
import com.asishtech.loans.service.LoansService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping(value = "/api", produces = "application/json")
@RequiredArgsConstructor
public class LoansController {
    private final LoansService loansService;


    @PostMapping("/create-loan")
    public ResponseEntity<ResponseDTO> createLoan(@RequestParam
                                                      @Pattern(regexp = "([0-9]{10})", message = "Mobile number must be 10 digits")
                                                      String mobileNumber) {
        loansService.createLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(LoansConstants.STATUS_201, LoansConstants.MESSAGE_201) );
    }

    @GetMapping("/fetch-loan")
    public ResponseEntity<LoansDTO> fetchLoanDetails(@RequestParam
                                                     @Pattern(regexp = "([0-9]{10})", message = "Mobile number must be 10 digits")
                                                     String mobileNumber) {
        LoansDTO loansDto = loansService.fetchLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(loansDto);
    }


    @PutMapping("/update-loan")
    public ResponseEntity<ResponseDTO> updateLoanDetails(@Valid @RequestBody LoansDTO loansDto) {
        boolean isUpdated = loansService.updateLoan(loansDto);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDTO(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete-loan")
    public ResponseEntity<ResponseDTO> deleteLoanDetails(@RequestParam
                                                         @Pattern(regexp="(^$|[0-9]{10})",message = "Mobile number must be 10 digits")
                                                         String mobileNumber) {
        boolean isDeleted = loansService.deleteLoan(mobileNumber);
        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDTO(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDTO(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_DELETE));
        }
    }
}
