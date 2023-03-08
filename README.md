FlickSpotDemo
FlickSpotDemo is a demo project for Movie Booking System

Installation
Clone the repository:

bash
Copy code
git clone https://github.com/tibcogeek/FlickSpotDemo.git
Build the project:

bash
Copy code
cd FlickSpotDemo
./mvnw clean package
Usage
Run the application:

bash
Copy code
java -jar target/FlickSpotDemo-0.0.1-SNAPSHOT.jar
Open a web browser and go to http://localhost:8080/swagger-ui.html to view the API documentation and interact with the endpoints.

To authenticate, send a POST request to the /api/auth/signin endpoint with a JSON payload containing your username and password:

json
Copy code
{
"username": "user",
"password": "password"
}
The server will respond with a JSON object containing a JWT token:

json
Copy code
{
"token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNTE2MjM5MDIyfQ.1bOGl1Y7ZXwwb32dpseX7VnDn0Kh6UkH6vBmZQW8Sf4"
}
Use this token to authenticate future requests by including it in the Authorization header:

makefile
Copy code
Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VyIiwiaWF0IjoxNTE2MjM5MDIyfQ.1bOGl1Y7ZXwwb32dpseX7VnDn0Kh6UkH6vBmZQW8Sf4
Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.