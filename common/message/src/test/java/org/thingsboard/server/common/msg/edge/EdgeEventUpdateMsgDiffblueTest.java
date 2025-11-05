package org.thingsboard.server.common.msg.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;

class EdgeEventUpdateMsgDiffblueTest {
  /**
   * Test {@link EdgeEventUpdateMsg#equals(Object)}, and {@link EdgeEventUpdateMsg#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeEventUpdateMsg#equals(Object)}
   *   <li>{@link EdgeEventUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeEventUpdateMsg.equals(Object)",
    "int EdgeEventUpdateMsg.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeEventUpdateMsg edgeEventUpdateMsg = new EdgeEventUpdateMsg(tenantId, null);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeEventUpdateMsg edgeEventUpdateMsg2 = new EdgeEventUpdateMsg(tenantId2, null);

    // Act and Assert
    assertEquals(edgeEventUpdateMsg, edgeEventUpdateMsg2);
    assertEquals(edgeEventUpdateMsg.hashCode(), edgeEventUpdateMsg2.hashCode());
  }

  /**
   * Test {@link EdgeEventUpdateMsg#equals(Object)}, and {@link EdgeEventUpdateMsg#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeEventUpdateMsg#equals(Object)}
   *   <li>{@link EdgeEventUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeEventUpdateMsg.equals(Object)",
    "int EdgeEventUpdateMsg.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EdgeEventUpdateMsg edgeEventUpdateMsg = new EdgeEventUpdateMsg(null, null);
    EdgeEventUpdateMsg edgeEventUpdateMsg2 = new EdgeEventUpdateMsg(null, null);

    // Act and Assert
    assertEquals(edgeEventUpdateMsg, edgeEventUpdateMsg2);
    assertEquals(edgeEventUpdateMsg.hashCode(), edgeEventUpdateMsg2.hashCode());
  }

  /**
   * Test {@link EdgeEventUpdateMsg#equals(Object)}, and {@link EdgeEventUpdateMsg#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeEventUpdateMsg#equals(Object)}
   *   <li>{@link EdgeEventUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeEventUpdateMsg.equals(Object)",
    "int EdgeEventUpdateMsg.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeId edgeId = new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EdgeEventUpdateMsg edgeEventUpdateMsg = new EdgeEventUpdateMsg(tenantId, edgeId);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeId edgeId2 = new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EdgeEventUpdateMsg edgeEventUpdateMsg2 = new EdgeEventUpdateMsg(tenantId2, edgeId2);

    // Act and Assert
    assertEquals(edgeEventUpdateMsg, edgeEventUpdateMsg2);
    assertEquals(edgeEventUpdateMsg.hashCode(), edgeEventUpdateMsg2.hashCode());
  }

  /**
   * Test {@link EdgeEventUpdateMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeEventUpdateMsg.equals(Object)",
    "int EdgeEventUpdateMsg.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeEventUpdateMsg edgeEventUpdateMsg =
        new EdgeEventUpdateMsg(new TenantId(UUID.randomUUID()), null);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeEventUpdateMsg edgeEventUpdateMsg2 = new EdgeEventUpdateMsg(tenantId, null);

    // Act and Assert
    assertNotEquals(edgeEventUpdateMsg, edgeEventUpdateMsg2);
  }

  /**
   * Test {@link EdgeEventUpdateMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeEventUpdateMsg.equals(Object)",
    "int EdgeEventUpdateMsg.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeEventUpdateMsg edgeEventUpdateMsg = new EdgeEventUpdateMsg(null, null);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeEventUpdateMsg edgeEventUpdateMsg2 = new EdgeEventUpdateMsg(tenantId, null);

    // Act and Assert
    assertNotEquals(edgeEventUpdateMsg, edgeEventUpdateMsg2);
  }

  /**
   * Test {@link EdgeEventUpdateMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeEventUpdateMsg.equals(Object)",
    "int EdgeEventUpdateMsg.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeId edgeId = new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EdgeEventUpdateMsg edgeEventUpdateMsg = new EdgeEventUpdateMsg(tenantId, edgeId);
    TenantId tenantId2 = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeEventUpdateMsg edgeEventUpdateMsg2 = new EdgeEventUpdateMsg(tenantId2, null);

    // Act and Assert
    assertNotEquals(edgeEventUpdateMsg, edgeEventUpdateMsg2);
  }

  /**
   * Test {@link EdgeEventUpdateMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeEventUpdateMsg.equals(Object)",
    "int EdgeEventUpdateMsg.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeEventUpdateMsg edgeEventUpdateMsg = new EdgeEventUpdateMsg(tenantId, null);

    // Act and Assert
    assertNotEquals(edgeEventUpdateMsg, 1);
  }

  /**
   * Test {@link EdgeEventUpdateMsg#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEventUpdateMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EdgeEventUpdateMsg.equals(Object)",
    "int EdgeEventUpdateMsg.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EdgeEventUpdateMsg edgeEventUpdateMsg = new EdgeEventUpdateMsg(null, null);
    EdgeId edgeId = new EdgeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EdgeEventUpdateMsg edgeEventUpdateMsg2 = new EdgeEventUpdateMsg(null, edgeId);

    // Act and Assert
    assertNotEquals(edgeEventUpdateMsg, edgeEventUpdateMsg2);
  }
}
