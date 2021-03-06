package media;


import java.io.File; 
import java.io.FileWriter;
import java.io.IOException; 
import java.awt.image.BufferedImage; 
import java.awt.image.Raster;

import javax.imageio.ImageIO; 


public class RunLengthCode {

	private static String ComputeCode(int[][] imgArr){
		int freq=0;
		String RLC="" ;
		String r="";
		boolean flag=false;

		// write your logic here 
		for(int i=0; i<imgArr.length;i++){

			for(int j=0;j<((imgArr[i]).length);j++){
				
				if (imgArr[i][j]==0){
					continue;
				}
				
				else {
					if(imgArr[i][j]==1 && r==""){
						r="("+i+" ";
					}
					freq++;
					if(imgArr[i].length==j+1 || imgArr[i][j+1]==0){
					r=r+((j+1)-freq)+" "+(j)+" ";
					freq=0;
					flag = true;
					}
					}
				}
			
				if(flag==true){
					RLC=RLC+r+")";
					r="";
					flag =false;
					}
			}
             File myObj = new File("Triangle_RLE.txt");
		
	    try {
	    	FileWriter myWriter = new FileWriter("Triangle_RLE.txt");
			myWriter.write(RLC);
			myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return RLC;
	}
	
	public static void main(String [] args) {
		//write image path 
		String path = "C:/Users/20100/Desktop/binary_triangle.jpg";
		
		BufferedImage image = null;
		
		try {
			File input_image = new File(path);
			// Reading input image 
		    image = ImageIO.read(input_image);
		    System.out.println("Reading complete."); 
		} 
		
		catch (IOException e) {
		}
		
		// convert image to 2D array 
		int width = image.getWidth();
	    int height = image.getHeight();
	    int[][] imgArr = new int[height][width];
	    Raster raster = image.getData();
	    for (int i = 0; i < height; i++) {
	        for (int j = 0; j < width; j++) {
	            imgArr[i][j] = raster.getSample(j, i, 0);

	    }
	   }
		
	    
		// print run length Code 
		System.out.println(ComputeCode(imgArr));
		

	}//main ends here
	
}// class ends here 


