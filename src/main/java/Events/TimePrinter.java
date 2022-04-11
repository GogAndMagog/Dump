package Events;

import java.awt.event.*;
import java.lang.*;
import java.awt.*;
import java.time.Instant;

public class TimePrinter implements ActionListener {

  public void actionPerformed(ActionEvent event) {
    System.out.print("At the tone, the time is"
                   + Instant.ofEpochMilli(event.getWhen())
                   + '\n');
    Toolkit.getDefaultToolkit().beep();
  }
}
