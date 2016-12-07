package com.russbox.resources;

import com.russbox.api.Price;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/price")
@Produces(MediaType.APPLICATION_JSON)
public class PriceResource {

    @GET
    @Timed
    public Price getPrice() {
        return new Price();
    }
}
