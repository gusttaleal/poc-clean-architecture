package org.poc.chain.of.responsibility.core.domain.valueobjects;

import org.poc.chain.of.responsibility.core.domain.exceptions.CPFException;

public class CPF {
    private final String cpf;

    public CPF(final String cpf) throws CPFException {
        if (validate(cpf)) {
            this.cpf = cpf;
        } else {
            throw new CPFException("The CPF number is invalid. Try format on this way: 000.000.000-00");
        }
    }

    public String getCpf() {
        return cpf;
    }

    private boolean validate(final String cpf) {
        return cpf.matches("[0-9]{3}\\.?[0-9]{3}\\.?[0-9]{3}\\-?[0-9]{2}");
    }

    @Override
    public String toString() {
        return "CPF[" +
                "cpf='" + cpf + '\'' +
                ']';
    }
}
