package sr.ice.server;

import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.Identity;
import com.zeroc.Ice.ObjectAdapter;
import com.zeroc.Ice.Util;
import sr.ice.server.devices.cameras.PTZSurveillanceCamera;
import sr.ice.server.devices.cameras.SurveillanceCamera;
import sr.ice.server.devices.lightbulbs.LightBulb;
import sr.ice.server.devices.lightbulbs.MultiModeRGBLightBulb;
import sr.ice.server.devices.lightbulbs.RGBLightBulb;

public class IceServer {
	public void t1(String[] args) {
		int status = 0;
		Communicator communicator = null;

		try {
			communicator = Util.initialize(args);

			ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints("Adapter2",
					"tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p 10000 -z");

			// LightBulb
			LightBulb lightBulb1 = new LightBulb();
			adapter.add(lightBulb1, new Identity("1", "LightBulb"));
			LightBulb lightBulb2 = new LightBulb();
			adapter.add(lightBulb2, new Identity("2", "LightBulb"));

			// RGBLightBulb
			RGBLightBulb RGBLightBulb1 = new RGBLightBulb();
			adapter.add(RGBLightBulb1, new Identity("1", "RGBLightBulb"));
			RGBLightBulb RGBLightBulb2 = new RGBLightBulb();
			adapter.add(RGBLightBulb2, new Identity("2", "RGBLightBulb"));
			RGBLightBulb RGBLightBulb3 = new RGBLightBulb();
			adapter.add(RGBLightBulb3, new Identity("3", "RGBLightBulb"));

			// MultiModeRGBLightBulb
			MultiModeRGBLightBulb multiModeRGBLightBulb1 = new MultiModeRGBLightBulb();
			adapter.add(multiModeRGBLightBulb1, new Identity("1", "MultiModeRGBLightBulb"));
			MultiModeRGBLightBulb multiModeRGBLightBulb2 = new MultiModeRGBLightBulb();
			adapter.add(multiModeRGBLightBulb2, new Identity("2", "MultiModeRGBLightBulb"));

			// SurveillanceCameras
			SurveillanceCamera surveillanceCamera1 = new SurveillanceCamera();
			adapter.add(surveillanceCamera1, new Identity("1", "SurveillanceCamera"));
			SurveillanceCamera surveillanceCamera2 = new SurveillanceCamera();
			adapter.add(surveillanceCamera2, new Identity("2", "SurveillanceCamera"));

			// PTZSurveillanceCameras
			PTZSurveillanceCamera ptzSurveillanceCamera1 = new PTZSurveillanceCamera();
			adapter.add(ptzSurveillanceCamera1, new Identity("1", "PTZSurveillanceCamera"));
			PTZSurveillanceCamera ptzSurveillanceCamera2 = new PTZSurveillanceCamera();
			adapter.add(ptzSurveillanceCamera2, new Identity("2", "PTZSurveillanceCamera"));
			PTZSurveillanceCamera ptzSurveillanceCamera3 = new PTZSurveillanceCamera();
			adapter.add(ptzSurveillanceCamera3, new Identity("3", "PTZSurveillanceCamera"));

			adapter.activate();

			System.out.println("Entering event processing loop...");

			communicator.waitForShutdown();

		} catch (Exception e) {
			e.printStackTrace(System.err);
			status = 1;
		}
		if (communicator != null) {
			try {
				communicator.destroy();
			} catch (Exception e) {
				e.printStackTrace(System.err);
				status = 1;
			}
		}
		System.exit(status);
	}


	public static void main(String[] args) {
		IceServer app = new IceServer();
		app.t1(args);
	}
}