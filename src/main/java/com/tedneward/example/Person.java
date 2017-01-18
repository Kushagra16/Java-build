package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person implements Comparable<Person>{           //Added
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;
  static int count = 0;                            // Added 
  
  public Person() {	
    this("", 0, 0.0d);
    count ++;                                      // Added
  }
  
  public Person(String n, int a, double s) {
    
    name = n;
    age = a;
    salary = s;
    count ++;                                      // Added
  }

  public void setSSN(String value) {
    String old = ssn;
    ssn = value;
    
    this.pcs.firePropertyChange("ssn", old, value);
    propertyChangeFired = true;
  }
  public boolean getPropertyChangeFired() {
    return propertyChangeFired;
  }

  public double calculateBonus() {
    return salary * 1.10;
  }
  
  public String becomeJudge() {
    return "The Honorable " + name;
  }
  
  public int timeWarp() {
    return age + 10;
  }
  
  public String toString() {
      return "[" + "Person name:" + name + " age:" +  Integer.toString(age) + " salary:" + Double.toString(salary) + "]";
  }

  // PropertyChangeListener support; you shouldn't need to change any of
  // these two methods or the field
  //
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  public void addPropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.removePropertyChangeListener(listener);
  }

//                          NEW CHANGES

public void setAge(int a)
{
if(a<0) throw new IllegalArgumentException("age must be positive");
age = a;
}

public int getAge()
{
return age;
}

public void setName(String st)
{
if(st == null) throw new IllegalArgumentException("String must be not null");
name = st;
}

public String getName()
{
return name;
}

public void setSalary(double sal)
{
salary = sal;
}
public double getSalary()
{
return salary;
}

public int count()
{
 return count;
}


public boolean equals(Object obj)
{
if(obj instanceof Person)
{
Person ot = (Person)obj;
return age == ot.age && name == ot.name;
} return false;
}


public static class AgeComparator implements Comparator<Person>
{
public int compare(Person p1, Person p2)
{
if(p1.age == p2.age) return 0;
if(p1.age > p2.age) return 1;
else return -1;
}
}
 
public int compareTo(Person p)
{
if(salary == p.salary) return 0;
else if(salary > p.salary) return -1;
else return 1;
}

public static ArrayList<Person> getNewardFamily()
{
ArrayList<Person> al = new ArrayList<Person>();
Person p11 = new Person("Matthew", 15, 0);
Person p12 = new Person("Michael", 22, 10000);
Person p13 = new Person("Ted", 41, 250000);
Person p14 = new Person("Charlotte", 43, 150000);
al.add(p11);
al.add(p12);
al.add(p13);
al.add(p14);
return al;
}

}
