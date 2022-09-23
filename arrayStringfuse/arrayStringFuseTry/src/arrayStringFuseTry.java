import java.util.Arrays;

public class arrayStringFuseTry {
    public static void main(String[] args) {
        String [] a={"Let's","start","to"};
        String [] b={"code","!"};
        // arrayStringfuse(a,b);
        /*
            The operation would be done with the commented method.
            However, I'll add Arrays class visually that it works
         */
        var simpler=Arrays.toString(arrayStringfuse(a,b));
        System.out.println(simpler);
    }
    /* Hey listen, it is a static method, so be aware that it can fit better into a class.
     Understand the idea and adjust the code to your needs ;)
    */
    public static String[] arrayStringfuse(String [] firstArray, String [] secondArray){
        int firLength=firstArray.length;
        int secLength= secondArray.length;
        String [] result=new String [firLength+secLength];
        System.arraycopy(firstArray,0,result,0,firLength);
        System.arraycopy(secondArray,0,result,firLength,secLength);
        return result;
    }
}
