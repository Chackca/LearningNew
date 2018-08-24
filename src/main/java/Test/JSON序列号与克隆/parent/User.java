package Test.JSON序列号与克隆.parent;

import java.io.Serializable;

public class User extends SuperUser implements Serializable {

    private static final long serialVersionUID = 6244837929799767392L;


    @Override
    public String toString() {
        return "User{} " + super.toString();
    }
}
