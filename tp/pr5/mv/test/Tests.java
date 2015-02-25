package tp.pr5.mv.test;

import tp.pr5.mv.TPMV;
import tp.pr5.mv.cpu.Constantes;

// a�adir a proyecto pr4 y modificar MVTP.main a AAA.main donde AAA es
// el paquete donde se encuentra el m�todo main.
//

public class Tests{

	private static String base = "c:/hlocal/pruebas/";

	static public void main(String[] args) {
		String line;
		String[] tests = {
				"",
				"-m batch -a " + base + "ejec1/programa.asm -i " + base
						+ "ejec1/entrada.in -o " + base + "out.txt",
				"-m batch -a " + base + "ejec1/programa.asm -i " + base
						+ "ejec1/entrada.in ",
				"-m batch -a " + base + "ejec2/programa.asm -i " + base
						+ "ejec2/entrada.in -o " + base + "out.txt",
				"-m batch -a " + base + "ejec4/programa.asm -i " + base
						+ "ejec4/entrada.in -o " + base + "out.txt",
				"-m batch -a " + base + "ejec5/programa.asm -i " + base
						+ "ejec5/entrada.in -o " + base + "out.txt",
				"-m batch -a " + base + "ejec6/programa.asm -i " + base
						+ "ejec6/entrada.in -o " + base + "out.txt",
				"-m batch -a " + base + "ejec6/programa.asm -i " + base
						+ "ejec6/entrada.in ",
				"-m batch -a " + base + "ejec7/programa.asm -i " + base
						+ "ejec7/entrada.in -o " + base + "out.txt",
				"-m batch -a " + base + "ejec8/programa.asm -i " + base
						+ "ejec8/entrada.in -o " + base + "out.txt",
				"-m interactive -a " + base + "ejec8/programa.asm -i " + base
						+ "ejec8/entrada.in -o " + base + "out.txt",
				"-m interactive -a " + base + "ejec4/programa.asm -i " + base
						+ "ejec4/entrada.in -o " + base + "out.txt",
				"-m interactive -a " + base + "ejec3/programa.asm -i " + base
						+ "ejec3/entrada.in ",
				"-m window -a " + base + "ejec1/programa.asm -i " + base
						+ "ejec1/entrada.in -o " + base + "out.txt",
				"-m window -a " + base + "ejec6/programa.asm -i " + base
						+ "ejec6/entrada.in -o " + base + "out.txt",
				"-m window -a " + base + "ejec9/programa.asm -o " + base
						+ "out.txt",
				"-m window -a " + base + "ejec10/programa.asm ",
				"-m window -a " + base + "ejec2/programa.asm -i " + base
						+ "ejec2/entrada.in",
				"-m window -a " + base + "ejec11/programa.asm",
				"-m window -a " + base + "ejec3/programa.asm -i " + base
						+ "ejec3/entrada.in" };

		//int i = 16; // el n�mero de ejemplo a ejecutar, 1 -- 19
	
		System.out.print("Introduzca numero del test a ejecutar 1 - 19 o Salir :");
		line =  Constantes.leerConsola();
		args = tests[Integer.parseInt(line)].split(" ");
		TPMV.main(args);
		

	}
}
