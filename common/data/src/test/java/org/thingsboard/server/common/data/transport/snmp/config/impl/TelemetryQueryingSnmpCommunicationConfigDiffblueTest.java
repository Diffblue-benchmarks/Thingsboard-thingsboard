package org.thingsboard.server.common.data.transport.snmp.config.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.DataType;
import org.thingsboard.server.common.data.transport.snmp.SnmpCommunicationSpec;
import org.thingsboard.server.common.data.transport.snmp.SnmpMapping;

class TelemetryQueryingSnmpCommunicationConfigDiffblueTest {
  /**
   * Test {@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}, and {@link TelemetryQueryingSnmpCommunicationConfig#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}
   *   <li>{@link TelemetryQueryingSnmpCommunicationConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryQueryingSnmpCommunicationConfig.equals(Object)",
      "int TelemetryQueryingSnmpCommunicationConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig = new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());
    telemetryQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig2 = new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig2.setMappings(new ArrayList<>());
    telemetryQueryingSnmpCommunicationConfig2.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertEquals(telemetryQueryingSnmpCommunicationConfig, telemetryQueryingSnmpCommunicationConfig2);
    int expectedHashCodeResult = telemetryQueryingSnmpCommunicationConfig.hashCode();
    assertEquals(expectedHashCodeResult, telemetryQueryingSnmpCommunicationConfig2.hashCode());
  }

  /**
   * Test {@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}, and {@link TelemetryQueryingSnmpCommunicationConfig#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}
   *   <li>{@link TelemetryQueryingSnmpCommunicationConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryQueryingSnmpCommunicationConfig.equals(Object)",
      "int TelemetryQueryingSnmpCommunicationConfig.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig = new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());
    telemetryQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertEquals(telemetryQueryingSnmpCommunicationConfig, telemetryQueryingSnmpCommunicationConfig);
    int expectedHashCodeResult = telemetryQueryingSnmpCommunicationConfig.hashCode();
    assertEquals(expectedHashCodeResult, telemetryQueryingSnmpCommunicationConfig.hashCode());
  }

  /**
   * Test {@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryQueryingSnmpCommunicationConfig.equals(Object)",
      "int TelemetryQueryingSnmpCommunicationConfig.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<SnmpMapping> mappings = new ArrayList<>();
    mappings.add(new SnmpMapping("Oid", "Key", DataType.BOOLEAN));

    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig = new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig.setMappings(mappings);
    telemetryQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig2 = new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig2.setMappings(new ArrayList<>());
    telemetryQueryingSnmpCommunicationConfig2.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertNotEquals(telemetryQueryingSnmpCommunicationConfig, telemetryQueryingSnmpCommunicationConfig2);
  }

  /**
   * Test {@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryQueryingSnmpCommunicationConfig.equals(Object)",
      "int TelemetryQueryingSnmpCommunicationConfig.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig = new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());
    telemetryQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertNotEquals(telemetryQueryingSnmpCommunicationConfig, null);
  }

  /**
   * Test {@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryQueryingSnmpCommunicationConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryQueryingSnmpCommunicationConfig.equals(Object)",
      "int TelemetryQueryingSnmpCommunicationConfig.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TelemetryQueryingSnmpCommunicationConfig telemetryQueryingSnmpCommunicationConfig = new TelemetryQueryingSnmpCommunicationConfig();
    telemetryQueryingSnmpCommunicationConfig.setMappings(new ArrayList<>());
    telemetryQueryingSnmpCommunicationConfig.setQueryingFrequencyMs(1L);

    // Act and Assert
    assertNotEquals(telemetryQueryingSnmpCommunicationConfig,
        "Different type to TelemetryQueryingSnmpCommunicationConfig");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link TelemetryQueryingSnmpCommunicationConfig}
   *   <li>{@link TelemetryQueryingSnmpCommunicationConfig#toString()}
   *   <li>{@link TelemetryQueryingSnmpCommunicationConfig#getSpec()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TelemetryQueryingSnmpCommunicationConfig.<init>()",
      "SnmpCommunicationSpec TelemetryQueryingSnmpCommunicationConfig.getSpec()",
      "String TelemetryQueryingSnmpCommunicationConfig.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TelemetryQueryingSnmpCommunicationConfig actualTelemetryQueryingSnmpCommunicationConfig = new TelemetryQueryingSnmpCommunicationConfig();
    String actualToStringResult = actualTelemetryQueryingSnmpCommunicationConfig.toString();
    SnmpCommunicationSpec actualSpec = actualTelemetryQueryingSnmpCommunicationConfig.getSpec();

    // Assert
    assertEquals("TelemetryQueryingSnmpCommunicationConfig()", actualToStringResult);
    assertNull(actualTelemetryQueryingSnmpCommunicationConfig.getQueryingFrequencyMs());
    assertNull(actualTelemetryQueryingSnmpCommunicationConfig.getAllMappings());
    assertNull(actualTelemetryQueryingSnmpCommunicationConfig.getMappings());
    assertEquals(SnmpCommunicationSpec.TELEMETRY_QUERYING, actualSpec);
  }
}
