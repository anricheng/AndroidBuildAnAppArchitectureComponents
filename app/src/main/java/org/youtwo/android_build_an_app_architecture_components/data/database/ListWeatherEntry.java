package org.youtwo.android_build_an_app_architecture_components.data.database;


import java.util.Date;

/**
 * Simplified {@link WeatherEntry} which only contains the details needed for the weather list in
 * the {@link com.example.android.sunshine.ui.list.ForecastAdapter}
 */
public class ListWeatherEntry {

  private int id;
  private int weatherIconId;
  private Date date;
  private double min;
  private double max;

  public ListWeatherEntry(int id, int weatherIconId, Date date, double min, double max) {
    this.id = id;
    this.weatherIconId = weatherIconId;
    this.date = date;
    this.min = min;
    this.max = max;
  }

  public int getId() {
    return id;
  }

  public int getWeatherIconId() {
    return weatherIconId;
  }

  public Date getDate() {
    return date;
  }

  public double getMin() {
    return min;
  }

  public double getMax() {
    return max;
  }
}
