import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class TicketList {
    @SerializedName("tickets")
    public ArrayList<Ticket> tickets;
}

