package org.thingsboard.server.service.edge.rpc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.gen.edge.v1.DownlinkMsg;

class EdgeSessionStateDiffblueTest {
  /**
   * Test {@link EdgeSessionState#equals(Object)}, and {@link EdgeSessionState#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeSessionState#equals(Object)}
   *   <li>{@link EdgeSessionState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSessionState.equals(Object)", "int EdgeSessionState.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeSessionState edgeSessionState = new EdgeSessionState();
    edgeSessionState.setSendDownlinkMsgsFuture(null);

    EdgeSessionState edgeSessionState2 = new EdgeSessionState();
    edgeSessionState2.setSendDownlinkMsgsFuture(null);

    // Act and Assert
    assertEquals(edgeSessionState, edgeSessionState2);
    assertEquals(edgeSessionState.hashCode(), edgeSessionState2.hashCode());
  }

  /**
   * Test {@link EdgeSessionState#equals(Object)}, and {@link EdgeSessionState#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeSessionState#equals(Object)}
   *   <li>{@link EdgeSessionState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSessionState.equals(Object)", "int EdgeSessionState.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeSessionState edgeSessionState = new EdgeSessionState();
    SettableFuture<Boolean> sendDownlinkMsgsFuture = SettableFuture.create();
    edgeSessionState.setSendDownlinkMsgsFuture(sendDownlinkMsgsFuture);

    // Act and Assert
    assertEquals(edgeSessionState, edgeSessionState);
    int expectedHashCodeResult = edgeSessionState.hashCode();
    assertEquals(expectedHashCodeResult, edgeSessionState.hashCode());
  }

  /**
   * Test {@link EdgeSessionState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSessionState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSessionState.equals(Object)", "int EdgeSessionState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeSessionState edgeSessionState = new EdgeSessionState();
    SettableFuture<Boolean> sendDownlinkMsgsFuture = SettableFuture.create();
    edgeSessionState.setSendDownlinkMsgsFuture(sendDownlinkMsgsFuture);

    EdgeSessionState edgeSessionState2 = new EdgeSessionState();
    SettableFuture<Boolean> sendDownlinkMsgsFuture2 = SettableFuture.create();
    edgeSessionState2.setSendDownlinkMsgsFuture(sendDownlinkMsgsFuture2);

    // Act and Assert
    assertNotEquals(edgeSessionState, edgeSessionState2);
  }

  /**
   * Test {@link EdgeSessionState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSessionState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSessionState.equals(Object)", "int EdgeSessionState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeSessionState edgeSessionState = new EdgeSessionState();
    edgeSessionState.setSendDownlinkMsgsFuture(null);

    EdgeSessionState edgeSessionState2 = new EdgeSessionState();
    SettableFuture<Boolean> sendDownlinkMsgsFuture = SettableFuture.create();
    edgeSessionState2.setSendDownlinkMsgsFuture(sendDownlinkMsgsFuture);

    // Act and Assert
    assertNotEquals(edgeSessionState, edgeSessionState2);
  }

  /**
   * Test {@link EdgeSessionState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSessionState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSessionState.equals(Object)", "int EdgeSessionState.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EdgeSessionState edgeSessionState = new EdgeSessionState();
    SettableFuture<Boolean> sendDownlinkMsgsFuture = SettableFuture.create();
    edgeSessionState.setSendDownlinkMsgsFuture(sendDownlinkMsgsFuture);

    // Act and Assert
    assertNotEquals(edgeSessionState, null);
  }

  /**
   * Test {@link EdgeSessionState#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeSessionState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeSessionState.equals(Object)", "int EdgeSessionState.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EdgeSessionState edgeSessionState = new EdgeSessionState();
    SettableFuture<Boolean> sendDownlinkMsgsFuture = SettableFuture.create();
    edgeSessionState.setSendDownlinkMsgsFuture(sendDownlinkMsgsFuture);

    // Act and Assert
    assertNotEquals(edgeSessionState, "Different type to EdgeSessionState");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeSessionState#setScheduledSendDownlinkTask(ScheduledFuture)}
   *   <li>{@link EdgeSessionState#setSendDownlinkMsgsFuture(SettableFuture)}
   *   <li>{@link EdgeSessionState#toString()}
   *   <li>{@link EdgeSessionState#getPendingMsgsMap()}
   *   <li>{@link EdgeSessionState#getScheduledSendDownlinkTask()}
   *   <li>{@link EdgeSessionState#getSendDownlinkMsgsFuture()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map EdgeSessionState.getPendingMsgsMap()",
    "ScheduledFuture EdgeSessionState.getScheduledSendDownlinkTask()",
    "SettableFuture EdgeSessionState.getSendDownlinkMsgsFuture()",
    "void EdgeSessionState.setScheduledSendDownlinkTask(ScheduledFuture)",
    "void EdgeSessionState.setSendDownlinkMsgsFuture(SettableFuture)",
    "java.lang.String EdgeSessionState.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    EdgeSessionState edgeSessionState = new EdgeSessionState();

    // Act
    edgeSessionState.setScheduledSendDownlinkTask(null);
    SettableFuture<Boolean> sendDownlinkMsgsFuture = SettableFuture.create();
    edgeSessionState.setSendDownlinkMsgsFuture(sendDownlinkMsgsFuture);
    edgeSessionState.toString();
    Map<Integer, DownlinkMsg> actualPendingMsgsMap = edgeSessionState.getPendingMsgsMap();
    ScheduledFuture<?> actualScheduledSendDownlinkTask =
        edgeSessionState.getScheduledSendDownlinkTask();
    SettableFuture<Boolean> actualSendDownlinkMsgsFuture =
        edgeSessionState.getSendDownlinkMsgsFuture();

    // Assert
    assertNull(actualScheduledSendDownlinkTask);
    assertTrue(actualPendingMsgsMap.isEmpty());
    assertSame(sendDownlinkMsgsFuture, actualSendDownlinkMsgsFuture);
  }

  /**
   * Test new {@link EdgeSessionState} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link EdgeSessionState}
   */
  @Test
  @DisplayName("Test new EdgeSessionState (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EdgeSessionState.<init>()"})
  void testNewEdgeSessionState() {
    // Arrange and Act
    EdgeSessionState actualEdgeSessionState = new EdgeSessionState();

    // Assert
    assertNull(actualEdgeSessionState.getSendDownlinkMsgsFuture());
    assertNull(actualEdgeSessionState.getScheduledSendDownlinkTask());
    assertTrue(actualEdgeSessionState.getPendingMsgsMap().isEmpty());
  }
}
