package com.codility.healthcheck.controller;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *	Payconiq invites you to complete a Codility assessment Online in 50 Min Duration
 *	
 *	Requirements:
 *	Implement below endpoints, 
 *	Note: currentTime should be in ISO 8601, and Content-Type should be set to application/json.
 *	
 *	HTTP GET 	http://localhost:8081/healthcheck?format=short		HTTP OK, with body:{"status": "OK"}
 *	HTTP GET 	http://localhost:8081/healthcheck?format=full		HTTP OK, with body:{"status": "OK", "currentTime": "2022-06-29T10:33:26.547Z"}
 *	HTTP GET 	http://localhost:8081/healthcheck  					HTTP BAD_REQUEST
 *	HTTP POST 	http://localhost:8081/healthcheck  					HTTP METHOD_NOT_ALLOWED
 *	HTTP PUT 	http://localhost:8081/healthcheck  					HTTP METHOD_NOT_ALLOWED
 *	HTTP DELETE http://localhost:8081/healthcheck  					HTTP METHOD_NOT_ALLOWED
 *	
 * @author Shridutt Kothari
 */
@RestController
class HealthCheckController {

	@GetMapping(value = "/healthcheck", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseDTO> healthcheck(@RequestParam(name = "format") String format) {
		ResponseDTO responseDTO = null;
		if ("short".equals(format)) {
			responseDTO = new ResponseDTO("OK");
		} else if ("full".equals(format)) {
			responseDTO = new ResponseDTO("OK",
					OffsetDateTime.now(ZoneOffset.UTC).format(DateTimeFormatter.ISO_INSTANT));
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
	}

	@PutMapping(value = "/healthcheck")
	public ResponseEntity<Void> healthcheckPut() {
		return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
	}

	@PostMapping(value = "/healthcheck")
	public ResponseEntity<Void> healthcheckPost() {
		return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
	}

	@DeleteMapping(value = "/healthcheck")
	public ResponseEntity<Void> healthcheckDelete() {
		return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
	}

	public static class ResponseDTO {

		private String status;
		@JsonInclude(Include.NON_NULL)
		private String currentTime;

		public ResponseDTO(String status) {
			this.status = status;
		}

		public ResponseDTO(String status, String currentTime) {
			this.status = status;
			this.currentTime = currentTime;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getCurrentTime() {
			return currentTime;
		}

		public void setCurrentTime(String currentTime) {
			this.currentTime = currentTime;
		}
	}

}
