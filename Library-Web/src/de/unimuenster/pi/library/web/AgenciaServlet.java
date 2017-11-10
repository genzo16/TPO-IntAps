package de.unimuenster.pi.library.web;

import java.io.IOException;
import java.io.PrintStream;
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
import de.unimuenster.pi.library.jpa.Agencia;

@WebServlet("/AgenciaServlet")
public class AgenciaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private AgenciaService ejb;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintStream out = new PrintStream(response.getOutputStream());
		try{
			Agencia newAgencia = ejb.crearAgencia(request.getParameter("nombre"), request.getParameter("direccion"));
			out.println("Agencia creada correctamente.<br/>");
			out.println(newAgencia);
		}
		catch (EJBException e) {
			out.println("La Agencia no pudo ser creada.<br/>");
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
