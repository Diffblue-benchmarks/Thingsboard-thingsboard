package org.thingsboard.server.service.script;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {JsExecutorService.class})
@ExtendWith(SpringExtension.class)
class JsExecutorServiceDiffblueTest {
  @Autowired private JsExecutorService jsExecutorService;

  /**
   * Test {@link JsExecutorService#getThreadPollSize()}.
   *
   * <p>Method under test: {@link JsExecutorService#getThreadPollSize()}
   */
  @Test
  @DisplayName("Test getThreadPollSize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int JsExecutorService.getThreadPollSize()"})
  void testGetThreadPollSize() {
    // Arrange, Act and Assert
    assertEquals(50, jsExecutorService.getThreadPollSize());
  }
}
