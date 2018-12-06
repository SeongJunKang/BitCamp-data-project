package step22$File.exam04;
import java.io.InputStream;
import java.io.IOException;

public class MyDataInputStream extends InputStream {
  InputStream base;
  public MyDataInputStream(InputStream base) {
    this.base = base;
  }

  @Override
  public int read() throws IOException {
    return base.read();
  }

  @Override
  public int read(byte[] bytes) throws IOException {
    return base.read(bytes);            // 얘는 데코레이터일뿐, 하는 일은 본래
  }                                    // 상속 받은애한테 넘겨준다.

  @Override
  public int read(byte[] bytes,int offset, int length) throws IOException {
    return base.read(bytes,offset,length);
  }

  public short readShort() throws IOException {
    int result = 0 ;
    int temp = this.read();
    result += (temp << 8);

    temp = this.read();
    result +=temp;
    return (short)result;
  }

  public int readInt() throws IOException {
    int result = 0 ;
    int temp = this.read();
    result += (temp << 24);

    temp = this.read();
    result += (temp << 16);

    temp = this.read();
    result += (temp << 8);

    temp = this.read();
    result +=temp;

    return result;
  }

}
