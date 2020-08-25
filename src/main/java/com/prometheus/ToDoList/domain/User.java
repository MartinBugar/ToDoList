package com.prometheus.ToDoList.domain;

import com.fasterxml.jackson.annotation.JsonTypeId;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.util.Objects;

public class User {

    @Nullable
    private Integer id;

    @NonNull
    private String name;

    @NonNull
    private String surname;

    @NonNull
    private String nickName;

    @NonNull
    private String email;

    @Nullable
    private Integer age;

    @NonNull
    private String password;

    public User (){}

    public User(@NonNull String name, @NonNull String surname, @NonNull String nickName, @NonNull String email, @Nullable Integer age, @NonNull String password) {
        this.name = name;
        this.surname = surname;
        this.nickName = nickName;
        this.email = email;
        this.age = age;
        this.password = password;
    }

    @Nullable
    public Integer getId() {
        return id;
    }

    public void setId(@Nullable Integer id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getSurname() {
        return surname;
    }

    public void setSurname(@NonNull String surname) {
        this.surname = surname;
    }

    @Nullable
    public String getNickName() {
        return nickName;
    }

    public void setNickName(@Nullable String nickName) {
        this.nickName = nickName;
    }

    @NonNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NonNull String email) {
        this.email = email;
    }

    @Nullable
    public Integer getAge() {
        return age;
    }

    public void setAge(@Nullable Integer age) {
        this.age = age;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @Override
    public String
    toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                name.equals(user.name) &&
                surname.equals(user.surname) &&
                Objects.equals(nickName, user.nickName) &&
                email.equals(user.email) &&
                Objects.equals(age, user.age) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, nickName, email, age, password);
    }
}
