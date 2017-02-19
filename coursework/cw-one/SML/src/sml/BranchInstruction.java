package sml;

public class BranchInstruction extends Instruction {

    private int r1;
    private String l1;

    public BranchInstruction(String label, String opcode) {
        super(label, opcode);
    }

    public BranchInstruction(String label, int r1, String l1) {
        super(label, "bnz");
        this.r1 = r1;
        this.l1 = l1;
    }

    @Override
    public void execute(Machine m) {
        int value1 = m.getRegisters().getRegister(r1);
        if(value1 != 0){
            m.setPc(m.getLabels().indexOf(l1));
        }
    }

    @Override
    public String toString() {
        return super.toString() + " r1 : l1";
    }

}