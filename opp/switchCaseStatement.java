public class switchCaseStatement {
    public static void main(String[] args){
        int day = 3;
        switch (day){
            //day == 0
            case 0:
            System.out.println("sunday");
            break;
            case 1:
            System.out.println("Monday");
            break;
            case 2:
            System.out.println("Tuesday");
            break;
            default:
                System.out.println("unknown day");
            break;
        }

        //nested switch statement 
        String beverage = "Coke";
        char gender = 'M';
        switch (beverage) {
            case "Coke":
                switch (gender) {
                    //coke and M
                    case 'M':
                        System.out.println("Male");
                        break;
                    case 'F':
                    System.out.println("Female");
                    break;
                }
                System.out.println("Black");
                break;
            default:
                System.out.println("Unknown breverage");
                break;
        }

        //switch case or 
        int status = 404;
        switch (status){
            case 200:
            case 201:
            case 202:
                System.out.println("Success");
                break;
                //status ==401 || status ==404
                case 401:
                case 404:
                    System.out.println("Not found");
                    break;
                default:
                    System.out.println("unknown status");
                    break;
        }
        //Task 1
        //make an int month and assign value 
        //int month =4;
        //using switch case check the month and print the following 
        //0 -> Jan 
        //1 -> Feb 
        //2 -> Mar 
        //3 -> jun 
        //.. -> continue each month till 11
        //11 -> Dec 
        //else -> unknown month 

        //Task 2 
        //Make a variable string locale and assign "np"
        //String locale = "np"
        //using switch case check the and print the following 
        //"en" or "en/us" or "en/uk" -> "Selected english "
        //"in" -> "selected indian"
        //"jp" -> "selected japanese "
        //"np" -> "selected Nepali "
        //else -> "unknown locale"

        //task 1 answer:
        int month = 4;
        switch (month){
            //day == 0
            case 0:
            System.out.println("Jan");
            break;
            case 1:
            System.out.println("Feb");
            break;
            case 2:
            System.out.println("March");
            break;
            case 3:
            System.out.println("April");
            break;
            case 4:
            System.out.println("May");
            break;
            case 5:
            System.out.println("June");
            break;
            case 6:
            System.out.println("July");
            break;
            case 7:
            System.out.println("August");
            break;
            case 8:
            System.out.println("September");
            break;
            case 9:
            System.out.println("October");
            break;
            case 10:
            System.out.println("November");
            break;
            case 11:
            System.out.println("December");
            break;
            default:
                System.out.println("unknown month");
            break;
        }

        //task 2 answerr
        String locale = "np";
        switch (locale){
            case "en/us or en/uk":
            System.out.println("Selected english");
            break;
            case "in":
            System.out.println("Selected Indian");
            break;
            case "jp":
            System.out.println("Selected Japanese");
            break;
            case "np":
            System.out.println("Selected Nepali");
            default:
                System.out.println("unknown locale");
            break;
        }

    }
}
