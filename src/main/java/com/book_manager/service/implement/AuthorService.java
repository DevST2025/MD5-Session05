package com.book_manager.service.implement;

import com.book_manager.dto.request.AuthorRequestDto;
import com.book_manager.dto.response.AuthorResponseDto;
import com.book_manager.entity.Author;
import com.book_manager.exception.NotFoundException;
import com.book_manager.repository.IAuthorRepository;
import com.book_manager.service.IAuthorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService implements IAuthorService {
    private final IAuthorRepository authorRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<AuthorResponseDto> findAll() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream().map(s-> modelMapper.map(authors, AuthorResponseDto.class)).collect(Collectors.toList());
    }

    @Override
    public AuthorResponseDto findById(String id) throws NotFoundException {
        Author author = authorRepository.findById(id).orElseThrow(() -> new NotFoundException("Id not found"));
        return modelMapper.map(author, AuthorResponseDto.class);
    }

    @Override
    public AuthorResponseDto save(AuthorRequestDto authorRequestDto) {
        Author author = modelMapper.map(authorRequestDto, Author.class);
        authorRepository.save(author);
        return modelMapper.map(author, AuthorResponseDto.class);
    }

    @Override
    public AuthorResponseDto deleteById(String id) throws NotFoundException {
        AuthorResponseDto authorResponseDto = findById(id);
        authorRepository.deleteById(id);
        return authorResponseDto;
    }
}
