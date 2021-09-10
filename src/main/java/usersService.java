import java.util.List;

public class usersService {

    private static final usersDAO userDao = new usersDAO();

    public static int add(users user){
        return userDao.add(user);
    }
    public  static  void edit (int id,users U){
        userDao.edit(id, U);
    }

    public  static users find_by_username (String username){
        return userDao.findUsername(username);
    }
    public  static List<users> get_by_age_diapasons(int id1, int id2){
        return userDao.get_by_age_diapasons(id1, id2);
    }
    public  static  void delete_by_username(String username){
        userDao.delete_by_username(username);

    }
    public  static  void delete_by_id(int id){
        userDao.delete_by_id(id);
    }

}
