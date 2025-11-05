package org.thingsboard.server.common.data.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class EdgeEventDiffblueTest {
  /**
   * Test {@link EdgeEvent#equals(Object)}, and {@link EdgeEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeEvent#equals(Object)}
   *   <li>{@link EdgeEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEvent.equals(Object)", "int EdgeEvent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    EdgeEvent edgeEvent2 = new EdgeEvent();

    // Act and Assert
    assertEquals(edgeEvent, edgeEvent2);
    assertEquals(edgeEvent.hashCode(), edgeEvent2.hashCode());
  }

  /**
   * Test {@link EdgeEvent#equals(Object)}, and {@link EdgeEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeEvent#equals(Object)}
   *   <li>{@link EdgeEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEvent.equals(Object)", "int EdgeEvent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setTenantId(TenantId.SYS_TENANT_ID);

    EdgeEvent edgeEvent2 = new EdgeEvent();
    edgeEvent2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(edgeEvent, edgeEvent2);
    assertEquals(edgeEvent.hashCode(), edgeEvent2.hashCode());
  }

  /**
   * Test {@link EdgeEvent#equals(Object)}, and {@link EdgeEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeEvent#equals(Object)}
   *   <li>{@link EdgeEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEvent.equals(Object)", "int EdgeEvent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.ADDED);

    EdgeEvent edgeEvent2 = new EdgeEvent();
    edgeEvent2.setAction(EdgeEventActionType.ADDED);

    // Act and Assert
    assertEquals(edgeEvent, edgeEvent2);
    assertEquals(edgeEvent.hashCode(), edgeEvent2.hashCode());
  }

  /**
   * Test {@link EdgeEvent#equals(Object)}, and {@link EdgeEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeEvent#equals(Object)}
   *   <li>{@link EdgeEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEvent.equals(Object)", "int EdgeEvent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    EdgeEvent edgeEvent2 = new EdgeEvent();
    edgeEvent2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(edgeEvent, edgeEvent2);
    assertEquals(edgeEvent.hashCode(), edgeEvent2.hashCode());
  }

  /**
   * Test {@link EdgeEvent#equals(Object)}, and {@link EdgeEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeEvent#equals(Object)}
   *   <li>{@link EdgeEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEvent.equals(Object)", "int EdgeEvent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setUid("1234");

    EdgeEvent edgeEvent2 = new EdgeEvent();
    edgeEvent2.setUid("1234");

    // Act and Assert
    assertEquals(edgeEvent, edgeEvent2);
    assertEquals(edgeEvent.hashCode(), edgeEvent2.hashCode());
  }

  /**
   * Test {@link EdgeEvent#equals(Object)}, and {@link EdgeEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeEvent#equals(Object)}
   *   <li>{@link EdgeEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEvent.equals(Object)", "int EdgeEvent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setType(EdgeEventType.DASHBOARD);

    EdgeEvent edgeEvent2 = new EdgeEvent();
    edgeEvent2.setType(EdgeEventType.DASHBOARD);

    // Act and Assert
    assertEquals(edgeEvent, edgeEvent2);
    assertEquals(edgeEvent.hashCode(), edgeEvent2.hashCode());
  }

  /**
   * Test {@link EdgeEvent#equals(Object)}, and {@link EdgeEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EdgeEvent#equals(Object)}
   *   <li>{@link EdgeEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEvent.equals(Object)", "int EdgeEvent.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();

    // Act and Assert
    assertEquals(edgeEvent, edgeEvent);
    int expectedHashCodeResult = edgeEvent.hashCode();
    assertEquals(expectedHashCodeResult, edgeEvent.hashCode());
  }

  /**
   * Test {@link EdgeEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEvent.equals(Object)", "int EdgeEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeEvent(), 1);
  }

  /**
   * Test {@link EdgeEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEvent.equals(Object)", "int EdgeEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setSeqId(1L);

    // Act and Assert
    assertNotEquals(edgeEvent, new EdgeEvent());
  }

  /**
   * Test {@link EdgeEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEvent.equals(Object)", "int EdgeEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(edgeEvent, new EdgeEvent());
  }

  /**
   * Test {@link EdgeEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEvent.equals(Object)", "int EdgeEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.ADDED);

    // Act and Assert
    assertNotEquals(edgeEvent, new EdgeEvent());
  }

  /**
   * Test {@link EdgeEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEvent.equals(Object)", "int EdgeEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(edgeEvent, new EdgeEvent());
  }

  /**
   * Test {@link EdgeEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEvent.equals(Object)", "int EdgeEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setUid("1234");

    // Act and Assert
    assertNotEquals(edgeEvent, new EdgeEvent());
  }

  /**
   * Test {@link EdgeEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEvent.equals(Object)", "int EdgeEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setType(EdgeEventType.DASHBOARD);

    // Act and Assert
    assertNotEquals(edgeEvent, new EdgeEvent());
  }

  /**
   * Test {@link EdgeEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEvent.equals(Object)", "int EdgeEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(edgeEvent, new EdgeEvent());
  }

  /**
   * Test {@link EdgeEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEvent.equals(Object)", "int EdgeEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();

    EdgeEvent edgeEvent2 = new EdgeEvent();
    edgeEvent2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(edgeEvent, edgeEvent2);
  }

  /**
   * Test {@link EdgeEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEvent.equals(Object)", "int EdgeEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();

    EdgeEvent edgeEvent2 = new EdgeEvent();
    edgeEvent2.setAction(EdgeEventActionType.ADDED);

    // Act and Assert
    assertNotEquals(edgeEvent, edgeEvent2);
  }

  /**
   * Test {@link EdgeEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEvent.equals(Object)", "int EdgeEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();

    EdgeEvent edgeEvent2 = new EdgeEvent();
    edgeEvent2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(edgeEvent, edgeEvent2);
  }

  /**
   * Test {@link EdgeEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEvent.equals(Object)", "int EdgeEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();

    EdgeEvent edgeEvent2 = new EdgeEvent();
    edgeEvent2.setUid("1234");

    // Act and Assert
    assertNotEquals(edgeEvent, edgeEvent2);
  }

  /**
   * Test {@link EdgeEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEvent.equals(Object)", "int EdgeEvent.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();

    EdgeEvent edgeEvent2 = new EdgeEvent();
    edgeEvent2.setType(EdgeEventType.DASHBOARD);

    // Act and Assert
    assertNotEquals(edgeEvent, edgeEvent2);
  }

  /**
   * Test {@link EdgeEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEvent.equals(Object)", "int EdgeEvent.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeEvent(), null);
  }

  /**
   * Test {@link EdgeEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeEvent.equals(Object)", "int EdgeEvent.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeEvent(), "Different type to EdgeEvent");
  }
}
