package TmpTests;

import java.util.concurrent.TimeUnit;

public class Body
{
  private Sex sex;

  Body()
  {
    sex = Sex.MALE;
  }

  Body(Sex sex)
  {
    this.sex = sex;
  }

  public void setSex(Sex sex)
  {
    this.sex = sex;
  }

  public Sex getSex()
  {
    return sex;
  }

  public void changeGender(Sex sex)
  {
    try {
      System.out.printf("My gender is %s\n", this.sex);
      for (long i = 0; i < 1_000_000_000; i++)
        for (long j = 0; j < 20; j++)
            new Body();
//      TimeUnit.SECONDS.sleep(10);
      System.out.printf("I will change my gender from %s to %s\n", this.sex, sex);
      this.sex = sex;
    }catch (Exception e)
    {
      System.out.println(e.getMessage());
    }

  }
}