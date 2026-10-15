# Smart Home Facade Pattern (Assignment #4)

## Overview

This repository contains a Java implementation of the **Facade Structural Design Pattern**.

The project simulates a Smart Home system where several subsystems, including security, climate control, lighting, and door locks, are managed through one simplified interface called `SmartHomeFacade`.

The Facade coordinates these subsystems and allows the client to control the house without interacting with each subsystem directly.

## Project Structure

### 1. Complex Subsystems

- `DoorLockManager.java` — manages locking and unlocking doors.
- `SecuritySystem.java` — arms and disarms the security system.
- `ClimateControl.java` — controls temperature and climate settings.
- `LightingSystem.java` — manages the lights.

### 2. Facade

- `SmartHomeFacade.java` — provides methods such as `leaveHome()`, `enterHome()`, and `nightMode()` to coordinate the subsystems.
- The Facade also uses `HomeNotificationService` to send notifications without depending on a specific notification implementation.

### 3. Notification Components

- `HomeNotificationService.java` — defines the interface for sending home notifications.
- `ConsoleNotificationService.java` — implements the interface by printing notifications to the console.
- `FakeHomeNotificationService.java` — stores notifications during testing so their contents can be verified.

### 4. Client

- `SmartHomeClient.java` — demonstrates how the client uses the Facade to control the Smart Home system through a simplified interface.

### 5. Tests

- `SmartHomeFacadeTest.java` — contains unit tests for the home scenarios, dependency validation, and notification behavior.

## Clean Code Principles Applied

The project demonstrates selected principles from Chapters 7, 8, and 9 of Robert C. Martin's *Clean Code*.

### Chapter 7 — Error Handling

**Don't Pass Null**

The `SmartHomeFacade` constructor uses `Objects.requireNonNull()` to validate its dependencies. If a required subsystem or notification service is `null`, the constructor throws a `NullPointerException` with a descriptive message.

The `testConstructorRejectsNullDoors()` test verifies that invalid dependencies are rejected.

### Chapter 8 — Boundaries

**Clean Boundaries**

The `SmartHomeFacade` depends on the `HomeNotificationService` interface rather than a specific notification implementation.

`ConsoleNotificationService` handles console output, while `FakeHomeNotificationService` is used in tests to capture notifications. This separation allows the notification implementation to be changed without modifying the Facade's main home-management scenarios.

The `testLeaveHomeSendsNotification()` test verifies that the Facade sends the expected notification through the interface.

### Chapter 9 — Unit Tests

**Single Concept per Test**

Each test focuses on one Smart Home scenario, such as entering the home, leaving the home, or activating night mode. Multiple assertions are used to verify the expected state changes within the same scenario.

**F.I.R.S.T. Principles**

The tests use assertions to validate results automatically. The `@BeforeEach` annotation creates fresh subsystem objects before every test, helping maintain independence. The tests are intended to run quickly and produce repeatable results.

**Build-Operate-Check**

The tests follow three steps:

1. **Build:** `setUp()` creates the subsystem objects and the Facade.
2. **Operate:** The test calls a Facade method, such as `facade.leaveHome()`.
3. **Check:** Assertions verify the resulting state and behavior.

## How to Run

### Compile the Project

```bash
javac *.java
```

### Run the Client

```bash
java SmartHomeClient
```

### Run the Tests

Run `SmartHomeFacadeTest` using your IDE or your project's configured JUnit test runner.

## Conclusion

The Smart Home project demonstrates how the Facade pattern simplifies interactions with multiple subsystems. The implementation also uses dependency validation, interface-based notification handling, and unit tests to improve reliability, maintainability, and testability.