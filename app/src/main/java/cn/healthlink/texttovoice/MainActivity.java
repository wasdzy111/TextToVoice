package cn.healthlink.texttovoice;

import android.os.Environment;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    private EditText text;
    private Button btn_textToVoice, btn_speakText;
    private TextToSpeech textToSpeech; // TTS对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textToSpeech = new TextToSpeech(this, this);

        text = (EditText) findViewById(R.id.editText);
        btn_textToVoice = (Button) findViewById(R.id.btn_textToVoice);
        btn_speakText = (Button) findViewById(R.id.btn_speakText);


        btn_textToVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String url = SDCardUtils.getDiskFileDir(MainActivity.this).getAbsolutePath() + "/" + Cn2Spell.getPinYin(text.getText().toString()) + ".wav";
                String url = Environment.getExternalStorageDirectory().getAbsolutePath()+"/1.mp3";

                createVoiceFile(text.getText().toString(), url);
            }
        });
        btn_speakText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakText(text.getText().toString());
            }
        });
    }

    //生成文件
    public void createVoiceFile(String text, String url) {

        try {
            textToSpeech.synthesizeToFile(
                    text,
                    new HashMap<String, String>(),
                    url);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //播放文字
    public void speakText(String text) {

        textToSpeech.speak(text,
                TextToSpeech.QUEUE_FLUSH, null);

    }

    //监听初始化
    @Override
    public void onInit(int i) {
        if (i == TextToSpeech.SUCCESS) {
            textToSpeech.setLanguage(Locale.SIMPLIFIED_CHINESE);
            //textToSpeech.setLanguage(Locale.ENGLISH);
            textToSpeech.setPitch(1.0f);// 设置音调，值越大声音越尖（女生），值越小则变成男声,1.0是常规
            textToSpeech.setSpeechRate(1.0f);
        }
    }

    //释放资源
    @Override
    protected void onStop() {
        super.onStop();
        if (textToSpeech != null && !textToSpeech.isSpeaking()) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
    }
}
