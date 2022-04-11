package Sorts;

import java.util.*;

public class Sorter {

  private static int groupSize = 2;

  public static void mergeSort(List<? extends Comparable> array)
  {
    Object[] sorted = array.toArray();
    Comparable[][] groups;

    if (array == null | array.isEmpty() | array.size() == 1)
      return;

    int groupNumber = getGroupNumber(array.size())
      ;
    groups = new Comparable[groupNumber][groupSize];

    for (int i = 0, groupIndex = 0, elementIndex = 0; i < array.size(); i++)
    {

      groups[groupIndex][elementIndex] = array.get(i);
      elementIndex++;
      if(elementIndex == groupSize)
      {
        groupIndex++;
        elementIndex = 0;
      }

    }
    groupSize++;
  }

  private static int getGroupNumber(int length)
  {
    int groupCounter = length/groupSize;
    if(length%groupSize > 0)
      groupCounter++;
    return groupCounter;
  }

  private static Comparable[][] sort(Comparable[][] groups)
  {
    if (groups.length == 1)
      return groups;

    int groupsNumber, groupSize;
    groupsNumber = groups.length / 2;
    if (groups.length % 2 > 0)
      groupsNumber++;
    groupSize = groups[0].length * 2;

    Comparable[][] result = new Comparable[groupsNumber][groupSize];

    for (Comparable[] g : result) {
      for (Comparable e : g)
      {

      }
    }

    return result;
  }


}
