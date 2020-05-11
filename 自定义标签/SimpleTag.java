package tagpackage;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTag extends SimpleTagSupport{
	private int num;
	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}
	/**
	 * <aa>
	 * xxxxxx
	 * </aa>
	 * */
	@Override
	public void doTag() throws JspException, IOException {
	//»ñÈ¡jspÔªËØ
		JspFragment jspBody = getJspBody();
		for(int i=0;i<num;i++) {
			jspBody.invoke(null);
		}
		// TODO Auto-generated method stub
		super.doTag();
	}

}
