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
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
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
import org.thingsboard.server.common.data.HasImage;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.asset.AssetProfileInfo;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.page.SortOrder;
import org.thingsboard.server.dao.edge.BaseRelatedEdgesService;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.resource.ImageService;
import org.thingsboard.server.dao.service.DataValidator;

@ExtendWith(MockitoExtension.class)
class AssetProfileServiceImplDiffblueTest {
  @Mock private AssetProfileDao assetProfileDao;

  @InjectMocks private AssetProfileServiceImpl assetProfileServiceImpl;

  @Mock private DataValidator<AssetProfile> dataValidator;

  @Mock private ImageService imageService;

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link AssetProfileServiceImpl#findAssetProfileById(TenantId, AssetProfileId)} with {@code
   * tenantId}, {@code assetProfileId}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileById(TenantId,
   * AssetProfileId)}
   */
  @Test
  @DisplayName(
      "Test findAssetProfileById(TenantId, AssetProfileId) with 'tenantId', 'assetProfileId'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssetProfile AssetProfileServiceImpl.findAssetProfileById(TenantId, AssetProfileId)"
  })
  void testFindAssetProfileByIdWithTenantIdAssetProfileId() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.findAssetProfileById(
                ModelConstants.SYSTEM_TENANT, assetProfileId));
    verify(assetProfileId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileById(TenantId, AssetProfileId, boolean)}
   * with {@code tenantId}, {@code assetProfileId}, {@code putInCache}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileById(TenantId,
   * AssetProfileId, boolean)}
   */
  @Test
  @DisplayName(
      "Test findAssetProfileById(TenantId, AssetProfileId, boolean) with 'tenantId', 'assetProfileId', 'putInCache'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssetProfile AssetProfileServiceImpl.findAssetProfileById(TenantId, AssetProfileId, boolean)"
  })
  void testFindAssetProfileByIdWithTenantIdAssetProfileIdPutInCache() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.findAssetProfileById(
                ModelConstants.SYSTEM_TENANT, assetProfileId, true));
    verify(assetProfileId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileInfoById(TenantId, AssetProfileId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileInfoById(TenantId,
   * AssetProfileId)}
   */
  @Test
  @DisplayName(
      "Test findAssetProfileInfoById(TenantId, AssetProfileId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssetProfileInfo AssetProfileServiceImpl.findAssetProfileInfoById(TenantId, AssetProfileId)"
  })
  void testFindAssetProfileInfoById_thenThrowDataValidationException() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.findAssetProfileInfoById(
                ModelConstants.SYSTEM_TENANT, assetProfileId));
    verify(assetProfileId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#saveAssetProfile(AssetProfile)} with {@code assetProfile}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#saveAssetProfile(AssetProfile)}
   */
  @Test
  @DisplayName("Test saveAssetProfile(AssetProfile) with 'assetProfile'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link AssetProfileServiceImpl#saveAssetProfile(AssetProfile, boolean, boolean)} with
   * {@code assetProfile}, {@code doValidate}, {@code publishSaveEvent}.
   *
   * <ul>
   *   <li>Then calls {@link AssetProfileId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#saveAssetProfile(AssetProfile, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test saveAssetProfile(AssetProfile, boolean, boolean) with 'assetProfile', 'doValidate', 'publishSaveEvent'; then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssetProfile AssetProfileServiceImpl.saveAssetProfile(AssetProfile, boolean, boolean)"
  })
  void testSaveAssetProfileWithAssetProfileDoValidatePublishSaveEvent_thenCallsGetId() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.saveAssetProfile(
                new AssetProfile(assetProfileId), false, false));
    verify(assetProfileId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#saveAssetProfile(AssetProfile, boolean, boolean)} with
   * {@code assetProfile}, {@code doValidate}, {@code publishSaveEvent}.
   *
   * <ul>
   *   <li>Then calls {@link AssetProfile#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#saveAssetProfile(AssetProfile, boolean,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test saveAssetProfile(AssetProfile, boolean, boolean) with 'assetProfile', 'doValidate', 'publishSaveEvent'; then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssetProfile AssetProfileServiceImpl.saveAssetProfile(AssetProfile, boolean, boolean)"
  })
  void testSaveAssetProfileWithAssetProfileDoValidatePublishSaveEvent_thenCallsGetName() {
    // Arrange
    when(assetProfileDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<AssetProfile>any()))
        .thenReturn(new AssetProfile());

    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.getName()).thenThrow(new DataValidationException("An error occurred"));
    when(dataValidator.validate(
            Mockito.<AssetProfile>any(), Mockito.<Function<AssetProfile, TenantId>>any()))
        .thenReturn(assetProfile);
    when(imageService.replaceBase64WithImageUrl(Mockito.<HasImage>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.saveAssetProfile(new AssetProfile(), true, true));
    verify(assetProfile, atLeast(1)).getName();
    verify(assetProfileDao).saveAndFlush(isNull(), isA(AssetProfile.class));
    verify(imageService).replaceBase64WithImageUrl(isA(HasImage.class), eq("asset profile"));
    verify(dataValidator).validate(isA(AssetProfile.class), isA(Function.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#saveAssetProfile(AssetProfile)} with {@code assetProfile}.
   *
   * <ul>
   *   <li>Then calls {@link AssetProfile#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#saveAssetProfile(AssetProfile)}
   */
  @Test
  @DisplayName("Test saveAssetProfile(AssetProfile) with 'assetProfile'; then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile AssetProfileServiceImpl.saveAssetProfile(AssetProfile)"})
  void testSaveAssetProfileWithAssetProfile_thenCallsGetName() {
    // Arrange
    when(assetProfileDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<AssetProfile>any()))
        .thenReturn(new AssetProfile());

    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.getName()).thenThrow(new DataValidationException("An error occurred"));
    when(dataValidator.validate(
            Mockito.<AssetProfile>any(), Mockito.<Function<AssetProfile, TenantId>>any()))
        .thenReturn(assetProfile);
    when(imageService.replaceBase64WithImageUrl(Mockito.<HasImage>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.saveAssetProfile(new AssetProfile()));
    verify(assetProfile, atLeast(1)).getName();
    verify(assetProfileDao).saveAndFlush(isNull(), isA(AssetProfile.class));
    verify(imageService).replaceBase64WithImageUrl(isA(HasImage.class), eq("asset profile"));
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   *   <li>Given {@link AssetProfile#AssetProfile()} Default is {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId,
   * AssetProfileId)}
   */
  @Test
  @DisplayName(
      "Test deleteAssetProfile(TenantId, AssetProfileId); given AssetProfile() Default is 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfile(TenantId, AssetProfileId)"})
  void testDeleteAssetProfile_givenAssetProfileDefaultIsTrue() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setDefault(true);
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(assetProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.deleteAssetProfile(
                ModelConstants.SYSTEM_TENANT, new AssetProfileId(ModelConstants.NULL_UUID)));
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId, AssetProfileId)}.
   *
   * <ul>
   *   <li>Given {@link AssetProfileServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId,
   * AssetProfileId)}
   */
  @Test
  @DisplayName(
      "Test deleteAssetProfile(TenantId, AssetProfileId); given AssetProfileServiceImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfile(TenantId, AssetProfileId)"})
  void testDeleteAssetProfile_givenAssetProfileServiceImpl() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.deleteAssetProfile(
                ModelConstants.SYSTEM_TENANT, assetProfileId));
    verify(assetProfileId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId, AssetProfileId)}.
   *
   * <ul>
   *   <li>Given fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId,
   * AssetProfileId)}
   */
  @Test
  @DisplayName(
      "Test deleteAssetProfile(TenantId, AssetProfileId); given fromString '784f394c-42b6-435a-983c-b7beff2784f9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfile(TenantId, AssetProfileId)"})
  void testDeleteAssetProfile_givenFromString784f394c42b6435a983cB7beff2784f9() {
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
   *   <li>Then calls {@link AssetProfile#isDefault()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteAssetProfile(TenantId,
   * AssetProfileId)}
   */
  @Test
  @DisplayName("Test deleteAssetProfile(TenantId, AssetProfileId); then calls isDefault()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link AssetProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}
   */
  @Test
  @DisplayName("Test deleteEntity(TenantId, EntityId, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfiles(TenantId, PageLink)"})
  void testFindAssetProfiles() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfiles(TenantId, PageLink)"})
  void testFindAssetProfiles2() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

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
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetProfiles(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfiles(TenantId, PageLink)"})
  void testFindAssetProfiles3() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

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
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetProfiles(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfiles(TenantId, PageLink)"})
  void testFindAssetProfiles4() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.findAssetProfiles(tenantId, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetProfiles(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfiles(TenantId, PageLink)"})
  void testFindAssetProfiles5() {
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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetProfiles(TenantId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfiles(TenantId, PageLink)"})
  void testFindAssetProfiles_givenBy_created_time_desc() {
    // Arrange
    PageData<AssetProfile> emptyPageDataResult = PageData.emptyPageData();
    when(assetProfileDao.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetProfile> actualFindAssetProfilesResult =
        assetProfileServiceImpl.findAssetProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetProfileDao).findAssetProfiles(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetProfilesResult);
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfiles(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetProfiles(TenantId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfiles(TenantId, PageLink)"})
  void testFindAssetProfiles_thenCallsGetId() {
    // Arrange
    PageData<AssetProfile> emptyPageDataResult = PageData.emptyPageData();
    when(assetProfileDao.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetProfile> actualFindAssetProfilesResult =
        assetProfileServiceImpl.findAssetProfiles(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetProfileDao).findAssetProfiles(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetProfilesResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfiles(TenantId, PageLink)"})
  void testFindAssetProfiles_thenCallsGetProperty() {
    // Arrange
    PageData<AssetProfile> emptyPageDataResult = PageData.emptyPageData();
    when(assetProfileDao.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetProfile> actualFindAssetProfilesResult =
        assetProfileServiceImpl.findAssetProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetProfileDao).findAssetProfiles(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetProfilesResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetProfilesResult);
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetProfileInfos(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfileInfos(TenantId, PageLink)"})
  void testFindAssetProfileInfos() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfileInfos(TenantId, PageLink)"})
  void testFindAssetProfileInfos2() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

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
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetProfileInfos(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfileInfos(TenantId, PageLink)"})
  void testFindAssetProfileInfos3() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

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
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetProfileInfos(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfileInfos(TenantId, PageLink)"})
  void testFindAssetProfileInfos4() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.findAssetProfileInfos(tenantId, mock(PageLink.class)));
    verify(tenantId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetProfileInfos(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfileInfos(TenantId, PageLink)"})
  void testFindAssetProfileInfos5() {
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
   * <ul>
   *   <li>Given {@link SortOrder#BY_CREATED_TIME_DESC}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetProfileInfos(TenantId, PageLink); given BY_CREATED_TIME_DESC")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfileInfos(TenantId, PageLink)"})
  void testFindAssetProfileInfos_givenBy_created_time_desc() {
    // Arrange
    PageData<AssetProfileInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetProfileDao.findAssetProfileInfos(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.BY_CREATED_TIME_DESC);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetProfileInfo> actualFindAssetProfileInfosResult =
        assetProfileServiceImpl.findAssetProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(assetProfileDao).findAssetProfileInfos(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetProfileInfosResult);
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileInfos(TenantId, PageLink)}
   */
  @Test
  @DisplayName("Test findAssetProfileInfos(TenantId, PageLink); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfileInfos(TenantId, PageLink)"})
  void testFindAssetProfileInfos_thenCallsGetId() {
    // Arrange
    PageData<AssetProfileInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetProfileDao.findAssetProfileInfos(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetProfileInfo> actualFindAssetProfileInfosResult =
        assetProfileServiceImpl.findAssetProfileInfos(tenantId, pageLink);

    // Assert
    verify(tenantId).getId();
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetProfileDao).findAssetProfileInfos(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetProfileInfosResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"PageData AssetProfileServiceImpl.findAssetProfileInfos(TenantId, PageLink)"})
  void testFindAssetProfileInfos_thenCallsGetProperty() {
    // Arrange
    PageData<AssetProfileInfo> emptyPageDataResult = PageData.emptyPageData();
    when(assetProfileDao.findAssetProfileInfos(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    SortOrder sortOrder = mock(SortOrder.class);
    when(sortOrder.getProperty()).thenReturn("");

    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(sortOrder);
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<AssetProfileInfo> actualFindAssetProfileInfosResult =
        assetProfileServiceImpl.findAssetProfileInfos(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
    verify(assetProfileDao).findAssetProfileInfos(isA(TenantId.class), isA(PageLink.class));
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetProfileInfosResult);
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
    assertSame(PageData.EMPTY_PAGE_DATA, actualFindAssetProfileInfosResult);
  }

  /**
   * Test {@link AssetProfileServiceImpl#createDefaultAssetProfile(TenantId)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#createDefaultAssetProfile(TenantId)}
   */
  @Test
  @DisplayName("Test createDefaultAssetProfile(TenantId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
   * Test {@link AssetProfileServiceImpl#createDefaultAssetProfile(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link AssetProfileServiceImpl} (default constructor).
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#createDefaultAssetProfile(TenantId)}
   */
  @Test
  @DisplayName(
      "Test createDefaultAssetProfile(TenantId); given AssetProfileServiceImpl (default constructor); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile AssetProfileServiceImpl.createDefaultAssetProfile(TenantId)"})
  void testCreateDefaultAssetProfile_givenAssetProfileServiceImpl_thenCallsGetId() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.createDefaultAssetProfile(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#createDefaultAssetProfile(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link AssetProfile#getName()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#createDefaultAssetProfile(TenantId)}
   */
  @Test
  @DisplayName("Test createDefaultAssetProfile(TenantId); then calls getName()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile AssetProfileServiceImpl.createDefaultAssetProfile(TenantId)"})
  void testCreateDefaultAssetProfile_thenCallsGetName() {
    // Arrange
    when(assetProfileDao.saveAndFlush(Mockito.<TenantId>any(), Mockito.<AssetProfile>any()))
        .thenReturn(new AssetProfile());

    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.getName()).thenThrow(new DataValidationException("An error occurred"));
    when(dataValidator.validate(
            Mockito.<AssetProfile>any(), Mockito.<Function<AssetProfile, TenantId>>any()))
        .thenReturn(assetProfile);
    when(imageService.replaceBase64WithImageUrl(Mockito.<HasImage>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.createDefaultAssetProfile(ModelConstants.SYSTEM_TENANT));
    verify(assetProfile, atLeast(1)).getName();
    verify(assetProfileDao).saveAndFlush(isA(TenantId.class), isA(AssetProfile.class));
    verify(imageService).replaceBase64WithImageUrl(isA(HasImage.class), eq("asset profile"));
    verify(dataValidator).validate(isA(AssetProfile.class), isA(Function.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#findDefaultAssetProfile(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findDefaultAssetProfile(TenantId)}
   */
  @Test
  @DisplayName("Test findDefaultAssetProfile(TenantId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile AssetProfileServiceImpl.findDefaultAssetProfile(TenantId)"})
  void testFindDefaultAssetProfile_thenThrowDataValidationException() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.findDefaultAssetProfile(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#findDefaultAssetProfileInfo(TenantId)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findDefaultAssetProfileInfo(TenantId)}
   */
  @Test
  @DisplayName("Test findDefaultAssetProfileInfo(TenantId); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AssetProfileInfo AssetProfileServiceImpl.findDefaultAssetProfileInfo(TenantId)"
  })
  void testFindDefaultAssetProfileInfo_thenThrowDataValidationException() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.findDefaultAssetProfileInfo(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#setDefaultAssetProfile(TenantId, AssetProfileId)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#setDefaultAssetProfile(TenantId,
   * AssetProfileId)}
   */
  @Test
  @DisplayName("Test setDefaultAssetProfile(TenantId, AssetProfileId)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileServiceImpl.setDefaultAssetProfile(TenantId, AssetProfileId)"
  })
  void testSetDefaultAssetProfile() {
    // Arrange
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.isDefault()).thenReturn(true);
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(assetProfile);
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    boolean actualSetDefaultAssetProfileResult =
        assetProfileServiceImpl.setDefaultAssetProfile(tenantId, assetProfileId);

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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
            ModelConstants.SYSTEM_TENANT,
            new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(assetProfile).isDefault();
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    assertFalse(actualSetDefaultAssetProfileResult);
  }

  /**
   * Test {@link AssetProfileServiceImpl#setDefaultAssetProfile(TenantId, AssetProfileId)}.
   *
   * <ul>
   *   <li>Given {@link AssetProfileServiceImpl} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#setDefaultAssetProfile(TenantId,
   * AssetProfileId)}
   */
  @Test
  @DisplayName(
      "Test setDefaultAssetProfile(TenantId, AssetProfileId); given AssetProfileServiceImpl (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileServiceImpl.setDefaultAssetProfile(TenantId, AssetProfileId)"
  })
  void testSetDefaultAssetProfile_givenAssetProfileServiceImpl() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    AssetProfileId assetProfileId = mock(AssetProfileId.class);
    when(assetProfileId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.setDefaultAssetProfile(
                ModelConstants.SYSTEM_TENANT, assetProfileId));
    verify(assetProfileId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#setDefaultAssetProfile(TenantId, AssetProfileId)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#setDefaultAssetProfile(TenantId,
   * AssetProfileId)}
   */
  @Test
  @DisplayName("Test setDefaultAssetProfile(TenantId, AssetProfileId); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AssetProfileServiceImpl.setDefaultAssetProfile(TenantId, AssetProfileId)"
  })
  void testSetDefaultAssetProfile_thenCallsGetId() {
    // Arrange
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(new AssetProfile());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            assetProfileServiceImpl.setDefaultAssetProfile(
                tenantId,
                new AssetProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(tenantId).getId();
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteAssetProfilesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteAssetProfilesByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteAssetProfilesByTenantId(TenantId); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfilesByTenantId(TenantId)"})
  void testDeleteAssetProfilesByTenantId_thenCallsGetId() {
    // Arrange
    PageData<AssetProfile> emptyPageDataResult = PageData.emptyPageData();
    when(assetProfileDao.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    assetProfileServiceImpl.deleteAssetProfilesByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfilesByTenantId(TenantId)"})
  void testDeleteAssetProfilesByTenantId_thenThrowDataValidationException() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.deleteAssetProfilesByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteAssetProfilesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link AssetProfileDao#findAssetProfiles(TenantId, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteAssetProfilesByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteAssetProfilesByTenantId(TenantId); when SYSTEM_TENANT; then calls findAssetProfiles(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteAssetProfilesByTenantId(TenantId)"})
  void testDeleteAssetProfilesByTenantId_whenSystem_tenant_thenCallsFindAssetProfiles() {
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
   * Test {@link AssetProfileServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName("Test deleteByTenantId(TenantId); then calls getId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_thenCallsGetId() {
    // Arrange
    PageData<AssetProfile> emptyPageDataResult = PageData.emptyPageData();
    when(assetProfileDao.findAssetProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    assetProfileServiceImpl.deleteByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_thenThrowDataValidationException() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> assetProfileServiceImpl.deleteByTenantId(tenantId));
    verify(tenantId).getId();
  }

  /**
   * Test {@link AssetProfileServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link AssetProfileDao#findAssetProfiles(TenantId, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @DisplayName(
      "Test deleteByTenantId(TenantId); when SYSTEM_TENANT; then calls findAssetProfiles(TenantId, PageLink)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileServiceImpl.deleteByTenantId(TenantId)"})
  void testDeleteByTenantId_whenSystem_tenant_thenCallsFindAssetProfiles() {
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
   * Test {@link AssetProfileServiceImpl#getEntityType()}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityType AssetProfileServiceImpl.getEntityType()"})
  void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.ASSET_PROFILE, new AssetProfileServiceImpl().getEntityType());
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileNamesByTenantId(TenantId, boolean)}.
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileNamesByTenantId(TenantId,
   * boolean)}
   */
  @Test
  @DisplayName("Test findAssetProfileNamesByTenantId(TenantId, boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AssetProfileServiceImpl.findAssetProfileNamesByTenantId(TenantId, boolean)"
  })
  void testFindAssetProfileNamesByTenantId() {
    // Arrange
    when(assetProfileDao.findTenantAssetProfileNames(Mockito.<UUID>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    List<EntityInfo> actualFindAssetProfileNamesByTenantIdResult =
        assetProfileServiceImpl.findAssetProfileNamesByTenantId(tenantId, true);

    // Assert
    verify(tenantId, atLeast(1)).getId();
    verify(assetProfileDao).findTenantAssetProfileNames(isA(UUID.class), eq(true));
    assertTrue(actualFindAssetProfileNamesByTenantIdResult.isEmpty());
  }

  /**
   * Test {@link AssetProfileServiceImpl#findAssetProfileNamesByTenantId(TenantId, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileServiceImpl#findAssetProfileNamesByTenantId(TenantId,
   * boolean)}
   */
  @Test
  @DisplayName(
      "Test findAssetProfileNamesByTenantId(TenantId, boolean); then throw DataValidationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List AssetProfileServiceImpl.findAssetProfileNamesByTenantId(TenantId, boolean)"
  })
  void testFindAssetProfileNamesByTenantId_thenThrowDataValidationException() {
    // Arrange
    AssetProfileServiceImpl assetProfileServiceImpl = new AssetProfileServiceImpl();

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> assetProfileServiceImpl.findAssetProfileNamesByTenantId(tenantId, true));
    verify(tenantId).getId();
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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
