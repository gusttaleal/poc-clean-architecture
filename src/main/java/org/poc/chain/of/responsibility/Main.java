package org.poc.chain.of.responsibility;

import org.poc.chain.of.responsibility.core.domain.entities.Student;
import org.poc.chain.of.responsibility.core.domain.usecases.CreateStudentEnrollment;
import org.poc.chain.of.responsibility.core.domain.usecases.PersistStudentOnDatabase;
import org.poc.chain.of.responsibility.core.domain.valueobjects.CPF;
import org.poc.chain.of.responsibility.core.domain.valueobjects.Email;
import org.poc.chain.of.responsibility.infra.database.StudentMongoRepository;
import org.poc.chain.of.responsibility.infra.database.StudentPostgresRepository;

import java.time.LocalDate;
import java.util.Objects;
import java.util.logging.Logger;

public class Main {
    private static final String className = StudentMongoRepository.class.getSimpleName();
    private static final Logger log = Logger.getLogger(className);
    private static final CreateStudentEnrollment createStudentEnrollment = new CreateStudentEnrollment();
    private static final StudentPostgresRepository studentPostgresRepository = new StudentPostgresRepository();
    private static final StudentMongoRepository studentMongoRepository = new StudentMongoRepository();

    public static void main(String[] args) {
        /*Simulation of an infrastructure component*/
        log.info("Application start!");

        PersistStudentOnDatabase persistStudentOnDatabase;
        if (Objects.equals(args[0], "1")) {
            persistStudentOnDatabase = new PersistStudentOnDatabase(studentPostgresRepository);
        } else {
            persistStudentOnDatabase = new PersistStudentOnDatabase(studentMongoRepository);
        }

        Student student = Student
                .builder()
                .cpf(CPF.builder().cpf("000.000.000-00").build())
                .fullName("Gustavo Leal")
                .email(Email.builder().email("gustavo@email.com").build())
                .birthDate(LocalDate.of(1993, 12, 20))
                .build();
        log.info("Student data: [" + student.toString() + "].");

        createStudentEnrollment.execute(student);
        log.info("Updated student data : [" + student + "].");

        persistStudentOnDatabase.execute(student);

        log.info("Application end.");
    }
}