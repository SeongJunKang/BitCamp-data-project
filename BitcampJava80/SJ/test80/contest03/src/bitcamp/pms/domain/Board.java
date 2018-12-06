package bitcamp.pms.domain;
/*  제목 , 내용, 조회수,암호, 생성일
 */
import java.sql.Date;
public class Board {


        String title;
        String content;
        int view;
        String password;
        Date createdDate;

        public Board() {

        }

        @Override
        public String toString() {
          return title + "," + view + "," +createdDate ;
        }
        public String toCSV() {
          return String.format("%s,%s,%d,%s,%s",title,content,view,password,createdDate.toString());
        }

        public void setTitle(String n) {
          title = n;
        }
        public void setContent(String n) {
          content = n;
        }
        public void setCreatedDate(Date n) {
          createdDate = n;
        }
        public void setPassword(String n) {
          password = n;
        }

        public void setView(int n) {
          view = n;
        }

        public String getTitle() {
          return title;
        }

        public String getContent() {
          return content;
        }
        public Date getCreatedDate() {
          return createdDate;
        }
        public String getPassword() {
          return password;
        }

        public int getView() {
          return view;
        }





}
