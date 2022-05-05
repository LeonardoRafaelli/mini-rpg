public class Assassino extends Personagens{
    private int especialSombra;

    public Assassino(double vida, int defesa, int ataque, int stamina, String name, int especialSombra) {
        super(vida, defesa, ataque, stamina, name);
        this.especialSombra = especialSombra;
    }

    @Override
    public int ataqueEspecial() {
        return especialSombra;
    }

    public int getEspecialSombra() {
        return especialSombra;
    }

    public void setEspecialSombra(int especialSombra) {
        this.especialSombra = especialSombra;
    }

    @Override
    public String toString() {
        return "  Assassino{" +
                "especialSombra=" + especialSombra +
                '}' + super.toString();
    }
}
