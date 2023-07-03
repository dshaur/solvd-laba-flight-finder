# Airplane Flights Finder Project

This project is a Java application that helps users find the shortest or cheapest route between airports for airplane flights. The application allows users to input their starting airport and destination airport, choose the search criteria (distance or price), and generates a list of flight instructions to reach the destination.

## Features

- Displays a list of available city destinations.
- Calculates the shortest or cheapest route between airports.
- Generates a list of flight instructions for the user.
- Saves route details in JSON and XML formats.
- Stores airport, country, city, and flight information in a database.
- Uses real coordinates to calculate distances between airports.
- Simulates the route between airports based on search criteria.
- Handles complex routes with multiple intermediate flights.
- Uses JAXB and Jackson for serialization of route details.

## Getting Started

These instructions will help you set up the project and run it on your local machine for development and testing purposes.

### Prerequisites

- Java Development Kit (JDK) version 20.0.0 or higher
- Database Management System (e.g., MySQL, PostgreSQL)

### Installation

1. Clone the repository: git clone [https://github.com/dshaur/solvd-laba-flight-finder.git]

2. Import the project into your preferred Java IDE.

3. Configure the database connection in the `db.properties` and `mybatis_config.xml` files with the appropriate credentials.

4. Run the SQL script provided in the `database.sql` file to set up the database schema and initial data.

5. Build and run the project from your IDE.

### Usage

1. Launch the application.

2. Follow the prompts to input the starting airport, destination airport, and search criteria.

3. The application will display the generated list of flight instructions to reach the destination.

### Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.

### License

This project is licensed under the [MIT License](https://opensource.org/licenses/MIT).
