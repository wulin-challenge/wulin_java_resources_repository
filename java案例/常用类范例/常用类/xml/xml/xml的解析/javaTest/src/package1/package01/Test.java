package package1.package01;

/*public  class Test {
    public static void main(String[] args) {
         System.out.println(new Test().test());
    }

    int test()
    {
         try
         {
             return func1();
         }
         finally
         {
             return func2();
         }
    }

    int func1()

    {
         System.out.println("func1");
         return 1;
    }
    int func2()
    {
         System.out.println("func2");
         return 2;
    }    
}*/

public  class Test {
    public static void main(String[] args) {
         System.out.println(new Test().test());;
    }

    static int test()

    {
         int x = 1;
         try
         {
             return x;
         }
         finally
         {
            x++;
            System.out.println(x);
         }
    }
}
