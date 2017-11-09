package de.unimuenster.pi.library.ejb;

import java.util.Collection;
import java.util.Date;

import javax.ejb.EJBException;
import javax.ejb.Remote;
import javax.validation.ConstraintViolationException;

import de.unimuenster.pi.library.jpa.Agencia;
import de.unimuenster.pi.library.jpa.Paquete;


/**
 * Remote interface of session bean for book management.
 * @author Henning Heitkoetter
 *
 */
@Remote
public interface PaqueteService {
	/**
	 * Create a new book in the database with properties as specified by <code>book</code>.
	 * @param book The newly created book has the same property values as this parameter.
	 * @return The newly created book.
	 * @throws ConstraintViolationException (wrapped in an {@link EJBException})
	 */
	Paquete crearPaquete(Paquete agencia);

	/**
	 * Create a new book in the database with the specified property values.
	 * @param name The name of the book.
	 * @param author The author, or <code>null</code>.
	 * @param isbn The ISBN, or <code>null</code>.
	 * @return The newly created book.
	 * @throws ConstraintViolationException (wrapped in an {@link EJBException})
	 */
	Paquete crearPaquete(String nombre, String descripcion, Date fecha_desde, Date fecha_hasta,
			String agencia, String destino, String estado, int cupo);
	
	/**
	 * Returns the book with the specified ID.
	 * @param bookId The ID of the book.
	 * @return The book.
	 * @throws IllegalArgumentException If no book exists for the given ID.
	 */
	Paquete getPaquete(int idPaquete);
	
	/**
	 * Retrieves all books from stored in the system.
	 * @return All books.
	 */
	Collection<Paquete> getAllPaquetes();
}
