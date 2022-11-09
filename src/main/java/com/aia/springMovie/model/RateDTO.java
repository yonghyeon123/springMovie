package com.aia.springMovie.model;

import lombok.Data;

@Data
public class RateDTO {
    private int id;
    private int writerId;
    private int movieId;
    private int rating;
    private String review;
}
