package com.bansal.lms.serviceImpl;

import com.bansal.lms.dto.BookDTO;
import com.bansal.lms.entity.BookIssue;
import com.bansal.lms.entity.Inventory;
import com.bansal.lms.exceptions.BookNotFoundException;
import com.bansal.lms.exceptions.BorrowingLimitException;
import com.bansal.lms.repository.BookIssueRepository;
import com.bansal.lms.repository.InventoryRepository;
import com.bansal.lms.service.InventoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * @author shaifibansal
 */
@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private BookIssueRepository bookIssueRepository;

    @Override
    public void addBookInInventory(BookDTO bookDTO) {
        Inventory inventory = new Inventory();
        BeanUtils.copyProperties(bookDTO,inventory);
        inventory.setAvailable(true);
        inventoryRepository.save(inventory);
    }

    @Override
    public void removeBookFromInventory(Long bookId) throws BookNotFoundException {
        Optional<Inventory> inventoryEntry = inventoryRepository.findById(bookId);
        if(inventoryEntry.isPresent()){
            inventoryRepository.updateBookAvailabilityStatus(false,bookId);
        }else{
            throw new BookNotFoundException("Book not found with id " + bookId);
        }
    }

    @Override
    public void borrowBook(Long bookId, Long userId) throws BookNotFoundException, BorrowingLimitException {
        Optional<Inventory> inventoryEntry = inventoryRepository.findById(bookId);
        if(inventoryEntry.isPresent()){
            int count = bookIssueRepository.numberOfBooksIssuedToUser(userId);
            if(count>1){
                throw new BorrowingLimitException("More than 2 books can't be issued");
            }
            addEntryForBookIssue(bookId,userId);
            inventoryRepository.updateBookAvailabilityStatus(false,bookId);
        }else{
            throw new BookNotFoundException("Book not found with id " + bookId);
        }
    }

    private void addEntryForBookIssue(Long bookId,Long userId){
        BookIssue bookIssue = new BookIssue();
        bookIssue.setBookId(bookId);
        bookIssue.setUserId(userId);
        bookIssue.setIssueDate(new Date());
        bookIssueRepository.save(bookIssue);
    }

    @Override
    public void returnBook(Long bookId, Long userId) throws BookNotFoundException {
        Optional<Inventory> inventoryEntry = inventoryRepository.findById(bookId);
        if(inventoryEntry.isPresent()){
            inventoryRepository.updateBookAvailabilityStatus(true,bookId);
            BookIssue bookIssue = bookIssueRepository.getBookIssueEntry(userId,bookId);
            if(bookIssue != null){
                // Call calculate fine method to calculate fine and return
                bookIssue.setReturnDate(new Date());
                bookIssueRepository.save(bookIssue);
            }
        }else {
            throw new BookNotFoundException("Book not found with id " + bookId);
        }
    }

    // TODO : Implement method to calculate fine for book returned after 7 days
    private double calculateFine(){
        return 0;
    }
}
