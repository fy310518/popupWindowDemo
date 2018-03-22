# popupWindowDemo
PopupWindow 简单封装与使用

继承 PopupWindow 实现了一个 CommonPopupWindow 的抽象类；里面封装了popup 数常用功能；

为了使用方便又 实现了一个 NicePopup 类；使用方式如下：

PopupWindow mPopWindow = NicePopup.Builder.init()
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



关于PopupWindow 的显示可以参考，个人简书 https://www.jianshu.com/p/461a6137d644；

关于本篇 PopupWindow 的封装，遇到许多坑，一一爬了一遍，在此感谢前辈们博客的指导（查的资料过多已经不记得具体地址了，抱歉）^_^
