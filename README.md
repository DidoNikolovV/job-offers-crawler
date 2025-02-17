This is a Sample Spring Boot application that crawls job listings from multiple sources (Dev.bg, LinkedIn, etc.) and stores them in database. The project supports multi-threaded crawling with an Object Pool and provides an API to retrieve job offers.
Features
    Multi-threaded crawling with configurable concurrency.
    Supports multiple job websites like LinkedIn, Dev.bg, and Indeed.
    REST API to fetch job listings.
    Swagger API Documentation for easy exploration.

## Technologies Used
- **Java**
- **Spring Boot**
- **Gradle**
- **MySQL**

🔧 Setup & Installation
### Prerequisites

Ensure you have the following prerequisites installed on your system:
- Java Development Kit (JDK)
   - This project requires Java 17.
- Gradle - 7.5 or higher
- IDE: IntelliJ
- MySQL

# Clone the repository:**
   ```bash
   git clone https://github.com/DidoNikolovV/job-offers-crawler.git
   ```
## Navigate to the project directory
   ```bash
   cd job-offers-crawler
   ```
### Open InteliJ in the project directory
   ```bash
   idea .
   ```
### **Update Application Configuration**
    Open the src/main/resources/application.yml file.

    Locate the following section and update the MySQL connection details according to your setup:

    yaml

    datasource:
     driverClassName: com.mysql.cj.jdbc.Driver
     url: jdbc:mysql://<your-database-host>:<your-database-port>/job_offers_db?allowPublicKeyRetrieval=true&useSSL=false&createDatabaseIfNotExist=true&serverTimezone=UTC
     username: <your-database-username>
     password: <your-database-password>

    Update url, username, and password as needed.

### Build
  ```bash
   git switch master
   ```
  ```bash
   ./gradlew clean build
   ```
### **Run the application**
    Go to the main class, right click and run it.
The API will start running at http://localhost:8080. 

📜 Accessing Swagger UI

Follow these steps to access the Swagger UI for exploring the API:
1. Start your application.
2. Open a web browser.
3. Navigate to [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).
4. Explore available endpoints.
