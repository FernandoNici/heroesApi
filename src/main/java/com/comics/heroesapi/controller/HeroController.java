package com.comics.heroesapi.controller;

import com.comics.heroesapi.repository.HeroRepository;
import com.comics.heroesapi.service.HeroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HeroController {
    HeroService heroService;

    HeroRepository heroRepository;

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(HeroController.class);

    public HeroController(HeroService heroService, HeroRepository heroRepository) {
        this.heroService = heroService;
        this.heroRepository = heroRepository;
    }


}
