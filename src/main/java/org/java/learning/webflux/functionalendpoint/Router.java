package org.java.learning.webflux.functionalendpoint;

import org.apache.commons.collections4.Get;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class Router {

    RouterFunction<ServerResponse> routerFunction = RouterFunctions
            .route().GET("/hello", request -> ServerResponse.ok().body(Mono.just("Hello World"), String.class)).build();
}
