package org.thingsboard.server.queue.environment;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EnvironmentLogService.class})
@ExtendWith(SpringExtension.class)
class EnvironmentLogServiceDiffblueTest {
  @Autowired
  private EnvironmentLogService environmentLogService;

  /**
   * Test {@link EnvironmentLogService#init()}.
   * <p>
   * Method under test: {@link EnvironmentLogService#init()}
   */
  @Test
  @DisplayName("Test init()")
  void testInit() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange and Act
    environmentLogService.init();
  }
}
