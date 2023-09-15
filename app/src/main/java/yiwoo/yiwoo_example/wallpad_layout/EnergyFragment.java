package yiwoo.yiwoo_example.wallpad_layout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import yiwoo.yiwoo_example.wallpad_layout.progressbar.MyPagerAdapter;


public class EnergyFragment extends Fragment {
    static String TAG = "@!@";

    ViewPager2 viewPager2;
    MyPagerAdapter myPagerAdapter;

    Button btnNext, btnBack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "[에너지 프래그먼트]onCreateView() 호출");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_energy, container, false);

        viewPager2 = view.findViewById(R.id.progress_pager);
        myPagerAdapter = new MyPagerAdapter(getActivity());
        viewPager2.setAdapter(myPagerAdapter);

        btnBack = view.findViewById(R.id.left_button);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentItem = viewPager2.getCurrentItem();
                if (currentItem > 0) {
                    viewPager2.setCurrentItem(currentItem - 1);
                }
            }
        });

        btnNext = view.findViewById(R.id.right_button);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentItem = viewPager2.getCurrentItem();
                if (currentItem < myPagerAdapter.getItemCount() - 1) {
                    viewPager2.setCurrentItem(currentItem + 1);
                }
            }
        });

        return view;
    }
}