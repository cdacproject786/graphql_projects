package com.reactive.graphql.repository;

import com.reactive.graphql.domain.Player;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlayerRepository extends ReactiveCrudRepository<Player,Integer> {

    Mono<Player> findByName(String name);
    Mono<Player> deleteByName(String name);
    Flux<Player> findByClub(String club);
    Flux<Player> findByNationality(String nationality);
}


