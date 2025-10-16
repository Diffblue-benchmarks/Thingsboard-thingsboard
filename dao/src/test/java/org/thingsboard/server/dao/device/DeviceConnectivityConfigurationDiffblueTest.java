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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DeviceConnectivityConfigurationDiffblueTest {
  /**
   * Test {@link DeviceConnectivityConfiguration#equals(Object)}, and {@link
   * DeviceConnectivityConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceConnectivityConfiguration#equals(Object)}
   *   <li>{@link DeviceConnectivityConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityConfiguration.equals(Object)",
    "int DeviceConnectivityConfiguration.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceConnectivityConfiguration deviceConnectivityConfiguration =
        new DeviceConnectivityConfiguration();
    DeviceConnectivityConfiguration deviceConnectivityConfiguration2 =
        new DeviceConnectivityConfiguration();

    // Act and Assert
    assertEquals(deviceConnectivityConfiguration, deviceConnectivityConfiguration2);
    assertEquals(
        deviceConnectivityConfiguration.hashCode(), deviceConnectivityConfiguration2.hashCode());
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#equals(Object)}, and {@link
   * DeviceConnectivityConfiguration#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceConnectivityConfiguration#equals(Object)}
   *   <li>{@link DeviceConnectivityConfiguration#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityConfiguration.equals(Object)",
    "int DeviceConnectivityConfiguration.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceConnectivityConfiguration deviceConnectivityConfiguration =
        new DeviceConnectivityConfiguration();

    // Act and Assert
    assertEquals(deviceConnectivityConfiguration, deviceConnectivityConfiguration);
    int expectedHashCodeResult = deviceConnectivityConfiguration.hashCode();
    assertEquals(expectedHashCodeResult, deviceConnectivityConfiguration.hashCode());
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityConfiguration#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityConfiguration.equals(Object)",
    "int DeviceConnectivityConfiguration.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceConnectivityConfiguration(), 1);
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityConfiguration#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityConfiguration.equals(Object)",
    "int DeviceConnectivityConfiguration.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceConnectivityInfo deviceConnectivityInfo = new DeviceConnectivityInfo();
    deviceConnectivityInfo.setEnabled(true);
    deviceConnectivityInfo.setHost("localhost");
    deviceConnectivityInfo.setPort("Port");

    HashMap<String, DeviceConnectivityInfo> connectivity = new HashMap<>();
    connectivity.put("foo", deviceConnectivityInfo);

    DeviceConnectivityConfiguration deviceConnectivityConfiguration =
        new DeviceConnectivityConfiguration();
    deviceConnectivityConfiguration.setConnectivity(connectivity);

    // Act and Assert
    assertNotEquals(deviceConnectivityConfiguration, new DeviceConnectivityConfiguration());
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityConfiguration#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityConfiguration.equals(Object)",
    "int DeviceConnectivityConfiguration.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DeviceConnectivityConfiguration(), null);
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceConnectivityConfiguration#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceConnectivityConfiguration.equals(Object)",
    "int DeviceConnectivityConfiguration.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new DeviceConnectivityConfiguration(), "Different type to DeviceConnectivityConfiguration");
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#getConnectivity(String)} with {@code String}.
   *
   * <p>Method under test: {@link DeviceConnectivityConfiguration#getConnectivity(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "DeviceConnectivityInfo DeviceConnectivityConfiguration.getConnectivity(String)"
  })
  public void testGetConnectivityWithString() {
    // Arrange, Act and Assert
    assertNull(new DeviceConnectivityConfiguration().getConnectivity("Protocol"));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceConnectivityConfiguration#setConnectivity(Map)}
   *   <li>{@link DeviceConnectivityConfiguration#toString()}
   *   <li>{@link DeviceConnectivityConfiguration#getConnectivity()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Map DeviceConnectivityConfiguration.getConnectivity()",
    "void DeviceConnectivityConfiguration.setConnectivity(Map)",
    "String DeviceConnectivityConfiguration.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    DeviceConnectivityConfiguration deviceConnectivityConfiguration =
        new DeviceConnectivityConfiguration();
    HashMap<String, DeviceConnectivityInfo> connectivity = new HashMap<>();

    // Act
    deviceConnectivityConfiguration.setConnectivity(connectivity);
    String actualToStringResult = deviceConnectivityConfiguration.toString();
    Map<String, DeviceConnectivityInfo> actualConnectivity =
        deviceConnectivityConfiguration.getConnectivity();

    // Assert
    assertEquals("DeviceConnectivityConfiguration(connectivity={})", actualToStringResult);
    assertTrue(actualConnectivity.isEmpty());
    assertSame(connectivity, actualConnectivity);
  }

  /**
   * Test {@link DeviceConnectivityConfiguration#isEnabled(String)}.
   *
   * <p>Method under test: {@link DeviceConnectivityConfiguration#isEnabled(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean DeviceConnectivityConfiguration.isEnabled(String)"})
  public void testIsEnabled() {
    // Arrange, Act and Assert
    assertFalse(new DeviceConnectivityConfiguration().isEnabled("Protocol"));
  }
}
