package com.keruis.report.utils;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wanghuan on 2016/11/25.
 */
public class HttpUtils {

    /**
     * 根据 Object 给 response 返回 JSON 字符串
     * @param response
     * @param object
     * @return
     */
    public static boolean respJSON(HttpServletResponse response , Object object){
        if(response != null && object != null){
            Gson gson = new Gson();
            String respJson = gson.toJson(object);
            PrintWriter out = null;
            try {
                out = response.getWriter();
                out.write(respJson);
                out.flush();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(out != null){
                    out.close();
                }
            }

        }
        return false;
    }
}
