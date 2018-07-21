package com.olshevskyi.util

import org.apache.velocity.app.VelocityEngine
import spark.ModelAndView
import spark.template.velocity.VelocityTemplateEngine


class ViewUtil {

    static velocityEngine = getVelocityEngine()

    static String renderView(String viewName, Map<String, Object> model) {
        velocityEngine.render(new ModelAndView(model, viewName))
    }

    static getVelocityEngine() {
        def velocityEngine = new VelocityEngine()
        velocityEngine.setProperty("runtime.references.strict", true);
        velocityEngine.setProperty("resource.loader", "class");
        velocityEngine.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        return new VelocityTemplateEngine(velocityEngine)
    }

}
