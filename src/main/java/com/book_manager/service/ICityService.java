package com.book_manager.service;


import com.book_manager.dto.request.CityRequestDto;
import com.book_manager.entity.City;
import com.book_manager.exception.NotFoundException;

import java.util.List;

public interface ICityService {
    List<City> findAll();
    City findById(String id) throws NotFoundException;
    City save(CityRequestDto cityRequestDto);
    City deleteById(String id) throws NotFoundException;
}
