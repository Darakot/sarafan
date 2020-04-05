package com.pethomeproject.sarafan.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.pethomeproject.sarafan.domain.Message;
import com.pethomeproject.sarafan.domain.Views;
import com.pethomeproject.sarafan.repo.MessageRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("message")
public class MessageController {
    private final MessageRepo messageRepo;

    public MessageController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping
    @JsonView(Views.IdName.class)
    public List<Message> list() {
        return messageRepo.findAll();
    }

    @GetMapping("{id}")
    @JsonView(Views.FullMessage.class)
    public Message getOne(@PathVariable("id") Message message) {
        return message;
    }

    @PostMapping
    public Message create(@RequestBody Message message){
    message.setCreationDate(LocalDateTime.now());
    return messageRepo.save(message);
    }

    @PutMapping("{id}")
    public Message update(@PathVariable("id") Message messageFromDB,
                          @RequestBody Message message) {
        BeanUtils.copyProperties(message, messageFromDB, "id");

        return messageRepo.save(messageFromDB);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Message message) {
        messageRepo.delete(message);
    }
}
