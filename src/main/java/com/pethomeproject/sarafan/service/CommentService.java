package com.pethomeproject.sarafan.service;

import com.pethomeproject.sarafan.domain.Comment;
import com.pethomeproject.sarafan.domain.User;
import com.pethomeproject.sarafan.domain.Views;
import com.pethomeproject.sarafan.dto.EventType;
import com.pethomeproject.sarafan.dto.ObjectType;
import com.pethomeproject.sarafan.repo.CommentRepo;
import com.pethomeproject.sarafan.util.WsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.BiConsumer;

/**
 * сервисный слой для комментов
 */
@Service
public class CommentService {
    private final CommentRepo commentRepo;
    private final BiConsumer<EventType, Comment> wsSender;

    @Autowired
    public CommentService(CommentRepo commentRepo, WsSender wsSender) {
        this.commentRepo = commentRepo;
        this.wsSender = wsSender.getSender(ObjectType.COMMENT, Views.FullComment.class);
    }

    public Comment create(Comment comment, User user) {
        comment.setAuthor(user);
        Comment commentFromDb = commentRepo.save(comment);

        wsSender.accept(EventType.CREATE, commentFromDb);

        return commentFromDb;
    }
}
