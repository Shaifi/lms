package com.bansal.lms.repository;

import com.bansal.lms.entity.BookIssue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author shaifibansal
 */
@Repository
public interface BookIssueRepository extends JpaRepository<BookIssue,Long> {

    @Query(value = "select count(*) from book_issue where user_id = :userId and return_date is NULL",nativeQuery = true)
    Integer numberOfBooksIssuedToUser(@Param("userId")Long userId);

    @Query(value = "select * from book_issue where user_id = :userId and book_id = :bookId and return_date is NULL", nativeQuery = true)
    BookIssue getBookIssueEntry(@Param("userId")Long userId, @Param("bookId")Long bookId);
}
