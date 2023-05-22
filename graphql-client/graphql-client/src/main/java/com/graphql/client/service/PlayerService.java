package com.graphql.client.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.graphql.client.domain.Player;
import com.netflix.graphql.dgs.client.MonoGraphQLClient;
import com.netflix.graphql.dgs.client.WebClientGraphQLClient;
import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
public class PlayerService {

/*    public GraphQLResponseEntity<List> getAllPlayers(String url, String query) throws IOException {
        GraphQLTemplate graphQLTemplate = new GraphQLTemplate();
        log.info("template created");
        List<String> list = new ArrayList<>();
        list.add(url);
        list.add("?query=");
        list.add(query);
        log.info("list created");
        GraphQLRequestEntity requestEntity = GraphQLRequestEntity.Builder()
                .url(StringUtils.join(list))
                .request(PlayerInput.class)
                .build();

        log.info("request entity created");
        //GraphQLResponseEntity<List<PlayerInput>> response = new GraphQLResponseEntity<>();
        return graphQLTemplate.query(requestEntity,List.class);
    }*/


/*    public ResponseEntity<?> getAllPlayersusingWebClient(int id)
    {

        String query = "query{\n" +
                "   getPlayerById(\n" +
                "       id : "+id+"\n" +
                "   ){\n" +
                "        id\n" +
                "        name\n" +
                "        club\n" +
                "        nationality\n" +
                "    }\n" +
                "}";
        WebClient webClient = WebClient.create("http://localhost:9090/graphql");
        WebClientGraphQLClient client = MonoGraphQLClient.createWithWebClient(webClient);
        Mono<GraphQLResponse> grapgQlResponseMono =  client.reactiveExecuteQuery(query);
       // log.info("after execute query");
        //log.info(grapgQlResponseMono.toString());
        Mono<String> name =  grapgQlResponseMono.map(val -> val.extractValue("name"));
        //log.info("after extract operation");
        //log.info(name.toString());
        return new ResponseEntity<>(grapgQlResponseMono, HttpStatus.OK);

    }*/

    public ResponseEntity<?> getAllPlayers() {
        ObjectMapper objectMapper = new ObjectMapper();
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:9090/graphql")
                .build();
        GraphQLWebClient graphQLWebClient = GraphQLWebClient.newInstance(webClient, objectMapper);
        Mono<GraphQLResponse> response = graphQLWebClient.post(GraphQLRequest.builder().resource("query1.graphql").build());

        return ResponseEntity.ok(response.map(graphQLResponse -> {
            log.info("GraphQL Response :: {}", graphQLResponse);
            return graphQLResponse.getFirstList(Player.class);
        }));

    }


    public ResponseEntity<?> getPlayerById()
    {
        ObjectMapper objectMapper = new ObjectMapper();
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:9090/graphql")
                .build();

        GraphQLWebClient graphQLWebClient = GraphQLWebClient.newInstance(webClient,objectMapper);
        Mono<GraphQLResponse> response = graphQLWebClient.post(GraphQLRequest.builder().resource("query2.graphql").build());

        return ResponseEntity.ok(response.map(graphQLResponse -> {
            log.info("GraphQl Response:: {}",graphQLResponse);
            return graphQLResponse.getFirst(Player.class);
        }));
    }
}
