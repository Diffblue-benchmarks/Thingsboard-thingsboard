package org.thingsboard.server.service.executors;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SharedEventLoopGroupServiceDiffblueTest {
  /**
   * Test {@link SharedEventLoopGroupService#getSharedEventLoopGroup()}.
   *
   * <p>Method under test: {@link SharedEventLoopGroupService#getSharedEventLoopGroup()}
   */
  @Test
  @DisplayName("Test getSharedEventLoopGroup()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "io.netty.channel.EventLoopGroup SharedEventLoopGroupService.getSharedEventLoopGroup()"
  })
  void testGetSharedEventLoopGroup() {
    // Arrange, Act and Assert
    assertNull(new SharedEventLoopGroupService().getSharedEventLoopGroup());
  }
}
