import SmartHouseIce


class DeviceClient:
    def __init__(self, communicator, name, category):
        self._name = name
        self._category_name = category
        self._base = communicator.stringToProxy(
            f"{category}/{name}:tcp -h 127.0.0.2 -p 10000 -z : udp -h 127.0.0.2 -p 10000 -z"
        )
        self.stub = self.get_stub(self._base)
        self.commands = {
            "on": self.stub.turnOn,
            "off": self.stub.turnOff,
            "getState": lambda: print(self.stub.isTurnedOn()),
        }

    def interact(self):
        print(
            f"connected to {self._category_name}:{self._name}. Type 'help' to list available commands"
        )
        
        while True:
            print(f"{self._category_name}:{self._name}> ", end="")
            command_args = None

            try:
                command_raw = input().split(" ")
                if len(command_raw) == 2:
                    command_name, command_args = command_raw
                else:
                    command_name = command_raw[0]

            except KeyboardInterrupt:
                break

            if command_name in self.commands.keys():
                if command_name not in ("on", "off") and not self.stub.isTurnedOn():
                    print("device is turned off")
                    continue
                try:
                    if command_args is not None:
                        self.commands[command_name](command_args)
                    else:
                        self.commands[command_name]()
                except TypeError:
                    print("invalid number of arguments")

            elif command_name == "exit":
                print("type 'help' to list available commands")
                return

            elif command_name == "help":
                for command in self.commands.keys():
                    print(command)
                print("exit")

            else:
                print("invaild command, use help for commands list")


class LightBulbClient(DeviceClient):
    def __init__(self, communicator, name, category="LightBulb"):
        super().__init__(communicator, name, category)

        self.add_commands()

    def get_stub(self, base):
        return SmartHouseIce.LightBulbPrx.checkedCast(base)

    def add_commands(self):
        self.commands["getBrightness"] = lambda: print(self.stub.getBrightness())
        self.commands[
            "setBrightness"
        ] = lambda new_brightness: self._set_brightness_command(new_brightness)

    def _set_brightness_command(self, new_brightness):
        try:
            self.stub.setBrightness(int(new_brightness))
        except (SmartHouseIce.InvalidBrightnessException, ValueError):
            print("invalid brightness value. Should be int in range 0-100")


class RGBLightBulbClient(LightBulbClient):
    def __init__(self, communicator, name, category="RGBLightBulb"):
        super().__init__(communicator, name, category)

        self.add_commands()

    def get_stub(self, base):
        return SmartHouseIce.RGBLightBulbPrx.checkedCast(base)

    def add_commands(self):
        super().add_commands()

        self.commands["getColor"] = lambda: print(self.stub.getColor())
        self.commands["setColor"] = lambda new_color_raw: self._set_color_command(
            new_color_raw
        )

    def _set_color_command(self, new_color_raw):
        try:
            r, g, b = new_color_raw.split("-")
            self.stub.setColor(int(r), int(g), int(b))
        except (SmartHouseIce.InvalidColorException, ValueError):
            print("invalid color values")


class MultiModeRGBLightBulbClient(RGBLightBulbClient):
    def __init__(self, communicator, name, category="MultiModeRGBLightBulb"):
        super().__init__(communicator, name, category)

        self.add_commands()

    def get_stub(self, base):
        return SmartHouseIce.MultiModeRGBLightBulbPrx.checkedCast(base)

    def add_commands(self):
        super().add_commands()

        self.commands["getMode"] = lambda: print(self.stub.getMode())
        self.commands["setMode"] = lambda new_mode: self._set_mode_command(new_mode)

    def _set_mode_command(self, new_mode):
        new_mode_enum = SmartHouseIce.LightBulbMode.valueOf(new_mode)

        if new_mode_enum is None:
            print("invalid mode")
        else:
            self.stub.setMode(new_mode_enum)


class SurveillanceCameraClient(DeviceClient):
    def __init__(self, communicator, name, category="SurveillanceCamera"):
        super().__init__(communicator, name, category)

        self.add_commands()

    def get_stub(self, base):
        return SmartHouseIce.SurveillanceCameraPrx.checkedCast(base)

    def add_commands(self):
        self.commands["isRecording"] = lambda: print(self.stub.isRecording())
        self.commands["startRecording"] = self.stub.startRecording
        self.commands["stopRecording"] = self.stub.stopRecording


class PTZSurveillanceCameraClient(SurveillanceCameraClient):
    def __init__(self, communicator, name, category="PTZSurveillanceCamera"):
        super().__init__(communicator, name, category)

    def get_stub(self, base):
        return SmartHouseIce.PTZSurveillanceCameraPrx.checkedCast(base)

    def add_commands(self):
        super().add_commands()

        self.commands["getPanTiltZoom"] = lambda: print(self.stub.getPanTiltZoom())
        self.commands[
            "setPanTiltZoom"
        ] = lambda new_pan_tilt_zoom_raw: self._set_pan_tilt_zoom(new_pan_tilt_zoom_raw)
        self.commands["resetPanTiltZoom"] = self.stub.resetPanTiltZoom
        self.commands["takePicture"] = self.stub.takePicture

    def _set_pan_tilt_zoom(self, new_pan_tilt_zoom_raw):
        try:
            p, t, z = new_pan_tilt_zoom_raw.split("-")
            self.stub.setPanTiltZoom(int(p), int(t), round(float(z), 2))
        except (SmartHouseIce.InvalidPanTiltZoomException, ValueError):
            print("invalid ptz values")
