package step22.exam05;

import java.io.IOException;
import java.io.InputStream;

public class MyBufferedInputStream extends InputStream {
  byte[] buf = new byte[8192]; // 접시
  int length;

  InputStream base;

  public MyBufferedInputStream(InputStream base) {
    this.base = base;
  }

  @Override
  public int read() throws IOException {
    if (length <= 0) {
      length = base.read(buf);
    }

    if (length != -1) {
      return buf[--length] & 0x000000ff;
    }

    return length;
  }




}
