package com.jsp.hotelmanagementapp.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import com.jsp.hotelmanagementapp.daoimplementation.DaoImplementation;
import com.jsp.hotelmanagementapp.dao.Dao;

public class View {

	public static void main(String[] args) throws SQLException {

		String url = "jdbc:mysql://localhost:3306/hotel_db";
		String userName = "root";
		String password = "Monu@2002";
		Scanner scanner = new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("drivers load successfully    ..........");
		} catch (ClassNotFoundException e) {
			System.out.println("class notfound exception occurs");
		}
		try {
			Connection connection = DriverManager.getConnection(url, userName, password);

			System.out.println("connection established");
			boolean exit = false;

			System.out.println(
					"------------------====================welcome to Hotel Management system=======--------------");
			Dao dao = new DaoImplementation();
			while (!exit) {
				System.out.println("Enter the option for Doing the Task");
				System.out.println("1. new Reservation");
				System.out.println("2. view Reservations");
				System.out.println("3. get room Number");
				System.out.println("4. update Reservation");
				System.out.println("5. delete Reservation");
				System.out.println("6. Exit");

				int option = scanner.nextInt();
				switch (option) {
				case 1:
					dao.newReservation(connection, scanner);
					break;
				case 2:
					dao.viewReservations(connection);
					break;
				case 3:
					dao.getRoomNumber(connection, scanner);
					break;
				case 4:
					dao.updateReservation(connection, scanner);
					break;
				case 5:
					dao.deleteReservation(connection, scanner);
					break;
				case 6:
					dao.exit();
					exit = true;
					break;

				default:
					System.out.println("Wrong Option......Chose a right option");
					break;
				}
			}

		} catch (SQLException e) {
			// TODO: handle exception
		}

		System.out.println("thanku for using the hotel management system .......for more inforamtion contact :");
		System.out.println("📩  monughorela2002@gmail.com");
		System.out.println("📞  +91 6377730881");
	}

}
