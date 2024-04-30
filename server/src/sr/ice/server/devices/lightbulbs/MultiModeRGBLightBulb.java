package sr.ice.server.devices.lightbulbs;

import SmartHouseIce.LightBulbMode;
import com.zeroc.Ice.Current;

public class MultiModeRGBLightBulb extends RGBLightBulb implements SmartHouseIce.MultiModeRGBLightBulb {
    LightBulbMode mode = LightBulbMode.NORMAL;

    @Override
    public LightBulbMode getMode(Current current) {
        return mode;
    }

    @Override
    public void setMode(LightBulbMode newMode, Current current) {
        mode = newMode;
    }
}
