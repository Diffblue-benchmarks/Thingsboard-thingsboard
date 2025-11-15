/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.data.device.profile.lwm2m;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TelemetryMappingConfigurationDiffblueTest {
  /**
   * Test {@link TelemetryMappingConfiguration#equals(Object)}, and {@link TelemetryMappingConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TelemetryMappingConfiguration#equals(Object)}
   *   <li>{@link TelemetryMappingConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryMappingConfiguration.equals(Object)",
      "int TelemetryMappingConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TelemetryMappingConfiguration telemetryMappingConfiguration = new TelemetryMappingConfiguration();
    TelemetryMappingConfiguration telemetryMappingConfiguration2 = new TelemetryMappingConfiguration();

    // Act and Assert
    assertEquals(telemetryMappingConfiguration, telemetryMappingConfiguration2);
    int expectedHashCodeResult = telemetryMappingConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, telemetryMappingConfiguration2.hashCode());
  }

  /**
   * Test {@link TelemetryMappingConfiguration#equals(Object)}, and {@link TelemetryMappingConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TelemetryMappingConfiguration#equals(Object)}
   *   <li>{@link TelemetryMappingConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryMappingConfiguration.equals(Object)",
      "int TelemetryMappingConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();
    TelemetryMappingConfiguration telemetryMappingConfiguration = new TelemetryMappingConfiguration(keyName, observe,
        attribute, telemetry, new HashMap<>());
    HashMap<String, String> keyName2 = new HashMap<>();
    HashSet<String> observe2 = new HashSet<>();
    HashSet<String> attribute2 = new HashSet<>();
    HashSet<String> telemetry2 = new HashSet<>();
    TelemetryMappingConfiguration telemetryMappingConfiguration2 = new TelemetryMappingConfiguration(keyName2, observe2,
        attribute2, telemetry2, new HashMap<>());

    // Act and Assert
    assertEquals(telemetryMappingConfiguration, telemetryMappingConfiguration2);
    int expectedHashCodeResult = telemetryMappingConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, telemetryMappingConfiguration2.hashCode());
  }

  /**
   * Test {@link TelemetryMappingConfiguration#equals(Object)}, and {@link TelemetryMappingConfiguration#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TelemetryMappingConfiguration#equals(Object)}
   *   <li>{@link TelemetryMappingConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryMappingConfiguration.equals(Object)",
      "int TelemetryMappingConfiguration.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TelemetryMappingConfiguration telemetryMappingConfiguration = new TelemetryMappingConfiguration();

    // Act and Assert
    assertEquals(telemetryMappingConfiguration, telemetryMappingConfiguration);
    int expectedHashCodeResult = telemetryMappingConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, telemetryMappingConfiguration.hashCode());
  }

  /**
   * Test {@link TelemetryMappingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryMappingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryMappingConfiguration.equals(Object)",
      "int TelemetryMappingConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();
    TelemetryMappingConfiguration telemetryMappingConfiguration = new TelemetryMappingConfiguration(keyName, observe,
        attribute, telemetry, new HashMap<>());

    // Act and Assert
    assertNotEquals(telemetryMappingConfiguration, new TelemetryMappingConfiguration());
  }

  /**
   * Test {@link TelemetryMappingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryMappingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryMappingConfiguration.equals(Object)",
      "int TelemetryMappingConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TelemetryMappingConfiguration telemetryMappingConfiguration = new TelemetryMappingConfiguration();
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();

    // Act and Assert
    assertNotEquals(telemetryMappingConfiguration,
        new TelemetryMappingConfiguration(keyName, observe, attribute, telemetry, new HashMap<>()));
  }

  /**
   * Test {@link TelemetryMappingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryMappingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryMappingConfiguration.equals(Object)",
      "int TelemetryMappingConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TelemetryMappingConfiguration telemetryMappingConfiguration = new TelemetryMappingConfiguration();
    telemetryMappingConfiguration.setObserve(new HashSet<>());

    // Act and Assert
    assertNotEquals(telemetryMappingConfiguration, new TelemetryMappingConfiguration());
  }

  /**
   * Test {@link TelemetryMappingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryMappingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryMappingConfiguration.equals(Object)",
      "int TelemetryMappingConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TelemetryMappingConfiguration telemetryMappingConfiguration = new TelemetryMappingConfiguration();
    telemetryMappingConfiguration.setAttribute(new HashSet<>());

    // Act and Assert
    assertNotEquals(telemetryMappingConfiguration, new TelemetryMappingConfiguration());
  }

  /**
   * Test {@link TelemetryMappingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryMappingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryMappingConfiguration.equals(Object)",
      "int TelemetryMappingConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TelemetryMappingConfiguration telemetryMappingConfiguration = new TelemetryMappingConfiguration();
    telemetryMappingConfiguration.setTelemetry(new HashSet<>());

    // Act and Assert
    assertNotEquals(telemetryMappingConfiguration, new TelemetryMappingConfiguration());
  }

  /**
   * Test {@link TelemetryMappingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryMappingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryMappingConfiguration.equals(Object)",
      "int TelemetryMappingConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TelemetryMappingConfiguration telemetryMappingConfiguration = new TelemetryMappingConfiguration();
    telemetryMappingConfiguration.setAttributeLwm2m(new HashMap<>());

    // Act and Assert
    assertNotEquals(telemetryMappingConfiguration, new TelemetryMappingConfiguration());
  }

  /**
   * Test {@link TelemetryMappingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryMappingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryMappingConfiguration.equals(Object)",
      "int TelemetryMappingConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    TelemetryMappingConfiguration telemetryMappingConfiguration = new TelemetryMappingConfiguration();

    TelemetryMappingConfiguration telemetryMappingConfiguration2 = new TelemetryMappingConfiguration();
    telemetryMappingConfiguration2.setObserve(new HashSet<>());

    // Act and Assert
    assertNotEquals(telemetryMappingConfiguration, telemetryMappingConfiguration2);
  }

  /**
   * Test {@link TelemetryMappingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryMappingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryMappingConfiguration.equals(Object)",
      "int TelemetryMappingConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    TelemetryMappingConfiguration telemetryMappingConfiguration = new TelemetryMappingConfiguration();

    TelemetryMappingConfiguration telemetryMappingConfiguration2 = new TelemetryMappingConfiguration();
    telemetryMappingConfiguration2.setAttribute(new HashSet<>());

    // Act and Assert
    assertNotEquals(telemetryMappingConfiguration, telemetryMappingConfiguration2);
  }

  /**
   * Test {@link TelemetryMappingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryMappingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryMappingConfiguration.equals(Object)",
      "int TelemetryMappingConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    TelemetryMappingConfiguration telemetryMappingConfiguration = new TelemetryMappingConfiguration();

    TelemetryMappingConfiguration telemetryMappingConfiguration2 = new TelemetryMappingConfiguration();
    telemetryMappingConfiguration2.setTelemetry(new HashSet<>());

    // Act and Assert
    assertNotEquals(telemetryMappingConfiguration, telemetryMappingConfiguration2);
  }

  /**
   * Test {@link TelemetryMappingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryMappingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryMappingConfiguration.equals(Object)",
      "int TelemetryMappingConfiguration.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    TelemetryMappingConfiguration telemetryMappingConfiguration = new TelemetryMappingConfiguration();

    TelemetryMappingConfiguration telemetryMappingConfiguration2 = new TelemetryMappingConfiguration();
    telemetryMappingConfiguration2.setAttributeLwm2m(new HashMap<>());

    // Act and Assert
    assertNotEquals(telemetryMappingConfiguration, telemetryMappingConfiguration2);
  }

  /**
   * Test {@link TelemetryMappingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryMappingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryMappingConfiguration.equals(Object)",
      "int TelemetryMappingConfiguration.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TelemetryMappingConfiguration(), null);
  }

  /**
   * Test {@link TelemetryMappingConfiguration#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TelemetryMappingConfiguration#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TelemetryMappingConfiguration.equals(Object)",
      "int TelemetryMappingConfiguration.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TelemetryMappingConfiguration(), "Different type to TelemetryMappingConfiguration");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TelemetryMappingConfiguration#TelemetryMappingConfiguration()}
   *   <li>{@link TelemetryMappingConfiguration#setAttribute(Set)}
   *   <li>{@link TelemetryMappingConfiguration#setAttributeLwm2m(Map)}
   *   <li>{@link TelemetryMappingConfiguration#setKeyName(Map)}
   *   <li>{@link TelemetryMappingConfiguration#setObserve(Set)}
   *   <li>{@link TelemetryMappingConfiguration#setTelemetry(Set)}
   *   <li>{@link TelemetryMappingConfiguration#toString()}
   *   <li>{@link TelemetryMappingConfiguration#getAttribute()}
   *   <li>{@link TelemetryMappingConfiguration#getAttributeLwm2m()}
   *   <li>{@link TelemetryMappingConfiguration#getKeyName()}
   *   <li>{@link TelemetryMappingConfiguration#getObserve()}
   *   <li>{@link TelemetryMappingConfiguration#getTelemetry()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TelemetryMappingConfiguration.<init>()",
      "void TelemetryMappingConfiguration.<init>(Map, Set, Set, Set, Map)",
      "Set TelemetryMappingConfiguration.getAttribute()", "Map TelemetryMappingConfiguration.getAttributeLwm2m()",
      "Map TelemetryMappingConfiguration.getKeyName()", "Set TelemetryMappingConfiguration.getObserve()",
      "Set TelemetryMappingConfiguration.getTelemetry()", "void TelemetryMappingConfiguration.setAttribute(Set)",
      "void TelemetryMappingConfiguration.setAttributeLwm2m(Map)", "void TelemetryMappingConfiguration.setKeyName(Map)",
      "void TelemetryMappingConfiguration.setObserve(Set)", "void TelemetryMappingConfiguration.setTelemetry(Set)",
      "String TelemetryMappingConfiguration.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    TelemetryMappingConfiguration actualTelemetryMappingConfiguration = new TelemetryMappingConfiguration();
    HashSet<String> attribute = new HashSet<>();
    actualTelemetryMappingConfiguration.setAttribute(attribute);
    HashMap<String, ObjectAttributes> attributeLwm2m = new HashMap<>();
    actualTelemetryMappingConfiguration.setAttributeLwm2m(attributeLwm2m);
    HashMap<String, String> keyName = new HashMap<>();
    actualTelemetryMappingConfiguration.setKeyName(keyName);
    HashSet<String> observe = new HashSet<>();
    actualTelemetryMappingConfiguration.setObserve(observe);
    HashSet<String> telemetry = new HashSet<>();
    actualTelemetryMappingConfiguration.setTelemetry(telemetry);
    String actualToStringResult = actualTelemetryMappingConfiguration.toString();
    Set<String> actualAttribute = actualTelemetryMappingConfiguration.getAttribute();
    Map<String, ObjectAttributes> actualAttributeLwm2m = actualTelemetryMappingConfiguration.getAttributeLwm2m();
    Map<String, String> actualKeyName = actualTelemetryMappingConfiguration.getKeyName();
    Set<String> actualObserve = actualTelemetryMappingConfiguration.getObserve();
    Set<String> actualTelemetry = actualTelemetryMappingConfiguration.getTelemetry();

    // Assert
    assertEquals("TelemetryMappingConfiguration(keyName={}, observe=[], attribute=[], telemetry=[], attributeLwm2m={})",
        actualToStringResult);
    assertTrue(actualAttributeLwm2m.isEmpty());
    assertTrue(actualKeyName.isEmpty());
    assertTrue(actualAttribute.isEmpty());
    assertTrue(actualObserve.isEmpty());
    assertTrue(actualTelemetry.isEmpty());
    assertSame(attributeLwm2m, actualAttributeLwm2m);
    assertSame(keyName, actualKeyName);
    assertSame(attribute, actualAttribute);
    assertSame(observe, actualObserve);
    assertSame(telemetry, actualTelemetry);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TelemetryMappingConfiguration#TelemetryMappingConfiguration(Map, Set, Set, Set, Map)}
   *   <li>{@link TelemetryMappingConfiguration#setAttribute(Set)}
   *   <li>{@link TelemetryMappingConfiguration#setAttributeLwm2m(Map)}
   *   <li>{@link TelemetryMappingConfiguration#setKeyName(Map)}
   *   <li>{@link TelemetryMappingConfiguration#setObserve(Set)}
   *   <li>{@link TelemetryMappingConfiguration#setTelemetry(Set)}
   *   <li>{@link TelemetryMappingConfiguration#toString()}
   *   <li>{@link TelemetryMappingConfiguration#getAttribute()}
   *   <li>{@link TelemetryMappingConfiguration#getAttributeLwm2m()}
   *   <li>{@link TelemetryMappingConfiguration#getKeyName()}
   *   <li>{@link TelemetryMappingConfiguration#getObserve()}
   *   <li>{@link TelemetryMappingConfiguration#getTelemetry()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when HashMap()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TelemetryMappingConfiguration.<init>()",
      "void TelemetryMappingConfiguration.<init>(Map, Set, Set, Set, Map)",
      "Set TelemetryMappingConfiguration.getAttribute()", "Map TelemetryMappingConfiguration.getAttributeLwm2m()",
      "Map TelemetryMappingConfiguration.getKeyName()", "Set TelemetryMappingConfiguration.getObserve()",
      "Set TelemetryMappingConfiguration.getTelemetry()", "void TelemetryMappingConfiguration.setAttribute(Set)",
      "void TelemetryMappingConfiguration.setAttributeLwm2m(Map)", "void TelemetryMappingConfiguration.setKeyName(Map)",
      "void TelemetryMappingConfiguration.setObserve(Set)", "void TelemetryMappingConfiguration.setTelemetry(Set)",
      "String TelemetryMappingConfiguration.toString()"})
  void testGettersAndSetters_whenHashMap() {
    // Arrange
    HashMap<String, String> keyName = new HashMap<>();
    HashSet<String> observe = new HashSet<>();
    HashSet<String> attribute = new HashSet<>();
    HashSet<String> telemetry = new HashSet<>();

    // Act
    TelemetryMappingConfiguration actualTelemetryMappingConfiguration = new TelemetryMappingConfiguration(keyName,
        observe, attribute, telemetry, new HashMap<>());
    HashSet<String> attribute2 = new HashSet<>();
    actualTelemetryMappingConfiguration.setAttribute(attribute2);
    HashMap<String, ObjectAttributes> attributeLwm2m = new HashMap<>();
    actualTelemetryMappingConfiguration.setAttributeLwm2m(attributeLwm2m);
    HashMap<String, String> keyName2 = new HashMap<>();
    actualTelemetryMappingConfiguration.setKeyName(keyName2);
    HashSet<String> observe2 = new HashSet<>();
    actualTelemetryMappingConfiguration.setObserve(observe2);
    HashSet<String> telemetry2 = new HashSet<>();
    actualTelemetryMappingConfiguration.setTelemetry(telemetry2);
    String actualToStringResult = actualTelemetryMappingConfiguration.toString();
    Set<String> actualAttribute = actualTelemetryMappingConfiguration.getAttribute();
    Map<String, ObjectAttributes> actualAttributeLwm2m = actualTelemetryMappingConfiguration.getAttributeLwm2m();
    Map<String, String> actualKeyName = actualTelemetryMappingConfiguration.getKeyName();
    Set<String> actualObserve = actualTelemetryMappingConfiguration.getObserve();
    Set<String> actualTelemetry = actualTelemetryMappingConfiguration.getTelemetry();

    // Assert
    assertEquals("TelemetryMappingConfiguration(keyName={}, observe=[], attribute=[], telemetry=[], attributeLwm2m={})",
        actualToStringResult);
    assertTrue(actualAttributeLwm2m.isEmpty());
    assertTrue(actualKeyName.isEmpty());
    assertTrue(actualAttribute.isEmpty());
    assertTrue(actualObserve.isEmpty());
    assertTrue(actualTelemetry.isEmpty());
    assertSame(attributeLwm2m, actualAttributeLwm2m);
    assertSame(keyName2, actualKeyName);
    assertSame(attribute2, actualAttribute);
    assertSame(observe2, actualObserve);
    assertSame(telemetry2, actualTelemetry);
  }
}
