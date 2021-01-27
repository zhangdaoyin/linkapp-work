package com.cundy.data.api.demo1;

import cn.hutool.json.JSONException;
import cn.hutool.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;

public class HttpUtil {

    /*
     * 处理https GET/POST请求
     * 请求地址、请求方法、参数
     * */
    public static String httpsRequest(String requestUrl,String requestMethod,HashMap<String,String> map){
        StringBuffer buffer=null;
        try{
            //创建SSLContext
            SSLContext sslContext=SSLContext.getInstance("SSL");
            TrustManager[] tm={new X509TrustUtil()};
            //初始化
            sslContext.init(null, tm, new java.security.SecureRandom());;
            //获取SSLSocketFactory对象
            SSLSocketFactory ssf=sslContext.getSocketFactory();
            URL url=new URL(requestUrl);
            HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod(requestMethod);
            //设置当前实例使用的SSLSoctetFactory
            conn.setSSLSocketFactory(ssf);
            //往服务器端写内容
            if (map != null) {
                Iterator<String> iteratorHeader = map.keySet()
                        .iterator();
                while (iteratorHeader.hasNext()) {
                    String key = iteratorHeader.next();
                    conn.setRequestProperty(key,
                            map.get(key));
                }
            }
            conn.connect();
            //读取服务器端返回的内容
            InputStream is=conn.getInputStream();
            InputStreamReader isr=new InputStreamReader(is,"utf-8");
            BufferedReader br=new BufferedReader(isr);
            buffer=new StringBuffer();
            String line=null;
            while((line=br.readLine())!=null){
                buffer.append(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return buffer.toString();
    }

    //处理http请求  requestUrl为请求地址  requestMethod请求方式，值为"GET"或"POST"
    public static String httpRequest(String requestUrl, String requestMethod, HashMap<String,String> map){
        StringBuffer buffer=null;
        try{
            URL url=new URL(requestUrl);
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod(requestMethod);
            //往服务器端写内容 也就是发起http请求需要带的参数
            if (map != null) {
                Iterator<String> iteratorHeader = map.keySet()
                        .iterator();
                while (iteratorHeader.hasNext()) {
                    String key = iteratorHeader.next();
                    conn.setRequestProperty(key,
                            map.get(key));
                }
            }
            conn.connect();
            //读取服务器端返回的内容
            InputStream is=conn.getInputStream();
            InputStreamReader isr=new InputStreamReader(is,"utf-8");
            BufferedReader br=new BufferedReader(isr);
            buffer=new StringBuffer();
            String line=null;
            while((line=br.readLine())!=null){
                buffer.append(line);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return buffer.toString();
    }

    public static String doPost(String serverUrl, JSONObject json){
        URL url;
        HttpURLConnection con;
        try {
            url = new URL(serverUrl);
            con = (HttpURLConnection) url.openConnection();
            con.setDoInput(true);
            con.setDoOutput(true);
            con.setUseCaches(false);
            con.setDefaultUseCaches(false);
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept-Language", "zh-cn");
            con.setRequestMethod("POST");
            PrintWriter out = new PrintWriter(con.getOutputStream());
            out.write(json.toString());
            out.flush();
            out.close();
            BufferedReader l_reader = new BufferedReader(
                    new InputStreamReader(con.getInputStream(),
                            "UTF-8"));
            // 得到返回的信息
            String sCurrentLine = "";
            StringBuffer sTotalString = new StringBuffer();
            while ((sCurrentLine = l_reader.readLine()) != null) {
                sTotalString.append(sCurrentLine);
                sTotalString.append("\n");
            }
            return sTotalString.toString();
        } catch ( Exception e) {
            try {
                e.getStackTrace();
                return "";
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
        }
        return "";
    }
}
