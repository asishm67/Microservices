package com.asishtech.loans.mapper;

import com.asishtech.loans.dto.LoansDTO;
import com.asishtech.loans.entity.Loans;
import org.springframework.stereotype.Component;

@Component
public class LoansMapper {

    public static Loans toLoans(LoansDTO loansDTO,Loans loans) {
        loans.setMobileNumber(loansDTO.getMobileNumber());
        loans.setLoanNumber(loansDTO.getLoanNumber());
        loans.setLoanType(loansDTO.getLoanType());
        loans.setTotalLoan(loansDTO.getTotalLoan());
        loans.setAmountPaid(loansDTO.getAmountPaid());
        loans.setOutstandingAmount(loansDTO.getOutstandingAmount());
        return loans;
    }

    public static LoansDTO toLoansDTO(Loans loans, LoansDTO loansDTO) {
        loansDTO.setMobileNumber(loans.getMobileNumber());
        loansDTO.setLoanNumber(loans.getLoanNumber());
        loansDTO.setLoanType(loans.getLoanType());
        loansDTO.setTotalLoan(loans.getTotalLoan());
        loansDTO.setAmountPaid(loans.getAmountPaid());
        loansDTO.setOutstandingAmount(loans.getOutstandingAmount());
        return loansDTO;
    }
}
