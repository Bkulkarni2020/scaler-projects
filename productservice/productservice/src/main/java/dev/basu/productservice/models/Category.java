package dev.basu.productservice.models;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Category extends BaseModel {
    @Column
    private String name;
    private String description;
    private String imageUrl;
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    @Fetch(FetchMode.SUBSELECT)
    private List<Product> products;
    public List<Product> getProducts() {
        if (products == null) {
            products = new ArrayList<>();
        }
        return products;
    }
//
//    @OneToMany(mappedBy = "category")
//    private List<Product> products = new ArrayList<>();
    // this is the same relation being mapped by category attribute in the other (Product) class
}
