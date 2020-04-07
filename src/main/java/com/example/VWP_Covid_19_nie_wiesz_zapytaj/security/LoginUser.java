package com.example.VWP_Covid_19_nie_wiesz_zapytaj.security;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//MODEL

@Getter
@Setter
@Data
public class LoginUser {
    private String email;
    private String password;
    private String name;
    private String lastName;
}
