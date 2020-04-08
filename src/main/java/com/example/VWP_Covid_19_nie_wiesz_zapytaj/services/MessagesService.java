package com.example.VWP_Covid_19_nie_wiesz_zapytaj.services;

import com.example.VWP_Covid_19_nie_wiesz_zapytaj.mappers.MessagesMapper;
import com.example.VWP_Covid_19_nie_wiesz_zapytaj.models.Messages;
import com.example.VWP_Covid_19_nie_wiesz_zapytaj.repositories.MessagesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MessagesService {


    MessagesMapper messagesMapper;
    MessagesRepository messageRepository;

    public Messages saveMessage(Messages messages){
        return messageRepository.save(messages);
    }


    public List<Messages> getMessages(Long id) {
        return messageRepository.findMessagesById(id);
    }


}
