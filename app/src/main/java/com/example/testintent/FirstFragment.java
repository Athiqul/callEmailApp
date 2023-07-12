package com.example.testintent;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.testintent.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @SuppressLint("QueryPermissionsNeeded")
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button emailSent=(Button) view.findViewById(R.id.email);
        EditText userMobile=(EditText) view.findViewById(R.id.mobile);
        emailSent.setOnClickListener(view1 -> {
          String mobile=userMobile.getText().toString();
            Toast.makeText(getActivity(),"Your Mobile Number is "+mobile,Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:"+mobile ));
            if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
                startActivity(intent);
            }
           /* Intent intent = new Intent(Intent.ACTION_SEN DTO);
            //intent.setData(Uri.parse("mailto:"+getEmail)); // Only email apps handle this.
            intent.putExtra(Intent.EXTRA_SUBJECT, "Testing Email");
            if (intent.resolveActivity(requireActivity().getPackageManager()) != null) {
                startActivity(intent);
            }*/

        });

        binding.buttonFirst.setOnClickListener(view12 -> NavHostFragment.findNavController(FirstFragment.this)
                .navigate(R.id.action_FirstFragment_to_SecondFragment));



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}