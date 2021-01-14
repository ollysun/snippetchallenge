package com.webspoon.coding.challange.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import com.webspoon.coding.challange.model.Snippet;
import com.webspoon.coding.challange.model.request.SnippetRequestModel;
import com.webspoon.coding.challange.model.request.SnippetUpdateModel;

import lombok.extern.java.Log;

@Log
@Service
public class SnippetService {

	private static List<Snippet> snippetList = new ArrayList<>();

	public Snippet createSnippet(SnippetRequestModel snippetRequestModel, HttpServletRequest request) {

		Snippet snippet = new Snippet();
		snippet.setName(snippetRequestModel.getName());
		snippet.setSnippetString(snippetRequestModel.getSnippet());
		snippet.setExpires_at(addedSeconds(snippetRequestModel.getExpires_in()));
		snippet.setUrl(request.getRequestURL().toString());
		snippet.setPassword(snippetRequestModel.getPassword());

		snippetList.add(snippet);

		return snippet;

	}

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
				snippet.setExpires_at(checkTime(snippetUpdateModel.getExpires_In()));
				snippet.setName(snippetIterate.getName());
				snippet.setUrl(snippetIterate.getUrl());
			}
		}

		return snippet;
	}

	public List<Snippet> getSnippet() {
		if (snippetList.isEmpty()) {
			return Collections.emptyList();
		}

		List<Snippet> output = new ArrayList<>();
		for (Snippet snippet : snippetList) {
			int timedifference = checkSecondDifference(snippet.getExpires_at());
			if (timedifference > 60) {
				snippetList.remove(snippet);
			}
			output.add(snippet);
		}

		return output;
	}

	private Timestamp checkTime(Integer second) {
		if (second == null) {
			return addedSeconds(null);
		}
		return addedSeconds(second);

	}

	private static Timestamp addedSeconds(Integer secondsIn) {

		Date date = new Date();

		// Convert Date to Calendar
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		if (secondsIn != null) {
			c.add(Calendar.SECOND, secondsIn);
		} else {
			c.add(Calendar.SECOND, 30);
		}

		// get the currentdate
		Date currentDatePlusOne = c.getTime();

		return new Timestamp(currentDatePlusOne.getTime());
	}

	private static Integer checkSecondDifference(Timestamp timestamp) {

		Date timestampDateTime = new Date(timestamp.getTime());
		System.out.println("diffrese timestamo " + timestampDateTime.getSeconds());
		Date nowTime = new Date();
		System.out.println("diffrese now " + nowTime.getSeconds());

		Long different = nowTime.getTime() - timestampDateTime.getTime();

		long secondsInMilli = 1000;
		long minutesInMilli = secondsInMilli * 60;
		long hoursInMilli = minutesInMilli * 60;
		long daysInMilli = hoursInMilli * 24;

		long elapsedDays = different / daysInMilli;
		different = different % daysInMilli;

		long elapsedHours = different / hoursInMilli;
		different = different % hoursInMilli;

		long elapsedMinutes = different / minutesInMilli;
		different = different % minutesInMilli;

		long elapsedSeconds = different / secondsInMilli;

		System.out.println("diffrese " + elapsedSeconds);

		return (int) elapsedSeconds;

	}

}
