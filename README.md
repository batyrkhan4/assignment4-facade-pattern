# Smart Home Facade Pattern (Assignment #4)

## Overview
This repository contains a Java implementation of the **Facade Structural Design Pattern**.
The project simulates a Smart Home system where a complex subsystem (involving security, climate control, lighting, and door locks) is hidden behind a simplified, unified interface (the Facade).

## Project Structure
The project consists of three main parts:
1. **Complex Subsystem:**
    * `DoorLockManager.java` - Manages locking and unlocking doors.
    * `SecuritySystem.java` - Arms and disarms the house alarm.
    * `ClimateControl.java` - Adjusts temperature and heating/cooling modes.
    * `LightingSystem.java` - Controls the lights in different rooms.
2. **Facade:**
    * `SmartHomeFacade.java` - Provides a simple API (`leaveHome()`, `arriveHome()`, `nightMode()`) that coordinates the subsystem classes in the correct order.
3. **Client:**
    * `SmartHomeClient.java` - The entry point that uses the Facade to control the house without directly interacting with the subsystem classes.

## Clean Code Principles Applied
1. **Meaningful Names:** Methods like `leaveHome()` and `arriveHome()` make the Facade's API self-explanatory.
2. **Single Responsibility Principle (SRP):** The Facade strictly coordinates the execution order; it does not implement the actual logic of turning on lights or locking doors.
3. **Encapsulation (No Leaking Details):** The Client is completely unaware of the complex subsystem interactions.
4. **Small, Focused Classes:** Each subsystem class manages only one specific aspect of the house (e.g., `ClimateControl` only handles temperature).
5. **Dependency Injection:** The Facade receives its dependencies through the constructor, making the system modular and testable.

## How to Run
1. Clone the repository.
2. Compile the Java files: `javac *.java`
3. Run the client class: `java SmartHomeClient`