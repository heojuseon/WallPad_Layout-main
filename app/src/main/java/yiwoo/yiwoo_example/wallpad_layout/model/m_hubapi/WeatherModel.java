package yiwoo.yiwoo_example.wallpad_layout.model.m_hubapi;

import com.google.gson.annotations.SerializedName;

public class WeatherModel {
    @SerializedName("response")
    public Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response response) {
        this.response = response;
    }
}
