package com.org.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.dto.Movie;
import com.org.dto.Response;
import com.org.service.MovieService;

/**
 * 
 * @author sujit.sahoo
 *
 */
@RestController
public class DynamoController {
	@Autowired
	MovieService movieServiceImpl;

	@GetMapping(path = "/hello",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getHello() {
		return ResponseEntity.ok("<html><body><b1>Hello Project</b1></body></html>");
	}

	@GetMapping(path = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> getDetails(String year, String title) {
		Movie movie = movieServiceImpl.getItem(year, title);
		if(movie!=null)
		{
			Response response = new Response();
			response.setData(movie);
			response.setMessage("Success");
		return ResponseEntity.ok(response);
		}
		else
		{
			Response response = new Response();
			response.setMessage("No Data FOund");
			ResponseEntity<Response> responseEntity = new ResponseEntity<Response>(response, HttpStatus.NOT_FOUND);
			return responseEntity;
		}
	}

	@PostMapping(path = "/add",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addDetails(@RequestBody Movie movie) {
		movieServiceImpl.addItem(movie);
		return ResponseEntity.ok("Success");
	}

	@PutMapping(path = "/update",produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateDetails(@RequestBody Movie movie) {
		movieServiceImpl.updateItem(movie);
		return ResponseEntity.ok("Success");
	}

	@DeleteMapping(path = "/delete",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteDetails(String year, String title) {
		movieServiceImpl.deleteItem(year, title);
		return ResponseEntity.ok("Success");
	}

}
