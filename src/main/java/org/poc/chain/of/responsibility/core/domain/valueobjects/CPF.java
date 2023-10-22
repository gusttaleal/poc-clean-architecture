package org.poc.chain.of.responsibility.core.domain.valueobjects;

import lombok.Builder;
import lombok.Data;
import org.poc.chain.of.responsibility.core.domain.exceptions.InvalidCPF;

import java.util.Objects;

@Data
@Builder
public class CPF {
    private String cpf;

    public CPF(final String cpf) {
        validate(cpf);
        this.cpf = cpf;
    }

    private void validate(final String cpf) {
        boolean isValid = !Objects.isNull(cpf) && cpf.matches(
                "[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}\\-[0-9]{2}");
        if (!isValid)
            throw new InvalidCPF("The CPF number: [" + cpf + "] "
                    + "is invalid. Try format on this way: [000.000.000-00].");
    }
}
