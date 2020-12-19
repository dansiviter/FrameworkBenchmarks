package io.helidon.benchmark.services;

import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;

public class PlainTextService implements Service {

    @Override
    public void update(Routing.Rules rules) {
        rules.get("/plaintext", PlainTextService::plaintext);
    }

    private static void plaintext(ServerRequest req, ServerResponse res) {
        res.send("Hello, World!");
    }
}
