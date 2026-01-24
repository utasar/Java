public class Manager extends Employee
{
    private int numSubordinates = 0;

    public Manager()
    {
        super();
    }

    public Manager(String name, int numSubordinates, int numProjects)
    {
        // equivalent to setNumCurrentProjects() line
        super(name, numProjects);
        //super.setNumCurrentProjects(numProjects);
        //numCurrentProjects = numProjects;
        this.numSubordinates = numSubordinates;
    }

    // this method will get called if the object is type Manager
    @Override
    public boolean canTakeLeave()
    {
        return true;
    }

    @Override
    public void setNumCurrentProjects(int numProjects)
    {
        super.setNumCurrentProjects(numProjects);
        this.setNumSubordinates(numProjects * 3);
    }

    public int getNumSubordinates()
    {
        return numSubordinates;
    }

    public void setNumSubordinates(int numSubordinates)
    {
        this.numSubordinates = numSubordinates;
    }

    // This method will get called if the object is of type Manager
    @Override
    public String toString()
    {
        return "Manager " + super.getName() + " has " + numSubordinates + " subordinates and is currently working on " + super.getNumCurrentProjects() + " projects.";
    }
}
