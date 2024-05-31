package com.jsp.hotelmanagementapp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

public interface Dao {

	boolean newReservation(Connection c,Scanner s);
	void viewReservations(Connection c);
	int getRoomNumber(Connection c,Scanner s);
	boolean updateReservation(Connection c,Scanner s);
	boolean deleteReservation(Connection c,Scanner s);
	void exit();
	
}
