public class Tanque extends Personagens{
    private int specialSuperAttack;

    public Tanque(double vida, int defesa, int ataque, int stamina, String name) {
        super(vida, defesa, ataque, stamina, name);
        this.specialSuperAttack = ataque * 2;
    }

    @Override
    public int ataqueEspecial() {
        return specialSuperAttack;
    }

    public int getEspecialSuperAttack() {
        return specialSuperAttack;
    }

    public void setEspecialSuperAttack(int especialDefesa) {
        this.specialSuperAttack = especialDefesa;
    }

    @Override
    public String toString() {
        return "  Tanque{" +
                "specialSuperAttack=" + specialSuperAttack +
                '}' + super.toString();
    }
}
