package org.thingsboard.server.service.edge.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import io.grpc.netty.shaded.io.netty.channel.DefaultEventLoop;
import io.grpc.stub.StreamObserver;
import java.util.UUID;
import java.util.concurrent.ScheduledExecutorService;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.edge.Edge;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;
import org.thingsboard.server.gen.edge.v1.RequestMsg;
import org.thingsboard.server.gen.edge.v1.ResponseMsg;
import org.thingsboard.server.service.edge.EdgeContextComponent;

class EdgeGrpcSessionDiffblueTest {
  /**
   * Test {@link EdgeGrpcSession#equals(Object)}, and {@link EdgeGrpcSession#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeGrpcSession#equals(Object)}
   *   <li>{@link EdgeGrpcSession#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeGrpcSession.equals(Object)", "int EdgeGrpcSession.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeContextComponent ctx = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession =
        new EdgeGrpcSession(
            ctx,
            outputStream,
            sessionOpenListener,
            sessionCloseListener,
            new DefaultEventLoop(),
            3,
            3);

    // Act and Assert
    assertEquals(edgeGrpcSession, edgeGrpcSession);
    int expectedHashCodeResult = edgeGrpcSession.hashCode();
    assertEquals(expectedHashCodeResult, edgeGrpcSession.hashCode());
  }

  /**
   * Test {@link EdgeGrpcSession#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcSession#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeGrpcSession.equals(Object)", "int EdgeGrpcSession.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeContextComponent ctx = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession =
        new EdgeGrpcSession(
            ctx,
            outputStream,
            sessionOpenListener,
            sessionCloseListener,
            new DefaultEventLoop(),
            3,
            3);
    EdgeContextComponent ctx2 = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream2 = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener2 = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener2 = mock(BiConsumer.class);

    // Act and Assert
    assertNotEquals(
        edgeGrpcSession,
        new EdgeGrpcSession(
            ctx2,
            outputStream2,
            sessionOpenListener2,
            sessionCloseListener2,
            new DefaultEventLoop(),
            3,
            3));
  }

  /**
   * Test {@link EdgeGrpcSession#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcSession#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeGrpcSession.equals(Object)", "int EdgeGrpcSession.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeContextComponent ctx = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession =
        new EdgeGrpcSession(
            ctx,
            outputStream,
            sessionOpenListener,
            sessionCloseListener,
            new DefaultEventLoop(),
            1,
            3);
    EdgeContextComponent ctx2 = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream2 = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener2 = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener2 = mock(BiConsumer.class);

    // Act and Assert
    assertNotEquals(
        edgeGrpcSession,
        new EdgeGrpcSession(
            ctx2,
            outputStream2,
            sessionOpenListener2,
            sessionCloseListener2,
            new DefaultEventLoop(),
            3,
            3));
  }

  /**
   * Test {@link EdgeGrpcSession#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcSession#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeGrpcSession.equals(Object)", "int EdgeGrpcSession.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeContextComponent ctx = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession =
        new EdgeGrpcSession(
            ctx,
            outputStream,
            sessionOpenListener,
            sessionCloseListener,
            new DefaultEventLoop(),
            3,
            1);
    EdgeContextComponent ctx2 = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream2 = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener2 = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener2 = mock(BiConsumer.class);

    // Act and Assert
    assertNotEquals(
        edgeGrpcSession,
        new EdgeGrpcSession(
            ctx2,
            outputStream2,
            sessionOpenListener2,
            sessionCloseListener2,
            new DefaultEventLoop(),
            3,
            3));
  }

  /**
   * Test {@link EdgeGrpcSession#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcSession#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeGrpcSession.equals(Object)", "int EdgeGrpcSession.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeContextComponent ctx = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession =
        new EdgeGrpcSession(
            ctx,
            outputStream,
            sessionOpenListener,
            sessionCloseListener,
            new DefaultEventLoop(),
            3,
            3);
    edgeGrpcSession.setConnected(true);
    EdgeContextComponent ctx2 = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream2 = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener2 = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener2 = mock(BiConsumer.class);

    // Act and Assert
    assertNotEquals(
        edgeGrpcSession,
        new EdgeGrpcSession(
            ctx2,
            outputStream2,
            sessionOpenListener2,
            sessionCloseListener2,
            new DefaultEventLoop(),
            3,
            3));
  }

  /**
   * Test {@link EdgeGrpcSession#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcSession#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeGrpcSession.equals(Object)", "int EdgeGrpcSession.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EdgeContextComponent ctx = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession =
        new EdgeGrpcSession(
            ctx,
            outputStream,
            sessionOpenListener,
            sessionCloseListener,
            new DefaultEventLoop(),
            3,
            3);
    edgeGrpcSession.setSyncCompleted(true);
    EdgeContextComponent ctx2 = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream2 = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener2 = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener2 = mock(BiConsumer.class);

    // Act and Assert
    assertNotEquals(
        edgeGrpcSession,
        new EdgeGrpcSession(
            ctx2,
            outputStream2,
            sessionOpenListener2,
            sessionCloseListener2,
            new DefaultEventLoop(),
            3,
            3));
  }

  /**
   * Test {@link EdgeGrpcSession#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcSession#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeGrpcSession.equals(Object)", "int EdgeGrpcSession.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EdgeContextComponent ctx = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession =
        new EdgeGrpcSession(
            ctx,
            outputStream,
            sessionOpenListener,
            sessionCloseListener,
            new DefaultEventLoop(),
            3,
            3);
    edgeGrpcSession.setNewStartTs(1L);
    EdgeContextComponent ctx2 = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream2 = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener2 = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener2 = mock(BiConsumer.class);

    // Act and Assert
    assertNotEquals(
        edgeGrpcSession,
        new EdgeGrpcSession(
            ctx2,
            outputStream2,
            sessionOpenListener2,
            sessionCloseListener2,
            new DefaultEventLoop(),
            3,
            3));
  }

  /**
   * Test {@link EdgeGrpcSession#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcSession#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeGrpcSession.equals(Object)", "int EdgeGrpcSession.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EdgeContextComponent ctx = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession =
        new EdgeGrpcSession(
            ctx,
            outputStream,
            sessionOpenListener,
            sessionCloseListener,
            new DefaultEventLoop(),
            3,
            3);
    edgeGrpcSession.setPreviousStartTs(1L);
    EdgeContextComponent ctx2 = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream2 = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener2 = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener2 = mock(BiConsumer.class);

    // Act and Assert
    assertNotEquals(
        edgeGrpcSession,
        new EdgeGrpcSession(
            ctx2,
            outputStream2,
            sessionOpenListener2,
            sessionCloseListener2,
            new DefaultEventLoop(),
            3,
            3));
  }

  /**
   * Test {@link EdgeGrpcSession#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcSession#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeGrpcSession.equals(Object)", "int EdgeGrpcSession.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EdgeContextComponent ctx = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession =
        new EdgeGrpcSession(
            ctx,
            outputStream,
            sessionOpenListener,
            sessionCloseListener,
            new DefaultEventLoop(),
            3,
            3);
    edgeGrpcSession.setNewStartSeqId(1L);
    EdgeContextComponent ctx2 = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream2 = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener2 = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener2 = mock(BiConsumer.class);

    // Act and Assert
    assertNotEquals(
        edgeGrpcSession,
        new EdgeGrpcSession(
            ctx2,
            outputStream2,
            sessionOpenListener2,
            sessionCloseListener2,
            new DefaultEventLoop(),
            3,
            3));
  }

  /**
   * Test {@link EdgeGrpcSession#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcSession#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeGrpcSession.equals(Object)", "int EdgeGrpcSession.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EdgeContextComponent ctx = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession =
        new EdgeGrpcSession(
            ctx,
            outputStream,
            sessionOpenListener,
            sessionCloseListener,
            new DefaultEventLoop(),
            3,
            3);
    edgeGrpcSession.setPreviousStartSeqId(1L);
    EdgeContextComponent ctx2 = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream2 = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener2 = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener2 = mock(BiConsumer.class);

    // Act and Assert
    assertNotEquals(
        edgeGrpcSession,
        new EdgeGrpcSession(
            ctx2,
            outputStream2,
            sessionOpenListener2,
            sessionCloseListener2,
            new DefaultEventLoop(),
            3,
            3));
  }

  /**
   * Test {@link EdgeGrpcSession#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcSession#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeGrpcSession.equals(Object)", "int EdgeGrpcSession.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EdgeContextComponent ctx = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession =
        new EdgeGrpcSession(
            ctx,
            outputStream,
            sessionOpenListener,
            sessionCloseListener,
            new DefaultEventLoop(),
            3,
            3);
    edgeGrpcSession.setSeqIdEnd(1L);
    EdgeContextComponent ctx2 = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream2 = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener2 = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener2 = mock(BiConsumer.class);

    // Act and Assert
    assertNotEquals(
        edgeGrpcSession,
        new EdgeGrpcSession(
            ctx2,
            outputStream2,
            sessionOpenListener2,
            sessionCloseListener2,
            new DefaultEventLoop(),
            3,
            3));
  }

  /**
   * Test {@link EdgeGrpcSession#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcSession#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeGrpcSession.equals(Object)", "int EdgeGrpcSession.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    EdgeContextComponent ctx = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession =
        new EdgeGrpcSession(
            ctx,
            outputStream,
            sessionOpenListener,
            sessionCloseListener,
            new DefaultEventLoop(),
            3,
            3);
    edgeGrpcSession.setClientMaxInboundMessageSize(3);
    EdgeContextComponent ctx2 = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream2 = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener2 = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener2 = mock(BiConsumer.class);

    // Act and Assert
    assertNotEquals(
        edgeGrpcSession,
        new EdgeGrpcSession(
            ctx2,
            outputStream2,
            sessionOpenListener2,
            sessionCloseListener2,
            new DefaultEventLoop(),
            3,
            3));
  }

  /**
   * Test {@link EdgeGrpcSession#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcSession#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeGrpcSession.equals(Object)", "int EdgeGrpcSession.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    EdgeContextComponent ctx = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession =
        new EdgeGrpcSession(
            ctx,
            outputStream,
            sessionOpenListener,
            sessionCloseListener,
            new DefaultEventLoop(),
            3,
            3);
    EdgeContextComponent ctx2 = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream2 = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener2 = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener2 = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession2 =
        new EdgeGrpcSession(
            ctx2,
            outputStream2,
            sessionOpenListener2,
            sessionCloseListener2,
            new DefaultEventLoop(),
            3,
            3);
    edgeGrpcSession2.setNewStartTs(1L);

    // Act and Assert
    assertNotEquals(edgeGrpcSession, edgeGrpcSession2);
  }

  /**
   * Test {@link EdgeGrpcSession#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcSession#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeGrpcSession.equals(Object)", "int EdgeGrpcSession.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    EdgeContextComponent ctx = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession =
        new EdgeGrpcSession(
            ctx,
            outputStream,
            sessionOpenListener,
            sessionCloseListener,
            new DefaultEventLoop(),
            3,
            3);
    EdgeContextComponent ctx2 = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream2 = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener2 = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener2 = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession2 =
        new EdgeGrpcSession(
            ctx2,
            outputStream2,
            sessionOpenListener2,
            sessionCloseListener2,
            new DefaultEventLoop(),
            3,
            3);
    edgeGrpcSession2.setPreviousStartTs(1L);

    // Act and Assert
    assertNotEquals(edgeGrpcSession, edgeGrpcSession2);
  }

  /**
   * Test {@link EdgeGrpcSession#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcSession#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeGrpcSession.equals(Object)", "int EdgeGrpcSession.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    EdgeContextComponent ctx = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession =
        new EdgeGrpcSession(
            ctx,
            outputStream,
            sessionOpenListener,
            sessionCloseListener,
            new DefaultEventLoop(),
            3,
            3);
    EdgeContextComponent ctx2 = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream2 = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener2 = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener2 = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession2 =
        new EdgeGrpcSession(
            ctx2,
            outputStream2,
            sessionOpenListener2,
            sessionCloseListener2,
            new DefaultEventLoop(),
            3,
            3);
    edgeGrpcSession2.setNewStartSeqId(1L);

    // Act and Assert
    assertNotEquals(edgeGrpcSession, edgeGrpcSession2);
  }

  /**
   * Test {@link EdgeGrpcSession#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcSession#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeGrpcSession.equals(Object)", "int EdgeGrpcSession.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    EdgeContextComponent ctx = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession =
        new EdgeGrpcSession(
            ctx,
            outputStream,
            sessionOpenListener,
            sessionCloseListener,
            new DefaultEventLoop(),
            3,
            3);
    EdgeContextComponent ctx2 = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream2 = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener2 = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener2 = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession2 =
        new EdgeGrpcSession(
            ctx2,
            outputStream2,
            sessionOpenListener2,
            sessionCloseListener2,
            new DefaultEventLoop(),
            3,
            3);
    edgeGrpcSession2.setPreviousStartSeqId(1L);

    // Act and Assert
    assertNotEquals(edgeGrpcSession, edgeGrpcSession2);
  }

  /**
   * Test {@link EdgeGrpcSession#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcSession#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeGrpcSession.equals(Object)", "int EdgeGrpcSession.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    EdgeContextComponent ctx = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession =
        new EdgeGrpcSession(
            ctx,
            outputStream,
            sessionOpenListener,
            sessionCloseListener,
            new DefaultEventLoop(),
            3,
            3);
    EdgeContextComponent ctx2 = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream2 = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener2 = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener2 = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession2 =
        new EdgeGrpcSession(
            ctx2,
            outputStream2,
            sessionOpenListener2,
            sessionCloseListener2,
            new DefaultEventLoop(),
            3,
            3);
    edgeGrpcSession2.setSeqIdEnd(1L);

    // Act and Assert
    assertNotEquals(edgeGrpcSession, edgeGrpcSession2);
  }

  /**
   * Test {@link EdgeGrpcSession#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcSession#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeGrpcSession.equals(Object)", "int EdgeGrpcSession.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EdgeContextComponent ctx = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener = mock(BiConsumer.class);

    // Act and Assert
    assertNotEquals(
        new EdgeGrpcSession(
            ctx,
            outputStream,
            sessionOpenListener,
            sessionCloseListener,
            new DefaultEventLoop(),
            3,
            3),
        null);
  }

  /**
   * Test {@link EdgeGrpcSession#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeGrpcSession#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeGrpcSession.equals(Object)", "int EdgeGrpcSession.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EdgeContextComponent ctx = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener = mock(BiConsumer.class);

    // Act and Assert
    assertNotEquals(
        new EdgeGrpcSession(
            ctx,
            outputStream,
            sessionOpenListener,
            sessionCloseListener,
            new DefaultEventLoop(),
            3,
            3),
        "Different type to EdgeGrpcSession");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeGrpcSession#setClientMaxInboundMessageSize(int)}
   *   <li>{@link EdgeGrpcSession#setConnected(boolean)}
   *   <li>{@link EdgeGrpcSession#setCtx(EdgeContextComponent)}
   *   <li>{@link EdgeGrpcSession#setEdge(Edge)}
   *   <li>{@link EdgeGrpcSession#setEdgeVersion(EdgeVersion)}
   *   <li>{@link EdgeGrpcSession#setInputStream(StreamObserver)}
   *   <li>{@link EdgeGrpcSession#setMaxHighPriorityQueueSizePerSession(int)}
   *   <li>{@link EdgeGrpcSession#setMaxInboundMessageSize(int)}
   *   <li>{@link EdgeGrpcSession#setNewStartSeqId(Long)}
   *   <li>{@link EdgeGrpcSession#setNewStartTs(Long)}
   *   <li>{@link EdgeGrpcSession#setOutputStream(StreamObserver)}
   *   <li>{@link EdgeGrpcSession#setPreviousStartSeqId(Long)}
   *   <li>{@link EdgeGrpcSession#setPreviousStartTs(Long)}
   *   <li>{@link EdgeGrpcSession#setSendDownlinkExecutorService(ScheduledExecutorService)}
   *   <li>{@link EdgeGrpcSession#setSeqIdEnd(Long)}
   *   <li>{@link EdgeGrpcSession#setSyncCompleted(boolean)}
   *   <li>{@link EdgeGrpcSession#setTenantId(TenantId)}
   *   <li>{@link EdgeGrpcSession#toString()}
   *   <li>{@link EdgeGrpcSession#getClientMaxInboundMessageSize()}
   *   <li>{@link EdgeGrpcSession#getCtx()}
   *   <li>{@link EdgeGrpcSession#getEdge()}
   *   <li>{@link EdgeGrpcSession#getEdgeVersion()}
   *   <li>{@link EdgeGrpcSession#getInputStream()}
   *   <li>{@link EdgeGrpcSession#getMaxHighPriorityQueueSizePerSession()}
   *   <li>{@link EdgeGrpcSession#getMaxInboundMessageSize()}
   *   <li>{@link EdgeGrpcSession#getNewStartSeqId()}
   *   <li>{@link EdgeGrpcSession#getNewStartTs()}
   *   <li>{@link EdgeGrpcSession#getOutputStream()}
   *   <li>{@link EdgeGrpcSession#getPreviousStartSeqId()}
   *   <li>{@link EdgeGrpcSession#getPreviousStartTs()}
   *   <li>{@link EdgeGrpcSession#getSendDownlinkExecutorService()}
   *   <li>{@link EdgeGrpcSession#getSeqIdEnd()}
   *   <li>{@link EdgeGrpcSession#getSessionCloseListener()}
   *   <li>{@link EdgeGrpcSession#getSessionId()}
   *   <li>{@link EdgeGrpcSession#getSessionOpenListener()}
   *   <li>{@link EdgeGrpcSession#getSessionState()}
   *   <li>{@link EdgeGrpcSession#getTenantId()}
   *   <li>{@link EdgeGrpcSession#isConnected()}
   *   <li>{@link EdgeGrpcSession#isSyncCompleted()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "int EdgeGrpcSession.getClientMaxInboundMessageSize()",
    "EdgeContextComponent EdgeGrpcSession.getCtx()",
    "Edge EdgeGrpcSession.getEdge()",
    "EdgeVersion EdgeGrpcSession.getEdgeVersion()",
    "StreamObserver EdgeGrpcSession.getInputStream()",
    "int EdgeGrpcSession.getMaxHighPriorityQueueSizePerSession()",
    "int EdgeGrpcSession.getMaxInboundMessageSize()",
    "Long EdgeGrpcSession.getNewStartSeqId()",
    "Long EdgeGrpcSession.getNewStartTs()",
    "StreamObserver EdgeGrpcSession.getOutputStream()",
    "Long EdgeGrpcSession.getPreviousStartSeqId()",
    "Long EdgeGrpcSession.getPreviousStartTs()",
    "ScheduledExecutorService EdgeGrpcSession.getSendDownlinkExecutorService()",
    "Long EdgeGrpcSession.getSeqIdEnd()",
    "BiConsumer EdgeGrpcSession.getSessionCloseListener()",
    "UUID EdgeGrpcSession.getSessionId()",
    "BiConsumer EdgeGrpcSession.getSessionOpenListener()",
    "EdgeSessionState EdgeGrpcSession.getSessionState()",
    "TenantId EdgeGrpcSession.getTenantId()",
    "boolean EdgeGrpcSession.isConnected()",
    "boolean EdgeGrpcSession.isSyncCompleted()",
    "void EdgeGrpcSession.setClientMaxInboundMessageSize(int)",
    "void EdgeGrpcSession.setConnected(boolean)",
    "void EdgeGrpcSession.setCtx(EdgeContextComponent)",
    "void EdgeGrpcSession.setEdge(Edge)",
    "void EdgeGrpcSession.setEdgeVersion(EdgeVersion)",
    "void EdgeGrpcSession.setInputStream(StreamObserver)",
    "void EdgeGrpcSession.setMaxHighPriorityQueueSizePerSession(int)",
    "void EdgeGrpcSession.setMaxInboundMessageSize(int)",
    "void EdgeGrpcSession.setNewStartSeqId(Long)",
    "void EdgeGrpcSession.setNewStartTs(Long)",
    "void EdgeGrpcSession.setOutputStream(StreamObserver)",
    "void EdgeGrpcSession.setPreviousStartSeqId(Long)",
    "void EdgeGrpcSession.setPreviousStartTs(Long)",
    "void EdgeGrpcSession.setSendDownlinkExecutorService(ScheduledExecutorService)",
    "void EdgeGrpcSession.setSeqIdEnd(Long)",
    "void EdgeGrpcSession.setSyncCompleted(boolean)",
    "void EdgeGrpcSession.setTenantId(TenantId)",
    "java.lang.String EdgeGrpcSession.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    EdgeContextComponent ctx = new EdgeContextComponent();
    StreamObserver<ResponseMsg> outputStream = mock(StreamObserver.class);
    BiConsumer<EdgeId, EdgeGrpcSession> sessionOpenListener = mock(BiConsumer.class);
    BiConsumer<Edge, UUID> sessionCloseListener = mock(BiConsumer.class);

    EdgeGrpcSession edgeGrpcSession =
        new EdgeGrpcSession(
            ctx,
            outputStream,
            sessionOpenListener,
            sessionCloseListener,
            new DefaultEventLoop(),
            3,
            3);

    // Act
    edgeGrpcSession.setClientMaxInboundMessageSize(3);
    edgeGrpcSession.setConnected(true);
    EdgeContextComponent ctx2 = new EdgeContextComponent();
    edgeGrpcSession.setCtx(ctx2);
    Edge edge = new Edge();
    edgeGrpcSession.setEdge(edge);
    edgeGrpcSession.setEdgeVersion(EdgeVersion.V_3_3_0);
    StreamObserver<RequestMsg> inputStream = mock(StreamObserver.class);
    edgeGrpcSession.setInputStream(inputStream);
    edgeGrpcSession.setMaxHighPriorityQueueSizePerSession(3);
    edgeGrpcSession.setMaxInboundMessageSize(3);
    edgeGrpcSession.setNewStartSeqId(1L);
    edgeGrpcSession.setNewStartTs(1L);
    StreamObserver<ResponseMsg> outputStream2 = mock(StreamObserver.class);
    edgeGrpcSession.setOutputStream(outputStream2);
    edgeGrpcSession.setPreviousStartSeqId(1L);
    edgeGrpcSession.setPreviousStartTs(1L);
    DefaultEventLoop sendDownlinkExecutorService = new DefaultEventLoop();
    edgeGrpcSession.setSendDownlinkExecutorService(sendDownlinkExecutorService);
    edgeGrpcSession.setSeqIdEnd(1L);
    edgeGrpcSession.setSyncCompleted(true);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    edgeGrpcSession.setTenantId(tenantId);
    edgeGrpcSession.toString();
    int actualClientMaxInboundMessageSize = edgeGrpcSession.getClientMaxInboundMessageSize();
    EdgeContextComponent actualCtx = edgeGrpcSession.getCtx();
    Edge actualEdge = edgeGrpcSession.getEdge();
    EdgeVersion actualEdgeVersion = edgeGrpcSession.getEdgeVersion();
    StreamObserver<RequestMsg> actualInputStream = edgeGrpcSession.getInputStream();
    int actualMaxHighPriorityQueueSizePerSession =
        edgeGrpcSession.getMaxHighPriorityQueueSizePerSession();
    int actualMaxInboundMessageSize = edgeGrpcSession.getMaxInboundMessageSize();
    Long actualNewStartSeqId = edgeGrpcSession.getNewStartSeqId();
    Long actualNewStartTs = edgeGrpcSession.getNewStartTs();
    StreamObserver<ResponseMsg> actualOutputStream = edgeGrpcSession.getOutputStream();
    Long actualPreviousStartSeqId = edgeGrpcSession.getPreviousStartSeqId();
    Long actualPreviousStartTs = edgeGrpcSession.getPreviousStartTs();
    ScheduledExecutorService actualSendDownlinkExecutorService =
        edgeGrpcSession.getSendDownlinkExecutorService();
    Long actualSeqIdEnd = edgeGrpcSession.getSeqIdEnd();
    edgeGrpcSession.getSessionCloseListener();
    edgeGrpcSession.getSessionId();
    edgeGrpcSession.getSessionOpenListener();
    EdgeSessionState actualSessionState = edgeGrpcSession.getSessionState();
    TenantId actualTenantId = edgeGrpcSession.getTenantId();
    boolean actualIsConnectedResult = edgeGrpcSession.isConnected();
    boolean actualIsSyncCompletedResult = edgeGrpcSession.isSyncCompleted();

    // Assert
    assertNull(actualSessionState.getSendDownlinkMsgsFuture());
    assertNull(actualSessionState.getScheduledSendDownlinkTask());
    assertEquals(1L, actualNewStartSeqId.longValue());
    assertEquals(1L, actualNewStartTs.longValue());
    assertEquals(1L, actualPreviousStartSeqId.longValue());
    assertEquals(1L, actualPreviousStartTs.longValue());
    assertEquals(1L, actualSeqIdEnd.longValue());
    assertEquals(3, actualClientMaxInboundMessageSize);
    assertEquals(3, actualMaxHighPriorityQueueSizePerSession);
    assertEquals(3, actualMaxInboundMessageSize);
    assertEquals(EdgeVersion.V_3_3_0, actualEdgeVersion);
    assertTrue(actualSessionState.getPendingMsgsMap().isEmpty());
    assertTrue(actualIsConnectedResult);
    assertTrue(actualIsSyncCompletedResult);
    assertSame(sendDownlinkExecutorService, actualSendDownlinkExecutorService);
    assertSame(edge, actualEdge);
    assertSame(tenantId, actualTenantId);
    assertSame(ctx2, actualCtx);
    assertSame(inputStream, actualInputStream);
    assertSame(outputStream2, actualOutputStream);
  }
}
