package hu.neuron.java.web.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import hu.neuron.java.service.NewsService;
import hu.neuron.java.service.vo.NewsVO;

@ManagedBean
@ViewScoped
public class NewsBean implements Serializable {

	@ManagedProperty(value = "#{newsService}")
	private
	NewsService newsService;

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void saveArticle() {
		System.out.println("Making VO for new Article...");
		NewsVO article = new NewsVO();
		System.out.println("Setting user...");
		article.setAuthor(AuthBean.getUser());
		System.out.println("Setting content...");
		article.setContent(content);
		System.out.println("Setting date...");
		article.setSendDate(new Date());
		System.out.println("Sending to Service");
		newsService.saveArticle(article);
		
		FacesContext cnt = FacesContext.getCurrentInstance();
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Üzenet sikeresen rögzítve!","Sikeres rögzítés!");
		cnt.addMessage(null, msg);
		
	}
	
	private String author;
	private String content;
	private Date sendDate;
	
	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	private List<NewsVO> news;
	
	public NewsService getNewsService() {
		return newsService;
	}

	public void setNewsService(NewsService newsService) {
		this.newsService = newsService;
	}

	public List<NewsVO> getNews() {
		return newsService.getAllNews();
	}

	public void setNews(List<NewsVO> news) {
		this.news = news;
	}
	
	
}
