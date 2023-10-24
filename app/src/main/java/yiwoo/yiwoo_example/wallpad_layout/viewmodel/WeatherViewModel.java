package yiwoo.yiwoo_example.wallpad_layout.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import yiwoo.yiwoo_example.wallpad_layout.model.m_weather.LiveTemp;
import yiwoo.yiwoo_example.wallpad_layout.model.m_weather.Temp;
import yiwoo.yiwoo_example.wallpad_layout.model.m_hubapi.Item;
import yiwoo.yiwoo_example.wallpad_layout.model.m_hubapi.WeatherClient;
import yiwoo.yiwoo_example.wallpad_layout.model.m_hubapi.WeatherModel;

public class WeatherViewModel extends ViewModel {
    private MutableLiveData<WeatherModel> weather = new MutableLiveData<>();
    //    private OpenWeatherClient client;
    private WeatherClient client;

    //LiveData 바인딩
    private MutableLiveData<String> warningMessage = new MutableLiveData<>();
    public MutableLiveData<String> state_weather = new MutableLiveData<>("");
    public MutableLiveData<String> result_temp = new MutableLiveData<>("");
    public MutableLiveData<String> result_Max_temp = new MutableLiveData<>("");
    public MutableLiveData<String> result_Min_temp = new MutableLiveData<>("");


//    public LiveData<String> getWarningMessage() {
//        return warningMessage;
//    }

//    public WeatherViewModel() {   //Model 클래스 사용 안 할경우
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
//                int randomTemp = new Random().nextInt(50);
//                live_temp.postValue(String.valueOf(randomTemp));// 값이 50을 초과하면 경고 메시지를 설정합니다.
//
//                if (randomTemp > 20) {
//                    warningMessage.postValue("30도 초과 경고");
//                }
//            }
//        }, 0, 10_000);   //10초 간격으로 실행
//    }

    public void init() {
        client = WeatherClient.getInstance();   //OpenWeatherClient 로 부터 객체 받아온다.
        client.getWeather(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                if (response.isSuccessful()) {
                    List<Item> it = response.body().getResponse().getBody().getItems().getItem();

                    String temp = "";        // 기온
                    String max_temp = "";   //최고 기온
                    String min_temp = "";   //최저 기온
                    String sky = "";        //현재 날씨

                    for (int i = 0; i < 10; i++) {
                        String category = it.get(i).getCategory();
                        String fcstValue = it.get(i).getFcstValue();
                        if (category.equals("TMP")) {
                            temp = fcstValue;
                        } else if (category.equals("SKY")) {
                            switch (fcstValue){
                                case "1":sky = "맑음";
                                    break;
                                case "3":sky = "구름많음";
                                    break;
                                case "4":sky = "흐림";
                                    break;
                                default:
                                    sky="오류";
                            }
                        } else {
                            continue;
                        }
                        //최저, 최고 기온 알기위해서(전체 사이즈 중에서, 가장 높은값 / 가장 낮은 값)
                        for (int i1 = 0; i1 < it.size(); i1++) {
                            String category2 = it.get(i1).getCategory();
                            String fcstValue2 = it.get(i1).getFcstValue();
                            if (category2.equals("TMX")) {
                                if (max_temp.isEmpty() || Float.parseFloat(fcstValue2) > Float.parseFloat(max_temp)){   //이전 최고 기온 값이 비어 있거나 현재 기온 값이 이전 최고 기온 값을 초과하면 새로운 최고 기온 값인 max_temp를 현재 기온 값 fcstValue2로 업데이트
                                    max_temp = fcstValue2;
                                }
                            } else if (category2.equals("TMN")) {
                                if (min_temp.isEmpty() || Float.parseFloat(fcstValue2) < Float.parseFloat(min_temp)){
                                    min_temp = fcstValue2;
                                }
                            }
                        }
                    }
                    result_temp.setValue(temp);
                    result_Max_temp.setValue(max_temp);
                    result_Min_temp.setValue(min_temp);
                    state_weather.setValue(sky);


                    Log.d("WeatherViewModel", "Api Connect Success");
                }
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {

            }
        });
    }


//    public LiveData<WeatherModel> getWeather() {
//
//
//        return weather;
//    }

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


