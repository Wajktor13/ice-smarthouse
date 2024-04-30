import sys

import Ice

from client import *


def main_client_loop(clients):
    with Ice.initialize(sys.argv) as communicator:
        print("type 'help' to list available commands")

        while True:
            print("> ", end="")

            try:
                command = input()
            except KeyboardInterrupt:
                break

            split_command = command.rstrip().split(" ")
            if split_command[0] == "help":
                print(
                    "connect with device: <DEVICE_CATEGORY> <DEVICE_ID>\nexit\ncategories"
                )

            elif split_command[0] == "exit":
                break

            elif split_command[0] == "categories":
                for category in clients.keys():
                    print(category)
                    
            elif len(split_command) == 2:
                client_class = clients.get(split_command[0])
                if client_class is None:
                    print(
                        f"unknown device category: {split_command[0]}, available categories: {', '.join(clients.keys())}"
                    )
                    continue

                try:
                    client = client_class(communicator, split_command[1])
                    client.interact()
                except Ice.ObjectNotExistException:
                    print(
                        f"object {split_command[0]} with id {split_command[1]} does not exist"
                    )
            else:
                print(f"invaild command: {split_command[0]}")


if __name__ == "__main__":
    clients = {
        "LightBulb": LightBulbClient,
        "RGBLightBulb": RGBLightBulbClient,
        "MultiModeRGBLightBulb": MultiModeRGBLightBulbClient,
        "SurveillanceCamera": SurveillanceCameraClient,
        "PTZSurveillanceCamera": PTZSurveillanceCameraClient,
    }

    main_client_loop(clients)
