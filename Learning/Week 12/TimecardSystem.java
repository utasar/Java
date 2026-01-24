import java.util.ArrayList;

public class TimecardSystem
{
    public static void main(String[] args)
    {
        // ArrayList that takes advantage of polymorphism to hold both
        // Employee and Manager objects (because Manager IS-A Employee)
        ArrayList<Employee> allEmployees = new ArrayList<>();

        Employee e1 = new Employee("Bob", 5);
        System.out.println(e1.canTakeLeave());
        System.out.println(e1);
        allEmployees.add(e1);

        Manager m1 = new Manager("Fred", 3, 7);
        System.out.println(m1);
        System.out.println(m1.getNumSubordinates());
        m1.setNumCurrentProjects(7);
        System.out.println(m1.canTakeLeave());
        allEmployees.add(m1);

        // demonstrates polymorphism of assignProjects
        assignProjects(e1);
        System.out.println(e1);
        assignProjects(m1);
        System.out.println(m1);

        // generating a bunch of empty objects for the ArrayList
        for (int i = 0; i < 9; i++)
        {
            allEmployees.add(new Employee());
        }

        for (int i = 0; i < 2; i++)
        {
            allEmployees.add(new Manager());
        }

        // counting only the occurrences of Manager in the ArrayList
        int numManagers = 0;
        for (Employee e : allEmployees)
        {
            if (e instanceof Manager)
            {
                numManagers++;
            }
        }
        System.out.println("There are " + numManagers + " managers.");
    }

    // method that takes advantage of polymorphism by accepting type Employee
    // (or any subtype of Employee) and then calling the appropriate
    // setNumCurrentProjects method
    public static void assignProjects(Employee e)
    {
        e.setNumCurrentProjects(5);
    }
}
