package com.example.demo;

import com.example.demo.entity.employee;
import com.example.demo.repository.employeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// 															Run This Code to Insert 100 Random Records to Test Pagination


//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.Random;
//
//@Component
//class EmployeeDataInitializer {
//
//	private final employeeRepository repository;
//
//	public EmployeeDataInitializer(employeeRepository repository) {
//		this.repository = repository;
//	}
//
//	@PostConstruct
//	public void init() {
//		Random random = new Random();
//		String[] jobTitles = {"Software Engineer", "Product Manager", "Sales Representative", "Accountant", "Marketing Specialist"};
//		String[] cities = {"New York", "London", "Paris", "Tokyo", "Sydney"};
//		String[] states = {"NY", "CA", "TX", "FL", "IL"};
//
//		for (int i = 0; i < 100; i++) {
//			employee emp = new employee();
//			emp.setFullName(generateRandomString());
//			emp.setJobTitle(jobTitles[random.nextInt(jobTitles.length)]);
//			emp.setPhoneNumber(generateRandomPhoneNumber());
//			emp.setEmail(generateRandomEmail());
//			emp.setAddress(generateRandomString());
//			emp.setCity(cities[random.nextInt(cities.length)]);
//			emp.setState(states[random.nextInt(states.length)]);
//			emp.setPrimaryEmergencyContact(generateRandomString());
//			emp.setPrimaryEmergencyContactPhone(generateRandomPhoneNumber());
//			emp.setPrimaryEmergencyContactRelationship(generateRandomString());
//			emp.setSecondaryEmergencyContact(generateRandomString());
//			emp.setSecondaryEmergencyContactPhone(generateRandomPhoneNumber());
//			emp.setSecondaryEmergencyContactRelationship(generateRandomString());
//
//			repository.save(emp);
//		}
//
//		System.out.println("Employee records inserted successfully!");
//	}
//
//	private String generateRandomString() {
//		int length = 8;
//		String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
//		StringBuilder randomString = new StringBuilder();
//
//		Random random = new Random();
//		for (int i = 0; i < length; i++) {
//			int index = random.nextInt(characters.length());
//			randomString.append(characters.charAt(index));
//		}
//
//		return randomString.toString();
//	}
//
//	private String generateRandomPhoneNumber() {
//		StringBuilder phoneNumber = new StringBuilder();
//
//		Random random = new Random();
//		phoneNumber.append("+");
//
//		// Generate country code
//		int countryCode = 1 + random.nextInt(90);
//		phoneNumber.append(countryCode);
//
//		// Generate area code
//		int areaCode = 100 + random.nextInt(900);
//		phoneNumber.append(areaCode);
//
//		// Generate local number
//		for (int i = 0; i < 7; i++) {
//			int digit = random.nextInt(10);
//			phoneNumber.append(digit);
//		}
//
//		return phoneNumber.toString();
//	}
//
//	private String generateRandomEmail() {
//		String[] domains = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com"};
//		StringBuilder email = new StringBuilder();
//
//		Random random = new Random();
//
//		// Generate random alphanumeric string as username
//		email.append(generateRandomString());
//
//		// Append domain name
//		email.append("@");
//		email.append(domains[random.nextInt(domains.length)]);
//
//		return email.toString();
//	}
//}

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
