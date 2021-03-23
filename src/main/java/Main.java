import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {

    // адрес файла json
    private static final String jsonFile = "tickets.json";

    public static void main(String[] args) {

        double averageTimeToFly = 0;
        double procentile90InMinutes = 0;

        // ловим FileNotFoundException
        try {

            // читаем файл
            JsonReader reader = new JsonReader(new FileReader(jsonFile));

            // присваиваем значения массиву объектов с билетами
            TicketList ticketList = new Gson().fromJson(reader, TicketList.class);

            // среднее время полета в минутах
            averageTimeToFly = allFlyTimeForAllFlights(ticketList) / (ticketList.tickets.size());

            // среднее время полета в часах
            System.out.println("Среднее время полета для всех рейсов составит: " + averageTimeToFly / 60 + " часов");

            procentile90InMinutes = flyTimeFor90PrcFlights(ticketList);

            System.out.println("Среднее время полета полета между городами: \n"
                    + ticketList.tickets.get(0).getOriginName() + " и "
                    + ticketList.tickets.get(0).getDestinationName() + "\n"
                    + "для выборки из 90 процентиля составит: "
                    + procentile90InMinutes / 60 + " часов");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    // метод для подсчета времени полета для 1 рейса
    public static double howLongWeFly(String departureTime, String arrivalTime) {
        String[] time1 = departureTime.split(":");
        String[] time2 = arrivalTime.split(":");

        double timeToFly = 0;
        double dep = Double.parseDouble(time1[0]) * 60
                + Double.parseDouble(time1[1]);
        double arrival = Double.parseDouble(time2[0]) * 60
                + Double.parseDouble(time2[1]);
        timeToFly = arrival - dep;

        return timeToFly;
    }

    // синтетический метод для подсчета всего времени всех полетов в минутах
    public static double allFlyTimeForAllFlights(TicketList ticketlist) {
        double sumTime = 0;
        // пробегаем по массиву, вычислем время полета в каждом случае
        for (int i = 0; i < ticketlist.tickets.size(); i++) {
            sumTime += howLongWeFly(ticketlist.tickets.get(i).departureTime,
                    ticketlist.tickets.get(i).arrivalTime);
        }
        return sumTime;
    }

    //  метод для подсчета среднего времени полета (в минутах) для выборки из 90 процентиля
    public static double flyTimeFor90PrcFlights(TicketList ticketlist) {
        double sumTime = 0;
        int index = (int) (ticketlist.tickets.size() * 0.9);
        // пробегаем по массиву, вычислем время полета в каждом случае
        for (int i = 0; i < index; i++) {
            sumTime += howLongWeFly(ticketlist.tickets.get(i).departureTime,
                    ticketlist.tickets.get(i).arrivalTime);
        }
        return sumTime / index;
    }


}
