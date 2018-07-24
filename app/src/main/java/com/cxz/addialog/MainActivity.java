package com.cxz.addialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.cxz.ad_library.AdDialog;
import com.cxz.adlibrary.AdConstant;
import com.cxz.adlibrary.AdManager;
import com.cxz.adlibrary.bean.AdInfo;
import com.cxz.adlibrary.transformer.RotateDownPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<AdInfo> adInfos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAdDialog();
            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdDialog.getInstance()
                        .setImages(new int[]{R.mipmap.new_user_guide_1, R.mipmap.new_user_guide_2, R.mipmap.new_user_guide_3, R.mipmap.new_user_guide_4})
                        .setCanceledOnTouchOutside(false)
                        .setPageTransformer(new com.cxz.ad_library.transformer.RotateDownPageTransformer())
                        .show(getSupportFragmentManager());
            }
        });

    }

    private void initData() {
        adInfos = new ArrayList<>();
        AdInfo adInfo = new AdInfo();
        adInfo.setActivityImg("https://github.com/bjchenxz/AdDialog/raw/master/images/ad01.png");
        adInfos.add(adInfo);
        adInfo = new AdInfo();
        adInfo.setActivityImg("https://github.com/bjchenxz/AdDialog/raw/master/images/ad02.png");
        adInfos.add(adInfo);
    }

    void showAdDialog() {
        AdManager adManager = new AdManager(this, adInfos);
        adManager.setOverScreen(true)
                .setWidthPerHeight(0.73F)
                .setPageTransformer(new RotateDownPageTransformer())
                .setOnImageClickListener(new AdManager.OnImageClickListener() {
                    @Override
                    public void onImageClick(View view, AdInfo adInfo) {
                        Toast.makeText(MainActivity.this, adInfo.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        adManager.showAdDialog(AdConstant.ANIM_DOWN_TO_UP);
    }
}
