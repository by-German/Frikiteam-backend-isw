package com.frikiteam.events.resource;

import lombok.Data;

@Data
public class UserResource {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String logo;

//
//    private String username;
//
//    public String getUsername() {
//        return username;
//    }
//
//    public UserResource setUsername(String username) {
//        this.username = username;
//        return this;
//    }
}