package hu.schonherz.training.refresher;

public class RefreshParams {

	protected int start;
	protected int length;
	protected String searchExpression;
	protected String orderBy;
	protected String orderType;

	/**
	 * @return the start
	 */
	public int getStart() {
		return start;
	}

	/**
	 * @param start
	 *            the start to set
	 */
	public void setStart(int start) {
		this.start = start;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @return the searchExpression
	 */
	public String getSearchExpression() {
		return searchExpression;
	}

	/**
	 * @param searchExpression
	 *            the searchExpression to set
	 */
	public void setSearchExpression(String searchExpression) {
		this.searchExpression = searchExpression;
	}

	/**
	 * @return the orderBy
	 */
	public String getOrderBy() {
		return orderBy;
	}

	/**
	 * @param orderBy
	 *            the orderBy to set
	 */
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	/**
	 * @return the orderType
	 */
	public String getOrderType() {
		return orderType;
	}

	/**
	 * @param orderType
	 *            the orderType to set
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public RefreshParams(int start, int length, String searchExpression, String orderBy, String orderType) {
		super();
		this.start = start;
		this.length = length;
		this.searchExpression = searchExpression;
		this.orderBy = orderBy;
		this.orderType = orderType;
	}

}
