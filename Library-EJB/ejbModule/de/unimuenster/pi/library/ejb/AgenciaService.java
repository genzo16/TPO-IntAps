package de.unimuenster.pi.library.ejb;

import java.util.Collection;

import javax.ejb.EJBException;
import javax.ejb.Remote;
import javax.validation.ConstraintViolationException;

import de.unimuenster.pi.library.jpa.Agencia;


/**
 * Remote interface of session bean for book management.
 * @author Henning Heitkoetter
 *
 */
@Remote
public interface AgenciaService {
	/**
	 * Create a new book in the database with properties as specified by <code>book</code>.
	 * @param book The newly created book has the same property values as this parameter.
	 * @return The newly created book.
	 * @throws ConstraintViolationException (wrapped in an {@link EJBException})
	 */
	Agencia crearAgencia(Agencia agencia);

	/**
	 * Create a new book in the database with the specified property values.
	 * @param name The name of the book.
	 * @param author The author, or <code>null</code>.
	 * @param isbn The ISBN, or <code>null</code>.
	 * @return The newly created book.
	 * @throws ConstraintViolationException (wrapped in an {@link EJBException})
	 */
	Agencia crearAgencia(String nombre, String direccion);
	
	/**
	 * Returns the book with the specified ID.
	 * @param bookId The ID of the book.
	 * @return The book.
	 * @throws IllegalArgumentException If no book exists for the given ID.
	 */
	Agencia getAgencia(int idAgencia);
	
	/**
	 * Retrieves all books from stored in the system.
	 * @return All books.
	 */
	Collection<Agencia> getAllAgencias();
}
