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
package org.thingsboard.server.common.data.objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class TelemetryEntityViewDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TelemetryEntityView#equals(Object)}
   *   <li>{@link TelemetryEntityView#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TelemetryEntityView telemetryEntityView = new TelemetryEntityView();
    TelemetryEntityView telemetryEntityView2 = new TelemetryEntityView();

    // Act and Assert
    assertEquals(telemetryEntityView, telemetryEntityView2);
    int expectedHashCodeResult = telemetryEntityView.hashCode();
    assertEquals(expectedHashCodeResult, telemetryEntityView2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TelemetryEntityView#equals(Object)}
   *   <li>{@link TelemetryEntityView#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ArrayList<String> timeseries = new ArrayList<>();
    TelemetryEntityView telemetryEntityView = new TelemetryEntityView(timeseries, new AttributesEntityView());
    ArrayList<String> timeseries2 = new ArrayList<>();
    TelemetryEntityView telemetryEntityView2 = new TelemetryEntityView(timeseries2, new AttributesEntityView());

    // Act and Assert
    assertEquals(telemetryEntityView, telemetryEntityView2);
    int expectedHashCodeResult = telemetryEntityView.hashCode();
    assertEquals(expectedHashCodeResult, telemetryEntityView2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TelemetryEntityView#equals(Object)}
   *   <li>{@link TelemetryEntityView#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TelemetryEntityView telemetryEntityView = new TelemetryEntityView();

    // Act and Assert
    assertEquals(telemetryEntityView, telemetryEntityView);
    int expectedHashCodeResult = telemetryEntityView.hashCode();
    assertEquals(expectedHashCodeResult, telemetryEntityView.hashCode());
  }

  /**
   * Method under test: {@link TelemetryEntityView#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<String> timeseries = new ArrayList<>();
    TelemetryEntityView telemetryEntityView = new TelemetryEntityView(timeseries, new AttributesEntityView());

    // Act and Assert
    assertNotEquals(telemetryEntityView, new TelemetryEntityView());
  }

  /**
   * Method under test: {@link TelemetryEntityView#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TelemetryEntityView telemetryEntityView = new TelemetryEntityView();
    ArrayList<String> timeseries = new ArrayList<>();

    // Act and Assert
    assertNotEquals(telemetryEntityView, new TelemetryEntityView(timeseries, new AttributesEntityView()));
  }

  /**
   * Method under test: {@link TelemetryEntityView#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TelemetryEntityView telemetryEntityView = new TelemetryEntityView();
    telemetryEntityView.setAttributes(new AttributesEntityView());

    // Act and Assert
    assertNotEquals(telemetryEntityView, new TelemetryEntityView());
  }

  /**
   * Method under test: {@link TelemetryEntityView#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TelemetryEntityView telemetryEntityView = new TelemetryEntityView(new ArrayList<>(),
        mock(AttributesEntityView.class));

    // Act and Assert
    assertNotEquals(telemetryEntityView, new TelemetryEntityView());
  }

  /**
   * Method under test: {@link TelemetryEntityView#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TelemetryEntityView telemetryEntityView = new TelemetryEntityView();

    TelemetryEntityView telemetryEntityView2 = new TelemetryEntityView();
    telemetryEntityView2.setAttributes(new AttributesEntityView());

    // Act and Assert
    assertNotEquals(telemetryEntityView, telemetryEntityView2);
  }

  /**
   * Method under test: {@link TelemetryEntityView#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TelemetryEntityView(), null);
  }

  /**
   * Method under test: {@link TelemetryEntityView#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TelemetryEntityView(), "Different type to TelemetryEntityView");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TelemetryEntityView#TelemetryEntityView()}
   *   <li>{@link TelemetryEntityView#setAttributes(AttributesEntityView)}
   *   <li>{@link TelemetryEntityView#setTimeseries(List)}
   *   <li>{@link TelemetryEntityView#toString()}
   *   <li>{@link TelemetryEntityView#getAttributes()}
   *   <li>{@link TelemetryEntityView#getTimeseries()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    TelemetryEntityView actualTelemetryEntityView = new TelemetryEntityView();
    AttributesEntityView attributes = new AttributesEntityView();
    actualTelemetryEntityView.setAttributes(attributes);
    ArrayList<String> timeseries = new ArrayList<>();
    actualTelemetryEntityView.setTimeseries(timeseries);
    String actualToStringResult = actualTelemetryEntityView.toString();
    AttributesEntityView actualAttributes = actualTelemetryEntityView.getAttributes();
    List<String> actualTimeseries = actualTelemetryEntityView.getTimeseries();

    // Assert that nothing has changed
    assertEquals("TelemetryEntityView(timeseries=[], attributes=AttributesEntityView(cs=[], ss=[], sh=[]))",
        actualToStringResult);
    assertTrue(actualTimeseries.isEmpty());
    assertSame(timeseries, actualTimeseries);
    assertSame(attributes, actualAttributes);
  }

  /**
   * Method under test:
   * {@link TelemetryEntityView#TelemetryEntityView(List, AttributesEntityView)}
   */
  @Test
  void testNewTelemetryEntityView() {
    // Arrange
    ArrayList<String> timeseries = new ArrayList<>();
    AttributesEntityView attributes = new AttributesEntityView();

    // Act
    TelemetryEntityView actualTelemetryEntityView = new TelemetryEntityView(timeseries, attributes);

    // Assert
    assertTrue(actualTelemetryEntityView.getTimeseries().isEmpty());
    assertSame(attributes, actualTelemetryEntityView.getAttributes());
  }

  /**
   * Method under test:
   * {@link TelemetryEntityView#TelemetryEntityView(List, AttributesEntityView)}
   */
  @Test
  void testNewTelemetryEntityView2() {
    // Arrange
    ArrayList<String> timeseries = new ArrayList<>();
    timeseries.add("foo");
    AttributesEntityView attributes = new AttributesEntityView();

    // Act
    TelemetryEntityView actualTelemetryEntityView = new TelemetryEntityView(timeseries, attributes);

    // Assert
    List<String> timeseries2 = actualTelemetryEntityView.getTimeseries();
    assertEquals(1, timeseries2.size());
    assertEquals("foo", timeseries2.get(0));
    assertSame(attributes, actualTelemetryEntityView.getAttributes());
  }

  /**
   * Method under test:
   * {@link TelemetryEntityView#TelemetryEntityView(List, AttributesEntityView)}
   */
  @Test
  void testNewTelemetryEntityView3() {
    // Arrange
    ArrayList<String> timeseries = new ArrayList<>();
    timeseries.add("42");
    timeseries.add("foo");
    AttributesEntityView attributes = new AttributesEntityView();

    // Act
    TelemetryEntityView actualTelemetryEntityView = new TelemetryEntityView(timeseries, attributes);

    // Assert
    assertEquals(timeseries, actualTelemetryEntityView.getTimeseries());
    assertSame(attributes, actualTelemetryEntityView.getAttributes());
  }

  /**
   * Method under test:
   * {@link TelemetryEntityView#TelemetryEntityView(TelemetryEntityView)}
   */
  @Test
  void testNewTelemetryEntityView4() {
    // Arrange
    ArrayList<String> timeseries = new ArrayList<>();
    TelemetryEntityView obj = new TelemetryEntityView(timeseries, new AttributesEntityView());

    // Act and Assert
    assertEquals(obj, new TelemetryEntityView(obj));
  }
}
