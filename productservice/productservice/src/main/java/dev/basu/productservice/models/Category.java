package dev.basu.productservice.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseModel {
    @Column
    private String name;
    private String description;
    private String imageUrl;
//
//    @OneToMany(mappedBy = "category")
//    private List<Product> products = new ArrayList<>();
    // this is the same relation being mapped by category attribute in the other (Product) class
}
