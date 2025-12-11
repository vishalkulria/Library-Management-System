# Maven Build Guide

This document provides detailed instructions for building and running the Library Management System using Maven.

## Prerequisites

### Required Software
- **Java Development Kit (JDK)**: Version 1.8 or higher
  - Download from: https://www.oracle.com/java/technologies/javase-downloads.html
  
- **Maven**: Version 3.6.0 or higher
  - Download from: https://maven.apache.org/download.cgi
  - Installation Guide: https://maven.apache.org/install.html

- **Git**: For cloning the repository
  - Download from: https://git-scm.com/downloads

### Verify Installation
```bash
# Check Java version
java -version

# Check Maven version
mvn -version

# Check Git version
git --version
```

## Project Build Configuration

### POM.xml Overview
The `pom.xml` file contains:
- **Group ID**: com.library
- **Artifact ID**: library-management-system
- **Version**: 1.0.0
- **Packaging**: JAR

### Key Plugins
1. **Maven Compiler Plugin** - Compiles Java source code
2. **Maven Shade Plugin** - Creates a fat JAR with all dependencies
3. **Maven JAR Plugin** - Packages the application
4. **Maven Surefire Plugin** - Runs unit tests
5. **Maven Assembly Plugin** - Creates assembly packages

## Building the Project

### Step 1: Clone the Repository
```bash
git clone https://github.com/vishalkulria/Library-Management-System.git
cd Library-Management-System
```

### Step 2: Build with Maven

#### Full Clean Build (Recommended)
```bash
mvn clean package
```

This command:
- Removes previous build artifacts
- Compiles the source code
- Runs unit tests
- Packages the application into JAR files

#### Output
- **JAR File**: `target/library-management-system-1.0.0-shaded.jar`
- **Tests Report**: `target/surefire-reports/`

#### Build Without Tests
```bash
mvn clean package -DskipTests
```

#### Build Specific Module
```bash
mvn clean package -pl :library-management-system
```

## Running the Application

### Method 1: Using Maven Directly
```bash
mvn exec:java -Dexec.mainClass="com.library.ui.LibraryManagementSystem"
```

### Method 2: Using Generated JAR
```bash
java -jar target/library-management-system-1.0.0-shaded.jar
```

### Method 3: Using Assembly JAR
```bash
# First build with assembly
mvn clean assembly:assembly -DdescriptorId=jar-with-dependencies

# Then run
java -jar target/library-management-system-1.0.0-jar-with-dependencies.jar
```

## Running Tests

### Run All Tests
```bash
mvn test
```

### Run Specific Test
```bash
mvn test -Dtest=BookTest
```

### Generate Test Report
```bash
mvn test
# Reports available in: target/surefire-reports/
```

### Skip Tests During Build
```bash
mvn clean package -DskipTests
```

## Common Maven Commands

| Command | Description |
|---------|-------------|
| `mvn clean` | Removes all build artifacts |
| `mvn compile` | Compiles source code only |
| `mvn test` | Runs unit tests |
| `mvn package` | Creates JAR file |
| `mvn install` | Installs the JAR to local repository |
| `mvn deploy` | Deploys to remote repository |
| `mvn dependency:tree` | Shows dependency tree |
| `mvn help:active-profiles` | Shows active profiles |

## IDE Integration

### IntelliJ IDEA
1. Open project as Maven project
2. Right-click on `pom.xml` → Add as Maven Project
3. Maven window opens on the right
4. Double-click goals to run (e.g., `package`, `clean`)

### Eclipse
1. File → Import → Maven → Existing Maven Projects
2. Select the project directory
3. Right-click project → Run As → Maven build

### VS Code
1. Install "Maven for Java" extension
2. Right-click `pom.xml` → Run Maven commands
3. Or use terminal: `mvn clean package`

## Project Structure

```
Library-Management-System/
├── pom.xml                          # Maven configuration
├── .gitignore                       # Git ignore rules
├── README.md                        # Main documentation
├── MAVEN_BUILD.md                   # This file
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/library/
│   │   │       ├── model/           # Data models
│   │   │       │   ├── Book.java
│   │   │       │   ├── Student.java
│   │   │       │   └── IssuedBook.java
│   │   │       └── ui/              # User interface
│   │   │           └── LibraryManagementSystem.java
│   │   └── resources/               # Resource files
│   │
│   └── test/
│       └── java/
│           └── com/library/
│               └── model/
│                   └── BookTest.java # Unit tests
│
└── target/                          # Build output
    ├── classes/                     # Compiled classes
    ├── test-classes/                # Test classes
    ├── library-management-system-1.0.0.jar
    └── library-management-system-1.0.0-shaded.jar
```

## Troubleshooting

### Issue: Maven command not found
**Solution**: 
- Check Maven is installed in PATH
- Run: `echo $PATH` (Linux/Mac) or `echo %PATH%` (Windows)
- Add Maven bin directory to PATH if not present

### Issue: Java version mismatch
**Solution**:
```bash
# Check current Java version
java -version

# Set JAVA_HOME environment variable
export JAVA_HOME=/path/to/jdk  # Linux/Mac
set JAVA_HOME=C:\path\to\jdk   # Windows
```

### Issue: Build fails with dependency errors
**Solution**:
```bash
# Clear Maven cache
mvn clean

# Update dependencies
mvn dependency:purge-local-repository

# Rebuild
mvn clean package
```

### Issue: Tests fail
**Solution**:
```bash
# Run with verbose output
mvn test -X

# Run specific test with debug
mvn test -Dtest=BookTest -X
```

### Issue: JAR file not created
**Solution**:
1. Check build logs for compilation errors
2. Verify all source files are in correct directories
3. Ensure pom.xml is not corrupted
4. Run: `mvn clean compile` to check compilation

## Maven Central Repository

The project downloads dependencies from Maven Central Repository:
- **URL**: https://repo.maven.apache.org/maven2/

### Current Dependencies
- **JUnit 4.13.2** - Unit testing framework

## Custom Maven Settings

### Create Custom Settings File
```bash
cp ~/.m2/settings.xml ~/.m2/settings.xml.backup
# Edit ~/.m2/settings.xml for custom configurations
```

### Set Proxy (if required)
Edit `.m2/settings.xml`:
```xml
<proxy>
    <id>myproxy</id>
    <active>true</active>
    <protocol>http</protocol>
    <host>proxy.example.com</host>
    <port>8080</port>
</proxy>
```

## Performance Tips

### Speed Up Builds
1. **Skip Tests**: `mvn clean package -DskipTests`
2. **Parallel Build**: `mvn clean package -T 1C`
3. **Offline Mode**: `mvn clean package -o` (requires downloaded dependencies)
4. **Quiet Mode**: `mvn clean package -q`

### Check Build Performance
```bash
mvn clean package -DskipTests --log-file build.log
cat build.log | grep "BUILD SUCCESS\|BUILD FAILURE"
```

## Continuous Integration

### GitHub Actions Example
Create `.github/workflows/maven.yml`:
```yaml
name: Maven Build

on: [push, pull_request]

jobs:
  build:
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@v2
      - name: Set up JDK 11
        uses: actions/setup-java@v2
        with:
          java-version: '11'
      - name: Build with Maven
        run: mvn clean package
```

## Next Steps

1. **Explore IDE Integration**: Use your favorite IDE with Maven
2. **Add More Tests**: Expand unit test coverage
3. **Database Integration**: Add database support
4. **Continuous Integration**: Set up CI/CD pipelines
5. **Documentation**: Generate JavaDoc with `mvn javadoc:javadoc`

## Additional Resources

- Maven Official Documentation: https://maven.apache.org/
- Maven Central Repository: https://mvnrepository.com/
- JUnit Testing: https://junit.org/junit4/
- Java Development Kit: https://docs.oracle.com/javase/

## Support

For issues or questions:
1. Check the main README.md
2. Review Maven documentation
3. Search Maven Central Repository for dependency issues
4. Open an issue on GitHub: https://github.com/vishalkulria/Library-Management-System/issues

---

**Happy Building!** 🚀
