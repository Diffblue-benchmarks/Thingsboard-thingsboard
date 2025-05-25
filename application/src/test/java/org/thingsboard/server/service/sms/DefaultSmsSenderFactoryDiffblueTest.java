package org.thingsboard.server.service.sms;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
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
   * Test {@link DefaultSmsSenderFactory#createSmsSender(SmsProviderConfiguration)}.
   * <ul>
   *   <li>Given {@link RuntimeException#RuntimeException(String)} with {@code foo}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSmsSenderFactory#createSmsSender(SmsProviderConfiguration)}
   */
  @Test
  @DisplayName("Test createSmsSender(SmsProviderConfiguration); given RuntimeException(String) with 'foo'; then throw RuntimeException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "org.thingsboard.rule.engine.api.sms.SmsSender DefaultSmsSenderFactory.createSmsSender(SmsProviderConfiguration)"})
  void testCreateSmsSender_givenRuntimeExceptionWithFoo_thenThrowRuntimeException() {
    // Arrange
    SmsProviderConfiguration config = mock(SmsProviderConfiguration.class);
    when(config.getType()).thenThrow(new RuntimeException("foo"));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> defaultSmsSenderFactory.createSmsSender(config));
    verify(config).getType();
  }
}
