package com.comics.heroesapi.repository;

import com.comics.heroesapi.model.Hero;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface HeroRepository extends CrudRepository<Hero, String> {
}
