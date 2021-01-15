package com.webspoon.coding.challange.services;

import com.webspoon.coding.challange.model.Snippet;
import com.webspoon.coding.challange.model.request.SnippetRequestModel;
import com.webspoon.coding.challange.model.request.SnippetUpdateModel;

import javax.servlet.http.HttpServletRequest;

public interface SnippetService {

    Snippet createSnippet(SnippetRequestModel snippetRequestModel, HttpServletRequest request);

    Snippet updateSnippet(SnippetUpdateModel snippetUpdateModel);

    Snippet getSnippet();
}
