package com.book_manager.service;


import com.book_manager.dto.request.ZipcodeRequestDto;
import com.book_manager.entity.Zipcode;
import com.book_manager.exception.NotFoundException;

import java.util.List;

public interface IZipcodeService {
    List<Zipcode> findAll();
    Zipcode findById(String id) throws NotFoundException;
    Zipcode save(ZipcodeRequestDto zipcodeRequestDto);
    Zipcode deleteById(String id) throws NotFoundException;
}
