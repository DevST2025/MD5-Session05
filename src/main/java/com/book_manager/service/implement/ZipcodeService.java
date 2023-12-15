package com.book_manager.service.implement;

import com.book_manager.dto.request.ZipcodeRequestDto;
import com.book_manager.entity.Zipcode;
import com.book_manager.exception.NotFoundException;
import com.book_manager.service.IZipcodeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZipcodeService implements IZipcodeService {
    @Override
    public List<Zipcode> findAll() {
        return null;
    }

    @Override
    public Zipcode findById(String id) throws NotFoundException {
        return null;
    }

    @Override
    public Zipcode save(ZipcodeRequestDto zipcodeRequestDto) {
        return null;
    }

    @Override
    public Zipcode deleteById(String id) throws NotFoundException {
        return null;
    }
}
