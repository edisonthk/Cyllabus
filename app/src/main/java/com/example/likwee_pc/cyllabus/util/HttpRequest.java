package com.example.likwee_pc.cyllabus.util;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by edisonthk on 2015/01/17.
 */
public class HttpRequest {

    private static final String CHARSET = "UTF-8";

    private static final int READ_TIMEOUT = 10000; // milliseconds
    private static final int CONNECT_TIMEOUT = 15000; // milliseconds

    private String mMethod;
    private String mUrl;
    private List<NameValuePair> mParams;

    public HttpRequest(String method, String url){
        mParams = null;
        mMethod = method;
        mUrl = url;
    }

    public String send()  throws IOException {
        return loadFromNetwork();
    }

    public void setParams(List<NameValuePair> params){
        this.mParams = params;
    }

    /** Initiates the fetch operation. */
    private String loadFromNetwork() throws IOException {
        InputStream stream = null;
        String str ="";

        try {
            stream = sendHTTPRequest(mUrl,mParams);
            str = readIt(stream, 500);
        } finally {
            if (stream != null) {
                stream.close();
            }
        }
        return str;
    }


    private InputStream sendHTTPRequest(String urlString, List<NameValuePair> params) throws IOException {

        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(READ_TIMEOUT);
        conn.setConnectTimeout(CONNECT_TIMEOUT);
        conn.setRequestMethod(mMethod);
        conn.setDoInput(true);
        conn.setDoOutput(true);

        if(params != null){
            OutputStream os = conn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(os, CHARSET));
            writer.write(getQuery(params));
            writer.flush();
            writer.close();
            os.close();
        }

        conn.connect();

        InputStream stream = conn.getInputStream();
        return stream;
    }

    private String getQuery(List<NameValuePair> params) throws UnsupportedEncodingException
    {
        StringBuilder result = new StringBuilder();
        boolean first = true;

        for (NameValuePair pair : params)
        {
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(pair.getName(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(pair.getValue(), "UTF-8"));
        }

        return result.toString();
    }

    private String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
        Reader reader = null;
        reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[len];
        reader.read(buffer);
        return new String(buffer);
    }
}
