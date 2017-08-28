package org.youtwo.android_build_an_app_architecture_components.data.network;

import android.support.annotation.NonNull;
import org.youtwo.android_build_an_app_architecture_components.data.database.WeatherEntry;

/**
 * Created by Bill on 2017/8/27.
 */

class WeatherResponse {

  @NonNull
  private final WeatherEntry[] mWeatherForecast;

  public WeatherResponse(@NonNull final WeatherEntry[] weatherForecast) {
    mWeatherForecast = weatherForecast;
  }

  public WeatherEntry[] getWeatherForecast() {
    return mWeatherForecast;
  }
}
