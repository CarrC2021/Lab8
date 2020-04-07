package edu.up.cs301threadslab;

public class AnimationThread extends Thread {
    AnimationView view;

    public AnimationThread(AnimationView v){
        view = v;
    }

    @Override
    public void run(){
        for(;;){
            view.postInvalidate();
            try {
                this.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
