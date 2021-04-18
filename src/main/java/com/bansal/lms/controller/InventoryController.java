package com.bansal.lms.controller;

import com.bansal.lms.dto.BookDTO;
import com.bansal.lms.exceptions.BookNotFoundException;
import com.bansal.lms.exceptions.BorrowingLimitException;
import com.bansal.lms.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shaifibansal
 */
@RestController
public class InventoryController {

    @Autowired
    InventoryService inventoryService;

    @PostMapping(value = "/addBook",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addBookInInventory(@RequestBody BookDTO book){
        inventoryService.addBookInInventory(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping(value = "/removeBook",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> removeBookFromInventory(@RequestParam(name = "bookId") Long bookId)throws Exception{
        inventoryService.removeBookFromInventory(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/borrowBook",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> borrowBook(@RequestParam(name = "bookId")Long bookId,@RequestParam(name = "userId")Long userId)
            throws BookNotFoundException, BorrowingLimitException {
        inventoryService.borrowBook(bookId,userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/returnBook", produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> returnBook(@RequestParam(name = "bookId")Long bookId,@RequestParam(name = "userId")Long userId){

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
