package com.estudos.orders.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    @Serial
    private  static final  long serialVersionUID = 1L;
    private long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public User(){}

    public User(long id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
