package sr.ice.server.devices.cameras;

import com.zeroc.Ice.Current;
import sr.ice.server.devices.Device;

public class SurveillanceCamera extends Device implements SmartHouseIce.SurveillanceCamera {
    private boolean isRecording = false;

    @Override
    public boolean isRecording(Current current) {
        return isRecording;
    }

    @Override
    public void startRecording(Current current) {
        isRecording = true;
    }

    @Override
    public void stopRecording(Current current) {
        isRecording = false;
    }

    @Override
    public void takePicture(Current current) {
        System.out.println("camera has taken a picture");
    }
}
