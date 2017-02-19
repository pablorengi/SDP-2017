package sml;

public class OutInstruction extends Instruction {

    private int result;
    private int register;

    public OutInstruction(String label, String op) {
        super(label, op);
    }

    public OutInstruction(String label, int register) {
        super(label, "out");
        this.register = register;
    }

    @Override
    public void execute(Machine m) {
        result = m.getRegisters().getRegister(register);
        System.out.println(this);
    }

    @Override
    public String toString() {
        return super.toString() + " "  + result;
    }

}