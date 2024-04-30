#ifndef SMARTHOUSEICE
#define SMARTHOUSEICE

module SmartHouseIce {

    // Device

    interface Device {
        idempotent bool isTurnedOn();
        idempotent void turnOn();
        idempotent void turnOff();
    }

    // Light Bulbs

    enum LightBulbMode {
        NORMAL,
        BLINK,
        BREATH,
        STROBE,
        COLORCYCLE
    }

    struct Color {
        int r;
        int g;
        int b;
    }

    exception InvalidColorException {};
    exception InvalidBrightnessException {};

    interface LightBulb extends Device {
        idempotent int getBrightness();
        idempotent void setBrightness(int newBrightness) throws InvalidBrightnessException;
    }

    interface RGBLightBulb extends LightBulb {
        idempotent Color getColor();
        idempotent void setColor(int r, int g, int b) throws InvalidColorException;
    }

    interface MultiModeRGBLightBulb extends RGBLightBulb {
        idempotent LightBulbMode getMode();
        idempotent void setMode(LightBulbMode newMode);
    }

    // Surveillance Cameras

    struct PanTiltZoom {
        int panAngle;
        int tiltAngle;
        float zoom;
    }

    exception InvalidPanTiltZoomException {};

    interface SurveillanceCamera extends Device {
        idempotent bool isRecording();
        idempotent void startRecording();
        idempotent void stopRecording();
        void takePicture();
    }

    interface PTZSurveillanceCamera extends SurveillanceCamera {
        idempotent PanTiltZoom getPanTiltZoom();
        idempotent void setPanTiltZoom(int panAngle, int tiltAngle, float zoom) throws InvalidPanTiltZoomException;
        void resetPanTiltZoom();
    }
};

#endif
