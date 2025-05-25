package org.thingsboard.server.service.telemetry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AttributeDataDiffblueTest {
  /**
   * Test {@link AttributeData#AttributeData(long, String, Object)}.
   * <p>
   * Method under test: {@link AttributeData#AttributeData(long, String, Object)}
   */
  @Test
  @DisplayName("Test new AttributeData(long, String, Object)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AttributeData.<init>(long, String, Object)"})
  void testNewAttributeData() {
    // Arrange and Act
    AttributeData actualAttributeData = new AttributeData(1L, "Key", "Value");

    // Assert
    assertEquals("Key", actualAttributeData.getKey());
    assertEquals("Value", actualAttributeData.getValue());
    assertEquals(1L, actualAttributeData.getLastUpdateTs());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AttributeData#getKey()}
   *   <li>{@link AttributeData#getLastUpdateTs()}
   *   <li>{@link AttributeData#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AttributeData.getKey()", "long AttributeData.getLastUpdateTs()",
      "Object AttributeData.getValue()"})
  void testGettersAndSetters() {
    // Arrange
    AttributeData attributeData = new AttributeData(1L, "Key", "Value");

    // Act
    String actualKey = attributeData.getKey();
    long actualLastUpdateTs = attributeData.getLastUpdateTs();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals("Value", attributeData.getValue());
    assertEquals(1L, actualLastUpdateTs);
  }

  /**
   * Test {@link AttributeData#compareTo(AttributeData)} with {@code AttributeData}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link AttributeData#compareTo(AttributeData)}
   */
  @Test
  @DisplayName("Test compareTo(AttributeData) with 'AttributeData'; then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int AttributeData.compareTo(AttributeData)"})
  void testCompareToWithAttributeData_thenReturnZero() {
    // Arrange
    AttributeData attributeData = new AttributeData(1L, "Key", "Value");

    // Act and Assert
    assertEquals(0, attributeData.compareTo(new AttributeData(1L, "Key", "Value")));
  }
}
