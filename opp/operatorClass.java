public class operatorClass {
    public static void main(String[] args) {
        //Arithmetic operator 
        //+,-,/,*,%
        int intVar1 =10, intVar2 =20;
        int addOper = intVar1+intVar2; //+10+20
        int minusOper = intVar1-intVar2; //10-20
        int multOper = intVar1*intVar2; //10*20
        int divOper = intVar1/intVar2; //10/20
        int modOper = intVar1%intVar2; //10%20(remainder)

        System.out.println("addOper :"+addOper);
        System.out.println("minusOpper:"+ minusOper);
        System.out.println("multOper:"+multOper);
        System.out.println("divOper:"+divOper);
        System.out.println("modOper:"+modOper);

        //Assignment Operator 
        int assignVar = 10;
        assignVar += 20; //10+20= 30
        assignVar -= 15; //30-15=15
        assignVar *= 2; //15*2=30
        assignVar /= 10; //30/10=3
        assignVar %= 2;  //3%2=1

        System.out.println("assignVar:"+assignVar);

        //unary operator 
        int unaryVar = 20;
        unaryVar ++; //unaryVar += 1; 20+1;
        unaryVar --; //unaryVar -= 1;21-1; 20
        System.out.println("unaryVar:"+unaryVar);

        //rrelational operator 
        int relVar1 =20, relVar2 =30;
        boolean equalOper =relVar1==relVar2; //20=30 ? false
        boolean greaterOper = relVar1 > relVar2; //20>30 ? false
        boolean lessEqualOper = relVar2 <=30; // 30<=30? true
        boolean notEqual =20 !=10; //true

        System.out.println("equalOper:"+equalOper);
        System.out.println("greaterOper:"+greaterOper);
        System.out.println("lessEqaualOper:"+lessEqualOper);
        System.out.println("notEqual:"+notEqual);

        //logical operator 
        int logVar1 = 10, logVar2 =20, logVar3 =23;
        boolean andOper =true && true;
        boolean andoperVar =(logVar1< logVar2)&& (logVar3 == logVar2); // true&&false
        boolean orOper = false || false || true;
        boolean orOpervar =(logVar1 < logVar2) || (logVar3 == logVar2);
        boolean notOper = !(logVar1 <logVar2); //!true -> false 

        System.out.println("andOper:"+andOper);
        System.out.println("andOperVar:"+andoperVar);
        System.out.println("orOper:"+orOper);
        System.out.println("multOper:"+multOper);
        System.out.println("orOperVar:"+orOpervar);
        System.out.println("notOper:"+notOper);
        
        //Ternary operator 
        /*
         * string status;
         * int marking =40;
         * if (marking >40){
         * status ="pass";
         * }
         * else{
         * status ="Fail";
         * }
         */
        int marking =40;
        String status = (marking >40) ? "Pass" :"Fail";
        System.out.println("Status :" +status);

        /*
* Task
* Add the follwing variable
* oopMarking -> int
* architectureMarking -> int
* databaseMarking -> int
* creativeThinking -> int
* make a float avg and calculate the avg of the markings
* make a boolean expressions to check if
* all the marking is greater than 50
* Make a result -> String and check the boolean
* if the true set result as "Good job" else set result as "Bad job"
* print the result
*/

int oopMarking = 30;
        int architectureMarking = 40;
        int databaseMarking = 50;
        int creativeThinkingMarking = 45;
        float avg = (float) (oopMarking + architectureMarking 
            + databaseMarking + creativeThinkingMarking) / 4;
        boolean check = oopMarking >= 40 &&
            databaseMarking >=40 && architectureMarking >= 40 &&
            creativeThinkingMarking >=40 && avg >=50;
        String result = check ? "Good Job" : "Bad Job";
        System.out.println(result);
    }
} 
