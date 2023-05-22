package com.graphql.client.controller;

import com.graphql.client.service.PlayerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class GraphQLClientController {


    @Autowired
    private PlayerService playerService;

    @GetMapping("/allplayers")
    public ResponseEntity<?> getAllPlayers() throws IOException {
        return this.playerService.getAllPlayers();
    }

    @GetMapping("/player/{id}")
    public ResponseEntity<?> getPlayerById(@PathVariable("id")int id)
    {
        return this.playerService.getPlayerById();
    }
}
