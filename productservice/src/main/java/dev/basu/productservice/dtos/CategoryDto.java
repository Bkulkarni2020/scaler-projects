package dev.basu.productservice.dtos;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
    private UUID Id;
    private String name;
    private String description;
    private String imageUrl;
}
