package de.unimuenster.pi.library.web;

import java.io.IOException;
import java.io.PrintStream;
import java.sql.Date;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import de.unimuenster.pi.library.ejb.AgenciaService;
import de.unimuenster.pi.library.ejb.BookService;
import de.unimuenster.pi.library.ejb.PaqueteService;
import de.unimuenster.pi.library.jpa.Agencia;
import de.unimuenster.pi.library.jpa.Book;
import de.unimuenster.pi.library.jpa.Paquete;

@WebServlet("/PaqueteServlet")
public class PaqueteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private PaqueteService ejb;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintStream out = new PrintStream(response.getOutputStream());
		try{
			Paquete newPaquete = ejb.crearPaquete(request.getParameter("nombre"), request.getParameter("descripcion"),
					 Date.valueOf(request.getParameter("fechaDesde")), Date.valueOf(request.getParameter("fechaHasta")), request.getParameter("agencia"),
					 request.getParameter("destino"), request.getParameter("estado"), Integer.valueOf(request.getParameter("cupo")));
			out.println("Paquete creada correctamente.<br/>");
			out.println(newPaquete);
		}
		catch (EJBException e) {
			out.println("El Paquete no pudo ser creado.<br/>");
			if(e.getCausedByException() instanceof ConstraintViolationException){
				out.println("Razon(s):<br/>");
				ConstraintViolationException cve = (ConstraintViolationException) e.getCausedByException();
				Set<ConstraintViolation<?>> violations = cve.getConstraintViolations();
				if(violations!=null)
					for(ConstraintViolation<?> cur : violations)
						out.println(cur.getMessage() + "<br/>");
				else
					out.println(cve.getMessage());
			}
		}
		finally{
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
