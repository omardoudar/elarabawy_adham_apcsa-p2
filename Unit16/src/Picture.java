import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
	///////////////////// constructors //////////////////////////////////

	/**
	 * Constructor that takes no arguments
	 */
	public Picture() {
		/*
		 * not needed but use it to show students the implicit call to super() child
		 * constructors always call a parent constructor
		 */
		super();
	}

	/**
	 * Constructor that takes a file name and creates the picture
	 * 
	 * @param fileName
	 *            the name of the file to create the picture from
	 */
	public Picture(String fileName) {
		// let the parent class handle this fileName
		super(fileName);
	}

	/**
	 * Constructor that takes the width and height
	 * 
	 * @param height
	 *            the height of the desired picture
	 * @param width
	 *            the width of the desired picture
	 */
	public Picture(int height, int width) {
		// let the parent class handle this width and height
		super(width, height);
	}

	/**
	 * Constructor that takes a picture and creates a copy of that picture
	 * 
	 * @param copyPicture
	 *            the picture to copy
	 */
	public Picture(Picture copyPicture) {
		// let the parent class do the copy
		super(copyPicture);
	}

	/**
	 * Constructor that takes a buffered image
	 * 
	 * @param image
	 *            the buffered image to use
	 */
	public Picture(BufferedImage image) {
		super(image);
	}

	////////////////////// methods ///////////////////////////////////////

	/**
	 * Method to return a string with information about this picture.
	 * 
	 * @return a string with information about the picture such as fileName, height
	 *         and width.
	 */
	public String toString() {
		String output = "Picture, filename " + getFileName() + " height " + getHeight() + " width " + getWidth();
		return output;

	}

	/** Method to set the blue to 0 */
	public void scale(Picture image, String output) {
		Picture smaller = image.scale(.25, .25);
		smaller.write("src/images/" + output);
		smaller.explore();
	}

	public void zeroBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] rowArray : pixels) {
			for (Pixel pixelObj : rowArray) {
				pixelObj.setBlue(0);
			}
		}
	}

	public void keepOnlyBlue() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel pixelObj : row) {
				pixelObj.setRed(0);
				pixelObj.setGreen(0);
			}
		}
	}

	public void keepOnlyGreen() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel pixelObj : row) {
				pixelObj.setRed(0);
				pixelObj.setBlue(0);
			}
		}
	}

	public void keepOnlyRed() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel pixelObj : row) {
				pixelObj.setBlue(0);
				pixelObj.setGreen(0);
			}
		}
	}

	public void negate() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel pixelObj : row) {
				pixelObj.setRed(255 - pixelObj.getRed());
				pixelObj.setBlue(255 - pixelObj.getBlue());
				pixelObj.setGreen(255 - pixelObj.getGreen());

			}
		}
	}

	public void grayscale() {
		Pixel[][] pixels = this.getPixels2D();
		for (Pixel[] row : pixels) {
			for (Pixel pixelObj : row) {
				int average = (pixelObj.getRed() + pixelObj.getBlue() + pixelObj.getGreen()) / 3;
				pixelObj.setRed(average);
				pixelObj.setBlue(average);
				pixelObj.setGreen(average);

			}
		}
	}

	public void fixUnderwater() {
		Pixel[][] pixels = this.getPixels2D();
		int sumRed = 0;
		int sumBlue = 0;
		int sumGreen = 0;

		int pixelCount = pixels.length * pixels[0].length;
		for (Pixel[] row : pixels) {
			for (Pixel pixelObj : row) {
				sumRed += pixelObj.getRed();
				sumBlue += pixelObj.getBlue();
				sumGreen += pixelObj.getGreen();
			}
		}
		int avgRed = sumRed / pixelCount;
		int avgBlue = sumBlue / pixelCount;
		int avgGreen = sumGreen / pixelCount;

		int arbGreen = 120;
		int arbBlue = 130;
		int arbRed = 120;
		for (Pixel[] r : pixels) {
			for (Pixel pixel : r) {
				pixel.setGreen(pixel.getGreen() + (arbGreen - avgGreen));
				pixel.setBlue(pixel.getBlue() + (arbBlue - avgBlue));
				pixel.setRed(pixel.getRed() + (arbRed - avgRed));
			}
		}
	}

	/**
	 * Method that mirrors the picture around a vertical mirror in the center of the
	 * picture from left to right
	 */
	public void mirrorVertical() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	public void mirrorVerticalRightToLeft() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int width = pixels[0].length;
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < width / 2; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][width - 1 - col];
				leftPixel.setColor(rightPixel.getColor());
			}
		}
	}

	public void mirrorHorizontal() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel botPixel = null;
		int height = pixels.length;
		for (int row = 0; row < height / 2; row++) {
			for (int col = 0; col < pixels[row].length; col++) {
				topPixel = pixels[row][col];
				botPixel = pixels[height - row - 1][col];
				botPixel.setColor(topPixel.getColor());
			}
		}
	}

	public void mirrorHorizontalBotToTop() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel topPixel = null;
		Pixel botPixel = null;
		int height = pixels.length;
		for (int row = 0; row < height / 2; row++) {
			for (int col = 0; col < pixels[row].length; col++) {
				topPixel = pixels[row][col];
				botPixel = pixels[height - row - 1][col];
				topPixel.setColor(botPixel.getColor());
			}
		}
	}

	public void mirrorDiagonal() {
		Pixel[][] pixels = this.getPixels2D();
		Pixel lowerPixel = null;
		Pixel upperPixel = null;
		int square = Math.min(pixels.length, pixels[0].length);
		for (int i = 0; i < square; i++) {
			for (int j = 0; j < i; j++) {
				lowerPixel = pixels[i][j];
				upperPixel = pixels[j][i];
				upperPixel.setColor(lowerPixel.getColor());
			}
		}
	}

	/** Mirror just part of a picture of a temple */
	public void mirrorTemple() {
		int mirrorPoint = 276;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		int count = 0;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 27; row < 97; row++) {
			// loop from 13 to just before the mirror point
			for (int col = 13; col < mirrorPoint; col++) {
				count++;
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
		System.out.print(count);
	}

	public void mirrorArms() {
		int mirrorPoint = 191;
		Pixel topPixel = null;
		Pixel botPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		for (int row = 160; row < mirrorPoint; row++) {
			for (int col = 103; col < 170; col++) {
				topPixel = pixels[row][col];
				botPixel = pixels[mirrorPoint - row + mirrorPoint][col];
				botPixel.setColor(topPixel.getColor());
			}
		}
		mirrorPoint = 196;
		for (int row = 172; row < mirrorPoint; row++) {
			for (int col = 239; col < 295; col++) {
				topPixel = pixels[row][col];
				botPixel = pixels[mirrorPoint - row + mirrorPoint][col];
				botPixel.setColor(topPixel.getColor());
			}
		}
	}

	public void mirrorGull() {
		int mirrorPoint = 344;
		Pixel leftPixel = null;
		Pixel rightPixel = null;
		Pixel[][] pixels = this.getPixels2D();

		// loop through the rows
		for (int row = 234; row < 321; row++) {
			// loop from 13 to just before the mirror point
			for (int col = 237; col < mirrorPoint; col++) {
				leftPixel = pixels[row][col];
				rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
				rightPixel.setColor(leftPixel.getColor());
			}
		}
	}

	/**
	 * copy from the passed fromPic to the specified startRow and startCol in the
	 * current picture
	 * 
	 * @param fromPic
	 *            the picture to copy from
	 * @param startRow
	 *            the start row to copy to
	 * @param startCol
	 *            the start col to copy to
	 */
	public void copy(Picture fromPic, int startRow, int startCol) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = 0, toRow = startRow; fromRow < fromPixels.length
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = 0, toCol = startCol; fromCol < fromPixels[0].length
					&& toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	public void copy(Picture fromPic, int startR, int startC, int endR, int endC, int row, int col) {
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = Math.min(fromPixels.length, startR), toRow = row; fromRow < Math.min(fromPixels.length, endR)
				&& toRow < toPixels.length; fromRow++, toRow++) {
			for (int fromCol = Math.min(fromPixels.length, startC), toCol = col; fromCol < Math
					.min(fromPixels[0].length, endC) && toCol < toPixels[0].length; fromCol++, toCol++) {
				fromPixel = fromPixels[fromRow][fromCol];
				toPixel = toPixels[toRow][toCol];
				toPixel.setColor(fromPixel.getColor());
			}
		}
	}

	public void encode(Picture messagePict) {
		// var init
		Pixel[][] messagePixels = messagePict.getPixels2D();
		Pixel[][] currImage = this.getPixels2D();
		Pixel currPixel = null;

		ArrayList<ArrayList<Integer>> pixelLocations = new ArrayList<ArrayList<Integer>>();
		boolean isLookingForBlack;

		// temp init
		int blackCount = 0;
		int whiteCount = 0;

		// optimize which color being written
		for (int row = 0; row < messagePict.getHeight(); row++) {
			for (int col = 0; col < messagePict.getWidth(); col++) {
				currPixel = messagePixels[row][col];
				if (isBlack(currPixel)) {
					blackCount++;
				} else {
					whiteCount++;
				}
			}
		}

		isLookingForBlack = true;//(blackCount >= whiteCount);

		for (int row = 0; row < messagePict.getHeight(); row++) {
			for (int col = 0; col < messagePict.getWidth(); col++) {
				if (isBlack(messagePixels[row][col])) {
					if(isLookingForBlack) {
						System.out.println("row: " + row + " col: " + col);
						pixelLocations.add(convertToBinary(row));
						System.out.println("row: " + convertToBinary(row) + " col: " + convertToBinary(col));
						System.out.println("row: " + getIntFromBinary(convertToBinary(row)) + " col: " + getIntFromBinary(convertToBinary(col)));
						pixelLocations.add(convertToBinary(col));
					}
				} else {
					if(!isLookingForBlack) {
						pixelLocations.add(convertToBinary(row));
						pixelLocations.add(convertToBinary(col));
					}
				}
			}
		}
		
		//temp init v2
		int row = 0;
		int col = 0;
		int i = 0;
		System.out.println(pixelLocations.get(1));
		System.out.println(getIntFromBinary(pixelLocations.get(1)));
		for(int b = 0; b < pixelLocations.size(); b++) {
			ArrayList<Integer> binarySet = pixelLocations.get(b);
			boolean isRow = (i%2 == 0);
			//System.out.println(pixelLocations.size());
			for(int binaryVal : binarySet) {
				//System.out.println("row" + row + " col" + col);
				//System.out.println(currImage[row][col].getGreen());
				if(isRow) {
					currImage[row][col].setGreen(currImage[row][col].getGreen() - ((currImage[row][col].getGreen()%2==0) ? 0 : 1));
				} else {
					currImage[row][col].setGreen(currImage[row][col].getGreen() - ((currImage[row][col].getGreen()%2==0) ? 1 : 0));
				}
				
				if(binaryVal == 0) {
					currImage[row][col].setRed(currImage[row][col].getRed() - ((currImage[row][col].getRed()%2==0) ? 0 : 1));
				} else {
					currImage[row][col].setRed(currImage[row][col].getRed() - ((currImage[row][col].getRed()%2==0) ? 1 : 0));
				}
				//System.out.println(currImage[0].length);
				if(col==639) {
					col = 0;
					row++;
				} else {
					col++;
				}
			}
			i++;
			
		}
		
		
		System.out.println("--------------------------------------");

	}

	public static ArrayList<Integer> convertToBinary(int num){
	    ArrayList<Integer> binary = new ArrayList<Integer>();
	    String temp = Integer.toBinaryString(num);
	    ArrayList<String> out = new ArrayList<String>(Arrays.asList(temp.split("")));
	    return getIntegerArray(out);
	}
	
	private static ArrayList<Integer> getIntegerArray(ArrayList<String> stringArray) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(String stringValue : stringArray) {
            try {
                //Convert String to Integer, and store it into integer array list.
                result.add(Integer.parseInt(stringValue));
            } catch(NumberFormatException nfe) {
               //System.out.println("Could not parse " + nfe);
                //Log.w("NumberFormat", "Parsing failed! " + stringValue + " can not be an integer");
            } 
        }       
        return result;
    }
	
	public static boolean isBlack(Pixel pixel) {
		int currRed = pixel.getRed();

		// checks to see if the distance to pure white is closer than the distance to
		// pure black
		
		//if distance to white is smaller than distance to black
		if (currRed < 255 - currRed) {
			return true;
		} else {
			return false;
		}
	}

	public static String getStringFromPixel(int row, int col) {
		return String.format("%03d", row) + String.format("%03d", col);
	}
	
	public static int getIntFromBinary(ArrayList<Integer> temp) {
		String intString = "";
		for (int bit : temp) {
		    intString += bit + "";
		}
		
		return Integer.parseInt(intString, 2);
	}
	
	public Picture decode() {
		Pixel[][] pixels = this.getPixels2D();
		int height = this.getHeight();
		int width = this.getWidth();
		Pixel currPixel = null;

		ArrayList<ArrayList<Integer>> blackLocations = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> tempBinarySet = new ArrayList<Integer>();
		int binarySetIndex = 0;
		int pastIndex = 0;
		for(int row = 0; row < height; row++) {
			for(int col = 0; col< width; col++) {
				binarySetIndex = (pixels[row][col].getGreen() % 2 == 0) ? 0 : 1;
				if(binarySetIndex != pastIndex) {
					blackLocations.add(tempBinarySet);
					tempBinarySet = new ArrayList<Integer>();
				}
				if(pixels[row][col].getRed() % 2 != 0) {
					tempBinarySet.add(1);
				} else {
					tempBinarySet.add(0);
				}
				pastIndex = binarySetIndex;
				
			}
		}
		
		Pixel messagePixel = null;
		Picture messagePicture = new Picture(height,width);
		Pixel[][] messagePixels = messagePicture.getPixels2D();
		System.out.println(blackLocations.get(1));
		System.out.println(getIntFromBinary(blackLocations.get(1)));
		for(int i = 0; i < blackLocations.size()/2; i+=2) {
			
			int row = getIntFromBinary(blackLocations.get(i));
			int col = getIntFromBinary(blackLocations.get(i+1));
			System.out.println("row: " + row + " col: " + col);
			System.out.println("row: " + blackLocations.get(i) + " col: " + blackLocations.get(i+1));
			messagePixels[row][col].setColor(Color.BLACK);
		}
			return messagePicture;
	}

	/** Method to create a collage of several pictures */
	public void createCollage() {
		Picture flower1 = new Picture("src/images/flower1.jpg");
		Picture flower2 = new Picture("src/images/flower2.jpg");
		this.copy(flower1, 0, 0);
		this.copy(flower2, 100, 0);
		this.copy(flower1, 200, 0);
		Picture flowerNoBlue = new Picture(flower2);
		flowerNoBlue.zeroBlue();
		this.copy(flowerNoBlue, 300, 0);
		this.copy(flower1, 400, 0);
		this.copy(flower2, 500, 0);
		this.mirrorVertical();
		this.write("src/images/collage.jpg");
	}

	public void createMyCollage() {
		Picture obj1 = new Picture("src/images/snowman.jpg");
		Picture obj2 = new Picture("src/images/robot.jpg");

		this.copy(obj1, 55, 55, 105, 105, 0, 0);
		this.copy(obj2, 100, 0);
		Picture negativeObj = new Picture(obj1);
		negativeObj.negate();
		this.copy(negativeObj, 200, 0);

		Picture objBlue = new Picture(obj2);
		objBlue.keepOnlyBlue();
		this.copy(objBlue, 400, 0);

		Picture objMirrored = new Picture(obj1);
		objMirrored.mirrorHorizontal();

		this.copy(objMirrored, 400, 0);
		this.copy(obj2, 500, 0);
		this.mirrorVertical();
		this.write("src/images/collage.jpg");
	}

	/**
	 * Method to show large changes in color
	 * 
	 * @param edgeDist
	 *            the distance for finding edges
	 */
	public void edgeDetection(int edgeDist) {
		Pixel firstPixel = null;
		Pixel secondPixel = null;
		Pixel[][] pixels = this.getPixels2D();
		Color secondColor = null;
		int[][] change = new int[pixels.length][pixels[0].length];
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				firstPixel = pixels[row][col];
				if (col < pixels[0].length - 1) {
					secondPixel = pixels[row][col + 1];
					secondColor = secondPixel.getColor();
					if (firstPixel.colorDistance(secondColor) > edgeDist) {
						change[row][col] = 1;
					}
				}
				if (row < pixels.length - 1) {
					secondPixel = pixels[row + 1][col];
					secondColor = secondPixel.getColor();
					if (firstPixel.colorDistance(secondColor) > edgeDist) {
						change[row][col] = 1;
					}
				}
			}
		}
		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				if (change[row][col] == 1)
					pixels[row][col].setColor(Color.BLACK);
				else
					pixels[row][col].setColor(Color.WHITE);
			}
		}
	}

	public void edgeDetection2(int edgeDist) {
		Pixel[][] pixels = this.getPixels2D();
		int[][] change = new int[pixels.length][pixels[0].length];
		for (int row = 0; row < pixels.length - 2; row++) {
			for (int col = 0; col < pixels[0].length - 2; col++) {
				float vertSum = 0;
				for (int rowComp = row; rowComp < row + 3; rowComp++) {
					vertSum += pixels[rowComp][col].colorDistance(pixels[rowComp][col + 2].getColor());
				}

				if (vertSum / 3 > edgeDist) {
					change[row + 1][col] = 1;
					change[row + 1][col + 1] = 1;
					change[row + 1][col + 2] = 1;
				}

				float horizSum = 0;
				for (int colComp = col; colComp < col + 3; colComp++) {
					horizSum += pixels[row][colComp].colorDistance(pixels[row + 2][colComp].getColor());
				}
				if (horizSum / 3 > edgeDist) {
					change[row][col + 1] = 1;
					change[row + 1][col + 1] = 1;
					change[row + 2][col + 1] = 1;
				}
			}
		}

		for (int row = 0; row < pixels.length; row++) {
			for (int col = 0; col < pixels[0].length; col++) {
				if (change[row][col] == 1)
					pixels[row][col].setColor(Color.BLACK);
				else
					pixels[row][col].setColor(Color.WHITE);
			}
		}
	}

	/*
	 * Main method for testing - each class in Java can have a main method
	 */
	public static void main(String[] args) {
		//System.out.println(getStringFromPixel(123, 12));
	}

} // this } is the end of class Picture, put all new methods before this
