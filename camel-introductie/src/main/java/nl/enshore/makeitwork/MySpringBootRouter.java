package nl.enshore.makeitwork;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * A simple Camel route that triggers from a timer and calls a bean and prints to system out.
 * <p/>
 * Use <tt>@Component</tt> to make Camel auto detect this route when starting.
 */
@Component
public class MySpringBootRouter extends RouteBuilder {

    @Override
    public void configure() {
        from("file:./in").routeId("fileIO-met-xpath")
        .to("log:fileIO")
        .choice().when().xpath("//for = 'makeitwork'")
            .to("file:./out/special")
        .otherwise()
            .to("file:./out/regular")
        .end();
    }
}
