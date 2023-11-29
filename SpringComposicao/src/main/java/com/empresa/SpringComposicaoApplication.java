package com.empresa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.empresa.model.Course;
import com.empresa.model.Enrollment;
import com.empresa.model.Student;
import com.empresa.repository.CourseRepository;
import com.empresa.repository.EnrollmentRepository;
import com.empresa.repository.StudentRepository;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SpringComposicaoApplication {

	public static void main(String[] args) {
        SpringApplication.run(SpringComposicaoApplication.class, args);
    }

	@Bean
    public CommandLineRunner demo(StudentRepository studentRepository, CourseRepository courseRepository,
                                  EnrollmentRepository enrollmentRepository) {
        return args -> {
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n------ Menu ------");
                System.out.println("1. Criar Estudante");
                System.out.println("2. Ver Estudantes");
                System.out.println("3. Criar Cursos");
                System.out.println("4. Ver Cursos");
                System.out.println("5. Matricular Estudante em Curso");
                System.out.println("6. Ver Matricular");
                System.out.println("7. Sair");
                System.out.print("Escolha sua opção: ");

                choice = scanner.nextInt();
                scanner.nextLine();  // Consumir a quebra de linha

                switch (choice) {
                    case 1:
                        createStudent(studentRepository, scanner);
                        break;
                    case 2:
                        viewStudents(studentRepository);
                        break;
                    case 3:
                        createCourse(courseRepository, scanner);
                        break;
                    case 4:
                        viewCourses(courseRepository);
                        break;
                    case 5:
                        enrollStudentInCourse(studentRepository, courseRepository, enrollmentRepository, scanner);
                        break;
                    case 6:
                        viewEnrollments(enrollmentRepository);
                        break;
                    case 7:
                        System.out.println("Saindo do Sistema. Fim!");
                        break;
                    default:
                        System.out.println("Opção Inválida. Tente novamente.");
                }
            } while (choice != 7);
        };
    }

    private void createStudent(StudentRepository studentRepository, Scanner scanner) {
        System.out.print("Enter com nome do Estudante: ");
        String name = scanner.nextLine();

        Student student = new Student(name);
        studentRepository.save(student);

        System.out.println("Estudante Criado com Sucesso.");
    }

    private void viewStudents(StudentRepository studentRepository) {
        List<Student> students = studentRepository.findAll();

        System.out.println("\n------ Estudante ------");
        for (Student student : students) {
            System.out.println("ID: " + student.getId() + ", Nome: " + student.getName());
        }
    }

    private void createCourse(CourseRepository courseRepository, Scanner scanner) {
        System.out.print("Enter com nome do Curso: ");
        String name = scanner.nextLine();

        Course course = new Course(name);
        courseRepository.save(course);

        System.out.println("Curso Criado com Sucesso.");
    }

    private void viewCourses(CourseRepository courseRepository) {
        List<Course> courses = courseRepository.findAll();

        System.out.println("\n------ Cursos ------");
        for (Course course : courses) {
            System.out.println("ID: " + course.getId() + ", Nome: " + course.getName());
        }
    }

    private void enrollStudentInCourse(StudentRepository studentRepository, CourseRepository courseRepository,
                                       EnrollmentRepository enrollmentRepository, Scanner scanner) {
        System.out.print("Enter com ID do Estudante: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha

        System.out.print("Enter com ID do Curso: ");
        int courseId = scanner.nextInt();
        scanner.nextLine();  // Consumir a quebra de linha

        Student student = studentRepository.findById((long) studentId).orElse(null);
        Course course = courseRepository.findById((long) courseId).orElse(null);

        if (student != null && course != null) {
            Enrollment enrollment = new Enrollment(student, course);
            enrollmentRepository.save(enrollment);

            System.out.println("Estudante matriculado no curso com sucesso.");
        } else {
            System.out.println("Estudante ou Curso não encontrado.");
        }
    }

    private void viewEnrollments(EnrollmentRepository enrollmentRepository) {
        List<Enrollment> enrollments = enrollmentRepository.findAll();

        System.out.println("\n------ Matrícula ------");
        for (Enrollment enrollment : enrollments) {
            System.out.println("ID: " + enrollment.getId() +
                    ", Estudante: " + enrollment.getStudent().getName() +
                    ", Curso: " + enrollment.getCourse().getName() +
                    ", Data da Matrícula: " + enrollment.getEnrollmentDate());
        }
    }
}