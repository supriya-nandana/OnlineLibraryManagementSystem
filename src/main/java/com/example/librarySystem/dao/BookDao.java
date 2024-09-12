package com.example.librarySystem.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.librarySystem.model.Book;

@Repository
public interface BookDao extends CrudRepository<Book, Integer> {

	
	@Query(value = "select * from book where b.author_name like %:authorName% and b.book_title like %:booktitle% and category_name=:categoryName", nativeQuery = true)
	Optional<List<Book>> getBooksByauthorNameAndcategoryNameAndbookTitle(String booktitle, String authorName,
			String categoryName);

}
