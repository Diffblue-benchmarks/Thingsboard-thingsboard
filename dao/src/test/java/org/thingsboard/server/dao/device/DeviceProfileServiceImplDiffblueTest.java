package org.thingsboard.server.dao.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.DeviceProfileInfo;
import org.thingsboard.server.common.data.EntityInfo;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DeviceProfileId;
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

@RunWith(MockitoJUnitRunner.class)
public class DeviceProfileServiceImplDiffblueTest {
  @Mock private DeviceProfileDao deviceProfileDao;

  @InjectMocks private DeviceProfileServiceImpl deviceProfileServiceImpl;

  /**
   * Test {@link DeviceProfileServiceImpl#handleEvictEvent(DeviceProfileEvictEvent)} with {@code
   * DeviceProfileEvictEvent}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceProfileServiceImpl#handleEvictEvent(DeviceProfileEvictEvent)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceProfileServiceImpl.handleEvictEvent(DeviceProfileEvictEvent)"})
  public void testHandleEvictEventWithDeviceProfileEvictEvent_thenThrowDataValidationException() {
    // Arrange
    DeviceProfileServiceImpl deviceProfileServiceImpl = new DeviceProfileServiceImpl();
    DeviceProfile savedDeviceProfile = mock(DeviceProfile.class);
    when(savedDeviceProfile.getId()).thenThrow(new DataValidationException("An error occurred"));

    DeviceProfileEvictEvent event =
        new DeviceProfileEvictEvent(
            ModelConstants.SYSTEM_TENANT,
            "New Name",
            "Old Name",
            null,
            true,
            "Provision Device Key");
    event.setSavedDeviceProfile(savedDeviceProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class, () -> deviceProfileServiceImpl.handleEvictEvent(event));
    verify(savedDeviceProfile).getId();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId, DeviceProfileId)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DeviceProfileServiceImpl.deleteDeviceProfile(TenantId, DeviceProfileId)"
  })
  public void testDeleteDeviceProfile() {
    // Arrange
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteDeviceProfile(
                ModelConstants.SYSTEM_TENANT,
                new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId, DeviceProfileId)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DeviceProfileServiceImpl.deleteDeviceProfile(TenantId, DeviceProfileId)"
  })
  public void testDeleteDeviceProfile2() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.isDefault()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteDeviceProfile(
                ModelConstants.SYSTEM_TENANT,
                new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(deviceProfile).isDefault();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfileDao} {@link DeviceProfileDao#findById(TenantId, UUID)} return
   *       {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DeviceProfileServiceImpl.deleteDeviceProfile(TenantId, DeviceProfileId)"
  })
  public void testDeleteDeviceProfile_givenDeviceProfileDaoFindByIdReturnNull() {
    // Arrange
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    deviceProfileServiceImpl.deleteDeviceProfile(
        ModelConstants.SYSTEM_TENANT,
        new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfile} {@link DeviceProfile#isDefault()} return {@code true}.
   *   <li>Then calls {@link DeviceProfile#isDefault()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DeviceProfileServiceImpl.deleteDeviceProfile(TenantId, DeviceProfileId)"
  })
  public void testDeleteDeviceProfile_givenDeviceProfileIsDefaultReturnTrue_thenCallsIsDefault() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.isDefault()).thenReturn(true);
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteDeviceProfile(
                ModelConstants.SYSTEM_TENANT,
                new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(deviceProfile).isDefault();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity() {
    // Arrange
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity2() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(deviceProfile).getId();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity3() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId())
        .thenReturn(new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doThrow(new DataValidationException("An error occurred"))
        .when(deviceProfileDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(deviceProfile).getId();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(deviceProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfileDao} {@link DeviceProfileDao#findById(TenantId, UUID)} return
   *       {@code null}.
   *   <li>Then calls {@link DeviceProfileDao#findById(TenantId, UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity_givenDeviceProfileDaoFindByIdReturnNull_thenCallsFindById() {
    // Arrange
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    deviceProfileServiceImpl.deleteEntity(
        ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true);

    // Assert
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity_thenCallsGetTenantId() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfile.getId())
        .thenReturn(new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    doNothing().when(deviceProfileDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, true));
    verify(deviceProfile).getId();
    verify(deviceProfile).getTenantId();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    verify(deviceProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#isDefault()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity_thenCallsIsDefault() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.isDefault()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, false));
    verify(deviceProfile).isDefault();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId, boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then calls {@link DeviceProfile#isDefault()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteEntity(TenantId, EntityId,
   * boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteEntity(TenantId, EntityId, boolean)"})
  public void testDeleteEntity_whenFalse_thenCallsIsDefault() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.isDefault()).thenReturn(true);
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfile);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteEntity(
                ModelConstants.SYSTEM_TENANT, BaseEntityService.NULL_CUSTOMER_ID, false));
    verify(deviceProfile).isDefault();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceProfileServiceImpl.findDeviceProfiles(TenantId, PageLink)"})
  public void testFindDeviceProfiles() {
    // Arrange
    when(deviceProfileDao.findDeviceProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.findDeviceProfiles(
                ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE));
    verify(deviceProfileDao).findDeviceProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceProfileServiceImpl.findDeviceProfiles(TenantId, PageLink)"})
  public void testFindDeviceProfiles2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.findDeviceProfiles(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceProfileServiceImpl.findDeviceProfiles(TenantId, PageLink)"})
  public void testFindDeviceProfiles3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () -> deviceProfileServiceImpl.findDeviceProfiles(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is {@code ASC}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceProfileServiceImpl.findDeviceProfiles(TenantId, PageLink)"})
  public void testFindDeviceProfiles_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<DeviceProfile> emptyPageDataResult = PageData.emptyPageData();
    when(deviceProfileDao.findDeviceProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceProfile> actualFindDeviceProfilesResult =
        deviceProfileServiceImpl.findDeviceProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceProfileDao).findDeviceProfiles(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindDeviceProfilesResult.EMPTY_PAGE_DATA, actualFindDeviceProfilesResult);
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceProfileServiceImpl.findDeviceProfiles(TenantId, PageLink)"})
  public void testFindDeviceProfiles_givenSortOrderWithPropertyIsEmptyString() {
    // Arrange
    PageData<DeviceProfile> emptyPageDataResult = PageData.emptyPageData();
    when(deviceProfileDao.findDeviceProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceProfile> actualFindDeviceProfilesResult =
        deviceProfileServiceImpl.findDeviceProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceProfileDao).findDeviceProfiles(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindDeviceProfilesResult.EMPTY_PAGE_DATA, actualFindDeviceProfilesResult);
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceProfileServiceImpl.findDeviceProfiles(TenantId, PageLink)"})
  public void testFindDeviceProfiles_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<DeviceProfile> emptyPageDataResult = PageData.emptyPageData();
    when(deviceProfileDao.findDeviceProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceProfile> actualFindDeviceProfilesResult =
        deviceProfileServiceImpl.findDeviceProfiles(ModelConstants.SYSTEM_TENANT, pageLink);

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceProfileDao).findDeviceProfiles(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindDeviceProfilesResult.EMPTY_PAGE_DATA, actualFindDeviceProfilesResult);
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceProfileServiceImpl.findDeviceProfiles(TenantId, PageLink)"})
  public void testFindDeviceProfiles_thenCallsGetProperty() {
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
        () -> deviceProfileServiceImpl.findDeviceProfiles(ModelConstants.SYSTEM_TENANT, pageLink));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfiles(TenantId, PageLink)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"PageData DeviceProfileServiceImpl.findDeviceProfiles(TenantId, PageLink)"})
  public void testFindDeviceProfiles_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<DeviceProfile> emptyPageDataResult = PageData.emptyPageData();
    when(deviceProfileDao.findDeviceProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<DeviceProfile> actualFindDeviceProfilesResult =
        deviceProfileServiceImpl.findDeviceProfiles(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE);

    // Assert
    verify(deviceProfileDao).findDeviceProfiles(isA(TenantId.class), isA(PageLink.class));
    assertSame(actualFindDeviceProfilesResult.EMPTY_PAGE_DATA, actualFindDeviceProfilesResult);
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId, PageLink, String)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId,
   * PageLink, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceProfileServiceImpl.findDeviceProfileInfos(TenantId, PageLink, String)"
  })
  public void testFindDeviceProfileInfos() {
    // Arrange
    when(deviceProfileDao.findDeviceProfileInfos(
            Mockito.<TenantId>any(), Mockito.<PageLink>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.findDeviceProfileInfos(
                ModelConstants.SYSTEM_TENANT,
                BaseRelatedEdgesService.FIRST_PAGE,
                "Transport Type"));
    verify(deviceProfileDao)
        .findDeviceProfileInfos(isA(TenantId.class), isA(PageLink.class), eq("Transport Type"));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId, PageLink, String)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId,
   * PageLink, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceProfileServiceImpl.findDeviceProfileInfos(TenantId, PageLink, String)"
  })
  public void testFindDeviceProfileInfos2() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPageSize()).thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.findDeviceProfileInfos(
                ModelConstants.SYSTEM_TENANT, pageLink, "Transport Type"));
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId, PageLink, String)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId,
   * PageLink, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceProfileServiceImpl.findDeviceProfileInfos(TenantId, PageLink, String)"
  })
  public void testFindDeviceProfileInfos3() {
    // Arrange
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenThrow(new DataValidationException("An error occurred"));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.findDeviceProfileInfos(
                ModelConstants.SYSTEM_TENANT, pageLink, "Transport Type"));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId, PageLink, String)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder} with {@code Property} and direction is {@code ASC}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId,
   * PageLink, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceProfileServiceImpl.findDeviceProfileInfos(TenantId, PageLink, String)"
  })
  public void testFindDeviceProfileInfos_givenSortOrderWithPropertyAndDirectionIsAsc() {
    // Arrange
    PageData<DeviceProfileInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceProfileDao.findDeviceProfileInfos(
            Mockito.<TenantId>any(), Mockito.<PageLink>any(), Mockito.<String>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(1);
    when(pageLink.getSortOrder()).thenReturn(SortOrder.of("Property", Direction.ASC));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceProfileInfo> actualFindDeviceProfileInfosResult =
        deviceProfileServiceImpl.findDeviceProfileInfos(
            ModelConstants.SYSTEM_TENANT, pageLink, "Transport Type");

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceProfileDao)
        .findDeviceProfileInfos(isA(TenantId.class), isA(PageLink.class), eq("Transport Type"));
    assertSame(
        actualFindDeviceProfileInfosResult.EMPTY_PAGE_DATA, actualFindDeviceProfileInfosResult);
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId, PageLink, String)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId,
   * PageLink, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceProfileServiceImpl.findDeviceProfileInfos(TenantId, PageLink, String)"
  })
  public void testFindDeviceProfileInfos_givenSortOrderWithPropertyIsEmptyString() {
    // Arrange
    PageData<DeviceProfileInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceProfileDao.findDeviceProfileInfos(
            Mockito.<TenantId>any(), Mockito.<PageLink>any(), Mockito.<String>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(""));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceProfileInfo> actualFindDeviceProfileInfosResult =
        deviceProfileServiceImpl.findDeviceProfileInfos(
            ModelConstants.SYSTEM_TENANT, pageLink, "Transport Type");

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceProfileDao)
        .findDeviceProfileInfos(isA(TenantId.class), isA(PageLink.class), eq("Transport Type"));
    assertSame(
        actualFindDeviceProfileInfosResult.EMPTY_PAGE_DATA, actualFindDeviceProfileInfosResult);
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId, PageLink, String)}.
   *
   * <ul>
   *   <li>Given {@link SortOrder#SortOrder(String)} with property is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId,
   * PageLink, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceProfileServiceImpl.findDeviceProfileInfos(TenantId, PageLink, String)"
  })
  public void testFindDeviceProfileInfos_givenSortOrderWithPropertyIsNull() {
    // Arrange
    PageData<DeviceProfileInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceProfileDao.findDeviceProfileInfos(
            Mockito.<TenantId>any(), Mockito.<PageLink>any(), Mockito.<String>any()))
        .thenReturn(emptyPageDataResult);
    PageLink pageLink = mock(PageLink.class);
    when(pageLink.getPage()).thenReturn(0);
    when(pageLink.getSortOrder()).thenReturn(new SortOrder(null));
    when(pageLink.getPageSize()).thenReturn(1);

    // Act
    PageData<DeviceProfileInfo> actualFindDeviceProfileInfosResult =
        deviceProfileServiceImpl.findDeviceProfileInfos(
            ModelConstants.SYSTEM_TENANT, pageLink, "Transport Type");

    // Assert
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(deviceProfileDao)
        .findDeviceProfileInfos(isA(TenantId.class), isA(PageLink.class), eq("Transport Type"));
    assertSame(
        actualFindDeviceProfileInfosResult.EMPTY_PAGE_DATA, actualFindDeviceProfileInfosResult);
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId, PageLink, String)}.
   *
   * <ul>
   *   <li>Then calls {@link SortOrder#getProperty()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId,
   * PageLink, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceProfileServiceImpl.findDeviceProfileInfos(TenantId, PageLink, String)"
  })
  public void testFindDeviceProfileInfos_thenCallsGetProperty() {
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
            deviceProfileServiceImpl.findDeviceProfileInfos(
                ModelConstants.SYSTEM_TENANT, pageLink, "Transport Type"));
    verify(pageLink).getPage();
    verify(pageLink).getPageSize();
    verify(pageLink, atLeast(1)).getSortOrder();
    verify(sortOrder).getProperty();
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId, PageLink, String)}.
   *
   * <ul>
   *   <li>When {@link BaseRelatedEdgesService#FIRST_PAGE}.
   *   <li>Then return {@link PageData#EMPTY_PAGE_DATA}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#findDeviceProfileInfos(TenantId,
   * PageLink, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "PageData DeviceProfileServiceImpl.findDeviceProfileInfos(TenantId, PageLink, String)"
  })
  public void testFindDeviceProfileInfos_whenFirst_page_thenReturnEmpty_page_data() {
    // Arrange
    PageData<DeviceProfileInfo> emptyPageDataResult = PageData.emptyPageData();
    when(deviceProfileDao.findDeviceProfileInfos(
            Mockito.<TenantId>any(), Mockito.<PageLink>any(), Mockito.<String>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    PageData<DeviceProfileInfo> actualFindDeviceProfileInfosResult =
        deviceProfileServiceImpl.findDeviceProfileInfos(
            ModelConstants.SYSTEM_TENANT, BaseRelatedEdgesService.FIRST_PAGE, "Transport Type");

    // Assert
    verify(deviceProfileDao)
        .findDeviceProfileInfos(isA(TenantId.class), isA(PageLink.class), eq("Transport Type"));
    assertSame(
        actualFindDeviceProfileInfosResult.EMPTY_PAGE_DATA, actualFindDeviceProfileInfosResult);
  }

  /**
   * Test {@link DeviceProfileServiceImpl#setDefaultDeviceProfile(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Given {@link DeviceProfile#DeviceProfile()} Default is {@code true}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#setDefaultDeviceProfile(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DeviceProfileServiceImpl.setDefaultDeviceProfile(TenantId, DeviceProfileId)"
  })
  public void testSetDefaultDeviceProfile_givenDeviceProfileDefaultIsTrue_thenReturnFalse() {
    // Arrange
    DeviceProfile deviceProfile = new DeviceProfile();
    deviceProfile.setDefault(true);
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfile);

    // Act
    boolean actualSetDefaultDeviceProfileResult =
        deviceProfileServiceImpl.setDefaultDeviceProfile(
            ModelConstants.SYSTEM_TENANT,
            new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    assertFalse(actualSetDefaultDeviceProfileResult);
  }

  /**
   * Test {@link DeviceProfileServiceImpl#setDefaultDeviceProfile(TenantId, DeviceProfileId)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#isDefault()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#setDefaultDeviceProfile(TenantId,
   * DeviceProfileId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DeviceProfileServiceImpl.setDefaultDeviceProfile(TenantId, DeviceProfileId)"
  })
  public void testSetDefaultDeviceProfile_thenCallsIsDefault() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.isDefault()).thenReturn(true);
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(deviceProfile);

    // Act
    boolean actualSetDefaultDeviceProfileResult =
        deviceProfileServiceImpl.setDefaultDeviceProfile(
            null, new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(deviceProfile).isDefault();
    verify(deviceProfileDao).findById(isNull(), isA(UUID.class));
    assertFalse(actualSetDefaultDeviceProfileResult);
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfilesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfilesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteDeviceProfilesByTenantId(TenantId)"})
  public void testDeleteDeviceProfilesByTenantId() {
    // Arrange
    PageData<DeviceProfile> emptyPageDataResult = PageData.emptyPageData();
    when(deviceProfileDao.findDeviceProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    deviceProfileServiceImpl.deleteDeviceProfilesByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(deviceProfileDao).findDeviceProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfilesByTenantId(TenantId)}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfilesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteDeviceProfilesByTenantId(TenantId)"})
  public void testDeleteDeviceProfilesByTenantId2() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getId())
        .thenReturn(new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ArrayList<DeviceProfile> data = new ArrayList<>();
    data.add(deviceProfile);
    PageData<DeviceProfile> pageData = new PageData<>(data, 100, 100L, true);

    doThrow(new DataValidationException("An error occurred"))
        .when(deviceProfileDao)
        .removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(deviceProfileDao.findDeviceProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteDeviceProfilesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(deviceProfile).getId();
    verify(deviceProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(deviceProfileDao).findDeviceProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfilesByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfile#getTenantId()}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfilesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteDeviceProfilesByTenantId(TenantId)"})
  public void testDeleteDeviceProfilesByTenantId_thenCallsGetTenantId() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfile.getId())
        .thenReturn(new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ArrayList<DeviceProfile> data = new ArrayList<>();
    data.add(deviceProfile);
    PageData<DeviceProfile> pageData = new PageData<>(data, 100, 100L, true);

    doNothing().when(deviceProfileDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(deviceProfileDao.findDeviceProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(pageData);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            deviceProfileServiceImpl.deleteDeviceProfilesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(deviceProfile).getId();
    verify(deviceProfile).getTenantId();
    verify(deviceProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(deviceProfileDao).findDeviceProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Then calls {@link DeviceProfileDao#findDeviceProfiles(TenantId, PageLink)}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenCallsFindDeviceProfiles() {
    // Arrange
    PageData<DeviceProfile> emptyPageDataResult = PageData.emptyPageData();
    when(deviceProfileDao.findDeviceProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any()))
        .thenReturn(emptyPageDataResult);

    // Act
    deviceProfileServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(deviceProfileDao).findDeviceProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#getEntityType()}.
   *
   * <p>Method under test: {@link DeviceProfileServiceImpl#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType DeviceProfileServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.DEVICE_PROFILE, new DeviceProfileServiceImpl().getEntityType());
  }

  /**
   * Test {@link DeviceProfileServiceImpl#findDeviceProfileNamesByTenantId(TenantId, boolean)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link
   * DeviceProfileServiceImpl#findDeviceProfileNamesByTenantId(TenantId, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "List DeviceProfileServiceImpl.findDeviceProfileNamesByTenantId(TenantId, boolean)"
  })
  public void testFindDeviceProfileNamesByTenantId_thenReturnEmpty() {
    // Arrange
    when(deviceProfileDao.findTenantDeviceProfileNames(Mockito.<UUID>any(), anyBoolean()))
        .thenReturn(new ArrayList<>());

    // Act
    List<EntityInfo> actualFindDeviceProfileNamesByTenantIdResult =
        deviceProfileServiceImpl.findDeviceProfileNamesByTenantId(
            ModelConstants.SYSTEM_TENANT, true);

    // Assert
    verify(deviceProfileDao).findTenantDeviceProfileNames(isA(UUID.class), eq(true));
    assertTrue(actualFindDeviceProfileNamesByTenantIdResult.isEmpty());
  }
}
