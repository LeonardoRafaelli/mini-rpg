import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList <Personagens> listaPersonagens = new ArrayList<>();
    static Personagens character;

    public static void main(String[] args) {
        listaPersonagens.add(new Assassino(30, 15, 20, 5, "Kobe", 30));
        listaPersonagens.add(new Invocador(40, 20, 15, 5, "Udyr", 25));
        listaPersonagens.add(new Tanque(50, 30, 10, 5, "Voluri"));
        menu();
    }

    private static void menu(){
        System.out.println("1 - Play;" +
                "\n2 - Register Character;" +
                "\n3 - Delete Character;" +
                "\n4 - List Characters;");
        switch (sc.nextInt()){
            case 1 -> characterSelectionMenu();
            case 2 -> registerCharacter();
            case 3 -> deleteCharacter();
            case 4 -> listCharacters();
        }
        menu();
    }

    private static void listCharacters(){
        for (Personagens personagem : listaPersonagens) {
            System.out.println(personagem.toString());
        }
    };

    private static void deleteCharacter(){
        System.out.print("Insert the character's name to remove it\n ->: ");
        listaPersonagens.forEach(character -> {
            if(character.getName().equals(sc.next())){
                listaPersonagens.remove(character);
            }
        });
        System.out.println("The character have been removed!");
    }

    private static void characterSelectionMenu() {
        System.out.println("Select your character (0 - end the game): ");
        for(int i = 0; i < listaPersonagens.size(); i++){
            System.out.println((i+1) + " - " + listaPersonagens.get(i).toString());
        }
        int option = sc.nextInt();
        if(option != 0){
            character = listaPersonagens.get(option - 1);
            System.out.println("Character selected -> " + character.toString());
            game();
        }
    }

    private static void game(){

        double monsterLife = (Math.ceil(Math.random() * 40)) + 14;
        double monsterAttack = (Math.ceil(Math.random() * 40)) + 14;
        System.out.println("A monster have been spawned for someone\nHis total life is: " + monsterLife + "\n His total attack power is: " + monsterAttack);
        System.out.println("Your life: " + character.getVida()
        + "\nYour attack power: " + character.getAtaque()
        + "\nYour super attack: " + character.ataqueEspecial());

        int cont = 0;
        boolean attackMaded;
        Personagens temporaryCharacter = character;
        do{
            attackMaded = true;
            do{
                System.out.println("Your turn to attack!");
                System.out.println("1 - Normal Attack;");
                if(cont % 2 == 0){
                    System.out.println("2 - Special Attack.");
                }
                int option = sc.nextInt();
                if(option == 1){
                    monsterLife -= character.getAtaque();
                    attackMaded = false;
                    if(cont % 2 != 0){
                        cont++;
                    }
                } else if(option == 2 && cont % 2 == 0){
                    monsterLife -= character.ataqueEspecial();
                    attackMaded = false;
                    cont++;
                }
            }while(attackMaded);
            System.out.println("Monster's life: " + monsterLife);

            System.out.println("Monster's turn!");
            double random = (Math.ceil(Math.random() * 30));
            if(random < 10){
                System.out.println("You defended yourself from the attack!" + random);
            } else {
                character.setVida( (character.getVida() - monsterAttack));
                System.out.println("You've been attacked");
            }

            System.out.println("Your actual life: " + character.getVida());

        }while(monsterLife > 0 && character.getVida() > 0);
        if(monsterLife <= 0){
            System.out.println("\nCongratulations, you killed the monster!");
        } else {
            System.out.println("You did not killed the monster this time, he slaughtered you. Maybe next time!");
        }
        character = temporaryCharacter;
    }

    private static void registerCharacter(){
        System.out.println("Select the class of your character: ");
        listaPersonagens.add(colectCharacterData(selectChar()));
        System.out.println("Your character have been added to the game!!");
    }

    private static Personagens colectCharacterData(int option){
        System.out.print("Name: ");
        String name = sc.next();
        System.out.print("Life: ");
        int life = sc.nextInt();
        System.out.print("Defense: ");
        int defense = sc.nextInt();
        System.out.print("Attack: ");
        int attack = sc.nextInt();
        System.out.print("Stamina: ");
        int stamina = sc.nextInt();
        switch (option){
            case 1 -> {
                System.out.print("Special Shadow: ");
                return new Assassino(life, defense, attack, stamina, name, sc.nextInt());
            }
            case 2 -> {
                System.out.print("Special Summon: ");
                return new Invocador(life, defense, attack, stamina, name, sc.nextInt());
            }
            case 3 -> {
                return new Tanque(life, defense, attack, stamina, name);
            }
        }

        return null;
    };

    private static int selectChar(){
        System.out.println("---Characters---" +
                "\n1 - Assassin;" +
                "\n2 - Summoner;" +
                "\n3 - Tank.");
        return sc.nextInt();
    }

}
