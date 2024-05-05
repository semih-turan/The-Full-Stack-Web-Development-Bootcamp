package dev.patika.librarymanagementapi.v1.dto.response.publisher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PublisherResponse {
    private String name;
    private LocalDate year;
}
