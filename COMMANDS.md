# 🚀 Complete Guide: Commands to Run Your Project

## 📋 Table of Contents
1. [Quick Start](#quick-start)
2. [Using JAR File](#using-jar-file)
3. [Using Maven](#using-maven)
4. [Using Java Compiler](#using-java-compiler)
5. [Development & Testing](#development--testing)
6. [Build & Packaging](#build--packaging)
7. [All Commands Reference](#all-commands-reference)

---

## 🎯 Quick Start

### **Fastest Way (Using JAR File)**
```bash
cd c:\Users\asus\Desktop\Libraray
java -jar target\library-management-system-1.0.0.jar
```

**That's it!** Your application will launch immediately.

---

## 📦 Using JAR File

### **Method 1: Command Line (Windows)**
```bash
cd c:\Users\asus\Desktop\Libraray
java -jar target\library-management-system-1.0.0.jar
```

### **Method 2: Full Path (Windows)**
```bash
java -jar c:\Users\asus\Desktop\Libraray\target\library-management-system-1.0.0.jar
```

### **Method 3: Windows PowerShell**
```powershell
cd 'c:\Users\asus\Desktop\Libraray'
java -jar target\library-management-system-1.0.0.jar
```

### **Method 4: Linux/Mac**
```bash
cd /path/to/Libraray
java -jar target/library-management-system-1.0.0.jar
```

### **Method 5: Double-Click (No Command Needed)**
1. Navigate to: `c:\Users\asus\Desktop\Libraray\target\`
2. Find: `library-management-system-1.0.0.jar`
3. Double-click it
4. Application launches!

---

## 🔧 Using Maven

### **Build the Project**
```bash
cd c:\Users\asus\Desktop\Libraray
mvn clean package
```

This will:
- Clean previous builds
- Compile source code
- Run tests
- Create JAR files in `target/` directory

### **Build Without Running Tests**
```bash
mvn clean package -DskipTests
```

Use this for faster builds when you don't need to run tests.

### **Run Application via Maven**
```bash
mvn exec:java -Dexec.mainClass="com.library.ui.LibraryManagementSystem"
```

### **Just Compile Without Packaging**
```bash
mvn compile
```

### **Run Only Tests**
```bash
mvn test
```

### **Clean Build Artifacts**
```bash
mvn clean
```

### **Install to Local Repository**
```bash
mvn install
```

### **Create Site Documentation**
```bash
mvn site
```

### **View Project Information**
```bash
mvn project-info-reports:project-info
```

---

## ☕ Using Java Compiler

### **Compile Java Source Files**
```bash
cd c:\Users\asus\Desktop\Libraray
javac -d target/classes src/main/java/com/library/model/*.java src/main/java/com/library/ui/*.java
```

### **Create JAR File from Compiled Classes**
```bash
jar cfe target/library-management-system-1.0.0.jar com.library.ui.LibraryManagementSystem -C target/classes .
```

### **Run Compiled Classes Directly** (without JAR)
```bash
cd c:\Users\asus\Desktop\Libraray
java -cp target/classes com.library.ui.LibraryManagementSystem
```

---

## 🧪 Development & Testing

### **Run Unit Tests**
```bash
mvn test
```

### **Run Specific Test**
```bash
mvn test -Dtest=BookTest
```

### **Run Tests with Verbose Output**
```bash
mvn test -X
```

### **Skip Tests During Build**
```bash
mvn clean package -DskipTests
```

### **View Test Results**
```bash
# Open this file in browser after running tests
target/surefire-reports/index.html
```

---

## 📦 Build & Packaging

### **Complete Maven Build**
```bash
mvn clean package
```

### **Build Fat JAR (with all dependencies)**
```bash
mvn clean package -Pdependencies
```

### **Create Assembly JAR**
```bash
mvn assembly:single
```

### **Check JAR Contents**
```bash
jar tf target/library-management-system-1.0.0.jar
```

### **Extract JAR Contents** (if needed)
```bash
mkdir jar-contents
cd jar-contents
jar xf ../target/library-management-system-1.0.0.jar
```

### **Generate JavaDoc**
```bash
mvn javadoc:javadoc
```

---

## 📊 All Commands Reference

### **Quick Command Cheat Sheet**

| Task | Command |
|------|---------|
| **Run Application (Fastest)** | `java -jar target\library-management-system-1.0.0.jar` |
| **Build Project** | `mvn clean package` |
| **Build (Skip Tests)** | `mvn clean package -DskipTests` |
| **Run via Maven** | `mvn exec:java -Dexec.mainClass="com.library.ui.LibraryManagementSystem"` |
| **Compile** | `javac -d target/classes src/main/java/com/library/model/*.java src/main/java/com/library/ui/*.java` |
| **Run Tests** | `mvn test` |
| **Clean Build** | `mvn clean` |
| **Check Java Version** | `java -version` |
| **List JAR Contents** | `jar tf target/library-management-system-1.0.0.jar` |
| **Generate JavaDoc** | `mvn javadoc:javadoc` |
| **Install Dependencies** | `mvn install` |
| **Skip Compilation** | `mvn clean package -Dmaven.compiler.skip=true` |

---

## 🎯 Step-by-Step: From Scratch

### **Step 1: Navigate to Project**
```bash
cd c:\Users\asus\Desktop\Libraray
```

### **Step 2: Build the Project**
```bash
mvn clean package
```

### **Step 3: Run the Application**
```bash
java -jar target\library-management-system-1.0.0.jar
```

**That's all!** The application will launch with a GUI window.

---

## 🔍 Troubleshooting Commands

### **Check Java Installation**
```bash
java -version
javac -version
```

### **Check Maven Installation**
```bash
mvn --version
```

### **Check if JAR File Exists**
```bash
dir target\*.jar
# or
ls -lh target/*.jar  # Linux/Mac
```

### **Test JAR Validity**
```bash
jar tf target\library-management-system-1.0.0.jar
```

### **Run with Verbose Output** (to debug issues)
```bash
java -jar target\library-management-system-1.0.0.jar
```

---

## 💡 Environment Setup Commands

### **Check Current Directory**
```bash
cd
# or
pwd
```

### **List Project Files**
```bash
dir
# or
ls -la
```

### **View Directory Tree**
```bash
tree /F
# or
find . -type f -name "*.java"
```

### **Set JAVA_HOME** (if needed on Windows)
```bash
set JAVA_HOME=C:\Program Files\Java\jdk1.8.0_291
set PATH=%JAVA_HOME%\bin;%PATH%
```

### **Set MAVEN_HOME** (if needed on Windows)
```bash
set MAVEN_HOME=C:\apache-maven-3.9.11
set PATH=%MAVEN_HOME%\bin;%PATH%
```

---

## 🎓 Understanding the Commands

### **java -jar command**
```bash
java -jar target\library-management-system-1.0.0.jar
```
- `java` = Java Runtime
- `-jar` = Execute JAR file flag
- `target\library-management-system-1.0.0.jar` = Path to JAR file

### **mvn clean package command**
```bash
mvn clean package
```
- `mvn` = Maven command
- `clean` = Remove old build files
- `package` = Compile and create JAR

### **javac command**
```bash
javac -d target/classes src/main/java/com/library/model/*.java
```
- `javac` = Java Compiler
- `-d target/classes` = Output directory
- `src/main/java/com/library/model/*.java` = Source files to compile

---

## 📱 Running on Different Systems

### **Windows Command Prompt**
```cmd
cd c:\Users\asus\Desktop\Libraray
java -jar target\library-management-system-1.0.0.jar
```

### **Windows PowerShell**
```powershell
cd 'c:\Users\asus\Desktop\Libraray'
java -jar target\library-management-system-1.0.0.jar
```

### **Linux/Ubuntu**
```bash
cd ~/Desktop/Libraray  # or actual path
java -jar target/library-management-system-1.0.0.jar
```

### **macOS**
```bash
cd ~/Desktop/Libraray  # or actual path
java -jar target/library-management-system-1.0.0.jar
```

---

## 🚀 Most Common Commands

### **For Daily Development:**

1. **Build & Run**
```bash
mvn clean package && java -jar target\library-management-system-1.0.0.jar
```

2. **Just Run (if already built)**
```bash
java -jar target\library-management-system-1.0.0.jar
```

3. **Build Without Tests (Faster)**
```bash
mvn clean package -DskipTests && java -jar target\library-management-system-1.0.0.jar
```

4. **Run Tests**
```bash
mvn test
```

5. **Quick Compile**
```bash
mvn compile
```

---

## ✅ Verification Commands

### **Verify Installation**
```bash
# Check Java
java -version

# Check Maven
mvn -version

# Check project structure
tree /F
```

### **Verify Build Success**
```bash
# Check if JAR exists
dir target\*.jar

# Check JAR is valid
jar tf target\library-management-system-1.0.0.jar
```

---

## 📚 Additional Resources

### **Maven Documentation**
- Official: https://maven.apache.org/
- Commands: https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html

### **Java Commands**
- Java Runtime: https://docs.oracle.com/javase/8/docs/technotes/tools/windows/java.html
- Javac Compiler: https://docs.oracle.com/javase/8/docs/technotes/tools/windows/javac.html

### **Your Project Documentation**
- `README.md` - Project overview
- `MAVEN_BUILD.md` - Maven details
- `JAR_LOCATION.md` - JAR file guide
- `SUMMARY.md` - Project summary

---

## 🎯 TL;DR (Too Long; Didn't Read)

### **Just Want to Run It?**
```bash
cd c:\Users\asus\Desktop\Libraray
java -jar target\library-management-system-1.0.0.jar
```

### **Want to Build & Run?**
```bash
cd c:\Users\asus\Desktop\Libraray
mvn clean package
java -jar target\library-management-system-1.0.0.jar
```

That's it! Your application is ready to use! 🎉

---

**Last Updated:** December 11, 2025
**Project Version:** 1.0.0
**Repository:** https://github.com/vishalkulria/Library-Management-System
