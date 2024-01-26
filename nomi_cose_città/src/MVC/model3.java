package MVC;


public class model3 {
    private String name;
    private String password;
    private String mail;
   

    public model3(){

    }

    public void setName(String name) {
        this.name = name;
        System.out.println("username " + name);
    }

    public String getName() {
        return this.name;
    }

    public void setPass(String password) {
        this.password = password;
        System.out.println("password " + password);
    }

    public String getPass() {
        return this.password;
    }

    public void setMail(String mail){
        this.mail = mail;
        System.out.println("mail " + mail);
    }


    public String getMail() {
        return this.mail;
    }

    
   
}
