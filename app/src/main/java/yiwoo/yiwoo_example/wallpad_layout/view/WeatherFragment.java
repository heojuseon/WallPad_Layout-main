package yiwoo.yiwoo_example.wallpad_layout.view;

import android.os.Bundle;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import yiwoo.yiwoo_example.wallpad_layout.R;
import yiwoo.yiwoo_example.wallpad_layout.databinding.FragmentWeatherBinding;
import yiwoo.yiwoo_example.wallpad_layout.model.Temp;
import yiwoo.yiwoo_example.wallpad_layout.model.m_weather.OpenWeather;
import yiwoo.yiwoo_example.wallpad_layout.viewmodel.WeatherViewModel;


public class WeatherFragment extends Fragment {
    FragmentWeatherBinding weatherBinding;
    WeatherViewModel weatherViewModel;
    private OpenWeather openWeather;
    static String TAG = "@!@";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "[날씨 프래그먼트] onCreateView()호출");
        // Inflate the layout for this fragment
        weatherBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_weather, container, false);
        weatherBinding.setLifecycleOwner(this);

        weatherViewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
//        weatherBinding.setVm("***");    //변수에 값을 할당 한다. 이렇게 사용할 경우 layout 에서  ex) android:text="@{myText}" 형대로 사용
        weatherBinding.setWeather(weatherViewModel);

        //view 가 viewModel 을 관찰 하다가 이벤트 발생(Toast)
        weatherViewModel.getWarningMessage().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(String warningMessage) {
                if (warningMessage != null) {
                    Toast.makeText(requireContext(), warningMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });

        weatherViewModel.live_temp.observe(getViewLifecycleOwner(), currentTemp -> {
            int temp = Integer.parseInt(currentTemp);
            if(temp > 30) {
                Toast.makeText(requireContext(), "hot : " + temp, Toast.LENGTH_SHORT).show();
            }

        });



        //Max_Temp
        weatherViewModel.init();
        weatherViewModel.getWeather().observe(getViewLifecycleOwner(), new Observer<OpenWeather>() {
            @Override
            public void onChanged(OpenWeather openWeather) {
                Log.d("WeatherFragment","API Connection finish");
                openWeather = weatherViewModel.getWeather().getValue();
                Log.d("WeatherFragment", openWeather.toString());
            }
        });


        return weatherBinding.getRoot();
    }


}