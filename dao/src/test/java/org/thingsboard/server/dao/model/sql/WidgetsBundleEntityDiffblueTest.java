package org.thingsboard.server.dao.model.sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.common.data.widget.WidgetsBundle;
import org.thingsboard.server.dao.model.ModelConstants;

class WidgetsBundleEntityDiffblueTest {
  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}, and {@link WidgetsBundleEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleEntity#equals(Object)}
   *   <li>{@link WidgetsBundleEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(widgetsBundleEntity, widgetsBundleEntity2);
    int expectedHashCodeResult = widgetsBundleEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetsBundleEntity2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}, and {@link WidgetsBundleEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleEntity#equals(Object)}
   *   <li>{@link WidgetsBundleEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias(null);
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias(null);
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(widgetsBundleEntity, widgetsBundleEntity2);
    int expectedHashCodeResult = widgetsBundleEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetsBundleEntity2.hashCode());
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}, and {@link WidgetsBundleEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleEntity#equals(Object)}
   *   <li>{@link WidgetsBundleEntity#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);

    // Act and Assert
    assertEquals(widgetsBundleEntity, widgetsBundleEntity);
    int expectedHashCodeResult = widgetsBundleEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetsBundleEntity.hashCode());
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Dr");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias(null);
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(3L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("Alias");
    widgetsBundleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription(null);
    widgetsBundleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(null);
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Alias");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage(null);
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(3);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(null);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(false);
    widgetsBundleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(null);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setTitle("Mr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setTitle(null);
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);

    WidgetsBundleEntity widgetsBundleEntity2 = new WidgetsBundleEntity();
    widgetsBundleEntity2.setAlias("Alias");
    widgetsBundleEntity2.setCreatedTime(1L);
    widgetsBundleEntity2.setDescription("The characteristics of someone or something");
    widgetsBundleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setImage("Image");
    widgetsBundleEntity2.setOrder(1);
    widgetsBundleEntity2.setScada(true);
    widgetsBundleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setTitle("Dr");
    widgetsBundleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, widgetsBundleEntity2);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, null);
  }

  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean WidgetsBundleEntity.equals(Object)",
    "int WidgetsBundleEntity.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetsBundleEntity, "Different type to WidgetsBundleEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetsBundleEntity#WidgetsBundleEntity()}
   *   <li>{@link WidgetsBundleEntity#setAlias(String)}
   *   <li>{@link WidgetsBundleEntity#setDescription(String)}
   *   <li>{@link WidgetsBundleEntity#setExternalId(UUID)}
   *   <li>{@link WidgetsBundleEntity#setImage(String)}
   *   <li>{@link WidgetsBundleEntity#setOrder(Integer)}
   *   <li>{@link WidgetsBundleEntity#setScada(boolean)}
   *   <li>{@link WidgetsBundleEntity#setTenantId(UUID)}
   *   <li>{@link WidgetsBundleEntity#setTitle(String)}
   *   <li>{@link WidgetsBundleEntity#toString()}
   *   <li>{@link WidgetsBundleEntity#getAlias()}
   *   <li>{@link WidgetsBundleEntity#getDescription()}
   *   <li>{@link WidgetsBundleEntity#getExternalId()}
   *   <li>{@link WidgetsBundleEntity#getImage()}
   *   <li>{@link WidgetsBundleEntity#getOrder()}
   *   <li>{@link WidgetsBundleEntity#getTenantId()}
   *   <li>{@link WidgetsBundleEntity#getTitle()}
   *   <li>{@link WidgetsBundleEntity#isScada()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void WidgetsBundleEntity.<init>()",
    "String WidgetsBundleEntity.getAlias()",
    "String WidgetsBundleEntity.getDescription()",
    "UUID WidgetsBundleEntity.getExternalId()",
    "String WidgetsBundleEntity.getImage()",
    "Integer WidgetsBundleEntity.getOrder()",
    "UUID WidgetsBundleEntity.getTenantId()",
    "String WidgetsBundleEntity.getTitle()",
    "boolean WidgetsBundleEntity.isScada()",
    "void WidgetsBundleEntity.setAlias(String)",
    "void WidgetsBundleEntity.setDescription(String)",
    "void WidgetsBundleEntity.setExternalId(UUID)",
    "void WidgetsBundleEntity.setImage(String)",
    "void WidgetsBundleEntity.setOrder(Integer)",
    "void WidgetsBundleEntity.setScada(boolean)",
    "void WidgetsBundleEntity.setTenantId(UUID)",
    "void WidgetsBundleEntity.setTitle(String)",
    "String WidgetsBundleEntity.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    WidgetsBundleEntity actualWidgetsBundleEntity = new WidgetsBundleEntity();
    actualWidgetsBundleEntity.setAlias("Alias");
    actualWidgetsBundleEntity.setDescription("The characteristics of someone or something");
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualWidgetsBundleEntity.setExternalId(externalId);
    actualWidgetsBundleEntity.setImage("Image");
    actualWidgetsBundleEntity.setOrder(1);
    actualWidgetsBundleEntity.setScada(true);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualWidgetsBundleEntity.setTenantId(tenantId);
    actualWidgetsBundleEntity.setTitle("Dr");
    String actualToStringResult = actualWidgetsBundleEntity.toString();
    String actualAlias = actualWidgetsBundleEntity.getAlias();
    String actualDescription = actualWidgetsBundleEntity.getDescription();
    UUID actualExternalId = actualWidgetsBundleEntity.getExternalId();
    String actualImage = actualWidgetsBundleEntity.getImage();
    Integer actualOrder = actualWidgetsBundleEntity.getOrder();
    UUID actualTenantId = actualWidgetsBundleEntity.getTenantId();
    String actualTitle = actualWidgetsBundleEntity.getTitle();
    boolean actualIsScadaResult = actualWidgetsBundleEntity.isScada();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualExternalId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("Alias", actualAlias);
    assertEquals("Dr", actualTitle);
    assertEquals("Image", actualImage);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(
        "WidgetsBundleEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, alias=Alias, title=Dr, image=Image,"
            + " scada=true, description=The characteristics of someone or something, order=1, externalId=784f394c"
            + "-42b6-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertNull(actualWidgetsBundleEntity.getVersion());
    assertNull(actualWidgetsBundleEntity.getId());
    assertNull(actualWidgetsBundleEntity.getUuid());
    assertEquals(0L, actualWidgetsBundleEntity.getCreatedTime());
    assertEquals(1, actualOrder.intValue());
    assertTrue(actualIsScadaResult);
    assertSame(externalId, actualExternalId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link WidgetsBundleEntity#WidgetsBundleEntity(WidgetsBundle)}.
   *
   * <p>Method under test: {@link WidgetsBundleEntity#WidgetsBundleEntity(WidgetsBundle)}
   */
  @Test
  @DisplayName("Test new WidgetsBundleEntity(WidgetsBundle)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetsBundleEntity.<init>(WidgetsBundle)"})
  void testNewWidgetsBundleEntity() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    WidgetsBundle widgetsBundle = new WidgetsBundle(new WidgetsBundleId(id));
    widgetsBundle.setTenantId(null);
    UUID id2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    widgetsBundle.setExternalId(new WidgetsBundleId(id2));

    // Act
    WidgetsBundleEntity actualWidgetsBundleEntity = new WidgetsBundleEntity(widgetsBundle);

    // Assert
    UUID id3 = actualWidgetsBundleEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id3.toString());
    UUID externalId = actualWidgetsBundleEntity.getExternalId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", externalId.toString());
    assertNull(actualWidgetsBundleEntity.getTenantId());
    assertSame(id, id3);
    assertSame(id, actualWidgetsBundleEntity.getUuid());
    assertSame(id2, externalId);
  }

  /**
   * Test {@link WidgetsBundleEntity#WidgetsBundleEntity(WidgetsBundle)}.
   *
   * <p>Method under test: {@link WidgetsBundleEntity#WidgetsBundleEntity(WidgetsBundle)}
   */
  @Test
  @DisplayName("Test new WidgetsBundleEntity(WidgetsBundle)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetsBundleEntity.<init>(WidgetsBundle)"})
  void testNewWidgetsBundleEntity2() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    WidgetsBundle widgetsBundle = new WidgetsBundle(new WidgetsBundleId(id));
    widgetsBundle.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetsBundle.setExternalId(null);

    // Act
    WidgetsBundleEntity actualWidgetsBundleEntity = new WidgetsBundleEntity(widgetsBundle);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualWidgetsBundleEntity.getTenantId().toString());
    UUID id2 = actualWidgetsBundleEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertNull(actualWidgetsBundleEntity.getExternalId());
    assertSame(id, id2);
    assertSame(id, actualWidgetsBundleEntity.getUuid());
  }

  /**
   * Test {@link WidgetsBundleEntity#WidgetsBundleEntity(WidgetsBundle)}.
   *
   * <ul>
   *   <li>When {@link WidgetsBundle#WidgetsBundle()}.
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#WidgetsBundleEntity(WidgetsBundle)}
   */
  @Test
  @DisplayName(
      "Test new WidgetsBundleEntity(WidgetsBundle); when WidgetsBundle(); then return Id is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void WidgetsBundleEntity.<init>(WidgetsBundle)"})
  void testNewWidgetsBundleEntity_whenWidgetsBundle_thenReturnIdIsNull() {
    // Arrange and Act
    WidgetsBundleEntity actualWidgetsBundleEntity = new WidgetsBundleEntity(new WidgetsBundle());

    // Assert
    assertNull(actualWidgetsBundleEntity.getId());
    assertNull(actualWidgetsBundleEntity.getUuid());
    assertNull(actualWidgetsBundleEntity.getExternalId());
    assertNull(actualWidgetsBundleEntity.getTenantId());
  }

  /**
   * Test {@link WidgetsBundleEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link WidgetsBundleEntity#WidgetsBundleEntity()} ExternalId is {@code null}.
   *   <li>Then return ExternalId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given WidgetsBundleEntity() ExternalId is 'null'; then return ExternalId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WidgetsBundle WidgetsBundleEntity.toData()"})
  void testToData_givenWidgetsBundleEntityExternalIdIsNull_thenReturnExternalIdIsNull() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);
    widgetsBundleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setExternalId(null);

    // Act
    WidgetsBundle actualToDataResult = widgetsBundleEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertNull(actualToDataResult.getExternalId());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }

  /**
   * Test {@link WidgetsBundleEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link WidgetsBundleEntity#WidgetsBundleEntity()} TenantId is {@code null}.
   *   <li>Then return TenantId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); given WidgetsBundleEntity() TenantId is 'null'; then return TenantId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WidgetsBundle WidgetsBundleEntity.toData()"})
  void testToData_givenWidgetsBundleEntityTenantIdIsNull_thenReturnTenantIdIsNull() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);
    widgetsBundleEntity.setTenantId(null);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    widgetsBundleEntity.setExternalId(externalId);

    // Act
    WidgetsBundle actualToDataResult = widgetsBundleEntity.toData();

    // Assert
    WidgetsBundleId externalId2 = actualToDataResult.getExternalId();
    UUID id = externalId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(EntityType.WIDGETS_BUNDLE, externalId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertEquals(externalId2, actualToDataResult.getId());
    assertSame(externalId, id);
  }

  /**
   * Test {@link WidgetsBundleEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link WidgetsBundleEntity#WidgetsBundleEntity()}.
   *   <li>Then return Order is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#toData()}
   */
  @Test
  @DisplayName("Test toData(); given WidgetsBundleEntity(); then return Order is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WidgetsBundle WidgetsBundleEntity.toData()"})
  void testToData_givenWidgetsBundleEntity_thenReturnOrderIsNull() {
    // Arrange and Act
    WidgetsBundle actualToDataResult = new WidgetsBundleEntity().toData();

    // Assert
    assertNull(actualToDataResult.getOrder());
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getAlias());
    assertNull(actualToDataResult.getDescription());
    assertNull(actualToDataResult.getImage());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getTitle());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getId().getId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isScada());
  }

  /**
   * Test {@link WidgetsBundleEntity#toData()}.
   *
   * <ul>
   *   <li>Then return ExternalId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetsBundleEntity#toData()}
   */
  @Test
  @DisplayName(
      "Test toData(); then return ExternalId Id toString is '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"WidgetsBundle WidgetsBundleEntity.toData()"})
  void testToData_thenReturnExternalIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    WidgetsBundleEntity widgetsBundleEntity = new WidgetsBundleEntity();
    widgetsBundleEntity.setAlias("Alias");
    widgetsBundleEntity.setCreatedTime(1L);
    widgetsBundleEntity.setDescription("The characteristics of someone or something");
    widgetsBundleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setImage("Image");
    widgetsBundleEntity.setOrder(1);
    widgetsBundleEntity.setScada(true);
    widgetsBundleEntity.setTitle("Dr");
    widgetsBundleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetsBundleEntity.setVersion(1L);
    widgetsBundleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    widgetsBundleEntity.setExternalId(externalId);

    // Act
    WidgetsBundle actualToDataResult = widgetsBundleEntity.toData();

    // Assert
    WidgetsBundleId externalId2 = actualToDataResult.getExternalId();
    UUID id = externalId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(EntityType.WIDGETS_BUNDLE, externalId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertEquals(externalId2, actualToDataResult.getId());
    assertSame(externalId, id);
  }
}
