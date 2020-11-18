package com.muthu.Google_Translation_Ex.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.muthu.Google_Translation_Ex.model.TranslateApiResponse;
import com.muthu.Google_Translation_Ex.model.Translation;
import com.muthu.Google_Translation_Ex.model.TranslationData;

@Controller
@RequestMapping(value = "/google")
public class TranslationController {

	@Autowired
	private RestTemplate restTemplate;
	
	List<String> texts = Arrays.asList("Hello world, my name is muthuraja", "i am coming from madurai, age is 24");
	
	@GetMapping(value="/googleTranslation")
	public String getGoogleTranslateResp() {
		String translatedText = null;
		for(String s: texts) {
			
			translatedText = googleTranslationApiResp(s, "ja");
		}
		return translatedText;
	}
	
	public static List<String[]> splitByComma(String address){
		List<String[]> sp = new ArrayList<String[]>();
		
		String[] split = address.split(",");
		
		sp.add(split);
		
		return sp;
	}
	
	public static String appendByComma(String text[], int length) {
		StringBuilder sb =  new StringBuilder();
		
		for(int i=0; i< length; i++) {
			if( i== length -1) {
				sb.append(text[i]);
			} else {
				sb.append(text[i] + ",");
			}
		}
		return sb.toString();
	}
	
	public String googleTranslationApiResp(String texts, String language) {
		
		List<String[]> splitOutput = splitByComma(texts);
		
		String uri = "";
		
		List<String> str = new ArrayList<String>();
		
		String translatedText = "";
		
		TranslateApiResponse transApi = null;
		
		List<Translation> trans = null;
		
		TranslationData transData = null;
		
		for(String[] i: splitOutput) {
			for(String j : i) {
				uri= "https://translation.googleapis.com/language/translate/v2?key=XXXXXXXXXX&q="+ j + "&target=" + language;
				
				transData = restTemplate.getForObject(uri, TranslationData.class);
				
				if(transData != null) {
					transApi = transData.getTranslateApiResponse();
					trans = transApi.getTranslation();
					for(Translation tr : trans) {
						translatedText = tr.getTranslatedText();
					}
				}
				
				str.add(translatedText);
			}
		}
		
		String[] out = new String[str.size()];
		
		for(int i=0; i< str.size(); i++) {
			out[i] = str.get(i);
		}
		
		String appendedOut = appendByComma(out, out.length);
		
		return appendedOut;
	}
}
