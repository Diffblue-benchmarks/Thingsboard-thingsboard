package org.thingsboard.server.dao.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;

public class BaseSqlEntityDiffblueTest {
  /**
   * Test {@link BaseSqlEntity#getUuid(UUIDBased)} with {@code UUIDBased}.
   * <ul>
   *   <li>Then return toString is {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#getUuid(UUIDBased)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UUID BaseSqlEntity.getUuid(UUIDBased)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UUID BaseSqlEntity.getUuid(UUIDBased)"})
  public void testGetUuidWithUUIDBased_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BaseSqlEntity.getUuid(null));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UUID BaseSqlEntity.getTenantUuid(TenantId)"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"UUID BaseSqlEntity.getTenantUuid(TenantId)"})
  public void testGetTenantUuid_whenSystem_tenant() {
    // Arrange, Act and Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080",
        BaseSqlEntity.getTenantUuid(ModelConstants.SYSTEM_TENANT).toString());
  }

  /**
   * Test {@link BaseSqlEntity#getEntityId(UUID, Function)}.
   * <ul>
   *   <li>Given {@code Apply}.</li>
   *   <li>Then return {@code Apply}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#getEntityId(UUID, Function)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object BaseSqlEntity.getEntityId(UUID, Function)"})
  public void testGetEntityId_givenApply_thenReturnApply() {
    // Arrange
    UUID uuid = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    Function<UUID, Object> creator = mock(Function.class);
    when(creator.apply(Mockito.<UUID>any())).thenReturn("Apply");

    // Act
    Object actualEntityId = BaseSqlEntity.getEntityId(uuid, creator);

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Object BaseSqlEntity.getEntityId(UUID, Function)"})
  public void testGetEntityId_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(BaseSqlEntity.<Object>getEntityId(null, mock(Function.class)));
  }

  /**
   * Test {@link BaseSqlEntity#getTenantId(UUID)}.
   * <ul>
   *   <li>Then return Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#getTenantId(UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantId BaseSqlEntity.getTenantId(UUID)"})
  public void testGetTenantId_thenReturnIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange and Act
    TenantId actualTenantId = BaseSqlEntity.getTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.getId().toString());
    assertEquals(EntityType.TENANT, actualTenantId.getEntityType());
    assertFalse(actualTenantId.isNullUid());
    assertFalse(actualTenantId.isSysTenantId());
  }

  /**
   * Test {@link BaseSqlEntity#getTenantId(UUID)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#getTenantId(UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantId BaseSqlEntity.getTenantId(UUID)"})
  public void testGetTenantId_whenNull_thenReturnIdToStringIs138140001dd211b28080808080808080() {
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
   *   <li>When {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseSqlEntity#getTenantId(UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"TenantId BaseSqlEntity.getTenantId(UUID)"})
  public void testGetTenantId_whenNull_uuid() {
    // Arrange and Act
    TenantId actualTenantId = BaseSqlEntity.getTenantId(ModelConstants.NULL_UUID);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTenantId.getId().toString());
    assertEquals(EntityType.TENANT, actualTenantId.getEntityType());
    assertTrue(actualTenantId.isNullUid());
    assertTrue(actualTenantId.isSysTenantId());
  }
}
