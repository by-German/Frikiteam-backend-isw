package com.frikiteam.events.controller;

import com.frikiteam.events.domain.model.Comment;
import com.frikiteam.events.domain.service.CommentService;
import com.frikiteam.events.resource.CommentResource;
import com.frikiteam.events.resource.SaveCommentResource;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/events/{eventId}")
public class EventCommentsController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private ModelMapper mapper;

    @PostMapping("users/{id}/comments")
    @Operation(summary = "Create a comment for a event", tags = "events-comments")
    public CommentResource createComment
            (@PathVariable Long eventId, @PathVariable Long id, SaveCommentResource resource) {

        Comment comment = mapper.map(resource, Comment.class);
        return mapper.map(commentService.createComment(eventId, id, comment), CommentResource.class);
    }

}
