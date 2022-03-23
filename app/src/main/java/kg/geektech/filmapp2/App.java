package kg.geektech.filmapp2;

import android.app.Application;

import kg.geektech.filmapp2.data.remote.FilmApi;
import kg.geektech.filmapp2.data.remote.RetrofitClient;

public class App extends Application {

    private RetrofitClient retrofitClient;
    public static FilmApi api;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.createFilmApi();
    }
}
