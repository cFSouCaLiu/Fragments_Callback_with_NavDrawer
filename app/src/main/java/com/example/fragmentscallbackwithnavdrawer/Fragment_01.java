package com.example.fragmentscallbackwithnavdrawer;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.fragmentscallbackwithnavdrawer.utils.Gol;

import org.jetbrains.annotations.NotNull;
public class Fragment_01 extends Fragment {
//var emplacement
    private static final  String emplacement = Fragment_01.class.getSimpleName();
    FragmentManager fragmentManager;

    //

    @Override
    public void onAttach(@NonNull @NotNull Context context) {
        super.onAttach(context);
        Gol.addLog(emplacement, "onAttach");

    }

    private void btn_addFragment(View view) {
        addFragment();
    }

    private void addFragment() {
    }

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Gol.addLog(emplacement,"onCreate");



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Gol.addLog(emplacement, "onCreateView");
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_01, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Gol.addLog(emplacement, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Gol.addLog(emplacement,"onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Gol.addLog(emplacement, "onPause");

    }

    @Override
    public void onStop() {
                super.onStop();
        Gol.addLog(emplacement,"onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Gol.addLog(emplacement,"onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Gol.addLog(emplacement,"onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Gol.addLog(emplacement,"onDetach");
    }

}