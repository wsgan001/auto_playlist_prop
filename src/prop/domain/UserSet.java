package prop.domain;

import prop.ErrorString;
import prop.PropException;

import java.util.ArrayList;

/**
 * User set
 * @author  joaquim.motger
 */

public class UserSet {

    private static final String delimiter = "\n";
    private TernarySearchTree<User> users;


    /**
     * <code>UsersSet</code> class constructor
     */
    public UserSet() {
        users = new TernarySearchTree<>();
    }

    /**
     * Getter method of the <code>users</code>
     * @return      users
     */
    public ArrayList<User> getUsers() {
        return users.getList();
    }

    /**
     * Getter method of <code>users</code> size
     * @return      users size
     */
    public int getSize() {
        return users.getSize();
    }

    /**
     * Add <code>user</code> to <code>users</code>
     * @param  user     new <code>user</code> to add
     * @throws  Exception
     */
    public void addUser(User user) throws PropException {
        String name = user.getName();
        if (!contains(name)) {
            users.put(name,user);
        } else throw new PropException(ErrorString.EXISTING_USER);
    }

    /**
     * Returns true if the user set contains the user with name <code>name</code>
     * @param name     the name of the user
     * @return          true if present,
     *                  false if not present
     */
    public boolean contains(String name) {
        return users.contains(name);
    }

    /**
     * Getter method of the <code>User</code> with name <code>name</code>
     * @param   name    <code>user</code> name
     * @return  user    the user; null if not found
     */
    public User getUserByName(String name) throws PropException{
        if (contains(name)) return users.get(name);
        else throw new PropException(ErrorString.UNEXISTING_USER);
    }

    /**
     * obtains users which initial name letters match with prefix
     * @param prefix    the substring used to find users
     * @return          an arrayList that contains the users
     */
    public ArrayList<User> findUsers(String prefix) {
        return users.matchPrefix(prefix);
    }

    /**
     * Search users under a series of conditions, based on their attributes
     * @param conditions    an arrayList of pairs, in which is pair contains an attribute and a value
     * @return              an arrayList with all users that match the search
     * @throws PropException
     */
    public ArrayList<User> searchUsers(ArrayList<Pair<String,String>> conditions) throws PropException {
        ArrayList<User> userSet = new ArrayList<>();
        for (User user : users.getList()) {
            boolean valid = true;
            for (Pair<String,String> condition : conditions) {
                if (!satisfies(user,condition.first(),condition.second())) {
                    valid = false;
                    break;
                }
            }
            if (valid)
                userSet.add(user);
        }
        return userSet;
    }

    private boolean satisfies(User user, String attribute, String value) throws PropException {
        switch (attribute) {
            case "user_name":
                return user.getName().equals(value);
            case "user_gender":
                return user.getGender().equals(value);
            case "user_age":
                return user.age() == Integer.parseInt(value);
            default:
                throw new PropException(ErrorString.UNEXISTING_ATTRIBUTE);
        }
    }

    /**
     * Remove <code>user</code> with name <code>name</code> from <code>users</code>
     * @params  name    <code>user</code> name
     * @throws  Exception
     */
    public void removeUser (String name) throws Exception {
        if (contains(name)) {
            users.remove(name);
        }
        else throw new Exception(ErrorString.UNEXISTING_USER);
    }

    /**
     * Get the <code>UserSet</code> in String format
     * @return      a <code>String</code> with the <code>UserSet</code> in the specified format
     */
    public String toString() {
        String s = "";
        for (User user : users.getList()) {
            s += user.toString() + delimiter;
        }
        return s;
    }

}
