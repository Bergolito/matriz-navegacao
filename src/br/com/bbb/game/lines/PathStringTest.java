package br.com.bbb.game.lines;

public class PathStringTest {

	/*
    A value of cell "S" means Source.
    A value of cell "D" means Destination.
    A value of cell "F" means Blank cell.
    A value of cell "X" means Blank Wall.
    */
	public static void teste01() {
		PathString path = new PathString();

		String[][] matrix1OK = 
		{  
			{"S", "X", "D", "F"}, 
			{"F", "X", "F", "F"}, 
			{"F", "X", "F", "F"}, 
			{"F", "F", "F", "F"}
		}; 
		System.out.println("Achou Caminho? "+path.isPath(matrix1OK));

	}

	public static void teste02() {
		PathString path = new PathString();
		
		String[][] matrix1OK = 
		{  
			{"S", "X", "D", "F"}, 
			{"F", "X", "F", "F"}, 
			{"F", "X", "F", "F"}, 
			{"F", "F", "F", "F"}
		}; 

		System.out.println("Achou Caminho? "+path.isPath(matrix1OK));
		
		String[][] matrix1Falha = 
		{  
			{"X", "F", "X", "S"}, 
			{"F", "X", "X", "X"}, 
			{"D", "F", "F", "F"}, 
			{"X", "F", "F", "F"}
		}; 
				
		System.out.println("Achou Caminho? "+path.isPath(matrix1Falha));
	
		
		String[][] matrix2OK = 
		{  
			{"S", "X", "F", "F", "F"}, 
			{"F", "X", "F", "X", "F"}, 
			{"F", "X", "F", "X", "F"}, 
			{"F", "X", "F", "X", "F"},
			{"F", "F", "F", "X", "D"}
		}; 
				
		System.out.println("Achou Caminho? "+path.isPath(matrix2OK));
	
		String[][] matrix2Falha = 
		{  
			{"S", "X", "F", "F", "F"}, 
			{"F", "X", "F", "X", "F"}, 
			{"F", "X", "F", "X", "F"}, 
			{"F", "X", "F", "X", "X"},
			{"F", "F", "F", "X", "D"}
		}; 
				
		System.out.println("Achou Caminho? "+path.isPath(matrix2Falha));
		
		String[][] matrix3OK = 
		{  
			{"S", "X", "F", "F", "F", "F"}, 
			{"F", "X", "F", "X", "X", "F"}, 
			{"F", "X", "F", "X", "X", "F"}, 
			{"F", "X", "F", "X", "X", "F"},
			{"F", "X", "F", "X", "X", "F"},
			{"F", "F", "F", "X", "D", "F"}
		}; 
				
		System.out.println("Achou Caminho? "+path.isPath(matrix3OK));
	
		String[][] matrix3Falha = 
		{  
			{"S", "X", "F", "F", "F", "F"}, 
			{"F", "X", "F", "X", "X", "X"}, 
			{"F", "X", "F", "X", "X", "X"}, 
			{"F", "X", "F", "X", "X", "X"},
			{"F", "X", "F", "X", "X", "X"},
			{"F", "F", "F", "X", "D", "X"}
		}; 
				
		System.out.println("Achou Caminho? "+path.isPath(matrix3Falha));
	
		String[][] matrix4OK = 
		{  
			{"F", "F", "F", "X", "F", "F", "F", "F", "F"}, 
			{"F", "X", "F", "X", "F", "X", "X", "X", "F"},
			{"F", "X", "F", "X", "F", "X", "X", "X", "F"},
			{"F", "X", "F", "X", "F", "X", "X", "X", "F"},
			{"F", "X", "F", "X", "F", "X", "X", "X", "F"},
			{"F", "X", "F", "X", "F", "X", "X", "X", "F"},
			{"F", "X", "F", "X", "F", "X", "X", "X", "F"},
			{"F", "X", "F", "X", "F", "X", "X", "X", "F"},
			{"S", "X", "F", "F", "F", "X", "X", "D", "F"},
		}; 
				
		System.out.println("Achou Caminho? "+path.isPath(matrix4OK));
	
		String[][] matrix4Falha = 
		{  
				{"F", "F", "F", "X", "F", "F", "F", "F", "F"}, 
				{"F", "X", "F", "X", "F", "X", "X", "X", "F"},
				{"F", "X", "F", "X", "F", "X", "X", "X", "F"},
				{"F", "X", "F", "X", "F", "X", "X", "X", "F"},
				{"F", "X", "F", "X", "F", "X", "X", "X", "F"},
				{"F", "X", "F", "X", "F", "X", "X", "X", "F"},
				{"F", "X", "F", "X", "F", "X", "X", "X", "F"},
				{"F", "X", "F", "X", "F", "X", "X", "X", "F"},
				{"S", "X", "F", "F", "F", "X", "X", "D", "X"},
		}; 
				
		System.out.println("Achou Caminho? "+path.isPath(matrix4Falha));
	}
	
	public static void main(String[] args) {
		//
		teste01();
		//
		teste02();
	}
}
