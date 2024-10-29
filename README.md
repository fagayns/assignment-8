

Project Overview
This project demonstrates a Java application designed using Object-Oriented Programming (OOP) principles. It models various types of devices (Smartphone, Laptop, and Tablet) with a graphical user interface (GUI) built using JavaFX. The program allows users to create and manage a list of devices, including adding and removing them, using a clean and intuitive interface.

Features
Object-Oriented Design:

Implements inheritance:
A base class Device represents a generic device.
Derived classes (Smartphone, Laptop, and Tablet) add specific attributes to represent their respective devices.
JavaFX GUI:

Device management system with:
Tabs to select device type (Smartphone, Laptop, Tablet).
Input fields for device attributes.
A ListView to display added devices.
Buttons for adding and removing devices from the list.
Displays a selected device's details when clicked.
Dynamic List View:

A ListView is used to show devices.
Devices are stored in an ObservableList, ensuring automatic updates in the UI when items are added or removed.
Project Structure
1. Base Class: Device
This class models a generic device.

Attributes:

type: Enum (SMARTPHONE, LAPTOP, TABLET)
name: String
price: Double
weight: Double
Methods:

A parameterized constructor to initialize the attributes.
Getters and setters for all attributes.
2. Derived Classes:
Each derived class inherits from Device and adds additional attributes:

Smartphone

screenSize: double
cameraResolution: double
Laptop

ramSize: int
processorType: String
Tablet

batteryLife: double
hasStylus: boolean
Each derived class has its own constructor to initialize both its own and inherited attributes.
