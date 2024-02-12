package multi.threading.project.example;

public class CharecExample {

    public static void main(String[] args) {

        int x = 123;
        String val = Integer.toString(x);

        for(int i=0;i<val.length()-1;i++){

           // System.out.println(val.charAt(i+1)+val.charAt(i));
           // System.out.println(val.charAt(i));

            int i1 = Character.getNumericValue(val.charAt(i)) + Character.getNumericValue(val.charAt(i + 1));
            System.out.println(i1);
        }
    }
}
