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
package org.thingsboard.server.dao.device.provision;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.DeviceCredentialsId;
import org.thingsboard.server.common.data.security.DeviceCredentials;

class ProvisionResponseDiffblueTest {
  /**
   * Test {@link ProvisionResponse#equals(Object)}, and {@link ProvisionResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProvisionResponse#equals(Object)}
   *   <li>{@link ProvisionResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProvisionResponse.equals(Object)",
    "int ProvisionResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ProvisionResponse provisionResponse =
        new ProvisionResponse(new DeviceCredentials(), ProvisionResponseStatus.UNKNOWN);
    ProvisionResponse provisionResponse2 =
        new ProvisionResponse(new DeviceCredentials(), ProvisionResponseStatus.UNKNOWN);

    // Act and Assert
    assertEquals(provisionResponse, provisionResponse2);
    assertEquals(provisionResponse.hashCode(), provisionResponse2.hashCode());
  }

  /**
   * Test {@link ProvisionResponse#equals(Object)}, and {@link ProvisionResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProvisionResponse#equals(Object)}
   *   <li>{@link ProvisionResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProvisionResponse.equals(Object)",
    "int ProvisionResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ProvisionResponse provisionResponse =
        new ProvisionResponse(null, ProvisionResponseStatus.UNKNOWN);
    ProvisionResponse provisionResponse2 =
        new ProvisionResponse(null, ProvisionResponseStatus.UNKNOWN);

    // Act and Assert
    assertEquals(provisionResponse, provisionResponse2);
    assertEquals(provisionResponse.hashCode(), provisionResponse2.hashCode());
  }

  /**
   * Test {@link ProvisionResponse#equals(Object)}, and {@link ProvisionResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProvisionResponse#equals(Object)}
   *   <li>{@link ProvisionResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProvisionResponse.equals(Object)",
    "int ProvisionResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ProvisionResponse provisionResponse = new ProvisionResponse(new DeviceCredentials(), null);
    ProvisionResponse provisionResponse2 = new ProvisionResponse(new DeviceCredentials(), null);

    // Act and Assert
    assertEquals(provisionResponse, provisionResponse2);
    assertEquals(provisionResponse.hashCode(), provisionResponse2.hashCode());
  }

  /**
   * Test {@link ProvisionResponse#equals(Object)}, and {@link ProvisionResponse#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProvisionResponse#equals(Object)}
   *   <li>{@link ProvisionResponse#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProvisionResponse.equals(Object)",
    "int ProvisionResponse.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ProvisionResponse provisionResponse =
        new ProvisionResponse(new DeviceCredentials(), ProvisionResponseStatus.UNKNOWN);

    // Act and Assert
    assertEquals(provisionResponse, provisionResponse);
    int expectedHashCodeResult = provisionResponse.hashCode();
    assertEquals(expectedHashCodeResult, provisionResponse.hashCode());
  }

  /**
   * Test {@link ProvisionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProvisionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProvisionResponse.equals(Object)",
    "int ProvisionResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ProvisionResponse provisionResponse =
        new ProvisionResponse(null, ProvisionResponseStatus.UNKNOWN);

    // Act and Assert
    assertNotEquals(
        provisionResponse,
        new ProvisionResponse(new DeviceCredentials(), ProvisionResponseStatus.UNKNOWN));
  }

  /**
   * Test {@link ProvisionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProvisionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProvisionResponse.equals(Object)",
    "int ProvisionResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(UUID.randomUUID()));
    ProvisionResponse provisionResponse =
        new ProvisionResponse(deviceCredentials, ProvisionResponseStatus.UNKNOWN);

    // Act and Assert
    assertNotEquals(
        provisionResponse,
        new ProvisionResponse(new DeviceCredentials(), ProvisionResponseStatus.UNKNOWN));
  }

  /**
   * Test {@link ProvisionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProvisionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProvisionResponse.equals(Object)",
    "int ProvisionResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ProvisionResponse provisionResponse = new ProvisionResponse(new DeviceCredentials(), null);

    // Act and Assert
    assertNotEquals(
        provisionResponse,
        new ProvisionResponse(new DeviceCredentials(), ProvisionResponseStatus.UNKNOWN));
  }

  /**
   * Test {@link ProvisionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProvisionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProvisionResponse.equals(Object)",
    "int ProvisionResponse.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ProvisionResponse provisionResponse =
        new ProvisionResponse(new DeviceCredentials(), ProvisionResponseStatus.SUCCESS);

    // Act and Assert
    assertNotEquals(
        provisionResponse,
        new ProvisionResponse(new DeviceCredentials(), ProvisionResponseStatus.UNKNOWN));
  }

  /**
   * Test {@link ProvisionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProvisionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProvisionResponse.equals(Object)",
    "int ProvisionResponse.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ProvisionResponse(new DeviceCredentials(), ProvisionResponseStatus.UNKNOWN), null);
  }

  /**
   * Test {@link ProvisionResponse#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ProvisionResponse#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ProvisionResponse.equals(Object)",
    "int ProvisionResponse.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new ProvisionResponse(new DeviceCredentials(), ProvisionResponseStatus.UNKNOWN),
        "Different type to ProvisionResponse");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ProvisionResponse#ProvisionResponse(DeviceCredentials, ProvisionResponseStatus)}
   *   <li>{@link ProvisionResponse#toString()}
   *   <li>{@link ProvisionResponse#getDeviceCredentials()}
   *   <li>{@link ProvisionResponse#getResponseStatus()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ProvisionResponse.<init>(DeviceCredentials, ProvisionResponseStatus)",
    "DeviceCredentials ProvisionResponse.getDeviceCredentials()",
    "ProvisionResponseStatus ProvisionResponse.getResponseStatus()",
    "String ProvisionResponse.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    DeviceCredentials deviceCredentials = new DeviceCredentials();

    // Act
    ProvisionResponse actualProvisionResponse =
        new ProvisionResponse(deviceCredentials, ProvisionResponseStatus.UNKNOWN);
    String actualToStringResult = actualProvisionResponse.toString();
    DeviceCredentials actualDeviceCredentials = actualProvisionResponse.getDeviceCredentials();

    // Assert
    assertEquals(
        "ProvisionResponse(deviceCredentials=DeviceCredentials [deviceId=null, credentialsType=null,"
            + " credentialsId=null, credentialsValue=null, createdTime=0, id=null], responseStatus=UNKNOWN)",
        actualToStringResult);
    assertEquals(ProvisionResponseStatus.UNKNOWN, actualProvisionResponse.getResponseStatus());
    assertSame(deviceCredentials, actualDeviceCredentials);
  }
}
