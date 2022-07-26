package com.codegym.borrowbook.repository;

import com.codegym.borrowbook.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IBookRepository extends JpaRepository<Book, String> {
    @Query(value = "select * from book ", nativeQuery = true)
    Page<Book> findAllBook(Pageable pageable);

    @Query(value = "select * from book where id_book =:idBook", nativeQuery = true)
    Book findByCodeBook(@Param("idBook") String idBook);

    @Modifying
    @Query(value = "update book set amount =:amount-1 where idBook =:idBook")
    void update(@Param("amount") int amount, @Param("idBook") String idBook);

    @Modifying
    @Query(value = "update book set amount = :amount where idBook =:idBook")
    void returnBook(@Param("amount") int amount, @Param("idBook") String idBook);

}
