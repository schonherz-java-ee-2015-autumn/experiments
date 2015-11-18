package hu.neuron.java.web.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

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
