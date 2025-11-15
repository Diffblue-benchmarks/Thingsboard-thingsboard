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
package org.thingsboard.server.cache.resourceInfo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TbResourceId;
import org.thingsboard.server.common.data.id.TenantId;

class ResourceInfoEvictEventDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ResourceInfoEvictEvent#equals(Object)}
   *   <li>{@link ResourceInfoEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ResourceInfoEvictEvent resourceInfoEvictEvent = new ResourceInfoEvictEvent(tenantId,
        new TbResourceId(UUID.randomUUID()));

    // Act and Assert
    assertEquals(resourceInfoEvictEvent, resourceInfoEvictEvent);
    int expectedHashCodeResult = resourceInfoEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, resourceInfoEvictEvent.hashCode());
  }

  /**
   * Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ResourceInfoEvictEvent resourceInfoEvictEvent = new ResourceInfoEvictEvent(tenantId,
        new TbResourceId(UUID.randomUUID()));
    TenantId tenantId2 = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, new ResourceInfoEvictEvent(tenantId2, new TbResourceId(UUID.randomUUID())));
  }

  /**
   * Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ResourceInfoEvictEvent resourceInfoEvictEvent = new ResourceInfoEvictEvent(null,
        new TbResourceId(UUID.randomUUID()));
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, new ResourceInfoEvictEvent(tenantId, new TbResourceId(UUID.randomUUID())));
  }

  /**
   * Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ResourceInfoEvictEvent resourceInfoEvictEvent = new ResourceInfoEvictEvent(new TenantId(UUID.randomUUID()),
        mock(TbResourceId.class));
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, new ResourceInfoEvictEvent(tenantId, new TbResourceId(UUID.randomUUID())));
  }

  /**
   * Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantId tenantId = new TenantId(null);
    ResourceInfoEvictEvent resourceInfoEvictEvent = new ResourceInfoEvictEvent(tenantId,
        new TbResourceId(UUID.randomUUID()));
    TenantId tenantId2 = new TenantId(null);

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, new ResourceInfoEvictEvent(tenantId2, new TbResourceId(UUID.randomUUID())));
  }

  /**
   * Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ResourceInfoEvictEvent resourceInfoEvictEvent = new ResourceInfoEvictEvent(null,
        new TbResourceId(UUID.randomUUID()));

    // Act and Assert
    assertNotEquals(resourceInfoEvictEvent, new ResourceInfoEvictEvent(null, new TbResourceId(UUID.randomUUID())));
  }

  /**
   * Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(new ResourceInfoEvictEvent(tenantId, new TbResourceId(UUID.randomUUID())), null);
  }

  /**
   * Method under test: {@link ResourceInfoEvictEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(new ResourceInfoEvictEvent(tenantId, new TbResourceId(UUID.randomUUID())),
        "Different type to ResourceInfoEvictEvent");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ResourceInfoEvictEvent#ResourceInfoEvictEvent(TenantId, TbResourceId)}
   *   <li>{@link ResourceInfoEvictEvent#toString()}
   *   <li>{@link ResourceInfoEvictEvent#getResourceId()}
   *   <li>{@link ResourceInfoEvictEvent#getTenantId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    TbResourceId resourceId = new TbResourceId(UUID.randomUUID());

    // Act
    ResourceInfoEvictEvent actualResourceInfoEvictEvent = new ResourceInfoEvictEvent(tenantId, resourceId);
    actualResourceInfoEvictEvent.toString();
    TbResourceId actualResourceId = actualResourceInfoEvictEvent.getResourceId();

    // Assert
    assertSame(resourceId, actualResourceId);
    assertSame(tenantId, actualResourceInfoEvictEvent.getTenantId());
  }
}
