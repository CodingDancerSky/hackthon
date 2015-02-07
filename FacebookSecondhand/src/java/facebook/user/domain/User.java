package facebook.user.domain;

public class User {

	private String id;
	
	private String username;
	
        private String link;
        
        private String email;
	
	public User(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	
        }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
        
        
        public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

        
        public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
