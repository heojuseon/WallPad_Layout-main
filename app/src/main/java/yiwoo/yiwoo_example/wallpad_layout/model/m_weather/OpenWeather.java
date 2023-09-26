package yiwoo.yiwoo_example.wallpad_layout.model.m_weather;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class OpenWeather {
    @SerializedName("weather")
    private List<Weather> weather;
    @SerializedName("base")
    private String base;
    @SerializedName("main")
    private Main main;
    @SerializedName("visibility")
    private int visibility; //가시성
    @SerializedName("dt")
    private long dt;    //데이터 계산 시간
    @SerializedName("timezone")
    private int timezone;   //UTC에서 초단위로 이동
    @SerializedName("id")
    private long id;    //도시 id
    @SerializedName("name")
    private String name;    //도시 이름

    public List<Weather> getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public Main getMain() {
        return main;
    }

    public int getVisibility() {
        return visibility;
    }

    public long getDt() {
        return dt;
    }

    public int getTimezone() {
        return timezone;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "OpenWeather{" +
                "weather=" + weather +
                ", base='" + base + '\'' +
                ", main=" + main +
                ", visibility=" + visibility +
                ", dt=" + dt +
                ", timezone=" + timezone +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
