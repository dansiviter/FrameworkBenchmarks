package io.helidon.benchmark.services;

import static java.util.Collections.singletonMap;

import java.util.Collections;

import javax.json.Json;
import javax.json.JsonBuilderFactory;

import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;

public class JsonService implements Service {

    private JsonBuilderFactory jsonBuilderFactory;

    public JsonService() {
        this.jsonBuilderFactory = Json.createBuilderFactory(Collections.emptyMap());
    }

    @Override
    public void update(Routing.Rules rules) {
        rules.get("/json", this::json);
    }

    private void json(ServerRequest req, ServerResponse res) {
        res.send(jsonBuilderFactory.createObjectBuilder(singletonMap("message", "Hello, World!")).build());
    }
}
