package org.thingsboard.server.common.msg.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.MsgType;

class EdgeHighPriorityMsgDiffblueTest {
  /**
   * Test {@link EdgeHighPriorityMsg#equals(Object)}, and {@link EdgeHighPriorityMsg#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeHighPriorityMsg#equals(Object)}
   *   <li>{@link EdgeHighPriorityMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeHighPriorityMsg.equals(Object)",
    "int EdgeHighPriorityMsg.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeHighPriorityMsg edgeHighPriorityMsg = new EdgeHighPriorityMsg(tenantId, new EdgeEvent());
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeHighPriorityMsg edgeHighPriorityMsg2 = new EdgeHighPriorityMsg(tenantId2, new EdgeEvent());

    // Act and Assert
    assertEquals(edgeHighPriorityMsg, edgeHighPriorityMsg2);
    assertEquals(edgeHighPriorityMsg.hashCode(), edgeHighPriorityMsg2.hashCode());
  }

  /**
   * Test {@link EdgeHighPriorityMsg#equals(Object)}, and {@link EdgeHighPriorityMsg#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeHighPriorityMsg#equals(Object)}
   *   <li>{@link EdgeHighPriorityMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeHighPriorityMsg.equals(Object)",
    "int EdgeHighPriorityMsg.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EdgeHighPriorityMsg edgeHighPriorityMsg = new EdgeHighPriorityMsg(null, new EdgeEvent());
    EdgeHighPriorityMsg edgeHighPriorityMsg2 = new EdgeHighPriorityMsg(null, new EdgeEvent());

    // Act and Assert
    assertEquals(edgeHighPriorityMsg, edgeHighPriorityMsg2);
    assertEquals(edgeHighPriorityMsg.hashCode(), edgeHighPriorityMsg2.hashCode());
  }

  /**
   * Test {@link EdgeHighPriorityMsg#equals(Object)}, and {@link EdgeHighPriorityMsg#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeHighPriorityMsg#equals(Object)}
   *   <li>{@link EdgeHighPriorityMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeHighPriorityMsg.equals(Object)",
    "int EdgeHighPriorityMsg.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeHighPriorityMsg edgeHighPriorityMsg = new EdgeHighPriorityMsg(tenantId, null);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeHighPriorityMsg edgeHighPriorityMsg2 = new EdgeHighPriorityMsg(tenantId2, null);

    // Act and Assert
    assertEquals(edgeHighPriorityMsg, edgeHighPriorityMsg2);
    assertEquals(edgeHighPriorityMsg.hashCode(), edgeHighPriorityMsg2.hashCode());
  }

  /**
   * Test {@link EdgeHighPriorityMsg#equals(Object)}, and {@link EdgeHighPriorityMsg#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeHighPriorityMsg#equals(Object)}
   *   <li>{@link EdgeHighPriorityMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeHighPriorityMsg.equals(Object)",
    "int EdgeHighPriorityMsg.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeHighPriorityMsg edgeHighPriorityMsg = new EdgeHighPriorityMsg(tenantId, new EdgeEvent());

    // Act and Assert
    assertEquals(edgeHighPriorityMsg, edgeHighPriorityMsg);
    int expectedHashCodeResult = edgeHighPriorityMsg.hashCode();
    assertEquals(expectedHashCodeResult, edgeHighPriorityMsg.hashCode());
  }

  /**
   * Test {@link EdgeHighPriorityMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeHighPriorityMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeHighPriorityMsg.equals(Object)",
    "int EdgeHighPriorityMsg.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EdgeHighPriorityMsg edgeHighPriorityMsg = new EdgeHighPriorityMsg(tenantId, new EdgeEvent());
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeHighPriorityMsg edgeHighPriorityMsg2 = new EdgeHighPriorityMsg(tenantId2, new EdgeEvent());

    // Act and Assert
    assertNotEquals(edgeHighPriorityMsg, edgeHighPriorityMsg2);
  }

  /**
   * Test {@link EdgeHighPriorityMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeHighPriorityMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeHighPriorityMsg.equals(Object)",
    "int EdgeHighPriorityMsg.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeHighPriorityMsg edgeHighPriorityMsg = new EdgeHighPriorityMsg(null, new EdgeEvent());
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeHighPriorityMsg edgeHighPriorityMsg2 = new EdgeHighPriorityMsg(tenantId, new EdgeEvent());

    // Act and Assert
    assertNotEquals(edgeHighPriorityMsg, edgeHighPriorityMsg2);
  }

  /**
   * Test {@link EdgeHighPriorityMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeHighPriorityMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeHighPriorityMsg.equals(Object)",
    "int EdgeHighPriorityMsg.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeHighPriorityMsg edgeHighPriorityMsg = new EdgeHighPriorityMsg(tenantId, null);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeHighPriorityMsg edgeHighPriorityMsg2 = new EdgeHighPriorityMsg(tenantId2, new EdgeEvent());

    // Act and Assert
    assertNotEquals(edgeHighPriorityMsg, edgeHighPriorityMsg2);
  }

  /**
   * Test {@link EdgeHighPriorityMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeHighPriorityMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeHighPriorityMsg.equals(Object)",
    "int EdgeHighPriorityMsg.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeHighPriorityMsg edgeHighPriorityMsg =
        new EdgeHighPriorityMsg(tenantId, mock(EdgeEvent.class));
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeHighPriorityMsg edgeHighPriorityMsg2 = new EdgeHighPriorityMsg(tenantId2, new EdgeEvent());

    // Act and Assert
    assertNotEquals(edgeHighPriorityMsg, edgeHighPriorityMsg2);
  }

  /**
   * Test {@link EdgeHighPriorityMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeHighPriorityMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeHighPriorityMsg.equals(Object)",
    "int EdgeHighPriorityMsg.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeHighPriorityMsg edgeHighPriorityMsg = new EdgeHighPriorityMsg(tenantId, new EdgeEvent());

    // Act and Assert
    assertNotEquals(edgeHighPriorityMsg, null);
  }

  /**
   * Test {@link EdgeHighPriorityMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeHighPriorityMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeHighPriorityMsg.equals(Object)",
    "int EdgeHighPriorityMsg.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeHighPriorityMsg edgeHighPriorityMsg = new EdgeHighPriorityMsg(tenantId, new EdgeEvent());

    // Act and Assert
    assertNotEquals(edgeHighPriorityMsg, "Different type to EdgeHighPriorityMsg");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeHighPriorityMsg#EdgeHighPriorityMsg(TenantId, EdgeEvent)}
   *   <li>{@link EdgeHighPriorityMsg#toString()}
   *   <li>{@link EdgeHighPriorityMsg#getEdgeEvent()}
   *   <li>{@link EdgeHighPriorityMsg#getMsgType()}
   *   <li>{@link EdgeHighPriorityMsg#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EdgeHighPriorityMsg.<init>(TenantId, EdgeEvent)",
    "EdgeEvent EdgeHighPriorityMsg.getEdgeEvent()",
    "MsgType EdgeHighPriorityMsg.getMsgType()",
    "TenantId EdgeHighPriorityMsg.getTenantId()",
    "String EdgeHighPriorityMsg.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeEvent edgeEvent = new EdgeEvent();

    // Act
    EdgeHighPriorityMsg actualEdgeHighPriorityMsg = new EdgeHighPriorityMsg(tenantId, edgeEvent);
    String actualToStringResult = actualEdgeHighPriorityMsg.toString();
    EdgeEvent actualEdgeEvent = actualEdgeHighPriorityMsg.getEdgeEvent();
    MsgType actualMsgType = actualEdgeHighPriorityMsg.getMsgType();

    // Assert
    assertEquals(
        "EdgeHighPriorityMsg(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, edgeEvent=EdgeEvent(super=BaseData"
            + " [createdTime=0, id=null], seqId=0, tenantId=null, edgeId=null, action=null, entityId=null, uid=null,"
            + " type=null, body=null))",
        actualToStringResult);
    assertEquals(MsgType.EDGE_HIGH_PRIORITY_TO_EDGE_SESSION_MSG, actualMsgType);
    assertSame(edgeEvent, actualEdgeEvent);
    assertSame(tenantId, actualEdgeHighPriorityMsg.getTenantId());
  }
}
