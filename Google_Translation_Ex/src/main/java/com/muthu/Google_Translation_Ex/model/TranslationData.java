package com.muthu.Google_Translation_Ex.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TranslationData {
	
	@JsonProperty("data")
	private TranslateApiResponse translateApiResponse;

	public TranslateApiResponse getTranslateApiResponse() {
		return translateApiResponse;
	}

	public void setTranslateApiResponse(TranslateApiResponse translateApiResponse) {
		this.translateApiResponse = translateApiResponse;
	}
	
	

}
