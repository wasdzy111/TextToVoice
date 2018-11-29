# TextToVoice

#### 项目介绍
    1、使用android TTS 生成可以播放的文件 和 播放功能；该项目中未检测手机是否自带支持中文的TTS软件；
    2、Android系统从1.6版本开始就支持TTS（Text-To-Speech）,即语音合成。但是android系统默认的TTS引擎:Pic TTS不支持中文。所以我们得安装自己的TTS引擎和语音包（推荐讯飞TTS）

#### 使用说明

~~~
        //生成可以播放的文件
        btn_textToVoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String url = SDCardUtils.getDiskFileDir(MainActivity.this).getAbsolutePath() + "/" + Cn2Spell.getPinYin(text.getText().toString()) + ".wav";
                String url = Environment.getExternalStorageDirectory().getAbsolutePath()+"/1.mp3";

                createVoiceFile(text.getText().toString(), url);
            }
        });
        //播放文件
        btn_speakText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakText(text.getText().toString());
            }
        });
~~~