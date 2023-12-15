package com.book_manager.dto.request;

import com.book_manager.entity.City;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ZipcodeRequestDto {
    private String id;
    private String name;
    private City city;
}
