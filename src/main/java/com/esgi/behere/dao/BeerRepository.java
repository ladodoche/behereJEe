package com.esgi.behere.dao;

import com.esgi.behere.model.Beer;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface BeerRepository extends CrudRepository<Beer, Long>{

}