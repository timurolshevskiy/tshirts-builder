package com.olshevskyi.web;
import com.olshevskyi.web.controller.TShirtController;

import static spark.Spark.*;

class Main {

    public static void main(String[] args) {
        port(8000);
        staticFiles.location("/public");
        get("/builder", new TShirtController().displayMain);
    }
}
