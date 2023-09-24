package dev.basu.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CategoryDto {
    private UUID Id;
    private String name;
    private String description;
    private String imageUrl;
}
