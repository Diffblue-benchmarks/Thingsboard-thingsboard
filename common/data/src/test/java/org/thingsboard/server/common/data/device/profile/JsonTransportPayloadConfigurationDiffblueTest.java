package org.thingsboard.server.common.data.device.profile;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.TransportPayloadType;

class JsonTransportPayloadConfigurationDiffblueTest {
  /**
   * Test {@link JsonTransportPayloadConfiguration#equals(Object)}, and {@link
   * JsonTransportPayloadConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JsonTransportPayloadConfiguration#equals(Object)}
   *   <li>{@link JsonTransportPayloadConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonTransportPayloadConfiguration.equals(Object)",
    "int JsonTransportPayloadConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsonTransportPayloadConfiguration jsonTransportPayloadConfiguration =
        new JsonTransportPayloadConfiguration();
    JsonTransportPayloadConfiguration jsonTransportPayloadConfiguration2 =
        new JsonTransportPayloadConfiguration();

    // Act and Assert
    assertEquals(jsonTransportPayloadConfiguration, jsonTransportPayloadConfiguration2);
    assertEquals(
        jsonTransportPayloadConfiguration.hashCode(),
        jsonTransportPayloadConfiguration2.hashCode());
  }

  /**
   * Test {@link JsonTransportPayloadConfiguration#equals(Object)}, and {@link
   * JsonTransportPayloadConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JsonTransportPayloadConfiguration#equals(Object)}
   *   <li>{@link JsonTransportPayloadConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonTransportPayloadConfiguration.equals(Object)",
    "int JsonTransportPayloadConfiguration.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsonTransportPayloadConfiguration jsonTransportPayloadConfiguration =
        new JsonTransportPayloadConfiguration();

    // Act and Assert
    assertEquals(jsonTransportPayloadConfiguration, jsonTransportPayloadConfiguration);
    int expectedHashCodeResult = jsonTransportPayloadConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, jsonTransportPayloadConfiguration.hashCode());
  }

  /**
   * Test {@link JsonTransportPayloadConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JsonTransportPayloadConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonTransportPayloadConfiguration.equals(Object)",
    "int JsonTransportPayloadConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonTransportPayloadConfiguration(), null);
  }

  /**
   * Test {@link JsonTransportPayloadConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JsonTransportPayloadConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonTransportPayloadConfiguration.equals(Object)",
    "int JsonTransportPayloadConfiguration.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new JsonTransportPayloadConfiguration(),
        "Different type to JsonTransportPayloadConfiguration");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link JsonTransportPayloadConfiguration}
   *   <li>{@link JsonTransportPayloadConfiguration#toString()}
   *   <li>{@link JsonTransportPayloadConfiguration#getTransportPayloadType()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void JsonTransportPayloadConfiguration.<init>()",
    "TransportPayloadType JsonTransportPayloadConfiguration.getTransportPayloadType()",
    "String JsonTransportPayloadConfiguration.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    JsonTransportPayloadConfiguration actualJsonTransportPayloadConfiguration =
        new JsonTransportPayloadConfiguration();
    String actualToStringResult = actualJsonTransportPayloadConfiguration.toString();

    // Assert
    assertEquals("JsonTransportPayloadConfiguration()", actualToStringResult);
    assertEquals(
        TransportPayloadType.JSON,
        actualJsonTransportPayloadConfiguration.getTransportPayloadType());
  }
}
