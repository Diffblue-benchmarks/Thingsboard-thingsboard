package org.thingsboard.server.service.sms;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.rule.engine.api.sms.exception.SmsParseException;
import org.thingsboard.server.common.data.sms.config.AwsSnsSmsProviderConfiguration;
import org.thingsboard.server.service.sms.aws.AwsSmsSender;

@ContextConfiguration
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class AbstractSmsSenderDiffblueTest {
  @Autowired
  private AbstractSmsSender abstractSmsSender;

  @MockBean
  private AwsSmsSender awsSmsSender;

  @MockBean
  private AwsSnsSmsProviderConfiguration awsSnsSmsProviderConfiguration;

  /**
   * Test {@link AbstractSmsSender#validatePhoneNumber(String)}.
   * <ul>
   *   <li>Then throw {@link SmsParseException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSmsSender#validatePhoneNumber(String)}
   */
  @Test
  @DisplayName("Test validatePhoneNumber(String); then throw SmsParseException")
  void testValidatePhoneNumber_thenThrowSmsParseException() throws SmsParseException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = mock(AwsSnsSmsProviderConfiguration.class);
    when(config.getRegion()).thenReturn("us-east-2");
    when(config.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(config.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");

    // Act and Assert
    assertThrows(SmsParseException.class, () -> (new AwsSmsSender(config)).validatePhoneNumber("6625550144"));
    verify(config, atLeast(1)).getAccessKeyId();
    verify(config, atLeast(1)).getRegion();
    verify(config, atLeast(1)).getSecretAccessKey();
  }

  /**
   * Test {@link AbstractSmsSender#validatePhoneNumber(String)}.
   * <ul>
   *   <li>When {@code +9999}.</li>
   *   <li>Then return {@code +9999}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSmsSender#validatePhoneNumber(String)}
   */
  @Test
  @DisplayName("Test validatePhoneNumber(String); when '+9999'; then return '+9999'")
  void testValidatePhoneNumber_when9999_thenReturn9999() throws SmsParseException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = mock(AwsSnsSmsProviderConfiguration.class);
    when(config.getRegion()).thenReturn("us-east-2");
    when(config.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(config.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");

    // Act
    String actualValidatePhoneNumberResult = (new AwsSmsSender(config)).validatePhoneNumber("+9999");

    // Assert
    verify(config, atLeast(1)).getAccessKeyId();
    verify(config, atLeast(1)).getRegion();
    verify(config, atLeast(1)).getSecretAccessKey();
    assertEquals("+9999", actualValidatePhoneNumberResult);
  }

  /**
   * Test {@link AbstractSmsSender#prepareMessage(String)}.
   * <ul>
   *   <li>When {@code \\n}.</li>
   *   <li>Then return {@code \}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSmsSender#prepareMessage(String)}
   */
  @Test
  @DisplayName("Test prepareMessage(String); when '\\\\n'; then return '\\'")
  void testPrepareMessage_whenN_thenReturnBackslash() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = mock(AwsSnsSmsProviderConfiguration.class);
    when(config.getRegion()).thenReturn("us-east-2");
    when(config.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(config.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");

    // Act
    String actualPrepareMessageResult = (new AwsSmsSender(config)).prepareMessage("\\\\n");

    // Assert
    verify(config, atLeast(1)).getAccessKeyId();
    verify(config, atLeast(1)).getRegion();
    verify(config, atLeast(1)).getSecretAccessKey();
    assertEquals("\\\n", actualPrepareMessageResult);
  }

  /**
   * Test {@link AbstractSmsSender#prepareMessage(String)}.
   * <ul>
   *   <li>When {@code \n}.</li>
   *   <li>Then return lf.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSmsSender#prepareMessage(String)}
   */
  @Test
  @DisplayName("Test prepareMessage(String); when '\\n'; then return lf")
  void testPrepareMessage_whenN_thenReturnLf() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = mock(AwsSnsSmsProviderConfiguration.class);
    when(config.getRegion()).thenReturn("us-east-2");
    when(config.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(config.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");

    // Act
    String actualPrepareMessageResult = (new AwsSmsSender(config)).prepareMessage("\\n");

    // Assert
    verify(config, atLeast(1)).getAccessKeyId();
    verify(config, atLeast(1)).getRegion();
    verify(config, atLeast(1)).getSecretAccessKey();
    assertEquals("\n", actualPrepareMessageResult);
  }

  /**
   * Test {@link AbstractSmsSender#prepareMessage(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost\n}.</li>
   *   <li>Then return {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSmsSender#prepareMessage(String)}
   */
  @Test
  @DisplayName("Test prepareMessage(String); when 'Not all who wander are lost\\n'; then return 'Not all who wander are lost'")
  void testPrepareMessage_whenNotAllWhoWanderAreLostN_thenReturnNotAllWhoWanderAreLost() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = mock(AwsSnsSmsProviderConfiguration.class);
    when(config.getRegion()).thenReturn("us-east-2");
    when(config.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(config.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");

    // Act
    String actualPrepareMessageResult = (new AwsSmsSender(config)).prepareMessage("Not all who wander are lost\\n");

    // Assert
    verify(config, atLeast(1)).getAccessKeyId();
    verify(config, atLeast(1)).getRegion();
    verify(config, atLeast(1)).getSecretAccessKey();
    assertEquals("Not all who wander are lost\n", actualPrepareMessageResult);
  }

  /**
   * Test {@link AbstractSmsSender#prepareMessage(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost\\n}.</li>
   *   <li>Then return {@code Not all who wander are lost\}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSmsSender#prepareMessage(String)}
   */
  @Test
  @DisplayName("Test prepareMessage(String); when 'Not all who wander are lost\\\\n'; then return 'Not all who wander are lost\\'")
  void testPrepareMessage_whenNotAllWhoWanderAreLostN_thenReturnNotAllWhoWanderAreLost2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = mock(AwsSnsSmsProviderConfiguration.class);
    when(config.getRegion()).thenReturn("us-east-2");
    when(config.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(config.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");

    // Act
    String actualPrepareMessageResult = (new AwsSmsSender(config)).prepareMessage("Not all who wander are lost\\\\n");

    // Assert
    verify(config, atLeast(1)).getAccessKeyId();
    verify(config, atLeast(1)).getRegion();
    verify(config, atLeast(1)).getSecretAccessKey();
    assertEquals("Not all who wander are lost\\\n", actualPrepareMessageResult);
  }

  /**
   * Test {@link AbstractSmsSender#prepareMessage(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost}.</li>
   *   <li>Then return {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSmsSender#prepareMessage(String)}
   */
  @Test
  @DisplayName("Test prepareMessage(String); when 'Not all who wander are lost'; then return 'Not all who wander are lost'")
  void testPrepareMessage_whenNotAllWhoWanderAreLost_thenReturnNotAllWhoWanderAreLost() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = mock(AwsSnsSmsProviderConfiguration.class);
    when(config.getRegion()).thenReturn("us-east-2");
    when(config.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(config.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");

    // Act
    String actualPrepareMessageResult = (new AwsSmsSender(config)).prepareMessage("Not all who wander are lost");

    // Assert
    verify(config, atLeast(1)).getAccessKeyId();
    verify(config, atLeast(1)).getRegion();
    verify(config, atLeast(1)).getSecretAccessKey();
    assertEquals("Not all who wander are lost", actualPrepareMessageResult);
  }

  /**
   * Test {@link AbstractSmsSender#prepareMessage(String)}.
   * <ul>
   *   <li>When {@code Not all who wander are lost"}.</li>
   *   <li>Then return {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSmsSender#prepareMessage(String)}
   */
  @Test
  @DisplayName("Test prepareMessage(String); when 'Not all who wander are lost\"'; then return 'Not all who wander are lost'")
  void testPrepareMessage_whenNotAllWhoWanderAreLost_thenReturnNotAllWhoWanderAreLost2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = mock(AwsSnsSmsProviderConfiguration.class);
    when(config.getRegion()).thenReturn("us-east-2");
    when(config.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(config.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");

    // Act
    String actualPrepareMessageResult = (new AwsSmsSender(config)).prepareMessage("Not all who wander are lost\"");

    // Assert
    verify(config, atLeast(1)).getAccessKeyId();
    verify(config, atLeast(1)).getRegion();
    verify(config, atLeast(1)).getSecretAccessKey();
    assertEquals("Not all who wander are lost", actualPrepareMessageResult);
  }

  /**
   * Test {@link AbstractSmsSender#prepareMessage(String)}.
   * <ul>
   *   <li>When {@code "Not all who wander are lost}.</li>
   *   <li>Then return {@code Not all who wander are lost}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSmsSender#prepareMessage(String)}
   */
  @Test
  @DisplayName("Test prepareMessage(String); when '\"Not all who wander are lost'; then return 'Not all who wander are lost'")
  void testPrepareMessage_whenNotAllWhoWanderAreLost_thenReturnNotAllWhoWanderAreLost3() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = mock(AwsSnsSmsProviderConfiguration.class);
    when(config.getRegion()).thenReturn("us-east-2");
    when(config.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(config.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");

    // Act
    String actualPrepareMessageResult = (new AwsSmsSender(config)).prepareMessage("\"Not all who wander are lost");

    // Assert
    verify(config, atLeast(1)).getAccessKeyId();
    verify(config, atLeast(1)).getRegion();
    verify(config, atLeast(1)).getSecretAccessKey();
    assertEquals("Not all who wander are lost", actualPrepareMessageResult);
  }

  /**
   * Test {@link AbstractSmsSender#prepareMessage(String)}.
   * <ul>
   *   <li>When {@code ""}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSmsSender#prepareMessage(String)}
   */
  @Test
  @DisplayName("Test prepareMessage(String); when '\"\"'; then return empty string")
  void testPrepareMessage_whenQuotationMarkQuotationMark_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = mock(AwsSnsSmsProviderConfiguration.class);
    when(config.getRegion()).thenReturn("us-east-2");
    when(config.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(config.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");

    // Act
    String actualPrepareMessageResult = (new AwsSmsSender(config)).prepareMessage("\"\"");

    // Assert
    verify(config, atLeast(1)).getAccessKeyId();
    verify(config, atLeast(1)).getRegion();
    verify(config, atLeast(1)).getSecretAccessKey();
    assertEquals("", actualPrepareMessageResult);
  }

  /**
   * Test {@link AbstractSmsSender#prepareMessage(String)}.
   * <ul>
   *   <li>When {@code "}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link AbstractSmsSender#prepareMessage(String)}
   */
  @Test
  @DisplayName("Test prepareMessage(String); when '\"'; then return empty string")
  void testPrepareMessage_whenQuotationMark_thenReturnEmptyString() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AwsSnsSmsProviderConfiguration config = mock(AwsSnsSmsProviderConfiguration.class);
    when(config.getRegion()).thenReturn("us-east-2");
    when(config.getSecretAccessKey()).thenReturn("EXAMPLEakiAIOSFODNN7");
    when(config.getAccessKeyId()).thenReturn("EXAMPLEakiAIOSFODNN7");

    // Act
    String actualPrepareMessageResult = (new AwsSmsSender(config)).prepareMessage("\"");

    // Assert
    verify(config, atLeast(1)).getAccessKeyId();
    verify(config, atLeast(1)).getRegion();
    verify(config, atLeast(1)).getSecretAccessKey();
    assertEquals("", actualPrepareMessageResult);
  }

  /**
   * Test {@link AbstractSmsSender#countMessageSegments(String)}.
   * <p>
   * Method under test: {@link AbstractSmsSender#countMessageSegments(String)}
   */
  @Test
  @DisplayName("Test countMessageSegments(String)")
  void testCountMessageSegments() {
    // Arrange
    when(awsSmsSender.countMessageSegments(Mockito.<String>any())).thenReturn(3);

    // Act
    int actualCountMessageSegmentsResult = abstractSmsSender.countMessageSegments("Not all who wander are lost");

    // Assert
    verify(awsSmsSender).countMessageSegments(eq("Not all who wander are lost"));
    assertEquals(3, actualCountMessageSegmentsResult);
  }
}
