package com.admin.ctrl;

import com.admin.common.StorageFileNotFoundException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class CustomErrorController {

    @ExceptionHandler(Exception.class)
    public String handleError(Exception e) {
        e.printStackTrace();
        return "error_500";
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public String noResourceException(NoResourceFoundException e){
        e.printStackTrace();
        return "error_404";
    }

    @ExceptionHandler(StorageFileNotFoundException.class)
    public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
        return ResponseEntity.notFound().build();
    }
}
