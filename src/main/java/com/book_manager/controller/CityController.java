package com.book_manager.controller;

import com.book_manager.dto.request.CityRequestDto;
import com.book_manager.entity.City;
import com.book_manager.exception.NotFoundException;
import com.book_manager.service.ICityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/city")
public class CityController {
    private final ICityService cityService;

    public ResponseEntity<City> addCity(@RequestBody CityRequestDto cityRequestDto) {
        return new ResponseEntity<>(cityService.save(cityRequestDto), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<City> getCityById(@PathVariable String id) throws NotFoundException {
        return new ResponseEntity<>(cityService.findById(id), HttpStatus.OK);

    }

    @GetMapping("/getall")
    public ResponseEntity<List<City>> getCities() {
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable  String id) throws NotFoundException {
        return new ResponseEntity<>(cityService.deleteById(id), HttpStatus.OK);

    }

    @PostMapping("/edit/id")
    public ResponseEntity<City> editCity(@RequestBody  CityRequestDto cityRequestDto,
                                         @PathVariable  String id) {
        cityRequestDto.setId(id);
        return new ResponseEntity<>(cityService.save(cityRequestDto), HttpStatus.OK);

    }
}
