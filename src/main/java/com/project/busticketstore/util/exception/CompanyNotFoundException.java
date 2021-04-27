package com.project.busticketstore.util.exception;

import java.util.function.Supplier;

public class CompanyNotFoundException extends RuntimeException  {
    public CompanyNotFoundException(String message) {
        super(message);
    }
}
