package cn.healthlink.texttovoice;

import android.content.Context;
import android.os.Environment;

import java.io.File;

/**
 * Created by BINGO on 2017/05/23.
 */

public class SDCardUtils {
    /**
     * 获取当前的存储目录
     * 如果有外部存储卡则先存储到存储卡的mrl；否则存储到当前应用的files下面
     */
    public static File getDiskFileDir(Context context) {
        String uniqueName = "mrl";//文件夹
        String filePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            filePath = Environment.getExternalStorageDirectory().getPath();
            makeRootDirectory(filePath);
        } else {
            filePath = context.getFilesDir().getPath();
            makeRootDirectory(filePath);
        }

        File file = null;
        try {
            file = new File(filePath + File.separator + uniqueName);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }

    public static void makeRootDirectory(String filePath) {
        File file = null;
        try {
            file = new File(filePath);
            if (!file.exists()) {
                file.mkdir();
            }
        } catch (Exception e) {

        }
    }
}
