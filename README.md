# Logs - analyzer

## Instructions how to run/test the program from cmd

1. To complile use:

```bash
mvn clean package
```
2. To run use:

```bash
java -jar target/logs-analyze-1.0-SNAPSHOT.jar filePath
```
as filePath provide path to input file in resources. A sample log file is available in /resources/logfile.txt

3. To test use:

```bash
mvn test
```