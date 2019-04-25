package com.bookstore.service.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * @Author: Joker_wang
 * @Date: 2019/2/12 19:16
 * @Version 1.0.0
 */
public class RequestDeal {
    public static void requestDeal(BindingResult errors){
        if (errors.hasErrors()) {
            List<ObjectError> errorList = errors.getAllErrors();
            StringBuilder sb = new StringBuilder();
            //String desc = "";
            for (ObjectError error : errorList) {
                FieldError fieldError = (FieldError) error;
                //desc = fieldError.getDefaultMessage();
                sb.append(fieldError.getDefaultMessage() + "|");
            }
            throw new RuntimeException();
        }
    }
}
