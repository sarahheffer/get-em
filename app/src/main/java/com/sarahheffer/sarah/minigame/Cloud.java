package com.sarahheffer.sarah.minigame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.view.View;

import java.util.Random;

public class Cloud extends View {

    private int mScreenWidth = 800;
    private int mScreenHeight;

    private Bitmap mCloudBitmap = null;
    private Point mCloudLocation;
    private int mCloudSpeed;

    public Cloud(Context context) {
        super(context);
        resetCloud();
    }

    private void resetCloud() {
        int cloudX = randInt(40, mScreenWidth-200);
        int cloudY = -150 - randInt(0, 120);
        mCloudLocation = new Point(cloudX, cloudY);
        setBitmap();
        mCloudSpeed = randInt(2,5);
    }

    public void moveCloud() {
        mCloudLocation.y += mCloudSpeed;
        if (mCloudLocation.y > mScreenHeight) {
            resetCloud();
        }
    }

    public Point getLocation() {
        return mCloudLocation;
    }

    public Bitmap getBitmap() {
        return mCloudBitmap;
    }

    private void setBitmap() {
        int cloudNum = randInt(1,4);
        switch (cloudNum) {
            case 1:
                mCloudBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cloud_1);
                break;
            case 2:
                mCloudBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cloud_2);
                break;
            case 3:
                mCloudBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cloud_3);
                break;
            case 4:
                mCloudBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cloud_4);
                break;
            default:
                mCloudBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cloud_1);
                break;
        }
    }

    public void setScreenParams(int screenWidth, int screenHeight){
        mScreenWidth = screenWidth;
        mScreenHeight = screenHeight;
    }

    public static int randInt(int min, int max) {
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;
        return randomNum;
    }
}
