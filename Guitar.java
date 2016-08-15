
public class Guitar {
	private int strings;
	private int chords;
	public static double [][] dash; //array created with frequencies and times.
	
	Guitar(int strings, int chords) throws InterruptedException {
		//guitar constructor which takes in the number of strings and chords.
		this.strings = strings;
		this.chords = chords;
		dash = new double[strings + 1][chords];

        generateSong(); //calls on the methods as soon as the new object is created.
        simulateSong();
	}
	
	
	public void generateSong() {
		//this method fills the array with the frequencies and times.
		System.out.print("Guitar(): Generated new guitar with " + strings + " strings. Song length is " + chords + " chords.\n");
		for (int i = 0; i < dash.length; i++) {
			for (int j = 0; j < dash[i].length; j++) {

				if (i == strings) {
					dash[i][j] = (Math.random() * 2) + 1;

				}

				else {
					dash[i][j] = (Math.random() * 4158.5) + 27.5;
				}

			}
		}
		//displays 2-D array.
        for (int i = 0; i < dash.length - 1; i++) {
            for (int j = 0; j < dash[i].length; j++) {
                System.out.printf("% 8.2f",dash[i][j]); //formatting

            }
            System.out.println();
        }

        for (int j = 0; j < dash[0].length; j++) {
            System.out.printf("% 8.1f",dash[dash.length-1][j]); //formatting
        }

	}
	//this method displays the second 2-D array with timed periods.
	public void simulateSong() throws InterruptedException {
		System.out.println();
		System.out.println();
		System.out.println("Guitar.simulateSong()");
		for (int j = 0; j < dash[strings].length;) {
				
				
				for (int i = strings - 1; i >= 0; i--) {
                    System.out.printf(" %7.2f", dash[i][j]); //formatting
					
					if (i == 0) {
                        double time = dash[dash.length - 1][j];
                        while (time > 1){
                            System.out.print(".");
                            Thread.sleep(1000); //delays printing of values
                            time--;
                        }
                        System.out.print(".");
                        Thread.sleep((long)(time*1000)); //delays printing of periods.

						i = strings - 1;
						j++;
						break;
						
					}
					
					
				}
				System.out.println();
	}
	}
		//this method creates a 1-D array with values closest to mid-range frequency.
	public double[] getChordArray(int col) {
		
		double [] result = new double[dash.length];
		if (col > dash.length || col < 1) {
            System.out.println("No such chord!"); //if no chord exists prints this and returns null.
            return null;
		} else {
            for (int i = 0; i < dash.length; i++){

                result[i] = dash[i][col - 1]; //fills new array with values and time periods.
            }
            return result;
        }
	}
}
