package sr.ice.server.devices.lightbulbs;

import SmartHouseIce.Color;
import SmartHouseIce.InvalidColorException;
import com.zeroc.Ice.Current;

public class RGBLightBulb extends LightBulb implements SmartHouseIce.RGBLightBulb {
    private Color color = new Color(0, 0, 0);

    @Override
    public Color getColor(Current current) {
        return color;
    }

    @Override
    public void setColor(int r, int g, int b, Current current) throws InvalidColorException {
        if (!validateColorValue(r) || !validateColorValue(g) || !validateColorValue(b)) {
            throw new InvalidColorException();
        }

        color = new Color(r, g, b);
    }

    private boolean validateColorValue(int v) {
        return v >= 0 && v <= 255;
    }
}