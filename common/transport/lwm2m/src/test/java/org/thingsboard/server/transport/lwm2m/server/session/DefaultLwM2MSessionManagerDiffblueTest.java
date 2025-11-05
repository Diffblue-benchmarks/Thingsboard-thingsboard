package org.thingsboard.server.transport.lwm2m.server.session;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.transport.SessionMsgListener;
import org.thingsboard.server.common.transport.TransportService;
import org.thingsboard.server.common.transport.TransportServiceCallback;
import org.thingsboard.server.gen.transport.TransportProtos;
import org.thingsboard.server.gen.transport.TransportProtos.SessionEventMsg;
import org.thingsboard.server.gen.transport.TransportProtos.SessionInfoProto;
import org.thingsboard.server.gen.transport.TransportProtos.TransportToDeviceActorMsg;

@ExtendWith(MockitoExtension.class)
class DefaultLwM2MSessionManagerDiffblueTest {
  @InjectMocks private DefaultLwM2MSessionManager defaultLwM2MSessionManager;

  @Mock private TransportService transportService;

  /**
   * Test {@link DefaultLwM2MSessionManager#register(SessionInfoProto)}.
   *
   * <ul>
   *   <li>When DefaultInstance.
   *   <li>Then calls {@link TransportService#process(TransportToDeviceActorMsg,
   *       TransportServiceCallback)}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DefaultLwM2MSessionManager#register(TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName(
      "Test register(SessionInfoProto); when DefaultInstance; then calls process(TransportToDeviceActorMsg, TransportServiceCallback)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DefaultLwM2MSessionManager.register(TransportProtos.SessionInfoProto)"})
  void testRegister_whenDefaultInstance_thenCallsProcess() {
    // Arrange
    when(transportService.registerAsyncSession(
            Mockito.<SessionInfoProto>any(), Mockito.<SessionMsgListener>any()))
        .thenReturn(null);
    doNothing()
        .when(transportService)
        .process(
            Mockito.<TransportToDeviceActorMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    // Act
    defaultLwM2MSessionManager.register(SessionInfoProto.getDefaultInstance());

    // Assert
    verify(transportService)
        .process(isA(TransportToDeviceActorMsg.class), (TransportServiceCallback<Void>) isNull());
    verify(transportService)
        .registerAsyncSession(isA(SessionInfoProto.class), isA(SessionMsgListener.class));
  }

  /**
   * Test {@link DefaultLwM2MSessionManager#deregister(SessionInfoProto)}.
   *
   * <p>Method under test: {@link
   * DefaultLwM2MSessionManager#deregister(TransportProtos.SessionInfoProto)}
   */
  @Test
  @DisplayName("Test deregister(SessionInfoProto)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DefaultLwM2MSessionManager.deregister(TransportProtos.SessionInfoProto)"
  })
  void testDeregister() {
    // Arrange
    doNothing().when(transportService).deregisterSession(Mockito.<SessionInfoProto>any());
    doNothing()
        .when(transportService)
        .process(
            Mockito.<SessionInfoProto>any(),
            Mockito.<SessionEventMsg>any(),
            Mockito.<TransportServiceCallback<Void>>any());

    // Act
    defaultLwM2MSessionManager.deregister(SessionInfoProto.getDefaultInstance());

    // Assert
    verify(transportService).deregisterSession(isA(SessionInfoProto.class));
    verify(transportService)
        .process(
            isA(SessionInfoProto.class),
            isA(SessionEventMsg.class),
            (TransportServiceCallback<Void>) isNull());
  }
}
