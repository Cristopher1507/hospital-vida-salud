package pe.cibertec.citas_service.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String COLA = "cita.confirmada";

    @Bean
    public Queue queue() {
        return new Queue(COLA, true);
    }
}