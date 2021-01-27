package com.cundy.data.api.demo1;

import org.json.JSONArray;
import org.json.JSONObject;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

public class SRMTest {
    static String url = "http://127.0.0.1:8060/";
    static String method = "POST";

  public static void main(String[] args) throws Exception {
    HashMap<String, String> map = new HashMap<>();
    //封装数据
      JSONObject jsonObject = new JSONObject();
      JSONArray array = new JSONArray();
      JSONObject json = new JSONObject();
      json.put("No", "修改14-1341");
      json.put("Code", "XG13-A087");
      array.put(json);
      JSONObject json1 = new JSONObject();
      json1.put("No", "修改16-6553");
      json1.put("Code", "修改14-1341");
      array.put(json1);
      JSONObject json2 = new JSONObject();
      json2.put("No", "XG13-A087");
      json2.put("Code", "修改16-6553");
      array.put(json2);
      jsonObject.put("data", array);
      System.out.println(jsonObject);
      String receive = URLEncoder.encode(jsonObject.toString(), "UTF-8");
      map.put("receive", receive);
      String serverUrl = url + "/receive/receiveCodeBySRM.action";

      String result = HttpUtil.httpRequest(serverUrl,method,map);
      System.out.println(result);
      JSONObject strObject = new JSONObject(result);
      System.out.println("处理结果：" + strObject.opt("status"));
      System.out.println("处理消息：" + strObject.opt("msg"));
      System.out.println("记录ID：" + strObject.opt("logId"));
  }
}
