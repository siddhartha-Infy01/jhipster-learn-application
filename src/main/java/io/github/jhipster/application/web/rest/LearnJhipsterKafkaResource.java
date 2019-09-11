package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.service.LearnJhipsterKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/learn-jhipster-kafka")
public class LearnJhipsterKafkaResource {

    private final Logger log = LoggerFactory.getLogger(LearnJhipsterKafkaResource.class);

    private LearnJhipsterKafkaProducer kafkaProducer;

    public LearnJhipsterKafkaResource(LearnJhipsterKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
