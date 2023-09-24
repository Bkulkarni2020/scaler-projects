package dev.basu.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.dialect.function.TruncFunction;
import org.hibernate.id.factory.spi.GenerationTypeStrategy;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
public class BaseModel {
    @Id
    @GeneratedValue(generator = "basayya")
    @GenericGenerator(name = "basayya", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "binary(16)", nullable = false, updatable = false)
    private UUID uuid;
    private String created_by;
    private OffsetDateTime created_date = OffsetDateTime.now( ZoneOffset.UTC );
    private String updated_by;
    private OffsetDateTime updated_date =null;
    private boolean isActive;
}
