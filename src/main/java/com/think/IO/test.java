package com.think.IO;

import info.monitorenter.cpdetector.io.ASCIIDetector;
import info.monitorenter.cpdetector.io.ByteOrderMarkDetector;
import info.monitorenter.cpdetector.io.CodepageDetectorProxy;
import info.monitorenter.cpdetector.io.JChardetFacade;
import info.monitorenter.cpdetector.io.ParsingDetector;
import info.monitorenter.cpdetector.io.UnicodeDetector;
import java.io.FileInputStream;
import java.io.InputStream;

public class test {

  public static void main(String[] args) {
    java.io.File f = new java.io.File("C:\\Users\\HW\\Desktop\\WB\\11.log");
  /*------------------------------------------------------------------------
  detector是探测器，它把探测任务交给具体的探测实现类的实例完成。
  cpDetector内置了一些常用的探测实现类，这些探测实现类的实例可以通过add方法
  加进来，如ParsingDetector、 JChardetFacade、ASCIIDetector、UnicodeDetector。
  detector按照“谁最先返回非空的探测结果，就以该结果为准”的原则返回探测到的
  字符集编码。
--------------------------------------------------------------------------*/
    CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance(); // A singleton.


/*-------------------------------------------------------------------------
  ParsingDetector可用于检查HTML、XML等文件或字符流的编码,构造方法中的参数用于
  指示是否显示探测过程的详细信息，为false不显示。
---------------------------------------------------------------------------*/
//    detector.add(new cpdetector.io.ParsingDetector(false));
/*--------------------------------------------------------------------------
  JChardetFacade封装了由Mozilla组织提供的JChardet，它可以完成大多数文件的编码
  测定。所以，一般有了这个探测器就可满足大多数项目的要求，如果你还不放心，可以
  再多加几个探测器，比如下面的ASCIIDetector、UnicodeDetector等。
 ---------------------------------------------------------------------------*/
////UnicodeDetector用于Unicode家族编码的测定
//    detector.add(cpdetector.io.UnicodeDetector.getInstance());
    // Add the implementations of info.monitorenter.cpdetector.io.ICodepageDetector:
    // This one is quick if we deal with unicode codepages:
    detector.add(new ByteOrderMarkDetector());
    // The first instance delegated to tries to detect the meta charset attribut in html pages.
    detector.add(new ParsingDetector(false)); // be verbose about parsing.
    // This one does the tricks of exclusion and frequency detection, if first implementation is
    // unsuccessful:
    detector.add(JChardetFacade.getInstance()); // Another singleton.
    detector.add(ASCIIDetector.getInstance()); // Fallback, see javadoc.
    // UnicodeDetector用于Unicode家族编码的测定
    detector.add(UnicodeDetector.getInstance());
    java.nio.charset.Charset charset = null;
    try {
//      InputStream input = new FileInputStream(f);
      charset = detector.detectCodepage(f.toURL());
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    if (charset != null) {
      System.out.println(f.getName() + "编码是：" + charset.name() +" 可能是:" + charset.aliases());

    } else {
      System.out.println(f.getName() + "未知");
    }

  }
}
