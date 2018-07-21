package com.olshevskyi.controller;

import com.olshevskyi.builder.TShirtsBuilder;
import com.olshevskyi.builder.impl.DefaultTShirtsBuilder;
import com.olshevskyi.domain.TShirt;
import com.olshevskyi.util.ViewUtil;
import spark.Route;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class TShirtController {

    private TShirtsBuilder tShirtsBuilder = new DefaultTShirtsBuilder();

    public final Route displayMain = ((request, response) -> {
        String words = request.queryParams("words");
        HashMap<String, Object> model = new HashMap<>();
        if (words != null) {
            List<String> splitWords = Arrays.stream(words.split(","))
                    .map(String::trim)
                    .collect(Collectors.toList());;

            List<TShirt> tShirts = tShirtsBuilder.buildTShirts(splitWords);

            model.put("tShirts", tShirts);
        }
        return ViewUtil.renderView("/velocity/main.vl", model);
    });

}
