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
package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.jupiter.api.Test;

class GeneralNotificationInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GeneralNotificationInfo#equals(Object)}
   *   <li>{@link GeneralNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    GeneralNotificationInfo generalNotificationInfo = new GeneralNotificationInfo();
    GeneralNotificationInfo generalNotificationInfo2 = new GeneralNotificationInfo();

    // Act and Assert
    assertEquals(generalNotificationInfo, generalNotificationInfo2);
    int expectedHashCodeResult = generalNotificationInfo.hashCode();
    assertEquals(expectedHashCodeResult, generalNotificationInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GeneralNotificationInfo#equals(Object)}
   *   <li>{@link GeneralNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    GeneralNotificationInfo generalNotificationInfo = new GeneralNotificationInfo(new HashMap<>());
    GeneralNotificationInfo generalNotificationInfo2 = new GeneralNotificationInfo(new HashMap<>());

    // Act and Assert
    assertEquals(generalNotificationInfo, generalNotificationInfo2);
    int expectedHashCodeResult = generalNotificationInfo.hashCode();
    assertEquals(expectedHashCodeResult, generalNotificationInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GeneralNotificationInfo#equals(Object)}
   *   <li>{@link GeneralNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    GeneralNotificationInfo generalNotificationInfo = new GeneralNotificationInfo();

    // Act and Assert
    assertEquals(generalNotificationInfo, generalNotificationInfo);
    int expectedHashCodeResult = generalNotificationInfo.hashCode();
    assertEquals(expectedHashCodeResult, generalNotificationInfo.hashCode());
  }

  /**
   * Method under test: {@link GeneralNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    GeneralNotificationInfo generalNotificationInfo = new GeneralNotificationInfo(new HashMap<>());

    // Act and Assert
    assertNotEquals(generalNotificationInfo, new GeneralNotificationInfo());
  }

  /**
   * Method under test: {@link GeneralNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    GeneralNotificationInfo generalNotificationInfo = new GeneralNotificationInfo();

    // Act and Assert
    assertNotEquals(generalNotificationInfo, new GeneralNotificationInfo(new HashMap<>()));
  }

  /**
   * Method under test: {@link GeneralNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashMap<String, String> data = new HashMap<>();
    data.computeIfPresent("foo", mock(BiFunction.class));
    GeneralNotificationInfo generalNotificationInfo = new GeneralNotificationInfo(data);

    // Act and Assert
    assertNotEquals(generalNotificationInfo, new GeneralNotificationInfo());
  }

  /**
   * Method under test: {@link GeneralNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GeneralNotificationInfo(), null);
  }

  /**
   * Method under test: {@link GeneralNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new GeneralNotificationInfo(), "Different type to GeneralNotificationInfo");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GeneralNotificationInfo#GeneralNotificationInfo()}
   *   <li>{@link GeneralNotificationInfo#setData(Map)}
   *   <li>{@link GeneralNotificationInfo#toString()}
   *   <li>{@link GeneralNotificationInfo#getData()}
   *   <li>{@link GeneralNotificationInfo#getTemplateData()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    GeneralNotificationInfo actualGeneralNotificationInfo = new GeneralNotificationInfo();
    HashMap<String, String> data = new HashMap<>();
    actualGeneralNotificationInfo.setData(data);
    String actualToStringResult = actualGeneralNotificationInfo.toString();
    Map<String, String> actualData = actualGeneralNotificationInfo.getData();
    Map<String, String> actualTemplateData = actualGeneralNotificationInfo.getTemplateData();

    // Assert that nothing has changed
    assertEquals("GeneralNotificationInfo(data={})", actualToStringResult);
    assertTrue(actualData.isEmpty());
    assertSame(data, actualData);
    assertSame(data, actualTemplateData);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link GeneralNotificationInfo#GeneralNotificationInfo(Map)}
   *   <li>{@link GeneralNotificationInfo#setData(Map)}
   *   <li>{@link GeneralNotificationInfo#toString()}
   *   <li>{@link GeneralNotificationInfo#getData()}
   *   <li>{@link GeneralNotificationInfo#getTemplateData()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange and Act
    GeneralNotificationInfo actualGeneralNotificationInfo = new GeneralNotificationInfo(new HashMap<>());
    HashMap<String, String> data = new HashMap<>();
    actualGeneralNotificationInfo.setData(data);
    String actualToStringResult = actualGeneralNotificationInfo.toString();
    Map<String, String> actualData = actualGeneralNotificationInfo.getData();
    Map<String, String> actualTemplateData = actualGeneralNotificationInfo.getTemplateData();

    // Assert that nothing has changed
    assertEquals("GeneralNotificationInfo(data={})", actualToStringResult);
    assertTrue(actualData.isEmpty());
    assertSame(data, actualData);
    assertSame(data, actualTemplateData);
  }
}
