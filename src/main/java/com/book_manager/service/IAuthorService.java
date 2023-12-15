package com.book_manager.service;

import com.book_manager.dto.request.AuthorRequestDto;
import com.book_manager.dto.response.AuthorResponseDto;
import com.book_manager.exception.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface IAuthorService {
    List<AuthorResponseDto> findAll();
    AuthorResponseDto findById(String id) throws NotFoundException;
    AuthorResponseDto save(AuthorRequestDto authorRequestDto);
    AuthorResponseDto deleteById(String id) throws NotFoundException;


}
