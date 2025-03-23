package dev.divyansh.productservicettsevening.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreApiProductDto {
    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private RatingDto rating;
}
