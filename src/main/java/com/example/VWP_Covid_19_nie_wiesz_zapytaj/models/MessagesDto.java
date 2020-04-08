package com.example.VWP_Covid_19_nie_wiesz_zapytaj.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MessagesDto {


    private Long id;
    @Nullable
    private Long id_sender;
    private String email_sender;
    private Long id_recipient;
    private String text_msg;
    private String topic;


}
