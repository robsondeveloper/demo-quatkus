package quarkus.pagination;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

public class PageRequest {

    @QueryParam("page")
    @DefaultValue("0")
    @PositiveOrZero
    private int index;

    @QueryParam("size")
    @DefaultValue("10")
    @Positive
    private int size;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
