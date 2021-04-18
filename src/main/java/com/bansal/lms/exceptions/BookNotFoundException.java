package com.bansal.lms.exceptions;

/**
 * @author shaifibansal
 */
public class BookNotFoundException extends Exception{

    public BookNotFoundException(){

    }

    public BookNotFoundException(String msg){
        super(msg);
    }

}
