# ANTLR-Based Scientific Expression Evaluator and Plotter

This project is a **JavaFX-based scientific expression evaluator and graphical plotter** that integrates **compiler design concepts** with **numerical computation** and **data visualization**.
It allows users to define, evaluate, and visualize mathematical expressions through a **custom Domain-Specific Language (DSL)** implemented using **ANTLR 4**.

---

## 1. Overview

The project demonstrates how compiler front-end technology can be combined with Java’s graphical capabilities to create an interactive computation environment.
Users can define mathematical functions, evaluate complex expressions, plot graphs dynamically, and save or load sessions.

It uses:

* **ANTLR 4** for lexical analysis and parsing.
* **JavaFX** for user interface and interactive charting.
* **Gson** for session serialization.
* **Maven** for build management and dependency handling.

---

## 2. Features

| Feature                            | Description                                                                                                                      |
| ---------------------------------- | -------------------------------------------------------------------------------------------------------------------------------- |
| Custom DSL                         | Users can define and evaluate mathematical expressions and functions such as `f(x)=sin(x)` and `plot(f(x), -3.14, 3.14, "red")`. |
| Implicit Multiplication            | Allows expressions like `2x`, `(x+1)(x+2)`, and `3sin(x)` without using `*`.                                                     |
| Persistent Variables and Functions | Values and definitions are preserved throughout the session.                                                                     |
| Session Save/Load                  | Saves all user-defined data to a JSON file and restores it later.                                                                |
| Interactive Graph Plotting         | Uses JavaFX `LineChart` for visualization with zoom and pan support.                                                             |
| Export Plot as Image               | Saves the currently displayed plot as a PNG file.                                                                                |
| Error Handling                     | Reports invalid input and parsing issues in the console.                                                                         |

---

## 3. System Architecture

### 3.1 Grammar Definition (`Expr.g4`)

Defines the syntax for:

* Numeric literals and variables
* Arithmetic operations (`+`, `-`, `*`, `/`, `^`)
* Parentheses and operator precedence
* Function definitions (`f(x)=x^2+2x`)
* Plotting commands (`plot(f(x),-10,10,"blue")`)
* Implicit multiplication through `term pow #implicitMul` rule

### 3.2 Evaluator (`EvalVisitor.java`)

Implements the visitor pattern to:

* Evaluate arithmetic expressions and functions.
* Store variables and functions in memory.
* Execute plot commands by delegating to the plotting module.
* Serialize and deserialize sessions using the Gson library.

### 3.3 GUI (`CalculatorApp.java`)

Built using JavaFX. The interface contains:

* A code editor area for input.
* A console area for displaying results and logs.
* A chart area for visual output.
* Buttons for Run, Clear Plot, Save Plot, Reset Zoom, Save Session, and Load Session.

A `SplitPane` layout ensures the editor and chart occupy equal halves of the window, and resizing behavior maintains balanced proportions.

---

## 4. Example DSL Usage

Users can input multi-line commands such as:

```
pi = 3.14159
a = 2
b = 3

f(x) = sin(x)
g(x) = a*x^2 + b*x + 1
h(x) = f(x) + g(x)

f(pi/2)
g(4)
h(1)

plot(f(x), -pi, pi, "red")
plot(g(x), -10, 10, "blue")
plot((x+1)(x+2), -5, 5, "green")
```

This script defines variables and functions, evaluates expressions, and plots multiple graphs with specified colors.

---

## 5. Session Management

### Saving Sessions

All user-defined variables and functions are stored in a file named `session.json`.
The structure of the file is as follows:

```json
{
  "vars": {
    "a": 2.0,
    "b": 3.0,
    "pi": 3.14159
  },
  "functions": {
    "f": { "params": ["x"], "expr": "sin(x)" },
    "g": { "params": ["x"], "expr": "a*x^2 + b*x + 1" }
  }
}
```

### Loading Sessions

Saved sessions can be restored at any time.
The evaluator re-parses stored expressions to rebuild internal parse trees using ANTLR, ensuring that all functions and variables work exactly as before.

---

## 6. Plot Export

The **Save Plot** feature captures the current chart and saves it as an image file (`plot.png`).
By default, the image is stored in the same directory as the JAR file.

This is handled using the JavaFX Snapshot API:

```java
ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", new File("plot.png"));
```

---

## 7. Building and Running

### Prerequisites

* Java 17 or later
* Maven 3.6 or later

### Steps

1. Clone the repository:

   ```bash
   git clone https://github.com/Mithil-Srinivas/ANTLR-Plotter.git
   cd ANTLR-Plotter
   ```

2. Build the project:

   ```bash
   mvn clean package
   ```

3. Run the JAR:

   ```bash
   java -jar target/Calculator-1.0-SNAPSHOT.jar
   ```
