package com.pethomeproject.sarafan.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.pethomeproject.sarafan.domain.Comment;
import com.pethomeproject.sarafan.domain.User;
import com.pethomeproject.sarafan.domain.Views;
import com.pethomeproject.sarafan.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Контроллер для отоброжания комментов для сообщений
 */
@RestController
@RequestMapping("comment")
public class CommentController {
    private final CommentService commentService;


    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    @JsonView(Views.FullComment.class)
    public Comment create(
            @RequestBody Comment comment,
            @AuthenticationPrincipal User user
    ) {
        return commentService.create(comment, user);
    }
}
