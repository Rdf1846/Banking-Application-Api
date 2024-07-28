# Banking Application 

## Overview
 The Banking Application is a comprehensive system for managing bank accounts. In this project, we developed REST APIs for a straightforward banking application utilizing SpringBoot, Spring Data JPA (Hibernate), a MySQL database and secured with Okta authentication. The core functionalities include creating a bank account, deleting an account, retrieving account details, depositing funds, withdrawing funds, and more.

 ## API
 Link : [API LINK](usefulResources/Rahul-Banking-API-Details.pdf)

## Features

1. **Create Bank Account**: Allows the users to create new bank accounts.
2. **Delete Bank Account**: Enables users to delete existing bank accounts.
3. **Fetch Account Details**: Provides users with detailed information about their bank accounts.
4. **Deposit Funds**: Allows the users to deposit funds into their bank accounts.
5. **Withdraw Funds**: Enables users to withdraw funds from their bank accounts.
6. **Update User Details**: Let the users update their personal information and account details.
7. **Secure Authentication**: Uses Okta security for managing user authentication and authorization.

## Technologies Used

- **Backend**: Spring Boot
- **Database**: MySQL
- **ORM**: Spring Data JPA (Hibernate)
- **Authentication**: Okta
- **Build Tool**: Maven

## Setup and Installation

### Prerequisites

- Java 11 or higher
- MySQL
- Maven

### Backend Setup

1. **Clone the repository:**
    ```bash
    git clone [https://github.com/yourusername/banking-application-ap.git]
    cd banking-application-ap
    ```

2. **Configure MySQL Database:**
    Update the `application.properties` file with your MySQL database details:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/yourdbname
    spring.datasource.username=yourusername
    spring.datasource.password=yourpassword
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
    ```

3. **Build the backend:**
    ```bash
    mvn clean install
    ```

4. **Run the backend:**
    ```bash
    mvn spring-boot:run
    ```

### Okta Authentication Setup

1. **Create an Okta Developer Account:**
    Sign up at [Okta Developer](https://developer.okta.com/).

2. **Create a New Application in Okta:**
    - Go to **Applications** > **Add Application**.
    - Choose **Web** and click **Next**.
    - Fill in the required details and save the application.
    - Note down the **Client ID** and **Client Secret**.

3. **Update Okta Configuration:**
    Update the `application.properties` file with your Okta details:
    ```properties
    okta.oauth2.issuer=https://{yourOktaDomain}/oauth2/default
    okta.oauth2.client-id={yourClientId}
    okta.oauth2.client-secret={yourClientSecret}
    ```

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request.

## Contact

For any inquiries or support, please contact:
- **Name**: Rahul Kasana
- **Email**: rahulkasana1846@gmail.com
- **Location**: Ghaziabad, Uttar Pradesh

---

Happy Banking!


 
