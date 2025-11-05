package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.DeviceProfile;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.dao.device.DeviceProfileServiceImpl;
import org.thingsboard.server.dao.resource.BaseImageService;
import org.thingsboard.server.dao.service.validator.ResourceDataValidator;
import org.thingsboard.server.dao.sql.asset.JpaAssetProfileDao;
import org.thingsboard.server.dao.sql.dashboard.JpaDashboardInfoDao;
import org.thingsboard.server.dao.sql.device.JpaDeviceProfileDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceDao;
import org.thingsboard.server.dao.sql.resource.JpaTbResourceInfoDao;
import org.thingsboard.server.dao.sql.resource.TbResourceRepository;
import org.thingsboard.server.dao.sql.widget.JpaWidgetTypeDao;
import org.thingsboard.server.dao.sql.widget.JpaWidgetsBundleDao;
import org.thingsboard.server.service.entitiy.device.profile.DefaultTbDeviceProfileService;

class DeviceProfileControllerDiffblueTest {
  /**
   * Test {@link DeviceProfileController#getDeviceProfileById(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#getDeviceProfileById(String, boolean)}
   */
  @Test
  @DisplayName("Test getDeviceProfileById(String, boolean); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileController.getDeviceProfileById(String, boolean)"})
  void testGetDeviceProfileById_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> deviceProfileController.getDeviceProfileById("42", true));
  }

  /**
   * Test {@link DeviceProfileController#getDeviceProfileById(String, boolean)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#getDeviceProfileById(String, boolean)}
   */
  @Test
  @DisplayName("Test getDeviceProfileById(String, boolean); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileController.getDeviceProfileById(String, boolean)"})
  void testGetDeviceProfileById_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> deviceProfileController.getDeviceProfileById("", true));
  }

  /**
   * Test {@link DeviceProfileController#getDeviceProfileInfoById(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#getDeviceProfileInfoById(String)}
   */
  @Test
  @DisplayName("Test getDeviceProfileInfoById(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfileInfo DeviceProfileController.getDeviceProfileInfoById(String)"})
  void testGetDeviceProfileInfoById_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> deviceProfileController.getDeviceProfileInfoById("42"));
  }

  /**
   * Test {@link DeviceProfileController#getDeviceProfileInfoById(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#getDeviceProfileInfoById(String)}
   */
  @Test
  @DisplayName("Test getDeviceProfileInfoById(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfileInfo DeviceProfileController.getDeviceProfileInfoById(String)"})
  void testGetDeviceProfileInfoById_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> deviceProfileController.getDeviceProfileInfoById(""));
  }

  /**
   * Test {@link DeviceProfileController#getDefaultDeviceProfileInfo()}.
   *
   * <p>Method under test: {@link DeviceProfileController#getDefaultDeviceProfileInfo()}
   */
  @Test
  @DisplayName("Test getDefaultDeviceProfileInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfileInfo DeviceProfileController.getDefaultDeviceProfileInfo()"})
  void testGetDefaultDeviceProfileInfo() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> deviceProfileController.getDefaultDeviceProfileInfo());
  }

  /**
   * Test {@link DeviceProfileController#getTimeseriesKeys(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#getTimeseriesKeys(String)}
   */
  @Test
  @DisplayName("Test getTimeseriesKeys(String); when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List DeviceProfileController.getTimeseriesKeys(String)"})
  void testGetTimeseriesKeys_whenEmptyString_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> deviceProfileController.getTimeseriesKeys(""));
  }

  /**
   * Test {@link DeviceProfileController#getTimeseriesKeys(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#getTimeseriesKeys(String)}
   */
  @Test
  @DisplayName("Test getTimeseriesKeys(String); when 'null'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List DeviceProfileController.getTimeseriesKeys(String)"})
  void testGetTimeseriesKeys_whenNull_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> deviceProfileController.getTimeseriesKeys(null));
  }

  /**
   * Test {@link DeviceProfileController#getAttributesKeys(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#getAttributesKeys(String)}
   */
  @Test
  @DisplayName("Test getAttributesKeys(String); when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List DeviceProfileController.getAttributesKeys(String)"})
  void testGetAttributesKeys_whenEmptyString_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> deviceProfileController.getAttributesKeys(""));
  }

  /**
   * Test {@link DeviceProfileController#getAttributesKeys(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#getAttributesKeys(String)}
   */
  @Test
  @DisplayName("Test getAttributesKeys(String); when 'null'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List DeviceProfileController.getAttributesKeys(String)"})
  void testGetAttributesKeys_whenNull_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> deviceProfileController.getAttributesKeys(null));
  }

  /**
   * Test {@link DeviceProfileController#saveDeviceProfile(DeviceProfile)}.
   *
   * <p>Method under test: {@link DeviceProfileController#saveDeviceProfile(DeviceProfile)}
   */
  @Test
  @DisplayName("Test saveDeviceProfile(DeviceProfile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileController.saveDeviceProfile(DeviceProfile)"})
  void testSaveDeviceProfile() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> deviceProfileController.saveDeviceProfile(new DeviceProfile()));
  }

  /**
   * Test {@link DeviceProfileController#deleteDeviceProfile(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#deleteDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test deleteDeviceProfile(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileController.deleteDeviceProfile(String)"})
  void testDeleteDeviceProfile_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> deviceProfileController.deleteDeviceProfile("42"));
  }

  /**
   * Test {@link DeviceProfileController#deleteDeviceProfile(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#deleteDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test deleteDeviceProfile(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void DeviceProfileController.deleteDeviceProfile(String)"})
  void testDeleteDeviceProfile_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> deviceProfileController.deleteDeviceProfile(""));
  }

  /**
   * Test {@link DeviceProfileController#setDefaultDeviceProfile(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#setDefaultDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test setDefaultDeviceProfile(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileController.setDefaultDeviceProfile(String)"})
  void testSetDefaultDeviceProfile_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> deviceProfileController.setDefaultDeviceProfile("42"));
  }

  /**
   * Test {@link DeviceProfileController#setDefaultDeviceProfile(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#setDefaultDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test setDefaultDeviceProfile(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileController.setDefaultDeviceProfile(String)"})
  void testSetDefaultDeviceProfile_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> deviceProfileController.setDefaultDeviceProfile(""));
  }

  /**
   * Test {@link DeviceProfileController#setDefaultDeviceProfile(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#setDefaultDeviceProfile(String)}
   */
  @Test
  @DisplayName("Test setDefaultDeviceProfile(String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DeviceProfile DeviceProfileController.setDefaultDeviceProfile(String)"})
  void testSetDefaultDeviceProfile_whenNull() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> deviceProfileController.setDefaultDeviceProfile(null));
  }

  /**
   * Test {@link DeviceProfileController#getDeviceProfiles(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#getDeviceProfiles(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getDeviceProfiles(int, int, String, String, String); when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceProfileController.getDeviceProfiles(int, int, String, String, String)"
  })
  void testGetDeviceProfiles_whenEmptyString_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> deviceProfileController.getDeviceProfiles(3, 1, "Text Search", "", "asc"));
  }

  /**
   * Test {@link DeviceProfileController#getDeviceProfiles(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#getDeviceProfiles(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getDeviceProfiles(int, int, String, String, String); when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceProfileController.getDeviceProfiles(int, int, String, String, String)"
  })
  void testGetDeviceProfiles_whenEmptyString_thenThrowThingsboardException2()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> deviceProfileController.getDeviceProfiles(3, 1, "Text Search", "U", ""));
  }

  /**
   * Test {@link DeviceProfileController#getDeviceProfiles(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Sort Property}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#getDeviceProfiles(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getDeviceProfiles(int, int, String, String, String); when 'Sort Property'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceProfileController.getDeviceProfiles(int, int, String, String, String)"
  })
  void testGetDeviceProfiles_whenSortProperty_thenThrowIllegalArgumentException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            deviceProfileController.getDeviceProfiles(3, 1, "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link DeviceProfileController#getDeviceProfiles(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#getDeviceProfiles(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getDeviceProfiles(int, int, String, String, String); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceProfileController.getDeviceProfiles(int, int, String, String, String)"
  })
  void testGetDeviceProfiles_whenU_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> deviceProfileController.getDeviceProfiles(3, 1, "Text Search", "U", "asc"));
  }

  /**
   * Test {@link DeviceProfileController#getDeviceProfiles(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#getDeviceProfiles(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getDeviceProfiles(int, int, String, String, String); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceProfileController.getDeviceProfiles(int, int, String, String, String)"
  })
  void testGetDeviceProfiles_whenU_thenThrowThingsboardException2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> deviceProfileController.getDeviceProfiles(3, 1, "Text Search", "U", "U"));
  }

  /**
   * Test {@link DeviceProfileController#getDeviceProfileInfos(int, int, String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#getDeviceProfileInfos(int, int, String,
   * String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getDeviceProfileInfos(int, int, String, String, String, String); when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceProfileController.getDeviceProfileInfos(int, int, String, String, String, String)"
  })
  void testGetDeviceProfileInfos_whenEmptyString_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            deviceProfileController.getDeviceProfileInfos(
                3, 1, "Text Search", "", "asc", "Transport Type"));
  }

  /**
   * Test {@link DeviceProfileController#getDeviceProfileInfos(int, int, String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#getDeviceProfileInfos(int, int, String,
   * String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getDeviceProfileInfos(int, int, String, String, String, String); when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceProfileController.getDeviceProfileInfos(int, int, String, String, String, String)"
  })
  void testGetDeviceProfileInfos_whenEmptyString_thenThrowThingsboardException2()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            deviceProfileController.getDeviceProfileInfos(
                3, 1, "Text Search", "U", "", "Transport Type"));
  }

  /**
   * Test {@link DeviceProfileController#getDeviceProfileInfos(int, int, String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code Sort Property}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#getDeviceProfileInfos(int, int, String,
   * String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getDeviceProfileInfos(int, int, String, String, String, String); when 'Sort Property'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceProfileController.getDeviceProfileInfos(int, int, String, String, String, String)"
  })
  void testGetDeviceProfileInfos_whenSortProperty_thenThrowIllegalArgumentException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            deviceProfileController.getDeviceProfileInfos(
                3, 1, "Text Search", "Sort Property", "asc", "Transport Type"));
  }

  /**
   * Test {@link DeviceProfileController#getDeviceProfileInfos(int, int, String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#getDeviceProfileInfos(int, int, String,
   * String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getDeviceProfileInfos(int, int, String, String, String, String); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceProfileController.getDeviceProfileInfos(int, int, String, String, String, String)"
  })
  void testGetDeviceProfileInfos_whenU_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            deviceProfileController.getDeviceProfileInfos(
                3, 1, "Text Search", "U", "asc", "Transport Type"));
  }

  /**
   * Test {@link DeviceProfileController#getDeviceProfileInfos(int, int, String, String, String,
   * String)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link DeviceProfileController#getDeviceProfileInfos(int, int, String,
   * String, String, String)}
   */
  @Test
  @DisplayName(
      "Test getDeviceProfileInfos(int, int, String, String, String, String); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData DeviceProfileController.getDeviceProfileInfos(int, int, String, String, String, String)"
  })
  void testGetDeviceProfileInfos_whenU_thenThrowThingsboardException2()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () ->
            deviceProfileController.getDeviceProfileInfos(
                3, 1, "Text Search", "U", "U", "Transport Type"));
  }

  /**
   * Test {@link DeviceProfileController#getDeviceProfileNames(boolean)}.
   *
   * <p>Method under test: {@link DeviceProfileController#getDeviceProfileNames(boolean)}
   */
  @Test
  @DisplayName("Test getDeviceProfileNames(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List DeviceProfileController.getDeviceProfileNames(boolean)"})
  void testGetDeviceProfileNames() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbDeviceProfileService tbDeviceProfileService =
        new DefaultTbDeviceProfileService(new DeviceProfileServiceImpl());
    JpaTbResourceDao resourceDao = new JpaTbResourceDao(mock(TbResourceRepository.class));
    JpaTbResourceInfoDao resourceInfoDao = new JpaTbResourceInfoDao();
    ResourceDataValidator resourceValidator = new ResourceDataValidator();
    JpaAssetProfileDao assetProfileDao = new JpaAssetProfileDao();
    JpaDeviceProfileDao deviceProfileDao = new JpaDeviceProfileDao();
    JpaWidgetsBundleDao widgetsBundleDao = new JpaWidgetsBundleDao();
    JpaWidgetTypeDao widgetTypeDao = new JpaWidgetTypeDao();

    BaseImageService imageService =
        new BaseImageService(
            resourceDao,
            resourceInfoDao,
            resourceValidator,
            assetProfileDao,
            deviceProfileDao,
            widgetsBundleDao,
            widgetTypeDao,
            new JpaDashboardInfoDao());

    DeviceProfileController deviceProfileController =
        new DeviceProfileController(tbDeviceProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> deviceProfileController.getDeviceProfileNames(true));
  }
}
