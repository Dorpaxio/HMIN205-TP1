package io.dorpax.cours.hmin205.tp1;

import java.util.Date;

public class Stop {
    private Gare gare;
    private Date arrival, departure;
    private String way;

    public Stop(Gare gare, Date arrival, Date departure, String way) {
        this.gare = gare;
        this.arrival = arrival;
        this.departure = departure;
        this.way = way;
    }

    public Gare getGare() {
        return gare;
    }

    public void setGare(Gare gare) {
        this.gare = gare;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public Date getDeparture() {
        return departure;
    }

    public void setDeparture(Date departure) {
        this.departure = departure;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }
}
