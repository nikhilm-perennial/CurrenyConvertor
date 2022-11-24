package com.currency.model;

import com.currency.enums.Symbol;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Map;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    String name;

    @Enumerated(EnumType.STRING)
    Symbol symbol;

    @ElementCollection
    @MapKeyEnumerated(EnumType.STRING)
    Map<Symbol, Double> conversionRate;
}
