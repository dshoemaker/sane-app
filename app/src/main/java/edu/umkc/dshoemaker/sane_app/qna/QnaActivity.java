package edu.umkc.dshoemaker.sane_app.qna;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import edu.umkc.dshoemaker.sane_app.R;

/**
 * Created by choits on 2015. 11. 13..
 */
public class QnaActivity extends Activity {
    private ViewPager mPager;
    private LinearLayout mLayout;
    private int score;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.qna_layout);

        score=0;
        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(new PagerAdapterClass(getApplicationContext()));
    }

    private class PagerAdapterClass extends PagerAdapter {
        private LayoutInflater mInflater;

        public PagerAdapterClass(Context c){
            super();
            mInflater = LayoutInflater.from(c);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public Object instantiateItem(View pager, int position) {
            View v = null;
            if(position==0){
                v = mInflater.inflate(R.layout.qna1, null);
                v.findViewById(R.id.rb1).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), ""+score, Toast.LENGTH_SHORT).show();
                    }
                });
                v.findViewById(R.id.rb2).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        score++;
                        Toast.makeText(getApplicationContext(), ""+score, Toast.LENGTH_SHORT).show();
                    }
                });
                v.findViewById(R.id.rb3).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), ""+score, Toast.LENGTH_SHORT).show();
                    }
                });
                v.findViewById(R.id.rb4).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        score++;
                        Toast.makeText(getApplicationContext(), ""+score, Toast.LENGTH_SHORT).show();
                    }
                });

            }
            else if(position==1){
                v = mInflater.inflate(R.layout.qna2, null);
                v.findViewById(R.id.rb5).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), ""+score, Toast.LENGTH_SHORT).show();
                    }
                });
                v.findViewById(R.id.rb6).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        score++;
                        Toast.makeText(getApplicationContext(), ""+score, Toast.LENGTH_SHORT).show();
                    }
                });
                v.findViewById(R.id.rb7).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), ""+score, Toast.LENGTH_SHORT).show();
                    }
                });
                v.findViewById(R.id.rb8).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        score++;
                        Toast.makeText(getApplicationContext(), ""+score, Toast.LENGTH_SHORT).show();
                    }
                });


            }else{

                v = mInflater.inflate(R.layout.qna3, null);
                v.findViewById(R.id.rb9).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), ""+score, Toast.LENGTH_SHORT).show();
                    }
                });
                v.findViewById(R.id.rb10).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        score++;
                        Toast.makeText(getApplicationContext(), ""+score, Toast.LENGTH_SHORT).show();
                    }
                });
                v.findViewById(R.id.rb11).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), ""+score, Toast.LENGTH_SHORT).show();
                    }
                });
                v.findViewById(R.id.rb12).setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        score++;
                        Toast.makeText(getApplicationContext(), ""+score, Toast.LENGTH_SHORT).show();
                    }
                });


            }

            ((ViewPager)pager).addView(v, 0);

            return v;
        }

        @Override
        public void destroyItem(View pager, int position, Object view) {
            ((ViewPager)pager).removeView((View) view);
        }

        @Override
        public boolean isViewFromObject(View pager, Object obj) {
            return pager == obj;
        }

        @Override public void restoreState(Parcelable arg0, ClassLoader arg1) {}
        @Override public Parcelable saveState() { return null; }
        @Override public void startUpdate(View arg0) {

        }
        @Override public void finishUpdate(View arg0) {
            if(score>=0 && score<2)
                arg0.setBackgroundColor(Color.GREEN);
            else if(score>=2 && score<4)
                arg0.setBackgroundColor(Color.YELLOW);
            else if(score>=4 && score<=6)
                arg0.setBackgroundColor(Color.RED);
        }
    }
}
