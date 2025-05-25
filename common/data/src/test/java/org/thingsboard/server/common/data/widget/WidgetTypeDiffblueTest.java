package org.thingsboard.server.common.data.widget;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.WidgetTypeId;

class WidgetTypeDiffblueTest {
  /**
   * Test {@link WidgetType#equals(Object)}, and {@link WidgetType#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetType#equals(Object)}
   *   <li>{@link WidgetType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WidgetType.equals(Object)", "int WidgetType.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetType widgetType = new WidgetType();
    WidgetType widgetType2 = new WidgetType();

    // Act and Assert
    assertEquals(widgetType, widgetType2);
    int expectedHashCodeResult = widgetType.hashCode();
    assertEquals(expectedHashCodeResult, widgetType2.hashCode());
  }

  /**
   * Test {@link WidgetType#equals(Object)}, and {@link WidgetType#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetType#equals(Object)}
   *   <li>{@link WidgetType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WidgetType.equals(Object)", "int WidgetType.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetType widgetType = new WidgetType();

    // Act and Assert
    assertEquals(widgetType, widgetType);
    int expectedHashCodeResult = widgetType.hashCode();
    assertEquals(expectedHashCodeResult, widgetType.hashCode());
  }

  /**
   * Test {@link WidgetType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WidgetType.equals(Object)", "int WidgetType.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();

    // Act and Assert
    assertNotEquals(widgetTypeDetails, new WidgetType());
  }

  /**
   * Test {@link WidgetType#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WidgetType.equals(Object)", "int WidgetType.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetType widgetType = new WidgetType();

    // Act and Assert
    assertNotEquals(widgetType, new WidgetTypeDetails());
  }

  /**
   * Test {@link WidgetType#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WidgetType.equals(Object)", "int WidgetType.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetType(), null);
  }

  /**
   * Test {@link WidgetType#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean WidgetType.equals(Object)", "int WidgetType.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetType(), "Different type to WidgetType");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetType#WidgetType(WidgetTypeId)}
   *   <li>{@link WidgetType#setDescriptor(JsonNode)}
   *   <li>{@link WidgetType#toString()}
   *   <li>{@link WidgetType#getDescriptor()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetType.<init>()", "void WidgetType.<init>(WidgetTypeId)",
      "JsonNode WidgetType.getDescriptor()", "void WidgetType.setDescriptor(JsonNode)", "String WidgetType.toString()"})
  void testGettersAndSetters() {
    // Arrange
    WidgetTypeId id = new WidgetTypeId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    WidgetType actualWidgetType = new WidgetType(id);
    MissingNode descriptor = MissingNode.getInstance();
    actualWidgetType.setDescriptor(descriptor);
    String actualToStringResult = actualWidgetType.toString();
    JsonNode actualDescriptor = actualWidgetType.getDescriptor();

    // Assert
    assertEquals("WidgetType(descriptor=)", actualToStringResult);
    assertNull(actualWidgetType.getVersion());
    assertNull(actualWidgetType.getFqn());
    assertNull(actualWidgetType.getName());
    assertNull(actualWidgetType.getTenantId());
    assertEquals(0L, actualWidgetType.getCreatedTime());
    assertFalse(actualWidgetType.isDeprecated());
    assertFalse(actualWidgetType.isScada());
    assertSame(id, actualWidgetType.getId());
    assertSame(descriptor, actualDescriptor);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>Then return Id is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetType#WidgetType()}
   *   <li>{@link WidgetType#setDescriptor(JsonNode)}
   *   <li>{@link WidgetType#toString()}
   *   <li>{@link WidgetType#getDescriptor()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return Id is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetType.<init>()", "void WidgetType.<init>(WidgetTypeId)",
      "JsonNode WidgetType.getDescriptor()", "void WidgetType.setDescriptor(JsonNode)", "String WidgetType.toString()"})
  void testGettersAndSetters_thenReturnIdIsNull() {
    // Arrange and Act
    WidgetType actualWidgetType = new WidgetType();
    MissingNode descriptor = MissingNode.getInstance();
    actualWidgetType.setDescriptor(descriptor);
    String actualToStringResult = actualWidgetType.toString();
    JsonNode actualDescriptor = actualWidgetType.getDescriptor();

    // Assert
    assertEquals("WidgetType(descriptor=)", actualToStringResult);
    assertNull(actualWidgetType.getVersion());
    assertNull(actualWidgetType.getFqn());
    assertNull(actualWidgetType.getName());
    assertNull(actualWidgetType.getTenantId());
    assertNull(actualWidgetType.getId());
    assertEquals(0L, actualWidgetType.getCreatedTime());
    assertFalse(actualWidgetType.isDeprecated());
    assertFalse(actualWidgetType.isScada());
    assertSame(descriptor, actualDescriptor);
  }

  /**
   * Test {@link WidgetType#WidgetType(BaseWidgetType)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>Then return Deprecated.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetType#WidgetType(BaseWidgetType)}
   */
  @Test
  @DisplayName("Test new WidgetType(BaseWidgetType); given 'true'; then return Deprecated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetType.<init>(BaseWidgetType)"})
  void testNewWidgetType_givenTrue_thenReturnDeprecated() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();
    baseWidgetType.setDeprecated(true);

    // Act
    WidgetType actualWidgetType = new WidgetType(baseWidgetType);

    // Assert
    assertNull(actualWidgetType.getDescriptor());
    assertNull(actualWidgetType.getVersion());
    assertNull(actualWidgetType.getFqn());
    assertNull(actualWidgetType.getName());
    assertNull(actualWidgetType.getUuidId());
    assertNull(actualWidgetType.getTenantId());
    assertNull(actualWidgetType.getId());
    assertEquals(0L, actualWidgetType.getCreatedTime());
    assertFalse(actualWidgetType.isScada());
    assertTrue(actualWidgetType.isDeprecated());
  }

  /**
   * Test {@link WidgetType#WidgetType(WidgetType)}.
   * <ul>
   *   <li>Given {@code true}.</li>
   *   <li>When {@link WidgetType#WidgetType()} Deprecated is {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetType#WidgetType(WidgetType)}
   */
  @Test
  @DisplayName("Test new WidgetType(WidgetType); given 'true'; when WidgetType() Deprecated is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetType.<init>(WidgetType)"})
  void testNewWidgetType_givenTrue_whenWidgetTypeDeprecatedIsTrue() {
    // Arrange
    WidgetType widgetType = new WidgetType();
    widgetType.setDeprecated(true);

    // Act and Assert
    assertEquals(widgetType, new WidgetType(widgetType));
  }

  /**
   * Test {@link WidgetType#WidgetType(BaseWidgetType)}.
   * <ul>
   *   <li>When {@link BaseWidgetType#BaseWidgetType()}.</li>
   *   <li>Then return not Deprecated.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetType#WidgetType(BaseWidgetType)}
   */
  @Test
  @DisplayName("Test new WidgetType(BaseWidgetType); when BaseWidgetType(); then return not Deprecated")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetType.<init>(BaseWidgetType)"})
  void testNewWidgetType_whenBaseWidgetType_thenReturnNotDeprecated() {
    // Arrange and Act
    WidgetType actualWidgetType = new WidgetType(new BaseWidgetType());

    // Assert
    assertNull(actualWidgetType.getDescriptor());
    assertNull(actualWidgetType.getVersion());
    assertNull(actualWidgetType.getFqn());
    assertNull(actualWidgetType.getName());
    assertNull(actualWidgetType.getUuidId());
    assertNull(actualWidgetType.getTenantId());
    assertNull(actualWidgetType.getId());
    assertEquals(0L, actualWidgetType.getCreatedTime());
    assertFalse(actualWidgetType.isDeprecated());
    assertFalse(actualWidgetType.isScada());
  }

  /**
   * Test {@link WidgetType#WidgetType(WidgetType)}.
   * <ul>
   *   <li>When {@link WidgetType#WidgetType()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetType#WidgetType(WidgetType)}
   */
  @Test
  @DisplayName("Test new WidgetType(WidgetType); when WidgetType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetType.<init>(WidgetType)"})
  void testNewWidgetType_whenWidgetType() {
    // Arrange
    WidgetType widgetType = new WidgetType();

    // Act and Assert
    assertEquals(widgetType, new WidgetType(widgetType));
  }
}
