package hu.neuron.java.web.beans.lazy;

import java.util.Comparator;

import org.primefaces.model.SortOrder;

import hu.neuron.java.service.vo.UserVO;

public class LazySorter implements Comparator<UserVO> {

	private String sortField;

	private SortOrder sortOrder;

	public LazySorter(String sortField, SortOrder sortOrder) {
		this.sortField = sortField;
		this.sortOrder = sortOrder;
	}

	@Override
	public int compare(UserVO u1, UserVO u2) {
		try {

			int value;
			if (sortField.equals("username")) {
				value = u1.getUsername().compareTo(u2.getUsername());
			} else if (sortField.equals("phone")) {
				value = u1.getPhone().compareTo(u2.getPhone());
			} else if (sortField.equals("email")) {
				value = u1.getEmail().compareTo(u2.getEmail());
			} else {
				value = u1.getId().intValue() - u2.getId().intValue();
			}
			// Object value1 = UserVO.class.getField(this.sortField).get(u1);
			// Object value2 = UserVO.class.getField(this.sortField).get(u2);
			//
			// int value = ((Comparable) value1).compareTo(value2);

			return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}