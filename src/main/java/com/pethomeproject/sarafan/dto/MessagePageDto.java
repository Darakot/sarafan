package com.pethomeproject.sarafan.dto;

import com.fasterxml.jackson.annotation.JsonView;
import com.pethomeproject.sarafan.domain.Message;
import com.pethomeproject.sarafan.domain.Views;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * DTO для сообщений
 */

@Getter
@Setter
@AllArgsConstructor
@JsonView(Views.FullMessage.class)
public class MessagePageDto {
    private List<Message> messages;
    private int currentPage;
    private int totalPages;

}
