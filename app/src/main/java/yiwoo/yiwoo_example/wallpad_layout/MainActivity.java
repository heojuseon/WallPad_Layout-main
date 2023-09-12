package yiwoo.yiwoo_example.wallpad_layout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //레이아웃에 클릭 이벤트 설정
    LinearLayout linearLayout;

    ViewPager2 viewPager2;
    MyPagerAdapter myPagerAdapter;

    Button btnNext, btnBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        relativeLayout = findViewById(R.id.relativeLayout);
//        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        layoutInflater.inflate(R.layout.example, relativeLayout, true);

        viewPager2 = findViewById(R.id.progress_pager);
        myPagerAdapter = new MyPagerAdapter(this);
        viewPager2.setAdapter(myPagerAdapter);

        btnBack = findViewById(R.id.left_button);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentItem = viewPager2.getCurrentItem();
                if (currentItem > 0) {
                    viewPager2.setCurrentItem(currentItem - 1);
                }
            }
        });


        btnNext = findViewById(R.id.right_button);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentItem = viewPager2.getCurrentItem();
                if (currentItem < myPagerAdapter.getItemCount() - 1) {
                    viewPager2.setCurrentItem(currentItem + 1);
                }
            }
        });



        //리니어 레이아웃에 클릭이벤트 추가
        linearLayout = findViewById(R.id.box_layout_click);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 클릭 이벤트 처리 코드
                Toast.makeText(getApplicationContext(), "box_layout 클릭되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });



        //네비게이션 바 제거(fullScreen)
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

    }
}