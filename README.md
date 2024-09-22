# URL Shortener 🚀

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Spring Data JPA](https://img.shields.io/badge/Spring_Data_JPA-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![H2 Database](https://img.shields.io/badge/H2-003545?style=for-the-badge&logo=h2&logoColor=white)
![Google Guava](https://img.shields.io/badge/Google_Guava-4285F4?style=for-the-badge&logo=google&logoColor=white)

A URL shortener service built using Java, Spring Boot, Spring Data JPA, H2 Database, and Google's Guava API for hashing. This application allows users to create shortened URLs with optional expiration times and provides redirection to the original URL.

## Features 🌟
- Shorten URLs with a customizable expiration time.
- Default expiration time of 120 seconds if none is provided.
- Automatically manages expired URLs.
- Redirects to the original URL when accessing the shortened URL.

## Technologies Used 🛠️
- **Java**: Core programming language.
- **Spring Boot**: Backend framework for building the REST APIs.
- **Spring Data JPA**: ORM to handle database operations.
- **H2 Database**: In-memory database for simplicity.
- **Google Guava API**: Used for hashing to generate unique short URLs.

## APIs 📄

### 1. Create Shortened URL
- **URI**: `POST /create`
- **Request Body**: JSON with two fields: `originalUrl` (mandatory) and `validity` (optional).
  - If `validity` is not provided, the default is 120 seconds.
- **Request Example**:
    ```json
    {
      "originalUrl": "https://www.google.com/",
      "validity": "200"
    }
    ```
- **Response Example**:
    ```json
    {
      "originalUrl": "https://www.google.com/",
      "shortUrl": "cadaaea1",
      "expiryTime": "2024-09-22T18:34:16.6640681"
    }
    ```

### 2. Redirect to Original URL
- **URI**: `GET /{shortUrl}`
- **Request Example**: `GET /cadaaea1`
- **Functionality**: Redirects to the original URL associated with the short URL, if it's not expired.

## How It Works ⚙️
1. **Short URL Creation**: 
    - The `POST /create` API takes the original URL and an optional validity duration in seconds. It returns a shortened URL along with the expiry time. If no validity is provided, the default is 120 seconds.
2. **Redirection**:
    - The `GET /{shortUrl}` API checks the short URL's validity. If the short URL has not expired, the user is redirected to the original URL. Otherwise, it returns an error.

## Running the Project 🚀
To run this project locally:
1. Clone the repository.
2. Build the project using Maven.
3. Run the application. The server will be available at `localhost:9001`.
