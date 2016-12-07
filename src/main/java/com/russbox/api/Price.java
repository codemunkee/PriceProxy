package com.russbox.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Price {

    @JsonProperty
    public String getContent() {
        return Price.getPrice();
    }

    public static String getPrice() {

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

        return fullResponse.toString();

    }
}
