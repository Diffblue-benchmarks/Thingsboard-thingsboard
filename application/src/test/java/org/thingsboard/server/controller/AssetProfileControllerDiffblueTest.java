package org.thingsboard.server.controller;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.dao.asset.AssetProfileServiceImpl;
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
import org.thingsboard.server.service.entitiy.asset.profile.DefaultTbAssetProfileService;

class AssetProfileControllerDiffblueTest {
  /**
   * Test {@link AssetProfileController#getAssetProfileById(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileController#getAssetProfileById(String, boolean)}
   */
  @Test
  @DisplayName("Test getAssetProfileById(String, boolean); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile AssetProfileController.getAssetProfileById(String, boolean)"})
  void testGetAssetProfileById_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAssetProfileService tbAssetProfileService =
        new DefaultTbAssetProfileService(new AssetProfileServiceImpl());
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

    AssetProfileController assetProfileController =
        new AssetProfileController(tbAssetProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> assetProfileController.getAssetProfileById("42", true));
  }

  /**
   * Test {@link AssetProfileController#getAssetProfileById(String, boolean)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileController#getAssetProfileById(String, boolean)}
   */
  @Test
  @DisplayName("Test getAssetProfileById(String, boolean); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile AssetProfileController.getAssetProfileById(String, boolean)"})
  void testGetAssetProfileById_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAssetProfileService tbAssetProfileService =
        new DefaultTbAssetProfileService(new AssetProfileServiceImpl());
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

    AssetProfileController assetProfileController =
        new AssetProfileController(tbAssetProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> assetProfileController.getAssetProfileById("", true));
  }

  /**
   * Test {@link AssetProfileController#getAssetProfileInfoById(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileController#getAssetProfileInfoById(String)}
   */
  @Test
  @DisplayName("Test getAssetProfileInfoById(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfileInfo AssetProfileController.getAssetProfileInfoById(String)"})
  void testGetAssetProfileInfoById_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAssetProfileService tbAssetProfileService =
        new DefaultTbAssetProfileService(new AssetProfileServiceImpl());
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

    AssetProfileController assetProfileController =
        new AssetProfileController(tbAssetProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> assetProfileController.getAssetProfileInfoById("42"));
  }

  /**
   * Test {@link AssetProfileController#getAssetProfileInfoById(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileController#getAssetProfileInfoById(String)}
   */
  @Test
  @DisplayName("Test getAssetProfileInfoById(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfileInfo AssetProfileController.getAssetProfileInfoById(String)"})
  void testGetAssetProfileInfoById_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAssetProfileService tbAssetProfileService =
        new DefaultTbAssetProfileService(new AssetProfileServiceImpl());
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

    AssetProfileController assetProfileController =
        new AssetProfileController(tbAssetProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> assetProfileController.getAssetProfileInfoById(""));
  }

  /**
   * Test {@link AssetProfileController#getDefaultAssetProfileInfo()}.
   *
   * <p>Method under test: {@link AssetProfileController#getDefaultAssetProfileInfo()}
   */
  @Test
  @DisplayName("Test getDefaultAssetProfileInfo()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfileInfo AssetProfileController.getDefaultAssetProfileInfo()"})
  void testGetDefaultAssetProfileInfo() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAssetProfileService tbAssetProfileService =
        new DefaultTbAssetProfileService(new AssetProfileServiceImpl());
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

    AssetProfileController assetProfileController =
        new AssetProfileController(tbAssetProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> assetProfileController.getDefaultAssetProfileInfo());
  }

  /**
   * Test {@link AssetProfileController#saveAssetProfile(AssetProfile)}.
   *
   * <p>Method under test: {@link AssetProfileController#saveAssetProfile(AssetProfile)}
   */
  @Test
  @DisplayName("Test saveAssetProfile(AssetProfile)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile AssetProfileController.saveAssetProfile(AssetProfile)"})
  void testSaveAssetProfile() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAssetProfileService tbAssetProfileService =
        new DefaultTbAssetProfileService(new AssetProfileServiceImpl());
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

    AssetProfileController assetProfileController =
        new AssetProfileController(tbAssetProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> assetProfileController.saveAssetProfile(new AssetProfile()));
  }

  /**
   * Test {@link AssetProfileController#deleteAssetProfile(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileController#deleteAssetProfile(String)}
   */
  @Test
  @DisplayName("Test deleteAssetProfile(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileController.deleteAssetProfile(String)"})
  void testDeleteAssetProfile_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAssetProfileService tbAssetProfileService =
        new DefaultTbAssetProfileService(new AssetProfileServiceImpl());
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

    AssetProfileController assetProfileController =
        new AssetProfileController(tbAssetProfileService, imageService);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> assetProfileController.deleteAssetProfile("42"));
  }

  /**
   * Test {@link AssetProfileController#deleteAssetProfile(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileController#deleteAssetProfile(String)}
   */
  @Test
  @DisplayName("Test deleteAssetProfile(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void AssetProfileController.deleteAssetProfile(String)"})
  void testDeleteAssetProfile_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAssetProfileService tbAssetProfileService =
        new DefaultTbAssetProfileService(new AssetProfileServiceImpl());
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

    AssetProfileController assetProfileController =
        new AssetProfileController(tbAssetProfileService, imageService);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> assetProfileController.deleteAssetProfile(""));
  }

  /**
   * Test {@link AssetProfileController#setDefaultAssetProfile(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileController#setDefaultAssetProfile(String)}
   */
  @Test
  @DisplayName("Test setDefaultAssetProfile(String); when '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile AssetProfileController.setDefaultAssetProfile(String)"})
  void testSetDefaultAssetProfile_when42() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAssetProfileService tbAssetProfileService =
        new DefaultTbAssetProfileService(new AssetProfileServiceImpl());
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

    AssetProfileController assetProfileController =
        new AssetProfileController(tbAssetProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> assetProfileController.setDefaultAssetProfile("42"));
  }

  /**
   * Test {@link AssetProfileController#setDefaultAssetProfile(String)}.
   *
   * <ul>
   *   <li>When empty string.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileController#setDefaultAssetProfile(String)}
   */
  @Test
  @DisplayName("Test setDefaultAssetProfile(String); when empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile AssetProfileController.setDefaultAssetProfile(String)"})
  void testSetDefaultAssetProfile_whenEmptyString() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAssetProfileService tbAssetProfileService =
        new DefaultTbAssetProfileService(new AssetProfileServiceImpl());
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

    AssetProfileController assetProfileController =
        new AssetProfileController(tbAssetProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> assetProfileController.setDefaultAssetProfile(""));
  }

  /**
   * Test {@link AssetProfileController#setDefaultAssetProfile(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileController#setDefaultAssetProfile(String)}
   */
  @Test
  @DisplayName("Test setDefaultAssetProfile(String); when 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"AssetProfile AssetProfileController.setDefaultAssetProfile(String)"})
  void testSetDefaultAssetProfile_whenNull() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAssetProfileService tbAssetProfileService =
        new DefaultTbAssetProfileService(new AssetProfileServiceImpl());
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

    AssetProfileController assetProfileController =
        new AssetProfileController(tbAssetProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> assetProfileController.setDefaultAssetProfile(null));
  }

  /**
   * Test {@link AssetProfileController#getAssetProfiles(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileController#getAssetProfiles(int, int, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getAssetProfiles(int, int, String, String, String); when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetProfileController.getAssetProfiles(int, int, String, String, String)"
  })
  void testGetAssetProfiles_whenEmptyString_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAssetProfileService tbAssetProfileService =
        new DefaultTbAssetProfileService(new AssetProfileServiceImpl());
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

    AssetProfileController assetProfileController =
        new AssetProfileController(tbAssetProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> assetProfileController.getAssetProfiles(3, 1, "Text Search", "", "asc"));
  }

  /**
   * Test {@link AssetProfileController#getAssetProfiles(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileController#getAssetProfiles(int, int, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getAssetProfiles(int, int, String, String, String); when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetProfileController.getAssetProfiles(int, int, String, String, String)"
  })
  void testGetAssetProfiles_whenEmptyString_thenThrowThingsboardException2()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAssetProfileService tbAssetProfileService =
        new DefaultTbAssetProfileService(new AssetProfileServiceImpl());
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

    AssetProfileController assetProfileController =
        new AssetProfileController(tbAssetProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> assetProfileController.getAssetProfiles(3, 1, "Text Search", "U", ""));
  }

  /**
   * Test {@link AssetProfileController#getAssetProfiles(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Sort Property}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileController#getAssetProfiles(int, int, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getAssetProfiles(int, int, String, String, String); when 'Sort Property'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetProfileController.getAssetProfiles(int, int, String, String, String)"
  })
  void testGetAssetProfiles_whenSortProperty_thenThrowIllegalArgumentException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAssetProfileService tbAssetProfileService =
        new DefaultTbAssetProfileService(new AssetProfileServiceImpl());
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

    AssetProfileController assetProfileController =
        new AssetProfileController(tbAssetProfileService, imageService);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> assetProfileController.getAssetProfiles(3, 1, "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link AssetProfileController#getAssetProfiles(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileController#getAssetProfiles(int, int, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getAssetProfiles(int, int, String, String, String); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetProfileController.getAssetProfiles(int, int, String, String, String)"
  })
  void testGetAssetProfiles_whenU_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAssetProfileService tbAssetProfileService =
        new DefaultTbAssetProfileService(new AssetProfileServiceImpl());
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

    AssetProfileController assetProfileController =
        new AssetProfileController(tbAssetProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> assetProfileController.getAssetProfiles(3, 1, "Text Search", "U", "asc"));
  }

  /**
   * Test {@link AssetProfileController#getAssetProfiles(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileController#getAssetProfiles(int, int, String, String,
   * String)}
   */
  @Test
  @DisplayName(
      "Test getAssetProfiles(int, int, String, String, String); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetProfileController.getAssetProfiles(int, int, String, String, String)"
  })
  void testGetAssetProfiles_whenU_thenThrowThingsboardException2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAssetProfileService tbAssetProfileService =
        new DefaultTbAssetProfileService(new AssetProfileServiceImpl());
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

    AssetProfileController assetProfileController =
        new AssetProfileController(tbAssetProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> assetProfileController.getAssetProfiles(3, 1, "Text Search", "U", "U"));
  }

  /**
   * Test {@link AssetProfileController#getAssetProfileInfos(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileController#getAssetProfileInfos(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getAssetProfileInfos(int, int, String, String, String); when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetProfileController.getAssetProfileInfos(int, int, String, String, String)"
  })
  void testGetAssetProfileInfos_whenEmptyString_thenThrowThingsboardException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAssetProfileService tbAssetProfileService =
        new DefaultTbAssetProfileService(new AssetProfileServiceImpl());
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

    AssetProfileController assetProfileController =
        new AssetProfileController(tbAssetProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> assetProfileController.getAssetProfileInfos(3, 1, "Text Search", "", "asc"));
  }

  /**
   * Test {@link AssetProfileController#getAssetProfileInfos(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileController#getAssetProfileInfos(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getAssetProfileInfos(int, int, String, String, String); when empty string; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetProfileController.getAssetProfileInfos(int, int, String, String, String)"
  })
  void testGetAssetProfileInfos_whenEmptyString_thenThrowThingsboardException2()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAssetProfileService tbAssetProfileService =
        new DefaultTbAssetProfileService(new AssetProfileServiceImpl());
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

    AssetProfileController assetProfileController =
        new AssetProfileController(tbAssetProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> assetProfileController.getAssetProfileInfos(3, 1, "Text Search", "U", ""));
  }

  /**
   * Test {@link AssetProfileController#getAssetProfileInfos(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code Sort Property}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileController#getAssetProfileInfos(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getAssetProfileInfos(int, int, String, String, String); when 'Sort Property'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetProfileController.getAssetProfileInfos(int, int, String, String, String)"
  })
  void testGetAssetProfileInfos_whenSortProperty_thenThrowIllegalArgumentException()
      throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAssetProfileService tbAssetProfileService =
        new DefaultTbAssetProfileService(new AssetProfileServiceImpl());
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

    AssetProfileController assetProfileController =
        new AssetProfileController(tbAssetProfileService, imageService);

    // Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            assetProfileController.getAssetProfileInfos(
                3, 1, "Text Search", "Sort Property", "asc"));
  }

  /**
   * Test {@link AssetProfileController#getAssetProfileInfos(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileController#getAssetProfileInfos(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getAssetProfileInfos(int, int, String, String, String); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetProfileController.getAssetProfileInfos(int, int, String, String, String)"
  })
  void testGetAssetProfileInfos_whenU_thenThrowThingsboardException() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAssetProfileService tbAssetProfileService =
        new DefaultTbAssetProfileService(new AssetProfileServiceImpl());
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

    AssetProfileController assetProfileController =
        new AssetProfileController(tbAssetProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> assetProfileController.getAssetProfileInfos(3, 1, "Text Search", "U", "asc"));
  }

  /**
   * Test {@link AssetProfileController#getAssetProfileInfos(int, int, String, String, String)}.
   *
   * <ul>
   *   <li>When {@code U}.
   *   <li>Then throw {@link ThingsboardException}.
   * </ul>
   *
   * <p>Method under test: {@link AssetProfileController#getAssetProfileInfos(int, int, String,
   * String, String)}
   */
  @Test
  @DisplayName(
      "Test getAssetProfileInfos(int, int, String, String, String); when 'U'; then throw ThingsboardException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "org.thingsboard.server.common.data.page.PageData AssetProfileController.getAssetProfileInfos(int, int, String, String, String)"
  })
  void testGetAssetProfileInfos_whenU_thenThrowThingsboardException2() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAssetProfileService tbAssetProfileService =
        new DefaultTbAssetProfileService(new AssetProfileServiceImpl());
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

    AssetProfileController assetProfileController =
        new AssetProfileController(tbAssetProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class,
        () -> assetProfileController.getAssetProfileInfos(3, 1, "Text Search", "U", "U"));
  }

  /**
   * Test {@link AssetProfileController#getAssetProfileNames(boolean)}.
   *
   * <p>Method under test: {@link AssetProfileController#getAssetProfileNames(boolean)}
   */
  @Test
  @DisplayName("Test getAssetProfileNames(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.util.List AssetProfileController.getAssetProfileNames(boolean)"})
  void testGetAssetProfileNames() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.
    //   Run dcover create --keep-partial-tests to gain insights into why
    //   a non-Spring test was created.

    // Arrange
    DefaultTbAssetProfileService tbAssetProfileService =
        new DefaultTbAssetProfileService(new AssetProfileServiceImpl());
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

    AssetProfileController assetProfileController =
        new AssetProfileController(tbAssetProfileService, imageService);

    // Act and Assert
    assertThrows(
        ThingsboardException.class, () -> assetProfileController.getAssetProfileNames(true));
  }
}
