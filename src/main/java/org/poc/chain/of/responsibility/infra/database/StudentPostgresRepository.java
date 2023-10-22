package org.poc.chain.of.responsibility.infra.database;

import org.poc.chain.of.responsibility.core.domain.entities.Student;
import org.poc.chain.of.responsibility.core.repositories.StudentRepository;
import org.poc.chain.of.responsibility.core.domain.valueobjects.CPF;

import java.util.List;
import java.util.logging.Logger;

public class StudentPostgresRepository implements StudentRepository {
    private static final String className = StudentPostgresRepository.class.getSimpleName();
    private static final Logger log = Logger.getLogger(className);

    @Override
    public void persist(Student student) {
        log.info("[" + className + ":persist] Trying to persist student entity.");
        log.info("[" + className + ":execute] Success on persist!");
    }

    @Override
    public Student getStudent(CPF cpf) {
        log.info("[" + className + ":getStudent] Trying to get student data.");
        return null;
    }

    @Override
    public List<Student> getStudents() {
        log.info("[" + className + ":getStudents] Trying to get students data.");
        return null;
    }
}
