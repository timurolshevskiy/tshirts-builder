package com.olshevskyi.web;
import com.olshevskyi.controller.TShirtController;

import static spark.Spark.*;

class Main {

    public static void main(String[] args) {
        staticFiles.location("/public");
        get("/builder", new TShirtController().displayMain);
    }
}
