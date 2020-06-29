package com.example.librarySystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.librarySystem.model.Barrow;

public interface BarrowDao extends CrudRepository<Barrow, Integer>{

	Optional<List<Barrow>> findAllByHotelId(int userId);
	@Query(value = "select b.bookid from barrow b where b.user_id=:userId",nativeQuery = true)
	List<Integer> findbookIdByuserId(int userId);



	
}
