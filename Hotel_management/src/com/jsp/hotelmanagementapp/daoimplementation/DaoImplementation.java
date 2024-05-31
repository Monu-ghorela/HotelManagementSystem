package com.jsp.hotelmanagementapp.daoimplementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jsp.hotelmanagementapp.dao.Dao;

public class DaoImplementation implements Dao {

	@Override
	public boolean newReservation(Connection c, Scanner s) {

		try {
			Statement statement = c.createStatement();

			System.out.println("Enter the guest name");
			s.nextLine();
			String name = s.nextLine();

			System.out.println("Enter the room number to allot");
			int room_number = s.nextInt();
			System.out.println("Enter the contact  number of the guest");
			long phno = s.nextLong();
			String query = "INSERT INTO reservations(guest_name,room_no,contact_number) VALUES('" + name + "',"
					+ room_number + "," + phno + ");";
			statement.executeUpdate(query);
			System.out.println("reservation successfull");
			System.out.println("========================");
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("reservation failed");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return false;

	}

	@Override
	public void viewReservations(Connection c) {
		try {
			Statement statement = c.createStatement();

			String query = "Select * from reservations;";
			ResultSet set = statement.executeQuery(query);

			System.out.println("*************************************************************************************");
			System.out.println(" | reservation_id   |  guest_name | room number | contact number  | reservation_date|");
			System.out.println("*************************************************************************************");
			while (set.next()) {

				int id = set.getInt("reservation_id");

				String name = set.getString("guest_name");
				int room_no = set.getInt("room_no");
				long contact_number = set.getLong("contact_number");
				String date = set.getString("reservation_date");
				System.out.println("|  " + id + "             | " + name + "     |" + room_no + "           |"
						+ contact_number + "     |" + date + "      |");

			}
			System.out.println("========================");
			return;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("reservation failed");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		// TODO Auto-generated method stub

	}

	@Override
	public int getRoomNumber(Connection c, Scanner s) {
		try {
			System.out.println("Enter the reservation id");
			int id = s.nextInt();
			System.out.println("Enter the guest name");
			s.nextLine();
			String name = s.nextLine();

			String query = "select room_no from reservations where reservation_id=" + id + " and guest_name='" + name
					+ "';";
			Statement statement = c.createStatement();

			ResultSet resSet = statement.executeQuery(query);
			while (resSet.next()) {

				int roonumber = resSet.getInt("room_no");
				System.out.println("The room number of " + name + " having reservation id  " + id + " is " + roonumber);
			}
			System.out.println("========================");
			return 1;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("room number not find");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}

	@Override
	public boolean updateReservation(Connection c, Scanner s) {
		System.out.println("Enter the reservation id for that u want to make changes");
		int id = s.nextInt();
		if (isReservationExists(c, id)) {
			s.nextLine();
			System.out.println("enter the new guest name");
			String newName = s.nextLine();
			System.out.println("enter the  room number");
			int roomNumber = s.nextInt();
			System.out.println("Enter the contact number");
			long phno = s.nextLong();

			String query = "update reservations set guest_name='" + newName + "' ,room_no=" + roomNumber
					+ " ,contact_number='" + phno + "' where reservation_id=" + id;
			try {
				Statement statement = c.createStatement();

				int rowsaffected = statement.executeUpdate(query);
				if (rowsaffected > 0) {
					System.out.println("update successful ....row() affected " + rowsaffected);
					return true;
				}

			} catch (SQLException e) {

				e.printStackTrace();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

		return false;
	}

	@Override
	public boolean deleteReservation(Connection c, Scanner s) {

		System.out.println("Enter the reservation id to delete the reservation-----");
		int id = s.nextInt();
		if (isReservationExists(c, id)) {
			String query = "delete from reservations where reservation_id=" + id;
			try {
				Statement statement = c.createStatement();
				int rowsAffected = statement.executeUpdate(query);

				if (rowsAffected > 0) {
					System.out.println("Delete successfull ...row(s) affected " + rowsAffected);
					return true;
				}

			} catch (SQLException e) {
				e.printStackTrace();

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

		return false;
	}

	public static boolean isReservationExists(Connection c, int id) {

		return true;
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub

	}

}
