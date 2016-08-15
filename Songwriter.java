
public class Songwriter {
	public static void main(String [] args) throws InterruptedException {
		Guitar g1 = new Guitar(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
		//parses command line input, and creates guitar object.
		Vocalist v1 = new Vocalist(Integer.parseInt(args[2]), Integer.parseInt(args[0]), g1);
		//creates vocalist object.
		v1.vocalistArray();
		System.out.println();
		System.out.println(v1.toString());
		v1.sing();
		
	}
	
	
}
