package hu.neuron.java.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import hu.neuron.java.service.NewsConverter;
import hu.neuron.java.service.NewsService;
import hu.neuron.java.service.vo.NewsVO;
import hu.schonherz.java.dao.NewsDao;
import hu.schonherz.java.entities.News;

@Service("newsService")
@Transactional(propagation = Propagation.REQUIRED)
public class NewsServiceImpl implements NewsService {

	@Autowired
	NewsDao newsDao;
	@Override
	
	public List<NewsVO> getAllNews() {
		List<News> news = newsDao.selectAll();
		List<NewsVO> convertedNews= new ArrayList<>();
	
		for(News m:news) {
			convertedNews.add(NewsConverter.toVo(m));
			
		}
		return convertedNews;
	}
	@Override
	public void saveArticle(NewsVO article) {
		newsDao.save(NewsConverter.toEntity(article));		
	}

	
	

}
