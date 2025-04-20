package com.example.neoflex.exceptions;

/**
 * Класс-исключение для обработки некоректно введенных данных
 */
public class InvalidInputException extends RuntimeException {

    public InvalidInputException(String msg) {
        super(msg);
    }

}
