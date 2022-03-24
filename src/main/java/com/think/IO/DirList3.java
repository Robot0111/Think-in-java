package com.think.IO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList3 {

  /**
   * 方法传入匿名内部类
   * @param args
   */
  public static void main(String[] args) {
    File path = new File("D:\\workspace\\ThinkJ\\src\\main\\java\\com\\think\\generic");
    String[] list;
    if (args.length == 0)
      list = path.list();
    else
      list = path.list(new FilenameFilter() {
        Pattern pattern = Pattern.compile(args[0]);
        @Override
        public boolean accept(File dir, String name) {
          return pattern.matcher(name).matches();
        }
      });
    Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
    for (String dirItem : list){
      System.out.println(dirItem);
    }
  }
}
