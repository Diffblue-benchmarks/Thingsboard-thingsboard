package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EventEntityDiffblueTest {
  /**
   * Test {@link EventEntity#getUuid()}.
   *
   * <p>Method under test: {@link EventEntity#getUuid()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EventEntity.setUuid(UUID)"})
  public void testSetUuid() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EventEntity.setEntityId(UUID)"})
  public void testSetEntityId() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EventEntity.setId(UUID)"})
  public void testSetId() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
  @Category(MaintainedByDiffblue.class)
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EventEntity.setTenantId(UUID)"})
  public void testSetTenantId() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

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
  @Category(MaintainedByDiffblue.class)
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
