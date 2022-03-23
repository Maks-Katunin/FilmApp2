package kg.geektech.filmapp2.ui.error_fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import kg.geektech.filmapp2.R;
import kg.geektech.filmapp2.databinding.FragmentErrorBinding;

public class ErrorFragment extends Fragment {

    FragmentErrorBinding binding;

    public ErrorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentErrorBinding.inflate(getLayoutInflater());
        return binding.getRoot();
    }
}