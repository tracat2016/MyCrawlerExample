package crawler.example;

import com.github.abola.crawler.CrawlerPack;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


/**
 * 簡易練習
 * 
 * 找出所有文章中按推的id
 * 
 * @author Abola Lee
 *
 */
public class PttHomework {
	
	public static void main(String[] args) {
		String uri = "https://www.ptt.cc/bbs/translator/M.1108654871.A.004.html";

		Document jsoup = CrawlerPack.start()
				.addCookie("over18", "1")
				.getFromHtml(uri);

				System.out.println(jsoup.select("div.push"));

		for (Element elem:jsoup.select("div.push")){

			System.out.println(elem.select(".push.tag").text());
		}

//用 cookie 表示已滿18歲
		/*System.out.println(
			CrawlerPack.start()
			    .addCookie("over18", "1")
				.getFromHtml(uri)
				.select(".push-tag:matches(推)+span")
				.toString()
		);*/
	}
}
