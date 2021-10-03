package edu.sda.sample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DTO czyli Data Transfer Object
 * czyli jeśli w jakimś kawałku aplikacji potrzebujemy skorzystać
 * z podzbioru danych w naszym obiekcie (np. 4 pola z 20)
 * to robimy obiekt DTO na taką potrzebę
 *
 * !! Jeśli mamy wysłać nasz obiekt przez sieć itp. to tym bardziej robimy DTO
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HumanForCensusDTO {
    private String name;
    private String surname;
    private String age;
}
