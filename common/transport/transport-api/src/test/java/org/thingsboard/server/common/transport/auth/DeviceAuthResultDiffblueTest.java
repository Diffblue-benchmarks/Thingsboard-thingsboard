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
package org.thingsboard.server.common.transport.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceId;

class DeviceAuthResultDiffblueTest {
  /**
   * Test {@link DeviceAuthResult#of(DeviceId)} with {@code deviceId}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return ErrorMsg is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceAuthResult#of(DeviceId)}
   */
  @Test
  @DisplayName("Test of(DeviceId) with 'deviceId'; when 'null'; then return ErrorMsg is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceAuthResult DeviceAuthResult.of(DeviceId)"})
  void testOfWithDeviceId_whenNull_thenReturnErrorMsgIsNull() {
    // Arrange and Act
    DeviceAuthResult actualOfResult = DeviceAuthResult.of((DeviceId) null);

    // Assert
    assertNull(actualOfResult.getErrorMsg());
    assertNull(actualOfResult.getDeviceId());
    assertTrue(actualOfResult.isSuccess());
  }

  /**
   * Test {@link DeviceAuthResult#of(String)} with {@code errorMsg}.
   *
   * <p>Method under test: {@link DeviceAuthResult#of(String)}
   */
  @Test
  @DisplayName("Test of(String) with 'errorMsg'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceAuthResult DeviceAuthResult.of(String)"})
  void testOfWithErrorMsg() {
    // Arrange and Act
    DeviceAuthResult actualOfResult = DeviceAuthResult.of("An error occurred");

    // Assert
    assertEquals("An error occurred", actualOfResult.getErrorMsg());
    assertNull(actualOfResult.getDeviceId());
    assertFalse(actualOfResult.isSuccess());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceAuthResult#toString()}
   *   <li>{@link DeviceAuthResult#getDeviceId()}
   *   <li>{@link DeviceAuthResult#getErrorMsg()}
   *   <li>{@link DeviceAuthResult#isSuccess()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceId DeviceAuthResult.getDeviceId()",
    "String DeviceAuthResult.getErrorMsg()",
    "boolean DeviceAuthResult.isSuccess()",
    "String DeviceAuthResult.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    DeviceAuthResult ofResult = DeviceAuthResult.of("An error occurred");

    // Act
    String actualToStringResult = ofResult.toString();
    DeviceId actualDeviceId = ofResult.getDeviceId();
    String actualErrorMsg = ofResult.getErrorMsg();

    // Assert
    assertEquals("An error occurred", actualErrorMsg);
    assertEquals(
        "DeviceAuthResult [success=false, deviceId=null, errorMsg=An error occurred]",
        actualToStringResult);
    assertNull(actualDeviceId);
    assertFalse(ofResult.isSuccess());
  }
}
