package kg.geektech.filmapp2.ui.film_details;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.bumptech.glide.Glide;

import kg.geektech.filmapp2.App;
import kg.geektech.filmapp2.R;
import kg.geektech.filmapp2.data.models.Film;
import kg.geektech.filmapp2.databinding.FragmentFilmDetailBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmDetailFragment extends Fragment {
    private FragmentFilmDetailBinding binding;

    public FilmDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmDetailBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String data = getArguments().getString("data");
        App.api.getFilmDetail(data).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
              if (response.isSuccessful() && response.body() != null){
                  setFilmDetails(response.body());
              }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                NavController navController = Navigation.findNavController(requireActivity(),
                        R.id.nav_host_fragment);
                navController.navigate(R.id.errorFragment);
            }
        });
    }


    @SuppressLint("SetTextI18n")
    private void setFilmDetails(Film body) {
        Glide.with(this).load(body.getMovieBanner()).
                into(binding.ivMovieBanner);
        binding.title.setText("Title \n" +body.getTitle() +"\n");
        binding.originalTitle.setText("Original title \n" + body.getOriginalTitle() +"\n");
        binding.director.setText("Director \n" + body.getDirector() +"\n");
        binding.producer.setText("Producer \n" + body.getProducer() +"\n");
        binding.releaseDate.setText("Release date \n" + body.getReleaseDate() +"\n");
        binding.runningTime.setText("Running time \n" + body.getRunningTime() +"\n");
    }
}