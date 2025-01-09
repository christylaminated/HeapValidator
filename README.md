# SmartGreenhouseSensors

The **SmartGreenhouseSensors** project is a robust and modular system for managing temperature and humidity sensor data in smart farming environments. This version introduces flexible data storage strategies, encapsulation for data integrity, and robust error handling while supporting batch and real-time data processing modes.

---

## Features

### 1. **Strategy Pattern for Flexible Data Storage**
- Modular implementation allows seamless switching between different storage mechanisms:
  - **Default Strategy**: Uses a `LinkedList` for in-memory data storage.
  - **Alternate Strategy**: Utilizes alternative structures like `ArrayList` or `HashSet`.
  - Dynamic switching ensures no data loss when transitioning between strategies.

### 2. **Error Detection and Quality Control**
- Filters out erroneous sensor readings (`-999` values).
- Calculates the percentage of errors using the `percentError()` method.
- Ensures only valid data is stored and processed.

### 3. **Encapsulation and Security**
- Protects mutable fields like `GregorianCalendar` using encapsulation.
- Implements deep copies of mutable fields to prevent data tampering.
- Avoids direct access to mutable fields and maintains integrity with controlled methods.

### 4. **Batch and Real-Time Data Processing**
- **Batch Processing** (`GreenHouseNursery`):
  - Optimized for fast data input.
- **Real-Time Processing** (`GreenHouseProduce`):
  - Optimized for precomputed results and quick output response times.

### 5. **Reusable Abstract Classes and Interfaces**
- Abstract class `AbsGreenHouse` provides reusable methods for core logic.
- `ParsedDataStrategy` interface ensures clean architecture for strategy-based data management.

---

## Input Format

Sensor data is provided as a `List<Double>` in the following format:

---

### Example Input
```java
List<Double> sensorData = List.of(
    20231106010101.0, 45.5, 34.0, -999.0, 46.6, 40.0, 20231130020202.0, 22.2, 20.0
);

