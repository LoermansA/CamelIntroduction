package nl.enshore.makeitwork.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyAwesomeProcessor implements Processor {

    Logger logger = LoggerFactory.getLogger(MyAwesomeProcessor.class);

    public void process(Exchange exchange) throws Exception {
        String payload = exchange.getIn().getBody(String.class);
        logger.info(payload);
    }
}