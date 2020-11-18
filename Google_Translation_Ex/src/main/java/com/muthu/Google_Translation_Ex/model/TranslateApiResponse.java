package com.muthu.Google_Translation_Ex.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TranslateApiResponse {

	@JsonProperty("translations")
	private List<Translation> translation;

	public List<Translation> getTranslation() {
		return translation;
	}

	public void setTranslation(List<Translation> translation) {
		this.translation = translation;
	}
	
	
}
