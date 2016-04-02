package com.test.iptv.service;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.net.URL;
import java.util.List;

/**
 * Developed by rubayet on 4/2/16.
 */
public class JsonRequestHandler {
    static String response =null;
    public final static int GET =  1;
    public final static int POST = 2;

    public JsonRequestHandler(){

    }

    public String JsonRequestHandler(String url,int method){
        return this.JsonRequestHandler(url,method,null);
    }

    public String JsonRequestHandler(String url,int method, List<NameValuePair> params){
        try{
            // http client
            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpEntity httpEntity = null;
            HttpResponse httpResponse = null;

            // Checking http request method type
            if (method == POST) {
                HttpPost httpPost = new HttpPost(url);
                // adding post params
                if (params != null) {
                    httpPost.setEntity(new UrlEncodedFormEntity(params));
                }

                httpResponse = httpClient.execute(httpPost);


            }else if (method == GET) {
                // appending params to url
                if (params != null) {
                    String paramString = URLEncodedUtils
                            .format(params, "utf-8");
                    url += "?" + paramString;
                }
                HttpGet httpGet = new HttpGet(url);

                httpResponse = httpClient.execute(httpGet);

            }

            httpEntity = httpResponse.getEntity();
            response = EntityUtils.toString(httpEntity);

        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }
}
