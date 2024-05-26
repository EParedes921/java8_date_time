package org.eparedes.datetime.ejemplos;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

public class EjemploZonedDateTime {
    public static void main(String[] args) {

        LocalDateTime fechaLocal = LocalDateTime.parse("2021/09/23 12:45",
                DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));

        ZoneId newYork = ZoneId.of("America/New_York");
        ZonedDateTime zonaNy = fechaLocal.atZone(newYork);
        //ZonedDateTime zonaNy = ZonedDateTime.of(fechaLocal, ZoneOffset.of("-04:00")); // UTC
        System.out.println("Horario de partida en New York: " + zonaNy);

        ZoneId madrid = ZoneId.of("Europe/Madrid");
        ZonedDateTime zonaMadrid = fechaLocal.atZone(madrid);
        //ZonedDateTime zonaMadrid = zonaNy.withZoneSameInstant(ZoneOffset.of("+02:00")).plusHours(8); //UTC
        System.out.println("Horario de llegada en Madrid: " + zonaMadrid);

        DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm, dd MM yyyy");
        System.out.println("Detalles del viaje a españa:");
        System.out.println("Partida NY: " + f.format(zonaNy));
        System.out.println("llegada Madrid: " + f.format(zonaMadrid));

        //Zonas Horarias Disponibles
        //ZoneId.getAvailableZoneIds().forEach(System.out::println);
    }
}
