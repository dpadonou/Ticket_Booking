package istic.csr.tp5.database;

import istic.csr.tp5.dao.Arret;
import istic.csr.tp5.dao.Bus;

import java.util.HashMap;
import java.util.Map;

public class BusDataStore {

    Map<Integer, Bus> busMap;
    private int identifier;

    public BusDataStore() {
        busMap = new HashMap<>();
    }

    public synchronized Bus add(Arret arret) {
        Bus bus = new Bus(arret);
        bus.setId_(identifier);
        busMap.put(identifier, bus);
        bus.setDaemon(true);
        bus.start();
        identifier++;
        return bus;
    }

    public Bus findById(int id) {
        return busMap.get(id);
    }
}
