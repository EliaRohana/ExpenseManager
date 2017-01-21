package com.elia.em;

import com.elia.em.model.*;
import com.elia.em.repository.CounterRepository;
import com.elia.em.repository.MonthlyReportRepository;
import com.elia.em.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Month;

@SpringBootApplication
public class ExpenseManagerApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	@Autowired
	MonthlyReportRepository monthlyReportRepository;
	@Autowired
	CounterRepository counterRepository;
	@Autowired
	ExpenseFactory expenseFactory;
	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExpenseManagerApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {

		//rest db
		userRepository.deleteAll();
		monthlyReportRepository.deleteAll();

		counterRepository.save(new Counter("expenses"));

		User user = new User("elia", "rohana", "rohaelia@gmail.com", passwordEncoder.encode("1234"));
		User user2 = new User("abir", "rohana", "abir@gmail.com", passwordEncoder.encode("1234"));
		user = userRepository.save(user);
		user2 = userRepository.save(user2);
		MonthlyReport monthlyReport = new MonthlyReport("december", Month.DECEMBER, 2016, user.getId());
		monthlyReport = monthlyReportRepository.save(monthlyReport);

		Expense expense1 = expenseFactory.create(10, "banzine", Category.transport.name());
		Expense expense2 = expenseFactory.create(700, "rami levi", Category.food.name());
		monthlyReportRepository.addExpense(expense1, monthlyReport.getId());
		monthlyReportRepository.addExpense(expense2, monthlyReport.getId());
		monthlyReportRepository.addExpense(expenseFactory.create(700, "rami levi", Category.food.name()), monthlyReport.getId());
		monthlyReportRepository.addExpense(expenseFactory.create(700, "rami levi", Category.food.name()), monthlyReport.getId());
//		monthlyReport.addExpense(expense1);
//		monthlyReport.addExpense(expense2);
//		monthlyReport = monthlyReportRepository.save(monthlyReport);
		monthlyReportRepository.updateExpense(monthlyReport.getId(), expense1.getId(), expenseFactory.create(666, "rami levi", Category.food.name()));
		monthlyReportRepository.deleteExpense(monthlyReport.getId(), expense2.getId());



		// fetch all users
		System.out.println("Users found with findAll():");
		System.out.println("-------------------------------");

		for (User muser : userRepository.findAll()) {
			System.out.println("user = " + muser);
		}

		// fetch all users monthly report
		System.out.println("MonthlyReport found with findAll():");
		System.out.println("-------------------------------");
		for (MonthlyReport report : monthlyReportRepository.findAll()) {
			System.out.println("report = " + report);
		}

		monthlyReportRepository.addExpense(expenseFactory.create(50, "bla bla", Category.healthCare.name()), monthlyReport.getId());

		// fetch all users monthly report
		System.out.println("MonthlyReport found with findAll():");
		System.out.println("-------------------------------");
		for (MonthlyReport report : monthlyReportRepository.findAll()) {
			System.out.println("report = " + report);
		}

		// fetch all users
		System.out.println("Users found with find all expenses:");
		System.out.println("-------------------------------");

		long expenseListTotalCost = monthlyReportRepository.getExpenseListTotalCost(monthlyReport.getId());
		System.out.println("expenseListTotalCost = " + expenseListTotalCost);

		System.out.println("find monthly reports by id = " + monthlyReport.getId());
		System.out.println("-------------------------------");
		MonthlyReport one = monthlyReportRepository.findOne(monthlyReport.getId());
		System.out.println("one = " + one);

	}
}
