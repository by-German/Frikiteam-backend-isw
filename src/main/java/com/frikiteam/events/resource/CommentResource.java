package com.frikiteam.events.resource;

import lombok.Data;

@Data
public class CommentResource {
    private Long id;
    private UserResource user;
    private String comment;
}
