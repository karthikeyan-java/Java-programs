# 🚕 Taxi Booking System

A simple **Taxi Booking System** developed using **Core Java, JDBC, and MySQL**.

This project allows customers to register/login, view available taxis, book a taxi, and view booking history.

## 🛠️ Technologies Used

* Java
* JDBC
* MySQL
* Eclipse IDE

## ✨ Features

* Customer Registration and Login
* Phone Number and Password Validation
* View Taxi Details
* Taxi Booking
* Automatic Taxi Selection
* Fare Calculation
* Taxi Availability Management
* Booking History
* MySQL Database Integration

## 🚖 Taxi Booking Logic

The system selects a taxi based on:

1. Taxi should be available before the requested pickup time.
2. Minimum total earnings is given priority.
3. If earnings are equal, the nearest taxi is selected.

## 💰 Fare Calculation

* Base fare: ₹100 for the first 5 km
* Additional fare: ₹10 per km after 5 km

## 🗄️ Database

The project uses **MySQL** to store:

* Customer details
* Taxi details
* Booking details

### Main Tables

* `customer`
* `taxi`
* `booking`

## 📂 Project Structure

```text
TaxiBooking/
│
├── Main.java
├── Login.java
├── LoginDAO.java
├── Booking.java
├── Taxi.java
├── View.java
└── DBConnection.java
```

## ▶️ How to Run

1. Clone the repository.
2. Create a MySQL database named `taxibooking`.
3. Create the required tables: `customer`, `taxi`, and `booking`.
4. Update the MySQL username and password in `DBConnection.java`.
5. Run `Main.java`.
6. Register/Login and start booking taxis.

## 📌 Future Improvements

* Admin login and management
* Cancel booking functionality
* Better exception handling
* GUI using Java Swing or JavaFX
* Secure password hashing

## 👨‍💻 Author

**Karthi**

A Java project built to practice **Java, JDBC, MySQL, OOP, Collections, and database integration**.
