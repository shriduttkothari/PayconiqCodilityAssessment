# PayconiqCodilityAssessment
Payconiq SpringBoot Codility Assessment

Payconiq invites you to complete a Codility assessment Online in 50 Min Duration

## Requirements:
Implement below endpoints using springboot: 

Note: currentTime should be in ISO 8601, and Content-Type should be set to application/json.
	
HTTP GET 	http://localhost:8081/healthcheck?format=short		  HTTP OK, with body:{"status": "OK"}

HTTP GET 	http://localhost:8081/healthcheck?format=full		    HTTP OK, with body:{"status": "OK", "currentTime": "2022-06-29T10:33:26.547Z"}

HTTP GET 	http://localhost:8081/healthcheck  					        HTTP BAD_REQUEST

HTTP POST 	http://localhost:8081/healthcheck  					      HTTP METHOD_NOT_ALLOWED

HTTP PUT 	http://localhost:8081/healthcheck  					        HTTP METHOD_NOT_ALLOWED

HTTP DELETE http://localhost:8081/healthcheck  					      HTTP METHOD_NOT_ALLOWED

