package com.book_manager.service;


import com.book_manager.dto.request.BookRequestDto;
import com.book_manager.dto.response.BookResponseDto;

import java.util.List;
import java.util.UUID;

public interface IBookService {
    List<BookResponseDto> findAll();
    BookResponseDto findById(String id);
    void save(BookRequestDto bookRequestDto);
    void deleteById(String id);
}
