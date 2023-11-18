package com.empresa.jsp.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion {
	
	private Connection con = null;
	private PreparedStatement preparedStatement;
	private static Conexion db;
	
	private static final String url="jdbc:mysql://localhost:3306/";
	private static final String dbName="sistema";
	private static final String driver="com.mysql.cj.jdbc.Driver";
	private static final String userName="root";
	private static final String password="";
	
	public Conexion() {
		try {
			Class.forName(driver);
			con = (Connection)DriverManager.getConnection(url+dbName, userName, password);
		} catch ( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.err.println(e);
		}
	}
	
	public static Conexion getDb() {
		if(db == null) {
			db = new Conexion();
		}return db;
	}
	
	public boolean cerrarConexion() {
		try {
			con.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ResultSet query() throws SQLException{
		return preparedStatement.executeQuery();
	}
	
	public int execute() throws SQLException{
		return preparedStatement.executeUpdate();
	}
	
	public Connection getConexion() {
		return this.con;
	}
	
	public PreparedStatement setPreparedStatement(String sql) throws SQLException {
		this.preparedStatement = con.prepareStatement(sql);
		return this.preparedStatement;
	}
}

