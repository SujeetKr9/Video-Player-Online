package com.sujeet.videoplayeronline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.khizar1556.mkvideoplayer.MKPlayerActivity;

import net.alhazmy13.mediapicker.Video.VideoPicker;

import java.util.List;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }
public void pick(View view){
    new VideoPicker.Builder(Main3Activity.this)
            .mode(VideoPicker.Mode.CAMERA_AND_GALLERY)
            .directory(VideoPicker.Directory.DEFAULT)
            .extension(VideoPicker.Extension.MP4)
            .enableDebuggingMode(true)
            .build();
}
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == VideoPicker.VIDEO_PICKER_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> mPaths =  data.getStringArrayListExtra(VideoPicker.EXTRA_VIDEO_PATH);
            //Your Code
            MKPlayerActivity.configPlayer(this).play(mPaths.get(0));
        }
    }

}

