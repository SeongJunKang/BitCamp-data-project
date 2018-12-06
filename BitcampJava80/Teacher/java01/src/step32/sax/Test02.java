package step32.sax;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class Test02 {

  static class BookHandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
      System.out.println("XML 데이터 분석 시작...");
      super.startDocument();
    }
    
    @Override
    public void endDocument() throws SAXException {
      System.out.println("XML 데이터 분석 종료...");
      super.endDocument();
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
      System.out.printf("<%s>\n", localName);
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
      System.out.printf("</%s>\n", localName);
    }
  }
  
  public static void main(String[] args) throws Exception {
    SAXParserFactory spf = SAXParserFactory.newInstance();
    spf.setNamespaceAware(true);
    SAXParser saxParser = spf.newSAXParser();
    
    XMLReader xmlReader = saxParser.getXMLReader();
    
    // 콘텐츠 핸들러 등록하기
    // => XMLReader는 xml 파일에서 태그나 속성을 읽을 때 마다 
    //    콘텐츠 핸들러의 메서드를 호출한다.
    // => 만약 콘텐츠 핸들러가 등록되어 있지 않다면 아무런 일도 하지 않는다.
    xmlReader.setContentHandler(new BookHandler());
    
    xmlReader.parse(convertToFileURL("./sample.xml"));
  }

  private static String convertToFileURL(String filename) throws IOException {
    File f = new File(filename); 
    String path = f.getCanonicalPath(); 
    String fileURL = "file:";
    if (!path.startsWith("/")) { 
      fileURL += "/";  
    }
    fileURL += path;
    return fileURL;
  }

}













