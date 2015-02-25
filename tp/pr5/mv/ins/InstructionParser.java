package tp.pr5.mv.ins;
import tp.pr5.mv.ins.arithmeticsInstructions.*;
import tp.pr5.mv.ins.booleanInstructions.*;
import tp.pr5.mv.ins.comparisionInstructions.*;
import tp.pr5.mv.ins.jumpInstructions.*;
import tp.pr5.mv.ins.secuencialInstructions.*;
import tp.pr5.mv.ins.stackInstructions.*;
import tp.pr5.mv.ins.unaryInstructions.*;

public class InstructionParser {
	protected static Instruction[] operations = {
		new Add(),new Sub(),new Mul(),new Div(),new Neg(),new And(),new Not(),new Or(),new Dup(),new Flip(),new Out(),new Pop(),new Push(),
		new Store(),new Load(),new Eq(),new Gt(),new Le(),new Lt(),new Bf(),new Bt(),new InconditionalJump(),new Rbf(),new Rbt(),new Rjump(),new Halt(),new In(),new Out(),new StoreInd(),new LoadInd()};
	

	
	public static Instruction parse (String instructionLine){
		Instruction ins = null;
				String [] tokenLine = instructionLine.split(" ");
	
					for(Instruction instruction : operations){
					 
						if(ins == null){
							ins =  instruction.parse(tokenLine);
							
						}
					}
					
		return ins;
		
	}
}
