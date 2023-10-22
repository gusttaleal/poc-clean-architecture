package org.poc.chain.of.responsibility.core.usecases;

import lombok.RequiredArgsConstructor;
import org.poc.chain.of.responsibility.core.domain.entities.Student;
import org.poc.chain.of.responsibility.core.repositories.StudentRepository;

import java.util.logging.Logger;

@RequiredArgsConstructor
public class PersistStudentOnDatabase {
    private static final String className = PersistStudentOnDatabase.class.getSimpleName();

    private static final Logger log = Logger.getLogger(className);

    private final StudentRepository studentRepository;

    public void execute(final Student student) {
        log.info("[" + className + ":execute] Initiating the process to save Student data with enrollment code: ["
                + student.getEnrollment() + "].");

        studentRepository.persist(student);

        log.info("[" + className + ":execute] The student data has been saved successfully!");
    }
}
