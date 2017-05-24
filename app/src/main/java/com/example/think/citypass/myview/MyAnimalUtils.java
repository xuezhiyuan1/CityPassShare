package com.example.think.citypass.myview;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.think.citypass.R;


/**
 *
 * 张晓萌
 * 5.23
 */

public class MyAnimalUtils {

    private static boolean boo =false;
    private static GridView mGridView;
    private static Context mContext;


    /***
     * 第一个参数是指定的对象  imageview
     * 第二个是上下文对象
     * @param imageView
     * @param context
     */

    public static void pictureAnimal(ImageView imageView,Context context) {

        /**8
         * 初始化动画数据  调用AnimationUtils工具类中的loadAnimation方法,
         * loadAnimation方法里面有两个参数,一个是上下文对象,另一个是从资源ID里面获取动画
         */
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.startdonghua);
        imageView.startAnimation(animation);
        /*动画停留在结束的位置
        *
        * animation只是操作View 的位图表示（bitmap representation），而不是真正的改变View的位置
         *动画结束后，View回到了原来的位置，setFillAfter 和 setFillBefore 并不能解决这个问题，
         * 要使View保持动画结束时的状态，必须另外改变View的属性（动画并不会帮助你改变View的属性），
         * setFillAfter 和 setFillBefore 只能改变动画的属性
      ?????????????为什么会有setFillAfter 和 setFillBefore这两个方法：
     是因为有动画链的原因，假定你有一个移动的动画紧跟一个淡出的动画，如果你不把移动的动画的setFillAfter置为true，
     那么移动动画结束后，View会回到原来的位置淡出，如果setFillAfter置为true， 就会在移动动画结束的位置淡出
        * */

        /***
         * 这里的意思也就是在动画结束后,可以继续在这个位置进行动画
         */
        animation.setFillAfter(true);

        /***
         * 启动动画
         */
        animation.start();
    }


    /**
     * 这个函数与上面的方法类似,只不过那个目的是设置动画从0度旋转的225
     * 这个是恢复,从225度到0度
     * @param imageView
     * @param context
     */
    public static void pictureAnimala(ImageView imageView,Context context) {
        Animation animation = AnimationUtils.loadAnimation(context, R.anim.stopdonghua);
        imageView.startAnimation(animation);
        animation.setFillAfter(true);
        animation.start();
    }

    public static void getGVDHB(GridView gridView, Context context) {
        mGridView=gridView;
        mContext=context;
        /*判断 mGridView 里面有多少个视图*/
        if (mGridView.getChildCount() > 0) {

            /*默认是开始动画*/
            if (!boo) {
                /*m GridView 每个 item 开始动画*/
                AnimalStart();
                boo=true;
            } else {
                /*m GridView 每个 item 结束动画*/
                AnimalStop();

                boo=false;
            }

        } else {
            Toast.makeText(context, "+++为空+", Toast.LENGTH_SHORT).show();
        }
    }

    public static void getGVDHB(GridView gridView, Context context,boolean boo) {
        mGridView=gridView;
        mContext=context;
        if (mGridView.getChildCount() > 0) {
            /***
             * 默认执行的就是开始的动画,然后在设置Boolean反向
             */
            if (!boo) {
                AnimalStart();
                boo=true;
            } else {
                AnimalStop();
                boo=false;
            }

        } else {
            Toast.makeText(context, "+++为空+", Toast.LENGTH_SHORT).show();
        }
    }

    /*开始的动画*/
    private static void AnimalStart() {
        //这个数只是一个标记,区别后面是否是开始动画还是消失
        final int shu=1;
        for (int i = 0; i < mGridView.getChildCount(); i++) {

            final int finaA = i;

            /**---------------------------------------------------------*/
            final int finalB = (i+1) * 150;
            final Handler handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    startAnim(mGridView.getChildAt(finaA),shu);
                }
            };
            new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        Thread.sleep(finalB);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message msg = handler.obtainMessage();
                    handler.sendMessage(msg);
                }
            }).start();

        }
    }

    /*结束的动画*/
    private static void AnimalStop() {
        final int shu=0;
        for (int i = mGridView.getChildCount() - 1; i >= 0; i--) {
            final int finalA = i;
            final int a = mGridView.getChildCount() - i;

            final int finalB = a * 150;
            Log.d("DongHuaActivity", "finals:" + finalB);
            final Handler handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    startAnim(mGridView.getChildAt(finalA),shu);
                }
            };

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(finalB);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message msg = handler.obtainMessage();
                    handler.sendMessage(msg);
                }
            }).start();

        }
    }


    /*执行动画*/
    private static void startAnim(final View view, final int shu) {

        switch (shu){
            case 0:/*结束的动画*/
                view.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.stopanimal));
                view.setVisibility(View.INVISIBLE);
                break;

            case 1:/*开始的动画*/
                view.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.startanimal));
                view.setVisibility(View.VISIBLE);

                break;
        }



    }


}
