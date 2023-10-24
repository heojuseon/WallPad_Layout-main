package yiwoo.yiwoo_example.wallpad_layout.view;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import yiwoo.yiwoo_example.wallpad_layout.AlarmReceiver;
import yiwoo.yiwoo_example.wallpad_layout.R;
import yiwoo.yiwoo_example.wallpad_layout.databinding.FragmentWeatherBinding;
import yiwoo.yiwoo_example.wallpad_layout.viewmodel.WeatherViewModel;


public class WeatherFragment extends Fragment {
    FragmentWeatherBinding weatherBinding;
    WeatherViewModel weatherViewModel;
//    private OpenWeather openWeather;
    static String TAG = "@!@";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "[날씨 프래그먼트] onCreateView()호출");
        // Inflate the layout for this fragment
        weatherBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_weather, container, false);
        weatherBinding.setLifecycleOwner(this);

        weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
        weatherBinding.setVm(weatherViewModel);


        weatherViewModel.init();    //viewModel 의 API 호출 메소드를 호출


        return weatherBinding.getRoot();
    }


}