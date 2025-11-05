package org.thingsboard.edge.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.ManagedChannel;
import io.grpc.stub.StreamObserver;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.gen.edge.v1.DownlinkResponseMsg;
import org.thingsboard.server.gen.edge.v1.RequestMsg;
import org.thingsboard.server.gen.edge.v1.UplinkMsg;

@ExtendWith(MockitoExtension.class)
class EdgeGrpcClientDiffblueTest {
  @InjectMocks private EdgeGrpcClient edgeGrpcClient;

  @Mock private ManagedChannel managedChannel;

  @Mock private StreamObserver<RequestMsg> streamObserver;

  /**
   * Test {@link EdgeGrpcClient#disconnect(boolean)}.
   *
   * <ul>
   *   <li>Given {@link ManagedChannel} {@link ManagedChannel#isTerminated()} return {@code false}.
   *   <li>Then calls {@link ManagedChannel#shutdownNow()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcClient#disconnect(boolean)}
   */
  @Test
  @DisplayName(
      "Test disconnect(boolean); given ManagedChannel isTerminated() return 'false'; then calls shutdownNow()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeGrpcClient.disconnect(boolean)"})
  void testDisconnect_givenManagedChannelIsTerminatedReturnFalse_thenCallsShutdownNow()
      throws InterruptedException {
    // Arrange
    when(managedChannel.awaitTermination(anyLong(), Mockito.<TimeUnit>any())).thenReturn(true);
    when(managedChannel.isTerminated()).thenReturn(false);
    when(managedChannel.shutdown()).thenReturn(null);
    when(managedChannel.shutdownNow()).thenReturn(null);

    // Act
    edgeGrpcClient.disconnect(true);

    // Assert
    verify(managedChannel, atLeast(1)).awaitTermination(0L, TimeUnit.SECONDS);
    verify(managedChannel, atLeast(1)).isTerminated();
    verify(managedChannel).shutdown();
    verify(managedChannel).shutdownNow();
  }

  /**
   * Test {@link EdgeGrpcClient#disconnect(boolean)}.
   *
   * <ul>
   *   <li>Given {@link ManagedChannel} {@link ManagedChannel#isTerminated()} return {@code true}.
   *   <li>When {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcClient#disconnect(boolean)}
   */
  @Test
  @DisplayName(
      "Test disconnect(boolean); given ManagedChannel isTerminated() return 'true'; when 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeGrpcClient.disconnect(boolean)"})
  void testDisconnect_givenManagedChannelIsTerminatedReturnTrue_whenTrue()
      throws InterruptedException {
    // Arrange
    when(managedChannel.awaitTermination(anyLong(), Mockito.<TimeUnit>any())).thenReturn(true);
    when(managedChannel.isTerminated()).thenReturn(true);
    when(managedChannel.shutdown()).thenReturn(null);

    // Act
    edgeGrpcClient.disconnect(true);

    // Assert
    verify(managedChannel).awaitTermination(0L, TimeUnit.SECONDS);
    verify(managedChannel).isTerminated();
    verify(managedChannel).shutdown();
  }

  /**
   * Test {@link EdgeGrpcClient#disconnect(boolean)}.
   *
   * <ul>
   *   <li>Given {@link StreamObserver} {@link StreamObserver#onCompleted()} does nothing.
   *   <li>Then calls {@link StreamObserver#onCompleted()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcClient#disconnect(boolean)}
   */
  @Test
  @DisplayName(
      "Test disconnect(boolean); given StreamObserver onCompleted() does nothing; then calls onCompleted()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeGrpcClient.disconnect(boolean)"})
  void testDisconnect_givenStreamObserverOnCompletedDoesNothing_thenCallsOnCompleted()
      throws InterruptedException {
    // Arrange
    when(managedChannel.awaitTermination(anyLong(), Mockito.<TimeUnit>any())).thenReturn(true);
    when(managedChannel.isTerminated()).thenReturn(true);
    when(managedChannel.shutdown()).thenReturn(null);
    doNothing().when(streamObserver).onCompleted();

    // Act
    edgeGrpcClient.disconnect(false);

    // Assert
    verify(managedChannel).awaitTermination(0L, TimeUnit.SECONDS);
    verify(managedChannel).isTerminated();
    verify(managedChannel).shutdown();
    verify(streamObserver).onCompleted();
  }

  /**
   * Test {@link EdgeGrpcClient#disconnect(boolean)}.
   *
   * <ul>
   *   <li>Given {@link StreamObserver} {@link StreamObserver#onCompleted()} throw {@link
   *       RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcClient#disconnect(boolean)}
   */
  @Test
  @DisplayName(
      "Test disconnect(boolean); given StreamObserver onCompleted() throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeGrpcClient.disconnect(boolean)"})
  void testDisconnect_givenStreamObserverOnCompletedThrowRuntimeException()
      throws InterruptedException {
    // Arrange
    when(managedChannel.awaitTermination(anyLong(), Mockito.<TimeUnit>any())).thenReturn(true);
    when(managedChannel.isTerminated()).thenReturn(true);
    when(managedChannel.shutdown()).thenReturn(null);
    doThrow(new RuntimeException()).when(streamObserver).onCompleted();

    // Act
    edgeGrpcClient.disconnect(false);

    // Assert
    verify(managedChannel).awaitTermination(0L, TimeUnit.SECONDS);
    verify(managedChannel).isTerminated();
    verify(managedChannel).shutdown();
    verify(streamObserver).onCompleted();
  }

  /**
   * Test {@link EdgeGrpcClient#disconnect(boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcClient#disconnect(boolean)}
   */
  @Test
  @DisplayName("Test disconnect(boolean); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeGrpcClient.disconnect(boolean)"})
  void testDisconnect_thenThrowRuntimeException() throws InterruptedException {
    // Arrange
    when(managedChannel.shutdown()).thenThrow(new RuntimeException());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> edgeGrpcClient.disconnect(true));
    verify(managedChannel).shutdown();
  }

  /**
   * Test {@link EdgeGrpcClient#sendUplinkMsg(UplinkMsg)}.
   *
   * <ul>
   *   <li>Given {@link StreamObserver} {@link StreamObserver#onNext(Object)} does nothing.
   *   <li>Then calls {@link StreamObserver#onNext(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcClient#sendUplinkMsg(UplinkMsg)}
   */
  @Test
  @DisplayName(
      "Test sendUplinkMsg(UplinkMsg); given StreamObserver onNext(Object) does nothing; then calls onNext(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeGrpcClient.sendUplinkMsg(UplinkMsg)"})
  void testSendUplinkMsg_givenStreamObserverOnNextDoesNothing_thenCallsOnNext() {
    // Arrange
    doNothing().when(streamObserver).onNext(Mockito.<RequestMsg>any());

    // Act
    edgeGrpcClient.sendUplinkMsg(UplinkMsg.getDefaultInstance());

    // Assert
    verify(streamObserver).onNext(isA(RequestMsg.class));
  }

  /**
   * Test {@link EdgeGrpcClient#sendUplinkMsg(UplinkMsg)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcClient#sendUplinkMsg(UplinkMsg)}
   */
  @Test
  @DisplayName("Test sendUplinkMsg(UplinkMsg); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeGrpcClient.sendUplinkMsg(UplinkMsg)"})
  void testSendUplinkMsg_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException()).when(streamObserver).onNext(Mockito.<RequestMsg>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class, () -> edgeGrpcClient.sendUplinkMsg(UplinkMsg.getDefaultInstance()));
    verify(streamObserver).onNext(isA(RequestMsg.class));
  }

  /**
   * Test {@link EdgeGrpcClient#sendSyncRequestMsg(boolean)}.
   *
   * <ul>
   *   <li>Given {@link StreamObserver} {@link StreamObserver#onNext(Object)} does nothing.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcClient#sendSyncRequestMsg(boolean)}
   */
  @Test
  @DisplayName("Test sendSyncRequestMsg(boolean); given StreamObserver onNext(Object) does nothing")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeGrpcClient.sendSyncRequestMsg(boolean)"})
  void testSendSyncRequestMsg_givenStreamObserverOnNextDoesNothing() {
    // Arrange
    doNothing().when(streamObserver).onNext(Mockito.<RequestMsg>any());

    // Act
    edgeGrpcClient.sendSyncRequestMsg(true);

    // Assert
    verify(streamObserver).onNext(isA(RequestMsg.class));
  }

  /**
   * Test {@link EdgeGrpcClient#sendSyncRequestMsg(boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcClient#sendSyncRequestMsg(boolean)}
   */
  @Test
  @DisplayName("Test sendSyncRequestMsg(boolean); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeGrpcClient.sendSyncRequestMsg(boolean)"})
  void testSendSyncRequestMsg_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException()).when(streamObserver).onNext(Mockito.<RequestMsg>any());

    // Act and Assert
    assertThrows(RuntimeException.class, () -> edgeGrpcClient.sendSyncRequestMsg(true));
    verify(streamObserver).onNext(isA(RequestMsg.class));
  }

  /**
   * Test {@link EdgeGrpcClient#sendDownlinkResponseMsg(DownlinkResponseMsg)}.
   *
   * <ul>
   *   <li>Given {@link StreamObserver} {@link StreamObserver#onNext(Object)} does nothing.
   *   <li>Then calls {@link StreamObserver#onNext(Object)}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcClient#sendDownlinkResponseMsg(DownlinkResponseMsg)}
   */
  @Test
  @DisplayName(
      "Test sendDownlinkResponseMsg(DownlinkResponseMsg); given StreamObserver onNext(Object) does nothing; then calls onNext(Object)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeGrpcClient.sendDownlinkResponseMsg(DownlinkResponseMsg)"})
  void testSendDownlinkResponseMsg_givenStreamObserverOnNextDoesNothing_thenCallsOnNext() {
    // Arrange
    doNothing().when(streamObserver).onNext(Mockito.<RequestMsg>any());

    // Act
    edgeGrpcClient.sendDownlinkResponseMsg(DownlinkResponseMsg.getDefaultInstance());

    // Assert
    verify(streamObserver).onNext(isA(RequestMsg.class));
  }

  /**
   * Test {@link EdgeGrpcClient#sendDownlinkResponseMsg(DownlinkResponseMsg)}.
   *
   * <ul>
   *   <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcClient#sendDownlinkResponseMsg(DownlinkResponseMsg)}
   */
  @Test
  @DisplayName("Test sendDownlinkResponseMsg(DownlinkResponseMsg); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeGrpcClient.sendDownlinkResponseMsg(DownlinkResponseMsg)"})
  void testSendDownlinkResponseMsg_thenThrowRuntimeException() {
    // Arrange
    doThrow(new RuntimeException()).when(streamObserver).onNext(Mockito.<RequestMsg>any());

    // Act and Assert
    assertThrows(
        RuntimeException.class,
        () -> edgeGrpcClient.sendDownlinkResponseMsg(DownlinkResponseMsg.getDefaultInstance()));
    verify(streamObserver).onNext(isA(RequestMsg.class));
  }

  /**
   * Test {@link EdgeGrpcClient#getServerMaxInboundMessageSize()}.
   *
   * <p>Method under test: {@link EdgeGrpcClient#getServerMaxInboundMessageSize()}
   */
  @Test
  @DisplayName("Test getServerMaxInboundMessageSize()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int EdgeGrpcClient.getServerMaxInboundMessageSize()"})
  void testGetServerMaxInboundMessageSize() {
    // Arrange, Act and Assert
    assertEquals(0, new EdgeGrpcClient().getServerMaxInboundMessageSize());
  }
}
