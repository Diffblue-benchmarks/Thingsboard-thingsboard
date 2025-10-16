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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.model.ModelConstants;

public class EventEntityDiffblueTest {
  /**
   * Test {@link EventEntity#getUuid()}.
   *
   * <p>Method under test: {@link EventEntity#getUuid()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID EventEntity.getUuid()"})
  public void testGetUuid() {
    // Arrange, Act and Assert
    assertNull(new ErrorEventEntity().getUuid());
  }

  /**
   * Test {@link EventEntity#setUuid(UUID)}.
   *
   * <p>Method under test: {@link EventEntity#setUuid(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventEntity.setUuid(UUID)"})
  public void testSetUuid() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    UUID id = ModelConstants.NULL_UUID;

    // Act
    errorEventEntity.setUuid(id);

    // Assert
    assertSame(id, errorEventEntity.getId());
    assertSame(id, errorEventEntity.getUuid());
  }

  /**
   * Test {@link EventEntity#getCreatedTime()}.
   *
   * <p>Method under test: {@link EventEntity#getCreatedTime()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long EventEntity.getCreatedTime()"})
  public void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new ErrorEventEntity().getCreatedTime());
  }

  /**
   * Test {@link EventEntity#setCreatedTime(long)}.
   *
   * <p>Method under test: {@link EventEntity#setCreatedTime(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventEntity.setCreatedTime(long)"})
  public void testSetCreatedTime() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();

    // Act
    errorEventEntity.setCreatedTime(1L);

    // Assert
    assertEquals(1L, errorEventEntity.getCreatedTime());
    assertEquals(1L, errorEventEntity.getTs());
  }

  /**
   * Test {@link EventEntity#getEntityId()}.
   *
   * <p>Method under test: {@link EventEntity#getEntityId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID EventEntity.getEntityId()"})
  public void testGetEntityId() {
    // Arrange, Act and Assert
    assertNull(new ErrorEventEntity().getEntityId());
  }

  /**
   * Test {@link EventEntity#getId()}.
   *
   * <p>Method under test: {@link EventEntity#getId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID EventEntity.getId()"})
  public void testGetId() {
    // Arrange, Act and Assert
    assertNull(new ErrorEventEntity().getId());
  }

  /**
   * Test {@link EventEntity#getServiceId()}.
   *
   * <p>Method under test: {@link EventEntity#getServiceId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String EventEntity.getServiceId()"})
  public void testGetServiceId() {
    // Arrange, Act and Assert
    assertNull(new ErrorEventEntity().getServiceId());
  }

  /**
   * Test {@link EventEntity#getTenantId()}.
   *
   * <p>Method under test: {@link EventEntity#getTenantId()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID EventEntity.getTenantId()"})
  public void testGetTenantId() {
    // Arrange, Act and Assert
    assertNull(new ErrorEventEntity().getTenantId());
  }

  /**
   * Test {@link EventEntity#getTs()}.
   *
   * <p>Method under test: {@link EventEntity#getTs()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"long EventEntity.getTs()"})
  public void testGetTs() {
    // Arrange, Act and Assert
    assertEquals(0L, new ErrorEventEntity().getTs());
  }

  /**
   * Test {@link EventEntity#setEntityId(UUID)}.
   *
   * <p>Method under test: {@link EventEntity#setEntityId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventEntity.setEntityId(UUID)"})
  public void testSetEntityId() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    UUID entityId = ModelConstants.NULL_UUID;

    // Act
    errorEventEntity.setEntityId(entityId);

    // Assert
    assertSame(entityId, errorEventEntity.getEntityId());
  }

  /**
   * Test {@link EventEntity#setId(UUID)}.
   *
   * <p>Method under test: {@link EventEntity#setId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventEntity.setId(UUID)"})
  public void testSetId() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    UUID id = ModelConstants.NULL_UUID;

    // Act
    errorEventEntity.setId(id);

    // Assert
    assertSame(id, errorEventEntity.getId());
    assertSame(id, errorEventEntity.getUuid());
  }

  /**
   * Test {@link EventEntity#setServiceId(String)}.
   *
   * <p>Method under test: {@link EventEntity#setServiceId(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventEntity.setServiceId(String)"})
  public void testSetServiceId() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();

    // Act
    errorEventEntity.setServiceId("42");

    // Assert
    assertEquals("42", errorEventEntity.getServiceId());
  }

  /**
   * Test {@link EventEntity#setTenantId(UUID)}.
   *
   * <p>Method under test: {@link EventEntity#setTenantId(UUID)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventEntity.setTenantId(UUID)"})
  public void testSetTenantId() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    UUID tenantId = ModelConstants.NULL_UUID;

    // Act
    errorEventEntity.setTenantId(tenantId);

    // Assert
    assertSame(tenantId, errorEventEntity.getTenantId());
  }

  /**
   * Test {@link EventEntity#setTs(long)}.
   *
   * <p>Method under test: {@link EventEntity#setTs(long)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventEntity.setTs(long)"})
  public void testSetTs() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();

    // Act
    errorEventEntity.setTs(1L);

    // Assert
    assertEquals(1L, errorEventEntity.getCreatedTime());
    assertEquals(1L, errorEventEntity.getTs());
  }
}
