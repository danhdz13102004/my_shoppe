package com.example.SecurityJPA.entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.sql.Blob;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "username")
    private String userName;
    @Column(name = "password",length = 256)
    private String passWord;
    @Column(name = "enable")
    private boolean enalble;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Lob
    @Column(name = "avatar")
    private Blob avatar;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<Role> roles;

    public User() {
    }

    public User(Long id, String userName, String passWord, boolean enalble, String firstName, String lastName, String email, Blob avatar, Collection<Role> roles) {
        this.id = id;
        this.userName = userName;
        this.passWord = passWord;
        this.enalble = enalble;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.avatar = avatar;
        this.roles = roles;
    }

    public User(String userName, String passWord, boolean enalble, String firstName, String lastName, String email, Blob avatar, Collection<Role> roles) {
        this.userName = userName;
        this.passWord = passWord;
        this.enalble = enalble;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.avatar = avatar;
        this.roles = roles;
    }

    public User(String userName, String passWord, boolean enalble, String firstName, String lastName, String email, Blob avatar) {
        this.userName = userName;
        this.passWord = passWord;
        this.enalble = enalble;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.avatar = avatar;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isEnalble() {
        return enalble;
    }

    public void setEnalble(boolean enalble) {
        this.enalble = enalble;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Blob getAvatar() {
        return avatar;
    }

    public void setAvatar(Blob avatar) {
        this.avatar = avatar;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }
}
