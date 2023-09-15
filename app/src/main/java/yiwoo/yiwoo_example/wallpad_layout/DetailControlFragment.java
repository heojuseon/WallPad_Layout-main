package yiwoo.yiwoo_example.wallpad_layout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

public class DetailControlFragment extends Fragment {
    LinearLayout linearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_control, container, false);

        //리니어 레이아웃에 클릭이벤트 추가
        linearLayout = view.findViewById(R.id.box_layout_click);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 클릭 이벤트 처리 코드
                Toast.makeText(getActivity(), "box_layout 클릭되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

}