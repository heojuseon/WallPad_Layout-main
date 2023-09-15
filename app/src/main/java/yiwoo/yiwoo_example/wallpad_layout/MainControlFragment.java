package yiwoo.yiwoo_example.wallpad_layout;

import android.os.Bundle;

import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainControlFragment extends Fragment {
    static String TAG = "@!@";

    boolean selected = false;
    LinearLayout riving_selected;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "[메인컨트롤러 프래그먼트] onCreateView() 호출");
        View view = inflater.inflate(R.layout.fragment_main_control, container, false);

        riving_selected = view.findViewById(R.id.btn_living_light);
        riving_selected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isSelected = view.isSelected();
                if (isSelected){
                    riving_selected.setSelected(false);
                }else {
                    riving_selected.setSelected(true);
                }
                // view.setSelected(!view.isSelected());

            }
        });





        return view;
    }
}