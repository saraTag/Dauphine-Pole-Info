package io.github.oliviercailloux.y2018.dauphine_pole_info;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class CourseService {

	@PersistenceContext
	private static EntityManager entityManager;
	
	public static Course getCourseById(String idCourse) {
		TypedQuery<Course> queryCourse = entityManager.createQuery("SELECT i FROM Course i i.id = :idCourse",
				Course.class);
		Course cours = queryCourse.setParameter("idCourse", idCourse).getSingleResult();
		
		return cours; 
	}
}
