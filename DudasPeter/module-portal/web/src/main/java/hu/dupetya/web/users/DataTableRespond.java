package hu.dupetya.web.users;

import java.util.List;

public class DataTableRespond {
	private int draw;
	private int recordsTotal;
	private int recordsFiltered;
	private List<UserTableEntry> data;

	public int getDraw() {
		return draw;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public List<UserTableEntry> getData() {
		return data;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public void setData(List<UserTableEntry> data) {
		this.data = data;
	}

}
