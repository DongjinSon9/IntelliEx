import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class NewsToDay {

    public static void main(String[] args) {

        System.out.println("다음 뉴스의 오늘의 연재 출력하기");

//        문제 1 : jsoup을 사용하여 다음 뉴스의 오늘의 연재부분을 파싱하여 화면에 출력하는 프로그램을 작성
//        출력형태 = 기사 제목, 기사 링크 2가지 내용을 출력

        String url = "https://news.daum.net/?nil_profile=mini&nil_src=news";

        Document html = null;

        try {
            Connection.Response res = Jsoup.connect(url).method(Connection.Method.GET).execute();
            html = res.parse();
        } catch (IOException e) {
            System.out.println("파싱 중 오류 발생");
            e.printStackTrace();
        }

//
        Elements newsAllList = html.select(".list_todayseries");
        System.out.println(newsAllList);

        Elements newsSeries = newsAllList.select(".item_todayseries");

        for (int i = 0; i < newsSeries.size(); i++) {
            Element item = newsSeries.get(i);
            Element aTag = newsSeries.select(".link_txt").first();
            String title = aTag.text();
            String link = aTag.attr("href");
            System.out.println("기사 " + (i + 1) + " : " + title);
            System.out.println("(링크 : " + link + ")");
            System.out.println("-------------------------------------\n");
        }


    }

}
