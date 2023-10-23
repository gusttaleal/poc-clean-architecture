package org.poc.chain.of.responsibility.core.usecases;

import lombok.RequiredArgsConstructor;
import org.poc.chain.of.responsibility.core.domain.entities.Student;
import org.poc.chain.of.responsibility.core.domain.exceptions.ErrorWhenCipherPassword;
import org.poc.chain.of.responsibility.core.domain.service.StudentCipher;
import org.poc.chain.of.responsibility.core.domain.valueobjects.Password;

import java.util.logging.Logger;

@RequiredArgsConstructor
public class CreateStudentPassword {
    private static final String className = CreateStudentPassword.class.getSimpleName();
    private static final Logger log = Logger.getLogger(className);

    private final StudentCipher studentCipher;

    public void execute(final Student student, final String key) throws ErrorWhenCipherPassword {
        log.info("[" + className + ":execute] Initiating the process to cipher Student password.");

        Password password = studentCipher.encrypt(key);
        student.setPassword(password);

        log.info("[" + className + ":execute] The student password has been ciphered successfully!");
    }
}
