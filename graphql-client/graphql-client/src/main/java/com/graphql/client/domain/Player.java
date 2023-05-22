package com.graphql.client.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Player {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("age")
    private Integer age;

    @JsonProperty("club")
    private String club;

    @JsonProperty("nationality")
    private String nationality;

}
