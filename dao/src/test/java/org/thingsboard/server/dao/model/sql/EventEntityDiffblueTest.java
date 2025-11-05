package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class EventEntityDiffblueTest {
  /**
   * Test {@link EventEntity#getUuid()}.
   *
   * <p>Method under test: {@link EventEntity#getUuid()}
   */
  @Test
  @DisplayName("Test getUuid()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID EventEntity.getUuid()"})
  void testGetUuid() {
    // Arrange, Act and Assert
    assertNull(new ErrorEventEntity().getUuid());
  }

  /**
   * Test {@link EventEntity#setUuid(UUID)}.
   *
   * <p>Method under test: {@link EventEntity#setUuid(UUID)}
   */
  @Test
  @DisplayName("Test setUuid(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventEntity.setUuid(UUID)"})
  void testSetUuid() {
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
  @DisplayName("Test getCreatedTime()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long EventEntity.getCreatedTime()"})
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, new ErrorEventEntity().getCreatedTime());
  }

  /**
   * Test {@link EventEntity#setCreatedTime(long)}.
   *
   * <p>Method under test: {@link EventEntity#setCreatedTime(long)}
   */
  @Test
  @DisplayName("Test setCreatedTime(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventEntity.setCreatedTime(long)"})
  void testSetCreatedTime() {
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
  @DisplayName("Test getEntityId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID EventEntity.getEntityId()"})
  void testGetEntityId() {
    // Arrange, Act and Assert
    assertNull(new ErrorEventEntity().getEntityId());
  }

  /**
   * Test {@link EventEntity#getId()}.
   *
   * <p>Method under test: {@link EventEntity#getId()}
   */
  @Test
  @DisplayName("Test getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID EventEntity.getId()"})
  void testGetId() {
    // Arrange, Act and Assert
    assertNull(new ErrorEventEntity().getId());
  }

  /**
   * Test {@link EventEntity#getServiceId()}.
   *
   * <p>Method under test: {@link EventEntity#getServiceId()}
   */
  @Test
  @DisplayName("Test getServiceId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String EventEntity.getServiceId()"})
  void testGetServiceId() {
    // Arrange, Act and Assert
    assertNull(new ErrorEventEntity().getServiceId());
  }

  /**
   * Test {@link EventEntity#getTenantId()}.
   *
   * <p>Method under test: {@link EventEntity#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"UUID EventEntity.getTenantId()"})
  void testGetTenantId() {
    // Arrange, Act and Assert
    assertNull(new ErrorEventEntity().getTenantId());
  }

  /**
   * Test {@link EventEntity#getTs()}.
   *
   * <p>Method under test: {@link EventEntity#getTs()}
   */
  @Test
  @DisplayName("Test getTs()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long EventEntity.getTs()"})
  void testGetTs() {
    // Arrange, Act and Assert
    assertEquals(0L, new ErrorEventEntity().getTs());
  }

  /**
   * Test {@link EventEntity#setEntityId(UUID)}.
   *
   * <p>Method under test: {@link EventEntity#setEntityId(UUID)}
   */
  @Test
  @DisplayName("Test setEntityId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventEntity.setEntityId(UUID)"})
  void testSetEntityId() {
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
  @DisplayName("Test setId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventEntity.setId(UUID)"})
  void testSetId() {
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
  @DisplayName("Test setServiceId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventEntity.setServiceId(String)"})
  void testSetServiceId() {
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
  @DisplayName("Test setTenantId(UUID)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventEntity.setTenantId(UUID)"})
  void testSetTenantId() {
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
  @DisplayName("Test setTs(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void EventEntity.setTs(long)"})
  void testSetTs() {
    // Arrange
    ErrorEventEntity errorEventEntity = new ErrorEventEntity();

    // Act
    errorEventEntity.setTs(1L);

    // Assert
    assertEquals(1L, errorEventEntity.getCreatedTime());
    assertEquals(1L, errorEventEntity.getTs());
  }
}
