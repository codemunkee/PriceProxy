package com.russbox;

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
        // TODO: implement application
    }

}
