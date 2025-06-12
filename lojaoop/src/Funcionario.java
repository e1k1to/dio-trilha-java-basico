abstract class Funcionario {

    protected String name;
    protected String email;
    protected String password;
    protected Boolean ehAdmin;


    public Funcionario(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
        this.ehAdmin = false;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public Boolean getEhAdmin() {
        return this.ehAdmin;
    }

    //login, logoff, alterar dados, alterar senha

    
}
