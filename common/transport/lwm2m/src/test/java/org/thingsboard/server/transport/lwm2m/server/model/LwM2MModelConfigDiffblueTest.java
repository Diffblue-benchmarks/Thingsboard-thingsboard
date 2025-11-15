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
package org.thingsboard.server.transport.lwm2m.server.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.device.profile.lwm2m.ObjectAttributes;

class LwM2MModelConfigDiffblueTest {
  /**
   * Method under test: {@link LwM2MModelConfig#merge(LwM2MModelConfig)}
   */
  @Test
  void testMerge() {
    // Arrange
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig("https://config.us-east-2.amazonaws.com");
    LwM2MModelConfig modelConfig = new LwM2MModelConfig("https://config.us-east-2.amazonaws.com");

    // Act
    lwM2MModelConfig.merge(modelConfig);

    // Assert that nothing has changed
    assertEquals(lwM2MModelConfig, modelConfig);
  }

  /**
   * Method under test: {@link LwM2MModelConfig#merge(LwM2MModelConfig)}
   */
  @Test
  void testMerge2() {
    // Arrange
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig("https://config.us-east-2.amazonaws.com");

    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    HashMap<String, ObjectAttributes> attributesToAdd = new HashMap<>();
    attributesToAdd.put("foo", objectAttributes);

    LwM2MModelConfig modelConfig = new LwM2MModelConfig("https://config.us-east-2.amazonaws.com");
    modelConfig.setAttributesToAdd(attributesToAdd);

    // Act
    lwM2MModelConfig.merge(modelConfig);

    // Assert
    assertEquals(lwM2MModelConfig, modelConfig);
  }

  /**
   * Method under test: {@link LwM2MModelConfig#isEmpty()}
   */
  @Test
  void testIsEmpty() {
    // Arrange, Act and Assert
    assertTrue((new LwM2MModelConfig("https://config.us-east-2.amazonaws.com")).isEmpty());
  }

  /**
   * Method under test: {@link LwM2MModelConfig#isEmpty()}
   */
  @Test
  void testIsEmpty2() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    HashMap<String, ObjectAttributes> attributesToAdd = new HashMap<>();
    attributesToAdd.put("foo", objectAttributes);

    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig();
    lwM2MModelConfig.setAttributesToAdd(attributesToAdd);

    // Act and Assert
    assertFalse(lwM2MModelConfig.isEmpty());
  }

  /**
   * Method under test: {@link LwM2MModelConfig#isEmpty()}
   */
  @Test
  void testIsEmpty3() {
    // Arrange
    ObjectAttributes objectAttributes = new ObjectAttributes();
    objectAttributes.setDim(1L);
    objectAttributes.setEpmax(1L);
    objectAttributes.setEpmin(1L);
    objectAttributes.setGt(10.0d);
    objectAttributes.setLt(10.0d);
    objectAttributes.setLwm2m("Lwm2m");
    objectAttributes.setPmax(1L);
    objectAttributes.setPmin(1L);
    objectAttributes.setSsid(1L);
    objectAttributes.setSt(10.0d);
    objectAttributes.setUri("Uri");
    objectAttributes.setVer("Ver");

    HashMap<String, ObjectAttributes> attributesToAdd = new HashMap<>();
    attributesToAdd.computeIfPresent("foo", mock(BiFunction.class));
    attributesToAdd.put("foo", objectAttributes);

    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig();
    lwM2MModelConfig.setAttributesToAdd(attributesToAdd);

    // Act and Assert
    assertFalse(lwM2MModelConfig.isEmpty());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MModelConfig#equals(Object)}
   *   <li>{@link LwM2MModelConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig("https://config.us-east-2.amazonaws.com");
    LwM2MModelConfig lwM2MModelConfig2 = new LwM2MModelConfig("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertEquals(lwM2MModelConfig, lwM2MModelConfig2);
    int expectedHashCodeResult = lwM2MModelConfig.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MModelConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MModelConfig#equals(Object)}
   *   <li>{@link LwM2MModelConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig(null);
    LwM2MModelConfig lwM2MModelConfig2 = new LwM2MModelConfig(null);

    // Act and Assert
    assertEquals(lwM2MModelConfig, lwM2MModelConfig2);
    int expectedHashCodeResult = lwM2MModelConfig.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MModelConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MModelConfig#equals(Object)}
   *   <li>{@link LwM2MModelConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig();
    LwM2MModelConfig lwM2MModelConfig2 = new LwM2MModelConfig();

    // Act and Assert
    assertEquals(lwM2MModelConfig, lwM2MModelConfig2);
    int expectedHashCodeResult = lwM2MModelConfig.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MModelConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MModelConfig#equals(Object)}
   *   <li>{@link LwM2MModelConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig("https://config.us-east-2.amazonaws.com");

    // Act and Assert
    assertEquals(lwM2MModelConfig, lwM2MModelConfig);
    int expectedHashCodeResult = lwM2MModelConfig.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MModelConfig.hashCode());
  }

  /**
   * Method under test: {@link LwM2MModelConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig("Endpoint");

    // Act and Assert
    assertNotEquals(lwM2MModelConfig, new LwM2MModelConfig("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link LwM2MModelConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig(null);

    // Act and Assert
    assertNotEquals(lwM2MModelConfig, new LwM2MModelConfig("https://config.us-east-2.amazonaws.com"));
  }

  /**
   * Method under test: {@link LwM2MModelConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig(null);

    // Act and Assert
    assertNotEquals(lwM2MModelConfig, new LwM2MModelConfig());
  }

  /**
   * Method under test: {@link LwM2MModelConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig();

    // Act and Assert
    assertNotEquals(lwM2MModelConfig, new LwM2MModelConfig(null));
  }

  /**
   * Method under test: {@link LwM2MModelConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig(null);

    LwM2MModelConfig lwM2MModelConfig2 = new LwM2MModelConfig();
    lwM2MModelConfig2.setAttributesToAdd(new HashMap<>());

    // Act and Assert
    assertNotEquals(lwM2MModelConfig, lwM2MModelConfig2);
  }

  /**
   * Method under test: {@link LwM2MModelConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig();
    lwM2MModelConfig.setAttributesToAdd(new HashMap<>());

    // Act and Assert
    assertNotEquals(lwM2MModelConfig, new LwM2MModelConfig(null));
  }

  /**
   * Method under test: {@link LwM2MModelConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig();
    lwM2MModelConfig.setToObserve(new HashSet<>());

    // Act and Assert
    assertNotEquals(lwM2MModelConfig, new LwM2MModelConfig());
  }

  /**
   * Method under test: {@link LwM2MModelConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig();
    lwM2MModelConfig.setToCancelObserve(new HashSet<>());

    // Act and Assert
    assertNotEquals(lwM2MModelConfig, new LwM2MModelConfig());
  }

  /**
   * Method under test: {@link LwM2MModelConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig();
    lwM2MModelConfig.setToRead(new HashSet<>());

    // Act and Assert
    assertNotEquals(lwM2MModelConfig, new LwM2MModelConfig());
  }

  /**
   * Method under test: {@link LwM2MModelConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig();
    lwM2MModelConfig.setToCancelRead(new HashSet<>());

    // Act and Assert
    assertNotEquals(lwM2MModelConfig, new LwM2MModelConfig());
  }

  /**
   * Method under test: {@link LwM2MModelConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig();

    LwM2MModelConfig lwM2MModelConfig2 = new LwM2MModelConfig();
    lwM2MModelConfig2.setToObserve(new HashSet<>());

    // Act and Assert
    assertNotEquals(lwM2MModelConfig, lwM2MModelConfig2);
  }

  /**
   * Method under test: {@link LwM2MModelConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig();

    LwM2MModelConfig lwM2MModelConfig2 = new LwM2MModelConfig();
    lwM2MModelConfig2.setToCancelObserve(new HashSet<>());

    // Act and Assert
    assertNotEquals(lwM2MModelConfig, lwM2MModelConfig2);
  }

  /**
   * Method under test: {@link LwM2MModelConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig();

    LwM2MModelConfig lwM2MModelConfig2 = new LwM2MModelConfig();
    lwM2MModelConfig2.setToRead(new HashSet<>());

    // Act and Assert
    assertNotEquals(lwM2MModelConfig, lwM2MModelConfig2);
  }

  /**
   * Method under test: {@link LwM2MModelConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig();

    LwM2MModelConfig lwM2MModelConfig2 = new LwM2MModelConfig();
    lwM2MModelConfig2.setToCancelRead(new HashSet<>());

    // Act and Assert
    assertNotEquals(lwM2MModelConfig, lwM2MModelConfig2);
  }

  /**
   * Method under test: {@link LwM2MModelConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    LwM2MModelConfig lwM2MModelConfig = new LwM2MModelConfig(null);

    HashMap<String, ObjectAttributes> attributesToAdd = new HashMap<>();
    attributesToAdd.computeIfPresent("foo", mock(BiFunction.class));

    LwM2MModelConfig lwM2MModelConfig2 = new LwM2MModelConfig();
    lwM2MModelConfig2.setAttributesToAdd(attributesToAdd);

    // Act and Assert
    assertNotEquals(lwM2MModelConfig, lwM2MModelConfig2);
  }

  /**
   * Method under test: {@link LwM2MModelConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2MModelConfig("https://config.us-east-2.amazonaws.com"), null);
  }

  /**
   * Method under test: {@link LwM2MModelConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new LwM2MModelConfig("https://config.us-east-2.amazonaws.com"),
        "Different type to LwM2MModelConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MModelConfig#LwM2MModelConfig()}
   *   <li>{@link LwM2MModelConfig#setAttributesToAdd(Map)}
   *   <li>{@link LwM2MModelConfig#setAttributesToRemove(Set)}
   *   <li>{@link LwM2MModelConfig#setEndpoint(String)}
   *   <li>{@link LwM2MModelConfig#setToCancelObserve(Set)}
   *   <li>{@link LwM2MModelConfig#setToCancelRead(Set)}
   *   <li>{@link LwM2MModelConfig#setToObserve(Set)}
   *   <li>{@link LwM2MModelConfig#setToRead(Set)}
   *   <li>{@link LwM2MModelConfig#toString()}
   *   <li>{@link LwM2MModelConfig#getAttributesToAdd()}
   *   <li>{@link LwM2MModelConfig#getAttributesToRemove()}
   *   <li>{@link LwM2MModelConfig#getEndpoint()}
   *   <li>{@link LwM2MModelConfig#getToCancelObserve()}
   *   <li>{@link LwM2MModelConfig#getToCancelRead()}
   *   <li>{@link LwM2MModelConfig#getToObserve()}
   *   <li>{@link LwM2MModelConfig#getToRead()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2MModelConfig actualLwM2MModelConfig = new LwM2MModelConfig();
    HashMap<String, ObjectAttributes> attributesToAdd = new HashMap<>();
    actualLwM2MModelConfig.setAttributesToAdd(attributesToAdd);
    HashSet<String> attributesToRemove = new HashSet<>();
    actualLwM2MModelConfig.setAttributesToRemove(attributesToRemove);
    actualLwM2MModelConfig.setEndpoint("https://config.us-east-2.amazonaws.com");
    HashSet<String> toCancelObserve = new HashSet<>();
    actualLwM2MModelConfig.setToCancelObserve(toCancelObserve);
    HashSet<String> toCancelRead = new HashSet<>();
    actualLwM2MModelConfig.setToCancelRead(toCancelRead);
    HashSet<String> toObserve = new HashSet<>();
    actualLwM2MModelConfig.setToObserve(toObserve);
    HashSet<String> toRead = new HashSet<>();
    actualLwM2MModelConfig.setToRead(toRead);
    String actualToStringResult = actualLwM2MModelConfig.toString();
    Map<String, ObjectAttributes> actualAttributesToAdd = actualLwM2MModelConfig.getAttributesToAdd();
    Set<String> actualAttributesToRemove = actualLwM2MModelConfig.getAttributesToRemove();
    String actualEndpoint = actualLwM2MModelConfig.getEndpoint();
    Set<String> actualToCancelObserve = actualLwM2MModelConfig.getToCancelObserve();
    Set<String> actualToCancelRead = actualLwM2MModelConfig.getToCancelRead();
    Set<String> actualToObserve = actualLwM2MModelConfig.getToObserve();
    Set<String> actualToRead = actualLwM2MModelConfig.getToRead();

    // Assert that nothing has changed
    assertEquals(
        "LwM2MModelConfig(endpoint=https://config.us-east-2.amazonaws.com, attributesToAdd={}, attributesToRemove=[],"
            + " toObserve=[], toCancelObserve=[], toRead=[])",
        actualToStringResult);
    assertEquals("https://config.us-east-2.amazonaws.com", actualEndpoint);
    assertTrue(actualAttributesToAdd.isEmpty());
    assertTrue(actualAttributesToRemove.isEmpty());
    assertTrue(actualToCancelObserve.isEmpty());
    assertTrue(actualToCancelRead.isEmpty());
    assertTrue(actualToObserve.isEmpty());
    assertTrue(actualToRead.isEmpty());
    assertSame(attributesToAdd, actualAttributesToAdd);
    assertSame(attributesToRemove, actualAttributesToRemove);
    assertSame(toCancelObserve, actualToCancelObserve);
    assertSame(toCancelRead, actualToCancelRead);
    assertSame(toObserve, actualToObserve);
    assertSame(toRead, actualToRead);
  }

  /**
   * Method under test: {@link LwM2MModelConfig#LwM2MModelConfig(String)}
   */
  @Test
  void testNewLwM2MModelConfig() {
    // Arrange and Act
    LwM2MModelConfig actualLwM2MModelConfig = new LwM2MModelConfig("https://config.us-east-2.amazonaws.com");

    // Assert
    assertEquals("https://config.us-east-2.amazonaws.com", actualLwM2MModelConfig.getEndpoint());
    assertTrue(actualLwM2MModelConfig.getAttributesToAdd().isEmpty());
    assertTrue(actualLwM2MModelConfig.getAttributesToRemove().isEmpty());
    assertTrue(actualLwM2MModelConfig.getToCancelObserve().isEmpty());
    assertTrue(actualLwM2MModelConfig.getToCancelRead().isEmpty());
    assertTrue(actualLwM2MModelConfig.getToObserve().isEmpty());
    assertTrue(actualLwM2MModelConfig.getToRead().isEmpty());
    assertTrue(actualLwM2MModelConfig.isEmpty());
  }
}
