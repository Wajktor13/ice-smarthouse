package sr.ice.server.devices.lightbulbs;

import SmartHouseIce.InvalidBrightnessException;
import com.zeroc.Ice.Current;
import sr.ice.server.devices.Device;

public class LightBulb extends Device implements SmartHouseIce.LightBulb {
    private int brightness;

    @Override
    public int getBrightness(Current current) {
        return brightness;
    }

    @Override
    public void setBrightness(int newBrightness, Current current) throws InvalidBrightnessException {
        if (newBrightness < 0 || newBrightness > 100) {
            throw new InvalidBrightnessException();
        }

        brightness = newBrightness;
    }
}
