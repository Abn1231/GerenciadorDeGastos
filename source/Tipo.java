public class Tipo{
    private String nome;

    public Tipo(){}

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    //Sobreescrevendo o metodo toString 
    @Override
    public String toString(){
        String g = this.nome;
        return g;
    }
}