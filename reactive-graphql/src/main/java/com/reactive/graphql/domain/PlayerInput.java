package com.reactive.graphql.domain;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

    @Data
    @AllArgsConstructor
    public class PlayerInput {

        @JsonProperty("name")
        private String name;

        @JsonProperty("age")
        private Integer age;

        @JsonProperty("club")
        private String club;

        @JsonProperty("nationality")
        private String nationality;
    }


