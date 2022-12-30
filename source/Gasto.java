import java.util.Date;

public class Gasto extends Tipo {
    private int id;
    private String nome;
    private double valor;
    private Tipo tipo;
    private Date data = new Date();

    public Gasto() {}

    // Setters
    public void setID(int id){
        this.id = id;
    }
    public void setNome(String nome){
        if (nome.isEmpty()){
            throw new IllegalArgumentException("Tamanho do nome invalido! Tente um maior.");
        } else {
            this.nome = nome;
        }
    }
    public void setValor(double valor){
        if (valor <= 0){
            throw new IllegalArgumentException("O valor ser igual a 0 e invalido! Insira um valor valido.");
        } else {
            this.valor = valor;
        }
    }
    public void setTipo(Tipo tipo){
        if (tipo == null){
            throw new IllegalArgumentException("Tipo nao pode ser nullo! Insere um tipo.");
        } else {
            this.tipo = tipo;
        }
    }

    // Getters
    public String getNome(){
        return this.nome;
    }
    public double getValor(){
        return this.valor;
    }
    public Tipo getTipo(){
        return this.tipo;
    }
    public Date getData(){
        return this.data;
    }

    //Sobreescrevendo o metodo toString 
    @Override
    public String toString(){
        String g = "[id: " + this.id + "; nome: " + this.nome + "; valor: "+ this.valor + "; Data: " + this.data + "; tipo: " + this.tipo + "];";
        return g;
    }
}