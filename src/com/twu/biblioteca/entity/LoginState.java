package com.twu.biblioteca.entity;

public enum LoginState {
    NOT_EXIST("The username dose not exit!"),
    WRONG_PASSWORD("The password is wrong"),
    LOGIN_IN("Login in ,welcome!");
    String message;

    LoginState(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
