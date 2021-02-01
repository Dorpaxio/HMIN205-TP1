package io.dorpax.cours.hmin205.tp1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Train {
    private List<Stop> stops;

    public Train(List<Stop> stops) throws Exception {
        if (stops.size() < 2) {
            throw new Exception("Vous ne pouvez pas faire des trains sans stop de départ ET d'arrivée.");
        }
    }

    public Train(Stop... stops) throws Exception {
        this(Arrays.asList(stops.clone()));
    }

    public List<Stop> getStops() {
        return stops;
    }

    public List<Gare> getGares() {
        return this.stops.stream().map(Stop::getGare).collect(Collectors.toList());
    }

    public Stop[] getTrajetInfos(Gare gare1, Gare gare2) {
        boolean hasGare1 = false, hasGare2 = false;
        for (Stop stop : stops) {
            if (stop.getGare() == gare1) hasGare1 = true;
            else if (stop.getGare() == gare2) hasGare2 = true;
        }
        if (!(hasGare1 && hasGare2)) return null;

        return new Stop[]{stops.stream().min(Comparator.comparing(Stop::getArrival)).get(),
                stops.stream().max(Comparator.comparing(Stop::getArrival)).get()};
    }
}
