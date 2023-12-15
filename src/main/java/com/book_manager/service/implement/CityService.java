package com.book_manager.service.implement;

import com.book_manager.dto.request.CityRequestDto;
import com.book_manager.dto.response.CityResponseDto;
import com.book_manager.entity.City;
import com.book_manager.exception.NotFoundException;
import com.book_manager.repository.ICityRepository;
import com.book_manager.service.ICityService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService implements ICityService {
    private final ICityRepository cityRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public City findById(String id) throws NotFoundException {
        return cityRepository.findById(id).orElseThrow(() -> new NotFoundException("Id not found"));
    }

    @Override
    public City save(CityRequestDto cityRequestDto) {
        City city = modelMapper.map(cityRequestDto, City.class);
        return cityRepository.save(city);
    }

    @Override
    public City deleteById(String id) throws NotFoundException {
        City city = findById(id);
        cityRepository.deleteById(id);
        return city;
    }

}
