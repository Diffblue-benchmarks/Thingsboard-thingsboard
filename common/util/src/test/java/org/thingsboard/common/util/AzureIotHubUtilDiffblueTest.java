package org.thingsboard.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AzureIotHubUtilDiffblueTest {
  /**
   * Test {@link AzureIotHubUtil#buildUsername(String, String)}.
   *
   * <p>Method under test: {@link AzureIotHubUtil#buildUsername(String, String)}
   */
  @Test
  @DisplayName("Test buildUsername(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AzureIotHubUtil.buildUsername(String, String)"})
  void testBuildUsername() {
    // Arrange, Act and Assert
    assertEquals(
        "localhost/42/?api-version=2018-06-30", AzureIotHubUtil.buildUsername("localhost", "42"));
  }

  /**
   * Test {@link AzureIotHubUtil#buildSasToken(String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AzureIotHubUtil#buildSasToken(String, String)}
   */
  @Test
  @DisplayName("Test buildSasToken(String, String); when empty string; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AzureIotHubUtil.buildSasToken(String, String)"})
  void testBuildSasToken_whenEmptyString_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> AzureIotHubUtil.buildSasToken("localhost", ""));
  }

  /**
   * Test {@link AzureIotHubUtil#buildSasToken(String, String)}.
   *
   * <ul>
   *   <li>When {@code Sas Key}.
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link AzureIotHubUtil#buildSasToken(String, String)}
   */
  @Test
  @DisplayName("Test buildSasToken(String, String); when 'Sas Key'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AzureIotHubUtil.buildSasToken(String, String)"})
  void testBuildSasToken_whenSasKey_thenThrowRuntimeException() {
    // Arrange, Act and Assert
    assertThrows(
        RuntimeException.class, () -> AzureIotHubUtil.buildSasToken("localhost", "Sas Key"));
  }

  /**
   * Test {@link AzureIotHubUtil#getDefaultCaCert()}.
   *
   * <p>Method under test: {@link AzureIotHubUtil#getDefaultCaCert()}
   */
  @Test
  @DisplayName("Test getDefaultCaCert()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AzureIotHubUtil.getDefaultCaCert()"})
  void testGetDefaultCaCert() {
    // Arrange, Act and Assert
    assertEquals(
        "-----BEGIN CERTIFICATE-----\r\n"
            + "MIIDjjCCAnagAwIBAgIQAzrx5qcRqaC7KGSxHQn65TANBgkqhkiG9w0BAQsFADBh\r\n"
            + "MQswCQYDVQQGEwJVUzEVMBMGA1UEChMMRGlnaUNlcnQgSW5jMRkwFwYDVQQLExB3\r\n"
            + "d3cuZGlnaWNlcnQuY29tMSAwHgYDVQQDExdEaWdpQ2VydCBHbG9iYWwgUm9vdCBH\r\n"
            + "MjAeFw0xMzA4MDExMjAwMDBaFw0zODAxMTUxMjAwMDBaMGExCzAJBgNVBAYTAlVT\r\n"
            + "MRUwEwYDVQQKEwxEaWdpQ2VydCBJbmMxGTAXBgNVBAsTEHd3dy5kaWdpY2VydC5j\r\n"
            + "b20xIDAeBgNVBAMTF0RpZ2lDZXJ0IEdsb2JhbCBSb290IEcyMIIBIjANBgkqhkiG\r\n"
            + "9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuzfNNNx7a8myaJCtSnX/RrohCgiN9RlUyfuI\r\n"
            + "2/Ou8jqJkTx65qsGGmvPrC3oXgkkRLpimn7Wo6h+4FR1IAWsULecYxpsMNzaHxmx\r\n"
            + "1x7e/dfgy5SDN67sH0NO3Xss0r0upS/kqbitOtSZpLYl6ZtrAGCSYP9PIUkY92eQ\r\n"
            + "q2EGnI/yuum06ZIya7XzV+hdG82MHauVBJVJ8zUtluNJbd134/tJS7SsVQepj5Wz\r\n"
            + "tCO7TG1F8PapspUwtP1MVYwnSlcUfIKdzXOS0xZKBgyMUNGPHgm+F6HmIcr9g+UQ\r\n"
            + "vIOlCsRnKPZzFBQ9RnbDhxSJITRNrw9FDKZJobq7nMWxM4MphQIDAQABo0IwQDAP\r\n"
            + "BgNVHRMBAf8EBTADAQH/MA4GA1UdDwEB/wQEAwIBhjAdBgNVHQ4EFgQUTiJUIBiV\r\n"
            + "5uNu5g/6+rkS7QYXjzkwDQYJKoZIhvcNAQELBQADggEBAGBnKJRvDkhj6zHd6mcY\r\n"
            + "1Yl9PMWLSn/pvtsrF9+wX3N3KjITOYFnQoQj8kVnNeyIv/iPsGEMNKSuIEyExtv4\r\n"
            + "NeF22d+mQrvHRAiGfzZ0JFrabA0UWTW98kndth/Jsw1HKj2ZL7tcu7XUIOGZX1NG\r\n"
            + "Fdtom/DzMNU+MeKNhJ7jitralj41E6Vf8PlwUHBHQRFXGU7Aj64GxJUTFy8bJZ91\r\n"
            + "8rGOmaFvE7FBcf6IKshPECBV1/MUReXgRPTqh5Uykw7+U0b6LJ3/iyK5S9kJRaTe\r\n"
            + "pLiaWN0bfVKfjllDiIGknibVb63dDcY3fe0Dkhvld1927jyNxF1WW6LZZm6zNTfl\r\n"
            + "MrY=\r\n"
            + "-----END CERTIFICATE-----\r\n",
        AzureIotHubUtil.getDefaultCaCert());
  }
}
