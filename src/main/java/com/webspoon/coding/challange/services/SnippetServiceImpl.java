package com.webspoon.coding.challange.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webspoon.coding.challange.model.Snippet;
import com.webspoon.coding.challange.model.request.SnippetRequestModel;
import com.webspoon.coding.challange.model.request.SnippetUpdateModel;

import lombok.extern.java.Log;

@Log
@Service
public class SnippetServiceImpl implements SnippetService{

	@Autowired
	private Util util;

	private static List<Snippet> snippetList = new ArrayList<>();

	@Override
	public Snippet createSnippet(SnippetRequestModel snippetRequestModel, String request) {

		Snippet snippet = new Snippet();
		snippet.setName(snippetRequestModel.getName());
		snippet.setSnippetString(snippetRequestModel.getSnippet());
		snippet.setExpires_at(util.addedSeconds(snippetRequestModel.getExpires_in()));
		snippet.setUrl(request);
		snippet.setPassword(snippetRequestModel.getPassword());

		snippetList.add(snippet);

		return snippet;

	}

	@Override
	public Snippet updateSnippet(SnippetUpdateModel snippetUpdateModel) {
		if (snippetList.isEmpty()) {
			return (Snippet) Collections.emptyList();
		}

		Snippet snippet = new Snippet();

		Iterator<Snippet> iterator = snippetList.iterator();
		while (iterator.hasNext()) {
			Snippet snippetIterate = iterator.next();
			if (snippetIterate.getPassword().equals(snippetUpdateModel.getPassword())) {
				snippet.setSnippetString(snippetUpdateModel.getSnippet());
				snippet.setPassword(snippetUpdateModel.getPassword());
				snippet.setExpires_at(util.checkTime(snippetUpdateModel.getExpires_In()));
				snippet.setName(snippetIterate.getName());
				snippet.setUrl(snippetIterate.getUrl());
			}
		}

		return snippet;
	}

	@Override
	public Snippet getSnippet() {
		if (snippetList.isEmpty()) {
			return null;
		}

		List<Snippet> output = new ArrayList<>();
		Snippet out2 = new Snippet();
		for (Snippet snippet : snippetList) {
			int timedifference = util.checkSecondDifference(snippet.getExpires_at());
			if (timedifference > 60) {
				snippetList.remove(snippet);
			}
			output.add(snippet);
		}

		return output.get(0);
	}






}
