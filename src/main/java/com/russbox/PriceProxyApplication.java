package com.russbox;

import com.russbox.resources.HelloWorldResource;
import com.russbox.resources.PriceResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class PriceProxyApplication extends Application<PriceProxyConfiguration> {

    public static void main(final String[] args) throws Exception {
        new PriceProxyApplication().run(args);
    }

    @Override
    public String getName() {
        return "PriceProxy";
    }

    @Override
    public void initialize(final Bootstrap<PriceProxyConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final PriceProxyConfiguration configuration,
                    final Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );

        final PriceResource price = new PriceResource();

        environment.jersey().register(resource);
        environment.jersey().register(price);

    }

}
