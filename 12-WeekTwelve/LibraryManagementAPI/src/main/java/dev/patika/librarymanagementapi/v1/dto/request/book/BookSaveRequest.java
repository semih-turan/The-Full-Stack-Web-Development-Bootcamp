package dev.patika.librarymanagementapi.v1.dto.request.book;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookSaveRequest {
    private String name;
    private int year;
    private int stock;
}
