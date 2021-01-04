#DSP Bidder Coding Session
###Built With:
[Spring](https://spring.io/)



INSTALLATION
---
_Code requires valid Token from mockApi.
<br>
To obtain new token please refer to instructions provided by you in paragraph "Authentication".
Token has been "hardcoded" as per requirements in BannersClient.class under TOKEN field._
<br>

* cloning repository `git clone https://github.com/Wrona1990/BannerConsumer.git`
* generating .jar file `mvn clean package spring-boot:repackage`
* executing .jar file `java -jar BannerConsumer-1.0.0.jar`
* port on which applications tomcat server is listening = 8080

RUNNING
---
_To run the application you need mock API provided:
 <br>
 running and listening on port **different** than 8080_
* Application accepts Http Request GET:
`http://localhost:8080/banners/bidder/?bidId=X&adsize=YxY`

_where X = bidId_

_where adsize (of pattern) = NUMBERxNUMBER_
* Application returns JSON payload with banner provided by mock API in given adsize.

EXAMPLE
---
1. Curl Example:
`http://localhost:8080/banners/bidder/?bidId=test&adsize=728x90`
2. Response: 
`{
     "id": "test",
     "bannerId": 1,
     "price": 10
 }`
 
