package facebook.user.service;


import facebook.user.dao.UserDao;
import facebook.user.domain.User;
import java.util.List;



public class UserService {

	private UserDao dao ;
	
	public UserService(){
		dao = new UserDao();
	}
	
	public void add(User user){
		dao.add(user);
	}
	public User findUserById(String id){
		String sql = "select * from facebook_user where id='"+id+"'";
		List<User> list = dao.find(sql);
		if(list!=null && list.size()==1){
			return list.get(0);
		}
		return null;
	}

  
	
}
