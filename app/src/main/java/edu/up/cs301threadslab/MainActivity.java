package edu.up.cs301threadslab;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

/**
 * This application displays several animations.  It is used for the threads lab in CS371.
 *
 * @author Andrew Nuxoll
 * @version Fall 2015
 */
public class MainActivity extends Activity
        implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private AnimationView myAV;
    private Button theButton;
    private SeekBar theSeekBar;
    private AnimationThread thread;
    private StarAnimation starAnimation;
    private RandomizeThread randomThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setup the animation(s)
        myAV = (AnimationView)findViewById(R.id.animationArea);
        starAnimation = new StarAnimation(myAV.getMyWidth(), myAV.getMyHeight());
        myAV.addAnimation(starAnimation);

        //Let me know when someone taps the button
        theButton = (Button)findViewById(R.id.button);
        theButton.setOnClickListener(this);

        //Let me know when someone adjusts the seekbar
        theSeekBar = (SeekBar)findViewById(R.id.seekBar);
        theSeekBar.setOnSeekBarChangeListener(this);

//        thread = new AnimationThread(myAV);
//        thread.start();
//        randomThread = new RandomizeThread(starAnimation);
//        randomThread.start();
    }//onClick

    @Override
    public void onClick(View v) {
        for (int i = 0; i < 1000; i++) {
            myAV.postInvalidate();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        myAV.progressChange(seekBar.getProgress());
        for (int i = 0; i < 1000; i++) {
            myAV.postInvalidate();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /** These two methods aren't used */
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {}
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {}
}
