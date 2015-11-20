package hu.neuron.java.service;

import java.util.List;

import hu.neuron.java.service.vo.NewsVO;

public interface NewsService {

	public List<NewsVO> getAllNews();
	
	public void saveArticle(NewsVO article);

}
