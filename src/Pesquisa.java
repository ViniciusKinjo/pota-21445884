import java.util.ArrayList;

public class Pesquisa {
    private ArrayList<String> nome;
    private ArrayList<String> sexo;
    private ArrayList<String> endereco;
    private ArrayList<String> cidade;
    private ArrayList<String> email;
    private ArrayList<String> telefone;
    private ArrayList<String> idade;
    private int contCompara;


    public Pesquisa(ArrayList<String> nome, ArrayList<String> sexo, ArrayList<String> endereco, ArrayList<String> cidade, ArrayList<String> email, ArrayList<String> telefone, ArrayList<String> idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.endereco = endereco;
        this.cidade = cidade;
        this.email = email;
        this.telefone = telefone;
        this.idade = idade;
    }


    public int getContCompara(){
        return contCompara;
    }


    public String pesquisaBinaria(String nomeChave){
        int inicio, meio, fim;

        contCompara = 0;
        inicio = 0;
        fim = nome.size() - 1;

        while(inicio <= fim){
            meio = (inicio + fim)/2;
            contCompara++;
            if(nomeChave.equals(nome.get(meio))){
                return nome.get(meio) + ", " + sexo.get(meio) + ", " + endereco.get(meio) + ", " + cidade.get(meio) + ", " + email.get(meio) + ", " + telefone.get(meio) + ", " + idade.get(meio);
            }
            contCompara++;
            if(nomeChave.compareTo(nome.get(meio)) < 0){
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }

        return "Nome não encontrado!";
    }
}
