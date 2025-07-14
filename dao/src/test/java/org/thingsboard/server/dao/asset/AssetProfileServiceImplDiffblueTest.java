package org.thingsboard.server.dao.asset;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import org.hibernate.exception.ConstraintViolationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.EntityInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.asset.AssetProfileInfo;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.common.data.page.SortOrder.Direction;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;

@ExtendWith(MockitoExtension.class)
class AssetProfileServiceImplDiffblueTest {
  @Mock private AssetProfileDao assetProfileDao;

  @InjectMocks private AssetProfileServiceImpl assetProfileServiceImpl;

  @Mock private DataValidator<AssetProfile> dataValidator;

  /**
   * Test {@link AssetProfileServiceImpl#handleEvictEvent(AssetProfileEvictEvent)} with {@code
   * AssetProfileEvictEvent}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#handleEvictEvent(AssetProfileEvictEvent)}
   */
  @Test
  @DisplayName(
      "Test handleEvictEvent(AssetProfileEvictEvent) with 'AssetProfileEvictEvent'; then throw DataValidationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileServiceImpl.handleEvictEvent(AssetProfileEvictEvent)"})
  void testHandleEvictEventWithAssetProfileEvictEvent_thenThrowDataValidationException() {
    // Arrange
    AssetProfile savedAssetProfile = mock(AssetProfile.class);
    when(savedAssetProfile.getId()).thenThrow(new DataValidationException("An error occurred"));

    AssetProfileEvictEvent event =
        new AssetProfileEvictEvent(
            ModelConstants.SYSTEM_TENANT, "New Name", "not empty", null, false);
    event.setSavedAssetProfile(savedAssetProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> assetProfileServiceImpl.handleEvictEvent(event));
    verify(savedAssetProfile).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#saveAssetProfile(AssetProfile)} with {@code assetProfile}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#saveAssetProfile(AssetProfile)}
   */
  @Test
  @DisplayName("Test saveAssetProfile(AssetProfile) with 'assetProfile'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssetProfile AssetProfileServiceImpl.saveAssetProfile(AssetProfile)"})
  void testSaveAssetProfileWithAssetProfile() {
    // Arrange
    when(dataValidator.validate(
            Mockito.<AssetProfile>any(), Mockito.<Function<AssetProfile, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.saveAssetProfile(new AssetProfile()));
    verify(dataValidator).validate(isA(AssetProfile.class), isA(Function.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#saveAssetProfile(AssetProfile, boolean, boolean)} with
   * {@code assetProfile}, {@code doValidate}, {@code publishSaveEvent}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#saveAssetProfile(AssetProfile, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test saveAssetProfile(AssetProfile, boolean, boolean) with 'assetProfile', 'doValidate', 'publishSaveEvent'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "AssetProfile AssetProfileServiceImpl.saveAssetProfile(AssetProfile, boolean, boolean)"
  })
  void testSaveAssetProfileWithAssetProfileDoValidatePublishSaveEvent() {
    // Arrange
    when(dataValidator.validate(
            Mockito.<AssetProfile>any(), Mockito.<Function<AssetProfile, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.saveAssetProfile(new AssetProfile(), true, true));
    verify(dataValidator).validate(isA(AssetProfile.class), isA(Function.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId, AssetProfileId)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId,
   * AssetProfileId)}
   */
  @Test
  @DisplayName("Test deleteAssetProfile(TenantId, AssetProfileId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfile(TenantId, AssetProfileId)"})
  void testDeleteAssetProfile() {
    // Arrange
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.deleteAssetProfile(
                ModelConstants.SYSTEM_TENANT,
                new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId, AssetProfileId)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId,
   * AssetProfileId)}
   */
  @Test
  @DisplayName("Test deleteAssetProfile(TenantId, AssetProfileId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfile(TenantId, AssetProfileId)"})
  void testDeleteAssetProfile2() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setId(new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doThrow(new DataValidationException("An error occurred"))
        .when(assetProfileDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(assetProfile);
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.deleteAssetProfile(
                ModelConstants.SYSTEM_TENANT, assetProfileId));
    verify(assetProfileId, atLeast(1)).getId();
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId, AssetProfileId)}.
   *
   * <ul>
   *   <li>Given {@link AssetProfileDao} {@link AssetProfileDao#findById(TenantId, UUID)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId,
   * AssetProfileId)}
   */
  @Test
  @DisplayName(
      "Test deleteAssetProfile(TenantId, AssetProfileId); given AssetProfileDao findById(TenantId, UUID) return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfile(TenantId, AssetProfileId)"})
  void testDeleteAssetProfile_givenAssetProfileDaoFindByIdReturnNull() {
    // Arrange
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    assetProfileServiceImpl.deleteAssetProfile(
        ModelConstants.SYSTEM_TENANT,
        new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId, AssetProfileId)}.
   *
   * <ul>
   *   <li>Given {@link AssetProfileDao} {@link AssetProfileDao#findById(TenantId, UUID)} return
   *       {@code null}.
   *   <li>Then calls {@link AssetProfileId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId,
   * AssetProfileId)}
   */
  @Test
  @DisplayName(
      "Test deleteAssetProfile(TenantId, AssetProfileId); given AssetProfileDao findById(TenantId, UUID) return 'null'; then calls getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfile(TenantId, AssetProfileId)"})
  void testDeleteAssetProfile_givenAssetProfileDaoFindByIdReturnNull_thenCallsGetId() {
    // Arrange
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    assetProfileServiceImpl.deleteAssetProfile(ModelConstants.SYSTEM_TENANT, assetProfileId);

    // Assert
    verify(assetProfileId, atLeast(1)).getId();
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId, AssetProfileId)}.
   *
   * <ul>
   *   <li>Given {@link AssetProfile#AssetProfile()} Default is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId,
   * AssetProfileId)}
   */
  @Test
  @DisplayName(
      "Test deleteAssetProfile(TenantId, AssetProfileId); given AssetProfile() Default is 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfile(TenantId, AssetProfileId)"})
  void testDeleteAssetProfile_givenAssetProfileDefaultIsTrue() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setDefault(true);
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(assetProfile);
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.deleteAssetProfile(
                ModelConstants.SYSTEM_TENANT, assetProfileId));
    verify(assetProfileId, atLeast(1)).getId();
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId, AssetProfileId)}.
   *
   * <ul>
   *   <li>Then calls {@link AssetProfile#isDefault()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId,
   * AssetProfileId)}
   */
  @Test
  @DisplayName("Test deleteAssetProfile(TenantId, AssetProfileId); then calls isDefault()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfile(TenantId, AssetProfileId)"})
  void testDeleteAssetProfile_thenCallsIsDefault() {
    // Arrange
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.isDefault()).thenThrow(new DataValidationException("An error occurred"));
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(assetProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.deleteAssetProfile(
                ModelConstants.SYSTEM_TENANT,
                new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(assetProfile).isDefault();
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId, AssetProfileId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId,
   * AssetProfileId)}
   */
  @Test
  @DisplayName(
      "Test deleteAssetProfile(TenantId, AssetProfileId); then throw ConstraintViolationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfile(TenantId, AssetProfileId)"})
  void testDeleteAssetProfile_thenThrowConstraintViolationException() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setId(new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doThrow(
            new ConstraintViolationException(
                "An error occurred", new SQLException(), "Executing deleteAssetProfile [{}]"))
        .when(assetProfileDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(assetProfile);
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () ->
            assetProfileServiceImpl.deleteAssetProfile(
                ModelConstants.SYSTEM_TENANT, assetProfileId));
    verify(assetProfileId, atLeast(1)).getId();
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(assetProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity() {
    // Arrange
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity2() {
    // Arrange
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.isDefault()).thenThrow(new DataValidationException("An error occurred"));
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(assetProfile);
    EntityId id = mock(EntityId.class);
    when(id.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, id, false));
    verify(assetProfile).isDefault();
    verify(id).getId();
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link AssetProfileDao} {@link AssetProfileDao#findById(TenantId, UUID)} return
   *       {@code null}.
   *   <li>When {@link BaseEntityService#NULL_CUSTOMER_ID}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName(
      "Test deleteEntity(TenantId, EntityId, boolean); given AssetProfileDao findById(TenantId, UUID) return 'null'; when NULL_CUSTOMER_ID")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_givenAssetProfileDaoFindByIdReturnNull_whenNull_customer_id() {
    // Arrange
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    assetProfileServiceImpl.deleteEntity(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true);

    // Assert
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link AssetProfile} {@link AssetProfile#isDefault()} return {@code false}.
   *   <li>When {@code false}.
   *   <li>Then calls {@link AssetProfile#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName(
      "Test deleteEntity(TenantId, EntityId, boolean); given AssetProfile isDefault() return 'false'; when 'false'; then calls getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_givenAssetProfileIsDefaultReturnFalse_whenFalse_thenCallsGetId() {
    // Arrange
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.isDefault()).thenReturn(false);
    when(assetProfile.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(assetProfile);
    EntityId id = mock(EntityId.class);
    when(id.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, id, false));
    verify(assetProfile).getId();
    verify(assetProfile).isDefault();
    verify(id).getId();
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link AssetProfile} {@link AssetProfile#isDefault()} return {@code true}.
   *   <li>Then calls {@link AssetProfile#isDefault()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName(
      "Test deleteEntity(TenantId, EntityId, boolean); given AssetProfile isDefault() return 'true'; then calls isDefault()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_givenAssetProfileIsDefaultReturnTrue_thenCallsIsDefault() {
    // Arrange
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.isDefault()).thenReturn(true);
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(assetProfile);
    EntityId id = mock(EntityId.class);
    when(id.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, id, false));
    verify(assetProfile).isDefault();
    verify(id).getId();
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link AssetProfile#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean); then calls getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_thenCallsGetId() {
    // Arrange
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(assetProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(assetProfile).getId();
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link AssetProfile#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean); then calls getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  void testDeleteEntity_thenCallsGetId2() {
    // Arrange
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(assetProfile);
    EntityId id = mock(EntityId.class);
    when(id.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.deleteEntity(ModelConstants.SYSTEM_TENANT, id, true));
    verify(assetProfile).getId();
    verify(id).getId();
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetProfiles(TenantId, PageLink)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfiles(TenantId, PageLink)"})
  void testFindAssetProfiles() {
    // Arrange
    when(assetProfileDao.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.findAssetProfiles(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(assetProfileDao).findAssetProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetProfiles(TenantId, PageLink)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfiles(TenantId, PageLink)"})
  void testFindAssetProfiles2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.findAssetProfiles(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetProfiles(TenantId, PageLink)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfiles(TenantId, PageLink)"})
  void testFindAssetProfiles3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.findAssetProfiles(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is {@code ASC}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetProfiles(TenantId, PageLink); given SortOrder with 'Property' and direction is 'ASC'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfiles(TenantId, PageLink)"})
  void testFindAssetProfiles_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<AssetProfile> emptyPageDataResult = PageData.emptyPageData();
    when(assetProfileDao.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetProfile> actualFindAssetProfilesResult =
        assetProfileServiceImpl.findAssetProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetProfileDao).findAssetProfiles(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindAssetProfilesResult.EMPTY_PAGE_DATA, actualFindAssetProfilesResult);
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetProfiles(TenantId, PageLink); given SortOrder(String) with property is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfiles(TenantId, PageLink)"})
  void testFindAssetProfiles_givenSortOrderWithPropertyIsEmptyString() {
    // Arrange
    PageData<AssetProfile> emptyPageDataResult = PageData.emptyPageData();
    when(assetProfileDao.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetProfile> actualFindAssetProfilesResult =
        assetProfileServiceImpl.findAssetProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetProfileDao).findAssetProfiles(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindAssetProfilesResult.EMPTY_PAGE_DATA, actualFindAssetProfilesResult);
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetProfiles(TenantId, PageLink); given SortOrder(String) with property is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfiles(TenantId, PageLink)"})
  void testFindAssetProfiles_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<AssetProfile> emptyPageDataResult = PageData.emptyPageData();
    when(assetProfileDao.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetProfile> actualFindAssetProfilesResult =
        assetProfileServiceImpl.findAssetProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetProfileDao).findAssetProfiles(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindAssetProfilesResult.EMPTY_PAGE_DATA, actualFindAssetProfilesResult);
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetProfiles(TenantId, PageLink); then calls getProperty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfiles(TenantId, PageLink)"})
  void testFindAssetProfiles_thenCallsGetProperty() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.findAssetProfiles(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetProfiles(TenantId, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfiles(TenantId, PageLink)"})
  void testFindAssetProfiles_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<AssetProfile> emptyPageDataResult = PageData.emptyPageData();
    when(assetProfileDao.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<AssetProfile> actualFindAssetProfilesResult =
        assetProfileServiceImpl.findAssetProfiles(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetProfileDao).findAssetProfiles(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindAssetProfilesResult.EMPTY_PAGE_DATA, actualFindAssetProfilesResult);
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetProfileInfos(TenantId, PageLink)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfileInfos(TenantId, PageLink)"})
  void testFindAssetProfileInfos() {
    // Arrange
    when(assetProfileDao.findAssetProfileInfos(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.findAssetProfileInfos(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(assetProfileDao).findAssetProfileInfos(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetProfileInfos(TenantId, PageLink)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfileInfos(TenantId, PageLink)"})
  void testFindAssetProfileInfos2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.findAssetProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetProfileInfos(TenantId, PageLink)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfileInfos(TenantId, PageLink)"})
  void testFindAssetProfileInfos3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.findAssetProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is {@code ASC}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetProfileInfos(TenantId, PageLink); given SortOrder with 'Property' and direction is 'ASC'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfileInfos(TenantId, PageLink)"})
  void testFindAssetProfileInfos_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<AssetProfileInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetProfileDao.findAssetProfileInfos(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetProfileInfo> actualFindAssetProfileInfosResult =
        assetProfileServiceImpl.findAssetProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetProfileDao).findAssetProfileInfos(isA(TenantId.class), isA(PageLink.class));
    assertSame(
        actualFindAssetProfileInfosResult.EMPTY_PAGE_DATA, actualFindAssetProfileInfosResult);
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is empty string.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetProfileInfos(TenantId, PageLink); given SortOrder(String) with property is empty string")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfileInfos(TenantId, PageLink)"})
  void testFindAssetProfileInfos_givenSortOrderWithPropertyIsEmptyString() {
    // Arrange
    PageData<AssetProfileInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetProfileDao.findAssetProfileInfos(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetProfileInfo> actualFindAssetProfileInfosResult =
        assetProfileServiceImpl.findAssetProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetProfileDao).findAssetProfileInfos(isA(TenantId.class), isA(PageLink.class));
    assertSame(
        actualFindAssetProfileInfosResult.EMPTY_PAGE_DATA, actualFindAssetProfileInfosResult);
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetProfileInfos(TenantId, PageLink); given SortOrder(String) with property is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfileInfos(TenantId, PageLink)"})
  void testFindAssetProfileInfos_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<AssetProfileInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetProfileDao.findAssetProfileInfos(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetProfileInfo> actualFindAssetProfileInfosResult =
        assetProfileServiceImpl.findAssetProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetProfileDao).findAssetProfileInfos(isA(TenantId.class), isA(PageLink.class));
    assertSame(
        actualFindAssetProfileInfosResult.EMPTY_PAGE_DATA, actualFindAssetProfileInfosResult);
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetProfileInfos(TenantId, PageLink); then calls getProperty()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfileInfos(TenantId, PageLink)"})
  void testFindAssetProfileInfos_thenCallsGetProperty() {
    // Arrange
    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenThrow(new DataValidationException("An error occurred"));
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.findAssetProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  @DisplayName(
      "Test findAssetProfileInfos(TenantId, PageLink); when FIRST_PAGE; then return EMPTY_PAGE_DATA")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfileInfos(TenantId, PageLink)"})
  void testFindAssetProfileInfos_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<AssetProfileInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetProfileDao.findAssetProfileInfos(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<AssetProfileInfo> actualFindAssetProfileInfosResult =
        assetProfileServiceImpl.findAssetProfileInfos(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(assetProfileDao).findAssetProfileInfos(isA(TenantId.class), isA(PageLink.class));
    assertSame(
        actualFindAssetProfileInfosResult.EMPTY_PAGE_DATA, actualFindAssetProfileInfosResult);
  }

  /**
   * Test {@link AssetProfileServiceImpl#createDefaultAssetProfile(TenantId)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#createDefaultAssetProfile(TenantId)}
   */
  @Test
  @DisplayName("Test createDefaultAssetProfile(TenantId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AssetProfile AssetProfileServiceImpl.createDefaultAssetProfile(TenantId)"})
  void testCreateDefaultAssetProfile() {
    // Arrange
    when(dataValidator.validate(
            Mockito.<AssetProfile>any(), Mockito.<Function<AssetProfile, TenantId>>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.createDefaultAssetProfile(ModelConstants.SYSTEM_TENANT));
    verify(dataValidator).validate(isA(AssetProfile.class), isA(Function.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#setDefaultAssetProfile(TenantId, AssetProfileId)}.
   *
   * <ul>
   *   <li>Given {@link AssetProfile} {@link AssetProfile#isDefault()} return {@code true}.
   *   <li>Then calls {@link AssetProfileId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#setDefaultAssetProfile(TenantId,
   * AssetProfileId)}
   */
  @Test
  @DisplayName(
      "Test setDefaultAssetProfile(TenantId, AssetProfileId); given AssetProfile isDefault() return 'true'; then calls getId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileServiceImpl.setDefaultAssetProfile(TenantId, AssetProfileId)"
  })
  void testSetDefaultAssetProfile_givenAssetProfileIsDefaultReturnTrue_thenCallsGetId() {
    // Arrange
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.isDefault()).thenReturn(true);
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(assetProfile);
    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    boolean actualSetDefaultAssetProfileResult =
        assetProfileServiceImpl.setDefaultAssetProfile(
            ModelConstants.SYSTEM_TENANT, assetProfileId);

    // Assert
    verify(assetProfile).isDefault();
    verify(assetProfileId, atLeast(1)).getId();
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    assertFalse(actualSetDefaultAssetProfileResult);
  }

  /**
   * Test {@link AssetProfileServiceImpl#setDefaultAssetProfile(TenantId, AssetProfileId)}.
   *
   * <ul>
   *   <li>Given {@link AssetProfile} {@link AssetProfile#isDefault()} return {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#setDefaultAssetProfile(TenantId,
   * AssetProfileId)}
   */
  @Test
  @DisplayName(
      "Test setDefaultAssetProfile(TenantId, AssetProfileId); given AssetProfile isDefault() return 'true'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean AssetProfileServiceImpl.setDefaultAssetProfile(TenantId, AssetProfileId)"
  })
  void testSetDefaultAssetProfile_givenAssetProfileIsDefaultReturnTrue_thenReturnFalse() {
    // Arrange
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.isDefault()).thenReturn(true);
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(assetProfile);

    // Act
    boolean actualSetDefaultAssetProfileResult =
        assetProfileServiceImpl.setDefaultAssetProfile(
            null, new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(assetProfile).isDefault();
    verify(assetProfileDao).findById(isNull(), isA(UUID.class));
    assertFalse(actualSetDefaultAssetProfileResult);
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteAssetProfilesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteAssetProfilesByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteAssetProfilesByTenantId(TenantId)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfilesByTenantId(TenantId)"})
  void testDeleteAssetProfilesByTenantId() {
    // Arrange
    PageData<AssetProfile> emptyPageDataResult = PageData.emptyPageData();
    when(assetProfileDao.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    assetProfileServiceImpl.deleteAssetProfilesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(assetProfileDao).findAssetProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteAssetProfilesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteAssetProfilesByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteAssetProfilesByTenantId(TenantId); then throw ConstraintViolationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfilesByTenantId(TenantId)"})
  void testDeleteAssetProfilesByTenantId_thenThrowConstraintViolationException() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setId(new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ArrayList<AssetProfile> data = new ArrayList<>();
    data.add(assetProfile);
    PageData<AssetProfile> pageData = new PageData<>(data, 100, 100L, true);

    doThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing deleteAssetProfilesByTenantId, tenantId [{}]"))
        .when(assetProfileDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetProfileDao.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> assetProfileServiceImpl.deleteAssetProfilesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(assetProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(assetProfileDao).findAssetProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteAssetProfilesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteAssetProfilesByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteAssetProfilesByTenantId(TenantId); then throw DataValidationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfilesByTenantId(TenantId)"})
  void testDeleteAssetProfilesByTenantId_thenThrowDataValidationException() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setId(new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ArrayList<AssetProfile> data = new ArrayList<>();
    data.add(assetProfile);
    PageData<AssetProfile> pageData = new PageData<>(data, 100, 100L, true);

    doThrow(new DataValidationException("An error occurred"))
        .when(assetProfileDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetProfileDao.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.deleteAssetProfilesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(assetProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(assetProfileDao).findAssetProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link AssetProfileDao} {@link AssetProfileDao#findAssetProfiles(TenantId,
   *       PageLink)} return emptyPageData.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteByTenantId(TenantId); given AssetProfileDao findAssetProfiles(TenantId, PageLink) return emptyPageData")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_givenAssetProfileDaoFindAssetProfilesReturnEmptyPageData() {
    // Arrange
    PageData<AssetProfile> emptyPageDataResult = PageData.emptyPageData();
    when(assetProfileDao.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    assetProfileServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(assetProfileDao).findAssetProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link ConstraintViolationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteByTenantId(TenantId); then throw ConstraintViolationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_thenThrowConstraintViolationException() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setId(new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ArrayList<AssetProfile> data = new ArrayList<>();
    data.add(assetProfile);
    PageData<AssetProfile> pageData = new PageData<>(data, 100, 100L, true);

    doThrow(
            new ConstraintViolationException(
                "An error occurred",
                new SQLException(),
                "Executing deleteAssetProfilesByTenantId, tenantId [{}]"))
        .when(assetProfileDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetProfileDao.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(
        ConstraintViolationException.class,
        () -> assetProfileServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(assetProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(assetProfileDao).findAssetProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteByTenantId(TenantId); then throw DataValidationException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_thenThrowDataValidationException() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setId(new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ArrayList<AssetProfile> data = new ArrayList<>();
    data.add(assetProfile);
    PageData<AssetProfile> pageData = new PageData<>(data, 100, 100L, true);

    doThrow(new DataValidationException("An error occurred"))
        .when(assetProfileDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(assetProfileDao.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(assetProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(assetProfileDao).findAssetProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#getEntityType()}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType AssetProfileServiceImpl.getEntityType()"})
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.ASSET_PROFILE, new AssetProfileServiceImpl().getEntityType());
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileNamesByTenantId(TenantId, boolean)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileNamesByTenantId(TenantId,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test findAssetProfileNamesByTenantId(TenantId, boolean); when SYSTEM_TENANT; then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "List AssetProfileServiceImpl.findAssetProfileNamesByTenantId(TenantId, boolean)"
  })
  void testFindAssetProfileNamesByTenantId_whenSystem_tenant_thenReturnEmpty() {
    // Arrange
    when(assetProfileDao.findTenantAssetProfileNames(Mockito.<UUID>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityInfo> actualFindAssetProfileNamesByTenantIdResult =
        assetProfileServiceImpl.findAssetProfileNamesByTenantId(ModelConstants.SYSTEM_TENANT, true);

    // Assert
    verify(assetProfileDao).findTenantAssetProfileNames(isA(UUID.class), eq(true));
    assertTrue(actualFindAssetProfileNamesByTenantIdResult.isEmpty());
  }
}
