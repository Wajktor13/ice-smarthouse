package sr.ice.server.devices.cameras;

import SmartHouseIce.InvalidPanTiltZoomException;
import SmartHouseIce.PanTiltZoom;
import com.zeroc.Ice.Current;

public class PTZSurveillanceCamera extends SurveillanceCamera implements SmartHouseIce.PTZSurveillanceCamera {
    PanTiltZoom ptz;

    @Override
    public PanTiltZoom getPanTiltZoom(Current current) {
        return ptz;
    }

    @Override
    public void setPanTiltZoom(int panAngle, int tiltAngle, float zoom, Current current)
            throws InvalidPanTiltZoomException {
        if ((panAngle < 0 || panAngle > 360) || (tiltAngle < 0 || tiltAngle > 360) || (zoom < 0) || (zoom > 64)) {
            throw new InvalidPanTiltZoomException();
        }

        ptz = new PanTiltZoom(panAngle, tiltAngle, zoom);
    }

    @Override
    public void resetPanTiltZoom(Current current) {
        ptz = new PanTiltZoom(0, 0, 0);
    }
}
