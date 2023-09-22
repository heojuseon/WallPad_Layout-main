package yiwoo.yiwoo_example.wallpad_layout.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import yiwoo.yiwoo_example.wallpad_layout.model.LiveTemp;
import yiwoo.yiwoo_example.wallpad_layout.model.Temp;

public class WeatherViewModel extends ViewModel {
    public MutableLiveData<String> live_temp = new MutableLiveData<>("20");
    public MutableLiveData<String> high_temp = new MutableLiveData<>("0");
    public MutableLiveData<String> low_temp = new MutableLiveData<>("0");
    public MutableLiveData<String> state_weather = new MutableLiveData<>("구름 조금");

    Temp temp = new LiveTemp();


//    public WeatherViewModel() {   //Model 클래스 사용 안 할경우
//        Timer timer = new Timer();
//        timer.scheduleAtFixedRate(new TimerTask() {
//            @Override
//            public void run() {
////                temp.tempRandom();
////                live_temp.setValue(String.valueOf(temp.getRandTemp().nextInt(50)));
//                int randomTemp = new Random().nextInt(50);
//                live_temp.postValue(String.valueOf(randomTemp));
//            }
//        }, 0, 10_000);   //10초 간격으로 실행
//    }

    public WeatherViewModel() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                randomTemp();
            }
        }, 0, 10_000);   //10초 간격으로 실행
    }

    public void randomTemp() {
        temp.tempRandom();
        live_temp.postValue(String.valueOf(temp.getRandTemp().nextInt(50)));
    }







//    public void randomTemp() {   //클릭시 온도 랜덤 출력
//
//        temp.tempRandom();
//        live_temp.setValue(String.valueOf(temp.getRandTemp().nextInt(50)));
//    }

}


