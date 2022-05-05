public abstract class Personagens {
    private int defesa, ataque, stamina;
    private String name;
    private double vida;

    public Personagens(double vida, int defesa, int ataque, int stamina, String name) {
        this.vida = vida;
        this.defesa = defesa;
        this.ataque = ataque;
        this.stamina = stamina;
        this.name = name;
    }

    public abstract int ataqueEspecial();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVida() {
        return vida;
    }

    public void setVida(double vida) {
        this.vida = vida;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    @Override
    public String toString() {
        return "  Personagens{" +
                "vida=" + vida +
                ", defesa=" + defesa +
                ", ataque=" + ataque +
                ", stamina=" + stamina +
                ", nome=" + name +
                '}';
    }
}
