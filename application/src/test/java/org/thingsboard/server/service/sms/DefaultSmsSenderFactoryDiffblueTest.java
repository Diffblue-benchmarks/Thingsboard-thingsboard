package org.thingsboard.server.service.sms;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.sms.config.SmsProviderConfiguration;

@ContextConfiguration(classes = {DefaultSmsSenderFactory.class})
@ExtendWith(SpringExtension.class)
class DefaultSmsSenderFactoryDiffblueTest {
  @Autowired
  private DefaultSmsSenderFactory defaultSmsSenderFactory;

  /**
   * Test
   * {@link DefaultSmsSenderFactory#createSmsSender(SmsProviderConfiguration)}.
   * <p>
   * Method under test:
   * {@link DefaultSmsSenderFactory#createSmsSender(SmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test createSmsSender(SmsProviderConfiguration)")
  void testCreateSmsSender() {
    // Arrange
    SmsProviderConfiguration config = mock(SmsProviderConfiguration.class);
    when(config.getType()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultSmsSenderFactory.createSmsSender(config));
    verify(config).getType();
  }
}
