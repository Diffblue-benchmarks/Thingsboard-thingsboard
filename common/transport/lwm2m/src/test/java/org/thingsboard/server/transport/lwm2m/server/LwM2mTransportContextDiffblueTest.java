package org.thingsboard.server.transport.lwm2m.server;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LwM2mTransportContextDiffblueTest {
  /**
   * Test {@link LwM2mTransportContext#getServer()}.
   *
   * <p>Method under test: {@link LwM2mTransportContext#getServer()}
   */
  @Test
  @DisplayName("Test getServer()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.eclipse.leshan.server.LeshanServer LwM2mTransportContext.getServer()",
    "void LwM2mTransportContext.setServer(org.eclipse.leshan.server.LeshanServer)"
  })
  void testGetServer() {
    // Arrange, Act and Assert
    assertNull(new LwM2mTransportContext().getServer());
  }
}
