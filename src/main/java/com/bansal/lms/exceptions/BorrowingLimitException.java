package com.bansal.lms.exceptions;

/**
 * @author shaifibansal
 */
public class BorrowingLimitException extends Exception{

    public BorrowingLimitException(){

    }

    public BorrowingLimitException(String msg){
        super(msg);
    }
}
