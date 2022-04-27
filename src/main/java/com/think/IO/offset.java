package com.think.IO;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class offset {

  public static void main(String[] args) {
    String filePath = "C:\\Users\\HW\\Desktop\\WB\\源文件\\REBO\\REBO\\Data\\ProjectData\\11111\\MSGuiParameterChangeLog.pcl";

    try {
      byte[] bytes = new byte[1120];

      FileInputStream fis = new FileInputStream((filePath));
      fis.read(bytes, 0, 1120);
      bytes[1113] = 00;
      bytes[1117] = 00;
      bytes[1118] = 00;
      bytes[1119] = 00;
      String c = Hex.encodeHexStr(bytes);

      System.out.println(c);
      getFileByBytes(bytes,
          "C:\\Users\\HW\\Desktop\\WB\\源文件\\REBO\\REBO\\Data\\ProjectData\\11111\\",
          "MSGuiParameterChangeLog.pcl");
      //Arrays.fill(bytes, (byte)0);

      //System.out.print(Hex.encodeHex(bytes,false));

    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  //将Byte数组转换成文件
  public static void getFileByBytes(byte[] bytes, String filePath, String fileName) {
    BufferedOutputStream bos = null;
    FileOutputStream fos = null;
    File file = null;
    try {
      File dir = new File(filePath);
      if (!dir.exists() && dir.isDirectory()) {// 判断文件目录是否存在
        dir.mkdirs();
      }
      file = new File(filePath + "\\" + fileName);
      fos = new FileOutputStream(file);
      bos = new BufferedOutputStream(fos);
      bos.write(bytes);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (bos != null) {
        try {
          bos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (fos != null) {
        try {
          fos.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
