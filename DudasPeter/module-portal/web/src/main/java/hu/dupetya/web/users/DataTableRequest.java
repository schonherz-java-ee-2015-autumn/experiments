package hu.dupetya.web.users;

public class DataTableRequest {
	public static enum Column {
		NAME("0", "username"), EMAIL("1", "email"), DOB("2", "dob");
		private String str;
		private String sqlColumnName;

		public String getSqlColumnName() {
			return sqlColumnName;
		}

		public String getStr() {
			return str;
		}

		private Column(String s, String sqlColName) {
			str = s;
			sqlColumnName = sqlColName;
		}

		public static Column from(String parameter) {
			if (parameter != null) {
				for (Column c : Column.values()) {
					if (c.getStr().equals(parameter) || c.getSqlColumnName().equals(parameter)) {
						return c;
					}
				}
			}
			return null;
		}
	}

	private int draw;
	private int start;
	private int length;
	private String search;
	private Column orderCol;
	private String orderDir;

	public int getDraw() {
		return draw;
	}

	public int getStart() {
		return start;
	}

	public int getLength() {
		return length;
	}

	public String getSearch() {
		return search;
	}

	public Column getOrderCol() {
		return orderCol;
	}

	public String getOrderDir() {
		return orderDir;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public void setOrderCol(Column orderCol) {
		this.orderCol = orderCol;
	}

	public void setOrderDir(String orderDir) {
		this.orderDir = orderDir;
	}
}
