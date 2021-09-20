package activities;

public class Activity2 {

	public static void main(String[] args) {
		
		int number[] = {10,77,10,54,-11,10};
		int totalarraysize = number.length;
		
		//System.out.println(totalarraysize);
		
		int count =0;
		//for(int i=0;i<totalarraysize;i++)
		for(int i : number)
		{
			if(i==10)
			{
				count = count + i;
			}
			
		//	System.out.println("The elements in position of  "  + " is " +  i);
			//count = count + number[i];
			
					
		}
		//System.out.println("Result:"+ (count==30));
		if(count==30) {
			System.out.println("True " + "and the value is equal to " + count);
		}
		else {
			System.out.println("False" + " The value is not equal to 30");
		}
		//System.out.println("The total sum of arry is " + count);
		
		

	}

}
