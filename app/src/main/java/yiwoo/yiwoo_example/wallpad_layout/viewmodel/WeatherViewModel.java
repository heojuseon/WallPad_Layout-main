package yiwoo.yiwoo_example.wallpad_layout.viewmodel;

import android.annotation.SuppressLint;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import yiwoo.yiwoo_example.wallpad_layout.model.LiveTemp;
import yiwoo.yiwoo_example.wallpad_layout.model.Temp;
import yiwoo.yiwoo_example.wallpad_layout.model.m_weather.OpenWeather;
import yiwoo.yiwoo_example.wallpad_layout.model.m_weather.OpenWeatherClient;

public class WeatherViewModel extends ViewModel {

    //LiveData 바인딩
    public MutableLiveData<String> live_temp = new MutableLiveData<>("20");
    private MutableLiveData<String> warningMessage = new MutableLiveData<>();
    public MutableLiveData<String> high_temp = new MutableLiveData<>("0");
    public MutableLiveData<String> low_temp = new MutableLiveData<>("0");
    public MutableLiveData<String> state_weather = new MutableLiveData<>("구름 조금");

    Temp temp = new LiveTemp();


    private MutableLiveData<OpenWeather> weather = new MutableLiveData<>();
    private OpenWeatherClient client;


    public LiveData<String> getWarningMessage() {
        return warningMessage;
    }

    public WeatherViewModel() {   //Model 클래스 사용 안 할경우
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
//                temp.tempRandom();
//                live_temp.setValue(String.valueOf(temp.getRandTemp().nextInt(50)));
                int randomTemp = new Random().nextInt(50);
                live_temp.postValue(String.valueOf(randomTemp));// 값이 50을 초과하면 경고 메시지를 설정합니다.

                if (randomTemp > 20) {
                    warningMessage.postValue("30도 초과 경고");
                }
            }
        }, 0, 10_000);   //10초 간격으로 실행
    }

    public void init() {
        client = OpenWeatherClient.getInstance();   //OpenWeatherClient 로 부터 객체 받아온다.
        client.getWeather(new Callback<OpenWeather>() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onResponse(Call<OpenWeather> call, Response<OpenWeather> response) {
                OpenWeather result = response.body();
                weather.setValue(result);
                high_temp.setValue(String.format("%.1f", result.getMain().getTemp_max() - 273.15));

                Log.d("WeatherViewModel", "Api Connect Success");
                Log.d("WeatherViewModel", "2. Api Connect Success");
            }

            @Override
            public void onFailure(Call<OpenWeather> call, Throwable t) {
                Log.d("WeatherViewModel", "OnFailure : " + t.getMessage());
            }
        });
    }

    public LiveData<OpenWeather> getWeather() {


        return weather;
    }











//    public WeatherViewModel() {   //Model 클래스 사용
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                randomTemp();
//            }
//        }, 0, 10_000);   //10초 간격으로 실행
//    }
//
//    public void randomTemp() {
//        temp.tempRandom();
//        live_temp.postValue(String.valueOf(temp.getRandTemp().nextInt(50)));
//    }





//    public void randomTemp() {   //클릭시 온도 랜덤 출력
//
//        temp.tempRandom();
//        live_temp.setValue(String.valueOf(temp.getRandTemp().nextInt(50)));
//    }

}


