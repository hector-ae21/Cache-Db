## Description:
This project is a local persistent database that is capable of storing key-value pairs and grouping them into data collections.

## Project Structure

The project structure is the classic structure of a gradle project with several subprojects. We will find the following files and folders:

- `lib` Subproject for the library.
- `app` Subproject for the console application.
- `gradlew[.bat]` Script to use gradle included in the project.
- `settings.gradle` Configuration file where the project name is defined as well as the included subprojects.

## Library
The library subproject is intended to create the business logic separate from the application itself.

## Application
The application subproject is intended for the implementation of a console application (CLI - Command Line Interface).

## Project Compilation
To compile the complete project
```
./gradlew build
```

To compile one of the specific subprojects:
```
./gradlew build -p lib
./gradlew build -p app
```
## Check tests in the project
To launch all the tests of the project
```
./gradlew test
```

To launch the tests of a specific subproject:
```
./gradlew test -p lib
./gradlew test -p app
```
## Use of the console application

When compiling the `app` subproject, a distribution of the application is generated as a compressed file `build/distributions/app.zip`. When unzipping, an `app` folder will appear that will contain the .jar files generated from the compilation (subfolder `lib`) and the scripts to launch the application (subfolder `app`).

## Available Commands

```
app.bat add <key> <value>  # Adds a value to the library in the default collection
app.bat add <key> <value> -collect <collection> # Adds a new key-value pair to the indicated collection
app.bat put <key> <value>  # Updates a value of the library in the default collection if it exists
app.bat put <key> <value> -collect <collection> # Updates a key-value pair in the indicated collection if it exists, otherwise it creates it
app.bat get <key>          # Gets a value from the library in the default collection if it exists
app.bat get <key> -collect <collection> # Gets a value from the indicated Collection if it exists
app.bat remove <key>       # Removes a value from the library in the default collection if it exists
app.bat remove <key> -collect <collection> # Removes a value from the indicated Collection if it exists
app.bat exists <key>       # Checks if a value exists in the library in the default collection
app.bat exists <key> -collect <collection> # Checks if a value exists in the indicated Collection
app.bat get-all            # Gets all the keys from the library in the default collection
app.bat get-all -collect <collection> # Gets all the keys from the indicated Collection
app.bat get-all -c        # Gets the number of values from the library in the default collection
app.bat get-all -c -collect <collection> # Gets the number of values from the indicated Collection

```

### Unit Tests
The project has unit tests that check the correct operation of each of the methods and classes implemented

### Collections
The project has data collections that allow storing and retrieving data efficiently. In case a collection is not indicated, the data will be stored in a "default" collection.
To indicate the collection it is necessary to use any of the following parameters:
- -collect <collection-name>
- --collection <collection-name>

### Persistence with Encryption
All stored data is encrypted so that in case of accessing the persistence file you cannot access the information

### Persistence with compression
All stored data is compressed into a single zip file for each collection.

[gradle]: https://gradle.org
[picocli]: https://picocli.info
