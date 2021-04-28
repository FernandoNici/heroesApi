package com.comics.heroesapi.service;

import com.comics.heroesapi.model.Hero;
import com.comics.heroesapi.repository.HeroRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class HeroService {
    private final HeroRepository heroRepository;

    public HeroService(HeroRepository heroesRepository) {
        this.heroRepository = heroesRepository;
    }

    public Flux<Hero> findAll(){
        return Flux.fromIterable(this.heroRepository.findAll());
    }

    public Mono<Hero> findByIdHero(String id){
        return  Mono.justOrEmpty(this.heroRepository.findById(id));
    }

    public Mono<Hero> save(Hero heroes){
        return  Mono.justOrEmpty(this.heroRepository.save(heroes));
    }

    public Mono<Boolean> deletebyIDHero(String id) {
        heroRepository.deleteById(id);
        return Mono.just(true);
    }
}
