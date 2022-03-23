package com.think.IO;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Dirlistwo {
  public static FilenameFilter filter(final String regex) {
    return  new FilenameFilter() {
      private Pattern pattern = Pattern.compile(regex);
      @Override
      public boolean accept(File dir, String name) {
        return pattern.matcher(name).matches();
      }
    };
  }

  public static void main(String[] args) {
    File path = new File("D:\\workspace\\ThinkJ\\src\\main\\java\\com\\think\\generic");
    String[] list;
    if (args.length == 0)
      list = path.list();
    else
      list = path.list(filter(args[0]));
    Arrays.sort(list,String.CASE_INSENSITIVE_ORDER);
    for (String dirItem : list) {
      System.out.printf(dirItem);
    }
  }
}
