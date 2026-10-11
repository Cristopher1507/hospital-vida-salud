package pe.cibertec.auditoria_service.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class AuditoriaConsumer {

    @RabbitListener(queues = "cita.confirmada")
    public void recibirMensaje(String mensaje) {

        System.out.println("=================================");
        System.out.println("AUDITORIA REGISTRADA");
        System.out.println(mensaje);
        System.out.println("=================================");

    }
}