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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ApiUsageRecordStateDiffblueTest {
  /**
   * Test {@link ApiUsageRecordState#getValueAsString()}.
   * <ul>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageRecordState#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString(); then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ApiUsageRecordState.getValueAsString()"})
  void testGetValueAsString_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", (new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .getValueAsString());
  }

  /**
   * Test {@link ApiUsageRecordState#getValueAsString()}.
   * <ul>
   *   <li>Then return {@code 1.00M}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageRecordState#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString(); then return '1.00M'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ApiUsageRecordState.getValueAsString()"})
  void testGetValueAsString_thenReturn100m() {
    // Arrange, Act and Assert
    assertEquals("1.00M",
        (new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 1000000L))
            .getValueAsString());
  }

  /**
   * Test {@link ApiUsageRecordState#getValueAsString()}.
   * <ul>
   *   <li>Then return {@code 9223372036854.78M}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageRecordState#getValueAsString()}
   */
  @Test
  @DisplayName("Test getValueAsString(); then return '9223372036854.78M'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ApiUsageRecordState.getValueAsString()"})
  void testGetValueAsString_thenReturn922337203685478m() {
    // Arrange, Act and Assert
    assertEquals("9223372036854.78M",
        (new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, Long.MAX_VALUE))
            .getValueAsString());
  }

  /**
   * Test {@link ApiUsageRecordState#getThresholdAsString()}.
   * <ul>
   *   <li>Then return {@code 1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageRecordState#getThresholdAsString()}
   */
  @Test
  @DisplayName("Test getThresholdAsString(); then return '1'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ApiUsageRecordState.getThresholdAsString()"})
  void testGetThresholdAsString_thenReturn1() {
    // Arrange, Act and Assert
    assertEquals("1", (new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .getThresholdAsString());
  }

  /**
   * Test {@link ApiUsageRecordState#getThresholdAsString()}.
   * <ul>
   *   <li>Then return {@code 1.00M}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageRecordState#getThresholdAsString()}
   */
  @Test
  @DisplayName("Test getThresholdAsString(); then return '1.00M'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ApiUsageRecordState.getThresholdAsString()"})
  void testGetThresholdAsString_thenReturn100m() {
    // Arrange, Act and Assert
    assertEquals("1.00M",
        (new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1000000L, 42L))
            .getThresholdAsString());
  }

  /**
   * Test {@link ApiUsageRecordState#getThresholdAsString()}.
   * <ul>
   *   <li>Then return {@code 9223372036854.78M}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageRecordState#getThresholdAsString()}
   */
  @Test
  @DisplayName("Test getThresholdAsString(); then return '9223372036854.78M'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String ApiUsageRecordState.getThresholdAsString()"})
  void testGetThresholdAsString_thenReturn922337203685478m() {
    // Arrange, Act and Assert
    assertEquals("9223372036854.78M",
        (new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, Long.MAX_VALUE, 42L))
            .getThresholdAsString());
  }

  /**
   * Test {@link ApiUsageRecordState#equals(Object)}, and {@link ApiUsageRecordState#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageRecordState#equals(Object)}
   *   <li>{@link ApiUsageRecordState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageRecordState.equals(Object)", "int ApiUsageRecordState.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ApiUsageRecordState apiUsageRecordState = new ApiUsageRecordState(ApiFeature.TRANSPORT,
        ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L);
    ApiUsageRecordState apiUsageRecordState2 = new ApiUsageRecordState(ApiFeature.TRANSPORT,
        ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L);

    // Act and Assert
    assertEquals(apiUsageRecordState, apiUsageRecordState2);
    int expectedHashCodeResult = apiUsageRecordState.hashCode();
    assertEquals(expectedHashCodeResult, apiUsageRecordState2.hashCode());
  }

  /**
   * Test {@link ApiUsageRecordState#equals(Object)}, and {@link ApiUsageRecordState#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageRecordState#equals(Object)}
   *   <li>{@link ApiUsageRecordState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageRecordState.equals(Object)", "int ApiUsageRecordState.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ApiUsageRecordState apiUsageRecordState = new ApiUsageRecordState(null, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L,
        42L);
    ApiUsageRecordState apiUsageRecordState2 = new ApiUsageRecordState(null, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L,
        42L);

    // Act and Assert
    assertEquals(apiUsageRecordState, apiUsageRecordState2);
    int expectedHashCodeResult = apiUsageRecordState.hashCode();
    assertEquals(expectedHashCodeResult, apiUsageRecordState2.hashCode());
  }

  /**
   * Test {@link ApiUsageRecordState#equals(Object)}, and {@link ApiUsageRecordState#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageRecordState#equals(Object)}
   *   <li>{@link ApiUsageRecordState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageRecordState.equals(Object)", "int ApiUsageRecordState.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ApiUsageRecordState apiUsageRecordState = new ApiUsageRecordState(ApiFeature.TRANSPORT, null, 1L, 42L);
    ApiUsageRecordState apiUsageRecordState2 = new ApiUsageRecordState(ApiFeature.TRANSPORT, null, 1L, 42L);

    // Act and Assert
    assertEquals(apiUsageRecordState, apiUsageRecordState2);
    int expectedHashCodeResult = apiUsageRecordState.hashCode();
    assertEquals(expectedHashCodeResult, apiUsageRecordState2.hashCode());
  }

  /**
   * Test {@link ApiUsageRecordState#equals(Object)}, and {@link ApiUsageRecordState#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageRecordState#equals(Object)}
   *   <li>{@link ApiUsageRecordState#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageRecordState.equals(Object)", "int ApiUsageRecordState.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ApiUsageRecordState apiUsageRecordState = new ApiUsageRecordState(ApiFeature.TRANSPORT,
        ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L);

    // Act and Assert
    assertEquals(apiUsageRecordState, apiUsageRecordState);
    int expectedHashCodeResult = apiUsageRecordState.hashCode();
    assertEquals(expectedHashCodeResult, apiUsageRecordState.hashCode());
  }

  /**
   * Test {@link ApiUsageRecordState#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageRecordState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageRecordState.equals(Object)", "int ApiUsageRecordState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ApiUsageRecordState apiUsageRecordState = new ApiUsageRecordState(null, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L,
        42L);

    // Act and Assert
    assertNotEquals(apiUsageRecordState,
        new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L));
  }

  /**
   * Test {@link ApiUsageRecordState#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageRecordState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageRecordState.equals(Object)", "int ApiUsageRecordState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ApiUsageRecordState apiUsageRecordState = new ApiUsageRecordState(ApiFeature.DB,
        ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L);

    // Act and Assert
    assertNotEquals(apiUsageRecordState,
        new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L));
  }

  /**
   * Test {@link ApiUsageRecordState#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageRecordState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageRecordState.equals(Object)", "int ApiUsageRecordState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ApiUsageRecordState apiUsageRecordState = new ApiUsageRecordState(ApiFeature.TRANSPORT, null, 1L, 42L);

    // Act and Assert
    assertNotEquals(apiUsageRecordState,
        new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L));
  }

  /**
   * Test {@link ApiUsageRecordState#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageRecordState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageRecordState.equals(Object)", "int ApiUsageRecordState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ApiUsageRecordState apiUsageRecordState = new ApiUsageRecordState(ApiFeature.TRANSPORT,
        ApiUsageRecordKey.TRANSPORT_DP_COUNT, 1L, 42L);

    // Act and Assert
    assertNotEquals(apiUsageRecordState,
        new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L));
  }

  /**
   * Test {@link ApiUsageRecordState#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageRecordState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageRecordState.equals(Object)", "int ApiUsageRecordState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ApiUsageRecordState apiUsageRecordState = new ApiUsageRecordState(ApiFeature.TRANSPORT,
        ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 3L, 42L);

    // Act and Assert
    assertNotEquals(apiUsageRecordState,
        new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L));
  }

  /**
   * Test {@link ApiUsageRecordState#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageRecordState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageRecordState.equals(Object)", "int ApiUsageRecordState.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ApiUsageRecordState apiUsageRecordState = new ApiUsageRecordState(ApiFeature.TRANSPORT,
        ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 1L);

    // Act and Assert
    assertNotEquals(apiUsageRecordState,
        new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L));
  }

  /**
   * Test {@link ApiUsageRecordState#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageRecordState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageRecordState.equals(Object)", "int ApiUsageRecordState.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L),
        null);
  }

  /**
   * Test {@link ApiUsageRecordState#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageRecordState#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageRecordState.equals(Object)", "int ApiUsageRecordState.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L),
        "Different type to ApiUsageRecordState");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageRecordState#toString()}
   *   <li>{@link ApiUsageRecordState#getApiFeature()}
   *   <li>{@link ApiUsageRecordState#getKey()}
   *   <li>{@link ApiUsageRecordState#getThreshold()}
   *   <li>{@link ApiUsageRecordState#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ApiFeature ApiUsageRecordState.getApiFeature()", "ApiUsageRecordKey ApiUsageRecordState.getKey()",
      "long ApiUsageRecordState.getThreshold()", "long ApiUsageRecordState.getValue()",
      "String ApiUsageRecordState.toString()"})
  void testGettersAndSetters() {
    // Arrange
    ApiUsageRecordState apiUsageRecordState = new ApiUsageRecordState(ApiFeature.TRANSPORT,
        ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L);

    // Act
    String actualToStringResult = apiUsageRecordState.toString();
    ApiFeature actualApiFeature = apiUsageRecordState.getApiFeature();
    ApiUsageRecordKey actualKey = apiUsageRecordState.getKey();
    long actualThreshold = apiUsageRecordState.getThreshold();

    // Assert
    assertEquals("ApiUsageRecordState(apiFeature=TRANSPORT, key=TRANSPORT_MSG_COUNT, threshold=1, value=42)",
        actualToStringResult);
    assertEquals(1L, actualThreshold);
    assertEquals(42L, apiUsageRecordState.getValue());
    assertEquals(ApiFeature.TRANSPORT, actualApiFeature);
    assertEquals(ApiUsageRecordKey.TRANSPORT_MSG_COUNT, actualKey);
  }

  /**
   * Test {@link ApiUsageRecordState#ApiUsageRecordState(ApiFeature, ApiUsageRecordKey, long, long)}.
   * <p>
   * Method under test: {@link ApiUsageRecordState#ApiUsageRecordState(ApiFeature, ApiUsageRecordKey, long, long)}
   */
  @Test
  @DisplayName("Test new ApiUsageRecordState(ApiFeature, ApiUsageRecordKey, long, long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ApiUsageRecordState.<init>(ApiFeature, ApiUsageRecordKey, long, long)"})
  void testNewApiUsageRecordState() {
    // Arrange and Act
    ApiUsageRecordState actualApiUsageRecordState = new ApiUsageRecordState(ApiFeature.TRANSPORT,
        ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L);

    // Assert
    assertEquals("1", actualApiUsageRecordState.getThresholdAsString());
    assertEquals("42", actualApiUsageRecordState.getValueAsString());
    assertEquals(1L, actualApiUsageRecordState.getThreshold());
    assertEquals(42L, actualApiUsageRecordState.getValue());
    assertEquals(ApiFeature.TRANSPORT, actualApiUsageRecordState.getApiFeature());
    assertEquals(ApiUsageRecordKey.TRANSPORT_MSG_COUNT, actualApiUsageRecordState.getKey());
  }
}
