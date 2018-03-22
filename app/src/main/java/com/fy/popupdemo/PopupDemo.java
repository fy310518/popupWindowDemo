package com.fy.popupdemo;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.fy.popupdemo.base.CommonPopupWindow;
import com.fy.popupdemo.base.ViewHolder;

/**
 *
 * Created by fangs on 2018/3/22.
 */
public class PopupDemo extends CommonPopupWindow implements View.OnClickListener {

    public PopupDemo(Context context) {
        setAnim(R.style.AnimUp);
        setOutside(true);

        onCreateView(context);
    }

    @Override
    protected int initLayoutId() {
        return R.layout.demo_popup;
    }

    @Override
    public void convertView(ViewHolder holder) {
        TextView tv1 = holder.getView(R.id.pop_computer);
        TextView tv2 = holder.getView(R.id.pop_financial);
        TextView tv3 = holder.getView(R.id.pop_manage);

        tv1.setText("大王叫我来巡山");
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pop_computer:
                Toast.makeText(mContext, "条目一", Toast.LENGTH_LONG).show();
                dismiss();
                break;
            case R.id.pop_financial:
                Toast.makeText(mContext, "我是第二个条目", Toast.LENGTH_LONG).show();
                dismiss();
                break;
            case R.id.pop_manage:
                Toast.makeText(mContext, "最后一个条目", Toast.LENGTH_LONG).show();
                dismiss();
                break;
        }
    }
}
