package yiwoo.yiwoo_example.wallpad_layout.model.m_weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class OpenWeatherClient {
    private static OpenWeatherClient instance;
    public static final String WEATHER_URL= "https://api.openweathermap.org/data/2.5/";
    public Retrofit retrofit;
    private OpenWeatherAPI openWeatherAPI;


    public static OpenWeatherClient getInstance() { //하나의 OpenWeatherClient 인스턴스만 사용,  이 인스턴스를 통해 네트워크 호출 등의 작업을 수행하고 결과를 공유할 수 있다.
        if (instance == null){
            //최초 호출 시, instance 변수가 null인 경우에만 인스턴스를 생성하고 그 값을 반환
            instance = new OpenWeatherClient();
        }
        //이미 생성된 OpenWeatherClient 인스턴스가 있을 경우, 이를 반환 따라서 애플리케이션 내에서는 항상 동일한 인스턴스를 사용가능
        return instance;
    }

    public void getWeather(Callback<OpenWeather> callback) {
        //retrofit 객체 생성
        retrofit = new Retrofit.Builder()
                .baseUrl(WEATHER_URL)
                .addConverterFactory(GsonConverterFactory.create()) //Retrofit이 서버와의 통신에서 JSON 데이터를 Java 객체로 변환하고, Java 객체를 JSON으로 변환하여 서버로 보내는 작업을 자동으로 처리
                .build();

        //인터페이스 객체 생성
        openWeatherAPI = retrofit.create(OpenWeatherAPI.class);
        //api와 통신
        callWeatherAPI(callback);
    }

    private void callWeatherAPI(Callback<OpenWeather> callback) {
        Call<OpenWeather> call = openWeatherAPI.getWeather("sangam-dong", "6f38939bc018b8de98482e464f0cb6eb", "kr");
        call.enqueue(callback); //비동기 터리, 네트워크 요청이 완료되면 결과를 메인 스레드로 전달
    }
}
