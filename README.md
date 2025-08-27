# OnlineSupermarketDB

## Overview

The **OnlineSupermarketDB** application is a simple supermarket management system that links a Java GUI to a Microsoft Access Database. The program allows users to perform database queries through an intuitive graphical user interface (GUI).

## Features

- Intuitive GUI for managing supermarket data.  
- Database integration with Microsoft Access.  
- Supports CRUD operations (Create, Read, Update, Delete).  
- Dynamic linking between Java and Access database using the JDBC-ODBC bridge.

## Technologies Used

- **Java**: Swing for GUI development.  
- **Microsoft Access**: For database management.  
- **JDBC-ODBC**: For database connectivity.

## How to Run

1. **Clone the repository**:  
   ```bash
   git clone https://github.com/shaimamamdouh/OnlineSupermarketDB.git
2. **Open the project** in NetBeans or any Java IDE.  

3. Ensure the Microsoft Access database file (`.accdb`) is located in the `DataBase/` folder.  

4. **Update the JDBC connection string** in the Java code to point to the correct location of your Access database:  
   ```java
   String url = "jdbc:ucanaccess://path/to/database/OnlineSupermarket.accdb";
## Project Structure

The project directory is organized as follows:

**DataBase**           Contains the Access database file

**src/javadata/**       Java source files for GUI and database interaction

**build/classes/**      Compiled Java classes

**nbproject/**          NetBeans project configuration files

**build.xml**           Build file for the project

**manifest.mf**        Manifest file for application execution
