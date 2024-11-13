package org.thingsboard.server.dao.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.databind.util.RawValue;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.sql.AdminSettingsEntity;

public class BaseSqlEntityDiffblueTest {
  /**
   * Test {@link BaseSqlEntity#getId()}.
   * <p>
   * Method under test: {@link BaseSqlEntity#getId()}
   */
  @Test
  public void testGetId() {
    // Arrange, Act and Assert
    assertNull((new AdminSettingsEntity()).getId());
  }

  /**
   * Test {@link BaseSqlEntity#getUuid()}.
   * <p>
   * Method under test: {@link BaseSqlEntity#getUuid()}
   */
  @Test
  public void testGetUuid() {
    // Arrange, Act and Assert
    assertNull((new AdminSettingsEntity()).getUuid());
  }

  /**
   * Test {@link BaseSqlEntity#getUuid(UUIDBased)} with {@code UUIDBased}.
   * <ul>
   *   <li>Then return toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#getUuid(UUIDBased)}
   */
  @Test
  public void testGetUuidWithUUIDBased_thenReturnToStringIs138140001dd211b28080808080808080() {
    // Arrange, Act and Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080",
        BaseSqlEntity.getUuid(ModelConstants.SYSTEM_TENANT).toString());
  }

  /**
   * Test {@link BaseSqlEntity#getUuid(UUIDBased)} with {@code UUIDBased}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#getUuid(UUIDBased)}
   */
  @Test
  public void testGetUuidWithUUIDBased_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BaseSqlEntity.getUuid(null));
  }

  /**
   * Test {@link BaseSqlEntity#setUuid(UUID)}.
   * <p>
   * Method under test: {@link BaseSqlEntity#setUuid(UUID)}
   */
  @Test
  public void testSetUuid() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    UUID id = ModelConstants.NULL_UUID;

    // Act
    adminSettingsEntity.setUuid(id);

    // Assert
    assertSame(id, adminSettingsEntity.getId());
    assertSame(id, adminSettingsEntity.getUuid());
  }

  /**
   * Test {@link BaseSqlEntity#getCreatedTime()}.
   * <p>
   * Method under test: {@link BaseSqlEntity#getCreatedTime()}
   */
  @Test
  public void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new AdminSettingsEntity()).getCreatedTime());
  }

  /**
   * Test {@link BaseSqlEntity#setCreatedTime(long)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then {@link AdminSettingsEntity#AdminSettingsEntity()} CreatedTime is
   * one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#setCreatedTime(long)}
   */
  @Test
  public void testSetCreatedTime_whenOne_thenAdminSettingsEntityCreatedTimeIsOne() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();

    // Act
    adminSettingsEntity.setCreatedTime(1L);

    // Assert
    assertEquals(1L, adminSettingsEntity.getCreatedTime());
  }

  /**
   * Test {@link BaseSqlEntity#setCreatedTime(long)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then {@link AdminSettingsEntity#AdminSettingsEntity()} CreatedTime is
   * zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#setCreatedTime(long)}
   */
  @Test
  public void testSetCreatedTime_whenZero_thenAdminSettingsEntityCreatedTimeIsZero() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();

    // Act
    adminSettingsEntity.setCreatedTime(0L);

    // Assert that nothing has changed
    assertEquals(0L, adminSettingsEntity.getCreatedTime());
  }

  /**
   * Test {@link BaseSqlEntity#getTenantUuid(TenantId)}.
   * <ul>
   *   <li>When {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#getTenantUuid(TenantId)}
   */
  @Test
  public void testGetTenantUuid_whenNull() {
    // Arrange, Act and Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", BaseSqlEntity.getTenantUuid(null).toString());
  }

  /**
   * Test {@link BaseSqlEntity#getTenantUuid(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#getTenantUuid(TenantId)}
   */
  @Test
  public void testGetTenantUuid_whenSystem_tenant() {
    // Arrange, Act and Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080",
        BaseSqlEntity.getTenantUuid(ModelConstants.SYSTEM_TENANT).toString());
  }

  /**
   * Test {@link BaseSqlEntity#getEntityId(UUID, Function)}.
   * <ul>
   *   <li>Given {@code Apply}.</li>
   *   <li>When {@link ModelConstants#NULL_UUID}.</li>
   *   <li>Then return {@code Apply}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#getEntityId(UUID, Function)}
   */
  @Test
  public void testGetEntityId_givenApply_whenNull_uuid_thenReturnApply() {
    // Arrange
    Function<UUID, Object> creator = mock(Function.class);
    when(creator.apply(Mockito.<UUID>any())).thenReturn("Apply");

    // Act
    Object actualEntityId = BaseSqlEntity.getEntityId(ModelConstants.NULL_UUID, creator);

    // Assert
    verify(creator).apply(isA(UUID.class));
    assertEquals("Apply", actualEntityId);
  }

  /**
   * Test {@link BaseSqlEntity#getEntityId(UUID, Function)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#getEntityId(UUID, Function)}
   */
  @Test
  public void testGetEntityId_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BaseSqlEntity.<Object>getEntityId(null, mock(Function.class)));
  }

  /**
   * Test {@link BaseSqlEntity#getTenantId(UUID)}.
   * <ul>
   *   <li>Then {@link ModelConstants#NULL_UUID} toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#getTenantId(UUID)}
   */
  @Test
  public void testGetTenantId_thenNull_uuidToStringIs138140001dd211b28080808080808080() {
    // Arrange
    UUID uuid = ModelConstants.NULL_UUID;

    // Act
    TenantId actualTenantId = BaseSqlEntity.getTenantId(uuid);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTenantId.getId().toString());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuid.toString());
    assertTrue(actualTenantId.isNullUid());
    assertTrue(actualTenantId.isSysTenantId());
  }

  /**
   * Test {@link BaseSqlEntity#getTenantId(UUID)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return EntityType is {@code TENANT}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#getTenantId(UUID)}
   */
  @Test
  public void testGetTenantId_whenNull_thenReturnEntityTypeIsTenant() {
    // Arrange and Act
    TenantId actualTenantId = BaseSqlEntity.getTenantId(null);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTenantId.getId().toString());
    assertEquals(EntityType.TENANT, actualTenantId.getEntityType());
    assertTrue(actualTenantId.isNullUid());
    assertTrue(actualTenantId.isSysTenantId());
  }

  /**
   * Test {@link BaseSqlEntity#getTenantId(UUID)}.
   * <ul>
   *   <li>When randomUUID.</li>
   *   <li>Then return not NullUid.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#getTenantId(UUID)}
   */
  @Test
  public void testGetTenantId_whenRandomUUID_thenReturnNotNullUid() {
    // Arrange
    UUID uuid = UUID.randomUUID();

    // Act
    TenantId actualTenantId = BaseSqlEntity.getTenantId(uuid);

    // Assert
    assertFalse(actualTenantId.isNullUid());
    assertFalse(actualTenantId.isSysTenantId());
    assertSame(uuid, actualTenantId.getId());
  }

  /**
   * Test {@link BaseSqlEntity#toJson(Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#toJson(Object)}
   */
  @Test
  public void testToJson_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdminSettingsEntity()).toJson(null));
  }

  /**
   * Test {@link BaseSqlEntity#toJson(Object)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@link IntNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#toJson(Object)}
   */
  @Test
  public void testToJson_whenOne_thenReturnIntNode() {
    // Arrange and Act
    JsonNode actualToJsonResult = (new AdminSettingsEntity()).toJson(1);

    // Assert
    assertTrue(actualToJsonResult instanceof IntNode);
    assertTrue(actualToJsonResult.traverse() instanceof TreeTraversingParser);
    assertEquals("1", actualToJsonResult.toPrettyString());
    assertEquals(JsonNodeType.NUMBER, actualToJsonResult.getNodeType());
    assertFalse(actualToJsonResult.isTextual());
    assertFalse(((IntNode) actualToJsonResult).isNaN());
    assertTrue(actualToJsonResult.isInt());
    assertTrue(actualToJsonResult.isIntegralNumber());
    assertTrue(actualToJsonResult.isNumber());
  }

  /**
   * Test {@link BaseSqlEntity#toJson(Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@link TextNode}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#toJson(Object)}
   */
  @Test
  public void testToJson_whenValue_thenReturnTextNode() {
    // Arrange and Act
    JsonNode actualToJsonResult = (new AdminSettingsEntity()).toJson("Value");

    // Assert
    assertTrue(actualToJsonResult instanceof TextNode);
    assertTrue(actualToJsonResult.traverse() instanceof TreeTraversingParser);
    assertEquals("\"Value\"", actualToJsonResult.toPrettyString());
    assertEquals(JsonNodeType.STRING, actualToJsonResult.getNodeType());
    assertFalse(actualToJsonResult.isInt());
    assertFalse(actualToJsonResult.isIntegralNumber());
    assertFalse(actualToJsonResult.isNumber());
    assertTrue(actualToJsonResult.isTextual());
  }

  /**
   * Test {@link BaseSqlEntity#fromJson(JsonNode, Class)}.
   * <ul>
   *   <li>Given {@code Pojo}.</li>
   *   <li>Then return first is {@code Pojo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#fromJson(JsonNode, Class)}
   */
  @Test
  public void testFromJson_givenPojo_thenReturnFirstIsPojo() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();

    ArrayNode json = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    json.addPOJO("Pojo");
    json.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = adminSettingsEntity.fromJson(json, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof List);
    assertEquals(2, ((List<Object>) actualFromJsonResult).size());
    Object getResult = ((List<Object>) actualFromJsonResult).get(1);
    assertTrue(getResult instanceof Map);
    assertEquals("Pojo", ((List<Object>) actualFromJsonResult).get(0));
    assertEquals(1, ((Map<String, Boolean>) getResult).size());
    assertTrue(((Map<String, Boolean>) getResult).get("isPublic"));
  }

  /**
   * Test {@link BaseSqlEntity#fromJson(JsonNode, Class)}.
   * <ul>
   *   <li>Given
   * {@link CustomerServiceImpl#PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON}.</li>
   *   <li>Then return first size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#fromJson(JsonNode, Class)}
   */
  @Test
  public void testFromJson_givenPublic_customer_additional_info_json_thenReturnFirstSizeIsOne() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();

    ArrayNode json = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    json.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = adminSettingsEntity.fromJson(json, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof List);
    assertEquals(1, ((List<LinkedHashMap>) actualFromJsonResult).size());
    LinkedHashMap getResult = ((List<LinkedHashMap>) actualFromJsonResult).get(0);
    assertEquals(1, getResult.size());
    assertTrue(getResult.containsKey("isPublic"));
  }

  /**
   * Test {@link BaseSqlEntity#fromJson(JsonNode, Class)}.
   * <ul>
   *   <li>Given {@link RawValue#RawValue(String)} with v is {@code foo}.</li>
   *   <li>Then first return {@link RawValue}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#fromJson(JsonNode, Class)}
   */
  @Test
  public void testFromJson_givenRawValueWithVIsFoo_thenFirstReturnRawValue() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();

    ArrayNode json = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    RawValue raw = new RawValue("foo");
    json.addRawValue(raw);
    json.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = adminSettingsEntity.fromJson(json, type);

    // Assert
    assertEquals(2, ((List<Object>) actualFromJsonResult).size());
    Object getResult = ((List<Object>) actualFromJsonResult).get(0);
    assertTrue(getResult instanceof RawValue);
    assertTrue(actualFromJsonResult instanceof List);
    Object getResult2 = ((List<Object>) actualFromJsonResult).get(1);
    assertTrue(getResult2 instanceof Map);
    assertEquals(1, ((Map<String, Boolean>) getResult2).size());
    assertTrue(((Map<String, Boolean>) getResult2).get("isPublic"));
    assertEquals(raw, getResult);
  }

  /**
   * Test {@link BaseSqlEntity#fromJson(JsonNode, Class)}.
   * <ul>
   *   <li>Then first return {@link List}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#fromJson(JsonNode, Class)}
   */
  @Test
  public void testFromJson_thenFirstReturnList() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();

    ArrayNode json = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    json.addArray();
    json.add(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = adminSettingsEntity.fromJson(json, type);

    // Assert
    assertEquals(2, ((List<Object>) actualFromJsonResult).size());
    Object getResult = ((List<Object>) actualFromJsonResult).get(0);
    assertTrue(getResult instanceof List);
    assertTrue(actualFromJsonResult instanceof List);
    Object getResult2 = ((List<Object>) actualFromJsonResult).get(1);
    assertTrue(getResult2 instanceof Map);
    assertEquals(1, ((Map<String, Boolean>) getResult2).size());
    assertTrue(((List<Object>) getResult).isEmpty());
    assertTrue(((Map<String, Boolean>) getResult2).get("isPublic"));
  }

  /**
   * Test {@link BaseSqlEntity#fromJson(JsonNode, Class)}.
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory, int)} with nf is
   * withExactBigDecimals {@code true} and capacity is three.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#fromJson(JsonNode, Class)}
   */
  @Test
  public void testFromJson_whenArrayNodeWithNfIsWithExactBigDecimalsTrueAndCapacityIsThree() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    ArrayNode json = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true), 3);

    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = adminSettingsEntity.fromJson(json, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof List);
    assertTrue(((List<Object>) actualFromJsonResult).isEmpty());
  }

  /**
   * Test {@link BaseSqlEntity#fromJson(JsonNode, Class)}.
   * <ul>
   *   <li>When {@link ArrayNode#ArrayNode(JsonNodeFactory)} with nf is
   * withExactBigDecimals {@code true}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#fromJson(JsonNode, Class)}
   */
  @Test
  public void testFromJson_whenArrayNodeWithNfIsWithExactBigDecimalsTrue_thenReturnEmpty() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    ArrayNode json = new ArrayNode(JsonNodeFactory.withExactBigDecimals(true));
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = adminSettingsEntity.fromJson(json, type);

    // Assert
    assertTrue(actualFromJsonResult instanceof List);
    assertTrue(((List<Object>) actualFromJsonResult).isEmpty());
  }

  /**
   * Test {@link BaseSqlEntity#fromJson(JsonNode, Class)}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#fromJson(JsonNode, Class)}
   */
  @Test
  public void testFromJson_whenInstance_thenReturnNull() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    MissingNode json = MissingNode.getInstance();
    Class<Object> type = Object.class;

    // Act and Assert
    assertNull(adminSettingsEntity.fromJson(json, type));
  }

  /**
   * Test {@link BaseSqlEntity#fromJson(JsonNode, Class)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#fromJson(JsonNode, Class)}
   */
  @Test
  public void testFromJson_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull((new AdminSettingsEntity()).fromJson(null, null));
  }

  /**
   * Test {@link BaseSqlEntity#fromJson(JsonNode, Class)}.
   * <ul>
   *   <li>When
   * {@link CustomerServiceImpl#PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON}.</li>
   *   <li>Then return {@link Map}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#fromJson(JsonNode, Class)}
   */
  @Test
  public void testFromJson_whenPublic_customer_additional_info_json_thenReturnMap() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    Class<Object> type = Object.class;

    // Act
    Object actualFromJsonResult = adminSettingsEntity.fromJson(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON,
        type);

    // Assert
    assertTrue(actualFromJsonResult instanceof Map);
    assertEquals(1, ((Map<String, Boolean>) actualFromJsonResult).size());
    assertTrue(((Map<String, Boolean>) actualFromJsonResult).get("isPublic"));
  }

  /**
   * Test {@link BaseSqlEntity#listToString(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#listToString(List)}
   */
  @Test
  public void testListToString_given42_whenArrayListAdd42_thenReturn42() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();

    ArrayList<Object> list = new ArrayList<>();
    list.add("42");

    // Act and Assert
    assertEquals("42", adminSettingsEntity.listToString(list));
  }

  /**
   * Test {@link BaseSqlEntity#listToString(List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code 42,42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#listToString(List)}
   */
  @Test
  public void testListToString_given42_whenArrayListAdd42_thenReturn4242() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();

    ArrayList<Object> list = new ArrayList<>();
    list.add("42");
    list.add("42");

    // Act and Assert
    assertEquals("42,42", adminSettingsEntity.listToString(list));
  }

  /**
   * Test {@link BaseSqlEntity#listToString(List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#listToString(List)}
   */
  @Test
  public void testListToString_whenArrayList_thenReturnEmptyString() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();

    // Act and Assert
    assertEquals("", adminSettingsEntity.listToString(new ArrayList<>()));
  }

  /**
   * Test {@link BaseSqlEntity#listToString(List)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#listToString(List)}
   */
  @Test
  public void testListToString_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", (new AdminSettingsEntity()).listToString(null));
  }

  /**
   * Test {@link BaseSqlEntity#listFromString(String, Function)}.
   * <ul>
   *   <li>Given {@code Apply}.</li>
   *   <li>When {@code String}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#listFromString(String, Function)}
   */
  @Test
  public void testListFromString_givenApply_whenString_thenReturnSizeIsOne() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    Function<String, Object> mappingFunction = mock(Function.class);
    when(mappingFunction.apply(Mockito.<String>any())).thenReturn("Apply");

    // Act
    List<Object> actualListFromStringResult = adminSettingsEntity.listFromString("String", mappingFunction);

    // Assert
    verify(mappingFunction).apply(eq("String"));
    assertEquals(1, actualListFromStringResult.size());
    assertEquals("Apply", actualListFromStringResult.get(0));
  }

  /**
   * Test {@link BaseSqlEntity#listFromString(String, Function)}.
   * <ul>
   *   <li>When empty string.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#listFromString(String, Function)}
   */
  @Test
  public void testListFromString_whenEmptyString_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new AdminSettingsEntity()).<Object>listFromString("", mock(Function.class)).isEmpty());
  }

  /**
   * Test {@link BaseSqlEntity#listFromString(String, Function)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#listFromString(String, Function)}
   */
  @Test
  public void testListFromString_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertTrue((new AdminSettingsEntity()).<Object>listFromString(null, mock(Function.class)).isEmpty());
  }

  /**
   * Test {@link BaseSqlEntity#setId(UUID)}.
   * <p>
   * Method under test: {@link BaseSqlEntity#setId(UUID)}
   */
  @Test
  public void testSetId() {
    // Arrange
    AdminSettingsEntity adminSettingsEntity = new AdminSettingsEntity();
    UUID id = ModelConstants.NULL_UUID;

    // Act
    adminSettingsEntity.setId(id);

    // Assert
    assertSame(id, adminSettingsEntity.getId());
    assertSame(id, adminSettingsEntity.getUuid());
  }
}
