import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class GenericList<X>
{
  private X[] arr;
  private int size;

    //Constructor for objects of class GL
  public GenericList()
  {
   this.newArray();// X[10];
  }

//Size - returns the size of the list.
  public int size()
  {
    return size;
  }

//Add - add one value to the list in the next available position
  public void add(X value)
  {
    if (size == arr.length) // Is arr full? Then expand by 20%
    {
      this.expandArray();
    }

    arr[size] = value;
    size++;
  }

//Get - return the value at the specified location in the list.

  public X get(int index) throws ArrayIndexOutOfBoundsException{
    //if(index >=0 && index < size)

    if(index >=0 && index < size){
      return arr[index];
      }
    //return null;

  else{
    throw new ArrayIndexOutOfBoundsException("error");
  }
    //catch(ArrayIndexOutOfBoundsException e){
    //throw new ArrayIndexOutOfBoundsException("error");
  }
/*
    try{
      arr[index]=null;
    }
    catch(ArrayIndexOutOfBoundsException e){
      System.out.println("an error is occuring in get!");
      //throw new ArithmeticException("an error is occuring in get!");
    }*/

  /*
  public X get(int index) {
    //if(index >=0 && index < size)
    if(index >=0 && index < size)
  {
    return arr[index];
  }
  else{
    System.out.println("an error is occuring in get!");
    //throw new ArithmeticException("an error is occuring in get!");
  }
  return null;
}
  //throw new ArithmeticException("Access denied - You must be at least 18 years old.");
*/
//Clear - empties the list.
  public void clear()
  {
    this.newArray();
  }


//Insert - inserts a new element at given index
  public void insert(int index, X value) throws ArrayIndexOutOfBoundsException
  {
   //check if index works
      if(index < 0 || index > size)
      {
          throw new ArrayIndexOutOfBoundsException("index is out of bounds");
      }
    // If the index points to an empty element, add it.
    if ( index >= size )
      add(value);
    else
    {
      if (size == arr.length) // Is arr full? Then expand by 20%
      {
        this.expandArray();
      }
      // Open a hole to insert the value
      for (int i = size; i > index; i--)
        arr[i] = arr[i - 1];
      arr[index] = value;
      size++;
    }

}

/*Alina,

Do not change versions of jUnit.

If you look at the error message carefully you will see that jUnit says your toString function returned null but the test was expecting an empty string ( "" ).

Now go look at the jUnit test that is displaying an error. What is the test doing?
Create a new list.
Call the toString function with the new list.

Now look at your code for the toString method. What does your toString method do if the list is empty?

What do you want to do if the list is empty? Return "".

Let me know if you have more questions.

Tim*/
//toString - Returns a String value to represent the list
  public String toString()
  {
  if(arr[0] != null){
    String returnValue = String.valueOf(arr[0]);
    for (int i = 1; i < size; i++){
      returnValue = returnValue + ", " + arr[i];
    }
  return returnValue;
  }
  else
    return "";
  }




//Display - Displays the list
   public void display()
  {
    for (int i = 0; i < size; i++)
      System.out.println(i + ": " + arr[i]);
    if ( arr.length == size)
      System.out.println("List is full\n");
    else
      System.out.println("List has " + (arr.length - size) + " spaces left\n");

  }

  /*
  New method to create a new array!
  */
  private void newArray()
  {
    //arr = new String[10];
    arr = (X[]) new Object[12];
    size = 0;
  }

  /*
  New method to expand array!
  */
  private void expandArray()
  {
          X[] arr2;
          arr2 = (X[]) new Object[(int)(arr.length * 1.2)];
          // Copy elements from arr to arr2
          for (int i = 0; i < arr.length; i++)
            arr2[i] = arr[i];
          // Have arr point to new array
          arr = arr2;
          // Old array will be Garbage Collected
  }
/*
These tests expect the GenericList class to throw ArrayIndexOutOfBoundsException on an error. You will need to edit GenericList.java so
that the get, set, insert and remove methods throw exceptions when the index is out of bounds.  Do not display error messages.
 If an error is found, throw an exception.
*/

    /* Code to set an element of your X list at specified index
       to the provided value. */
   public void set(int index, X value) throws ArrayIndexOutOfBoundsException
   {
       if (index >= 0 && index < size) {
           arr[index] = value; // set element of X list at specified index to provided value.
           }
       else {
          throw new ArrayIndexOutOfBoundsException("index is out of bounds");
          //System.out.println("index is out of bounds");
       }
   }

    public void remove(int index) throws ArrayIndexOutOfBoundsException
     {
         //remove element at specified index.
         if (index >= 0 && index < size)
        {

         for (int i = index; i <= size; i++)
         {
             arr[i] = arr[i + 1];
         }
            size--;
        }
         //Display an error if an index is out of bounds
         else {
             throw new ArrayIndexOutOfBoundsException("index is out of bounds");
         }
     }


}
