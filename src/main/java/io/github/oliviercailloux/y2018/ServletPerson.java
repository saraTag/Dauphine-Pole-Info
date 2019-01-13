

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletPerson
 */
public class ServletPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("dauphine");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPerson() {
        super();
    }
    
    /**
     * Create a new Person.
     * 
     * @param firstname
     * @param lastname 
     * @param email
     * @param home_page 
     * @param cv 
     * @param note 
     * @param role 
     * @param password 
     * @param address 
     * @param mobile 
     * @param temporary 
     */
    public static void create(int id, String firstname,String lastname,String email,String phone, String fax, String home_page, String cv, String note, String role, String password, String address, String mobile, String temporary) {
        
    	EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            // Create a new Person object
            Person per = new Person();
            per.setId(id);
            per.setFirstname(firstname);
            per.setLastname(lastname);
            per.setEmail(email);
            per.setPhone(phone);
			per.setFax(fax);
            per.setHomePage(home_page);
            per.setCv(cv);
            per.setNote(note);
            per.setPassword(password);
            per.setRole(role);
            per.setAddress(address);
            per.setMobile(mobile);
            per.setTemporary(temporary);

            manager.persist(per);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
    }
    
    /**
     * Read all Persons.
     * 
     * @return a List of Persons
     */
    public static List<Person> getAllPersons() {

        List<Person> persons = null;

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();
            persons = manager.createQuery("SELECT s FROM Person s",
                    Person.class).getResultList();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
        return persons;
    }
    
    /**
     * Read a Person.
     * 
     * @return a Person
     */
    public Person getPerson(int id) {

    	Person pers = null;
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            pers = manager.find(Person.class, id);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
		return pers;
	
    }
    
    
    
    /**
     * Delete the existing Person.
     * 
     * @param id
     */
    public static void delete(int id) {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();
            Person pers = manager.find(Person.class, id);
            manager.remove(pers);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
    }
    
    /**
     * Update the existing Person.
     * 
      * @param firstname
     * @param lastname 
     * @param email
     * @param home_page 
     * @param cv 
     * @param note 
     * @param role 
     * @param password 
     * @param address 
     * @param mobile 
     * @param temporary 
     */
    public static void setPerson(int id, String firstname,String lastname, String email,String phone, String fax, String home_page, String cv, String note, String role, String password, String address, String mobile, String temporary) {
        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();
            Person pers = manager.find(Person.class, id);
            
            pers.setId(id);
            pers.setFirstname(firstname);
            pers.setLastname(lastname);
            pers.setEmail(email);
            pers.setPhone(phone);
			pers.setFax(fax);
            pers.setHomePage(home_page);
            pers.setCv(cv);
            pers.setNote(note);
            pers.setPassword(password);
            pers.setRole(role);
            pers.setAddress(address);
            pers.setMobile(mobile);
            pers.setTemporary(temporary);

            manager.persist(pers);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
    }
    
    
    /**
     * Update Person firstname and lastname.
     * 
      * @param firstname
     * @param lastname 
     */
    public static void setPerson(int id, String firstname,String lastname) {
        // Create an EntityManager
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();
            Person pers = manager.find(Person.class, id);
            
            pers.setId(id);
            pers.setFirstname(firstname);
            pers.setLastname(lastname);

            manager.persist(pers);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
    }



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// creation des personnes
		create(1,"lahsen","jannani","","","","","","","","","","","");
    	create(2,"maroin","ook","","","","","","","","","","","");
    	// update person
    	setPerson(1050,"lahsen","jannani","jannani.lahsen@gmail.com","","","","","","","","","","");
    	//test delete person
    	delete(1);
	}


}
