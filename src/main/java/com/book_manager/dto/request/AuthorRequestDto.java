package com.book_manager.dto.request;

import com.book_manager.entity.Zipcode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthorRequestDto {
    private String id;
    private String name;
    private Zipcode zipcode;

}
