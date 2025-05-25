package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
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
import org.thingsboard.server.common.data.id.WidgetsBundleId;
import org.thingsboard.server.common.data.widget.WidgetsBundle;
import org.thingsboard.server.dao.model.ModelConstants;

public class WidgetsBundleEntityDiffblueTest {
  /**
   * Test {@link WidgetsBundleEntity#equals(Object)}, and {@link WidgetsBundleEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetsBundleEntity#equals(Object)}
   *   <li>{@link WidgetsBundleEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleEntity.equals(Object)", "int WidgetsBundleEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetsBundleEntity#equals(Object)}
   *   <li>{@link WidgetsBundleEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleEntity.equals(Object)", "int WidgetsBundleEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleEntity.equals(Object)", "int WidgetsBundleEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleEntity.equals(Object)", "int WidgetsBundleEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleEntity.equals(Object)", "int WidgetsBundleEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleEntity.equals(Object)", "int WidgetsBundleEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleEntity.equals(Object)", "int WidgetsBundleEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleEntity.equals(Object)", "int WidgetsBundleEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleEntity.equals(Object)", "int WidgetsBundleEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleEntity.equals(Object)", "int WidgetsBundleEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleEntity.equals(Object)", "int WidgetsBundleEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleEntity.equals(Object)", "int WidgetsBundleEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleEntity.equals(Object)", "int WidgetsBundleEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleEntity.equals(Object)", "int WidgetsBundleEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleEntity.equals(Object)", "int WidgetsBundleEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleEntity.equals(Object)", "int WidgetsBundleEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleEntity.equals(Object)", "int WidgetsBundleEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
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
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleEntity.equals(Object)", "int WidgetsBundleEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
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
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleEntity.equals(Object)", "int WidgetsBundleEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean WidgetsBundleEntity.equals(Object)", "int WidgetsBundleEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
   * <p>
   * Methods under test:
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WidgetsBundleEntity.<init>()", "String WidgetsBundleEntity.getAlias()",
      "String WidgetsBundleEntity.getDescription()", "UUID WidgetsBundleEntity.getExternalId()",
      "String WidgetsBundleEntity.getImage()", "Integer WidgetsBundleEntity.getOrder()",
      "UUID WidgetsBundleEntity.getTenantId()", "String WidgetsBundleEntity.getTitle()",
      "boolean WidgetsBundleEntity.isScada()", "void WidgetsBundleEntity.setAlias(String)",
      "void WidgetsBundleEntity.setDescription(String)", "void WidgetsBundleEntity.setExternalId(UUID)",
      "void WidgetsBundleEntity.setImage(String)", "void WidgetsBundleEntity.setOrder(Integer)",
      "void WidgetsBundleEntity.setScada(boolean)", "void WidgetsBundleEntity.setTenantId(UUID)",
      "void WidgetsBundleEntity.setTitle(String)", "String WidgetsBundleEntity.toString()"})
  public void testGettersAndSetters() {
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
   * <p>
   * Method under test: {@link WidgetsBundleEntity#WidgetsBundleEntity(WidgetsBundle)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WidgetsBundleEntity.<init>(WidgetsBundle)"})
  public void testNewWidgetsBundleEntity() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setTenantId(null);
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    widgetsBundle.setExternalId(new WidgetsBundleId(id));

    // Act
    WidgetsBundleEntity actualWidgetsBundleEntity = new WidgetsBundleEntity(widgetsBundle);

    // Assert
    assertNull(actualWidgetsBundleEntity.getOrder());
    assertNull(actualWidgetsBundleEntity.getVersion());
    assertNull(actualWidgetsBundleEntity.getAlias());
    assertNull(actualWidgetsBundleEntity.getDescription());
    assertNull(actualWidgetsBundleEntity.getImage());
    assertNull(actualWidgetsBundleEntity.getTitle());
    assertNull(actualWidgetsBundleEntity.getId());
    assertNull(actualWidgetsBundleEntity.getUuid());
    assertNull(actualWidgetsBundleEntity.getTenantId());
    assertEquals(0L, actualWidgetsBundleEntity.getCreatedTime());
    assertFalse(actualWidgetsBundleEntity.isScada());
    assertSame(id, actualWidgetsBundleEntity.getExternalId());
  }

  /**
   * Test {@link WidgetsBundleEntity#WidgetsBundleEntity(WidgetsBundle)}.
   * <p>
   * Method under test: {@link WidgetsBundleEntity#WidgetsBundleEntity(WidgetsBundle)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WidgetsBundleEntity.<init>(WidgetsBundle)"})
  public void testNewWidgetsBundleEntity2() {
    // Arrange
    WidgetsBundle widgetsBundle = new WidgetsBundle();
    widgetsBundle.setTenantId(ModelConstants.SYSTEM_TENANT);
    widgetsBundle.setExternalId(null);

    // Act
    WidgetsBundleEntity actualWidgetsBundleEntity = new WidgetsBundleEntity(widgetsBundle);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualWidgetsBundleEntity.getTenantId().toString());
    assertNull(actualWidgetsBundleEntity.getOrder());
    assertNull(actualWidgetsBundleEntity.getVersion());
    assertNull(actualWidgetsBundleEntity.getAlias());
    assertNull(actualWidgetsBundleEntity.getDescription());
    assertNull(actualWidgetsBundleEntity.getImage());
    assertNull(actualWidgetsBundleEntity.getTitle());
    assertNull(actualWidgetsBundleEntity.getId());
    assertNull(actualWidgetsBundleEntity.getUuid());
    assertNull(actualWidgetsBundleEntity.getExternalId());
    assertEquals(0L, actualWidgetsBundleEntity.getCreatedTime());
    assertFalse(actualWidgetsBundleEntity.isScada());
  }

  /**
   * Test {@link WidgetsBundleEntity#WidgetsBundleEntity(WidgetsBundle)}.
   * <ul>
   *   <li>When {@link WidgetsBundle#WidgetsBundle()}.</li>
   *   <li>Then return ExternalId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#WidgetsBundleEntity(WidgetsBundle)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WidgetsBundleEntity.<init>(WidgetsBundle)"})
  public void testNewWidgetsBundleEntity_whenWidgetsBundle_thenReturnExternalIdIsNull() {
    // Arrange and Act
    WidgetsBundleEntity actualWidgetsBundleEntity = new WidgetsBundleEntity(new WidgetsBundle());

    // Assert
    assertNull(actualWidgetsBundleEntity.getOrder());
    assertNull(actualWidgetsBundleEntity.getVersion());
    assertNull(actualWidgetsBundleEntity.getAlias());
    assertNull(actualWidgetsBundleEntity.getDescription());
    assertNull(actualWidgetsBundleEntity.getImage());
    assertNull(actualWidgetsBundleEntity.getTitle());
    assertNull(actualWidgetsBundleEntity.getId());
    assertNull(actualWidgetsBundleEntity.getUuid());
    assertNull(actualWidgetsBundleEntity.getExternalId());
    assertNull(actualWidgetsBundleEntity.getTenantId());
    assertEquals(0L, actualWidgetsBundleEntity.getCreatedTime());
    assertFalse(actualWidgetsBundleEntity.isScada());
  }

  /**
   * Test {@link WidgetsBundleEntity#toData()}.
   * <ul>
   *   <li>Given {@link WidgetsBundleEntity#WidgetsBundleEntity()} ExternalId is {@code null}.</li>
   *   <li>Then return ExternalId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WidgetsBundle WidgetsBundleEntity.toData()"})
  public void testToData_givenWidgetsBundleEntityExternalIdIsNull_thenReturnExternalIdIsNull() {
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
   * <ul>
   *   <li>Given {@link WidgetsBundleEntity#WidgetsBundleEntity()} TenantId is {@code null}.</li>
   *   <li>Then return TenantId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WidgetsBundle WidgetsBundleEntity.toData()"})
  public void testToData_givenWidgetsBundleEntityTenantIdIsNull_thenReturnTenantIdIsNull() {
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
   * <ul>
   *   <li>Given {@link WidgetsBundleEntity#WidgetsBundleEntity()}.</li>
   *   <li>Then return Order is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WidgetsBundle WidgetsBundleEntity.toData()"})
  public void testToData_givenWidgetsBundleEntity_thenReturnOrderIsNull() {
    // Arrange and Act
    WidgetsBundle actualToDataResult = (new WidgetsBundleEntity()).toData();

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
   * <ul>
   *   <li>Then return ExternalId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetsBundleEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WidgetsBundle WidgetsBundleEntity.toData()"})
  public void testToData_thenReturnExternalIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
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
