package org.thingsboard.server.common.transport.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.transport.SessionMsgListener;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
import org.thingsboard.server.gen.transport.TransportProtos.SessionType;

class SessionMetaDataDiffblueTest {
  /**
   * Test {@link SessionMetaData#hasScheduledFuture()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link SessionMetaData#hasScheduledFuture()}
   */
  @Test
  @DisplayName("Test hasScheduledFuture(); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SessionMetaData.hasScheduledFuture()"})
  void testHasScheduledFuture_thenReturnFalse() {
    // Arrange
    SessionMetaData sessionMetaData =
        new SessionMetaData(
            SessionInfoProto.getDefaultInstance(),
            SessionType.SYNC,
            mock(SessionMsgListener.class));
    sessionMetaData.setScheduledFuture(null);

    // Act and Assert
    assertFalse(sessionMetaData.hasScheduledFuture());
  }
}
