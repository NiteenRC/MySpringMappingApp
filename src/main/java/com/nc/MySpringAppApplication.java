package com.nc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.nc.composite.repositories.AccountRepository;
import com.nc.composite.repositories.EmployeeRepository;
import com.nc.entity.composite.Account;
import com.nc.entity.composite.AccountId;
import com.nc.entity.composite.Employee;
import com.nc.entity.composite.EmployeeId;
import com.nc.entity.many2many.Course;
import com.nc.entity.many2many.Student;
import com.nc.entity.one2many.Book;
import com.nc.entity.one2many.Page;
import com.nc.entity.one2one.Address;
import com.nc.entity.one2one.User;
import com.nc.entity.one2one.UserDetails;
import com.nc.repository.many2many.CourseRepository;
import com.nc.repository.many2many.StudentRepository;
import com.nc.repository.one2many.BookRepository;
import com.nc.repository.one2many.PageRepository;
import com.nc.repository.one2one.AddressRepository;
import com.nc.repository.one2one.UserDetailsRepository;
import com.nc.repository.one2one.UserRepository;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class MySpringAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySpringAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(AccountRepository accountRepository, EmployeeRepository employeeRepository,
			BookRepository bookRepository, PageRepository pageRepository, StudentRepository studentRepository,
			CourseRepository courseRepository, UserRepository userRepository, AddressRepository addressRepository,
			UserDetailsRepository userDetailsRepository) {
		return args -> {

			// ======= IdClass Annotation =======
			accountRepository.save(new Account("458666", "Checking", 4588));// create new accounts
			accountRepository.save(new Account("458689", "Checking", 2500));
			accountRepository.save(new Account("424265", "Saving", 100000));

			// fetch accounts by a given type
			List<Account> accounts = accountRepository.findByAccountType("Checking");
			accounts.forEach(System.out::println);

			// fetch account by composite key
			Optional<Account> account = accountRepository.findById(new AccountId("424265", "Saving"));
			account.ifPresent(System.out::println);

			// ======= EmbeddedId Annotation =======
			// create new employees
			employeeRepository.save(new Employee(new EmployeeId(100L, 10L), "John Doe", "john@example.com", "123456"));
			employeeRepository.save(new Employee(new EmployeeId(101L, 20L), "Emma Ali", "emma@example.com", "654321"));

			// fetch employees by a given department id
			List<Employee> employees = employeeRepository.findByEmployeeIdDepartmentId(20L);
			employees.forEach(System.out::println);

			// fetch employee by composite key
			Optional<Employee> employee = employeeRepository.findById(new EmployeeId(100L, 10L));
			employee.ifPresent(System.out::println);

			// ======= One2Many Annotation =======
			// create a new book
			Book book1 = new Book("Java 101", "John Doe", "BK_156");
			Book book2 = new Book("Wings of Fire", "APJ", "BK_457");
			// create new pages
			Page page1 = new Page("Introduction contents", "Introduction", book1);
			Page page2 = new Page("Java 8 contents", "Java 8", book1);
			Page page3 = new Page("Concurrency contents", "Concurrency", book1);
			Page page4 = new Page("Objectives", "Introduction", book2);
			Page page5 = new Page("Preface", "Wings", book2);
			// set all pages to book
			book1.setPages(Arrays.asList(page1, page2, page3));
			book2.setPages(Arrays.asList(page4, page5));

			bookRepository.save(book1);// Saves books and pages
			bookRepository.save(book2);// Saves books and pages

			// ======= Many2Many Annotation =======
			Student student = new Student("John Doe", 15, "8th");// create a student
			studentRepository.save(student); // save the student. Note this save once again save required with course

			// create three courses
			Course course1 = new Course("Machine Learning", "ML", 12, 1500);
			Course course2 = new Course("Database Systems", "DS", 8, 800);
			Course course3 = new Course("Web Basics", "WB", 10, 0);

			courseRepository.saveAll(Arrays.asList(course1, course2, course3));// save courses
			student.getCourses().addAll(Arrays.asList(course1, course2, course3));// add courses to the student

			studentRepository.save(student);// update the student

			// ======= One2One Annotation =======
			Address address = new Address("3rd cross", "Bangalore", "Karnataka", "560068", "India");
			UserDetails userDetails = new UserDetails("M");
			User user = new User("Niteen", "niteen2010@gmail.com", "xyz");

			user.setAddress(address);// associate the address object
			user.setUserDetails(userDetails);// associate the userDetails object
			userDetails.setUser(user);// bi-directional
			userRepository.save(user);// when we get userDetails then hibernate saves user info as well

		};
	}
}
