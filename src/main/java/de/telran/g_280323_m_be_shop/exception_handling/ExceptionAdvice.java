package de.telran.g_280323_m_be_shop.exception_handling;

import de.telran.g_280323_m_be_shop.exception_handling.exceptions.EntityValidationException;
import de.telran.g_280323_m_be_shop.exception_handling.exceptions.ThirdTestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 3 способ обработки ошибок
// Плюс в том, что данный обработчик является глобальным,
// то есть ловит исключения, возникшие в любом классе нашего приложения.
// Также плюс в том, что мы при помощи объектов ResponseEntity можем
// отправить информационное сообщение об ошибке и выбранный нами статус.
// Минус данного подхода в том, что мы не можем по-разному обрабатывать
// ошибки, возникшие в разных классах, если нам это необходимо.
@ControllerAdvice
public class ExceptionAdvice {

    @ExceptionHandler(ThirdTestException.class)
    public ResponseEntity<Response> handleException(ThirdTestException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EntityValidationException.class)
    public ResponseEntity<Response> handleException(EntityValidationException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}