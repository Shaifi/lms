package com.bansal.lms.service;

import com.bansal.lms.dto.BookDTO;
import com.bansal.lms.exceptions.BookNotFoundException;
import com.bansal.lms.exceptions.BorrowingLimitException;

/**
 * @author shaifibansal
 */
public interface InventoryService {

    void addBookInInventory(BookDTO bookDTO);

    void removeBookFromInventory(Long bookId) throws BookNotFoundException;

    void borrowBook(Long bookId,Long userId) throws BookNotFoundException, BorrowingLimitException;

    void returnBook(Long bookId, Long userId) throws BookNotFoundException;
}
