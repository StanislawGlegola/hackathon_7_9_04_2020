package com.example.VWP_Covid_19_nie_wiesz_zapytaj.mappers;

public interface Mapper<F, T> {

    T map(F from);
    F reverseMap(T to);
}