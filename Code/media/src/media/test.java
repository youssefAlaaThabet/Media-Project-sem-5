package media;

public class test {
	public static void main (String[]args){
		int imgArr [][]=new int [][]{  {0,0,0,0,1,1,1,0},{0,1,0,0,0,0,0,0}}; 
	
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
				//  if(flag==true){
						//RLC=RLC+r+" "+")"+" ";
					//	RLC=RLC+r+" ";
						//flag =false;
						//}
				}
			}
		
			if(flag==true){
				//RLC=RLC+r+" "+")"+" ";
				RLC=RLC+r+")";
				r="";
				flag =false;
				}
		//if(r.length()>3){
		
	//}
		//else {
			//RLC=RLC.substring(0,RLC.length()-6);
		//}
		}
   System.out.println(RLC);
   //System.out.println(RLC.substring(0,RLC.length()-6));

}
	}
