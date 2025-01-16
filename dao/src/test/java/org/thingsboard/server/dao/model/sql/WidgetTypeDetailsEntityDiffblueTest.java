package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.WidgetTypeId;
import org.thingsboard.server.common.data.widget.WidgetTypeDetails;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class WidgetTypeDetailsEntityDiffblueTest {
  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}, and
   * {@link WidgetTypeDetailsEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeDetailsEntity#equals(Object)}
   *   <li>{@link WidgetTypeDetailsEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
    int expectedHashCodeResult = widgetTypeDetailsEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeDetailsEntity2.hashCode());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}, and
   * {@link WidgetTypeDetailsEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetTypeDetailsEntity#equals(Object)}
   *   <li>{@link WidgetTypeDetailsEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    // Act and Assert
    assertEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity);
    int expectedHashCodeResult = widgetTypeDetailsEntity.hashCode();
    assertEquals(expectedHashCodeResult, widgetTypeDetailsEntity.hashCode());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(3L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("Fqn");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription(null);
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(MissingNode.getInstance());
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(null);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(mock(JsonNode.class));
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(UUID.randomUUID());
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(null);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Fqn");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage(null);
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[]{"Fqn"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    WidgetTypeDetailsEntity widgetTypeDetailsEntity2 = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity2.setCreatedTime(1L);
    widgetTypeDetailsEntity2.setDeprecated(true);
    widgetTypeDetailsEntity2.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity2.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity2.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setFqn("Fqn");
    widgetTypeDetailsEntity2.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setImage("Image");
    widgetTypeDetailsEntity2.setName("Name");
    widgetTypeDetailsEntity2.setScada(true);
    widgetTypeDetailsEntity2.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity2.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity2.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, widgetTypeDetailsEntity2);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, null);
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetailsEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);

    // Act and Assert
    assertNotEquals(widgetTypeDetailsEntity, "Different type to WidgetTypeDetailsEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange and Act
    WidgetTypeDetailsEntity actualWidgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    actualWidgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    JsonNode descriptor = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualWidgetTypeDetailsEntity.setDescriptor(descriptor);
    UUID externalId = ModelConstants.NULL_UUID;
    actualWidgetTypeDetailsEntity.setExternalId(externalId);
    actualWidgetTypeDetailsEntity.setImage("Image");
    String[] tags = new String[]{"Tags"};
    actualWidgetTypeDetailsEntity.setTags(tags);
    String actualToStringResult = actualWidgetTypeDetailsEntity.toString();
    String actualDescription = actualWidgetTypeDetailsEntity.getDescription();
    JsonNode actualDescriptor = actualWidgetTypeDetailsEntity.getDescriptor();
    UUID actualExternalId = actualWidgetTypeDetailsEntity.getExternalId();
    String actualImage = actualWidgetTypeDetailsEntity.getImage();
    String[] actualTags = actualWidgetTypeDetailsEntity.getTags();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalId.toString());
    assertEquals("Image", actualImage);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertEquals(
        "WidgetTypeDetailsEntity(image=Image, description=The characteristics of someone or something, tags=[Tags],"
            + " descriptor={\"isPublic\":true}, externalId=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertEquals(0L, actualWidgetTypeDetailsEntity.getCreatedTime());
    assertFalse(actualWidgetTypeDetailsEntity.isDeprecated());
    assertFalse(actualWidgetTypeDetailsEntity.isScada());
    assertSame(tags, actualTags);
    assertSame(descriptor, actualDescriptor);
    assertSame(externalId, actualExternalId);
    assertArrayEquals(new String[]{"Tags"}, actualTags);
  }

  /**
   * Test
   * {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity(WidgetTypeDetails)}.
   * <p>
   * Method under test:
   * {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity(WidgetTypeDetails)}
   */
  @Test
  public void testNewWidgetTypeDetailsEntity() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    WidgetTypeDetailsEntity actualWidgetTypeDetailsEntity = new WidgetTypeDetailsEntity(widgetTypeDetails);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualWidgetTypeDetailsEntity.getTenantId().toString());
    assertNull(actualWidgetTypeDetailsEntity.getTags());
    assertNull(actualWidgetTypeDetailsEntity.getDescriptor());
    assertNull(actualWidgetTypeDetailsEntity.getVersion());
    assertNull(actualWidgetTypeDetailsEntity.getFqn());
    assertNull(actualWidgetTypeDetailsEntity.getName());
    assertNull(actualWidgetTypeDetailsEntity.getDescription());
    assertNull(actualWidgetTypeDetailsEntity.getImage());
    assertNull(actualWidgetTypeDetailsEntity.getId());
    assertNull(actualWidgetTypeDetailsEntity.getUuid());
    assertNull(actualWidgetTypeDetailsEntity.getExternalId());
    assertEquals(0L, actualWidgetTypeDetailsEntity.getCreatedTime());
    assertFalse(actualWidgetTypeDetailsEntity.isDeprecated());
    assertFalse(actualWidgetTypeDetailsEntity.isScada());
  }

  /**
   * Test
   * {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity(WidgetTypeDetails)}.
   * <p>
   * Method under test:
   * {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity(WidgetTypeDetails)}
   */
  @Test
  public void testNewWidgetTypeDetailsEntity2() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();
    widgetTypeDetails.setExternalId(new WidgetTypeId(ModelConstants.NULL_UUID));

    // Act
    WidgetTypeDetailsEntity actualWidgetTypeDetailsEntity = new WidgetTypeDetailsEntity(widgetTypeDetails);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualWidgetTypeDetailsEntity.getExternalId().toString());
    assertNull(actualWidgetTypeDetailsEntity.getTags());
    assertNull(actualWidgetTypeDetailsEntity.getDescriptor());
    assertNull(actualWidgetTypeDetailsEntity.getVersion());
    assertNull(actualWidgetTypeDetailsEntity.getFqn());
    assertNull(actualWidgetTypeDetailsEntity.getName());
    assertNull(actualWidgetTypeDetailsEntity.getDescription());
    assertNull(actualWidgetTypeDetailsEntity.getImage());
    assertNull(actualWidgetTypeDetailsEntity.getId());
    assertNull(actualWidgetTypeDetailsEntity.getUuid());
    assertNull(actualWidgetTypeDetailsEntity.getTenantId());
    assertEquals(0L, actualWidgetTypeDetailsEntity.getCreatedTime());
    assertFalse(actualWidgetTypeDetailsEntity.isDeprecated());
    assertFalse(actualWidgetTypeDetailsEntity.isScada());
  }

  /**
   * Test
   * {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity(WidgetTypeDetails)}.
   * <ul>
   *   <li>When {@link WidgetTypeDetails#WidgetTypeDetails()}.</li>
   *   <li>Then return TenantId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity(WidgetTypeDetails)}
   */
  @Test
  public void testNewWidgetTypeDetailsEntity_whenWidgetTypeDetails_thenReturnTenantIdIsNull() {
    // Arrange and Act
    WidgetTypeDetailsEntity actualWidgetTypeDetailsEntity = new WidgetTypeDetailsEntity(new WidgetTypeDetails());

    // Assert
    assertNull(actualWidgetTypeDetailsEntity.getTags());
    assertNull(actualWidgetTypeDetailsEntity.getDescriptor());
    assertNull(actualWidgetTypeDetailsEntity.getVersion());
    assertNull(actualWidgetTypeDetailsEntity.getFqn());
    assertNull(actualWidgetTypeDetailsEntity.getName());
    assertNull(actualWidgetTypeDetailsEntity.getDescription());
    assertNull(actualWidgetTypeDetailsEntity.getImage());
    assertNull(actualWidgetTypeDetailsEntity.getId());
    assertNull(actualWidgetTypeDetailsEntity.getUuid());
    assertNull(actualWidgetTypeDetailsEntity.getTenantId());
    assertNull(actualWidgetTypeDetailsEntity.getExternalId());
    assertEquals(0L, actualWidgetTypeDetailsEntity.getCreatedTime());
    assertFalse(actualWidgetTypeDetailsEntity.isDeprecated());
    assertFalse(actualWidgetTypeDetailsEntity.isScada());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#toData()}.
   * <ul>
   *   <li>Given {@link WidgetTypeDetailsEntity#WidgetTypeDetailsEntity()}.</li>
   *   <li>Then return Tags is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetailsEntity#toData()}
   */
  @Test
  public void testToData_givenWidgetTypeDetailsEntity_thenReturnTagsIsNull() {
    // Arrange and Act
    WidgetTypeDetails actualToDataResult = (new WidgetTypeDetailsEntity()).toData();

    // Assert
    assertNull(actualToDataResult.getTags());
    assertNull(actualToDataResult.getDescriptor());
    assertNull(actualToDataResult.getVersion());
    assertNull(actualToDataResult.getFqn());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getDescription());
    assertNull(actualToDataResult.getImage());
    assertNull(actualToDataResult.getUuidId());
    WidgetTypeId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertNull(actualToDataResult.getTenantId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(id.isNullUid());
    assertFalse(actualToDataResult.isDeprecated());
    assertFalse(actualToDataResult.isScada());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#toData()}.
   * <ul>
   *   <li>Then return ExternalId EntityType is {@code WIDGET_TYPE}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetailsEntity#toData()}
   */
  @Test
  public void testToData_thenReturnExternalIdEntityTypeIsWidgetType() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);
    widgetTypeDetailsEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    WidgetTypeDetails actualToDataResult = widgetTypeDetailsEntity.toData();

    // Assert
    WidgetTypeId externalId = actualToDataResult.getExternalId();
    assertEquals(EntityType.WIDGET_TYPE, externalId.getEntityType());
    assertTrue(externalId.isNullUid());
    assertEquals(externalId, actualToDataResult.getId());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#toData()}.
   * <ul>
   *   <li>Then return not TenantId NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetailsEntity#toData()}
   */
  @Test
  public void testToData_thenReturnNotTenantIdNullUid() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    UUID tenantId = UUID.randomUUID();
    widgetTypeDetailsEntity.setTenantId(tenantId);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);
    widgetTypeDetailsEntity.setExternalId(null);

    // Act and Assert
    TenantId tenantId2 = widgetTypeDetailsEntity.toData().getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link WidgetTypeDetailsEntity#toData()}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link WidgetTypeDetailsEntity#toData()}
   */
  @Test
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    WidgetTypeDetailsEntity widgetTypeDetailsEntity = new WidgetTypeDetailsEntity();
    widgetTypeDetailsEntity.setCreatedTime(1L);
    widgetTypeDetailsEntity.setDeprecated(true);
    widgetTypeDetailsEntity.setDescription("The characteristics of someone or something");
    widgetTypeDetailsEntity.setDescriptor(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    widgetTypeDetailsEntity.setFqn("Fqn");
    widgetTypeDetailsEntity.setId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setImage("Image");
    widgetTypeDetailsEntity.setName("Name");
    widgetTypeDetailsEntity.setScada(true);
    widgetTypeDetailsEntity.setTags(new String[]{"Tags"});
    widgetTypeDetailsEntity.setTenantId(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setUuid(ModelConstants.NULL_UUID);
    widgetTypeDetailsEntity.setVersion(1L);
    widgetTypeDetailsEntity.setExternalId(null);

    // Act
    WidgetTypeDetails actualToDataResult = widgetTypeDetailsEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertTrue(actualToDataResult.getId().isNullUid());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
