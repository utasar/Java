public class Family
{
    private Person parent1;
    private Person parent2;
    private Person child;

    public Family(Person p1, Person p2, Person p3)
    {
        setParent1(p1);
        setParent2(p2);
        setChild(p3);
    }

    public Person getParent1()
    {
        // utilizes the Person copy constructor to create
        // a deep copy of parent1
        return new Person(parent1);

        // performs a shallow copy of parent1
        // returns the reference (memory address)
        // so if the returned reference is modified,
        // then this class's parent1 will also be modified
        // uncomment to see what happens
        // return parent1;
    }

    private void setParent1(Person parent1)
    {
        this.parent1 = parent1;
    }

    public Person getParent2()
    {
        return parent2;
    }

    private void setParent2(Person parent2)
    {
        this.parent2 = parent2;
    }

    public Person getChild()
    {
        return child;
    }

    public void setChild(Person child)
    {
        this.child = child;
    }
}
