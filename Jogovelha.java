import java.util.Scanner;

/**
 * 
 * @author luca gouveia
 */
public class Jogovelha {
    private static Scanner leia = new Scanner (System.in);
    private static int[][] casa = new int [3][3];
    private static int player;
    private static int vencedor,linha,coluna;
    private static String jogador1, jogador2;
    private static long inicio;//tempo
    
public static void setTempo() { 
	inicio = System.currentTimeMillis(); 
} 

public static long getTempo() { 
	return (System.currentTimeMillis()-inicio)/1000;
}

public static void cadastro(){ // CADASTRO DOS NOMES DOS PLAYERS!
    System.out.println("Digite o nome do jogador 1:");
    jogador1 = leia.next();
    System.out.println("Digite o nome do jogador 2");
    jogador2 = leia.next();
} 


public static void print (int x,int y){
    
    if (casa[x][y]==1){
        System.out.print("X");
    }else if (casa[x][y] == 2){
        System.out.print("O");
    }else{
        System.out.print(" ");
    }
}

public static void jogo(){
    System.out.println("  1  |  2 | 3 ");
    System.out.println("-------------");
    
    System.out.print("1 ");
    print(0,0);
    System.out.print("  | ");
    print(0,1);
    System.out.print("  | ");
    print(0,2); 
    
    System.out.print("\n -------------\n2 "); 
    print(1,0);
    System.out.print("  | ");
    print(1,1);
    System.out.print("  | ");
    print(1,2);
    
    System.out.print("\n -------------\n3 ");
    print(2,0);
    System.out.print("  | ");
    print(2,1);
    System.out.print("  | ");
    print(2,2);
  
}

public static void jogar (int jogador){//
    int i =0;
    
    if (jogador == 1) { 
	player = 1; 
	System.out.println("\n\n Vez do Jogador " + jogador1); 
    } else { 
	player = 2; 
	System.out.println("\n\n Vez do Jogador " + jogador2); 
    }
    
    while (i==0){
        linha = 0;
        coluna =0;
        while (linha < 1 || linha > 3){
            System.out.println("ESCOLHA A LINHA (1,2,3): ");
            linha = leia.nextInt();
            if (linha < 1 || linha > 3) {
                System.out.println("Linha inválido! Escolha entre 1 e 3. ");
                
            }
        }
        while (coluna < 1 || coluna > 3){
            System.out.println("ESCOLHA A COLUNA (1,2,3): ");
            coluna = leia.nextInt();
            if (linha < 1 || linha > 3) {
                System.out.println("Coluna inválido! Escolha entre 1 e 3. ");
            }    
            
        }
         linha--;
         coluna--;
        
        if (casa[linha][coluna] == 0){
            
            casa[linha][coluna] = player;
            i = 1;
        }else {
            System.out.println("Posição já marcada!");
        }
    }
  
}

public static void check(){
    int i = 0;
    
    for (i = 0; i < 3; i++) {
        if (casa[i][0] == casa[i][1] && casa[i][0] == casa[i][2]){
            if (casa[i][0] == 1) vencedor = 1; 
            if (casa[i][0] == 2) vencedor = 2;   
        }
    }
    
    for (i =0; i<3; i++){
        if (casa[0][i] == casa[1][i] && casa[0][i] == casa[2][i]){
            if (casa[0][i] == 1) vencedor = 1; 
            if (casa[0][i] == 2) vencedor = 2;    
        }
        
    }
    if (casa[0][0] == casa[1][1] && casa[0][0] == casa[2][2]) { 
            if (casa[0][0] == 1) vencedor = 1; 
            if (casa[0][0] == 2) vencedor = 2; 
	} 
	
	if (casa[0][2] == casa[1][1] && casa[0][2] == casa[2][0]) { 
            if (casa[0][2] == 1) vencedor = 1; 
            if (casa[0][2] == 2) vencedor = 2; 
	} 
}

    public static void main(String[] args) {
        cadastro();
        setTempo();
        int i = 0;
        
        for (i=0 ; i <9; i++){
            jogo();
            if (i % 2 == 0){
                jogar(2);
            }else{
                jogar(1);
            }
            check();
            if (vencedor == 1 || vencedor == 2){
                i = 10;
            }
        }
        jogo();
        //
        if (vencedor == 1 ){
            System.out.println("\n \n "+ jogador1 + " VENCEU!");
        }else if (vencedor == 2){
            System.out.println("\n \n "+ jogador2 + " VENCEU!");
        }else{
            System.out.println("DEU VELHA!");
        }
        System.out.println("O tempo total de jogo foi de: " + getTempo() + " segundos ");
    }
    
}
