package hu.neuron.java.web.beans.lazy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import hu.neuron.java.service.vo.UserVO;

public class LazyUserDataModel extends LazyDataModel<UserVO> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<UserVO> datasource;

	public LazyUserDataModel(List<UserVO> datasource) {
		this.datasource = datasource;
	}

	@Override
	public UserVO getRowData(String rowKey) {
		for (UserVO user : datasource) {
			if (user.getUsername().equals(rowKey))
				return user;
		}

		return null;
	}

	@Override
	public Object getRowKey(UserVO user) {
		return user.getUsername();
	}

	@Override
	public List<UserVO> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		List<UserVO> data = new ArrayList<UserVO>();

		// filter
		for (UserVO user : datasource) {
			boolean match = true;

			if (filters != null) {
				for (Iterator<String> it = filters.keySet().iterator(); it.hasNext();) {
					try {
						String filterProperty = it.next();
						Object filterValue = filters.get(filterProperty);
						String fieldValue;
						// String.valueOf(user.getClass().getField(filterProperty).get(user));

						if (filterProperty.equals("username")) {
							fieldValue = user.getUsername();
						} else if (filterProperty.equals("phone")) {
							fieldValue = user.getPhone();
						} else if (filterProperty.equals("email")) {
							fieldValue = user.getEmail();
						} else {
							fieldValue = String.valueOf(user.getId());
						}

						if (filterValue == null || fieldValue.contains((filterValue.toString()))) {
							match = true;
						} else {
							match = false;
							break;
						}
					} catch (Exception e) {
						match = false;
					}
				}
			}

			if (match) {
				data.add(user);
			}
		}

		// sort
		if (sortField != null) {
			Collections.sort(data, new LazySorter(sortField, sortOrder));
		}

		// rowCount
		int dataSize = data.size();
		this.setRowCount(dataSize);

		// paginate
		if (dataSize > pageSize) {
			try {
				return data.subList(first, first + pageSize);
			} catch (IndexOutOfBoundsException e) {
				return data.subList(first, first + (dataSize % pageSize));
			}
		} else {
			return data;
		}
	}
}