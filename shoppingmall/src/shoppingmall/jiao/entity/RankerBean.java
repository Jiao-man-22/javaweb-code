package shoppingmall.jiao.entity;

public class RankerBean {
	private int id;
	private String name;
	private int click;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the click
	 */
	public int getClick() {
		return click;
	}
	/**
	 * @param click the click to set
	 */
	public void setClick(int click) {
		this.click = click;
	}
	@Override
	public String toString() {
		return "RankerBean [id=" + id + ", name=" + name + ", click=" + click + "]";
	}
	

}
