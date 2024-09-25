package board.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Service
public class ScrapingServiceImpl implements ScrapingService{
	
	@Override
	public Map<String, String> scrapeData(String url) {
		
		Map<String, String> data = new HashMap<>();
		
		try {
            // Jsoup을 사용해 전달된 URL에서 HTML 문서 가져오기
            Document doc = Jsoup.connect(url).get();

            // 예시: 특정 데이터를 추출 (HTML 구조에 맞는 CSS 선택자 사용)
            Elements menuLists = doc.select("ul.list_menu");
            //Element placeInfo = doc.selectFirst("ul.list_menu");
            
            // 데이터를 HTML 형식으로 반환
            //
            // 각 'li' 태그의 텍스트(메뉴 이름)를 추출
            System.out.println("메뉴 개수 " + menuLists.size());
            for (Element menuList : menuLists) {
                Elements items = menuList.select("li");  // 'li' 태그 선택
                for (Element item : items) {
                    String menuItem = item.text();  // 텍스트 추출
                    
                    System.out.println(menuItem);  // 메뉴 이름 출력
                }
            }
            
            //return placeInfo != null ? placeInfo.html() : "정보를 찾을 수 없습니다.";
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
		
	}
}
	