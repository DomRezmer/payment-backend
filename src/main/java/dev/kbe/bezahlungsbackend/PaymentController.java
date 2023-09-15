package dev.kbe.bezahlungsbackend;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.kbe.bezahlungsbackend.config.RabbitMQConfig;
import dev.kbe.bezahlungsbackend.config.RabbitMQSender;

@RestController
@CrossOrigin(origins = "localhost:3000", allowedHeaders = "*")
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @GetMapping("/test")
    public String sendPayment() {
        rabbitMQSender.send("Payment");
        return "PaymentController is working";
    }
}
