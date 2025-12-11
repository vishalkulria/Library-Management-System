# JAR File Location & Usage Guide

## 📍 JAR File Location

Your compiled JAR file is located at:

```
c:\Users\asus\Desktop\Libraray\target\library-management-system-1.0.0.jar
```

### 📊 JAR File Details

| Property | Value |
|----------|-------|
| **File Name** | `library-management-system-1.0.0.jar` |
| **Location** | `target/` directory |
| **Size** | ~10.6 KB |
| **Version** | 1.0.0 |
| **Main Class** | `com.library.ui.LibraryManagementSystem` |
| **Created** | December 11, 2025 |

## 🚀 How to Run the JAR File

### Method 1: Using Command Prompt/PowerShell

```bash
cd c:\Users\asus\Desktop\Libraray
java -jar target\library-management-system-1.0.0.jar
```

### Method 2: Double-Click (Windows)

1. Navigate to: `c:\Users\asus\Desktop\Libraray\target\`
2. Double-click on `library-management-system-1.0.0.jar`
3. The application window will open

### Method 3: Create a Batch File (Windows Shortcut)

Create a file named `run.bat` in the project root:

```batch
@echo off
cd /d %~dp0
java -jar target\library-management-system-1.0.0.jar
pause
```

Then double-click `run.bat` to run the application.

## 📂 Project Directory Structure

```
c:\Users\asus\Desktop\Libraray\
│
├── target/                              ← 📍 JAR FILES HERE
│   ├── library-management-system-1.0.0.jar    ✅ EXECUTABLE JAR
│   ├── classes/                          ← Compiled classes
│   │   └── com/library/...
│   └── maven-archiver/
│
├── src/                                 ← Source code
│   ├── main/java/com/library/
│   │   ├── model/
│   │   │   ├── Book.java
│   │   │   ├── Student.java
│   │   │   └── IssuedBook.java
│   │   └── ui/
│   │       └── LibraryManagementSystem.java
│   └── test/java/...
│
├── pom.xml                             ← Maven configuration
├── README.md                           ← Documentation
├── MAVEN_BUILD.md                      ← Maven guide
├── SUMMARY.md                          ← Project summary
└── .gitignore                          ← Git ignore
```

## 🔧 Building the JAR File (If Needed)

### Using Maven (Full Build with Dependencies)

```bash
# Full Maven build (includes all plugins)
mvn clean package

# This creates:
# - target/library-management-system-1.0.0.jar (basic JAR)
# - target/library-management-system-1.0.0-shaded.jar (fat JAR with dependencies)
```

### Using Java Compiler (Already Done)

```bash
# Compile Java files
javac -d target/classes src/main/java/com/library/model/*.java src/main/java/com/library/ui/*.java

# Create JAR with manifest
jar cfe target/library-management-system-1.0.0.jar com.library.ui.LibraryManagementSystem -C target/classes .
```

## 📋 System Requirements

To run the JAR file, you need:

- **Java Runtime Environment (JRE)** 8 or higher
- **Operating System**: Windows, Mac, or Linux
- **Memory**: 256 MB minimum
- **Display**: Any standard monitor (1024x768 or higher recommended)

### Check Java Installation

```bash
java -version
```

If Java is not installed, download from: https://www.oracle.com/java/technologies/downloads/

## ✨ Application Features

Once you run the JAR, you can use:

### 1. **Book Management Tab**
   - Add new books (Title, Author, ISBN, Category, Quantity)
   - Update existing books
   - Remove books
   - View all books in table

### 2. **Student Management Tab**
   - Add students (Student ID, Name, Phone)
   - Remove students
   - Track books issued to each student

### 3. **Search Books Tab**
   - Search by Title
   - Search by Author
   - Search by Category
   - Case-insensitive search with partial matching

### 4. **Issue & Return Books Tab**
   - Issue books to students
   - Return books
   - Automatic fine calculation (Rs 5 per day overdue)
   - View all issued books with status

## 📊 JAR File Contents

The JAR file contains:

```
library-management-system-1.0.0.jar
├── META-INF/
│   ├── MANIFEST.MF                    ← Entry point specification
│   └── maven/
│       └── com.library/...
├── com/library/model/
│   ├── Book.class
│   ├── Student.class
│   └── IssuedBook.class
└── com/library/ui/
    └── LibraryManagementSystem.class
```

## 🎯 Quick Command Reference

| Task | Command |
|------|---------|
| Run JAR | `java -jar target\library-management-system-1.0.0.jar` |
| Build (Maven) | `mvn clean package` |
| List JAR contents | `jar tf target\library-management-system-1.0.0.jar` |
| Extract JAR | `jar xf target\library-management-system-1.0.0.jar` |
| Check Java version | `java -version` |

## 📁 File Paths (Windows)

For easy reference, here are the Windows paths:

```
JAR File:
C:\Users\asus\Desktop\Libraray\target\library-management-system-1.0.0.jar

Project Root:
C:\Users\asus\Desktop\Libraray

Source Code:
C:\Users\asus\Desktop\Libraray\src\main\java\com\library\

Configuration:
C:\Users\asus\Desktop\Libraray\pom.xml
```

## 🐛 Troubleshooting

### JAR won't open
- Make sure Java is installed: `java -version`
- Check that you're in the correct directory
- Try running from command line first to see error messages

### Error: "Main-Class not found"
- The JAR was not built correctly
- Rebuild using: `mvn clean package`

### Error: "Java is not recognized"
- Java is not in your PATH
- Install Java or add it to your system PATH

### Application window doesn't appear
- The GUI might be opening off-screen
- Try running from terminal to see any error messages

## 📞 Support

If you have issues:

1. Check that Java is properly installed
2. Try rebuilding: `mvn clean package`
3. Check GitHub issues: https://github.com/vishalkulria/Library-Management-System
4. Review error messages in the terminal

## 🎉 Success!

Your JAR file is ready to use! The application will open with:

✅ Tabbed interface with 4 sections
✅ Book management with CRUD operations
✅ Student tracking
✅ Advanced search functionality
✅ Issue/Return book system with fine calculation

---

**Enjoy using your Library Management System! 📚**

Created: December 11, 2025
Version: 1.0.0
