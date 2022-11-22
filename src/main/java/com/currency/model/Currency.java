package com.currency.model;

import com.currency.Symbol;
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
    long id;

    String name;

    Symbol symbol;

    @ElementCollection
    @MapKeyEnumerated(EnumType.STRING)
    Map<Symbol, Double> conversionRate;
}
