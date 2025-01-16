package org.thingsboard.server.service.sms.aws;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.sms.exception.SmsException;
import org.thingsboard.rule.engine.api.sms.exception.SmsSendException;
import org.thingsboard.server.common.data.sms.config.AwsSnsSmsProviderConfiguration;

class AwsSmsSenderDiffblueTest {
  /**
   * Test {@link AwsSmsSender#AwsSmsSender(AwsSnsSmsProviderConfiguration)}.
   * <ul>
   *   <li>Given {@code Config}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AwsSmsSender#AwsSmsSender(AwsSnsSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new AwsSmsSender(AwsSnsSmsProviderConfiguration); given 'Config'")
  void testNewAwsSmsSender_givenConfig() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = new AwsSnsSmsProviderConfiguration();
    config.setAccessKeyId("Config");
    config.setRegion(null);
    config.setSecretAccessKey(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new AwsSmsSender(config));
  }

  /**
   * Test {@link AwsSmsSender#AwsSmsSender(AwsSnsSmsProviderConfiguration)}.
   * <ul>
   *   <li>Given empty string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AwsSmsSender#AwsSmsSender(AwsSnsSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new AwsSmsSender(AwsSnsSmsProviderConfiguration); given empty string")
  void testNewAwsSmsSender_givenEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = new AwsSnsSmsProviderConfiguration();
    config.setAccessKeyId("");
    config.setRegion(null);
    config.setSecretAccessKey(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new AwsSmsSender(config));
  }

  /**
   * Test {@link AwsSmsSender#AwsSmsSender(AwsSnsSmsProviderConfiguration)}.
   * <ul>
   *   <li>Given {@link IllegalArgumentException#IllegalArgumentException(String)}
   * with a string.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AwsSmsSender#AwsSmsSender(AwsSnsSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new AwsSmsSender(AwsSnsSmsProviderConfiguration); given IllegalArgumentException(String) with a string")
  void testNewAwsSmsSender_givenIllegalArgumentExceptionWithAString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = mock(AwsSnsSmsProviderConfiguration.class);
    when(config.getRegion()).thenThrow(new IllegalArgumentException(
        "Invalid AWS sms provider configuration: aws accessKeyId, aws secretAccessKey and aws region should be"
            + " specified!"));
    when(config.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(config.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");
    doNothing().when(config).setAccessKeyId(Mockito.<String>any());
    doNothing().when(config).setRegion(Mockito.<String>any());
    doNothing().when(config).setSecretAccessKey(Mockito.<String>any());
    config.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    config.setRegion("us-east-2");
    config.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new AwsSmsSender(config));
    verify(config).getAccessKeyId();
    verify(config).getRegion();
    verify(config).getSecretAccessKey();
    verify(config).setAccessKeyId(eq("EXAMPLEakiAIOSFODNN7"));
    verify(config).setRegion(eq("us-east-2"));
    verify(config).setSecretAccessKey(eq("EXAMPLEakiAIOSFODNN7"));
  }

  /**
   * Test {@link AwsSmsSender#AwsSmsSender(AwsSnsSmsProviderConfiguration)}.
   * <ul>
   *   <li>When {@link AwsSnsSmsProviderConfiguration} (default constructor)
   * AccessKeyId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AwsSmsSender#AwsSmsSender(AwsSnsSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new AwsSmsSender(AwsSnsSmsProviderConfiguration); when AwsSnsSmsProviderConfiguration (default constructor) AccessKeyId is 'null'")
  void testNewAwsSmsSender_whenAwsSnsSmsProviderConfigurationAccessKeyIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = new AwsSnsSmsProviderConfiguration();
    config.setAccessKeyId(null);
    config.setRegion(null);
    config.setSecretAccessKey(null);

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new AwsSmsSender(config));
  }

  /**
   * Test {@link AwsSmsSender#AwsSmsSender(AwsSnsSmsProviderConfiguration)}.
   * <ul>
   *   <li>When {@link AwsSnsSmsProviderConfiguration}
   * {@link AwsSnsSmsProviderConfiguration#getRegion()} return
   * {@code us-east-2}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AwsSmsSender#AwsSmsSender(AwsSnsSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new AwsSmsSender(AwsSnsSmsProviderConfiguration); when AwsSnsSmsProviderConfiguration getRegion() return 'us-east-2'")
  void testNewAwsSmsSender_whenAwsSnsSmsProviderConfigurationGetRegionReturnUsEast2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = mock(AwsSnsSmsProviderConfiguration.class);
    when(config.getRegion()).thenReturn("us-east-2");
    when(config.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(config.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");
    doNothing().when(config).setAccessKeyId(Mockito.<String>any());
    doNothing().when(config).setRegion(Mockito.<String>any());
    doNothing().when(config).setSecretAccessKey(Mockito.<String>any());
    config.setAccessKeyId("EXAMPLEakiAIOSFODNN7");
    config.setRegion("us-east-2");
    config.setSecretAccessKey("EXAMPLEakiAIOSFODNN7");

    // Act
    new AwsSmsSender(config);

    // Assert
    verify(config, atLeast(1)).getAccessKeyId();
    verify(config, atLeast(1)).getRegion();
    verify(config, atLeast(1)).getSecretAccessKey();
    verify(config).setAccessKeyId(eq("EXAMPLEakiAIOSFODNN7"));
    verify(config).setRegion(eq("us-east-2"));
    verify(config).setSecretAccessKey(eq("EXAMPLEakiAIOSFODNN7"));
  }

  /**
   * Test {@link AwsSmsSender#AwsSmsSender(AwsSnsSmsProviderConfiguration)}.
   * <ul>
   *   <li>When {@link AwsSnsSmsProviderConfiguration} (default constructor)
   * SecretAccessKey is {@code Config}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AwsSmsSender#AwsSmsSender(AwsSnsSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new AwsSmsSender(AwsSnsSmsProviderConfiguration); when AwsSnsSmsProviderConfiguration (default constructor) SecretAccessKey is 'Config'")
  void testNewAwsSmsSender_whenAwsSnsSmsProviderConfigurationSecretAccessKeyIsConfig() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = new AwsSnsSmsProviderConfiguration();
    config.setAccessKeyId("Config");
    config.setRegion(null);
    config.setSecretAccessKey("Config");

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> new AwsSmsSender(config));
  }

  /**
   * Test {@link AwsSmsSender#sendSms(String, String)}.
   * <ul>
   *   <li>Given {@link AwsSnsSmsProviderConfiguration}
   * {@link AwsSnsSmsProviderConfiguration#getRegion()} return {@code +9999}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsSmsSender#sendSms(String, String)}
   */
  @Test
  @DisplayName("Test sendSms(String, String); given AwsSnsSmsProviderConfiguration getRegion() return '+9999'")
  void testSendSms_givenAwsSnsSmsProviderConfigurationGetRegionReturn9999() throws SmsException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = mock(AwsSnsSmsProviderConfiguration.class);
    when(config.getRegion()).thenReturn("+9999");
    when(config.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(config.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertThrows(SmsSendException.class,
        () -> (new AwsSmsSender(config)).sendSms("+9999", "Not all who wander are lost"));
    verify(config, atLeast(1)).getAccessKeyId();
    verify(config, atLeast(1)).getRegion();
    verify(config, atLeast(1)).getSecretAccessKey();
  }

  /**
   * Test {@link AwsSmsSender#sendSms(String, String)}.
   * <ul>
   *   <li>Given {@link AwsSnsSmsProviderConfiguration}
   * {@link AwsSnsSmsProviderConfiguration#getRegion()} return {@code +9999}.</li>
   *   <li>When {@code \\n}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsSmsSender#sendSms(String, String)}
   */
  @Test
  @DisplayName("Test sendSms(String, String); given AwsSnsSmsProviderConfiguration getRegion() return '+9999'; when '\\\\n'")
  void testSendSms_givenAwsSnsSmsProviderConfigurationGetRegionReturn9999_whenN() throws SmsException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = mock(AwsSnsSmsProviderConfiguration.class);
    when(config.getRegion()).thenReturn("+9999");
    when(config.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(config.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertThrows(SmsSendException.class, () -> (new AwsSmsSender(config)).sendSms("+9999", "\\\\n"));
    verify(config, atLeast(1)).getAccessKeyId();
    verify(config, atLeast(1)).getRegion();
    verify(config, atLeast(1)).getSecretAccessKey();
  }

  /**
   * Test {@link AwsSmsSender#sendSms(String, String)}.
   * <ul>
   *   <li>Given {@link AwsSnsSmsProviderConfiguration}
   * {@link AwsSnsSmsProviderConfiguration#getRegion()} return
   * {@code us-east-2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsSmsSender#sendSms(String, String)}
   */
  @Test
  @DisplayName("Test sendSms(String, String); given AwsSnsSmsProviderConfiguration getRegion() return 'us-east-2'")
  void testSendSms_givenAwsSnsSmsProviderConfigurationGetRegionReturnUsEast2() throws SmsException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = mock(AwsSnsSmsProviderConfiguration.class);
    when(config.getRegion()).thenReturn("us-east-2");
    when(config.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(config.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertThrows(SmsSendException.class,
        () -> (new AwsSmsSender(config)).sendSms("+9999", "Not all who wander are lost"));
    verify(config, atLeast(1)).getAccessKeyId();
    verify(config, atLeast(1)).getRegion();
    verify(config, atLeast(1)).getSecretAccessKey();
  }

  /**
   * Test {@link AwsSmsSender#sendSms(String, String)}.
   * <ul>
   *   <li>Given {@link AwsSnsSmsProviderConfiguration}
   * {@link AwsSnsSmsProviderConfiguration#getRegion()} return
   * {@code us-east-2}.</li>
   *   <li>When {@code \n}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsSmsSender#sendSms(String, String)}
   */
  @Test
  @DisplayName("Test sendSms(String, String); given AwsSnsSmsProviderConfiguration getRegion() return 'us-east-2'; when '\\n'")
  void testSendSms_givenAwsSnsSmsProviderConfigurationGetRegionReturnUsEast2_whenN() throws SmsException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = mock(AwsSnsSmsProviderConfiguration.class);
    when(config.getRegion()).thenReturn("us-east-2");
    when(config.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(config.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertThrows(SmsSendException.class, () -> (new AwsSmsSender(config)).sendSms("+9999", "\\n"));
    verify(config, atLeast(1)).getAccessKeyId();
    verify(config, atLeast(1)).getRegion();
    verify(config, atLeast(1)).getSecretAccessKey();
  }

  /**
   * Test {@link AwsSmsSender#sendSms(String, String)}.
   * <ul>
   *   <li>When {@code "}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsSmsSender#sendSms(String, String)}
   */
  @Test
  @DisplayName("Test sendSms(String, String); when '\"'")
  void testSendSms_whenQuotationMark() throws SmsException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = mock(AwsSnsSmsProviderConfiguration.class);
    when(config.getRegion()).thenReturn("us-east-2");
    when(config.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(config.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertThrows(SmsSendException.class, () -> (new AwsSmsSender(config)).sendSms("+9999", "\""));
    verify(config, atLeast(1)).getAccessKeyId();
    verify(config, atLeast(1)).getRegion();
    verify(config, atLeast(1)).getSecretAccessKey();
  }

  /**
   * Test {@link AwsSmsSender#destroy()}.
   * <ul>
   *   <li>Then calls {@link AwsSnsSmsProviderConfiguration#getAccessKeyId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AwsSmsSender#destroy()}
   */
  @Test
  @DisplayName("Test destroy(); then calls getAccessKeyId()")
  void testDestroy_thenCallsGetAccessKeyId() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = mock(AwsSnsSmsProviderConfiguration.class);
    when(config.getRegion()).thenReturn("us-east-2");
    when(config.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(config.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");

    // Act
    (new AwsSmsSender(config)).destroy();

    // Assert
    verify(config, atLeast(1)).getAccessKeyId();
    verify(config, atLeast(1)).getRegion();
    verify(config, atLeast(1)).getSecretAccessKey();
  }
}
