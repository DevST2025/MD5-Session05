package com.book_manager.repository;

import com.book_manager.entity.Zipcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IZipcodeRepository extends JpaRepository<Zipcode, String> {
}
