package com.esgi.behere.dao;

import com.esgi.behere.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BeerRepository extends JpaRepository<Beer, Long> {

}