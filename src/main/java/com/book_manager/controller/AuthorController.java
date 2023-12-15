package com.book_manager.controller;

import com.book_manager.dto.request.AuthorRequestDto;
import com.book_manager.dto.response.AuthorResponseDto;
import com.book_manager.entity.Author;
import com.book_manager.entity.Zipcode;
import com.book_manager.exception.NotFoundException;
import com.book_manager.service.IAuthorService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/author")
public class AuthorController {
    private final IAuthorService authorService;
    private final ModelMapper modelMapper;
    @PostMapping("/addAuthor")
    public ResponseEntity<AuthorResponseDto> addAuthor(@RequestBody AuthorRequestDto authorRequestDto) {
        AuthorResponseDto authorResponseDto = authorService.save(authorRequestDto);
        return new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<AuthorResponseDto> getAuthor(@PathVariable String id) throws NotFoundException {
        return new ResponseEntity<>(authorService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<AuthorResponseDto>> getAuthors() {
        return new ResponseEntity<>(authorService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/edit/{id}")
    private ResponseEntity<AuthorResponseDto> editAuthor(@PathVariable  String id,
                                                         @RequestBody  AuthorRequestDto authorRequestDto) {
        authorRequestDto.setId(id);
        AuthorResponseDto authorResponseDto = authorService.save(authorRequestDto);
        return new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
    }
    @PostMapping("/addZipcode/{zipcodeId}/to/{authorId}")
    private ResponseEntity<AuthorResponseDto> addZipcode(@PathVariable("zipcodeId") Zipcode zipcode,
                                                         @PathVariable("authorId") Author author) throws NotFoundException {

        author.setZipcode(zipcode);
        AuthorRequestDto authorRequestDto = modelMapper.map(author, AuthorRequestDto.class);
        authorService.save(authorRequestDto);
        return new ResponseEntity<>(authorService.save(authorRequestDto), HttpStatus.OK);
    }

    @PostMapping("/removeZipcode/{id}")
    private ResponseEntity<AuthorResponseDto> removeZipcode(@PathVariable("id")  Author author) {
        author.setZipcode(null);
        AuthorRequestDto authorRequestDto = modelMapper.map(author, AuthorRequestDto.class);
        authorService.save(authorRequestDto);
        return new ResponseEntity<>(authorService.save(authorRequestDto), HttpStatus.OK);
    }

}
