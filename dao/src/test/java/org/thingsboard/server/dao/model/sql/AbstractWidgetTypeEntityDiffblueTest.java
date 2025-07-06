package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.widget.BaseWidgetType;

public class AbstractWidgetTypeEntityDiffblueTest {
  /**
   * Test {@link AbstractWidgetTypeEntity#toBaseWidgetType()}.
   *
   * <p>Method under test: {@link AbstractWidgetTypeEntity#toBaseWidgetType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BaseWidgetType AbstractWidgetTypeEntity.toBaseWidgetType()"})
  public void testToBaseWidgetType() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BaseWidgetType AbstractWidgetTypeEntity.toBaseWidgetType()"})
  public void testToBaseWidgetType_givenWidgetTypeDetailsEntity_thenReturnVersionIsNull() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"BaseWidgetType AbstractWidgetTypeEntity.toBaseWidgetType()"})
  public void testToBaseWidgetType_thenReturnTenantIdIdIsRandomUUID() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractWidgetTypeEntity.getFqn()"})
  public void testGetFqn() {
    // Arrange, Act and Assert
    assertNull(new WidgetTypeDetailsEntity().getFqn());
  }

  /**
   * Test {@link AbstractWidgetTypeEntity#getName()}.
   *
   * <p>Method under test: {@link AbstractWidgetTypeEntity#getName()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"String AbstractWidgetTypeEntity.getName()"})
  public void testGetName() {
    // Arrange, Act and Assert
    assertNull(new WidgetTypeDetailsEntity().getName());
  }

  /**
   * Test {@link AbstractWidgetTypeEntity#getTenantId()}.
   *
   * <p>Method under test: {@link AbstractWidgetTypeEntity#getTenantId()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UUID AbstractWidgetTypeEntity.getTenantId()"})
  public void testGetTenantId() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractWidgetTypeEntity.isDeprecated()"})
  public void testIsDeprecated_givenWidgetTypeDetailsEntityDeprecatedIsTrue_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractWidgetTypeEntity.isDeprecated()"})
  public void testIsDeprecated_givenWidgetTypeDetailsEntity_thenReturnFalse() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractWidgetTypeEntity.isScada()"})
  public void testIsScada_givenWidgetTypeDetailsEntityScadaIsTrue_thenReturnTrue() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AbstractWidgetTypeEntity.isScada()"})
  public void testIsScada_givenWidgetTypeDetailsEntity_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new WidgetTypeDetailsEntity().isScada());
  }

  /**
   * Test {@link AbstractWidgetTypeEntity#setDeprecated(boolean)}.
   *
   * <p>Method under test: {@link AbstractWidgetTypeEntity#setDeprecated(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractWidgetTypeEntity.setDeprecated(boolean)"})
  public void testSetDeprecated() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractWidgetTypeEntity.setFqn(String)"})
  public void testSetFqn() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractWidgetTypeEntity.setName(String)"})
  public void testSetName() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractWidgetTypeEntity.setScada(boolean)"})
  public void testSetScada() {
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AbstractWidgetTypeEntity.setTenantId(UUID)"})
  public void testSetTenantId() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    widgetTypeDetailsEntity.setTenantId(tenantId);

    // Assert
    assertSame(tenantId, widgetTypeDetailsEntity.getTenantId());
  }
}
