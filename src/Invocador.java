public class Invocador extends Personagens{
    private int especialInvocar;

    public Invocador(double vida, int defesa, int ataque, int stamina, String name, int especialInvocar) {
        super(vida, defesa, ataque, stamina, name);
        this.especialInvocar = especialInvocar;
    }

    @Override
    public int ataqueEspecial() {
        return especialInvocar;
    }

    public int getEspecialInvocar() {
        return especialInvocar;
    }

    public void setEspecialInvocar(int especialInvocar) {
        this.especialInvocar = especialInvocar;
    }

    @Override
    public String toString() {
        return  "  Invocador{" +
                "especialInvocar=" + especialInvocar +
                '}' + super.toString();
    }
}
