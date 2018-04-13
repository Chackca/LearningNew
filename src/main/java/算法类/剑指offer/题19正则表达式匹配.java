package 算法类.剑指offer;

public class 题19正则表达式匹配 {
	

	public static boolean match(String str,String pattern){
		if(str==null || pattern==null)
	        return false;
	    return matchCore(new StringBuilder(str),0,new StringBuilder(pattern),0);
	}
	
	
	private static boolean matchCore(StringBuilder SBStr, int indexOfStr, StringBuilder SBPattern, int indexOfPattren) {
		//如果匹配串和模式串都匹配结束
		if (indexOfStr == SBStr.length() && indexOfPattren == SBPattern.length()) {
			return true;
		}
		//当前pattern已经到达尾部，而str还没
		if (indexOfStr != SBStr.length() && indexOfPattren == SBPattern.length()) {	
			return false;
		}
		if(indexOfStr==SBStr.length() && indexOfPattren!=SBPattern.length()) {
			if(indexOfPattren+1<SBPattern.length()&&SBPattern.charAt(indexOfPattren+1)=='*')
                return matchCore(SBStr,indexOfStr,SBPattern,indexOfPattren+2);
			else 
                return false;
        }
		
		//如果模式串的第二个字符不是*或者已经只剩一个字符了
        if(indexOfPattren==SBPattern.length()-1|| SBPattern.charAt(indexOfPattren+1)!='*'){
            if(SBPattern.charAt(indexOfPattren)=='.' || SBPattern.charAt(indexOfPattren)==SBStr.charAt(indexOfStr))
                return matchCore(SBStr,indexOfStr+1,SBPattern,indexOfPattren+1);
            else
                return false;
        }

		
		
      //如果模式串的第二个字符是*
	  else{
	      if(SBPattern.charAt(indexOfPattren)=='.'||SBPattern.charAt(indexOfPattren)==SBStr.charAt(indexOfStr))
	          return matchCore(SBStr,indexOfStr+1,SBPattern,indexOfPattren)
	                  ||matchCore(SBStr,indexOfStr+1,SBPattern,indexOfPattren+2)
	                  ||matchCore(SBStr,indexOfStr,SBPattern,indexOfPattren+2);
	      else
	          return matchCore(SBStr,indexOfStr,SBPattern,indexOfPattren+2);
	  }
		
	}


	public static void main(String[] args){
        System.out.println(match("aaa","a.a"));//true
        System.out.println(match("aaa","ab*ac*a"));//true
        System.out.println(match("aaa","aa.a"));//false
        System.out.println(match("aaa","ab*a"));//false
    }
}
