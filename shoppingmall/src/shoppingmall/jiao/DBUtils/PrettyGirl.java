package shoppingmall.jiao.DBUtils;

import java.util.Objects;

public class PrettyGirl {
	 /**
     * ¹ÃÄïÎ¨Ò»ÈÏÖ¤ID
     */
    private String id;
    /**
     * ¹ÃÄïĞÕ×ÖÃûË­
     */
    private String name;


    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        PrettyGirl that = (PrettyGirl) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }



}
