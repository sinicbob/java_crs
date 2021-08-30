package ru.stqa.pft.mantis.tests;

import org.testng.annotations.Test;

public class RegistrationTests extends TestBase {

  @Test
  public void testReristration(){
    app.registration().start("user","user@test.ru");
  }
}
