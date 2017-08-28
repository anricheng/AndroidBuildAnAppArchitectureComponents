package org.youtwo.android_build_an_app_architecture_components.utilities;

import android.content.Context;
import java.util.Date;
import org.youtwo.android_build_an_app_architecture_components.AppExecutors;
import org.youtwo.android_build_an_app_architecture_components.data.SunshineRepository;
import org.youtwo.android_build_an_app_architecture_components.data.database.SunshineDatabase;
import org.youtwo.android_build_an_app_architecture_components.data.network.WeatherNetworkDataSource;
import org.youtwo.android_build_an_app_architecture_components.ui.detail.DetailViewModelFactory;
import org.youtwo.android_build_an_app_architecture_components.ui.list.MainViewModelFactory;

/**
 * Provides static methods to inject the various classes needed for Sunshine
 */

public class InjectorUtils {

  public static SunshineRepository provideRepository(Context context) {
    SunshineDatabase database = SunshineDatabase.getInstance(context.getApplicationContext());
    AppExecutors executors = AppExecutors.getInstance();
    WeatherNetworkDataSource networkDataSource =
        WeatherNetworkDataSource.getInstance(context.getApplicationContext(), executors);
    return SunshineRepository.getInstance(database.weatherDao(), networkDataSource, executors);
  }

  public static WeatherNetworkDataSource provideNetworkDataSource(Context context) {
    // This call to provide repository is necessary if the app starts from a service - in this
    // case the repository will not exist unless it is specifically created.
    provideRepository(context.getApplicationContext());
    AppExecutors executors = AppExecutors.getInstance();
    return WeatherNetworkDataSource.getInstance(context.getApplicationContext(), executors);
  }

  public static DetailViewModelFactory provideDetailViewModelFactory(Context context, Date date) {
    SunshineRepository repository = provideRepository(context.getApplicationContext());
    return new DetailViewModelFactory(repository, date);
  }

  public static MainViewModelFactory provideMainActivityViewModelFactory(Context context) {
    SunshineRepository repository = provideRepository(context.getApplicationContext());
    return new MainViewModelFactory(repository);
  }
}
