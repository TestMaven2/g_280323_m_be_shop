package de.telran.g_280323_m_be_shop.exception_handling.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 2 способ обработки ошибок
// Плюс в том, что это глобальный обработчик,
// то есть он ловит ошибки, которые возникают
// в любом классе нашего приложения.
// Плюс в том, что это очень простой способ,
// который не требует написания какого-то кода.
// Минус в том, что мы не отправляем клиенту
// никакого информативного сообщения о
// причинах возникновения ошибок, отправляем только статус.
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class SecondTestException extends RuntimeException {
    public SecondTestException(String message) {
        super(message);
    }
}