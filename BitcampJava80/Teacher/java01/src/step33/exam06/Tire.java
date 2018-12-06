package step33.exam06;

public class Tire {
  int width;
  int aspectRatio;
  int rim;
  
  public Tire() {}

  @Override
  public String toString() {
    return "Tire [width=" + width + ", aspectRatio=" + aspectRatio + ", rim=" + rim + "]";
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getAspectRatio() {
    return aspectRatio;
  }

  public void setAspectRatio(int aspectRatio) {
    this.aspectRatio = aspectRatio;
  }

  public int getRim() {
    return rim;
  }

  public void setRim(int rim) {
    this.rim = rim;
  }
  
  
}
