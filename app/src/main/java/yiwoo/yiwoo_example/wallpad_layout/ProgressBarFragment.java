package yiwoo.yiwoo_example.wallpad_layout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarFragment extends Fragment {

    ProgressBar progressBar;
    TextView progress_textView;
    String percentText;
    int progress = 25;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_progress_bar, container, false);
        progressBar = view.findViewById(R.id.progressBar);
        progressBar.setProgress(progress);

        progress_textView = view.findViewById(R.id.pro_text);

        //퍼센트 값 textview 출력
        percentText = progress + "%";
        progress_textView.setText(percentText);

                return view;
//        return inflater.inflate(R.layout.fragment_progress_bar, container, false);
    }


}