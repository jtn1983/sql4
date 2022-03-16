package ru.tenilin.sql4.entity;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NameSurnameAge implements Serializable {
    private String name;
    private String surname;
    private int age;
}
