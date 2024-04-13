package com.example.healthchecktest;

import com.codahale.metrics.health.HealthCheck;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloPlanetApplication extends Application<HelloPlanetConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HelloPlanetApplication().run(args);
    }

    @Override
    public String getName() {
        return "HelloPlanet";
    }

    @Override
    public void initialize(final Bootstrap<HelloPlanetConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final HelloPlanetConfiguration configuration,
                    final Environment environment) {

        environment.healthChecks().register("looking-good-billyray", new HealthCheck() {
            private boolean flipFlop = false;
            @Override
            protected Result check() throws Exception {
                this.flipFlop = !this.flipFlop;
                return flipFlop
                        ? Result.healthy("Feeling Good, Lewis")
                        : Result.unhealthy("bad bad bad");
            }
        });
    }

}
