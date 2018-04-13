package 算法类.剑指offer;

/*

 */
public class 题1赋值运算符函数 {
	
	public static class MyString{
		private String data;
		
		public MyString(String data){
			this.data=data;
		}
		
		public MyString assign(MyString another) {
			if (this == another || another.data.equals(this.data)) {
				return this;
			}else {
				this.data = another.data;
				return this;
			}	
		}

		@Override
		public String toString() {
			return "MyString [data=" + data + "]";
		}
		
		
	}
	
	
	public static void main(String[] args) {
        MyString s1 = new MyString("a");
        MyString s2 = new MyString("b");
        MyString s3 = new MyString("c");
        System.out.println("s1:" +s1.assign(s2).assign(s3));
        System.out.println("s1:" + s1);
        System.out.println("s2:" + s2);
        System.out.println("s3:" + s3);
    }

	
}
