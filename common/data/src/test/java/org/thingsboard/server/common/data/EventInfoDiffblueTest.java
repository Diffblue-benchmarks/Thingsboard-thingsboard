package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;

class EventInfoDiffblueTest {
  /**
   * Test {@link EventInfo#EventInfo(EventInfo)}.
   *
   * <p>Method under test: {@link EventInfo#EventInfo(EventInfo)}
   */
  @Test
  @DisplayName("Test new EventInfo(EventInfo)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EventInfo.<init>(EventInfo)"})
  void testNewEventInfo() {
    // Arrange
    EventInfo event = new EventInfo();

    // Act and Assert
    assertEquals(event, new EventInfo(event));
  }

  /**
   * Test {@link EventInfo#getCreatedTime()}.
   *
   * <p>Method under test: {@link EventInfo#getCreatedTime()}
   */
  @Test
  @DisplayName("Test getCreatedTime()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long EventInfo.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new EventInfo().getCreatedTime());
  }

  /**
   * Test {@link EventInfo#equals(Object)}, and {@link EventInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EventInfo#equals(Object)}
   *   <li>{@link EventInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EventInfo.equals(Object)", "int EventInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EventInfo eventInfo = new EventInfo();
    EventInfo eventInfo2 = new EventInfo();

    // Act and Assert
    assertEquals(eventInfo, eventInfo2);
    int expectedHashCodeResult = eventInfo.hashCode();
    assertEquals(expectedHashCodeResult, eventInfo2.hashCode());
  }

  /**
   * Test {@link EventInfo#equals(Object)}, and {@link EventInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EventInfo#equals(Object)}
   *   <li>{@link EventInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EventInfo.equals(Object)", "int EventInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EventInfo eventInfo = new EventInfo();
    eventInfo.setTenantId(TenantId.SYS_TENANT_ID);

    EventInfo eventInfo2 = new EventInfo();
    eventInfo2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(eventInfo, eventInfo2);
    int expectedHashCodeResult = eventInfo.hashCode();
    assertEquals(expectedHashCodeResult, eventInfo2.hashCode());
  }

  /**
   * Test {@link EventInfo#equals(Object)}, and {@link EventInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EventInfo#equals(Object)}
   *   <li>{@link EventInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EventInfo.equals(Object)", "int EventInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EventInfo eventInfo = new EventInfo();
    eventInfo.setType("Type");

    EventInfo eventInfo2 = new EventInfo();
    eventInfo2.setType("Type");

    // Act and Assert
    assertEquals(eventInfo, eventInfo2);
    int expectedHashCodeResult = eventInfo.hashCode();
    assertEquals(expectedHashCodeResult, eventInfo2.hashCode());
  }

  /**
   * Test {@link EventInfo#equals(Object)}, and {@link EventInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EventInfo#equals(Object)}
   *   <li>{@link EventInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EventInfo.equals(Object)", "int EventInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EventInfo eventInfo = new EventInfo();
    eventInfo.setUid("1234");

    EventInfo eventInfo2 = new EventInfo();
    eventInfo2.setUid("1234");

    // Act and Assert
    assertEquals(eventInfo, eventInfo2);
    int expectedHashCodeResult = eventInfo.hashCode();
    assertEquals(expectedHashCodeResult, eventInfo2.hashCode());
  }

  /**
   * Test {@link EventInfo#equals(Object)}, and {@link EventInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EventInfo#equals(Object)}
   *   <li>{@link EventInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EventInfo.equals(Object)", "int EventInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    EventInfo eventInfo = new EventInfo();
    eventInfo.setEntityId(TenantId.SYS_TENANT_ID);

    EventInfo eventInfo2 = new EventInfo();
    eventInfo2.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(eventInfo, eventInfo2);
    int expectedHashCodeResult = eventInfo.hashCode();
    assertEquals(expectedHashCodeResult, eventInfo2.hashCode());
  }

  /**
   * Test {@link EventInfo#equals(Object)}, and {@link EventInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EventInfo#equals(Object)}
   *   <li>{@link EventInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EventInfo.equals(Object)", "int EventInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EventInfo eventInfo = new EventInfo();

    // Act and Assert
    assertEquals(eventInfo, eventInfo);
    int expectedHashCodeResult = eventInfo.hashCode();
    assertEquals(expectedHashCodeResult, eventInfo.hashCode());
  }

  /**
   * Test {@link EventInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EventInfo.equals(Object)", "int EventInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EventInfo(), 1);
  }

  /**
   * Test {@link EventInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EventInfo.equals(Object)", "int EventInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EventInfo eventInfo = new EventInfo();
    eventInfo.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(eventInfo, new EventInfo());
  }

  /**
   * Test {@link EventInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EventInfo.equals(Object)", "int EventInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EventInfo eventInfo = new EventInfo();
    eventInfo.setType("Type");

    // Act and Assert
    assertNotEquals(eventInfo, new EventInfo());
  }

  /**
   * Test {@link EventInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EventInfo.equals(Object)", "int EventInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EventInfo eventInfo = new EventInfo();
    eventInfo.setUid("1234");

    // Act and Assert
    assertNotEquals(eventInfo, new EventInfo());
  }

  /**
   * Test {@link EventInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EventInfo.equals(Object)", "int EventInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EventInfo eventInfo = new EventInfo();
    eventInfo.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(eventInfo, new EventInfo());
  }

  /**
   * Test {@link EventInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EventInfo.equals(Object)", "int EventInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EventInfo eventInfo = new EventInfo();

    EventInfo eventInfo2 = new EventInfo();
    eventInfo2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(eventInfo, eventInfo2);
  }

  /**
   * Test {@link EventInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EventInfo.equals(Object)", "int EventInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EventInfo eventInfo = new EventInfo();

    EventInfo eventInfo2 = new EventInfo();
    eventInfo2.setType("Type");

    // Act and Assert
    assertNotEquals(eventInfo, eventInfo2);
  }

  /**
   * Test {@link EventInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EventInfo.equals(Object)", "int EventInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EventInfo eventInfo = new EventInfo();

    EventInfo eventInfo2 = new EventInfo();
    eventInfo2.setUid("1234");

    // Act and Assert
    assertNotEquals(eventInfo, eventInfo2);
  }

  /**
   * Test {@link EventInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EventInfo.equals(Object)", "int EventInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EventInfo eventInfo = new EventInfo();

    EventInfo eventInfo2 = new EventInfo();
    eventInfo2.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(eventInfo, eventInfo2);
  }

  /**
   * Test {@link EventInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EventInfo.equals(Object)", "int EventInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EventInfo(), null);
  }

  /**
   * Test {@link EventInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EventInfo.equals(Object)", "int EventInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EventInfo(), "Different type to EventInfo");
  }
}
