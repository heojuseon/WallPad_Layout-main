package yiwoo.yiwoo_example.wallpad_layout;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import yiwoo.yiwoo_example.wallpad_layout.model.m_hubapi.WeatherClient;
import yiwoo.yiwoo_example.wallpad_layout.model.m_hubapi.WeatherModel;
import yiwoo.yiwoo_example.wallpad_layout.viewmodel.WeatherViewModel;

public class AlarmReceiver extends BroadcastReceiver {
    private WeatherViewModel weatherViewModel;
    @Override
    public void onReceive(Context context, Intent intent) {
//// 알람이 수신되면 WeatherViewModel의 init 메서드를 호출하여 날씨 업데이트
//        if (weatherViewModel == null) {
//            weatherViewModel = new WeatherViewModel();
//        }
//        weatherViewModel.init();
//
//        // 다음 알람 설정 (10초마다 호출)
//        setAlarm(context);
//
//        Log.d("onReceive", "10초후 호출==========");
    }
    private void setAlarm(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent alarmIntent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        long interval = 10 * 1000; // 10 seconds
        long triggerTime = SystemClock.elapsedRealtime() + interval;

        // 주기적 알람 설정
        alarmManager.set(AlarmManager.ELAPSED_REALTIME, triggerTime, pendingIntent);
    }
}
