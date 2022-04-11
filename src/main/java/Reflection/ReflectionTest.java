package Reflection;

import java.lang.reflect.*;

public final class ReflectionTest {

  public static String getAllAboutClass(String className)
    throws ReflectiveOperationException
  {
    StringBuilder resString = new StringBuilder();

    Class currentClass = Class.forName(className);
    Class superClass = currentClass.getSuperclass();

    resString.append(ReflectionTest.getClassName(currentClass)
      + '\n'
      + ReflectionTest.getAllConstructors(currentClass)
      + '\n'
      + ReflectionTest.getAllMethods(currentClass)
      + '\n'
      + ReflectionTest.getAllFields(currentClass)
      + '\n');

    return resString.toString();

  }

  private static String getClassName(Class currentClass)
  {
    Class superClass = currentClass.getSuperclass();

    StringBuilder resString = new StringBuilder();
    resString.append(Modifier.toString(currentClass.getModifiers())
      + " class "
      + currentClass.getName()
    );

    if (superClass != null)
      resString.append(" extends " + superClass);
    resString.append('\n');

    return resString.toString();

  }

  private static String getAllConstructors(Class currentClass)
  {
    StringBuilder resString = new StringBuilder();
    Constructor[] constructors = currentClass.getDeclaredConstructors();

    resString.append("Constructors:\n");
    for (Constructor c : constructors)
    {
      resString.append(Modifier.toString(c.getModifiers())
        + " "
        + c.getName()
        + "(");
      Class[] paramTypes = c.getParameterTypes();
      for (int i = 0; i < paramTypes.length; i++)
      {
        if (i > 1)
          resString.append(", ");
        resString.append(paramTypes[i].getName());
      }
      resString.append(");\n");
    }

    return resString.toString();

  }

  private static String getAllMethods(Class currentClass)
  {
    StringBuilder resString = new StringBuilder();
    Method[] methods = currentClass.getDeclaredMethods();

    resString.append("Methods:\n");
    for (Method m : methods)
    {
      resString.append(Modifier.toString(m.getModifiers())
        + " "
        + m.getName()
        + "(");
      Class[] paramTypes = m.getParameterTypes();
      for (int i = 0; i < paramTypes.length; i++)
      {
        if (i > 1)
          resString.append(", ");
        resString.append(paramTypes[i].getName());
      }
      resString.append(");\n");
    }

    return resString.toString();
  }

  private static String getAllFields(Class currentClass)
  {
    StringBuilder resString = new StringBuilder();
    Field[] fields = currentClass.getDeclaredFields();

    resString.append("Fields:\n");
    for (Field f : fields)
    {
      resString.append(Modifier.toString(f.getModifiers())
        + ' '
        + f.getType().getTypeName()
        + ' '
        + f.getName()
        );
      resString.append(";\n");
    }

    return resString.toString();
  }

}
