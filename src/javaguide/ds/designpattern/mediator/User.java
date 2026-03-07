package javaguide.ds.designpattern.mediator;

/**
 * @author Wuxy
 * @version 1.0
 * @ClassName User
 * @since 2023/4/24 14:47
 */
public class User {
    private String name;


    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}
