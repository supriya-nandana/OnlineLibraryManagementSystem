
package com.example.librarySystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.librarySystem.model.Borrow;

@Repository
public interface BarrowDao extends CrudRepository<Borrow, Integer> {

	@SuppressWarnings("unchecked")
	Borrow save(Borrow barrow);

	@Query(value = "select b.book_id from borrow b where b.user_id=:userId",nativeQuery = true)
	List<Integer> findbookIdByuserId(int userId);
	
	Optional<List<Borrow>> findAllByBarrowId(int userId);

}
