# TextToVoice

#### 项目介绍
{**以下是码云平台说明，您可以替换为您的项目简介**
码云是开源中国推出的基于 Git 的代码托管平台（同时支持 SVN）。专为开发者提供稳定、高效、安全的云端软件开发协作平台
无论是个人、团队、或是企业，都能够用码云实现代码托管、项目管理、协作开发。企业项目请看 [https://gitee.com/enterprises](https://gitee.com/enterprises)}

#### 软件架构
软件架构说明


#### 安装教程

1. xxxx
2. xxxx
3. xxxx

#### 使用说明

~~~
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
~~~