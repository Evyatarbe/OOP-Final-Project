# OOP Final Project

## Overview

This project, developed during my first year of undergraduate studies, exemplifies the principles of Object-Oriented Programming (OOP) through the creation of a Java-based data visualization tool. It focuses on reading, processing, and graphically representing natality data using various chart types.

## Features

- **Data Visualization**: Implements both pie and column charts to represent natality statistics.
- **Modular Design**: Utilizes separate classes for different chart types (`Pie.java`, `Column.java`) and data handling (`NatalityPanel.java`).
- **Interactive Interface**: Provides a user-friendly interface for displaying and interacting with the charts.
- **Data Handling**: Reads and processes data from a CSV file (`NatalityMini.csv`) to generate visual representations.

## Project Structure

- `Chart.java`: Abstract base class defining common properties and methods for charts.
- `Pie.java`: Extends `Chart` to create pie chart visualizations.
- `Column.java`: Extends `Chart` to create column chart visualizations.
- `NatalityPanel.java`: Manages the layout and integration of different chart types.
- `Tester.java`: Contains the `main` method to run the application.
- `NatalityMini.csv`: Sample dataset containing natality statistics.
- `README.md`: Documentation and instructions for the project.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- An IDE or text editor of your choice (e.g., IntelliJ IDEA, Eclipse)

### Installation

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Evyatarbe/OOP-Final-Project.git
   ```
2. **Navigate to the Project Directory**:
   ```bash
   cd OOP-Final-Project
   ```
3. **Compile the Java Files**:
   ```bash
   javac *.java
   ```
4. **Run the Application**:
   ```bash
   java Tester
   ```

## Usage

Upon running the application, a window will display the natality data visualized through pie and column charts. The interface allows users to interact with the charts to gain insights into the data.

## Contributing

Contributions are welcome! If you'd like to enhance the project, feel free to fork the repository and submit a pull request.

## License

This project is open-source and available under the [MIT License](LICENSE).
