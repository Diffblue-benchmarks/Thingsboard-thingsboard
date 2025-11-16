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
package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DeviceCredentialsId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.security.DeviceCredentials;
import org.thingsboard.server.common.data.security.DeviceCredentialsType;
import org.thingsboard.server.dao.model.ModelConstants;

public class DeviceCredentialsEntityDiffblueTest {
  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}, and {@link
   * DeviceCredentialsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCredentialsEntity#equals(Object)}
   *   <li>{@link DeviceCredentialsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEntity.equals(Object)",
    "int DeviceCredentialsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
    assertEquals(deviceCredentialsEntity.hashCode(), deviceCredentialsEntity2.hashCode());
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}, and {@link
   * DeviceCredentialsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCredentialsEntity#equals(Object)}
   *   <li>{@link DeviceCredentialsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEntity.equals(Object)",
    "int DeviceCredentialsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId(null);
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId(null);
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
    assertEquals(deviceCredentialsEntity.hashCode(), deviceCredentialsEntity2.hashCode());
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}, and {@link
   * DeviceCredentialsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCredentialsEntity#equals(Object)}
   *   <li>{@link DeviceCredentialsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEntity.equals(Object)",
    "int DeviceCredentialsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(null);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(null);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
    assertEquals(deviceCredentialsEntity.hashCode(), deviceCredentialsEntity2.hashCode());
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}, and {@link
   * DeviceCredentialsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCredentialsEntity#equals(Object)}
   *   <li>{@link DeviceCredentialsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEntity.equals(Object)",
    "int DeviceCredentialsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue(null);
    deviceCredentialsEntity.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue(null);
    deviceCredentialsEntity2.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
    assertEquals(deviceCredentialsEntity.hashCode(), deviceCredentialsEntity2.hashCode());
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}, and {@link
   * DeviceCredentialsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCredentialsEntity#equals(Object)}
   *   <li>{@link DeviceCredentialsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEntity.equals(Object)",
    "int DeviceCredentialsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(null);
    deviceCredentialsEntity.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(null);
    deviceCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
    assertEquals(deviceCredentialsEntity.hashCode(), deviceCredentialsEntity2.hashCode());
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}, and {@link
   * DeviceCredentialsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCredentialsEntity#equals(Object)}
   *   <li>{@link DeviceCredentialsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEntity.equals(Object)",
    "int DeviceCredentialsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setVersion(1L);

    // Act and Assert
    assertEquals(deviceCredentialsEntity, deviceCredentialsEntity);
    int expectedHashCodeResult = deviceCredentialsEntity.hashCode();
    assertEquals(expectedHashCodeResult, deviceCredentialsEntity.hashCode());
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEntity.equals(Object)",
    "int DeviceCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(3L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEntity.equals(Object)",
    "int DeviceCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("Credentials Id");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEntity.equals(Object)",
    "int DeviceCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId(null);
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEntity.equals(Object)",
    "int DeviceCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(null);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEntity.equals(Object)",
    "int DeviceCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.X509_CERTIFICATE);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEntity.equals(Object)",
    "int DeviceCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("Credentials Value");
    deviceCredentialsEntity.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEntity.equals(Object)",
    "int DeviceCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue(null);
    deviceCredentialsEntity.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEntity.equals(Object)",
    "int DeviceCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(UUID.randomUUID());
    deviceCredentialsEntity.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEntity.equals(Object)",
    "int DeviceCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(null);
    deviceCredentialsEntity.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setVersion(1L);

    DeviceCredentialsEntity deviceCredentialsEntity2 = new DeviceCredentialsEntity();
    deviceCredentialsEntity2.setCreatedTime(1L);
    deviceCredentialsEntity2.setCredentialsId("42");
    deviceCredentialsEntity2.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity2.setCredentialsValue("42");
    deviceCredentialsEntity2.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentialsEntity, deviceCredentialsEntity2);
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEntity.equals(Object)",
    "int DeviceCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentialsEntity, null);
  }

  /**
   * Test {@link DeviceCredentialsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsEntity#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean DeviceCredentialsEntity.equals(Object)",
    "int DeviceCredentialsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setDeviceId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(deviceCredentialsEntity, "Different type to DeviceCredentialsEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeviceCredentialsEntity#DeviceCredentialsEntity()}
   *   <li>{@link DeviceCredentialsEntity#setCredentialsId(String)}
   *   <li>{@link DeviceCredentialsEntity#setCredentialsType(DeviceCredentialsType)}
   *   <li>{@link DeviceCredentialsEntity#setCredentialsValue(String)}
   *   <li>{@link DeviceCredentialsEntity#setDeviceId(UUID)}
   *   <li>{@link DeviceCredentialsEntity#toString()}
   *   <li>{@link DeviceCredentialsEntity#getCredentialsId()}
   *   <li>{@link DeviceCredentialsEntity#getCredentialsType()}
   *   <li>{@link DeviceCredentialsEntity#getCredentialsValue()}
   *   <li>{@link DeviceCredentialsEntity#getDeviceId()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void DeviceCredentialsEntity.<init>()",
    "String DeviceCredentialsEntity.getCredentialsId()",
    "DeviceCredentialsType DeviceCredentialsEntity.getCredentialsType()",
    "String DeviceCredentialsEntity.getCredentialsValue()",
    "UUID DeviceCredentialsEntity.getDeviceId()",
    "void DeviceCredentialsEntity.setCredentialsId(String)",
    "void DeviceCredentialsEntity.setCredentialsType(DeviceCredentialsType)",
    "void DeviceCredentialsEntity.setCredentialsValue(String)",
    "void DeviceCredentialsEntity.setDeviceId(UUID)",
    "String DeviceCredentialsEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DeviceCredentialsEntity actualDeviceCredentialsEntity = new DeviceCredentialsEntity();
    actualDeviceCredentialsEntity.setCredentialsId("42");
    actualDeviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    actualDeviceCredentialsEntity.setCredentialsValue("42");
    UUID deviceId = ModelConstants.NULL_UUID;
    actualDeviceCredentialsEntity.setDeviceId(deviceId);
    String actualToStringResult = actualDeviceCredentialsEntity.toString();
    String actualCredentialsId = actualDeviceCredentialsEntity.getCredentialsId();
    DeviceCredentialsType actualCredentialsType =
        actualDeviceCredentialsEntity.getCredentialsType();
    String actualCredentialsValue = actualDeviceCredentialsEntity.getCredentialsValue();
    UUID actualDeviceId = actualDeviceCredentialsEntity.getDeviceId();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDeviceId.toString());
    assertEquals("42", actualCredentialsId);
    assertEquals("42", actualCredentialsValue);
    assertEquals(
        "DeviceCredentialsEntity(deviceId=13814000-1dd2-11b2-8080-808080808080, credentialsType=ACCESS_TOKEN,"
            + " credentialsId=42, credentialsValue=42)",
        actualToStringResult);
    assertNull(actualDeviceCredentialsEntity.getVersion());
    assertNull(actualDeviceCredentialsEntity.getId());
    assertNull(actualDeviceCredentialsEntity.getUuid());
    assertEquals(0L, actualDeviceCredentialsEntity.getCreatedTime());
    assertEquals(DeviceCredentialsType.ACCESS_TOKEN, actualCredentialsType);
    assertSame(deviceId, actualDeviceId);
  }

  /**
   * Test {@link DeviceCredentialsEntity#DeviceCredentialsEntity(DeviceCredentials)}.
   *
   * <p>Method under test: {@link
   * DeviceCredentialsEntity#DeviceCredentialsEntity(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsEntity.<init>(DeviceCredentials)"})
  public void testNewDeviceCredentialsEntity() {
    // Arrange
    DeviceCredentials deviceCredentials =
        new DeviceCredentials(new DeviceCredentialsId(ModelConstants.NULL_UUID));
    deviceCredentials.setDeviceId(new DeviceId(ModelConstants.NULL_UUID));

    // Act
    DeviceCredentialsEntity actualDeviceCredentialsEntity =
        new DeviceCredentialsEntity(deviceCredentials);

    // Assert
    UUID deviceId = actualDeviceCredentialsEntity.getDeviceId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", deviceId.toString());
    assertNull(actualDeviceCredentialsEntity.getVersion());
    assertNull(actualDeviceCredentialsEntity.getCredentialsId());
    assertNull(actualDeviceCredentialsEntity.getCredentialsValue());
    assertNull(actualDeviceCredentialsEntity.getCredentialsType());
    assertEquals(0L, actualDeviceCredentialsEntity.getCreatedTime());
    assertSame(deviceId, actualDeviceCredentialsEntity.getId());
    assertSame(deviceId, actualDeviceCredentialsEntity.getUuid());
  }

  /**
   * Test {@link DeviceCredentialsEntity#DeviceCredentialsEntity(DeviceCredentials)}.
   *
   * <ul>
   *   <li>When {@link DeviceCredentials#DeviceCredentials()}.
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceCredentialsEntity#DeviceCredentialsEntity(DeviceCredentials)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceCredentialsEntity.<init>(DeviceCredentials)"})
  public void testNewDeviceCredentialsEntity_whenDeviceCredentials_thenReturnIdIsNull() {
    // Arrange and Act
    DeviceCredentialsEntity actualDeviceCredentialsEntity =
        new DeviceCredentialsEntity(new DeviceCredentials());

    // Assert
    assertNull(actualDeviceCredentialsEntity.getVersion());
    assertNull(actualDeviceCredentialsEntity.getCredentialsId());
    assertNull(actualDeviceCredentialsEntity.getCredentialsValue());
    assertNull(actualDeviceCredentialsEntity.getId());
    assertNull(actualDeviceCredentialsEntity.getUuid());
    assertNull(actualDeviceCredentialsEntity.getDeviceId());
    assertNull(actualDeviceCredentialsEntity.getCredentialsType());
    assertEquals(0L, actualDeviceCredentialsEntity.getCreatedTime());
  }

  /**
   * Test {@link DeviceCredentialsEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link DeviceCredentialsEntity#DeviceCredentialsEntity()}.
   *   <li>Then return Version is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceCredentials DeviceCredentialsEntity.toData()"})
  public void testToData_givenDeviceCredentialsEntity_thenReturnVersionIsNull() {
    // Arrange and Act
    DeviceCredentials actualToDataResult = new DeviceCredentialsEntity().toData();

    // Assert
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getCredentialsId());
    assertNull(actualToDataResult.getCredentialsValue());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    assertNull(actualToDataResult.getDeviceId());
    assertNull(actualToDataResult.getCredentialsType());
    assertEquals(0L, actualToDataResult.getCreatedTime());
  }

  /**
   * Test {@link DeviceCredentialsEntity#toData()}.
   *
   * <ul>
   *   <li>Then return UuidId toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceCredentialsEntity#toData()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceCredentials DeviceCredentialsEntity.toData()"})
  public void testToData_thenReturnUuidIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    DeviceCredentialsEntity deviceCredentialsEntity = new DeviceCredentialsEntity();
    deviceCredentialsEntity.setCreatedTime(1L);
    deviceCredentialsEntity.setCredentialsId("42");
    deviceCredentialsEntity.setCredentialsType(DeviceCredentialsType.ACCESS_TOKEN);
    deviceCredentialsEntity.setCredentialsValue("42");
    deviceCredentialsEntity.setId(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setUuid(ModelConstants.NULL_UUID);
    deviceCredentialsEntity.setVersion(1L);
    deviceCredentialsEntity.setDeviceId(ModelConstants.NULL_UUID);

    // Act
    DeviceCredentials actualToDataResult = deviceCredentialsEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("42", actualToDataResult.getCredentialsId());
    assertEquals("42", actualToDataResult.getCredentialsValue());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    DeviceId deviceId = actualToDataResult.getDeviceId();
    assertEquals(EntityType.DEVICE, deviceId.getEntityType());
    assertEquals(DeviceCredentialsType.ACCESS_TOKEN, actualToDataResult.getCredentialsType());
    assertTrue(deviceId.isNullUid());
    assertSame(uuidId, deviceId.getId());
    assertSame(uuidId, actualToDataResult.getId().getId());
  }
}
