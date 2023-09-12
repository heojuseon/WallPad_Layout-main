package yiwoo.yiwoo_example.wallpad_layout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyPagerAdapter extends FragmentStateAdapter {

    Fragment[] fragments = new Fragment[] {new ProgressBarFragment(), new SecondProgressBarFragment(), new ThirdProgressBarFragment()};

//       Fragment fragments = new Fragment();
    // 뷰페이저에 보여줄 페이지 개수 설정
//    private static final int NUM_PAGES = 1;

    public MyPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

//        // 해당 위치(position)에 따라 프래그먼트 반환
//        if (position == 0){ // 첫번째 위치일 경우 FirstFragment 화면 반환
//            fragments = new ProgressBarFragment();
//        }
//        // 위치에 따른 프래그먼트 반환
//        return fragments;

        return fragments[position];
    }

    @Override
    public int getItemCount() {
//        return NUM_PAGES;    //페이지 수

        return fragments.length;   //페이지 수
    }
}
