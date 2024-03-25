import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Test2 {

    public static void main(String[] args) {

        System.out.println("뉴스가져오기");

        String url = "https://news.daum.net/?nil_profile=mini&nil_src=news";

        Document html = null;

        try {
        Connection.Response res = null;
        res = Jsoup.connect(url).method(Connection.Method.GET).execute();
        html = res.parse();
        } catch (IOException e) {
            System.out.println("파싱중 오류발생");
            e.printStackTrace();
        }

        Element list_newsissue = html.select(".list_newsissue").first();
        System.out.println(list_newsissue);


//        ul 태그의 자식 태그인 li 태그의 자식 태그가 class 값이 하나뿐이라 할 필요가 없어서 주석
//        Elements li_list = list_newsissue.select("li");
//        System.out.println(li_list.size());

        Elements item_issue = list_newsissue.select(".item_issue");

//        기사 제목이 들어있는 div 태그 목록을 반복문을 통해 하나씩 출력
        for (int i = 0; i < item_issue.size(); i++) {
            Element item = item_issue.get(i);
//            Element cont_thumb = item.select(".cont_thumb").first();
//            Element strong = cont_thumb.select("strong").first();
//            Element atag = strong.select(".link_txt").first();
//            String title = atag.text();
//            String link = atag.attr("href");
//            System.out.println("기사 제목 " + (i + 1) + " : " + title);
//            System.out.println("기사 링크 : " + link);


            //줄임 버전
            Element newsAtag = item.select(".link_txt").first();
            String newsTitle = newsAtag.text();
            String newsLink = newsAtag.attr("href");
            System.out.println("기사 제목 " + (i + 1) + " : " + newsTitle);
            System.out.println("기사 링크 : " + newsLink);
            System.out.println("----------------------------------------");


        }

//        Elements cont_thumb = item_issue.get(0).select(".cont_thumb");

//        Element strong = cont_thumb.select("strong").first();

//        Element a = strong.select(".link_txt").first();

//        String title = a.text();



    }
}
