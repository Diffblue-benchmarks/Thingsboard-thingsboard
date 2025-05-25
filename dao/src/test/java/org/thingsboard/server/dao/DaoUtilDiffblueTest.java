package org.thingsboard.server.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityInfo;
import org.thingsboard.server.common.data.EntitySubtype;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ToData;

public class DaoUtilDiffblueTest {
  /**
   * Test {@link DaoUtil#convertDataList(Collection)}.
   * <ul>
   *   <li>Given {@code null}.</li>
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#convertDataList(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DaoUtil.convertDataList(Collection)"})
  public void testConvertDataList_givenNull_whenLinkedHashSetAddNull_thenReturnEmpty() {
    // Arrange
    LinkedHashSet<? extends ToData<Object>> toDataList = new LinkedHashSet<>();
    toDataList.add(null);

    // Act
    List<Object> actualConvertDataListResult = DaoUtil.convertDataList(toDataList);

    // Assert
    assertTrue(actualConvertDataListResult.isEmpty());
  }

  /**
   * Test {@link DaoUtil#convertDataList(Collection)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#convertDataList(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DaoUtil.convertDataList(Collection)"})
  public void testConvertDataList_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualConvertDataListResult = DaoUtil.convertDataList(new ArrayList<>());

    // Assert
    assertTrue(actualConvertDataListResult.isEmpty());
  }

  /**
   * Test {@link DaoUtil#convertDataList(Collection)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#convertDataList(Collection)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DaoUtil.convertDataList(Collection)"})
  public void testConvertDataList_whenNull_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualConvertDataListResult = DaoUtil.convertDataList(null);

    // Assert
    assertTrue(actualConvertDataListResult.isEmpty());
  }

  /**
   * Test {@link DaoUtil#getData(Optional)} with {@code Optional}.
   * <ul>
   *   <li>Given {@code Data}.</li>
   *   <li>When {@link ToData} {@link ToData#toData()} return {@code Data}.</li>
   *   <li>Then return {@code Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#getData(Optional)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object DaoUtil.getData(Optional)"})
  public void testGetDataWithOptional_givenData_whenToDataToDataReturnData_thenReturnData() {
    // Arrange
    ToData<Object> toData = mock(ToData.class);
    when(toData.toData()).thenReturn("Data");
    Optional<? extends ToData<Object>> data = Optional.of(toData);

    // Act
    Object actualData = DaoUtil.getData(data);

    // Assert
    verify(toData).toData();
    assertEquals("Data", actualData);
  }

  /**
   * Test {@link DaoUtil#getData(Optional)} with {@code Optional}.
   * <ul>
   *   <li>When empty.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#getData(Optional)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object DaoUtil.getData(Optional)"})
  public void testGetDataWithOptional_whenEmpty_thenReturnNull() {
    // Arrange
    Optional<? extends ToData<Object>> data = Optional.empty();

    // Act and Assert
    assertNull(DaoUtil.getData(data));
  }

  /**
   * Test {@link DaoUtil#getData(ToData)} with {@code ToData}.
   * <ul>
   *   <li>Given {@code Data}.</li>
   *   <li>When {@link ToData} {@link ToData#toData()} return {@code Data}.</li>
   *   <li>Then return {@code Data}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#getData(ToData)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object DaoUtil.getData(ToData)"})
  public void testGetDataWithToData_givenData_whenToDataToDataReturnData_thenReturnData() {
    // Arrange
    ToData<Object> data = mock(ToData.class);
    when(data.toData()).thenReturn("Data");

    // Act
    Object actualData = DaoUtil.getData(data);

    // Assert
    verify(data).toData();
    assertEquals("Data", actualData);
  }

  /**
   * Test {@link DaoUtil#getData(ToData)} with {@code ToData}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#getData(ToData)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object DaoUtil.getData(ToData)"})
  public void testGetDataWithToData_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(DaoUtil.getData((ToData<Object>) null));
  }

  /**
   * Test {@link DaoUtil#fromUUIDs(List, Function)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#fromUUIDs(List, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DaoUtil.fromUUIDs(List, Function)"})
  public void testFromUUIDs_thenReturnSizeIsTwo() {
    // Arrange
    ArrayList<UUID> uuids = new ArrayList<>();
    uuids.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    uuids.add(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    Function<UUID, Object> mapper = mock(Function.class);
    when(mapper.apply(Mockito.<UUID>any())).thenReturn("Apply");

    // Act
    List<Object> actualFromUUIDsResult = DaoUtil.fromUUIDs(uuids, mapper);

    // Assert
    verify(mapper, atLeast(1)).apply(isA(UUID.class));
    assertEquals(2, actualFromUUIDsResult.size());
    assertEquals("Apply", actualFromUUIDsResult.get(0));
    assertEquals("Apply", actualFromUUIDsResult.get(1));
  }

  /**
   * Test {@link DaoUtil#fromUUIDs(List, Function)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#fromUUIDs(List, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DaoUtil.fromUUIDs(List, Function)"})
  public void testFromUUIDs_whenArrayList_thenReturnEmpty() {
    // Arrange and Act
    List<Object> actualFromUUIDsResult = DaoUtil.<Object>fromUUIDs(new ArrayList<>(), mock(Function.class));

    // Assert
    assertTrue(actualFromUUIDsResult.isEmpty());
  }

  /**
   * Test {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}.
   * <p>
   * Method under test: {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DaoUtil.convertTenantEntityTypesToDto(UUID, EntityType, List)"})
  public void testConvertTenantEntityTypesToDto() {
    // Arrange
    UUID tenantUUID = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    ArrayList<String> types = new ArrayList<>();
    types.add("foo");

    // Act
    List<EntitySubtype> actualConvertTenantEntityTypesToDtoResult = DaoUtil.convertTenantEntityTypesToDto(tenantUUID,
        EntityType.TENANT, types);

    // Assert
    assertEquals(1, actualConvertTenantEntityTypesToDtoResult.size());
    EntitySubtype getResult = actualConvertTenantEntityTypesToDtoResult.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals("foo", getResult.getType());
    assertEquals(EntityType.TENANT, getResult.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }

  /**
   * Test {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DaoUtil.convertTenantEntityTypesToDto(UUID, EntityType, List)"})
  public void testConvertTenantEntityTypesToDto_given42_whenArrayListAdd42_thenReturnSizeIsTwo() {
    // Arrange
    UUID tenantUUID = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    ArrayList<String> types = new ArrayList<>();
    types.add("42");
    types.add("foo");

    // Act
    List<EntitySubtype> actualConvertTenantEntityTypesToDtoResult = DaoUtil.convertTenantEntityTypesToDto(tenantUUID,
        EntityType.TENANT, types);

    // Assert
    assertEquals(2, actualConvertTenantEntityTypesToDtoResult.size());
    assertEquals("42", actualConvertTenantEntityTypesToDtoResult.get(0).getType());
    EntitySubtype getResult = actualConvertTenantEntityTypesToDtoResult.get(1);
    assertEquals("foo", getResult.getType());
    assertEquals(EntityType.TENANT, getResult.getEntityType());
  }

  /**
   * Test {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}.
   * <ul>
   *   <li>Then return first TenantId Id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DaoUtil.convertTenantEntityTypesToDto(UUID, EntityType, List)"})
  public void testConvertTenantEntityTypesToDto_thenReturnFirstTenantIdIdIsRandomUUID() {
    // Arrange
    UUID tenantUUID = UUID.randomUUID();

    ArrayList<String> types = new ArrayList<>();
    types.add("foo");

    // Act
    List<EntitySubtype> actualConvertTenantEntityTypesToDtoResult = DaoUtil.convertTenantEntityTypesToDto(tenantUUID,
        EntityType.TENANT, types);

    // Assert
    assertEquals(1, actualConvertTenantEntityTypesToDtoResult.size());
    EntitySubtype getResult = actualConvertTenantEntityTypesToDtoResult.get(0);
    assertEquals("foo", getResult.getType());
    assertEquals(EntityType.TENANT, getResult.getEntityType());
    TenantId tenantId = getResult.getTenantId();
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
    assertSame(tenantUUID, tenantId.getId());
  }

  /**
   * Test {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#convertTenantEntityTypesToDto(UUID, EntityType, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DaoUtil.convertTenantEntityTypesToDto(UUID, EntityType, List)"})
  public void testConvertTenantEntityTypesToDto_whenArrayList_thenReturnEmpty() {
    // Arrange
    UUID tenantUUID = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    List<EntitySubtype> actualConvertTenantEntityTypesToDtoResult = DaoUtil.convertTenantEntityTypesToDto(tenantUUID,
        EntityType.TENANT, new ArrayList<>());

    // Assert
    assertTrue(actualConvertTenantEntityTypesToDtoResult.isEmpty());
  }

  /**
   * Test {@link DaoUtil#convertTenantEntityInfosToDto(UUID, EntityType, List)}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#convertTenantEntityInfosToDto(UUID, EntityType, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DaoUtil.convertTenantEntityInfosToDto(UUID, EntityType, List)"})
  public void testConvertTenantEntityInfosToDto_thenReturnSizeIsOne() {
    // Arrange
    UUID tenantUUID = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    ArrayList<EntityInfo> entityInfos = new ArrayList<>();
    entityInfos.add(new EntityInfo(BaseEntityService.NULL_CUSTOMER_ID, "Name"));

    // Act
    List<EntitySubtype> actualConvertTenantEntityInfosToDtoResult = DaoUtil.convertTenantEntityInfosToDto(tenantUUID,
        EntityType.TENANT, entityInfos);

    // Assert
    assertEquals(1, actualConvertTenantEntityInfosToDtoResult.size());
    EntitySubtype getResult = actualConvertTenantEntityInfosToDtoResult.get(0);
    TenantId tenantId = getResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertEquals("Name", getResult.getType());
    assertEquals(EntityType.TENANT, getResult.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }

  /**
   * Test {@link DaoUtil#convertTenantEntityInfosToDto(UUID, EntityType, List)}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#convertTenantEntityInfosToDto(UUID, EntityType, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DaoUtil.convertTenantEntityInfosToDto(UUID, EntityType, List)"})
  public void testConvertTenantEntityInfosToDto_thenReturnSizeIsTwo() {
    // Arrange
    UUID tenantUUID = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    ArrayList<EntityInfo> entityInfos = new ArrayList<>();
    entityInfos.add(new EntityInfo(BaseEntityService.NULL_CUSTOMER_ID, "Name"));
    entityInfos.add(new EntityInfo(BaseEntityService.NULL_CUSTOMER_ID, "Name"));

    // Act
    List<EntitySubtype> actualConvertTenantEntityInfosToDtoResult = DaoUtil.convertTenantEntityInfosToDto(tenantUUID,
        EntityType.TENANT, entityInfos);

    // Assert
    assertEquals(2, actualConvertTenantEntityInfosToDtoResult.size());
    assertEquals(actualConvertTenantEntityInfosToDtoResult.get(0), actualConvertTenantEntityInfosToDtoResult.get(1));
  }

  /**
   * Test {@link DaoUtil#convertTenantEntityInfosToDto(UUID, EntityType, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link DaoUtil#convertTenantEntityInfosToDto(UUID, EntityType, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"List DaoUtil.convertTenantEntityInfosToDto(UUID, EntityType, List)"})
  public void testConvertTenantEntityInfosToDto_whenArrayList_thenReturnEmpty() {
    // Arrange
    UUID tenantUUID = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    List<EntitySubtype> actualConvertTenantEntityInfosToDtoResult = DaoUtil.convertTenantEntityInfosToDto(tenantUUID,
        EntityType.TENANT, new ArrayList<>());

    // Assert
    assertTrue(actualConvertTenantEntityInfosToDtoResult.isEmpty());
  }
}
