package com.example.order_management.entity;

public class MailEntity {
    private String email;
    private String name;
    private String text;

    public MailEntity(String email, String name, String text) {
        this.email = email;
        this.name = name;
        this.text = text;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
