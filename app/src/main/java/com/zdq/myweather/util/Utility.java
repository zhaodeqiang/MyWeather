package com.zdq.myweather.util;

import android.text.TextUtils;

import com.zdq.myweather.db.City;
import com.zdq.myweather.db.County;
import com.zdq.myweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
    /**
     * 处理省级数据
     * @param response 响应结果 json格式
     * @return TRUE or FALSE
     */
    public static boolean handleProvinceResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray jsonArrays = new JSONArray(response);
                for (int i = 0; i < jsonArrays.length(); i++) {
                    JSONObject provinceObject = jsonArrays.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    /**
     * 处理城市数据
     * @param response 响应数据
     * @param provinceId 城市ID
     * @return TRUE or FALSE
     */
    public static boolean handleCityResponse(String response, int provinceId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray jsonArrays = new JSONArray(response);
                for (int i = 0; i < jsonArrays.length(); i++) {
                    JSONObject cityObject = jsonArrays.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return false;
    }

    /**
     *处理县级数据
     * @param response 响应数据
     * @param cityId 城市ID
     * @return TRUE or FALSE
     */
    public static boolean handleCountyResponse(String response, int cityId) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray jsonArrays = new JSONArray(response);
                for (int i = 0; i < jsonArrays.length(); i++) {
                    JSONObject countyObject = jsonArrays.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
