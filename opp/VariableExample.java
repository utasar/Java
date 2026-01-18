public class VariableExample {
    //Instance Variable
    int instanceVariable=100;
    //instancevariable can only be accessed with the object
    //static Variable
    static boolean staticVariable =false;
    //staticVariable can be accessed with class directly

    void firstFunction(){
        int localVariable =300;
        //Local Variable are made inside a function/constuctor scope/block
        System.out.println("Local variable:"+localVariable);
    }
    
    public static void main (String[]args){
        int localVariable2 =400;
        System.out.println("Local Variable :"+ localVariable2);
        //To use the instance variable of a class, make object
        //syntax: ClassName objVariable = new ClassName();
        VariableExample variableExampleObj =new VariableExample();
        //the variable of variableExample is called object, here variableExampleObj
        variableExampleObj.instanceVariable=600;
        System.out.println("Instance Variable: "+ variableExampleObj.instanceVariable);
        //static variable can be accessed with, ClassName.variableName
        System.out.println("Static Variable:" + VariableExample.staticVariable);
        VariableExample variableExampleObj2 = new VariableExample();
        variableExampleObj2.instanceVariable=360;
        System.out.println(variableExampleObj2.instanceVariable);
        VariableExample.staticVariable=true;


        //Java Typecasting Primitive Datatype
        //Widening Cating/Implicit casting/automatic
        //conversion of smaller datatype to larger datatype (size/capacity)
        //byte -> short-> char -> int -> long -> float -> double 
        byte byteVariable=10;
        short shortVariable=byteVariable; //here byte is automatically converted to short
        System.out.println("shortVariable;"+shortVariable);

        int mathMark =20;
        double mathConverted =mathMark; //int is automatically converted to double -> 20.0
        System.out.println("Int to double "+ mathConverted);
        
        //Narrowing Casting/Explicit Casting/manual
        //conversion of larger datatype to smaller datatype
        double gpa =3.4;
        int gpaInt =(int) gpa;
        System.out.println("GPA int" +gpaInt);
        int floatConversion =(int) 400.33f; //400
        System.out.println("floatConversion:"+floatConversion);

        //calculation
        float mathcalc=1/2;
        System.out.println(mathcalc); //1/2 in int is 0-> 0.0
        float mathCalcSolve =1.0f/2; //either one value float
        System.out.println("mathCalcSolve:"+mathCalcSolve);
        float mathCalcSolve2= (float) 1/2; //or manual cost
        System.out.println("mathCalcSolve2:"+mathCalcSolve2);

    }
}
