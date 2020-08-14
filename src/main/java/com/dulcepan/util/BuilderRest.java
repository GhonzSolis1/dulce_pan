package com.dulcepan.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class BuilderRest<T> {
    private RestTemplate restTemplate = new RestTemplate();
    private String url;
    private Map<String,String> mapHeader;
    private Object body = null;
    private MultiValueMap<String, String> params;
    private Class<T> objectClass;
    private HttpMethod method;
    private String authorization = null;


    public BuilderRest(String url) {
        this.url = url;
        mapHeader = new HashMap<>();
        params  = new HttpHeaders();
    }
    public com.dulcepan.util.BuilderRest<T> path(String path){
        this.url = this.url+path;
        return this;
    }
    public com.dulcepan.util.BuilderRest<T> param(String key, String value){
        this.params.add(key, value);
        return this;
    }
    public com.dulcepan.util.BuilderRest<T> header(String name, String value){
        this.mapHeader.put(name, value);
        return this;
    }


    public com.dulcepan.util.BuilderRest<T> body(Object body){
        this.body = body;
        return this;
    }
    public com.dulcepan.util.BuilderRest<T> objectClass(Class<T> objectClass){
        this.objectClass = objectClass;
        return this;
    }
    private HttpHeaders headers(){
        HttpHeaders headers = new HttpHeaders();
        for(String key : mapHeader.keySet()){
            headers.set(key, mapHeader.get(key));
        }
        return headers;
    }
    private URI url(){
        if (params.isEmpty()){
            return UriComponentsBuilder.fromHttpUrl(url).build().encode().toUri();
        }else{
            return UriComponentsBuilder.fromHttpUrl(url).queryParams(params).build().encode().toUri();
        }
    }
    public T build(){
        if(body!=null && !method.equals(HttpMethod.GET)){
            return restTemplate.exchange(this.url(),method, new HttpEntity<Object>(body, this.headers()), objectClass).getBody();
        }else{

            return restTemplate.exchange(this.url,method, new HttpEntity<Object>(this.headers()), objectClass).getBody();
        }
    }

    public com.dulcepan.util.BuilderRest<T> get(){
        this.method = HttpMethod.GET;
        return this;
    }
    public com.dulcepan.util.BuilderRest<T> post(){
        this.method = HttpMethod.POST;
        return this;
    }

    public com.dulcepan.util.BuilderRest<T> authorization(String authorization){
        this.authorization = authorization;
        return this;
    }
    public com.dulcepan.util.BuilderRest<T> basicAuth(String name, String pass){
        String auth =name+ ":"+pass;
        String encodedAuth= Base64.getEncoder().encodeToString(auth.getBytes(StandardCharsets.UTF_8));
        String authHeader = "Basic "+encodedAuth;
        header("Authorization",authHeader);
        this.authorization = authHeader;
        return this;
    }
}