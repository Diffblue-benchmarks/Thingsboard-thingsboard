package org.thingsboard.server.service.ws.notification.cmd;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.service.ws.WsCommandsWrapper;

@ContextConfiguration(classes = {NotificationCmdsWrapper.class})
@ExtendWith(SpringExtension.class)
class NotificationCmdsWrapperDiffblueTest {
  @Autowired
  private NotificationCmdsWrapper notificationCmdsWrapper;

  /**
   * Test {@link NotificationCmdsWrapper#toCommonCmdsWrapper()}.
   * <p>
   * Method under test: {@link NotificationCmdsWrapper#toCommonCmdsWrapper()}
   */
  @Test
  @DisplayName("Test toCommonCmdsWrapper()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WsCommandsWrapper NotificationCmdsWrapper.toCommonCmdsWrapper()"})
  void testToCommonCmdsWrapper() {
    // Arrange and Act
    WsCommandsWrapper actualToCommonCmdsWrapperResult = notificationCmdsWrapper.toCommonCmdsWrapper();

    // Assert
    assertNull(actualToCommonCmdsWrapperResult.getAuthCmd());
    assertTrue(actualToCommonCmdsWrapperResult.getCmds().isEmpty());
  }
}
