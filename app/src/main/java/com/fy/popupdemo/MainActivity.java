package com.fy.popupdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.fy.popupdemo.base.NicePopup;
import com.fy.popupdemo.base.PopupDismissListner;
import com.fy.popupdemo.base.ViewHolder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tvPopup).setOnClickListener(this);
        findViewById(R.id.tvLeft).setOnClickListener(this);
    }

    private PopupWindow mPopWindow;

    /**
     * 从左向右 动画显示 popup
     * @param view
     */
    private void showPopupWindow(View view) {
        mPopWindow = NicePopup.Builder.init()
                .setLayoutId(R.layout.demo_popup)
                .setConvertListener(new NicePopup.PopupConvertListener() {
                    @Override
                    public void convertView(ViewHolder holder) {
                        TextView tv1 = holder.getView(R.id.pop_computer);
                        TextView tv2 = holder.getView(R.id.pop_financial);
                        TextView tv3 = holder.getView(R.id.pop_manage);

                        tv1.setText("大王叫我来巡山");
                        tv1.setOnClickListener(MainActivity.this);
                        tv2.setOnClickListener(MainActivity.this);
                        tv3.setOnClickListener(MainActivity.this);
                    }
                }).create()
                .setDismissListner(new PopupDismissListner() {
                    @Override
                    public void onDismiss() {
                        Toast.makeText(MainActivity.this, "popupWindow 已关闭", Toast.LENGTH_LONG).show();
                    }
                })
                .setAnim(R.style.AnimLeft)
                .setOutside(true)
                .onCreateView(this);

        int[] position = new int[2];
        view.getLocationOnScreen(position);//得到按钮左上角坐标

        int b = mPopWindow.getHeight() > view.getHeight() ?
                (mPopWindow.getHeight() - view.getHeight()) / 2 :
                (view.getHeight() - mPopWindow.getHeight()) / 2;

        mPopWindow.showAtLocation(findViewById(android.R.id.content), Gravity.NO_GRAVITY,
                position[0] + view.getWidth() + 8,
                mPopWindow.getHeight() > view.getHeight() ? position[1] - b : position[1] + b);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvPopup://从下向上 显示 popup
                mPopWindow = new PopupDemo(this);
                mPopWindow.showAtLocation(findViewById(android.R.id.content), Gravity.BOTTOM, 0, 0);
                break;
            case R.id.tvLeft:
                showPopupWindow(v);
                break;
            case R.id.pop_computer:
                Toast.makeText(MainActivity.this, "computer", Toast.LENGTH_LONG).show();
                mPopWindow.dismiss();
                break;
            case R.id.pop_financial:
                Toast.makeText(MainActivity.this, "financial", Toast.LENGTH_LONG).show();
                mPopWindow.dismiss();
                break;
            case R.id.pop_manage:
                Toast.makeText(MainActivity.this, "manage", Toast.LENGTH_LONG).show();
                mPopWindow.dismiss();
                break;
        }
    }
}
