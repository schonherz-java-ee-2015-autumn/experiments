package hu.neuron.java.service;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import hu.neuron.java.service.vo.NewsVO;
import hu.schonherz.java.entities.News;

public class NewsConverter {
	
	static Mapper mapper = new DozerBeanMapper();
	public static NewsVO toVo(News news) {
		if(news == null) {
			return null;
		}
		return mapper.map(news, NewsVO.class);		
	}
	
	public static News toEntity(NewsVO NewsVo) {
		if(NewsVo == null) {
			return null;
		}
		return mapper.map(NewsVo, News.class);		
	}
	
	public static List<NewsVO> toVo(List<News> news) {
		List<NewsVO> rv = new ArrayList<>();
		
		for(News neww:news) {
			rv.add(toVo(neww));
		}
		return rv;
	}
	
	public static List<News> toEntity(List<NewsVO> NewsVo) {
		List<News> rv = new ArrayList<>();
		
		for(NewsVO newsE:NewsVo) {
			rv.add(toEntity(newsE));
		}
		return rv;
	}
}
