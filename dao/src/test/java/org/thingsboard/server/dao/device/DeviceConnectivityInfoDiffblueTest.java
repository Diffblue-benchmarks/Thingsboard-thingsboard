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
package org.thingsboard.server.dao.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DeviceConnectivityInfoDiffblueTest {
  /**
   * Test {@link DeviceConnectivityInfo#equals(Object)}, and {@link
   * DeviceConnectivityInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceConnectivityInfo#equals(Object)}
   *   <li>{@link DeviceConnectivityInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityInfo.equals(Object)",
    "int DeviceConnectivityInfo.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost("localhost");
    deviceConnectivityInfo.setPort("Port");

    DeviceConnectivityInfo deviceConnectivityInfo2 = new DeviceConnectivityInfo();
    deviceConnectivityInfo2.setEnabled(true);
    deviceConnectivityInfo2.setHost("localhost");
    deviceConnectivityInfo2.setPort("Port");

    // Act and Assert
    assertEquals(deviceConnectivityInfo, deviceConnectivityInfo2);
    assertEquals(deviceConnectivityInfo.hashCode(), deviceConnectivityInfo2.hashCode());
  }

  /**
   * Test {@link DeviceConnectivityInfo#equals(Object)}, and {@link
   * DeviceConnectivityInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceConnectivityInfo#equals(Object)}
   *   <li>{@link DeviceConnectivityInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityInfo.equals(Object)",
    "int DeviceConnectivityInfo.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost(null);
    deviceConnectivityInfo.setPort("Port");

    DeviceConnectivityInfo deviceConnectivityInfo2 = new DeviceConnectivityInfo();
    deviceConnectivityInfo2.setEnabled(true);
    deviceConnectivityInfo2.setHost(null);
    deviceConnectivityInfo2.setPort("Port");

    // Act and Assert
    assertEquals(deviceConnectivityInfo, deviceConnectivityInfo2);
    assertEquals(deviceConnectivityInfo.hashCode(), deviceConnectivityInfo2.hashCode());
  }

  /**
   * Test {@link DeviceConnectivityInfo#equals(Object)}, and {@link
   * DeviceConnectivityInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceConnectivityInfo#equals(Object)}
   *   <li>{@link DeviceConnectivityInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityInfo.equals(Object)",
    "int DeviceConnectivityInfo.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost("localhost");
    deviceConnectivityInfo.setPort(null);

    DeviceConnectivityInfo deviceConnectivityInfo2 = new DeviceConnectivityInfo();
    deviceConnectivityInfo2.setEnabled(true);
    deviceConnectivityInfo2.setHost("localhost");
    deviceConnectivityInfo2.setPort(null);

    // Act and Assert
    assertEquals(deviceConnectivityInfo, deviceConnectivityInfo2);
    assertEquals(deviceConnectivityInfo.hashCode(), deviceConnectivityInfo2.hashCode());
  }

  /**
   * Test {@link DeviceConnectivityInfo#equals(Object)}, and {@link
   * DeviceConnectivityInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceConnectivityInfo#equals(Object)}
   *   <li>{@link DeviceConnectivityInfo#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityInfo.equals(Object)",
    "int DeviceConnectivityInfo.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost("localhost");
    deviceConnectivityInfo.setPort("Port");

    // Act and Assert
    assertEquals(deviceConnectivityInfo, deviceConnectivityInfo);
    int expectedHashCodeResult = deviceConnectivityInfo.hashCode();
    assertEquals(expectedHashCodeResult, deviceConnectivityInfo.hashCode());
  }

  /**
   * Test {@link DeviceConnectivityInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityInfo.equals(Object)",
    "int DeviceConnectivityInfo.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(false);
    deviceConnectivityInfo.setHost("localhost");
    deviceConnectivityInfo.setPort("Port");

    DeviceConnectivityInfo deviceConnectivityInfo2 = new DeviceConnectivityInfo();
    deviceConnectivityInfo2.setEnabled(true);
    deviceConnectivityInfo2.setHost("localhost");
    deviceConnectivityInfo2.setPort("Port");

    // Act and Assert
    assertNotEquals(deviceConnectivityInfo, deviceConnectivityInfo2);
  }

  /**
   * Test {@link DeviceConnectivityInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityInfo.equals(Object)",
    "int DeviceConnectivityInfo.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost("Port");
    deviceConnectivityInfo.setPort("Port");

    DeviceConnectivityInfo deviceConnectivityInfo2 = new DeviceConnectivityInfo();
    deviceConnectivityInfo2.setEnabled(true);
    deviceConnectivityInfo2.setHost("localhost");
    deviceConnectivityInfo2.setPort("Port");

    // Act and Assert
    assertNotEquals(deviceConnectivityInfo, deviceConnectivityInfo2);
  }

  /**
   * Test {@link DeviceConnectivityInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityInfo.equals(Object)",
    "int DeviceConnectivityInfo.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost(null);
    deviceConnectivityInfo.setPort("Port");

    DeviceConnectivityInfo deviceConnectivityInfo2 = new DeviceConnectivityInfo();
    deviceConnectivityInfo2.setEnabled(true);
    deviceConnectivityInfo2.setHost("localhost");
    deviceConnectivityInfo2.setPort("Port");

    // Act and Assert
    assertNotEquals(deviceConnectivityInfo, deviceConnectivityInfo2);
  }

  /**
   * Test {@link DeviceConnectivityInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityInfo.equals(Object)",
    "int DeviceConnectivityInfo.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost("localhost");
    deviceConnectivityInfo.setPort("localhost");

    DeviceConnectivityInfo deviceConnectivityInfo2 = new DeviceConnectivityInfo();
    deviceConnectivityInfo2.setEnabled(true);
    deviceConnectivityInfo2.setHost("localhost");
    deviceConnectivityInfo2.setPort("Port");

    // Act and Assert
    assertNotEquals(deviceConnectivityInfo, deviceConnectivityInfo2);
  }

  /**
   * Test {@link DeviceConnectivityInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityInfo.equals(Object)",
    "int DeviceConnectivityInfo.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost("localhost");
    deviceConnectivityInfo.setPort(null);

    DeviceConnectivityInfo deviceConnectivityInfo2 = new DeviceConnectivityInfo();
    deviceConnectivityInfo2.setEnabled(true);
    deviceConnectivityInfo2.setHost("localhost");
    deviceConnectivityInfo2.setPort("Port");

    // Act and Assert
    assertNotEquals(deviceConnectivityInfo, deviceConnectivityInfo2);
  }

  /**
   * Test {@link DeviceConnectivityInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityInfo.equals(Object)",
    "int DeviceConnectivityInfo.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost("localhost");
    deviceConnectivityInfo.setPort("Port");

    // Act and Assert
    assertNotEquals(deviceConnectivityInfo, null);
  }

  /**
   * Test {@link DeviceConnectivityInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityInfo#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityInfo.equals(Object)",
    "int DeviceConnectivityInfo.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost("localhost");
    deviceConnectivityInfo.setPort("Port");

    // Act and Assert
    assertNotEquals(deviceConnectivityInfo, "Different type to DeviceConnectivityInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link DeviceConnectivityInfo}
   *   <li>{@link DeviceConnectivityInfo#setEnabled(boolean)}
   *   <li>{@link DeviceConnectivityInfo#setHost(String)}
   *   <li>{@link DeviceConnectivityInfo#setPort(String)}
   *   <li>{@link DeviceConnectivityInfo#toString()}
   *   <li>{@link DeviceConnectivityInfo#getHost()}
   *   <li>{@link DeviceConnectivityInfo#getPort()}
   *   <li>{@link DeviceConnectivityInfo#isEnabled()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceConnectivityInfo.<init>()",
    "String DeviceConnectivityInfo.getHost()",
    "String DeviceConnectivityInfo.getPort()",
    "boolean DeviceConnectivityInfo.isEnabled()",
    "void DeviceConnectivityInfo.setEnabled(boolean)",
    "void DeviceConnectivityInfo.setHost(String)",
    "void DeviceConnectivityInfo.setPort(String)",
    "String DeviceConnectivityInfo.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DeviceConnectivityInfo actualDeviceConnectivityInfo = new DeviceConnectivityInfo();
    actualDeviceConnectivityInfo.setEnabled(true);
    actualDeviceConnectivityInfo.setHost("localhost");
    actualDeviceConnectivityInfo.setPort("Port");
    String actualToStringResult = actualDeviceConnectivityInfo.toString();
    String actualHost = actualDeviceConnectivityInfo.getHost();
    String actualPort = actualDeviceConnectivityInfo.getPort();

    // Assert
    assertEquals(
        "DeviceConnectivityInfo(enabled=true, host=localhost, port=Port)", actualToStringResult);
    assertEquals("Port", actualPort);
    assertEquals("localhost", actualHost);
    assertTrue(actualDeviceConnectivityInfo.isEnabled());
  }
}
