public class VariableIntroduction {
    public static void main(String[]args){
        //shortcut psvm
        //Primitive datatype
        //Declaration
        boolean boolVaraible;
        //Initialization
        boolVaraible=false;
        //Declaration and initialization
        int intVariable=10;
        //Multi Declaration
        float floatVariable1,floatVariable2;
        //Initialization
        floatVariable1 =10.33f;
        //Multi Declaration and Initialization
        char charVariable1='c', charVariable2='a',charVariable3='t';
        //Limitations
        //byte byteVariable=1000000; cannot exceed the capacity
        //short shortVariable =false; cannot mismatch type of value 

        //Non Primitive Datatype    
        String stringVariable="Hello World";
        //String value is enclosed in double quotes""
        //Can make string using constructor
        String stringVariable2= new String("object of string");
        

        /*Task
         * Declare the following variable
         * firstName String
         * lastName String
         * age int
         * over18 boolean
         * Initialize each variable with your own detail
         * declare multiple variable
         * mathMarking,englishMarking,scienceMarking-> float
         * Initialize each variable with decimal number 
         * Declare and initialize multiple variable
         * averageMarking,gpa-> double
        */

        String firstName="Pratikshya";
        String lastName="shrestha";
        int age=19;
        boolean over18=true;
//Initialize and declare
        float mathMarking=80f;
        float englishMarking=88f;
        float scienceMarking=79f;
        

        float mathMarking=80f, englishMarking=88f, scienceMarking=79f;
        double averageMarking=60.99d, gpa=3.4;
        //'d' is optional in double 
    

    }
}
