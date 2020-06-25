package shoppingmall.jiao.entity;

public class GoodsBean {
	private long goodsId;
	private String goodsName;
	private String goodsIntro;
	private	float goodsPrice ;
	private	int	goodsNum ;
	private	String publisher ;
	private	String photo;
	private	String type ;
	/**
	 * @return the goodsId
	 */
	public long getGoodsId() {
		return goodsId;
	}
	/**
	 * @param goodsId the goodsId to set
	 */
	public void setGoodsId(long goodsId) {
		this.goodsId = goodsId;
	}
	/**
	 * @return the goodsName
	 */
	public String getGoodsName() {
		return goodsName;
	}
	/**
	 * @param goodsName the goodsName to set
	 */
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	/**
	 * @return the goodsIntro
	 */
	public String getGoodsIntro() {
		return goodsIntro;
	}
	/**
	 * @param goodsIntro the goodsIntro to set
	 */
	public void setGoodsIntro(String goodsIntro) {
		this.goodsIntro = goodsIntro;
	}
	/**
	 * @return the goodsPrice
	 */
	public float getGoodsPrice() {
		return goodsPrice;
	}
	/**
	 * @param goodsPrice the goodsPrice to set
	 */
	public void setGoodsPrice(float goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	/**
	 * @return the goodsNum
	 */
	public int getGoodsNum() {
		return goodsNum;
	}
	/**
	 * @param goodsNum the goodsNum to set
	 */
	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}
	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}
	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "GoodsBean [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsIntro=" + goodsIntro
				+ ", goodsPrice=" + goodsPrice + ", goodsNum=" + goodsNum + ", publisher=" + publisher + ", photo="
				+ photo + ", type=" + type + "]";
	}
	

}
