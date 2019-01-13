

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
 * Servlet implementation class ServletContent
 */
public class ServletContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
            .createEntityManagerFactory("dauphine");
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletContent() {
        super();
    }

    /**
     * Create a new course content.
     * 
    * @param id
     * @param name 
     * @param name
     * @param description 
     * @param training 
     * @param hourly_volume 
     * @param etcs 
     * @param project_volume 
     * @param objectives 
     * @param contents 
     * @param biblio 
     */
    public static void create(int id, String name, String description, String training, int hourly_volume, float etcs, int project_volume, String objectives, String contents, String biblio) {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            Content cont = new Content();
            cont.setId(id);
            cont.setName(name);
            cont.setDescription(description);
            cont.setTraining(training);
            cont.setHourlyVolume(hourly_volume);
            cont.setEtcs(etcs);
            cont.setProjectVolume(project_volume);
            cont.setObjectives(objectives);
            cont.setContents(contents);
            cont.setBiblio(biblio);

            manager.persist(cont);
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
     * Read all Contents.
     * 
     * @return a List of contents
     */
    public static List<Content> getAllContent() {

        List<Content> contents = null;

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            contents = manager.createQuery("SELECT s FROM Content s",
                    Content.class).getResultList();
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
        return contents;
    }
    
    
    /**
     * Read a Content.
     * 
     * @return a Content
     */
    public Content getContent(int id) {

    	Content cont = null;
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

             cont = manager.find(Content.class, id);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
		return cont;
	
    }
    
    /**
     * Delete the existing Content.
     * 
     * @param id
     */
    public static void delete(int id) {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();
            Content cont = manager.find(Content.class, id);

            manager.remove(cont);
            // Commit the transaction
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
     * Update the existing Content.
     * 
     * @param id
     * @param name 
     * @param name
     * @param description 
     * @param training 
     * @param hourly_volume 
     * @param etcs 
     * @param project_volume 
     * @param objectives 
     * @param contents 
     * @param biblio 
     */
    public static void setContent(int id, String name, String description, String training, int hourly_volume, float etcs, int project_volume, String objectives, String contents, String biblio) {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            Content cont = manager.find(Content.class, id);

            cont.setName(name);
            cont.setDescription(description);
            cont.setTraining(training);
            cont.setHourlyVolume(hourly_volume);
            cont.setEtcs(etcs);
            cont.setProjectVolume(project_volume);
            cont.setObjectives(objectives);
            cont.setContents(contents);
            cont.setBiblio(biblio);

            manager.persist(cont);
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
     * Update the content description.
     * @param id
     * @param description 
     */
    public static void setContent(int id, String description) {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            Content cont = manager.find(Content.class, id);
            cont.setDescription(description);
         
            manager.persist(cont);
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
		// Create contentss
        create(1, "cours1","","",15,-0f,11,"","",""); 
        create(1, "cours2","","",15,-0f,11,"","",""); // Alice will get an id 1
        // Update contents
        setContent(1, "cours3","","",15,-0f,11,"","","");

        // Delete contents
        delete(1);

	}

}
