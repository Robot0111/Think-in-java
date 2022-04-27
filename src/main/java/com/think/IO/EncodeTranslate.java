package com.think.IO;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * 编码转换
 * UTF_8
 * GBK
 * */
public class EncodeTranslate {
  private File[] files;    //需要转码的文件名字符串
  private File desDir;       //转码后存放的文件目录
  private Charset srcCharset;  //文件当前编码
  private Charset desCharset;  //文件目标编码

  /**
   * @param path 目标文件的路径
   * @Param desPath 目的文件的存放路径
   * @param type 目标文件的类型
   * @param srcEncode 目标文件的编码
   * @param desEncode 目的文件的编码
   *
   * */
  public EncodeTranslate(String path, String desPath, String type, String srcEncode, String desEncode) throws FileNotFoundException {
    File dirFile  = new File(path);
    if (!dirFile.exists()) {
      throw new FileNotFoundException("文件路径不存在：" + path);
    }

    this.files = dirFile.listFiles((dir, name)->name.contains(type));
    if (this.files.length == 0) {
      throw new FileNotFoundException("文件路径下不存在相关类型的文件：" + path + "->" + type);
    }

    desDir = new File(desPath);
    if (!desDir.exists()) {   //目标文件夹不存在，就创建
      if (!desDir.mkdirs()) {  //目标文件夹创建失败，路径冲突
        throw new FileNotFoundException("无法创建目标路径：" + desPath);
      }
    } else {
      if (!desDir.isDirectory()) {
        throw new FileNotFoundException("目标路径不是文件夹");
      }
    }

    this.srcCharset = Charset.forName(srcEncode);
    this.desCharset = Charset.forName(desEncode);
  }

  /**
   * java 8 的 Stream 的简单应用
   * */
  public void encodeTranslate() {
    Stream.of(files).forEach(this::translate);
  }

  /**
   * 把需要转码文件的中字符串按行读取出来，然后对其使用它本身的字符集解码成字节数组，
   * 再对字节数组按照需要的字符集编码成字符串，然后写入目的文件中。
   * */
  public void translate(File file) {

    try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), srcCharset))) {
      String fileName = file.getName();
      File newFile = new File(desDir, fileName);
      try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile), desCharset))) {
        String line = null;
        while (Objects.nonNull(line = reader.readLine())) {
          byte[] data = line.getBytes(desCharset);         //
          String newLine = new String(data, desCharset);
          writer.write(newLine);
          writer.newLine();
        }
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
    public static void main(String[] args) throws FileNotFoundException {
      String path = "C:\\Users\\HW\\Desktop\\WB";
      String desPath = "C:\\Users\\HW\\Desktop\\WB\\result";
      String type = ".log";
      String srcEncode = "UTF-16BE";
      String desEncode = "UTF-16LE";
      // 直接抛出异常，不做处理！
      EncodeTranslate encodeTranslate = new EncodeTranslate(path, desPath, type, srcEncode, desEncode);
      encodeTranslate.encodeTranslate();
      System.out.println("File Encode Translate Success!");
    }
  }



