package com.example.VWP_Covid_19_nie_wiesz_zapytaj.models;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "messages")
public class Messages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Nullable
    private Long id_sender;
    @Nullable
    private String email_sender;

    private Long id_recipient;

    private String text_msg;
    private String topic;


}
