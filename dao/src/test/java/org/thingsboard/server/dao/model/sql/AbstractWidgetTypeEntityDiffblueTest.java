package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.widget.BaseWidgetType;

class AbstractWidgetTypeEntityDiffblueTest {
  /**
   * Test {@link AbstractWidgetTypeEntity#toBaseWidgetType()}.
   *
   * <p>Method under test: {@link AbstractWidgetTypeEntity#toBaseWidgetType()}
   */
  @Test
  @DisplayName("Test toBaseWidgetType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseWidgetType AbstractWidgetTypeEntity.toBaseWidgetType()"})
  void testToBaseWidgetType() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    TenantId tenantId = widgetTypeDetailsEntity.toBaseWidgetType().getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }

  /**
   * Test {@link AbstractWidgetTypeEntity#toBaseWidgetType()}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity()}.
   *   <li>Then return Version is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractWidgetTypeEntity#toBaseWidgetType()}
   */
  @Test
  @DisplayName(
      "Test toBaseWidgetType(); given WidgetTypeDetailsEntity(); then return Version is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseWidgetType AbstractWidgetTypeEntity.toBaseWidgetType()"})
  void testToBaseWidgetType_givenWidgetTypeDetailsEntity_thenReturnVersionIsNull() {
    // Arrange and Act
    BaseWidgetType actualToBaseWidgetTypeResult = new WidgetTypeDetailsEntity().toBaseWidgetType();

    // Assert
    assertNull(actualToBaseWidgetTypeResult.getVersion());
    assertNull(actualToBaseWidgetTypeResult.getFqn());
    assertNull(actualToBaseWidgetTypeResult.getName());
    assertNull(actualToBaseWidgetTypeResult.getUuidId());
    WidgetTypeId id = actualToBaseWidgetTypeResult.getId();
    assertNull(id.getId());
    assertNull(actualToBaseWidgetTypeResult.getTenantId());
    assertEquals(0L, actualToBaseWidgetTypeResult.getCreatedTime());
    assertEquals(EntityType.WIDGET_TYPE, id.getEntityType());
    assertFalse(id.isNullUid());
    assertFalse(actualToBaseWidgetTypeResult.isDeprecated());
    assertFalse(actualToBaseWidgetTypeResult.isScada());
  }

  /**
   * Test {@link AbstractWidgetTypeEntity#toBaseWidgetType()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link AbstractWidgetTypeEntity#toBaseWidgetType()}
   */
  @Test
  @DisplayName("Test toBaseWidgetType(); then return TenantId Id is randomUUID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"BaseWidgetType AbstractWidgetTypeEntity.toBaseWidgetType()"})
  void testToBaseWidgetType_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    UUID tenantId = UUID.randomUUID();
    widgetTypeDetailsEntity.setTenantId(tenantId);

    // Act and Assert
    TenantId tenantId2 = widgetTypeDetailsEntity.toBaseWidgetType().getTenantId();
    assertEquals(EntityType.TENANT, tenantId2.getEntityType());
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link AbstractWidgetTypeEntity#getFqn()}.
   *
   * <p>Method under test: {@link AbstractWidgetTypeEntity#getFqn()}
   */
  @Test
  @DisplayName("Test getFqn()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractWidgetTypeEntity.getFqn()"})
  void testGetFqn() {
    // Arrange, Act and Assert
    assertNull(new WidgetTypeDetailsEntity().getFqn());
  }

  /**
   * Test {@link AbstractWidgetTypeEntity#getName()}.
   *
   * <p>Method under test: {@link AbstractWidgetTypeEntity#getName()}
   */
  @Test
  @DisplayName("Test getName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String AbstractWidgetTypeEntity.getName()"})
  void testGetName() {
    // Arrange, Act and Assert
    assertNull(new WidgetTypeDetailsEntity().getName());
  }

  /**
   * Test {@link AbstractWidgetTypeEntity#getTenantId()}.
   *
   * <p>Method under test: {@link AbstractWidgetTypeEntity#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"UUID AbstractWidgetTypeEntity.getTenantId()"})
  void testGetTenantId() {
    // Arrange, Act and Assert
    assertNull(new WidgetTypeDetailsEntity().getTenantId());
  }

  /**
   * Test {@link AbstractWidgetTypeEntity#isDeprecated()}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity()} Deprecated is {@code
   *       true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractWidgetTypeEntity#isDeprecated()}
   */
  @Test
  @DisplayName(
      "Test isDeprecated(); given WidgetTypeDetailsEntity() Deprecated is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractWidgetTypeEntity.isDeprecated()"})
  void testIsDeprecated_givenWidgetTypeDetailsEntityDeprecatedIsTrue_thenReturnTrue() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setDeprecated(true);

    // Act and Assert
    assertTrue(widgetTypeDetailsEntity.isDeprecated());
  }

  /**
   * Test {@link AbstractWidgetTypeEntity#isDeprecated()}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractWidgetTypeEntity#isDeprecated()}
   */
  @Test
  @DisplayName("Test isDeprecated(); given WidgetTypeDetailsEntity(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractWidgetTypeEntity.isDeprecated()"})
  void testIsDeprecated_givenWidgetTypeDetailsEntity_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new WidgetTypeDetailsEntity().isDeprecated());
  }

  /**
   * Test {@link AbstractWidgetTypeEntity#isScada()}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity()} Scada is {@code true}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractWidgetTypeEntity#isScada()}
   */
  @Test
  @DisplayName(
      "Test isScada(); given WidgetTypeDetailsEntity() Scada is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractWidgetTypeEntity.isScada()"})
  void testIsScada_givenWidgetTypeDetailsEntityScadaIsTrue_thenReturnTrue() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setScada(true);

    // Act and Assert
    assertTrue(widgetTypeDetailsEntity.isScada());
  }

  /**
   * Test {@link AbstractWidgetTypeEntity#isScada()}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity()}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AbstractWidgetTypeEntity#isScada()}
   */
  @Test
  @DisplayName("Test isScada(); given WidgetTypeDetailsEntity(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean AbstractWidgetTypeEntity.isScada()"})
  void testIsScada_givenWidgetTypeDetailsEntity_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new WidgetTypeDetailsEntity().isScada());
  }

  /**
   * Test {@link AbstractWidgetTypeEntity#setDeprecated(boolean)}.
   *
   * <p>Method under test: {@link AbstractWidgetTypeEntity#setDeprecated(boolean)}
   */
  @Test
  @DisplayName("Test setDeprecated(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractWidgetTypeEntity.setDeprecated(boolean)"})
  void testSetDeprecated() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();

    // Act
    widgetTypeDetailsEntity.setDeprecated(true);

    // Assert
    assertTrue(widgetTypeDetailsEntity.isDeprecated());
  }

  /**
   * Test {@link AbstractWidgetTypeEntity#setFqn(String)}.
   *
   * <p>Method under test: {@link AbstractWidgetTypeEntity#setFqn(String)}
   */
  @Test
  @DisplayName("Test setFqn(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractWidgetTypeEntity.setFqn(String)"})
  void testSetFqn() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();

    // Act
    widgetTypeDetailsEntity.setFqn("Fqn");

    // Assert
    assertEquals("Fqn", widgetTypeDetailsEntity.getFqn());
  }

  /**
   * Test {@link AbstractWidgetTypeEntity#setName(String)}.
   *
   * <p>Method under test: {@link AbstractWidgetTypeEntity#setName(String)}
   */
  @Test
  @DisplayName("Test setName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractWidgetTypeEntity.setName(String)"})
  void testSetName() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();

    // Act
    widgetTypeDetailsEntity.setName("Name");

    // Assert
    assertEquals("Name", widgetTypeDetailsEntity.getName());
  }

  /**
   * Test {@link AbstractWidgetTypeEntity#setScada(boolean)}.
   *
   * <p>Method under test: {@link AbstractWidgetTypeEntity#setScada(boolean)}
   */
  @Test
  @DisplayName("Test setScada(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractWidgetTypeEntity.setScada(boolean)"})
  void testSetScada() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();

    // Act
    widgetTypeDetailsEntity.setScada(true);

    // Assert
    assertTrue(widgetTypeDetailsEntity.isScada());
  }

  /**
   * Test {@link AbstractWidgetTypeEntity#setTenantId(UUID)}.
   *
   * <p>Method under test: {@link AbstractWidgetTypeEntity#setTenantId(UUID)}
   */
  @Test
  @DisplayName("Test setTenantId(UUID)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AbstractWidgetTypeEntity.setTenantId(UUID)"})
  void testSetTenantId() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    widgetTypeDetailsEntity.setTenantId(tenantId);

    // Assert
    assertSame(tenantId, widgetTypeDetailsEntity.getTenantId());
  }
}
