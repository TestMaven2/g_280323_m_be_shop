package de.telran.g_280323_m_be_shop.exception_handling;

public class Response {

    private String message;

    public Response(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}