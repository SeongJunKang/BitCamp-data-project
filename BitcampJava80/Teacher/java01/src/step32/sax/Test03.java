package step32.sax;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class Test03 {

  static class BookHandler extends DefaultHandler {
    boolean isCapture;
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
      if (localName.equals("title")) {
        System.out.print("제목: ");
        isCapture = true;
        
      } else if (localName.equals("price")) {
        System.out.print("가격: ");
        isCapture = true;
      }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
      if (localName.equals("title") || localName.equals("price")) {
        System.out.println();
        isCapture = false;
      }
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
      if (isCapture) {
        System.out.print(new String(ch, start, length));
      }
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













