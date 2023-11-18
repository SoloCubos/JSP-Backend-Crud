package com.empresa.jsp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.empresa.jsp.model.Usuario;
import com.empresa.jsp.utils.Conexion;
import com.mysql.cj.protocol.Resultset;

public class UsuarioDAO {

	private Conexion conexion;
	
	private static final String INSERT_USUARIO = "INSERT INTO usuario (nombre, email, pais) VALUES (?, ?, ?);";
	private static final String DELETE_USUARIO = "DELETE FROM usuario WHERE id = ?;";
	private static final String UPDATE_USUARIO = "UPDATE usuario SET nombre = ?, email = ?, pais = ? WHERE id = ?;";
	private static final String SELECT_USUARIO_BY_ID = "SELECT * FROM usuario WHERE id = ?;";
	private static final String SELECT_ALL_USUARIOS = "SELECT * FROM usuario;";

	
	public UsuarioDAO() {
		this.conexion = Conexion.getDb();
	}
	
	public boolean insert(Usuario usuario) throws SQLException{
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERT_USUARIO);
			preparedStatement.setString(1, usuario.getNombre());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getPais());
			conexion.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	} 
	
	public boolean delete(int id) {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(DELETE_USUARIO);
			preparedStatement.setInt(1, id);
			conexion.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(Usuario usuario) throws SQLException{
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(UPDATE_USUARIO);
			preparedStatement.setString(1, usuario.getNombre());
			preparedStatement.setString(2, usuario.getEmail());
			preparedStatement.setString(3, usuario.getPais());
			preparedStatement.setInt(4, usuario.getId());
			conexion.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public Usuario getOneUsuario(int id) {
		Usuario usuario = null; 
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_USUARIO_BY_ID);
			preparedStatement.setInt(1, id);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				usuario = new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("email"), rs.getString("pais"));
			}
			return usuario;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Usuario> getAllUsuarios() {
		List<Usuario> usuarios = new ArrayList();
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_ALL_USUARIOS);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				usuarios.add(new Usuario(rs.getInt("id"), rs.getString("nombre"), rs.getString("email"), rs.getString("pais")));
			}
			return usuarios;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
 