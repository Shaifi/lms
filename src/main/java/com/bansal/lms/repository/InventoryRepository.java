package com.bansal.lms.repository;

import com.bansal.lms.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author shaifibansal
 */
@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    @Modifying
    @Transactional
    @Query(value = "update inventory set is_available=:status where book_id = :bookId",nativeQuery = true)
    void updateBookAvailabilityStatus(@Param("status")boolean status,@Param("bookId")Long bookId);

}
