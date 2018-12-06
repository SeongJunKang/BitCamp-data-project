package step32.sax;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.XMLReader;

public class Test01 {

  public static void main(String[] args) throws Exception {
    // 1) SAXParser 공장을 준비한다.
    SAXParserFactory spf = SAXParserFactory.newInstance();
    System.out.println(spf.getClass().getName());
    
    // 2) SAXParser의 네임스페이스 인지 가능 여부를 지정한다.
    spf.setNamespaceAware(true);
    
    // 3) SAXParser를 생성한다.
    SAXParser saxParser = spf.newSAXParser();
    
    // 4) XML을 읽어들일 객체를 준비한다.
    XMLReader xmlReader = saxParser.getXMLReader();
    
    // 5) XML 파일을 읽어서 분석하라!
    // => 아규먼트는 "file:/경로" 형식으로 표현된 file URL 이어야 한다.
    
    // => XML 파일의 경로를 file URL 형태로 만든다.
    File f = new File("./sample.xml"); // <-- 상대경로는 현재 프로젝트이다. 
    String path = f.getCanonicalPath(); // <-- 파일 경로를 알아낸다.
    String fileURL = "file:";
    if (!path.startsWith("/")) { // 윈도 운영체제의 경우, 예) c:\test\a.xml
      fileURL += "/";  
    }
    fileURL += path;
    System.out.println(fileURL);

    // => XML 파일을 분석하라!
    xmlReader.parse(fileURL);
    
    System.out.println("분석 끝!");
  }

}













