package com.nc.repository.many2many;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.nc.entity.many2many.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

	List<Course> findByTitleContainingIgnoringCase(String title);

	List<Course> findByFeeLessThan(double fee);

	@Transactional(readOnly = true)
	@Query("select u from Course u where u.abbreviation = ?1 OR u.modules = ?2")
	List<Course> findByAnnotatedQuery(String param1, int param2);

	@Query("select u from Course u where u.abbreviation IN :param1 OR u.modules IN :param2")
	List<Course> findByAbbrevationLikeNamed(Collection<String> param1, Collection<Integer> param2);
}
