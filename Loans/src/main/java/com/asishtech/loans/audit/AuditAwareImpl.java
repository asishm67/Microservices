package com.asishtech.loans.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {
    //this method will return the current user
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("LOANS_SYSTEM");
    }
}
