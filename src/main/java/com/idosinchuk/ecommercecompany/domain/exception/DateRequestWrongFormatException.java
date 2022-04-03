package com.idosinchuk.ecommercecompany.domain.exception;

public class DateRequestWrongFormatException extends RuntimeException {
    public DateRequestWrongFormatException(String date) {
        super("The entered format of the date: " + date + " is wrong");
    }
}
