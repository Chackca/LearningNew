package 算法类.剑指offer;

public class 题581翻转单词顺序 {
	
	public static String reverse(String str){
		if (str.length()==0||str==null) return null;
		//第一步：反转所有字符
		StringBuilder SB = new StringBuilder();
		for (int i = str.length()-1; i >= 0; i--) 
			SB.append(str.charAt(i));
		
		//第二步：反转被反转的单词
		int start = 0;int end = 0;
		String temp = null;
		while (end<=str.length()-1) {
			while (end<=str.length()-1&&SB.charAt(end)!=' ') 
				end++;
			temp = SB.substring(start,end);
			int length = temp.length();
			for (int i = start; i < end; i++) {
				int last = length-(i-start)-1;
				SB.setCharAt(i, temp.charAt(last));
			}
			//跳过当前的 空格
			start=end+1;
			end++;
		}
		
		return SB.toString();
	}
	
	
	
	
	


	public static void main(String[] args){
	    System.out.println(reverse("I am a student.")); 
	    System.out.println(reverse("Ia am a student.")); 
	    System.out.println(reverse("Iaa am a student.")); 
	    //System.out.println("asdf".substring(0,2));
	}



	/*public static void main(String[] args) {
	    Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] string = str.split(" ");
        for(int i=0;i<string.length;i++){
            System.out.print(string[string.length-i-1]+" ");
        }
    }*/
}
