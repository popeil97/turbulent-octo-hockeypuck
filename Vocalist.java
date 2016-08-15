

public class Vocalist {
	private double center;
	private int chord;
	private double [][] melodyArray;
    Guitar g1;
	
	Vocalist(double center, int chord, Guitar g1) {
		//constructor that takes in the mid-range frequency, amount of chords, and the guitar object.
		this.center = center;
		this.chord = chord;
		melodyArray = new double[2][chord];
        this.g1 = g1;

        System.out.println();
        System.out.print("Vocalist(): midRangeFreq: " + center+ "\n" + "Vocalist(): songlength: " + chord);

    }
	
	
	public void vocalistArray() {
        double[] diffArray = new double[chord];
        for (int column = 1; column <= chord; column++) {
            double[] tempChord = g1.getChordArray(column);

            for (int row = 0; row < tempChord.length - 1; row++) {
                diffArray[row] = Math.abs(tempChord[row] - center);
            }
            melodyArray[0][column - 1] = tempChord[(int)smallestArrayValue(diffArray)];

            melodyArray[1][column - 1] = tempChord[tempChord.length - 1];
        }
    }

    private double smallestArrayValue(double[] passedArray){
    	//this method passes the new 1-D array and finds the min value and returns the index of that value.
        double minValue = passedArray[0];
        double indexOfMin = 0;
        for (int i = 0; i < passedArray.length; i++) {
            if (passedArray[i] < minValue) { //finds min value.
                minValue = passedArray[i];
                indexOfMin = i;
            }
        }
        return indexOfMin;

    }
	
	public String toString() {
		//ths method prints the third and final array.
        String result = "";
        for (int row = 0; row < melodyArray.length - 1; row++) {
            for (int column = 0; column < melodyArray[0].length; column++) {

                result += String.format(" %7.2f", melodyArray[row][column]); //formatting


            }
            
            result += "\n";
            for (int column = 0; column < melodyArray[0].length; column++) {
                result += String.format(" %7.1f", melodyArray[row + 1][column]); //formatting
            }
        }
    return result;

	}


    public void sing(){
    	//this method by using the StdAudio class allows the frequencies to be played.
        for(int i = 0; i < melodyArray[0].length; i++){
            StdAudio.playTone(melodyArray[0][i], melodyArray[1][i]);
        }

    }

}

	

