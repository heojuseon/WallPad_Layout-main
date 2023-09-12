package yiwoo.yiwoo_example.wallpad_layout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ThirdProgressBarFragment extends Fragment {

    ProgressBar progressBar3;
    TextView progress_textView3;
    String percentText3;
    int progress3 = 75;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third_progress_bar, container, false);
        progressBar3 = view.findViewById(R.id.progressBar3);
        progressBar3.setProgress(progress3);

        progress_textView3 = view.findViewById(R.id.pro_text3);

        //퍼센트 값 textview 출력
        percentText3 = progress3 + "%";
        progress_textView3.setText(percentText3);

        return view;
//        return inflater.inflate(R.layout.fragment_progress_bar, container, false);
    }
}