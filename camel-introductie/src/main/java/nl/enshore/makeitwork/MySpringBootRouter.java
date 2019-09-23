package nl.enshore.makeitwork;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nl.enshore.makeitwork.processor.MyAwesomeProcessor;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class MySpringBootRouter extends RouteBuilder {

    @Autowired
    MyAwesomeProcessor myAwesomeProcessor;

    @Override
    public void configure() {
        from("restlet:http://localhost:8888/greeting?restletMethod=POST").routeId("restEndpoint")
        .process(myAwesomeProcessor)
        .choice().when().xpath("//for = 'makeitwork'")
            .to("direct:special")
        .otherwise()
            .to("direct:regular")
        .end();

        from("direct:special")
        .to("file:./out/special");

        from("direct:regular")
        .to("file:./out/regular");
    }
}
