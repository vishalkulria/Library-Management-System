# 📋 ALL COMMANDS TO RUN YOUR PROJECT - SUMMARY

## 🎯 The Simplest Answer

### **Just Run It (Recommended)**
```bash
java -jar target\library-management-system-1.0.0.jar
```

That's literally it! Your app launches. Done! ✅

---

## 📚 All Available Commands

### **1. RUN APPLICATION**

#### ✨ Fastest Way (One Command)
```bash
java -jar target\library-management-system-1.0.0.jar
```

#### 📍 From Project Directory
```bash
cd c:\Users\asus\Desktop\Libraray
java -jar target\library-management-system-1.0.0.jar
```

#### 🖱️ Double-Click Method
1. Open Windows Explorer
2. Go to: `c:\Users\asus\Desktop\Libraray\target\`
3. Double-click: `library-management-system-1.0.0.jar`

#### 🔧 Using Maven
```bash
mvn exec:java -Dexec.mainClass="com.library.ui.LibraryManagementSystem"
```

---

### **2. BUILD PROJECT**

#### Build Everything (Recommended)
```bash
mvn clean package
```

#### Build Without Tests (Faster)
```bash
mvn clean package -DskipTests
```

#### Just Compile (Don't Package)
```bash
mvn compile
```

#### Clean Old Builds
```bash
mvn clean
```

---

### **3. COMPILE WITH JAVAC**

#### Compile All Java Files
```bash
javac -d target/classes src/main/java/com/library/model/*.java src/main/java/com/library/ui/*.java
```

#### Create JAR from Compiled Classes
```bash
jar cfe target/library-management-system-1.0.0.jar com.library.ui.LibraryManagementSystem -C target/classes .
```

#### Run Compiled Classes (Without JAR)
```bash
java -cp target/classes com.library.ui.LibraryManagementSystem
```

---

### **4. TESTING**

#### Run All Tests
```bash
mvn test
```

#### Run Specific Test
```bash
mvn test -Dtest=BookTest
```

#### Run Tests with Details
```bash
mvn test -X
```

---

### **5. VERIFICATION**

#### Check Java Installation
```bash
java -version
```

#### Check Maven Installation
```bash
mvn --version
```

#### Verify JAR File Exists
```bash
dir target\*.jar
```

#### Check JAR Contents
```bash
jar tf target\library-management-system-1.0.0.jar
```

---

### **6. ADVANCED COMMANDS**

#### Generate JavaDoc
```bash
mvn javadoc:javadoc
```

#### Install to Local Maven Repository
```bash
mvn install
```

#### Generate Project Documentation
```bash
mvn site
```

#### View Project Info
```bash
mvn project-info-reports:project-info
```

#### List JAR Dependencies
```bash
mvn dependency:tree
```

---

## 🚀 Most Common Workflows

### **Workflow 1: Just Run It (Fastest)**
```bash
java -jar target\library-management-system-1.0.0.jar
```
**Time:** ~2 seconds ⚡

---

### **Workflow 2: Build & Run (Complete)**
```bash
mvn clean package
java -jar target\library-management-system-1.0.0.jar
```
**Time:** ~30-60 seconds (first time), ~10 seconds (subsequent runs)

---

### **Workflow 3: Fast Build & Run (No Tests)**
```bash
mvn clean package -DskipTests && java -jar target\library-management-system-1.0.0.jar
```
**Time:** ~15-20 seconds

---

### **Workflow 4: Just Build (For CI/CD)**
```bash
mvn clean package
```
**Creates JAR file for distribution**

---

### **Workflow 5: Development & Testing**
```bash
mvn test
mvn compile
java -jar target\library-management-system-1.0.0.jar
```
**For active development with tests**

---

## 📖 Step-by-Step Instructions

### **For First Time Users:**

**Step 1:** Open Command Prompt or PowerShell
```bash
# Windows - Search for "Command Prompt" or "PowerShell"
```

**Step 2:** Navigate to Your Project
```bash
cd c:\Users\asus\Desktop\Libraray
```

**Step 3:** Run the Application
```bash
java -jar target\library-management-system-1.0.0.jar
```

**Step 4:** Enjoy! 🎉
- The GUI window opens automatically
- Start managing your library!

---

## 🎯 Quick Reference Table

| **What You Want** | **Command** |
|---|---|
| **Run Now** | `java -jar target\library-management-system-1.0.0.jar` |
| **Build & Run** | `mvn clean package && java -jar target\library-management-system-1.0.0.jar` |
| **Just Build** | `mvn clean package` |
| **Fast Build** | `mvn clean package -DskipTests` |
| **Run Tests** | `mvn test` |
| **Verify Setup** | `java -version && mvn --version` |
| **Check JAR** | `dir target\*.jar` |
| **List JAR Contents** | `jar tf target\library-management-system-1.0.0.jar` |
| **Compile Only** | `mvn compile` |
| **Generate Docs** | `mvn javadoc:javadoc` |

---

## 📁 File Locations

### **JAR File Location**
```
c:\Users\asus\Desktop\Libraray\target\library-management-system-1.0.0.jar
```

### **Source Code Location**
```
c:\Users\asus\Desktop\Libraray\src\main\java\com\library\
```

### **Maven Configuration**
```
c:\Users\asus\Desktop\Libraray\pom.xml
```

---

## 🔗 Related Documentation

- **COMMANDS.md** - Complete commands guide (this file)
- **JAR_LOCATION.md** - Detailed JAR information
- **README.md** - Project overview
- **MAVEN_BUILD.md** - Maven build details
- **SUMMARY.md** - Project summary

---

## ✅ Prerequisites

Before running commands, make sure you have:

- ✅ **Java 8 or higher** installed
  - Check: `java -version`
  - Download: https://www.oracle.com/java/technologies/downloads/

- ✅ **Maven 3.6 or higher** installed (for maven commands)
  - Check: `mvn --version`
  - Download: https://maven.apache.org/download.cgi

---

## 💡 Tips & Tricks

### **Speed Up Builds**
Skip tests during development:
```bash
mvn clean package -DskipTests
```

### **Run in Background**
Keep terminal free:
```bash
# Windows
start java -jar target\library-management-system-1.0.0.jar

# Linux/Mac
java -jar target/library-management-system-1.0.0.jar &
```

### **Save Command as Batch File** (Windows)
Create `run.bat`:
```batch
@echo off
cd /d %~dp0
java -jar target\library-management-system-1.0.0.jar
pause
```
Then just double-click `run.bat`!

### **Save Command as Shell Script** (Linux/Mac)
Create `run.sh`:
```bash
#!/bin/bash
cd "$(dirname "$0")"
java -jar target/library-management-system-1.0.0.jar
```
Then run: `bash run.sh`

---

## 🐛 Troubleshooting Commands

### **Not Working? Try These:**

**1. Check Java is Installed**
```bash
java -version
```

**2. Check Maven is Installed**
```bash
mvn --version
```

**3. Check JAR File Exists**
```bash
dir target\*.jar
```

**4. Check JAR is Valid**
```bash
jar tf target\library-management-system-1.0.0.jar
```

**5. Try Rebuilding**
```bash
mvn clean package -DskipTests
```

---

## 🎓 Understanding the Commands

### **java -jar**
Runs the compiled JAR file with Java Runtime

### **mvn clean package**
- `mvn` = Maven command
- `clean` = Remove old builds
- `package` = Compile and create JAR

### **javac**
Java compiler - converts `.java` files to `.class` files

### **jar**
Creates JAR (Java Archive) files

---

## 📞 Need Help?

1. **Check Documentation** → Read README.md
2. **Check Commands** → Use this file
3. **Check GitHub** → https://github.com/vishalkulria/Library-Management-System
4. **Check Java Docs** → https://docs.oracle.com/javase/8/
5. **Check Maven Docs** → https://maven.apache.org/guides/

---

## 🎉 Summary

**The Absolute Simplest Command:**
```bash
java -jar target\library-management-system-1.0.0.jar
```

**That's all you need to run your project!**

For more control and building from source, use Maven commands above.

---

**Your project is ready to run!** 🚀

Created: December 11, 2025  
Project: Library Management System v1.0.0  
Location: c:\Users\asus\Desktop\Libraray
