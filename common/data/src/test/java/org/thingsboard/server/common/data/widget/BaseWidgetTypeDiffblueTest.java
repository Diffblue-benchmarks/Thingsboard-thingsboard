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
package org.thingsboard.server.common.data.widget;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetTypeId;

class BaseWidgetTypeDiffblueTest {
  /**
   * Method under test: {@link BaseWidgetType#getId()}
   */
  @Test
  void testGetId() {
    // Arrange, Act and Assert
    assertNull((new BaseWidgetType()).getId());
  }

  /**
   * Method under test: {@link BaseWidgetType#getCreatedTime()}
   */
  @Test
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new BaseWidgetType()).getCreatedTime());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BaseWidgetType#equals(Object)}
   *   <li>{@link BaseWidgetType#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();
    BaseWidgetType baseWidgetType2 = new BaseWidgetType();

    // Act and Assert
    assertEquals(baseWidgetType, baseWidgetType2);
    int expectedHashCodeResult = baseWidgetType.hashCode();
    assertEquals(expectedHashCodeResult, baseWidgetType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BaseWidgetType#equals(Object)}
   *   <li>{@link BaseWidgetType#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();

    // Act and Assert
    assertEquals(baseWidgetType, baseWidgetType);
    int expectedHashCodeResult = baseWidgetType.hashCode();
    assertEquals(expectedHashCodeResult, baseWidgetType.hashCode());
  }

  /**
   * Method under test: {@link BaseWidgetType#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType(new WidgetTypeId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(baseWidgetType, new BaseWidgetType());
  }

  /**
   * Method under test: {@link BaseWidgetType#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();

    // Act and Assert
    assertNotEquals(baseWidgetType, new WidgetType());
  }

  /**
   * Method under test: {@link BaseWidgetType#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();
    WidgetType widgetType = mock(WidgetType.class);
    when(widgetType.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertNotEquals(baseWidgetType, widgetType);
  }

  /**
   * Method under test: {@link BaseWidgetType#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseWidgetType(), null);
  }

  /**
   * Method under test: {@link BaseWidgetType#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new BaseWidgetType(), "Different type to BaseWidgetType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BaseWidgetType#BaseWidgetType()}
   *   <li>{@link BaseWidgetType#setDeprecated(boolean)}
   *   <li>{@link BaseWidgetType#setFqn(String)}
   *   <li>{@link BaseWidgetType#setName(String)}
   *   <li>{@link BaseWidgetType#setScada(boolean)}
   *   <li>{@link BaseWidgetType#setTenantId(TenantId)}
   *   <li>{@link BaseWidgetType#setVersion(Long)}
   *   <li>{@link BaseWidgetType#toString()}
   *   <li>{@link BaseWidgetType#getFqn()}
   *   <li>{@link BaseWidgetType#getName()}
   *   <li>{@link BaseWidgetType#getTenantId()}
   *   <li>{@link BaseWidgetType#getVersion()}
   *   <li>{@link BaseWidgetType#isDeprecated()}
   *   <li>{@link BaseWidgetType#isScada()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    BaseWidgetType actualBaseWidgetType = new BaseWidgetType();
    actualBaseWidgetType.setDeprecated(true);
    actualBaseWidgetType.setFqn("Fqn");
    actualBaseWidgetType.setName("Name");
    actualBaseWidgetType.setScada(true);
    actualBaseWidgetType.setTenantId(TenantId.SYS_TENANT_ID);
    actualBaseWidgetType.setVersion(1L);
    String actualToStringResult = actualBaseWidgetType.toString();
    String actualFqn = actualBaseWidgetType.getFqn();
    String actualName = actualBaseWidgetType.getName();
    TenantId actualTenantId = actualBaseWidgetType.getTenantId();
    Long actualVersion = actualBaseWidgetType.getVersion();
    boolean actualIsDeprecatedResult = actualBaseWidgetType.isDeprecated();
    boolean actualIsScadaResult = actualBaseWidgetType.isScada();

    // Assert that nothing has changed
    assertEquals("BaseWidgetType(tenantId=13814000-1dd2-11b2-8080-808080808080, fqn=Fqn, name=Name, deprecated=true,"
        + " scada=true, version=1)", actualToStringResult);
    assertEquals("Fqn", actualFqn);
    assertEquals("Name", actualName);
    assertEquals(0L, actualBaseWidgetType.getCreatedTime());
    assertEquals(1L, actualVersion.longValue());
    assertTrue(actualIsDeprecatedResult);
    assertTrue(actualIsScadaResult);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link BaseWidgetType#BaseWidgetType(WidgetTypeId)}
   *   <li>{@link BaseWidgetType#setDeprecated(boolean)}
   *   <li>{@link BaseWidgetType#setFqn(String)}
   *   <li>{@link BaseWidgetType#setName(String)}
   *   <li>{@link BaseWidgetType#setScada(boolean)}
   *   <li>{@link BaseWidgetType#setTenantId(TenantId)}
   *   <li>{@link BaseWidgetType#setVersion(Long)}
   *   <li>{@link BaseWidgetType#toString()}
   *   <li>{@link BaseWidgetType#getFqn()}
   *   <li>{@link BaseWidgetType#getName()}
   *   <li>{@link BaseWidgetType#getTenantId()}
   *   <li>{@link BaseWidgetType#getVersion()}
   *   <li>{@link BaseWidgetType#isDeprecated()}
   *   <li>{@link BaseWidgetType#isScada()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    WidgetTypeId id = new WidgetTypeId(EntityId.NULL_UUID);

    // Act
    BaseWidgetType actualBaseWidgetType = new BaseWidgetType(id);
    actualBaseWidgetType.setDeprecated(true);
    actualBaseWidgetType.setFqn("Fqn");
    actualBaseWidgetType.setName("Name");
    actualBaseWidgetType.setScada(true);
    actualBaseWidgetType.setTenantId(TenantId.SYS_TENANT_ID);
    actualBaseWidgetType.setVersion(1L);
    String actualToStringResult = actualBaseWidgetType.toString();
    String actualFqn = actualBaseWidgetType.getFqn();
    String actualName = actualBaseWidgetType.getName();
    TenantId actualTenantId = actualBaseWidgetType.getTenantId();
    Long actualVersion = actualBaseWidgetType.getVersion();
    boolean actualIsDeprecatedResult = actualBaseWidgetType.isDeprecated();
    boolean actualIsScadaResult = actualBaseWidgetType.isScada();

    // Assert that nothing has changed
    assertEquals("BaseWidgetType(tenantId=13814000-1dd2-11b2-8080-808080808080, fqn=Fqn, name=Name, deprecated=true,"
        + " scada=true, version=1)", actualToStringResult);
    assertEquals("Fqn", actualFqn);
    assertEquals("Name", actualName);
    assertEquals(0L, actualBaseWidgetType.getCreatedTime());
    assertEquals(1L, actualVersion.longValue());
    assertTrue(actualIsDeprecatedResult);
    assertTrue(actualIsScadaResult);
    assertSame(id, actualBaseWidgetType.getId());
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Method under test: {@link BaseWidgetType#BaseWidgetType(BaseWidgetType)}
   */
  @Test
  void testNewBaseWidgetType() {
    // Arrange
    BaseWidgetType widgetType = new BaseWidgetType();

    // Act and Assert
    assertEquals(widgetType, new BaseWidgetType(widgetType));
  }

  /**
   * Method under test: {@link BaseWidgetType#BaseWidgetType(BaseWidgetType)}
   */
  @Test
  void testNewBaseWidgetType2() {
    // Arrange
    BaseWidgetType widgetType = new BaseWidgetType();
    widgetType.setDeprecated(true);

    // Act and Assert
    assertEquals(widgetType, new BaseWidgetType(widgetType));
  }
}
