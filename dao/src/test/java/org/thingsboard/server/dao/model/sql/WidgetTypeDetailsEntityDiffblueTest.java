package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.widget.WidgetTypeDetails;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class WidgetTypeDetailsEntityDiffblueTest {
  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}, and {@link
   * WidgetTypeDetailsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeDetailsEntity#equals(Object)}
   *   <li>{@link WidgetTypeDetailsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
    int expectedHashCodeResult = widgetTypeDetailsEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeDetailsEntity2.hashCode());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}, and {@link
   * WidgetTypeDetailsEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeDetailsEntity#equals(Object)}
   *   <li>{@link WidgetTypeDetailsEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setVersion(1L);

    // Act and Assert
    assertEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity);
    int expectedHashCodeResult = widgetTypeDetailsEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeDetailsEntity.hashCode());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(3L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("Fqn");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription(null);
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(DoubleNode.valueOf(10.0d));
    widgetTypeDetailsEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(null);
    widgetTypeDetailsEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(null);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setImage("Fqn");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setImage(null);
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Fqn"});
    widgetTypeDetailsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, null);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean WidgetTypeDetailsEntity.equals(Object)",
    "int WidgetTypeDetailsEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, "Different type to WidgetTypeDetailsEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity()}
   *   <li>{@link WidgetTypeDetailsEntity#setDescription(String)}
   *   <li>{@link WidgetTypeDetailsEntity#setDescriptor(JsonNode)}
   *   <li>{@link WidgetTypeDetailsEntity#setExternalId(UUID)}
   *   <li>{@link WidgetTypeDetailsEntity#setImage(String)}
   *   <li>{@link WidgetTypeDetailsEntity#setTags(String[])}
   *   <li>{@link WidgetTypeDetailsEntity#toString()}
   *   <li>{@link WidgetTypeDetailsEntity#getDescription()}
   *   <li>{@link WidgetTypeDetailsEntity#getDescriptor()}
   *   <li>{@link WidgetTypeDetailsEntity#getExternalId()}
   *   <li>{@link WidgetTypeDetailsEntity#getImage()}
   *   <li>{@link WidgetTypeDetailsEntity#getTags()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void WidgetTypeDetailsEntity.<init>()",
    "String WidgetTypeDetailsEntity.getDescription()",
    "JsonNode WidgetTypeDetailsEntity.getDescriptor()",
    "UUID WidgetTypeDetailsEntity.getExternalId()",
    "String WidgetTypeDetailsEntity.getImage()",
    "String[] WidgetTypeDetailsEntity.getTags()",
    "void WidgetTypeDetailsEntity.setDescription(String)",
    "void WidgetTypeDetailsEntity.setDescriptor(JsonNode)",
    "void WidgetTypeDetailsEntity.setExternalId(UUID)",
    "void WidgetTypeDetailsEntity.setImage(String)",
    "void WidgetTypeDetailsEntity.setTags(String[])",
    "String WidgetTypeDetailsEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    WidgetTypeDetailsEntity actualWidgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    actualWidgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    JsonNode descriptor = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualWidgetTypeDetailsEntity.setDescriptor(descriptor);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualWidgetTypeDetailsEntity.setExternalId(externalId);
    actualWidgetTypeDetailsEntity.setImage("Image");
    String[] tags = new String[] {"Tags"};
    actualWidgetTypeDetailsEntity.setTags(tags);
    String actualToStringResult = actualWidgetTypeDetailsEntity.toString();
    String actualDescription = actualWidgetTypeDetailsEntity.getDescription();
    JsonNode actualDescriptor = actualWidgetTypeDetailsEntity.getDescriptor();
    UUID actualExternalId = actualWidgetTypeDetailsEntity.getExternalId();
    String actualImage = actualWidgetTypeDetailsEntity.getImage();
    String[] actualTags = actualWidgetTypeDetailsEntity.getTags();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualExternalId.toString());
    assertEquals("Image", actualImage);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(
        "WidgetTypeDetailsEntity(image=Image, description=The characteristics of someone or something, tags=[Tags],"
            + " descriptor={\"isPublic\":true}, externalId=784f394c-42b6-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertNull(actualWidgetTypeDetailsEntity.getVersion());
    assertNull(actualWidgetTypeDetailsEntity.getFqn());
    assertNull(actualWidgetTypeDetailsEntity.getName());
    assertNull(actualWidgetTypeDetailsEntity.getId());
    assertNull(actualWidgetTypeDetailsEntity.getUuid());
    assertNull(actualWidgetTypeDetailsEntity.getTenantId());
    assertEquals(0L, actualWidgetTypeDetailsEntity.getCreatedTime());
    assertFalse(actualWidgetTypeDetailsEntity.isDeprecated());
    assertFalse(actualWidgetTypeDetailsEntity.isScada());
    assertSame(externalId, actualExternalId);
    assertSame(tags, actualTags);
    assertSame(descriptor, actualDescriptor);
    assertArrayEquals(new String[] {"Tags"}, actualTags);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity(WidgetTypeDetails)}.
   *
   * <p>Method under test: {@link
   * WidgetTypeDetailsEntity#WidgetTypeDetailsEntity(WidgetTypeDetails)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WidgetTypeDetailsEntity.<init>(WidgetTypeDetails)"})
  public void testNewWidgetTypeDetailsEntity() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails(new WidgetTypeId(id));
    UUID id2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    widgetTypeDetails.setExternalId(new WidgetTypeId(id2));

    // Act
    WidgetTypeDetailsEntity actualWidgetTypeDetailsEntity =
        new WidgetTypeDetailsEntity(widgetTypeDetails);

    // Assert
    UUID id3 = actualWidgetTypeDetailsEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id3.toString());
    UUID externalId = actualWidgetTypeDetailsEntity.getExternalId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", externalId.toString());
    assertNull(actualWidgetTypeDetailsEntity.getTenantId());
    assertSame(id, id3);
    assertSame(id, actualWidgetTypeDetailsEntity.getUuid());
    assertSame(id2, externalId);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity(WidgetTypeDetails)}.
   *
   * <p>Method under test: {@link
   * WidgetTypeDetailsEntity#WidgetTypeDetailsEntity(WidgetTypeDetails)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WidgetTypeDetailsEntity.<init>(WidgetTypeDetails)"})
  public void testNewWidgetTypeDetailsEntity2() {
    // Arrange
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails(new WidgetTypeId(id));
    widgetTypeDetails.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    WidgetTypeDetailsEntity actualWidgetTypeDetailsEntity =
        new WidgetTypeDetailsEntity(widgetTypeDetails);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualWidgetTypeDetailsEntity.getTenantId().toString());
    UUID id2 = actualWidgetTypeDetailsEntity.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id2.toString());
    assertNull(actualWidgetTypeDetailsEntity.getExternalId());
    assertSame(id, id2);
    assertSame(id, actualWidgetTypeDetailsEntity.getUuid());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity(WidgetTypeDetails)}.
   *
   * <ul>
   *   <li>When {@link WidgetTypeDetails#WidgetTypeDetails()}.
   *   <li>Then return Id is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * WidgetTypeDetailsEntity#WidgetTypeDetailsEntity(WidgetTypeDetails)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void WidgetTypeDetailsEntity.<init>(WidgetTypeDetails)"})
  public void testNewWidgetTypeDetailsEntity_whenWidgetTypeDetails_thenReturnIdIsNull() {
    // Arrange and Act
    WidgetTypeDetailsEntity actualWidgetTypeDetailsEntity =
        new WidgetTypeDetailsEntity(new WidgetTypeDetails());

    // Assert
    assertNull(actualWidgetTypeDetailsEntity.getId());
    assertNull(actualWidgetTypeDetailsEntity.getUuid());
    assertNull(actualWidgetTypeDetailsEntity.getTenantId());
    assertNull(actualWidgetTypeDetailsEntity.getExternalId());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity()} TenantId is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WidgetTypeDetails WidgetTypeDetailsEntity.toData()"})
  public void testToData_givenWidgetTypeDetailsEntityTenantIdIsRandomUUID() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(UUID.randomUUID());
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    widgetTypeDetailsEntity.setUuid(id);
    widgetTypeDetailsEntity.setVersion(1L);
    widgetTypeDetailsEntity.setExternalId(null);

    // Act
    WidgetTypeDetails actualToDataResult = widgetTypeDetailsEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getDescriptor() instanceof ObjectNode);
    assertEquals("Fqn", actualToDataResult.getFqn());
    assertEquals("Image", actualToDataResult.getImage());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals(
        "The characteristics of someone or something", actualToDataResult.getDescription());
    assertNull(actualToDataResult.getExternalId());
    assertEquals(1, actualToDataResult.getTags().length);
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertTrue(actualToDataResult.isDeprecated());
    assertTrue(actualToDataResult.isScada());
    assertSame(id, actualToDataResult.getUuidId());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity()}.
   *   <li>Then return Descriptor is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WidgetTypeDetails WidgetTypeDetailsEntity.toData()"})
  public void testToData_givenWidgetTypeDetailsEntity_thenReturnDescriptorIsNull() {
    // Arrange and Act
    WidgetTypeDetails actualToDataResult = new WidgetTypeDetailsEntity().toData();

    // Assert
    assertNull(actualToDataResult.getDescriptor());
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getFqn());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getDescription());
    assertNull(actualToDataResult.getImage());
    assertNull(actualToDataResult.getTags());
    assertNull(actualToDataResult.getUuidId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(actualToDataResult.isDeprecated());
    assertFalse(actualToDataResult.isScada());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#toData()}.
   *
   * <ul>
   *   <li>Then Descriptor return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WidgetTypeDetails WidgetTypeDetailsEntity.toData()"})
  public void testToData_thenDescriptorReturnObjectNode() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    widgetTypeDetailsEntity.setUuid(id);
    widgetTypeDetailsEntity.setVersion(1L);
    widgetTypeDetailsEntity.setExternalId(null);

    // Act
    WidgetTypeDetails actualToDataResult = widgetTypeDetailsEntity.toData();

    // Assert
    assertTrue(actualToDataResult.getDescriptor() instanceof ObjectNode);
    assertEquals("Fqn", actualToDataResult.getFqn());
    assertEquals("Image", actualToDataResult.getImage());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals(
        "The characteristics of someone or something", actualToDataResult.getDescription());
    assertNull(actualToDataResult.getExternalId());
    assertEquals(1, actualToDataResult.getTags().length);
    assertEquals(1L, actualToDataResult.getVersion().longValue());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertTrue(actualToDataResult.isDeprecated());
    assertTrue(actualToDataResult.isScada());
    assertSame(id, actualToDataResult.getUuidId());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#toData()}.
   *
   * <ul>
   *   <li>Then return ExternalId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link WidgetTypeDetailsEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"WidgetTypeDetails WidgetTypeDetailsEntity.toData()"})
  public void testToData_thenReturnExternalIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[] {"Tags"});
    widgetTypeDetailsEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    widgetTypeDetailsEntity.setVersion(1L);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    widgetTypeDetailsEntity.setExternalId(externalId);

    // Act
    WidgetTypeDetails actualToDataResult = widgetTypeDetailsEntity.toData();

    // Assert
    WidgetTypeId externalId2 = actualToDataResult.getExternalId();
    UUID id = externalId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.WIDGET_TYPE, externalId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertEquals(externalId2, actualToDataResult.getId());
    assertSame(externalId, id);
  }
}
