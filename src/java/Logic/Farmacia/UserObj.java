
package Logic.Farmacia;

public class UserObj 
{

    private String username;
    private String password;
  

    public UserObj( String p_Username, String p_Password)
    {
        
        setUsername(p_Username);
        setPassword(p_Password);
       
    }      
        
    

    public String getUsername() 
    {
        return username;
    }

    private void setUsername(String pUsername) 
    {
        this.username = pUsername;
    }

    public String getPassword() 
    {
        return password;
    }

    private void setPassword(String pPassword) 
    {
        this.password = pPassword;
    }

}
