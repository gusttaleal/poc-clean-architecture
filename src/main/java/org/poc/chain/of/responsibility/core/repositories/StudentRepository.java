package org.poc.chain.of.responsibility.core.repositories;

import org.poc.chain.of.responsibility.core.domain.entities.Student;
import org.poc.chain.of.responsibility.core.domain.valueobjects.CPF;

import java.util.List;

public interface StudentRepository {
    void persist(Student student);

    Student getStudent(CPF cpf);

    List<Student> getStudents();
}
