package org.thingsboard.server.dao.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.DeviceProfileId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.dao.Dao;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;

@RunWith(MockitoJUnitRunner.class)
public class DeviceProfileServiceImplDiffblueTest {
  @Mock
  private DeviceProfileDao deviceProfileDao;

  @InjectMocks
  private DeviceProfileServiceImpl deviceProfileServiceImpl;

  /**
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId, DeviceProfileId)}.
   * <ul>
   *   <li>Given {@link DeviceProfileDao} {@link Dao#findById(TenantId, UUID)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId, DeviceProfileId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteDeviceProfile(TenantId, DeviceProfileId)"})
  public void testDeleteDeviceProfile_givenDeviceProfileDaoFindByIdReturnNull() {
    // Arrange
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);

    // Act
    deviceProfileServiceImpl.deleteDeviceProfile(ModelConstants.SYSTEM_TENANT,
        new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId, DeviceProfileId)}.
   * <ul>
   *   <li>Given {@link DeviceProfile} {@link DeviceProfile#isDefault()} return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId, DeviceProfileId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteDeviceProfile(TenantId, DeviceProfileId)"})
  public void testDeleteDeviceProfile_givenDeviceProfileIsDefaultReturnTrue() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.isDefault()).thenReturn(true);
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(deviceProfile);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileServiceImpl.deleteDeviceProfile(ModelConstants.SYSTEM_TENANT,
            new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(deviceProfile).isDefault();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId, DeviceProfileId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfile(TenantId, DeviceProfileId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteDeviceProfile(TenantId, DeviceProfileId)"})
  public void testDeleteDeviceProfile_thenThrowDataValidationException() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.isDefault()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(deviceProfile);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileServiceImpl.deleteDeviceProfile(ModelConstants.SYSTEM_TENANT,
            new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))));
    verify(deviceProfile).isDefault();
    verify(deviceProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteDeviceProfilesByTenantId(TenantId)}.
   * <p>
   * Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfilesByTenantId(TenantId)}
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
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileServiceImpl#deleteDeviceProfilesByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteDeviceProfilesByTenantId(TenantId)"})
  public void testDeleteDeviceProfilesByTenantId_thenThrowDataValidationException() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfile.getId())
        .thenReturn(new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ArrayList<DeviceProfile> data = new ArrayList<>();
    data.add(deviceProfile);
    PageData<DeviceProfile> pageData = new PageData<>(data, 100, 100L, true);

    doNothing().when(deviceProfileDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(deviceProfileDao.findDeviceProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(pageData);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileServiceImpl.deleteDeviceProfilesByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(deviceProfile).getId();
    verify(deviceProfile).getTenantId();
    verify(deviceProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(deviceProfileDao).findDeviceProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link DeviceProfileDao} {@link DeviceProfileDao#findDeviceProfiles(TenantId, PageLink)} return emptyPageData.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenDeviceProfileDaoFindDeviceProfilesReturnEmptyPageData() {
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
   * Test {@link DeviceProfileServiceImpl#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeviceProfileServiceImpl#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeviceProfileServiceImpl.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenThrowDataValidationException() {
    // Arrange
    DeviceProfile deviceProfile = mock(DeviceProfile.class);
    when(deviceProfile.getTenantId()).thenThrow(new DataValidationException("An error occurred"));
    when(deviceProfile.getId())
        .thenReturn(new DeviceProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    ArrayList<DeviceProfile> data = new ArrayList<>();
    data.add(deviceProfile);
    PageData<DeviceProfile> pageData = new PageData<>(data, 100, 100L, true);

    doNothing().when(deviceProfileDao).removeById(Mockito.<TenantId>any(), Mockito.<UUID>any());
    when(deviceProfileDao.findDeviceProfiles(Mockito.<TenantId>any(), Mockito.<PageLink>any())).thenReturn(pageData);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> deviceProfileServiceImpl.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(deviceProfile).getId();
    verify(deviceProfile).getTenantId();
    verify(deviceProfileDao).removeById(isA(TenantId.class), isA(UUID.class));
    verify(deviceProfileDao).findDeviceProfiles(isA(TenantId.class), isA(PageLink.class));
  }

  /**
   * Test {@link DeviceProfileServiceImpl#getEntityType()}.
   * <p>
   * Method under test: {@link DeviceProfileServiceImpl#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType DeviceProfileServiceImpl.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.DEVICE_PROFILE, (new DeviceProfileServiceImpl()).getEntityType());
  }
}
