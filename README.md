# TRIDent-LE
This project defines the code for generating JSON response from MISMO XML and vice versa for Loan Estimate

This service runs on port :9015

To run the server, enter into project folder and run

mvn spring-boot:run (or) java -jar *location of the jar file*

The above line will start the server at port 9015

If you want to change the port .Please start th server as mentioned below 

syntax : java -jar *location of the jar file* --server.port= *server port number*
 
example: java -jar target/TRIDentLoanEstimate.jar --server.port=9090

API to generate Loan Estimate JSON response(/actualize/transformx/trident/le/letojson) with input as Loan Estimate XML 

syntax : *server address with port*/actualize/transformx/trident/le/letojson; method :POST; Header: Content-Type:application/xml

example: http://localhost:9015/actualize/transformx/trident/le/letojson ; method: POST; Header: Content-Type:application/xml