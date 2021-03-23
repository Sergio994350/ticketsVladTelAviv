import com.google.gson.annotations.SerializedName;

public class Ticket {

    public String origin; //  "VVO",
    @SerializedName("origin_name")
    public String originName; // "Владивосток",
    public String destination;  //  "TLV",
    @SerializedName("destination_name")
    public String destinationName; // "Тель-Авив",
    @SerializedName("departure_date")
    public String departureDate; // "12.05.18",
    @SerializedName("departure_time")
    public String departureTime; // ": "16:20",
    @SerializedName("arrival_date")
    public String arrivalDate; // ": "12.05.18",
    @SerializedName("arrival_time")
    public String arrivalTime; // ": "22:10",
    public String carrier;  // ": "TK",
    public String stops;  // ": 3,
    public String price;  // ": 12400

    public Ticket() {
    }

    public Ticket(String origin, String originName, String destination, String destinationName, String departureDate, String departureTime, String arrivalDate, String arrivalTime, String carrier, String stops, String price) {
        this.origin = origin;
        this.originName = originName;
        this.destination = destination;
        this.destinationName = destinationName;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.carrier = carrier;
        this.stops = stops;
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getStops() {
        return stops;
    }

    public void setStops(String stops) {
        this.stops = stops;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
