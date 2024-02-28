package PageCounter;

public final class PageCounter {

  public static int countPagess(int sumOfPages)
  {
    int pages = 0
      , currentSumOfPages = 0
      ;

    if (sumOfPages < 1)
      return -1;

    while (currentSumOfPages < sumOfPages)
    {
      pages++;
      currentSumOfPages += pages;
    }

    return pages;
  }

  public static int countPages(int sumOfPagesDigits)
  {
    int pages = 0
      , numberOfDigits = 1
      , base = 10
      , currentSumOfDigits = 0
      ;

    final int error = -1;

    while(currentSumOfDigits < sumOfPagesDigits)
    {
      pages++;
      if(pages % base == 0) {
        base *= 10;
        numberOfDigits++;
      }
      currentSumOfDigits += numberOfDigits;
    }

    if (currentSumOfDigits != sumOfPagesDigits)
      return error;

    return pages;
  }

}
