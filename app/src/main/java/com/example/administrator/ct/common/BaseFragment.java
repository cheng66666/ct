package com.example.administrator.ct.common;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment extends Fragment {

    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(getContentViewId(),container,false);
        mUnbinder = ButterKnife.bind(this,view);
        initView(view);
        initData();
        return view;
    }

    protected abstract int getContentViewId();

    protected void initData() {
    }

    protected void initView(View view){

    }

    public void toastShort(String msg){
        Toast.makeText(getActivity(),msg,Toast.LENGTH_SHORT).show();
    }

    public void toastLong(String msg){
        Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroyView(){
        mUnbinder.unbind();
        super.onDestroyView();
    }//解绑

}
