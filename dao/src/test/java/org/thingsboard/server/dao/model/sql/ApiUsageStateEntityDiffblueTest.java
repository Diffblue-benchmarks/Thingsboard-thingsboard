package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.dao.model.ModelConstants;

public class ApiUsageStateEntityDiffblueTest {
  /**
   * Test {@link ApiUsageStateEntity#ApiUsageStateEntity()}.
   * <p>
   * Method under test: {@link ApiUsageStateEntity#ApiUsageStateEntity()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ApiUsageStateEntity.<init>()"})
  public void testNewApiUsageStateEntity() {
    // Arrange and Act
    ApiUsageStateEntity actualApiUsageStateEntity = new ApiUsageStateEntity();

    // Assert
    assertNull(actualApiUsageStateEntity.getEntityType());
    assertNull(actualApiUsageStateEntity.getId());
    assertNull(actualApiUsageStateEntity.getUuid());
    assertNull(actualApiUsageStateEntity.getEntityId());
    assertNull(actualApiUsageStateEntity.getTenantId());
    assertEquals(0L, actualApiUsageStateEntity.getCreatedTime());
    assertEquals(ApiUsageStateValue.ENABLED, actualApiUsageStateEntity.getAlarmExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualApiUsageStateEntity.getDbStorageState());
    assertEquals(ApiUsageStateValue.ENABLED, actualApiUsageStateEntity.getEmailExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualApiUsageStateEntity.getJsExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualApiUsageStateEntity.getReExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualApiUsageStateEntity.getSmsExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualApiUsageStateEntity.getTbelExecState());
    assertEquals(ApiUsageStateValue.ENABLED, actualApiUsageStateEntity.getTransportState());
  }

  /**
   * Test {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}.
   * <ul>
   *   <li>When {@link ApiUsageState#ApiUsageState()}.</li>
   *   <li>Then return EntityType is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#ApiUsageStateEntity(ApiUsageState)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void ApiUsageStateEntity.<init>(ApiUsageState)"})
  public void testNewApiUsageStateEntity_whenApiUsageState_thenReturnEntityTypeIsNull() {
    // Arrange and Act
    ApiUsageStateEntity actualApiUsageStateEntity = new ApiUsageStateEntity(new ApiUsageState());

    // Assert
    assertNull(actualApiUsageStateEntity.getEntityType());
    assertNull(actualApiUsageStateEntity.getEntityId());
    assertNull(actualApiUsageStateEntity.getTenantId());
    assertEquals(0L, actualApiUsageStateEntity.getCreatedTime());
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}, and {@link ApiUsageStateEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageStateEntity#equals(Object)}
   *   <li>{@link ApiUsageStateEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(apiUsageStateEntity, apiUsageStateEntity2);
    int expectedHashCodeResult = apiUsageStateEntity.hashCode();
    assertEquals(expectedHashCodeResult, apiUsageStateEntity2.hashCode());
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}, and {@link ApiUsageStateEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageStateEntity#equals(Object)}
   *   <li>{@link ApiUsageStateEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(null);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(null);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(apiUsageStateEntity, apiUsageStateEntity2);
    int expectedHashCodeResult = apiUsageStateEntity.hashCode();
    assertEquals(expectedHashCodeResult, apiUsageStateEntity2.hashCode());
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}, and {@link ApiUsageStateEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageStateEntity#equals(Object)}
   *   <li>{@link ApiUsageStateEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(apiUsageStateEntity, apiUsageStateEntity);
    int expectedHashCodeResult = apiUsageStateEntity.hashCode();
    assertEquals(expectedHashCodeResult, apiUsageStateEntity.hashCode());
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(null);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(3L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(null);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(null);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(null);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType(null);
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("org.thingsboard.server.dao.model.sql.ApiUsageStateEntity");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(null);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(null);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(null);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(null);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(ModelConstants.NULL_UUID);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(null);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(null);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.WARNING);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    ApiUsageStateEntity apiUsageStateEntity2 = new ApiUsageStateEntity();
    apiUsageStateEntity2.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setCreatedTime(1L);
    apiUsageStateEntity2.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setEntityType("Entity Type");
    apiUsageStateEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity2.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, apiUsageStateEntity2);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, null);
  }

  /**
   * Test {@link ApiUsageStateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageStateEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ApiUsageStateEntity.equals(Object)", "int ApiUsageStateEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setCreatedTime(1L);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEntityId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(apiUsageStateEntity, "Different type to ApiUsageStateEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageStateEntity#setAlarmExecState(ApiUsageStateValue)}
   *   <li>{@link ApiUsageStateEntity#setDbStorageState(ApiUsageStateValue)}
   *   <li>{@link ApiUsageStateEntity#setEmailExecState(ApiUsageStateValue)}
   *   <li>{@link ApiUsageStateEntity#setEntityId(UUID)}
   *   <li>{@link ApiUsageStateEntity#setEntityType(String)}
   *   <li>{@link ApiUsageStateEntity#setJsExecState(ApiUsageStateValue)}
   *   <li>{@link ApiUsageStateEntity#setReExecState(ApiUsageStateValue)}
   *   <li>{@link ApiUsageStateEntity#setSmsExecState(ApiUsageStateValue)}
   *   <li>{@link ApiUsageStateEntity#setTbelExecState(ApiUsageStateValue)}
   *   <li>{@link ApiUsageStateEntity#setTenantId(UUID)}
   *   <li>{@link ApiUsageStateEntity#setTransportState(ApiUsageStateValue)}
   *   <li>{@link ApiUsageStateEntity#toString()}
   *   <li>{@link ApiUsageStateEntity#getAlarmExecState()}
   *   <li>{@link ApiUsageStateEntity#getDbStorageState()}
   *   <li>{@link ApiUsageStateEntity#getEmailExecState()}
   *   <li>{@link ApiUsageStateEntity#getEntityId()}
   *   <li>{@link ApiUsageStateEntity#getEntityType()}
   *   <li>{@link ApiUsageStateEntity#getJsExecState()}
   *   <li>{@link ApiUsageStateEntity#getReExecState()}
   *   <li>{@link ApiUsageStateEntity#getSmsExecState()}
   *   <li>{@link ApiUsageStateEntity#getTbelExecState()}
   *   <li>{@link ApiUsageStateEntity#getTenantId()}
   *   <li>{@link ApiUsageStateEntity#getTransportState()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ApiUsageStateValue ApiUsageStateEntity.getAlarmExecState()",
      "ApiUsageStateValue ApiUsageStateEntity.getDbStorageState()",
      "ApiUsageStateValue ApiUsageStateEntity.getEmailExecState()", "UUID ApiUsageStateEntity.getEntityId()",
      "String ApiUsageStateEntity.getEntityType()", "ApiUsageStateValue ApiUsageStateEntity.getJsExecState()",
      "ApiUsageStateValue ApiUsageStateEntity.getReExecState()",
      "ApiUsageStateValue ApiUsageStateEntity.getSmsExecState()",
      "ApiUsageStateValue ApiUsageStateEntity.getTbelExecState()", "UUID ApiUsageStateEntity.getTenantId()",
      "ApiUsageStateValue ApiUsageStateEntity.getTransportState()",
      "void ApiUsageStateEntity.setAlarmExecState(ApiUsageStateValue)",
      "void ApiUsageStateEntity.setDbStorageState(ApiUsageStateValue)",
      "void ApiUsageStateEntity.setEmailExecState(ApiUsageStateValue)", "void ApiUsageStateEntity.setEntityId(UUID)",
      "void ApiUsageStateEntity.setEntityType(String)", "void ApiUsageStateEntity.setJsExecState(ApiUsageStateValue)",
      "void ApiUsageStateEntity.setReExecState(ApiUsageStateValue)",
      "void ApiUsageStateEntity.setSmsExecState(ApiUsageStateValue)",
      "void ApiUsageStateEntity.setTbelExecState(ApiUsageStateValue)", "void ApiUsageStateEntity.setTenantId(UUID)",
      "void ApiUsageStateEntity.setTransportState(ApiUsageStateValue)", "String ApiUsageStateEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange
    ApiUsageStateEntity apiUsageStateEntity = new ApiUsageStateEntity();

    // Act
    apiUsageStateEntity.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setEmailExecState(ApiUsageStateValue.ENABLED);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    apiUsageStateEntity.setEntityId(entityId);
    apiUsageStateEntity.setEntityType("Entity Type");
    apiUsageStateEntity.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageStateEntity.setTbelExecState(ApiUsageStateValue.ENABLED);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    apiUsageStateEntity.setTenantId(tenantId);
    apiUsageStateEntity.setTransportState(ApiUsageStateValue.ENABLED);
    String actualToStringResult = apiUsageStateEntity.toString();
    ApiUsageStateValue actualAlarmExecState = apiUsageStateEntity.getAlarmExecState();
    ApiUsageStateValue actualDbStorageState = apiUsageStateEntity.getDbStorageState();
    ApiUsageStateValue actualEmailExecState = apiUsageStateEntity.getEmailExecState();
    UUID actualEntityId = apiUsageStateEntity.getEntityId();
    String actualEntityType = apiUsageStateEntity.getEntityType();
    ApiUsageStateValue actualJsExecState = apiUsageStateEntity.getJsExecState();
    ApiUsageStateValue actualReExecState = apiUsageStateEntity.getReExecState();
    ApiUsageStateValue actualSmsExecState = apiUsageStateEntity.getSmsExecState();
    ApiUsageStateValue actualTbelExecState = apiUsageStateEntity.getTbelExecState();
    UUID actualTenantId = apiUsageStateEntity.getTenantId();
    ApiUsageStateValue actualTransportState = apiUsageStateEntity.getTransportState();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualEntityId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("ApiUsageStateEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, entityType=Entity Type, entityId"
        + "=784f394c-42b6-435a-983c-b7beff2784f9, transportState=ENABLED, dbStorageState=ENABLED, reExecState=ENABLED,"
        + " jsExecState=ENABLED, tbelExecState=ENABLED, emailExecState=ENABLED, smsExecState=ENABLED, alarmExecState"
        + "=ENABLED)", actualToStringResult);
    assertEquals("Entity Type", actualEntityType);
    assertEquals(ApiUsageStateValue.ENABLED, actualAlarmExecState);
    assertEquals(ApiUsageStateValue.ENABLED, actualDbStorageState);
    assertEquals(ApiUsageStateValue.ENABLED, actualEmailExecState);
    assertEquals(ApiUsageStateValue.ENABLED, actualJsExecState);
    assertEquals(ApiUsageStateValue.ENABLED, actualReExecState);
    assertEquals(ApiUsageStateValue.ENABLED, actualSmsExecState);
    assertEquals(ApiUsageStateValue.ENABLED, actualTbelExecState);
    assertEquals(ApiUsageStateValue.ENABLED, actualTransportState);
    assertSame(entityId, actualEntityId);
    assertSame(tenantId, actualTenantId);
  }
}
