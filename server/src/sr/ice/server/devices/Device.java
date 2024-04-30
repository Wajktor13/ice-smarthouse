package sr.ice.server.devices;

import com.zeroc.Ice.Current;

public class Device implements SmartHouseIce.Device {
    private boolean isTurnedOn = false;

    @Override
    public boolean isTurnedOn(Current current) {
        return isTurnedOn;
    }

    @Override
    public void turnOn(Current current) {
        isTurnedOn = true;
    }

    @Override
    public void turnOff(Current current) {
        isTurnedOn = false;
    }
}
