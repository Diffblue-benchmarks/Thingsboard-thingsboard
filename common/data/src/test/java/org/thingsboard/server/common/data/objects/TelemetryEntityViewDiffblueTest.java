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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TelemetryEntityViewDiffblueTest {
  /**
   * Test {@link TelemetryEntityView#equals(Object)}, and {@link TelemetryEntityView#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TelemetryEntityView#equals(Object)}
   *   <li>{@link TelemetryEntityView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TelemetryEntityView.equals(Object)",
    "int TelemetryEntityView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TelemetryEntityView telemetryEntityView = new TelemetryEntityView();
    TelemetryEntityView telemetryEntityView2 = new TelemetryEntityView();

    // Act and Assert
    assertEquals(telemetryEntityView, telemetryEntityView2);
    assertEquals(telemetryEntityView.hashCode(), telemetryEntityView2.hashCode());
  }

  /**
   * Test {@link TelemetryEntityView#equals(Object)}, and {@link TelemetryEntityView#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TelemetryEntityView#equals(Object)}
   *   <li>{@link TelemetryEntityView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TelemetryEntityView.equals(Object)",
    "int TelemetryEntityView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ArrayList<String> timeseries = new ArrayList<>();
    TelemetryEntityView telemetryEntityView =
        new TelemetryEntityView(timeseries, new AttributesEntityView());
    ArrayList<String> timeseries2 = new ArrayList<>();
    TelemetryEntityView telemetryEntityView2 =
        new TelemetryEntityView(timeseries2, new AttributesEntityView());

    // Act and Assert
    assertEquals(telemetryEntityView, telemetryEntityView2);
    assertEquals(telemetryEntityView.hashCode(), telemetryEntityView2.hashCode());
  }

  /**
   * Test {@link TelemetryEntityView#equals(Object)}, and {@link TelemetryEntityView#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TelemetryEntityView#equals(Object)}
   *   <li>{@link TelemetryEntityView#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TelemetryEntityView.equals(Object)",
    "int TelemetryEntityView.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TelemetryEntityView telemetryEntityView = new TelemetryEntityView();

    // Act and Assert
    assertEquals(telemetryEntityView, telemetryEntityView);
    int expectedHashCodeResult = telemetryEntityView.hashCode();
    assertEquals(expectedHashCodeResult, telemetryEntityView.hashCode());
  }

  /**
   * Test {@link TelemetryEntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryEntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TelemetryEntityView.equals(Object)",
    "int TelemetryEntityView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<String> timeseries = new ArrayList<>();
    TelemetryEntityView telemetryEntityView =
        new TelemetryEntityView(timeseries, new AttributesEntityView());

    // Act and Assert
    assertNotEquals(telemetryEntityView, new TelemetryEntityView());
  }

  /**
   * Test {@link TelemetryEntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryEntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TelemetryEntityView.equals(Object)",
    "int TelemetryEntityView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TelemetryEntityView telemetryEntityView = new TelemetryEntityView();
    ArrayList<String> timeseries = new ArrayList<>();
    TelemetryEntityView telemetryEntityView2 =
        new TelemetryEntityView(timeseries, new AttributesEntityView());

    // Act and Assert
    assertNotEquals(telemetryEntityView, telemetryEntityView2);
  }

  /**
   * Test {@link TelemetryEntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryEntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TelemetryEntityView.equals(Object)",
    "int TelemetryEntityView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TelemetryEntityView telemetryEntityView = new TelemetryEntityView();
    telemetryEntityView.setAttributes(new AttributesEntityView());

    // Act and Assert
    assertNotEquals(telemetryEntityView, new TelemetryEntityView());
  }

  /**
   * Test {@link TelemetryEntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryEntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TelemetryEntityView.equals(Object)",
    "int TelemetryEntityView.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TelemetryEntityView telemetryEntityView = new TelemetryEntityView();

    TelemetryEntityView telemetryEntityView2 = new TelemetryEntityView();
    telemetryEntityView2.setAttributes(new AttributesEntityView());

    // Act and Assert
    assertNotEquals(telemetryEntityView, telemetryEntityView2);
  }

  /**
   * Test {@link TelemetryEntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryEntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TelemetryEntityView.equals(Object)",
    "int TelemetryEntityView.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TelemetryEntityView(), null);
  }

  /**
   * Test {@link TelemetryEntityView#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryEntityView#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean TelemetryEntityView.equals(Object)",
    "int TelemetryEntityView.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TelemetryEntityView(), "Different type to TelemetryEntityView");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TelemetryEntityView.<init>()",
    "AttributesEntityView TelemetryEntityView.getAttributes()",
    "List TelemetryEntityView.getTimeseries()",
    "void TelemetryEntityView.setAttributes(AttributesEntityView)",
    "void TelemetryEntityView.setTimeseries(List)",
    "String TelemetryEntityView.toString()"
  })
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

    // Assert
    assertEquals(
        "TelemetryEntityView(timeseries=[], attributes=AttributesEntityView(cs=[], ss=[], sh=[]))",
        actualToStringResult);
    assertTrue(actualTimeseries.isEmpty());
    assertSame(timeseries, actualTimeseries);
    assertSame(attributes, actualAttributes);
  }

  /**
   * Test {@link TelemetryEntityView#TelemetryEntityView(TelemetryEntityView)}.
   *
   * <p>Method under test: {@link TelemetryEntityView#TelemetryEntityView(TelemetryEntityView)}
   */
  @Test
  @DisplayName("Test new TelemetryEntityView(TelemetryEntityView)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TelemetryEntityView.<init>(TelemetryEntityView)"})
  void testNewTelemetryEntityView() {
    // Arrange
    ArrayList<String> timeseries = new ArrayList<>();
    TelemetryEntityView obj = new TelemetryEntityView(timeseries, new AttributesEntityView());

    // Act
    TelemetryEntityView actualTelemetryEntityView = new TelemetryEntityView(obj);

    // Assert
    assertEquals(obj, actualTelemetryEntityView);
  }

  /**
   * Test {@link TelemetryEntityView#TelemetryEntityView(List, AttributesEntityView)}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryEntityView#TelemetryEntityView(List,
   * AttributesEntityView)}
   */
  @Test
  @DisplayName(
      "Test new TelemetryEntityView(List, AttributesEntityView); given '42'; when ArrayList() add '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TelemetryEntityView.<init>(List, AttributesEntityView)"})
  void testNewTelemetryEntityView_given42_whenArrayListAdd42() {
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
   * Test {@link TelemetryEntityView#TelemetryEntityView(List, AttributesEntityView)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>Then return Timeseries is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryEntityView#TelemetryEntityView(List,
   * AttributesEntityView)}
   */
  @Test
  @DisplayName(
      "Test new TelemetryEntityView(List, AttributesEntityView); given 'foo'; then return Timeseries is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TelemetryEntityView.<init>(List, AttributesEntityView)"})
  void testNewTelemetryEntityView_givenFoo_thenReturnTimeseriesIsArrayList() {
    // Arrange
    ArrayList<String> timeseries = new ArrayList<>();
    timeseries.add("foo");
    AttributesEntityView attributes = new AttributesEntityView();

    // Act
    TelemetryEntityView actualTelemetryEntityView = new TelemetryEntityView(timeseries, attributes);

    // Assert
    assertEquals(timeseries, actualTelemetryEntityView.getTimeseries());
    assertSame(attributes, actualTelemetryEntityView.getAttributes());
  }

  /**
   * Test {@link TelemetryEntityView#TelemetryEntityView(List, AttributesEntityView)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return Timeseries Empty.
   * </ul>
   *
   * <p>Method under test: {@link TelemetryEntityView#TelemetryEntityView(List,
   * AttributesEntityView)}
   */
  @Test
  @DisplayName(
      "Test new TelemetryEntityView(List, AttributesEntityView); when ArrayList(); then return Timeseries Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TelemetryEntityView.<init>(List, AttributesEntityView)"})
  void testNewTelemetryEntityView_whenArrayList_thenReturnTimeseriesEmpty() {
    // Arrange
    ArrayList<String> timeseries = new ArrayList<>();
    AttributesEntityView attributes = new AttributesEntityView();

    // Act
    TelemetryEntityView actualTelemetryEntityView = new TelemetryEntityView(timeseries, attributes);

    // Assert
    assertTrue(actualTelemetryEntityView.getTimeseries().isEmpty());
    assertSame(attributes, actualTelemetryEntityView.getAttributes());
  }
}
