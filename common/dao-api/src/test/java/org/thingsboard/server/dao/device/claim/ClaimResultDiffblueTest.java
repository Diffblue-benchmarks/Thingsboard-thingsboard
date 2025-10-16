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
package org.thingsboard.server.dao.device.claim;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.DeviceInfo;

class ClaimResultDiffblueTest {
  /**
   * Test {@link ClaimResult#equals(Object)}, and {@link ClaimResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClaimResult#equals(Object)}
   *   <li>{@link ClaimResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimResult.equals(Object)", "int ClaimResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ClaimResult claimResult = new ClaimResult(new Device(), ClaimResponse.SUCCESS);
    ClaimResult claimResult2 = new ClaimResult(new Device(), ClaimResponse.SUCCESS);

    // Act and Assert
    assertEquals(claimResult, claimResult2);
    assertEquals(claimResult.hashCode(), claimResult2.hashCode());
  }

  /**
   * Test {@link ClaimResult#equals(Object)}, and {@link ClaimResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClaimResult#equals(Object)}
   *   <li>{@link ClaimResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimResult.equals(Object)", "int ClaimResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ClaimResult claimResult = new ClaimResult(null, ClaimResponse.SUCCESS);
    ClaimResult claimResult2 = new ClaimResult(null, ClaimResponse.SUCCESS);

    // Act and Assert
    assertEquals(claimResult, claimResult2);
    assertEquals(claimResult.hashCode(), claimResult2.hashCode());
  }

  /**
   * Test {@link ClaimResult#equals(Object)}, and {@link ClaimResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClaimResult#equals(Object)}
   *   <li>{@link ClaimResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimResult.equals(Object)", "int ClaimResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ClaimResult claimResult = new ClaimResult(new Device(), null);
    ClaimResult claimResult2 = new ClaimResult(new Device(), null);

    // Act and Assert
    assertEquals(claimResult, claimResult2);
    assertEquals(claimResult.hashCode(), claimResult2.hashCode());
  }

  /**
   * Test {@link ClaimResult#equals(Object)}, and {@link ClaimResult#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClaimResult#equals(Object)}
   *   <li>{@link ClaimResult#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimResult.equals(Object)", "int ClaimResult.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ClaimResult claimResult = new ClaimResult(new Device(), ClaimResponse.SUCCESS);

    // Act and Assert
    assertEquals(claimResult, claimResult);
    int expectedHashCodeResult = claimResult.hashCode();
    assertEquals(expectedHashCodeResult, claimResult.hashCode());
  }

  /**
   * Test {@link ClaimResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClaimResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimResult.equals(Object)", "int ClaimResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ClaimResult claimResult = new ClaimResult(null, ClaimResponse.SUCCESS);

    // Act and Assert
    assertNotEquals(claimResult, new ClaimResult(new Device(), ClaimResponse.SUCCESS));
  }

  /**
   * Test {@link ClaimResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClaimResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimResult.equals(Object)", "int ClaimResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ClaimResult claimResult = new ClaimResult(new DeviceInfo(), ClaimResponse.SUCCESS);

    // Act and Assert
    assertNotEquals(claimResult, new ClaimResult(new Device(), ClaimResponse.SUCCESS));
  }

  /**
   * Test {@link ClaimResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClaimResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimResult.equals(Object)", "int ClaimResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ClaimResult claimResult = new ClaimResult(new Device(), null);

    // Act and Assert
    assertNotEquals(claimResult, new ClaimResult(new Device(), ClaimResponse.SUCCESS));
  }

  /**
   * Test {@link ClaimResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClaimResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimResult.equals(Object)", "int ClaimResult.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ClaimResult claimResult = new ClaimResult(new Device(), ClaimResponse.FAILURE);

    // Act and Assert
    assertNotEquals(claimResult, new ClaimResult(new Device(), ClaimResponse.SUCCESS));
  }

  /**
   * Test {@link ClaimResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClaimResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimResult.equals(Object)", "int ClaimResult.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new ClaimResult(new Device(), ClaimResponse.SUCCESS), null);
  }

  /**
   * Test {@link ClaimResult#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClaimResult#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimResult.equals(Object)", "int ClaimResult.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ClaimResult(new Device(), ClaimResponse.SUCCESS), "Different type to ClaimResult");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClaimResult#ClaimResult(Device, ClaimResponse)}
   *   <li>{@link ClaimResult#setDevice(Device)}
   *   <li>{@link ClaimResult#setResponse(ClaimResponse)}
   *   <li>{@link ClaimResult#toString()}
   *   <li>{@link ClaimResult#getDevice()}
   *   <li>{@link ClaimResult#getResponse()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ClaimResult.<init>(Device, ClaimResponse)",
    "Device ClaimResult.getDevice()",
    "ClaimResponse ClaimResult.getResponse()",
    "void ClaimResult.setDevice(Device)",
    "void ClaimResult.setResponse(ClaimResponse)",
    "String ClaimResult.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ClaimResult actualClaimResult = new ClaimResult(new Device(), ClaimResponse.SUCCESS);
    Device device = new Device();
    actualClaimResult.setDevice(device);
    actualClaimResult.setResponse(ClaimResponse.SUCCESS);
    String actualToStringResult = actualClaimResult.toString();
    Device actualDevice = actualClaimResult.getDevice();

    // Assert
    assertEquals(
        "ClaimResult(device=Device(super=BaseData [createdTime=0, id=null], tenantId=null, customerId=null,"
            + " name=null, type=null, label=null, deviceProfileId=null, deviceData=null, deviceDataBytes=null,"
            + " firmwareId=null, softwareId=null, externalId=null, version=null), response=SUCCESS)",
        actualToStringResult);
    assertEquals(ClaimResponse.SUCCESS, actualClaimResult.getResponse());
    assertSame(device, actualDevice);
  }
}
