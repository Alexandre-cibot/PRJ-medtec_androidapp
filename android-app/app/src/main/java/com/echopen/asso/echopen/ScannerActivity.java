package com.echopen.asso.echopen;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;

import com.echopen.asso.echopen.ui.DrawView;
import com.echopen.asso.echopen.utils.Config;
import com.echopen.asso.echopen.utils.Timer;

public class ScannerActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
    }


    @Override
    public void refreshImage(final Bitmap iBitmap) {
        try{
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    DrawView echoImage = (DrawView) findViewById(R.id.echo);
                    echoImage.setImageBitmap(iBitmap);
                    echoImage.setColorFilter(Config.colorMatrixColorFilter);
                    Timer.logResult("Display Bitmap");
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
