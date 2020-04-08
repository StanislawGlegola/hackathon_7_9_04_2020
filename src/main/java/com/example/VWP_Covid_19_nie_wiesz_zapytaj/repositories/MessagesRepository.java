package com.example.VWP_Covid_19_nie_wiesz_zapytaj.repositories;

import com.example.VWP_Covid_19_nie_wiesz_zapytaj.models.Messages;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessagesRepository extends JpaRepository<Messages, Long> {


    @Query("select m from Messages m where m.id_recipient = ?1")
    List<Messages> findMessagesById(Long id);


}

