# SensorsAndTemperatureSensor

A Java-based temperature sensor management system that demonstrates object-oriented design principles through sensor interfaces and implementations.

## Overview

This project implements a sensor framework that allows you to:
- Create individual temperature sensors
- Combine multiple sensors into an average sensor
- Monitor and record sensor readings
- Toggle sensors on and off

## Architecture

### Core Components

#### `Sensor` Interface
The base interface that all sensors must implement:
- `boolean isOn()` - Check if sensor is active
- `void setOn()` - Turn sensor on
- `void setOff()` - Turn sensor off
- `int read()` - Get current reading (throws `IllegalStateException` if sensor is off)

#### `StandardSensor`
A fixed-value sensor implementation:
- Always returns the same predefined integer value
- Useful for testing and simulation

#### `TemperatureSensor`
A temperature sensor implementation (uses randomized readings):
- Simulates real-world temperature variations
- Can be toggled on and off
- Generates readings when active

#### `AverageSensor`
A composite sensor that aggregates multiple sensors:
- Combines readings from multiple child sensors
- Calculates average temperature across all sensors
- Maintains a history of all readings via `readings()`
- Requires all child sensors to be on for operation

## Usage Example

```java
// Create individual temperature sensors
Sensor kumpula = new TemperatureSensor();
Sensor kaisaniemi = new TemperatureSensor();
Sensor helsinkiVantaaAirport = new TemperatureSensor();

// Create an average sensor and add individual sensors
AverageSensor helsinkiRegion = new AverageSensor();
helsinkiRegion.addSensor(kumpula);
helsinkiRegion.addSensor(kaisaniemi);
helsinkiRegion.addSensor(helsinkiVantaaAirport);

// Activate all sensors and get readings
helsinkiRegion.setOn();
System.out.println("Temperature: " + helsinkiRegion.read() + "°C");

// View all recorded readings
System.out.println("Readings: " + helsinkiRegion.readings());
```

## Project Structure

```
application/
├── Sensor.java              # Interface definition
├── StandardSensor.java      # Fixed-value sensor implementation
├── TemperatureSensor.java   # Temperature sensor implementation
├── AverageSensor.java       # Composite sensor implementation
└── Program.java             # Main entry point
```

## Language

- **Java** (100%)

## Key Features

- **Interface-based design** - Easily extendable for new sensor types
- **Composite pattern** - Combine multiple sensors into a single logical unit
- **State management** - Control sensor activation state
- **Reading history** - Track all sensor measurements over time
- **Error handling** - Throws `IllegalStateException` for invalid read attempts

## Getting Started

1. Compile all Java files:
   ```bash
   javac application/*.java
   ```

2. Run the program:
   ```bash
   java application.Program
   ```

## Requirements

- Java 8 or higher
