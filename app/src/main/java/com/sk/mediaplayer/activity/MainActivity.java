package com.sk.mediaplayer.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.sk.mediaplayer.R;
import com.sk.mediaplayer.viewPager.AudioPager;
import com.sk.mediaplayer.viewPager.BasePager;
import com.sk.mediaplayer.viewPager.NetAudioPager;
import com.sk.mediaplayer.viewPager.NetVideoPager;
import com.sk.mediaplayer.viewPager.VideoPager;

public class MainActivity extends FragmentActivity {

    RadioGroup radioGroup;
    BasePager[] basePagers;
    FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioGroup=findViewById(R.id.rg_main);
        basePagers=new BasePager[4];
        basePagers[0]=new VideoPager(this);
        basePagers[1]=new AudioPager(this);
        basePagers[2]=new NetVideoPager(this);
        basePagers[3]=new NetAudioPager(this);
        manager = getSupportFragmentManager();
        manager.beginTransaction().add(R.id.fl_main,basePagers[0]).commitAllowingStateLoss();//设置默认页面
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override//只有改变才调用，i为对应id
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int pos=0;
                switch (i){
                    case R.id.rb_video:
                        pos=0;
                        break;
                    case R.id.rb_audio:
                        pos=1;
                        break;
                    case R.id.rb_net_video:
                        pos=2;
                        break;
                    case R.id.rb_net_audio:
                        pos=3;
                        break;
                }
                manager.beginTransaction().replace(R.id.fl_main,basePagers[pos]).commitAllowingStateLoss();//替换页面
            }
        });
    }

}
