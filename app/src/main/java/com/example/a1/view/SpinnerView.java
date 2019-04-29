package com.example.a1.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;

import java.util.ArrayList;

/**
 * Created by 1 on 2019/4/15.
 */

public class SpinnerView extends LinearLayout {

    private View mInflate;
    private EditText mEt;
    private ImageView mImg;
    private PopupWindow mPopupWindow;
    private ArrayList<String> mList;

    public SpinnerView(Context context) {
        super(context);
    }

    public SpinnerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mInflate = LayoutInflater.from(context).inflate(R.layout.spinner, null);
        addView(mInflate);
        initData();
        initView(mInflate);
    }

    private void initView(View pInflate) {
        mEt = mInflate.findViewById(R.id.et);
        mImg = mInflate.findViewById(R.id.iv_arrow);
        mImg.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                pop();
            }
        });

    }

    private void pop() {
        if (mPopupWindow == null){
            ListView listView = new ListView(getContext());
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                    android.R.layout.simple_list_item_1,mList);
            listView.setAdapter(adapter);
            //宽高+布局
            mPopupWindow = new PopupWindow(listView, mEt.getWidth(), 650);
            //点击外部消失
            mPopupWindow.setBackgroundDrawable(new ColorDrawable());
            mPopupWindow.setOutsideTouchable(true);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    mPopupWindow.dismiss();
                    mEt.setText(mList.get(position));
                    mEt.setSelection(mList.get(position).length());
                }
            });
        }
        mPopupWindow.showAsDropDown(mEt);
    }

    private void initData() {
        mList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mList.add("hhh"+i);
        }
    }
}
