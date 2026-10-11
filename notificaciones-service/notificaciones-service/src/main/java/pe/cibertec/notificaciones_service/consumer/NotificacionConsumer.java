package pe.cibertec.notificaciones_service.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class NotificacionConsumer {

    @RabbitListener(queues = "cita.confirmada")
    public void recibirMensaje(String mensaje) {

        System.out.println("=================================");
        System.out.println("NOTIFICACION RECIBIDA");
        System.out.println(mensaje);
        System.out.println("=================================");

    }
}