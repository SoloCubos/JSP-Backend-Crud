package com.empresa.jsp.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.empresa.jsp.dao.UsuarioDAO;
import com.empresa.jsp.model.Usuario;

/**
 * Servlet implementation class UsuarioServlet
 */
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsuarioDAO usuarioDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.usuarioDAO = new UsuarioDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertUsuario(request, response);
				break;
			case "/delete":	
				deleteUsuario(request, response);
				break;			
			case "/edit":	
				showEditForm(request, response);
				break;
			case "/update":
				updateUsuario(request, response);
				break;		
			default:
				listUsuarios(request, response);
				break;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
		dispatcher.forward(request, response);
	}
	private void insertUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException {
		
		Usuario usuario = new Usuario(request.getParameter("nombre"), request.getParameter("email"), request.getParameter("pais"));
		usuarioDAO.insert(usuario);
		
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Usuario usuarioActual = usuarioDAO.getOneUsuario(id);
		
		request.setAttribute("usuario", usuarioActual);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
		dispatcher.forward(request, response);
	}
	
	private void updateUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Usuario usuario = new Usuario(id, request.getParameter("nombre"), request.getParameter("email"), request.getParameter("pais"));
		usuarioDAO.update(usuario);
		
		response.sendRedirect("list");
	}
	
	private void deleteUsuario(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		usuarioDAO.delete(id);
		
		response.sendRedirect("list");
	}
	
	private void listUsuarios(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException, SQLException{
		List<Usuario> usuarios = usuarioDAO.getAllUsuarios();
		request.setAttribute("listUsuarios", usuarios);
		RequestDispatcher dispatcher = request.getRequestDispatcher("usuariolist.jsp");
		dispatcher.forward(request, response);
	}
}
