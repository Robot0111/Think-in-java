package com.think.IO;

import static net.mindview.util.Print.print;

import java.io.File;

public class DirectoryDemo {

  public static void main(String[] args) {
    // All directories
    PPrint.pprint(Directory.walk(".").dirs);
    //All files beginning with 'T'
    for(File file:Directory.local(".","T.*"))
      print(file);
    print("----------------------------");
    //All java files beginning with 'T'
    for(File file : Directory.walk(".","T.*\\.java"))
      print(file);
    print("================================");
    //Class files containing "z" or "z"
    for (File file:Directory.walk(".",".*[Zz].*\\.class"))
      print(file);
  }
}
