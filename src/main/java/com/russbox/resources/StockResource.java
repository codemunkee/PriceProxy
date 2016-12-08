package com.russbox.resources;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.russbox.api.Stock;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

@Path("/stock")
@Produces(MediaType.APPLICATION_JSON)
public class StockResource {

    @GET
    @Timed
    public Stock getStock() {

        StringBuilder fullResponse = new StringBuilder();

        try {
            URL url = new URL("https://www.google.com/finance/info?q=NYSE%3aTWLO");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                fullResponse.append(responseLine);
            }

            // first three characters are bullshit for whatever reason
            fullResponse.delete(0,2);

        } catch (Exception ex) {
            ex.printStackTrace();

        }

        ObjectMapper om = new ObjectMapper();
        // we only get 1 stock back but it comes back as part of an array
        // when we query Google so we have to do this
        Stock[] stocks = new Stock[1];

        try {
            stocks = om.readValue(fullResponse.toString(), Stock[].class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stocks[0];
    }
}
