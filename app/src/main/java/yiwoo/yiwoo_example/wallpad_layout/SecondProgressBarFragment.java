package yiwoo.yiwoo_example.wallpad_layout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SecondProgressBarFragment extends Fragment {

    ProgressBar progressBar2;
    TextView progress_textView2;
    String percentText2;
    int progress2 = 50;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second_progress_bar, container, false);
        progressBar2 = view.findViewById(R.id.progressBar2);
        progressBar2.setProgress(progress2);

        progress_textView2 = view.findViewById(R.id.pro_text2);

        //퍼센트 값 textview 출력
        percentText2 = progress2 + "%";
        progress_textView2.setText(percentText2);

        return view;
//        return inflater.inflate(R.layout.fragment_progress_bar, container, false);
    }
}