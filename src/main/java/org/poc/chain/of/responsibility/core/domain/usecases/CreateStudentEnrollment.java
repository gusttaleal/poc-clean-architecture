package org.poc.chain.of.responsibility.core.domain.usecases;

import org.poc.chain.of.responsibility.core.domain.entities.Student;

import java.util.UUID;
import java.util.logging.Logger;

public class CreateStudentEnrollment {
    private static final String className = CreateStudentEnrollment.class.getSimpleName();
    private static final Logger log = Logger.getLogger(className);

    public void execute(final Student student) {
        log.info("[" + className + ":execute] Initiating the process to create Student enrollment.");

        String enrollment = UUID.randomUUID().toString().split("\\-")[0];
        student.setEnrollment(enrollment);

        log.info("[" + className + ":execute] The student enrollment: ["
                + student.getEnrollment() + "] has been created successfully!");
    }
}
