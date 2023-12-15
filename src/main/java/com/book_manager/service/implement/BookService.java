package com.book_manager.service.implement;

import com.book_manager.dto.request.BookRequestDto;
import com.book_manager.dto.response.BookResponseDto;
import com.book_manager.repository.IBookRepository;
import com.book_manager.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService {
    private final IBookRepository bookRepository;

    @Override
    public List<BookResponseDto> findAll() {
        return null;
    }

    @Override
    public BookResponseDto findById(String id) {
        return null;
    }

    @Override
    public void save(BookRequestDto bookRequestDto) {

    }

    @Override
    public void deleteById(String id) {

    }
}
