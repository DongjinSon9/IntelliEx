import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class DaumNews2_review {

//            2024-03-28
//            해당 페이지의 기사 내용 가져오기
//            1. 기사 페이지 url 설정
//            2. 기사 페이지의 HTML 태그를 받은 Document 객체 생성
//            3. Jsoup.Connect() 사용해서 기사 페이지에 접속
//            4. parser()를 사용하여 가져온 HTML 태그를 Document 객체에 저장
//            5. 기사 내용이 있는 태그를 select()를 사용하여 선택
//            6. 기사 내용 가져오기

    public static void main (String[] args){
//        기사 내용 페이지의 html 태그를 받기 위한 객체생성
        Document subhtml = null;
        String url = "https://v.daum.net/v/20240328075046382";

        try {
//            위에서 받아온 링크로 파싱
            Connection.Response subres = Jsoup.connect(url).method(Connection.Method.GET).execute();
            subhtml = subres.parse();
        } catch (IOException e) {
            System.out.println("오류발생");
            e.printStackTrace();
        }

//        기사 내용 중 본문 부분을 검색 부모태그가 article_view이므로 select()를 이용하여 검색
        Element article_view = subhtml.select(".article_view").first();
//        기사내용은 p 태그를 사용하여 한 문단씩 작성됐으므로 select()를 이용하여 p태그 검색
        Elements newsPList = article_view.select("p");
//        기사에 따라 첫번째 p태그에 내용이 없을 수 있으므로 확인이 필요함
        Element newsPTag = newsPList.get(0);
//        기사 내용을 text만 뽑아서 가져옴
        String news = newsPTag.text();
        System.out.println("뉴스 내용 : " + news);

    }
}
