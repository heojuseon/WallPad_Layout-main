package yiwoo.yiwoo_example.wallpad_layout;

import android.content.Context;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import androidx.fragment.app.FragmentTransaction;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import yiwoo.yiwoo_example.wallpad_layout.view.WeatherFragment;


public class MainFragment extends Fragment {

    static String TAG = "@!@";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.weather_relativeLayout, new WeatherFragment());
        fragmentTransaction.add(R.id.energy_framelayout, new EnergyFragment());
        fragmentTransaction.add(R.id.maincontrol_constraint, new MainControlFragment());
        fragmentTransaction.add(R.id.detailcontrol_gridlayout, new DetailControlFragment());
        fragmentTransaction.commit();


        return view;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG, "[메인 프래그먼트]onAttach() 호출");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "[메인 프래그먼트]onCreate() 호출");
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "[메인 프래그먼트]onViewCreated() 호출");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.d(TAG, "[메인 프래그먼트]onViewStateRestored() 호출");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "[메인 프래그먼트]onStart() 호출");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "[메인 프래그먼트]onResume() 호출");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "[메인 프래그먼트]onPause() 호출");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "[메인 프래그먼트]onStop() 호출");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "[메인 프래그먼트]onSaveInstanceState() 호출");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "[메인 프래그먼트]onDestroyView() 호출");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "[메인 프래그먼트]onDestroy() 호출");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "[메인 프래그먼트]onDetach() 호출");
    }

}