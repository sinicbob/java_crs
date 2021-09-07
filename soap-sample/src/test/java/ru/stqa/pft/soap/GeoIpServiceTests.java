package ru.stqa.pft.soap;

import com.lavasoft.GeoIPService;
import org.testng.annotations.Test;

public class GeoIpServiceTests {

  @Test
  public void testMyIP(){
    String loc = new GeoIPService().getGeoIPServiceSoap().getIpLocation("123.40.104.2");
    System.out.println(loc);
  }
}
