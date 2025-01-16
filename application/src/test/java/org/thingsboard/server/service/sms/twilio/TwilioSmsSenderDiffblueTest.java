package org.thingsboard.server.service.sms.twilio;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.thingsboard.rule.engine.api.sms.exception.SmsParseException;
import org.thingsboard.server.common.data.sms.config.TwilioSmsProviderConfiguration;

@DisabledInAotMode
class TwilioSmsSenderDiffblueTest {
  @MockBean
  private TwilioSmsProviderConfiguration twilioSmsProviderConfiguration;

  @MockBean
  private TwilioSmsSender twilioSmsSender;

  /**
   * Test {@link TwilioSmsSender#TwilioSmsSender(TwilioSmsProviderConfiguration)}.
   * <ul>
   *   <li>Given {@link TwilioSmsProviderConfiguration}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TwilioSmsSender#TwilioSmsSender(TwilioSmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test new TwilioSmsSender(TwilioSmsProviderConfiguration); given TwilioSmsProviderConfiguration")
  void testNewTwilioSmsSender_givenTwilioSmsProviderConfiguration() {
    // Arrange
    TwilioSmsProviderConfiguration config = new TwilioSmsProviderConfiguration();
    config.setAccountSid("3");
    config.setAccountToken("ABC123");
    config.setNumberFrom("42");

    // Act and Assert
    assertThrows(SmsParseException.class, () -> new TwilioSmsSender(config));
  }
}
