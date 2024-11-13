package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.widget.WidgetTypeInfo;
import org.thingsboard.server.dao.model.ModelConstants;

public class WidgetTypeInfoEntityDiffblueTest {
  /**
   * Test {@link WidgetTypeInfoEntity#equals(Object)}, and
   * {@link WidgetTypeInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeInfoEntity#equals(Object)}
   *   <li>{@link WidgetTypeInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    WidgetTypeInfoEntity widgetTypeInfoEntity2 = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity2.setCreatedTime(1L);
    widgetTypeInfoEntity2.setDeprecated(true);
    widgetTypeInfoEntity2.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity2.setFqn("Fqn");
    widgetTypeInfoEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setImage("Image");
    widgetTypeInfoEntity2.setName("Name");
    widgetTypeInfoEntity2.setScada(true);
    widgetTypeInfoEntity2.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setVersion(1L);
    widgetTypeInfoEntity2.setWidgetType("Widget Type");

    // Act and Assert
    assertEquals(widgetTypeInfoEntity, widgetTypeInfoEntity2);
    int expectedHashCodeResult = widgetTypeInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeInfoEntity2.hashCode());
  }

  /**
   * Test {@link WidgetTypeInfoEntity#equals(Object)}, and
   * {@link WidgetTypeInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeInfoEntity#equals(Object)}
   *   <li>{@link WidgetTypeInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    // Act and Assert
    assertEquals(widgetTypeInfoEntity, widgetTypeInfoEntity);
    int expectedHashCodeResult = widgetTypeInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeInfoEntity.hashCode());
  }

  /**
   * Test {@link WidgetTypeInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(3L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    WidgetTypeInfoEntity widgetTypeInfoEntity2 = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity2.setCreatedTime(1L);
    widgetTypeInfoEntity2.setDeprecated(true);
    widgetTypeInfoEntity2.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity2.setFqn("Fqn");
    widgetTypeInfoEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setImage("Image");
    widgetTypeInfoEntity2.setName("Name");
    widgetTypeInfoEntity2.setScada(true);
    widgetTypeInfoEntity2.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setVersion(1L);
    widgetTypeInfoEntity2.setWidgetType("Widget Type");

    // Act and Assert
    assertNotEquals(widgetTypeInfoEntity, widgetTypeInfoEntity2);
  }

  /**
   * Test {@link WidgetTypeInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("Fqn");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    WidgetTypeInfoEntity widgetTypeInfoEntity2 = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity2.setCreatedTime(1L);
    widgetTypeInfoEntity2.setDeprecated(true);
    widgetTypeInfoEntity2.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity2.setFqn("Fqn");
    widgetTypeInfoEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setImage("Image");
    widgetTypeInfoEntity2.setName("Name");
    widgetTypeInfoEntity2.setScada(true);
    widgetTypeInfoEntity2.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setVersion(1L);
    widgetTypeInfoEntity2.setWidgetType("Widget Type");

    // Act and Assert
    assertNotEquals(widgetTypeInfoEntity, widgetTypeInfoEntity2);
  }

  /**
   * Test {@link WidgetTypeInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription(null);
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    WidgetTypeInfoEntity widgetTypeInfoEntity2 = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity2.setCreatedTime(1L);
    widgetTypeInfoEntity2.setDeprecated(true);
    widgetTypeInfoEntity2.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity2.setFqn("Fqn");
    widgetTypeInfoEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setImage("Image");
    widgetTypeInfoEntity2.setName("Name");
    widgetTypeInfoEntity2.setScada(true);
    widgetTypeInfoEntity2.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setVersion(1L);
    widgetTypeInfoEntity2.setWidgetType("Widget Type");

    // Act and Assert
    assertNotEquals(widgetTypeInfoEntity, widgetTypeInfoEntity2);
  }

  /**
   * Test {@link WidgetTypeInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Fqn");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    WidgetTypeInfoEntity widgetTypeInfoEntity2 = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity2.setCreatedTime(1L);
    widgetTypeInfoEntity2.setDeprecated(true);
    widgetTypeInfoEntity2.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity2.setFqn("Fqn");
    widgetTypeInfoEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setImage("Image");
    widgetTypeInfoEntity2.setName("Name");
    widgetTypeInfoEntity2.setScada(true);
    widgetTypeInfoEntity2.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setVersion(1L);
    widgetTypeInfoEntity2.setWidgetType("Widget Type");

    // Act and Assert
    assertNotEquals(widgetTypeInfoEntity, widgetTypeInfoEntity2);
  }

  /**
   * Test {@link WidgetTypeInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage(null);
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    WidgetTypeInfoEntity widgetTypeInfoEntity2 = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity2.setCreatedTime(1L);
    widgetTypeInfoEntity2.setDeprecated(true);
    widgetTypeInfoEntity2.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity2.setFqn("Fqn");
    widgetTypeInfoEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setImage("Image");
    widgetTypeInfoEntity2.setName("Name");
    widgetTypeInfoEntity2.setScada(true);
    widgetTypeInfoEntity2.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setVersion(1L);
    widgetTypeInfoEntity2.setWidgetType("Widget Type");

    // Act and Assert
    assertNotEquals(widgetTypeInfoEntity, widgetTypeInfoEntity2);
  }

  /**
   * Test {@link WidgetTypeInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[]{"Fqn"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    WidgetTypeInfoEntity widgetTypeInfoEntity2 = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity2.setCreatedTime(1L);
    widgetTypeInfoEntity2.setDeprecated(true);
    widgetTypeInfoEntity2.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity2.setFqn("Fqn");
    widgetTypeInfoEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setImage("Image");
    widgetTypeInfoEntity2.setName("Name");
    widgetTypeInfoEntity2.setScada(true);
    widgetTypeInfoEntity2.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setVersion(1L);
    widgetTypeInfoEntity2.setWidgetType("Widget Type");

    // Act and Assert
    assertNotEquals(widgetTypeInfoEntity, widgetTypeInfoEntity2);
  }

  /**
   * Test {@link WidgetTypeInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Fqn");

    WidgetTypeInfoEntity widgetTypeInfoEntity2 = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity2.setCreatedTime(1L);
    widgetTypeInfoEntity2.setDeprecated(true);
    widgetTypeInfoEntity2.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity2.setFqn("Fqn");
    widgetTypeInfoEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setImage("Image");
    widgetTypeInfoEntity2.setName("Name");
    widgetTypeInfoEntity2.setScada(true);
    widgetTypeInfoEntity2.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setVersion(1L);
    widgetTypeInfoEntity2.setWidgetType("Widget Type");

    // Act and Assert
    assertNotEquals(widgetTypeInfoEntity, widgetTypeInfoEntity2);
  }

  /**
   * Test {@link WidgetTypeInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType(null);

    WidgetTypeInfoEntity widgetTypeInfoEntity2 = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity2.setCreatedTime(1L);
    widgetTypeInfoEntity2.setDeprecated(true);
    widgetTypeInfoEntity2.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity2.setFqn("Fqn");
    widgetTypeInfoEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setImage("Image");
    widgetTypeInfoEntity2.setName("Name");
    widgetTypeInfoEntity2.setScada(true);
    widgetTypeInfoEntity2.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity2.setVersion(1L);
    widgetTypeInfoEntity2.setWidgetType("Widget Type");

    // Act and Assert
    assertNotEquals(widgetTypeInfoEntity, widgetTypeInfoEntity2);
  }

  /**
   * Test {@link WidgetTypeInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    // Act and Assert
    assertNotEquals(widgetTypeInfoEntity, null);
  }

  /**
   * Test {@link WidgetTypeInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");

    // Act and Assert
    assertNotEquals(widgetTypeInfoEntity, "Different type to WidgetTypeInfoEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of {@link WidgetTypeInfoEntity}
   *   <li>{@link WidgetTypeInfoEntity#setDescription(String)}
   *   <li>{@link WidgetTypeInfoEntity#setImage(String)}
   *   <li>{@link WidgetTypeInfoEntity#setTags(String[])}
   *   <li>{@link WidgetTypeInfoEntity#setWidgetType(String)}
   *   <li>{@link WidgetTypeInfoEntity#toString()}
   *   <li>{@link WidgetTypeInfoEntity#getDescription()}
   *   <li>{@link WidgetTypeInfoEntity#getImage()}
   *   <li>{@link WidgetTypeInfoEntity#getTags()}
   *   <li>{@link WidgetTypeInfoEntity#getWidgetType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    WidgetTypeInfoEntity actualWidgetTypeInfoEntity = new WidgetTypeInfoEntity();
    actualWidgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    actualWidgetTypeInfoEntity.setImage("Image");
    String[] tags = new String[]{"Tags"};
    actualWidgetTypeInfoEntity.setTags(tags);
    actualWidgetTypeInfoEntity.setWidgetType("Widget Type");
    String actualToStringResult = actualWidgetTypeInfoEntity.toString();
    String actualDescription = actualWidgetTypeInfoEntity.getDescription();
    String actualImage = actualWidgetTypeInfoEntity.getImage();
    String[] actualTags = actualWidgetTypeInfoEntity.getTags();

    // Assert that nothing has changed
    assertEquals("Image", actualImage);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals("Widget Type", actualWidgetTypeInfoEntity.getWidgetType());
    assertEquals(
        "WidgetTypeInfoEntity(image=Image, description=The characteristics of someone or something, tags=[Tags],"
            + " widgetType=Widget Type)",
        actualToStringResult);
    assertEquals(0L, actualWidgetTypeInfoEntity.getCreatedTime());
    assertFalse(actualWidgetTypeInfoEntity.isDeprecated());
    assertFalse(actualWidgetTypeInfoEntity.isScada());
    assertSame(tags, actualTags);
    assertArrayEquals(new String[]{"Tags"}, actualTags);
  }

  /**
   * Test {@link WidgetTypeInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link WidgetTypeInfoEntity} (default constructor).</li>
   *   <li>Then return Tags is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfoEntity#toData()}
   */
  @Test
  public void testToData_givenWidgetTypeInfoEntity_thenReturnTagsIsNull() {
    // Arrange and Act
    WidgetTypeInfo actualToDataResult = (new WidgetTypeInfoEntity()).toData();

    // Assert
    assertNull(actualToDataResult.getTags());
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getFqn());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getDescription());
    assertNull(actualToDataResult.getImage());
    assertNull(actualToDataResult.getWidgetType());
    assertNull(actualToDataResult.getUuidId());
    WidgetTypeId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(id.isNullUid());
    assertFalse(actualToDataResult.isDeprecated());
    assertFalse(actualToDataResult.isScada());
  }

  /**
   * Test {@link WidgetTypeInfoEntity#toData()}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnNotTenantIdNullUid() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");
    UUID tenantId = UUID.randomUUID();
    widgetTypeInfoEntity.setTenantId(tenantId);

    // Act and Assert
    TenantId tenantId2 = widgetTypeInfoEntity.toData().getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link WidgetTypeInfoEntity#toData()}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");
    widgetTypeInfoEntity.setTenantId(ModelConstants.NULL_UUID);

    // Act and Assert
    TenantId tenantId = widgetTypeInfoEntity.toData().getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link WidgetTypeInfoEntity#toData()}.
   * <ul>
   *   <li>Then return UuidId toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeInfoEntity#toData()}
   */
  @Test
  public void testToData_thenReturnUuidIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    WidgetTypeInfoEntity widgetTypeInfoEntity = new WidgetTypeInfoEntity();
    widgetTypeInfoEntity.setCreatedTime(1L);
    widgetTypeInfoEntity.setDeprecated(true);
    widgetTypeInfoEntity.setDescription("The characteristics of someone or something");
    widgetTypeInfoEntity.setFqn("Fqn");
    widgetTypeInfoEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setImage("Image");
    widgetTypeInfoEntity.setName("Name");
    widgetTypeInfoEntity.setScada(true);
    widgetTypeInfoEntity.setTags(new String[]{"Tags"});
    widgetTypeInfoEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeInfoEntity.setVersion(1L);
    widgetTypeInfoEntity.setWidgetType("Widget Type");
    widgetTypeInfoEntity.setTenantId(null);

    // Act
    WidgetTypeInfo actualToDataResult = widgetTypeInfoEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Fqn", actualToDataResult.getFqn());
    assertEquals("Image", actualToDataResult.getImage());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals("The characteristics of someone or something", actualToDataResult.getDescription());
    assertEquals("Widget Type", actualToDataResult.getWidgetType());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    WidgetTypeId id = actualToDataResult.getId();
    assertTrue(id.isNullUid());
    assertTrue(actualToDataResult.isDeprecated());
    assertTrue(actualToDataResult.isScada());
    assertSame(uuidId, id.getId());
    assertArrayEquals(new String[]{"Tags"}, actualToDataResult.getTags());
  }
}
