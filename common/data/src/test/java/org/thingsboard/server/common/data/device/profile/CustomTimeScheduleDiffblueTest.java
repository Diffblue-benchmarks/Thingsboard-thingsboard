package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.query.DynamicValue;
import org.thingsboard.server.common.data.query.DynamicValueSourceType;

class CustomTimeScheduleDiffblueTest {
  /**
   * Test {@link CustomTimeSchedule#equals(Object)}, and {@link CustomTimeSchedule#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomTimeSchedule#equals(Object)}
   *   <li>{@link CustomTimeSchedule#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomTimeSchedule.equals(Object)", "int CustomTimeSchedule.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule.setItems(new ArrayList<>());
    customTimeSchedule.setTimezone("UTC");

    CustomTimeSchedule customTimeSchedule2 = new CustomTimeSchedule();
    customTimeSchedule2.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule2.setItems(new ArrayList<>());
    customTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertEquals(customTimeSchedule, customTimeSchedule2);
    int expectedHashCodeResult = customTimeSchedule.hashCode();
    assertEquals(expectedHashCodeResult, customTimeSchedule2.hashCode());
  }

  /**
   * Test {@link CustomTimeSchedule#equals(Object)}, and {@link CustomTimeSchedule#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomTimeSchedule#equals(Object)}
   *   <li>{@link CustomTimeSchedule#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomTimeSchedule.equals(Object)", "int CustomTimeSchedule.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(null);
    customTimeSchedule.setItems(new ArrayList<>());
    customTimeSchedule.setTimezone("UTC");

    CustomTimeSchedule customTimeSchedule2 = new CustomTimeSchedule();
    customTimeSchedule2.setDynamicValue(null);
    customTimeSchedule2.setItems(new ArrayList<>());
    customTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertEquals(customTimeSchedule, customTimeSchedule2);
    int expectedHashCodeResult = customTimeSchedule.hashCode();
    assertEquals(expectedHashCodeResult, customTimeSchedule2.hashCode());
  }

  /**
   * Test {@link CustomTimeSchedule#equals(Object)}, and {@link CustomTimeSchedule#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomTimeSchedule#equals(Object)}
   *   <li>{@link CustomTimeSchedule#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomTimeSchedule.equals(Object)", "int CustomTimeSchedule.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule.setItems(new ArrayList<>());
    customTimeSchedule.setTimezone(null);

    CustomTimeSchedule customTimeSchedule2 = new CustomTimeSchedule();
    customTimeSchedule2.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule2.setItems(new ArrayList<>());
    customTimeSchedule2.setTimezone(null);

    // Act and Assert
    assertEquals(customTimeSchedule, customTimeSchedule2);
    int expectedHashCodeResult = customTimeSchedule.hashCode();
    assertEquals(expectedHashCodeResult, customTimeSchedule2.hashCode());
  }

  /**
   * Test {@link CustomTimeSchedule#equals(Object)}, and {@link CustomTimeSchedule#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CustomTimeSchedule#equals(Object)}
   *   <li>{@link CustomTimeSchedule#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomTimeSchedule.equals(Object)", "int CustomTimeSchedule.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule.setItems(new ArrayList<>());
    customTimeSchedule.setTimezone("UTC");

    // Act and Assert
    assertEquals(customTimeSchedule, customTimeSchedule);
    int expectedHashCodeResult = customTimeSchedule.hashCode();
    assertEquals(expectedHashCodeResult, customTimeSchedule.hashCode());
  }

  /**
   * Test {@link CustomTimeSchedule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomTimeSchedule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomTimeSchedule.equals(Object)", "int CustomTimeSchedule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(new DynamicValue<>(null, "Source Attribute"));
    customTimeSchedule.setItems(new ArrayList<>());
    customTimeSchedule.setTimezone("UTC");

    CustomTimeSchedule customTimeSchedule2 = new CustomTimeSchedule();
    customTimeSchedule2.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule2.setItems(new ArrayList<>());
    customTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(customTimeSchedule, customTimeSchedule2);
  }

  /**
   * Test {@link CustomTimeSchedule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomTimeSchedule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomTimeSchedule.equals(Object)", "int CustomTimeSchedule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(null);
    customTimeSchedule.setItems(new ArrayList<>());
    customTimeSchedule.setTimezone("UTC");

    CustomTimeSchedule customTimeSchedule2 = new CustomTimeSchedule();
    customTimeSchedule2.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule2.setItems(new ArrayList<>());
    customTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(customTimeSchedule, customTimeSchedule2);
  }

  /**
   * Test {@link CustomTimeSchedule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomTimeSchedule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomTimeSchedule.equals(Object)", "int CustomTimeSchedule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CustomTimeScheduleItem customTimeScheduleItem = new CustomTimeScheduleItem();
    customTimeScheduleItem.setDayOfWeek(1);
    customTimeScheduleItem.setEnabled(true);
    customTimeScheduleItem.setEndsOn(1L);
    customTimeScheduleItem.setStartsOn(1L);

    ArrayList<CustomTimeScheduleItem> items = new ArrayList<>();
    items.add(customTimeScheduleItem);

    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule.setItems(items);
    customTimeSchedule.setTimezone("UTC");

    CustomTimeSchedule customTimeSchedule2 = new CustomTimeSchedule();
    customTimeSchedule2.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule2.setItems(new ArrayList<>());
    customTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(customTimeSchedule, customTimeSchedule2);
  }

  /**
   * Test {@link CustomTimeSchedule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomTimeSchedule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomTimeSchedule.equals(Object)", "int CustomTimeSchedule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule.setItems(new ArrayList<>());
    customTimeSchedule.setTimezone(System.getProperty("user.timezone"));

    CustomTimeSchedule customTimeSchedule2 = new CustomTimeSchedule();
    customTimeSchedule2.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule2.setItems(new ArrayList<>());
    customTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(customTimeSchedule, customTimeSchedule2);
  }

  /**
   * Test {@link CustomTimeSchedule#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomTimeSchedule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomTimeSchedule.equals(Object)", "int CustomTimeSchedule.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule.setItems(new ArrayList<>());
    customTimeSchedule.setTimezone(null);

    CustomTimeSchedule customTimeSchedule2 = new CustomTimeSchedule();
    customTimeSchedule2.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule2.setItems(new ArrayList<>());
    customTimeSchedule2.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(customTimeSchedule, customTimeSchedule2);
  }

  /**
   * Test {@link CustomTimeSchedule#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomTimeSchedule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomTimeSchedule.equals(Object)", "int CustomTimeSchedule.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule.setItems(new ArrayList<>());
    customTimeSchedule.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(customTimeSchedule, null);
  }

  /**
   * Test {@link CustomTimeSchedule#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CustomTimeSchedule#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean CustomTimeSchedule.equals(Object)", "int CustomTimeSchedule.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    CustomTimeSchedule customTimeSchedule = new CustomTimeSchedule();
    customTimeSchedule.setDynamicValue(new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute"));
    customTimeSchedule.setItems(new ArrayList<>());
    customTimeSchedule.setTimezone("UTC");

    // Act and Assert
    assertNotEquals(customTimeSchedule, "Different type to CustomTimeSchedule");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link CustomTimeSchedule}
   *   <li>{@link CustomTimeSchedule#setDynamicValue(DynamicValue)}
   *   <li>{@link CustomTimeSchedule#setItems(List)}
   *   <li>{@link CustomTimeSchedule#setTimezone(String)}
   *   <li>{@link CustomTimeSchedule#toString()}
   *   <li>{@link CustomTimeSchedule#getDynamicValue()}
   *   <li>{@link CustomTimeSchedule#getItems()}
   *   <li>{@link CustomTimeSchedule#getTimezone()}
   *   <li>{@link CustomTimeSchedule#getType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void CustomTimeSchedule.<init>()", "DynamicValue CustomTimeSchedule.getDynamicValue()",
      "List CustomTimeSchedule.getItems()", "String CustomTimeSchedule.getTimezone()",
      "AlarmScheduleType CustomTimeSchedule.getType()", "void CustomTimeSchedule.setDynamicValue(DynamicValue)",
      "void CustomTimeSchedule.setItems(List)", "void CustomTimeSchedule.setTimezone(String)",
      "String CustomTimeSchedule.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    CustomTimeSchedule actualCustomTimeSchedule = new CustomTimeSchedule();
    DynamicValue<String> dynamicValue = new DynamicValue<>(DynamicValueSourceType.CURRENT_TENANT, "Source Attribute");

    actualCustomTimeSchedule.setDynamicValue(dynamicValue);
    ArrayList<CustomTimeScheduleItem> items = new ArrayList<>();
    actualCustomTimeSchedule.setItems(items);
    actualCustomTimeSchedule.setTimezone("UTC");
    String actualToStringResult = actualCustomTimeSchedule.toString();
    DynamicValue<String> actualDynamicValue = actualCustomTimeSchedule.getDynamicValue();
    List<CustomTimeScheduleItem> actualItems = actualCustomTimeSchedule.getItems();
    String actualTimezone = actualCustomTimeSchedule.getTimezone();

    // Assert
    assertEquals("CustomTimeSchedule(timezone=UTC, items=[], dynamicValue=DynamicValue(resolvedValue=null, sourceType"
        + "=CURRENT_TENANT, sourceAttribute=Source Attribute, inherit=false))", actualToStringResult);
    assertEquals("UTC", actualTimezone);
    assertEquals(AlarmScheduleType.CUSTOM, actualCustomTimeSchedule.getType());
    assertTrue(actualItems.isEmpty());
    assertSame(items, actualItems);
    assertSame(dynamicValue, actualDynamicValue);
  }
}
