package com.ubctwicefanclub.ubcasf;

import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;

import com.microsoft.speech.tts.Synthesizer;
import com.microsoft.speech.tts.Voice;
import com.microsoft.cognitiveservices.speech.ResultReason;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.SpeechRecognitionResult;
import com.microsoft.cognitiveservices.speech.SpeechRecognizer;

import java.util.concurrent.Future;

import static android.Manifest.permission.*;

public class MainActivity extends AppCompatActivity {

    private Synthesizer m_syn;

    private static String speechSubscription = "750907c2ce9e4e8ab4f1370fd306b048";
    private static String serviceRegion = "westus";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int requestCode = 5;
        ActivityCompat.requestPermissions(MainActivity.this, new String[]{RECORD_AUDIO, INTERNET}, requestCode);



            findViewById(R.id.otherwise).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    m_syn.stopSound();
                }
            });

            findViewById(R.id.blindbutton).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    m_syn.SpeakToAudio(getString(R.string.tts_text));
                }
            });
        }
    }
}