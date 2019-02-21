package com.zdq.myweather;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /*
    * 和风天气访问接口   此key是WEB API 的 Key
    * android key:b43bf87697eb4b258ed983f4edcd72f0
    * https://free-api.heweather.net/s6/weather/now?location=CN101010100&key=155537e37f11425287af50512851a035
    *
    * 区域列表：http://guolin.tech/api/china
    * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
