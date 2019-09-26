/*	*
    TRABALHO DE POO 1  -
 * @author: Paulo César Garcia Junior   - - 11811BCC003 - CIENCIA DA COMPUTAÇAO - - UFU
 *
 */
import java.util.*; // inclui as bibliotecas usadas (Random, Scanner)

public class Forca{
    private int vida;
    private final int MAX = 10;
    private String [] palavra;
    private int palavraSorteada;
    private char leters[] = {'a','b','c','d','e','f','g','h','i','j','k','l',
            'm','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private boolean usedLeters[];
    private boolean phrase[];

    public static void main(String args[]){
        String [] frases = {"Leopardo","Onca","Leao",
                "Chacau","Gnu","Lontra",
                "Hipopotamo","Zebra","Panda","Bisao"};
        Forca forca = new Forca(frases);
        Scanner input = new Scanner(System.in);
        String str;
        int v;
        while(true){
            while(!forca.ganhou()){
                forca.clear();
                forca.drawForca();
                forca.print();
                System.out.print("\nDigite uma letra: ");
                str = input.next().toLowerCase();
                forca.efetuarJogada(str.charAt(0));
                if(forca.getVida()<=0){
                    forca.clear();
                    System.out.print("\nVOCE PERDEU!\n");
                    break;
                }
            }
            if(forca.getVida()>0) forca.print();
            else forca.drawForca();
            System.out.print("Jogar novamente? (s - sim/ n - nao): ");
            if(input.next().toLowerCase().charAt(0)=='n') break;
            forca = new Forca(frases);
        }
    }

    public Forca(String [] str){
        this.setPalavra(str);
        this.sorteiaPalavra();
        int tam = this.palavra[this.palavraSorteada].length();
        this.usedLeters = new boolean[26];//verifica se a jogada pode ser efetuada
        this.phrase = new boolean[tam];
        for(int i=0;i<tam;i++){
            if(this.palavra[palavraSorteada].charAt(i)==' ') this.phrase[i] = true;
            else this.phrase[i] = false;
        }
        this.iniciarUsedLeters();
        this.iniciarVidas();
    }

    public void efetuarJogada(char letra){
        int posicao = this.posicaoLetra(letra);
        boolean acerto = false;
        if(posicao<0) {
            System.out.println("ERRO");
        }
        else{
            if(this.usedLeters[posicao]==false){//verifica se a letra ja foi escolhida
                int i=0, tam = this.palavra[palavraSorteada].length();
                for(i=0;i<tam;i++){
                    if(this.palavra[palavraSorteada].toLowerCase().charAt(i)==letra) {
                        this.phrase[i] = true;
                        acerto = true;
                    }
                }
                this.usedLeters[posicao] = true;
                if(!acerto) this.atualizaVida();
            }

        }
    }

    public void print(){
        int tam = this.palavra[palavraSorteada].length();
        System.out.print("       ");
        for(int i=0;i<tam;i++){
            if(phrase[i] == true) System.out.print(this.palavra[palavraSorteada].charAt(i) + "  ");
            else System.out.print("_ ");
        }
        System.out.println();
    }

    public void clear(){
        for(int i=0;i<1000;i++) System.out.println();
    }

    public void iniciarUsedLeters(){
        for(int i=0;i<26;i++) this.usedLeters[i] = false;
    }

    public void setPalavra(String []palavra){
        this.palavra = palavra;
    }

    public void sorteiaPalavra(){
        Random r = new Random();
        this.palavraSorteada = r.nextInt(this.MAX)%this.palavra.length;
    }

    public void iniciarVidas(){
        this.vida = 6;
    }

    public int getVida(){
        return this.vida;
    }

    public void atualizaVida(){
        this.vida--;
    }

    public boolean ganhou(){
        int tam = this.palavra[palavraSorteada].length();
        for(int i=0;i<tam;i++){
            if(phrase[i] == false) return false;
        }
        System.out.print("\nVOCE GANHOU:");
        return true;
    }

    public int posicaoLetra(char letra){ // verifica em qual posicao do alfabeto a letra esta
        for(int i=0;i<26;i++){
            if(this.leters[i]==letra) return i;
        }
        return -1;
    }

    public void drawForca(){ //desenha forca
        switch (this.vida){
            case 6:
                System.out.printf("____________________\n");
                System.out.printf("|                  |\n");
                for(int i=0;i<11;i++) System.out.printf("|\n");
                System.out.printf("|");
                break;
            case 5:
                System.out.printf("____________________\n");
                System.out.printf("|                  |\n");
                System.out.printf("|                (o o)\n");
                for(int i=0;i<10;i++) System.out.printf("|\n");
                System.out.printf("|");
                break;
            case 4:
                System.out.printf("____________________\n");
                System.out.printf("|                  |\n");
                System.out.printf("|                (o o)\n");
                System.out.printf("|                  |\n");
                for(int i=0;i<9;i++) System.out.printf("|\n");
                System.out.printf("|");
                break;
            case 3:
                System.out.printf("____________________\n");
                System.out.printf("|                  |\n");
                System.out.printf("|                (o o)\n");
                System.out.printf("|                  |\n");
                System.out.printf("|                 /|\n");
                for(int i=0;i<8;i++) System.out.printf("|\n");
                System.out.printf("|");
                break;
            case 2:
                System.out.printf("____________________\n");
                System.out.printf("|                  |\n");
                System.out.printf("|                (0 0)\n");
                System.out.printf("|                  |\n");
                System.out.printf("|                 /|\\\n");
                for(int i=0;i<8;i++) System.out.printf("|\n");
                System.out.printf("|");
                break;
            case 1:
                System.out.printf("____________________\n");
                System.out.printf("|                  |\n");
                System.out.printf("|                (0 0)\n");
                System.out.printf("|                  |\n");
                System.out.printf("|                 /|\\\n");
                System.out.printf("|                  |\n");
                System.out.printf("|                 /\n");
                for(int i=0;i<6;i++) System.out.printf("|\n");
                System.out.printf("|");
                break;
            case 0:
                System.out.printf("____________________\n");
                System.out.printf("|                  |\n");
                System.out.printf("|                (x x)\n");
                System.out.printf("|                  |\n");
                System.out.printf("|                 /|\\\n");
                System.out.printf("|                  |\n");
                System.out.printf("|                 / \\\n");
                for(int i=0;i<6;i++) System.out.printf("|\n");
                System.out.printf("|");
                break;
            default:
                break;
        }
    }
}
