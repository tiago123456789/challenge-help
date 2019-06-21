package com.tiago.desafio.services;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

abstract class AbstractReqresService<T> {

    protected String urlBase = "https://reqres.in/api/";

    protected T request(String path, HttpMethod method, Class classe) {
        String url = this.urlBase + path;

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", MediaType.APPLICATION_JSON.toString());
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate restTemplate = new RestTemplate();
        return (T) restTemplate.exchange(url, method, entity, classe).getBody();
    }
}
