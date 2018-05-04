package com.twu.biblioteca.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {
    String userName;
    String password;
    String realName;
    String email;
    String address;
    String phone;


    List<Article> possessions=new ArrayList<>();
    public Account(String userName, String password, String realName, String email, String address, String phone) {
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getRealName() {
        return realName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }


    public List<Article> getPossessions() {
        return possessions;
    }

    public void addPossession(Article article){
        possessions.add(article);
    }
    @Override
    public String toString() {
        return "Account{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(userName, account.userName) &&
                Objects.equals(password, account.password) &&
                Objects.equals(realName, account.realName) &&
                Objects.equals(email, account.email) &&
                Objects.equals(address, account.address) &&
                Objects.equals(phone, account.phone);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userName, password, realName, email, address, phone);
    }
}
