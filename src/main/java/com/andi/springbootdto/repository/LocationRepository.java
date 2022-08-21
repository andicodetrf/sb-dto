package com.andi.springbootdto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andi.springbootdto.model.Location;

public interface LocationRepository extends JpaRepository <Location, Long>{

}
