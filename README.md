# Library Management System

A comprehensive Java-based Library Management System with a Swing GUI. This application allows you to manage books, students, issue/return books, and track fines.

## Features

### 1. Book Management
- ✅ Add new books with Title, Author, ISBN, Category, and Quantity
- ✅ Update existing book information
- ✅ Remove books from the library
- ✅ View all books in a table format

### 2. Student Management
- ✅ Add students with Student ID, Name, and Phone Number
- ✅ Remove students from the system
- ✅ Track the number of books issued to each student

### 3. Search Books
- ✅ Search by Title (case-insensitive, partial match)
- ✅ Search by Author
- ✅ Search by Category
- ✅ View search results in a table

### 4. Issue & Return Books
- ✅ Issue books to students with due date calculation
- ✅ Return books with automatic fine calculation
- ✅ Track issue date, due date, and return date
- ✅ Fine calculation: Rs 5 per day overdue
- ✅ View all issued books with their status (Active/Returned/Overdue)

### 5. Additional Features
- **Tabbed Interface** - Easy navigation between different sections
- **Real-time Updates** - Tables update automatically
- **Data Validation** - Ensures all required fields are filled
- **User-Friendly GUI** - Built with Java Swing

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven 3.6 or higher
- Git (for cloning the repository)

## Installation & Setup

### Clone the Repository
```bash
git clone https://github.com/vishalkulria/Library-Management-System.git
cd Library-Management-System
```

### Build with Maven
```bash
# Clean and build the project
mvn clean package

# This will create a JAR file in the target directory
# JAR file: target/library-management-system-1.0.0-shaded.jar
```

### Run the Application

#### Using Maven
```bash
mvn exec:java -Dexec.mainClass="com.library.ui.LibraryManagementSystem"
```

#### Using compiled JAR
```bash
java -jar target/library-management-system-1.0.0-shaded.jar
```

### Compile (without Maven)
```bash
javac src/main/java/com/library/model/*.java
javac src/main/java/com/library/ui/*.java
```

### Run Tests
```bash
mvn test
```

### Generate JAR with Assembly
```bash
mvn assembly:assembly -DdescriptorId=jar-with-dependencies
```

## Project Structure

```
Library-Management-System/
├── pom.xml                              # Maven configuration file
├── .gitignore                           # Git ignore file
├── README.md                            # Project documentation
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── library/
│   │   │           ├── model/
│   │   │           │   ├── Book.java           # Book model class
│   │   │           │   ├── Student.java        # Student model class
│   │   │           │   └── IssuedBook.java     # IssuedBook model class
│   │   │           └── ui/
│   │   │               └── LibraryManagementSystem.java  # Main GUI class
│   │   └── resources/                   # Resource files
│   └── test/
│       └── java/
│           └── com/
│               └── library/
│                   └── model/
│                       └── BookTest.java       # Unit tests
└── target/
    └── library-management-system-1.0.0-shaded.jar   # Generated JAR
```

## Classes Overview

### Book
- Stores book information: title, author, ISBN, category, quantity
- Provides string representation for display

### Student
- Stores student information: studentId, name, phone
- Maintains list of issued books for each student

### IssuedBook
- Tracks issued books with dates and return status
- Calculates fine based on overdue days
- Provides status information (Active/Returned/Overdue)

### LibraryManagementSystem
- Main application class extending JFrame
- Manages all GUI components and user interactions
- Handles book and student management operations
- Manages book issue/return transactions

## Usage Guide

### Adding a Book
1. Go to "Book Management" tab
2. Enter Title, Author, ISBN, Category, and Quantity
3. Click "Add Book"
4. Book will appear in the table below

### Adding a Student
1. Go to "Student Management" tab
2. Enter Student ID, Name, and Phone
3. Click "Add Student"
4. Student will appear in the table

### Issuing a Book
1. Go to "Issue & Return Books" tab
2. Select Student and Book from dropdown menus
3. Enter number of days for due date (e.g., 14 days)
4. Click "Issue Book"
5. Book quantity will decrease automatically

### Returning a Book
1. Go to "Issue & Return Books" tab
2. Select the issued book from the table
3. Click "Return Book"
4. If overdue, fine will be calculated automatically (Rs 5 per day)

### Searching for Books
1. Go to "Search Books" tab
2. Select search type (Title, Author, or Category)
3. Enter search value
4. Click "Search"
5. Matching books will be displayed in the table

## Fine Calculation

- Fine Rate: Rs 5 per day
- Fine is calculated only when books are returned after the due date
- Displayed in a dialog box upon book return

## Example Workflow

1. Add books to the library
2. Add students to the system
3. Issue books to students
4. Search for books when needed
5. Return books and pay fines if overdue

## Future Enhancements

- Database integration (MySQL/SQLite)
- Persistent data storage
- Advanced reporting features
- User authentication
- Email notifications for due dates
- Book reservation system
- Librarian dashboard

## License

This project is open source and available under the MIT License.

## Author

Vishal Kulria

## Support

For issues or questions, please open an issue on the GitHub repository.

---

**Happy Library Management!** 📚
