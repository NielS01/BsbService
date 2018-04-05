Simple Microservice which validates a BSB number against the BSB list provided free 
by APCA (Australian Payments Clearing Association)

See swagger-ui link for operations:
	GET /bsbService	- retrieve branch details for the given BSB number
	                  example: http://localhost:8080/bsbService?bsbNumber=062032
	POST /bsbService/load - use this to initially load the BSB data 
	                  if you have downloaded the BSB file as a CSV 
	                  from APCA (http://bsb.apca.com.au/public/BSB_DB.NSF/publicBSB.xsp)
	
	POST /bsbService/loadFromUrl - use this to initially load the BSB data directly from APCA 
					  by providing the URL.  For example, as of April 2018, the latest BSB data is 
					  available from this link:
					   http://bsb.apca.com.au/Public/CS4BSBDir.nsf/0/FBDE6088E28C6EDDCA2582640019234E/$File/BSBDirectoryMar18-264.csv
	                  
Other useful links for this project:
* H2 Console: http://localhost:8080/h2-console
            use JDBC URL: jdbc:h2:mem:testdb
* Swagger UI: http://localhost:8080/swagger-ui.html            

     




 