package com.webspoon.coding.challange.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.webspoon.coding.challange.exception.SnippetException;
import com.webspoon.coding.challange.services.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.webspoon.coding.challange.model.Snippet;
import com.webspoon.coding.challange.model.request.SnippetRequestModel;
import com.webspoon.coding.challange.model.request.SnippetUpdateModel;
import com.webspoon.coding.challange.services.SnippetServiceImpl;

@RestController
public class SnippetController {

	@Autowired
	SnippetService snippetService;

    @GetMapping("/")
	public String defaultMessage() {
		return "Welcome to the Spring Boot Application Starter!";
	}

	@PostMapping("/snippet")
	public ResponseEntity<Snippet> createSnippet(@Valid @RequestBody SnippetRequestModel snippetRequestModel,
			HttpServletRequest request) {
		Snippet returnValue = snippetService.createSnippet(snippetRequestModel, request);
		return new ResponseEntity<>(returnValue, HttpStatus.CREATED);

	}

	@PutMapping("/snippet")
	public ResponseEntity<Snippet> updateSnippet(@Valid @RequestBody SnippetUpdateModel snippetUpdateModel) {

		if (snippetService.updateSnippet(snippetUpdateModel) == null) {
			throw new SnippetException("Empty List");
		}

		return new ResponseEntity<>(snippetService.updateSnippet(snippetUpdateModel), HttpStatus.OK);

	}

	@GetMapping("/snippet")
	public ResponseEntity<Snippet> getSnippet() {
		if (snippetService == null) {
			throw new SnippetException("Empty");
		}
		return new ResponseEntity<>(snippetService.getSnippet(), HttpStatus.OK);
	}

}
