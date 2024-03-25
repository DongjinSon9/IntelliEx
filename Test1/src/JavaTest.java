import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JavaTest {
    public static void main(String arg[]) {
//        System.out.println("Hello World!!");
//
//        System.out.println("다음 홈페이지 가져오기");
//        try {
//            Document daum = Jsoup.connect("https://www.daum.net").get();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("구글 홈페이지 가져오기");
//        try {
//            Connection.Response res = Jsoup.connect("https://www.google.com").method(Connection.Method.GET).execute();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        Document doc = null;
        Connection.Response res = null;

        try {
            res = Jsoup.connect("https://www.google.co.kr").method(Connection.Method.GET).execute();
            doc = res.parse();
        } catch (IOException e) {
            System.out.println("jsoup로 파싱 중 오류가 발생했습니다.");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
//
//        System.out.println("----------------------------------------------------------/n");
//        System.out.println(doc.html());
//
//
//        System.out.println("----------------------------------------------------------/n");
//        System.out.println(doc.text());
//
//        Element btnK = doc.select("input[name=btnK]").first();
//        String btnKValue = btnK.attr("value");
//        System.out.println("select()로 출력 " + btnKValue);
//
//        Elements btns = doc.select("input[name=btnK]");
//        for (int i = 0; i < btns.size(); i++) {
//            Element btn = btns.get(i);
//            String btnValue = btn.attr("value");
//            System.out.println("select()로 출력 " + i + " : " + btnValue);
//        }
        Elements imgs = doc.select("img");
        System.out.println("img 태그의 수 " + imgs.size());

        for (int i = 0; i < imgs.size(); i++) {
            Element img = imgs.get(i);
            String imgSrc = img.attr("src");

            if (imgSrc.isEmpty()) {
                continue;
            }

            System.out.println(i + "번째 태그" + imgSrc);
        }

        Elements inputs = doc.select("#APjFqb");
        System.out.println("사용자 입력란 수" + inputs.size());

        Element input = doc.select("#APjFqb").first();
        String inputValue = input.attr("title");
        System.out.println("사용자 입력란 title : " + inputValue);





        Elements classz = doc.select(".o3j99");
        System.out.println(classz.size());

        for (int i = 0; i < classz.size(); i++) {
            Element item = classz.get(i);
            Element style = item.select("style").first();
            System.out.println(style);
        }


        // 지정한 태그를 제외한 나머지 태그 모두 가져오기
        Elements elements = doc.select(".o3j99");
        System.out.println("class 값 .o3j99로 검색 결과 " + elements.size());

        Elements divList1 = doc.select("div");
        Elements divList2 = doc.select("div").not(".LX3sZb");

        System.out.println("divList1의 요소 수 " + divList1.size());
        System.out.println("divList2의 요소 수 " + divList2.size());

        elements = doc.select(".L3eUgb");
        System.out.println(elements.size());




        Element element = doc.select(".L3eUgb").first();
        divList1 = element.select("div");
        divList2 = element.select("div").not(".o3j99");

        System.out.println("o3j88 포함 " + divList1.size() + "개");
        System.out.println("o3j88 미포함 " + divList2.size() + "개");


//        getelementbyid() 이용하여 태그 1개 검색
        Element divTag = doc.getElementById("");
        System.out.println(divTag);

//        getelementsbytag() 이용하여 지정한 태그 모두 검색
//        Element divList = doc.getElementsByTag("");
//        System.out.println("DIVtag 수" + divTag);

//        getelementsbyclass() 이용하여 지정한 class 값을 사진 모든 태그 검색






    }
}
